package register;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Vlado.
 */
public class Main {
	
	private BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
	private RegisterLoader regLoader;
	private ConsoleUI ui;
	/**
	 * Provides choice of register or file for storing and create object for loading selected type. Create object of class
	 * ConsoleUI and call method run() on this object.
	 */
	public void init(){
		System.out.println("Vyber si druh ulozenia registra. \n 1.Databáza \n 2.Súbor");
		String i;
		try {
			i = bReader.readLine();
			switch(i){
			case "1" : regLoader = new DatabaseRegisterLoader();break;
			case "2" : regLoader = new SuperRegisterLoader();break;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ui = new ConsoleUI(regLoader);
		try {
			ui.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Create object of class Main
	 * @param args
	 */
	public static void main(String[] args) {
		Main main1 = new Main();
		main1.init();
	}
}
