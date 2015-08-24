package register;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.List;

public class FileRegisterLoader implements RegisterLoader {
	
	private File f;
	private String kindOfRegister;
	
	public FileRegisterLoader() throws ClassNotFoundException, IOException{
		initializite();
		System.out.println("Chces 1.pole alebo 2.kolekciu?");
		String choice = "2";
		switch(choice){
		case "1": Register register = isExist("class register.ListRegister"); fillRegister(register); kindOfRegister = "List";break;
		case "2": Register register2 = isExist("class register.ArrayRegister");fillRegister(register2);kindOfRegister = "Array"; break;
		}
	}

	private void initializite(){
		f = new File("register.bin");
	}
	
	private Register isExist(String registerName) throws ClassNotFoundException, IOException{
		ObjectInputStream oiReader = new ObjectInputStream(new FileInputStream("register.bin"));
		Object myReadObject = oiReader.readObject();
		System.out.println(registerName.equals(myReadObject.getClass().toString()));
		System.out.println(myReadObject.getClass().toString());
		
		if(!registerName.equals(myReadObject.getClass().toString()) && registerName.equals("class register.ListRegister")){
			return new ListRegister();
		} else if(!registerName.equals(myReadObject.getClass().toString()) && registerName.equals("class register.ArrayRegister")){
		    return new ArrayRegister(20);
		} else {
			return (Register)myReadObject;
		}
	}
	
	private void fillRegister(Register register) throws IOException{
		register.addPerson(new Person("Fi3lfsdcxyip Filarsky", "09001213456")); 
		register.addPerson(new Person("Fil4sdc&xaip Filarsky", "0900122123452"));
		register.addPerson(new Person("Vlads6aimXCir Filarsky", "09004123451"));
		register.addPerson(new Person("Filisa1p FiVXCVlarsky","09001123456")); 
		save(register);
	}
	
	/* (non-Javadoc)
	 * @see register.RegisterLoader#save(register.Register)
	 */
	@Override
	public void save(Register register) throws IOException{
		 File file = new File("register.bin");
	     FileOutputStream fOutputStream = new FileOutputStream(file);
	     ObjectOutputStream oOutputStream = new ObjectOutputStream(fOutputStream);
	     oOutputStream.writeObject(register);
	     oOutputStream.close();  
	}
	
	/* (non-Javadoc)
	 * @see register.RegisterLoader#load()
	 */
	@Override
	public Register load() throws ClassNotFoundException, IOException{ 
		try (FileInputStream fInputStream = new FileInputStream("register.bin");
				ObjectInputStream oInputStream = new ObjectInputStream(fInputStream);) {
			if (kindOfRegister.equals("List")) {
				Register register = (ListRegister) oInputStream.readObject();
				return register;
			} else {
				Register register = (ArrayRegister) oInputStream.readObject();
				return register;
			}
		}
	}
}
