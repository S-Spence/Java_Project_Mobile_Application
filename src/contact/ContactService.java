/* --------------------------------------------------------------------------------------------------------
 * Title: 3-1 Milestone Contact Service
 * Date: 2021-03-28
 * Author: Sarah Spence
 * Course: CS 330
 * Instructor: Bryant Moscon
 * Description: This is the contact service class. It stores contact objects. 
 * 				The class also adds contacts per unique contact Id, and deletes and updates contacts
 * 				per contact Id. 
 *---------------------------------------------------------------------------------------------------------
 */
package contact; 
import java.util.*; 

public class ContactService {
	
	ArrayList<Contact> contactList = new ArrayList<Contact>(); // Array list to store contacts
	
	// Class constructor
	public ContactService(){
	
	}
	
	/* Add a new contact to the list
	 * @Param A new contact
	 */
	public void addContact(Contact newContact) {
		
		// Iterate through list elements and throw exception if the contact Id is found 
		for (Contact contact : contactList) {
			if (contact.getContactID().equals(newContact.getContactID())) {
				throw new UnsupportedOperationException("The contact ID is already in the contact list.");
			}
		}
		
		// Add the contact to the contact list
		contactList.add(newContact);	
	}
	
	/* Method to delete a contact from the list per contact ID
	 * @Param String contact ID
	 */
	public void deleteContact(String contactID) {
		
		/* Remove the contact if the contact ID is in the list. Return statement to work around
		 * concurrent modification error.
		 */
		for (Contact contact : contactList) {
			if(contact.getContactID().equals(contactID)) {
				contactList.remove(contact);  // remove contact from list
				return;
			}	
		}
	}
	
	
	/* Method to update the first name by contact ID
	 * @Param String contact Id
	 * @Param String first name
	 */
	public void updateContactFirstName(String contactID, String firstName) {
		boolean foundId = false;    // Boolean to throw exception if Id invalid
		
		// Check the contact list for the contact ID and update first name
		for (Contact contact : contactList) {
			if(contact.getContactID().equals(contactID)) {
				contact.setFirstName(firstName);
				foundId = true;
			}
		}
		
		// throw exception if the contact Id was not found
		if(foundId == false) {
			throw new IllegalArgumentException("The contact Id is invalid.");
		}
	}
	
	/* Method to update the last name by contact ID 
	 * @Param String contact Id 
	 * @Param String last name
	 */
	public void updateContactLastName(String contactID, String lastName) {
		boolean foundId = false;   // Boolean to throw exception if contact Id invalid
		
		// Check the contact list for the contact ID and update last name
		for (Contact contact : contactList) {
			if(contact.getContactID().equals(contactID)) {
				contact.setLastName(lastName);	
				foundId = true;
			}
		}
		
		// Throw exception if the contact Id was not found
		if(foundId == false) {
			throw new IllegalArgumentException("The contact Id is invalid");
		}
	}
	
	/* Method to update the phone number by contact ID
	 * @Param String contact Id 
	 * @Param String phone number
	 */
	public void updateContactPhoneNumber(String contactID, String phoneNumber) {
		boolean foundId = false;  // Boolean to throw exception if contact Id invalid
		// Check the contact list for the contact ID and update phone number
		for (Contact contact : contactList) {
			if(contact.getContactID().equals(contactID)) {
				contact.setPhoneNumber(phoneNumber);
				foundId = true;	
			}
		}
		
		// Throw exception if the contact Id was not found
		if (foundId == false) {
			throw new IllegalArgumentException("The contact Id is invalid");
		}
	}
	
	/* Method to update the address by contact ID
	 * @Param String contact Id 
	 * @Param String address
	 */
	public void updateContactAddress(String contactID, String address) {
		boolean foundId = false;
		
		// Check the contact list for the contact ID and update address
		for (Contact contact : contactList) {
			if(contact.getContactID().equals(contactID)) {
				contact.setAddress(address);
				foundId = true;
			}
		}
		
		// Throw exception if the contact Id was not found
		if(foundId == false) {
			throw new IllegalArgumentException("The contact Id is invalid");
		}
	}
	
	// Return contact list
	public ArrayList<Contact> getContactList(){
		return this.contactList;
	}
}
