package register;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SuperRegisterLoader implements RegisterLoader {

	@Override
	public void save(Register register) throws IOException {
		try(FileWriter fWriter = new FileWriter("dvojzoznam.txt")){
			for(int i =0; i< register.getCount();i++){
				fWriter.write(register.getPerson(i).getName() + "\n" + register.getPerson(i).getPhoneNumber()+ "\n");
			}
		}
	}

	@Override
	public Register load() throws ClassNotFoundException, IOException {
		// FileReader fReader = new FileReader("dvojzoznam.txt");
		try (BufferedReader buffReader = new BufferedReader(new FileReader("dvojzoznam.txt"))) {
			String line;
			int i = 1;
			Register register = new ListRegister();
			String name = "";
			while ((line = buffReader.readLine()) != null) {
				if ((i % 2) != 0) {
					name = line;
					System.out.println("Meno nastavujem na: " + name);
					i++;
				} else {
					System.out.println("Cislo nastavujem na: " + line);
					register.addPerson(new Person(name, line));
					i++;
				}
			}
			return register;
		}
	}
}
