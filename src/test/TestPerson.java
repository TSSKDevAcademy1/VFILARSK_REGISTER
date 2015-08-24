package test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import register.Person;

public class TestPerson {

	Person person = new Person("Vlado","05095");
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}
	
	public void getName(){
		
		assertEquals(person.getName(),"Vlado");
	}
	
	public void setName(){
		
		person.setName("Filip");
		assertEquals(person.getPhoneNumber(),"Filip");
	}
	
	@Test
	public void createPerson(){
		assertEquals(person.getName(),"Vlado");
		assertEquals(person.getPhoneNumber(),"05095");
	}

	public void getPhoneNumberr(){
		
		person.setPhoneNumber("0000");
		assertEquals(person.getPhoneNumber(),"0000");
	}
	
	@Test
	public void setPhoneNumber(){
		
		person.setPhoneNumber("0000");
		assertEquals(person.getPhoneNumber(),"0000");
	}
	
	@Test
	public void isValidPhoneNUmber(){
		person.setPhoneNumber("54654");
	}
	
	@Test
	public void compareTo(){
		Person person = new Person("Jan","050");
		Person person2 = new Person("Duro","050925");
		Person person3 = new Person("Duro","050925");
		assertTrue(person.getName().compareTo(person2.getName()) > 0);
		assertTrue(person2.getName().compareTo(person.getName()) < 0);
		assertTrue(person2.getName().compareTo(person3.getName()) == 0);
	}
}
