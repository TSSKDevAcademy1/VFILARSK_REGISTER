package register;

import java.io.Serializable;
import java.util.Collections;
import java.util.Formatter;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register,Serializable {
    /** register.Person array. */
    private Person[] persons;
    
    /** Number of persons in this register. */
    private int count;
    
    /**
     * Constructor creates an empty register with maximum size specified.
     * @param size maximum size of the register
     */
    public ArrayRegister(int size) {
        persons = new Person[size];
        count = 0;
    }
    
    /* (non-Javadoc)
	 * @see register.Register#getCount()
	 */
    @Override
	public int getCount() {
        return count;
    }
    
    /* (non-Javadoc)
	 * @see register.Register#getSize()
	 */
    @Override
	public int getSize() {
        return persons.length;
    }
    
    /* (non-Javadoc)
	 * @see register.Register#getPerson(int)
	 */
    @Override
	public Person getPerson(int index) {
        return persons[index];
    }

    /* (non-Javadoc)
	 * @see register.Register#addPerson(register.Person)
	 */
    @Override
	public void addPerson(Person person) {
    	if(!(this.findPersonByName(person.getName()) instanceof Object) && !(this.findPersonByPhoneNumber(person.getPhoneNumber()) instanceof Object)){
	        persons[count] = person;
	        count++;
    	}
    }       
    
    //TODO: Implement the method findPersonByName
    /* (non-Javadoc)
	 * @see register.Register#findPersonByName(java.lang.String)
	 */
    @Override
	public Person findPersonByName(String name) {
    	for(int i = 0; i < this.getActual();i++){
        	if(persons[i].getName().equals(name)){
        		return persons[i];
        	} 
        }
		return null; 
    }
    
    //TODO: Implement the method findPersonByPhoneNumber
    /* (non-Javadoc)
	 * @see register.Register#findPersonByPhoneNumber(java.lang.String)
	 */
    @Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
        for(int i = 0; i < this.getActual();i++){
        	if(persons[i].getPhoneNumber().equals(phoneNumber)){
        		return persons[i];
        	} 
        }
		return null; 
    }
    
    //TODO: Implement the method removePerson
    /* (non-Javadoc)
	 * @see register.Register#getActual()
	 */
    
    @Override
	public int getActual(){
    	int i = 0;
    	while(this.persons[i] instanceof Person){
    		i++;
    	}
    	return i;
    }
    
    /* (non-Javadoc)
	 * @see register.Register#removePerson(register.Person)
	 */
    @Override
	public void removePerson(Person person) {
    	for(int i = 0; i < 20;i++){
    		if(persons[i] == null){
    			return;
    		} else {
    			if(persons[i].equals(person)){
    				persons[i] = null;
    				count--;
    				while(i< count){
    					persons[i] = persons[i+1];
    					i++;
    				}
    				if(i == this.getCount()-1){
    				persons[this.getCount()-1] = null;
    				count--;
    				}
    			}
    		}
    	}
    	
    }
    
    public void vypis(){
    	int length = this.getCount();
    	Formatter f = new Formatter();
    	System.out.println(length);
    	for(int i = 0;i< length;i++){
        	f.format("%d  %s %s \n",i+1,this.getPerson(i).getName(), this.getPerson(i).getPhoneNumber());
    }
        	System.out.println(f.toString());
        	f.close();
    }
}
