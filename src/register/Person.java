package register;

import java.io.Serializable;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * register.Person.
 */
public class Person implements Comparable<Person>, Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Name of this person. */
    private String name;
    
    /** Phone number of this person. */
    private String phoneNumber;
    
    /**
     * Construct a person.
     * @param name name of the person
     * @param phoneNumber phone number of the person
     */
    public Person(String name, String phoneNumber) {
        this.name = name;
        this.setPhoneNumber(phoneNumber);        
    }
            
    /**
     * Returns name of this person.
     * @return name of this person
     */
    public String getName(){
        return name;
    }
    
    /**
     * Sets name of this person.
     * @param nameNew name of this person
     */
    public void setName(String nameNew) {
        name = nameNew;
    }
    
    /**
     * Returns phone number of this person.
     * @return phone number of this person
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number of this person.
     * @param phoneNumberNew phone number of this person
     */
    public void setPhoneNumber(String phoneNumberNew) {
        if(!isValidPhoneNumber(phoneNumberNew)) {
            throw new RuntimeException("Phone number is not valid");
        }
        phoneNumber = phoneNumberNew;
    }
    
    
    //TODO: Implement method isValidPhoneNumber
    /**
     * Validates the phone number. Valid phone numbers contains only digits.
     * @param phoneNumber phone number to validate
     * @return <code>true</code> if phone number is valid, <code>false</code> otherwise
     */
    private boolean isValidPhoneNumber(String phoneNumber) {     
    	/*Pattern p = Pattern.compile("[0-9]*");
		Matcher m = p.matcher(phoneNumber);
		boolean b = m.matches();
        if(b){
        	return true;
        } else {
        	return false;
        } */
    	boolean bool = false;
    	int length = phoneNumber.length();
    	for(int i = 0;i<length;i++){
    		if((bool = Character.isDigit(phoneNumber.charAt(i))) == false){
    			return bool;
    		}
    	}
		return bool;
    }
    
    /**
     * Returns a string representation of the person.
     * @return string representation of the person.
     */
    public String toString() {
        return  name + " (" + phoneNumber + ")" +"\n";
    }

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(name);
}
}
