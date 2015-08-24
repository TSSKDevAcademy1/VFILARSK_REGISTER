package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;

/**
 * User interface of the application.
 */
public class ConsoleUI {
    /** register.Register of persons. */
    private Register register;
    private RegisterLoader registerLoader;
  
    
    /**
     * In JDK 6 use Console class instead.
     * @see readLine()
     */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Menu options.
     */
    private enum Option {
        PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
    };
    /**
     * 
     * @param registerLoader registerLoader for loading list from file/database
     */
    public ConsoleUI(RegisterLoader registerLoader){
    	this.registerLoader = registerLoader;
        try {
			this.register = registerLoader.load();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void run() throws IOException {
        while (true) {
            switch (showMenu()) {
                case PRINT:
                    printRegister();
                    break;
                case ADD:
                    addToRegister();
                    break;
                case UPDATE:
                    updateRegister();
                    break;
                case REMOVE:
                    removeFromRegister();
                    break;
                case FIND:
                    findInRegister();
                    break;
                case EXIT: registerLoader.save(register);
                    return;
            }
        }
    }
    
    private String readLine() {
        //In JDK 6.0 and above Console class can be used
        //return System.console().readLine();
        
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    private Option showMenu() {
        System.out.println("Menu.");
        for (Option option : Option.values()) {
            System.out.printf("%d. %s%n", option.ordinal() + 1, option);
        }
        System.out.println("-----------------------------------------------");
        
        int selection = -1;
        do {
            System.out.println("Option: ");
            selection = Integer.parseInt(readLine());
        } while (selection <= 0 || selection > Option.values().length);
        
        return Option.values()[selection - 1];
    }
    
    //TODO: Implement the method printRegister
    private void printRegister() {
    	register.vypis();
    }
    
    private void addToRegister() throws IOException {
    	System.out.println("Napis meno a priezvisko");
        String name = readLine();
        System.out.println("Napis telefonne cislo");
        String number = readLine();
        register.addPerson(new Person(name,number));
        registerLoader.save(register);
    }
    
    //TODO: Implement the method updateRegister
    private void updateRegister() {
        System.out.println("Index menenej osoby");
        int index = Integer.parseInt(readLine());
        System.out.println("Napis meno a priezvisko");
        String name = readLine();
        System.out.println("Napis telefonne cislo");
        String number = readLine();
        register.getPerson(index-1).setName(name);
        register.getPerson(index-1).setPhoneNumber(number);
    }
    
    //TODO: Implement the method findInRegister
    private void findInRegister() {
        System.out.println("1.Podla mena");
        System.out.println("2.Podla cisla");
        Integer choice = Integer.parseInt(readLine());
        switch(choice){
        	case 1 :System.out.println("Zadaj meno");
        		String name = readLine();
        		System.out.println(register.findPersonByName(name)); 
        		break;
        	case 2 : System.out.println("Zadaj cislo");
        		String number = readLine();
        		System.out.println(register.findPersonByPhoneNumber(number));
        		break;
        }
    }
    
    private void removeFromRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = register.getPerson(index - 1);
        register.removePerson(person);
    }
    
   
    

}
