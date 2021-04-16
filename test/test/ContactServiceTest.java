/* --------------------------------------------------------------------------------------------------------
 * Title: Contact Service Tests
 * Date: 2021-03-28
 * Author: Sarah Spence
 * Description: This class contains the unit tests for the contactService class
 *---------------------------------------------------------------------------------------------------------
 */
package test;
import contact.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;

class ContactServiceTest {

	
	/* Requirement 1: The contact service must be able to add contacts with a unique ID.
	 * Test 1: Add new contacts to the list with unique Ids.
	 * Test 2: Throw Exception when the contact ID is already in the contact list.
	 */
	
	// Requirement 1: Test 1: Add a new contact when the ID is not already in the list 
	@Test
	void testAddNewContact() {
		
		// Instantiate a new contact service list
		ContactService contactList = new ContactService();
		
		// Create new contacts and add them to the contact list
		Contact contact1 = new Contact("123123123", "Sarah", "Spence", "1234567890", "Some Street");
		Contact contact2 = new Contact("12345", "Angela", "Pannetti", "1234567891", "Some Street 2");
		Contact contact3 = new Contact("1234567", "Alyssa", "Smith", "1234123412", "Some Street 3");
		
		// Add the contacts to the contact list
		contactList.addContact(contact1);
		contactList.addContact(contact2);
		contactList.addContact(contact3);
		
		// Check that the contact service list contains 3 new contacts
		assertTrue(contactList.getContactList().size() == 3);
	}
	
	// Requirement 1: Test 2: throw Exception when the contact ID is already in the list
	@Test
	void testAddNewContactException() {
		
		// Instantiate a new contact service list
		ContactService contactList = new ContactService();
		
		// Create new contacts and add them to the contact list. Contact three had non-unique Id
		Contact contact1 = new Contact("123123123", "Sarah", "Spence", "1234567890", "Some Street");
		Contact contact2 = new Contact("12345", "Angela", "Pannetti", "1234567891", "Some Street 2");
		Contact contact3 = new Contact("12345", "Alyssa", "Smith", "1234123412", "Some Street 3");

		// Add contacts 1 and 2 to the contact list
		contactList.addContact(contact1);
		contactList.addContact(contact2);
		
		// Test that an exception is thrown when adding a contact with a non-unique Id
		Assertions.assertThrows(UnsupportedOperationException.class, () ->{
			contactList.addContact(contact3);
		});
	}
	
	/* Requirement 2: The contact service must be able to delete a contact by its contactID
	 * Test 1: delete the contact when the ID provided is in the contact list
	 * Test 2: check that the list remains unchanged when the Id is not in the list
	 */
	
	// Requirement 2: Test 1: delete the contact when the ID provided is in the contact list
	@Test
	void testDeleteContact() {
		
		// Instantiate a new contact service list
		ContactService contactList = new ContactService();
		
		// Create new contacts and add them to the contact list
		Contact contact1 = new Contact("123123123", "Sarah", "Spence", "1234567890", "Some Street");
		Contact contact2 = new Contact("12345", "Angela", "Pannetti", "1234567891", "Some Street 2");
		Contact contact3 = new Contact("1234567", "Alyssa", "Smith", "1234123412", "Some Street 3");
		
		// Add the contacts to the contact list
		contactList.addContact(contact1);
		contactList.addContact(contact2);
		contactList.addContact(contact3);
		
		// Delete contact from contact list by contact ID
		contactList.deleteContact("12345");
		
		// Check that the contact was deleted from the list
		assertTrue(contactList.getContactList().size() == 2);
	}
	
	// Requirement 2: Test 2: check that the list remains unchanged when the contact Id is not in the list
	@Test
	void testDeleteInvalidContact() {
		
		// Instantiate a new contact service list
		ContactService contactList = new ContactService();
		
		// Create new contacts and add them to the contact list
		Contact contact1 = new Contact("123123123", "Sarah", "Spence", "1234567890", "Some Street");
		Contact contact2 = new Contact("12345", "Angela", "Pannetti", "1234567891", "Some Street 2");
		Contact contact3 = new Contact("1234567", "Alyssa", "Smith", "1234123412", "Some Street 3");
		
		// Add the contacts to the contact list
		contactList.addContact(contact1);
		contactList.addContact(contact2);
		contactList.addContact(contact3);
		
		// Try to delete a contact with an invalid Id
		contactList.deleteContact("123");
		
		// Check that the contact list remains unchanged
		assertTrue(contactList.getContactList().size() == 3);
	}
	
