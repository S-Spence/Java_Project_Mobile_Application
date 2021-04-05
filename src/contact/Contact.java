/* --------------------------------------------------------------------------------------------------------
 * Title: 3-1 Milestone Contact Service
 * Date: 2021-03-14
 * Author: Sarah Spence
 * Course: CS 330
 * Instructor: Bryant Moscon
 * Description: This is the contact class. The class creates a new contact object containing a unique contact ID,
 *              a contact first name, a contact last name, a contact phone number, and a contact address.
 *              The contact ID is immutable once set. The variables cannot be null.  
 *---------------------------------------------------------------------------------------------------------
 */
package contact;

public class Contact {
	
	String contactID;     // Contact Id (max 10 characters)
	String firstName;     // First name (max 10 characters)
	String lastName;	  // Last name (max 10 characters)
	String phoneNumber;   // Phone number (Exactly 10 digits)
	String address;       // Address (Max 30 characters)
	
	// Empty class constructor
	public Contact() {
		
	}
	
	// Overloaded class constructor (parameterized)
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		
		// Throw exception if the contact id is already set
		if(this.contactID != null) {
			throw new UnsupportedOperationException("The contact ID is not updateable");
			
		}
		// Throw exception if the contact length exceeds 10 characters or is null
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("The contact ID provided cannot be null and must be 10 characters or less.");
		}
		// Else, set contact Id
		else {
			this.contactID = contactID;
		}
		
		// Set the first name if it is 10 characters or less and is not null
		if (firstName != null && firstName.length() <= 10) {
			this.firstName = firstName;
		}
		// Else, throw exception for invalid input
		else {
			throw new IllegalArgumentException("The first name cannot be null and must be 10 characters or less.");
		}
		
		// Set the last name if it is 10 characters or less and is not null
		if (lastName != null && lastName.length() <= 10) {
			this.lastName = lastName;
		}
		// Else, throw exception for invalid input
		else {
			throw new IllegalArgumentException("The last name cannot be null and must be 10 characters or less.");
		}
		
		// Set the phone number if it is exactly ten characters and is not null
		if (phoneNumber != null && phoneNumber.length() == 10) {
			this.phoneNumber = phoneNumber;
		}
		// Else, throw exception for invalid input
		else {
			throw new IllegalArgumentException("The phone number must be exactly 10 characters and cannot be null");
		}
		
		// Set the address if it is 30 characters or less and is not null
		if (address != null && address.length() <= 30) {
			this.address = address;
		}
		// Else, throw exception for inalid input
		else {
			throw new IllegalArgumentException("The address cannot be null and must be 30 chracters or less.");
		}
	}	
	
	/* Set immutable contact ID. Throw an exception to show that the id is not updatable. 
	 * Include exception handling for null values and values greater than 10 characters.
	 * @param string contact ID
	 */ 
    public void setContactId(String contactID) {
    	
    	// Only set the contactID for a new contact where the ID is null
    	if(this.contactID != null) {
    		throw new UnsupportedOperationException("The contact ID is not updatable.");
    	}
    	// Else, set the contact ID if it is 10 character or less and is not null
    	else {
    		if(contactID != null && contactID.length() <= 10) {
    			this.contactID = contactID;
    		}
    		else {
    			throw new IllegalArgumentException("The contact ID cannot exceed 10 characters and cannot be null.");
    		}
    	}
    }
    
	/* Set first name when a name is provided that is ten characters or less. 
	 * Include exception handling for null values ad values greater than 10 characters.
	 * @param string first name
	 */
	public void setFirstName(String firstName) {
		
		// Set the first name if it is 10 characters or less and is not null
		if (firstName != null && firstName.length() <= 10) {
			this.firstName = firstName;
		}
		else {
			throw new IllegalArgumentException("The first name cannot exceed 10 characters and cannot be null.");
		}	
	}
	
	/* Set last name when a name is provided that is ten characters or less. 
	 * Include exception handling for null values and values greater than 10 characters.
	 * @param string last name 
	 */
	public void setLastName(String lastName) {
		
		// Set the last name if it is 10 characters or less and is not null
		if (lastName != null && lastName.length() <= 10) {
			this.lastName = lastName;
		}
		else {
			throw new IllegalArgumentException("The last name cannot exceed 10 characters and cannot be null.");
		}
	}
	
	/* Set phone number while input is 10 exactly characters. 
	 * Include exception handling for null values and values not equal to 10 characters 
	 * @param string phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		
		// Set the phone number if it is equal to 10 characters and is not null
		if(phoneNumber != null && phoneNumber.length() == 10) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new IllegalArgumentException("The phone must be exactly 10 characters and cannot be null.");
		}
	}
	
	/* Set address while the input is less than 30 characters. 
	 * Include Exception handling for null values and values greater than 30 characters.
	 * @param string address
	 */
	public void setAddress(String address) {
		
		// Set the address if it is 30 characters or less and is not null
		if(address != null && address.length() <= 30) {
			this.address = address;
		}
		else {
			throw new IllegalArgumentException("The address cannot exceed 30 characters and cannot be null.");
		}
	}
	
	/* Methods to return class objects*/
	
	// Get contact Id
	public String getContactID() {
		return this.contactID;
	}
	
	// Get first name
	public String getFirstName() {
		return this.firstName;
	}
	
	// Get last name
	public String getLastName() {
		return this.lastName;
	}
	
	//Get phone number
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	// Get address
	public String getAddress() {
		return this.address;
	}	
}
