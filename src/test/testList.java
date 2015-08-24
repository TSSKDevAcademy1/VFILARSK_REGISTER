package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import register.ListRegister;
import register.Person;

public class testList {

	ListRegister register = new ListRegister();
	Person vlado = new Person("Vlado","159");
	Person peter = new Person("Peter","91");
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

	public void createRegister() {
		assertEquals(register.getCount(),0);
		assertEquals(register.getSize(),20);
	}
	
	@Test
	public void addPerson() {
		register.addPerson(vlado);
		register.addPerson(peter);
		assertEquals(register.getPerson(0),vlado);
		assertEquals(register.getPerson(1),peter);
	}
	
	@Test
	public void findPersonByName() {
		register.addPerson(vlado);
		register.addPerson(peter);
		assertEquals(register.findPersonByName("Vlado"),vlado);
	}
	
	@Test
	public void findPersonByPhoneNumber() {
		register.addPerson(vlado);
		register.addPerson(peter);
		assertEquals(register.findPersonByPhoneNumber("91"),peter);
	}
	
	@Test
	public void removePerson() {
		register.addPerson(vlado);
		register.addPerson(peter);
		register.removePerson(vlado);
		assertFalse(register.findPersonByName("Vlado") instanceof Object);
	}
	
}