	/* Requirement 3: The contact class must be able to update the following contact fields per contact ID: first name, last name,
	 * 				  phone number, address. 
	 * Test 1: check that the method to update the first name works when the contact ID is in the list
	 * Test 2: check that the method to update the last name works when the contact ID is in the list
	 * Test 3: check that the method to update the phone number works when the contact ID is in the list
	 * Test 4: check that the method to update the address works when the contact ID is in the list
	 * Test 5: throw exception when updating a contact first name with an invalid Id
	 * Test 6: throw exception when updating a contact last name with an invalid Id
	 * Test 7: throw exception when updating a contact phone number with an invalid Id
	 * Test 8: throw exception when updating a contact address with an invalid Id
	 */
	
	// Requirement 3: Test 1: Check that the method to update the first name works with valid contactID
	@Test
	void testUpdateFirstName() {
		
		// Instantiate a new contact service list
		ContactService contactList = new ContactService();
		
		// Create new contacts and add them to the contact list
		Contact contact1 = new Contact("123123123", "Sarah", "Spence", "1234567890", "Some Street");
		Contact contact2 = new Contact("12345", "Angela", "Pannetti", "1234567891", "Some Street 2");
		Contact contact3 = new Contact("1234567", "Alyssa", "Smith", "1234123412", "Some Street 3");
		
		// Add the contacts to the contact list
		contactList.addContact(contact1);
		contactList.addContact(contact2);
		contactList.addContact(contact3);
		
		// Update a contact's first name
		contactList.updateContactFirstName("12345", "James");
		
		// Test that the contact's first name updated
		for(Contact contact : contactList.getContactList()) {
			if(contact.getContactID().equals("12345")) {
				assertTrue(contact.getFirstName().equals("James"));
			}
		}
	}
	
	// Requirement 3: Test 2: check that the method to update the last name works with a valid contact ID
	@Test
	void testUpdateLastName() {
		
		// Instantiate a new contact service list
		ContactService contactList = new ContactService();
		
		// Create new contacts and add them to the contact list
		Contact contact1 = new Contact("123123123", "Sarah", "Spence", "1234567890", "Some Street");
		Contact contact2 = new Contact("12345", "Angela", "Pannetti", "1234567891", "Some Street 2");
		Contact contact3 = new Contact("1234567", "Alyssa", "Smith", "1234123412", "Some Street 3");
		
		// Add the contacts to the contact list
		contactList.addContact(contact1);
		contactList.addContact(contact2);
		contactList.addContact(contact3);
		
		// Update a contact's last name
		contactList.updateContactLastName("12345", "Kelly");
		
		// Test that the contact last name updated
		for(Contact contact : contactList.getContactList()) {
			if(contact.getContactID().equals("12345")) {
				assertTrue(contact.getLastName().equals("Kelly"));
			}
		}
	}
	
	// Requirement 3: Test 3: check that the method to update the phone number works with a valid contact ID
	@Test
	void testUpdatePhoneNumber() {
		
		// Instantiate a new contact service list
		ContactService contactList = new ContactService();
		
		// Create new contacts and add them to the contact list
		Contact contact1 = new Contact("123123123", "Sarah", "Spence", "1234567890", "Some Street");
		Contact contact2 = new Contact("12345", "Angela", "Pannetti", "1234567891", "Some Street 2");
		Contact contact3 = new Contact("1234567", "Alyssa", "Smith", "1234123412", "Some Street 3");
		
		// Add the contacts to the contact list
		contactList.addContact(contact1);
		contactList.addContact(contact2);
		contactList.addContact(contact3);
		
		// Update a contact's phone number
		contactList.updateContactPhoneNumber("12345", "1231231231");
		
		// Test that the contact name updated
		for(Contact contact : contactList.getContactList()) {
			if(contact.getContactID().equals("12345")) {
				assertTrue(contact.getPhoneNumber().equals("1231231231"));
			}
		}
	}
	
	// Requirement 3: Test 4: check that the method to update the address works with a valid contact ID
	@Test
	void testUpdateAddress() {
		
		// Instantiate a new contact service list
		ContactService contactList = new ContactService();
		
		// Create new contacts and add them to the contact list
		Contact contact1 = new Contact("123123123", "Sarah", "Spence", "1234567890", "Some Street");
		Contact contact2 = new Contact("12345", "Angela", "Pannetti", "1234567891", "Some Street 2");
		Contact contact3 = new Contact("1234567", "Alyssa", "Smith", "1234123412", "Some Street 3");
		
		// Add the contacts to the contact list
		contactList.addContact(contact1);
		contactList.addContact(contact2);
		contactList.addContact(contact3);
		
		// Update a contact's address
		contactList.updateContactAddress("12345", "New Street");
		
		// Test that the contact address updated
		for(Contact contact : contactList.getContactList()) {
			if(contact.getContactID().equals("12345")) {
				assertTrue(contact.getAddress().equals("New Street"));
			}
		}
	}
	
	// Requirement 3: Test 5: Throw exception when updating a contact first name with an invalid Id
	@Test
	void testUpdateFirstNameInvalidId() {
		
		// Instantiate a new contact service list
		ContactService contactList = new ContactService();
		
		// Create new contacts and add them to the contact list
		Contact contact1 = new Contact("123123123", "Sarah", "Spence", "1234567890", "Some Street");
		Contact contact2 = new Contact("12345", "Angela", "Pannetti", "1234567891", "Some Street 2");
		Contact contact3 = new Contact("1234567", "Alyssa", "Smith", "1234123412", "Some Street 3");
		
		// Add the contacts to the contact list
		contactList.addContact(contact1);
		contactList.addContact(contact2);
		contactList.addContact(contact3);
		
		// Try to update a contact with an invalid ID
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactList.updateContactFirstName("123", "James");
		});
	}
	
	// Requirement 3: Test 6: Throw exception when updating a contact last name with an invalid Id
	@Test
	void testUpdateLastNameInvalidId() {
		
		// Instantiate a new contact service list
		ContactService contactList = new ContactService();
		
		// Create new contacts and add them to the contact list
		Contact contact1 = new Contact("123123123", "Sarah", "Spence", "1234567890", "Some Street");
		Contact contact2 = new Contact("12345", "Angela", "Pannetti", "1234567891", "Some Street 2");
		Contact contact3 = new Contact("1234567", "Alyssa", "Smith", "1234123412", "Some Street 3");
		
		// Add the contacts to the contact list
		contactList.addContact(contact1);
		contactList.addContact(contact2);
		contactList.addContact(contact3);
		
		// Try to update a contact with an invalid ID
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactList.updateContactLastName("123", "Kelly");
		});
	}
	
	// Requirement 3: Test 7: Throw exception when updating a contact phone number with an invalid Id
	@Test
	void testUpdatePhoneNumberInvalidId() {
		
		// Instantiate a new contact service list
		ContactService contactList = new ContactService();
		
		// Create new contacts and add them to the contact list
		Contact contact1 = new Contact("123123123", "Sarah", "Spence", "1234567890", "Some Street");
		Contact contact2 = new Contact("12345", "Angela", "Pannetti", "1234567891", "Some Street 2");
		Contact contact3 = new Contact("1234567", "Alyssa", "Smith", "1234123412", "Some Street 3");
		
		// Add the contacts to the contact list
		contactList.addContact(contact1);
		contactList.addContact(contact2);
		contactList.addContact(contact3);
		
		// Try to update a contact with an invalid ID
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactList.updateContactPhoneNumber("123", "1231231231");
		});
	}
	
	// Requirement 3: Test 8: Throw exception when updating a contact address with an invalid Id
	@Test
	void testUpdateAddressInvalidId() {
		
		// Instantiate a new contact service list
		ContactService contactList = new ContactService();
		
		// Create new contacts and add them to the contact list
		Contact contact1 = new Contact("123123123", "Sarah", "Spence", "1234567890", "Some Street");
		Contact contact2 = new Contact("12345", "Angela", "Pannetti", "1234567891", "Some Street 2");
		Contact contact3 = new Contact("1234567", "Alyssa", "Smith", "1234123412", "Some Street 3");
		
		// Add the contacts to the contact list
		contactList.addContact(contact1);
		contactList.addContact(contact2);
		contactList.addContact(contact3);
		
		// Try to update a contact with an invalid ID
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactList.updateContactAddress("123", "New Street");
		});
	}
}

