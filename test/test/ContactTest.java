/* --------------------------------------------------------------------------------------------------------
 * Title: Contact Tests
 * Date: 2021-03-28
 * Author: Sarah Spence
 * Description: This class contains the unit tests for the contact class.
 *---------------------------------------------------------------------------------------------------------
 */
package test;

import contact.*;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	
	/* Requirement 1: The contact class must have a unique contact ID that cannot be null and cannot be 
	 *                longer than 10 characters. The contact ID shall not be updatable. 
	 *                
	 * Test 1: set contactID when ten characters or less and not null for a new contact
	 * Test 2: set contactId when ten characters or less and not null with setContactId() method
	 * Test 3: test that an exception is thrown when the contact ID is already set for setContactId() method
	 * Test 4: test for an exception when the contact ID is too long in new contact
	 * Test 5: test for an exception when the contact Id is null for a new contact
	 * Test 6: test for an exception when the contact Id is too long in an updated contact
	 * Test 7: test for an exception when the contact Id is null for and updated contact
	 */
	
	// Requirement 1: Test 1: set contactID ten characters or less and the contact is a new contact
	@Test
	void testSetContactID() {
		
		// Create new contact
		Contact contact = new Contact("123456789", "Sarah", "Smith", "1111122222", "Some Street");
		// Test contact Id set
		assertTrue(contact.getContactID().equals("123456789"));
		
	}
	
	/* Requirement 1: Test 2: set contactId when ten characters or less and not null with the
	 * set contact method.
	 */
	@Test
	void testSetContactIdMethod() {
		
		// Create new contact no values
		Contact contact = new Contact();
		
		// Set contact Id when it has not been set
		contact.setContactId("123");
		
		// Test contact Id set
		assertTrue(contact.getContactID().equals("123"));
	}
	
	// Requirement 1: Test 3: check that an exception is thrown when the contact is already set
	@Test
	void testAlreadySetID() {
		Contact contact = new Contact("123456789", "Sarah", "Smith", "1111122222", "Some Street");
		Assertions.assertThrows(UnsupportedOperationException.class, () ->{
			contact.setContactId("123333333");
		});
	}
	
	// Requirement 1: Test 4: Test for an exception when created a new contact with an invalid Id
	@Test
	void testNewContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("12345678910", "Sarah", "Spence", "1111111111", "Unicorn Lane");
		});
	}
	
	// Requirement 1: Test 5: Test for an exception when creating a new contact with a null Id
	@Test
	void testNewContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, "Sarah", "Spence", "1111111111", "Unicorn Lane");
		});
	}
	
	/* Requirement 1: Test 6: Test that an exception is throw when the contact Id is too long in
	 * the setContactId() method.
	 */
	@Test
	void testSetContactIdTooLong() {
		
		// Create a new contact
		Contact contact = new Contact();
		
		// Check for exception when the contact Id is too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setContactId("123123123123");
		});
	}
	
	/* Requirement 1: Test 7: Test that an exception is throw when the contact Id is null in
	 * the setContactId() method.
	 */
	@Test
	void testSetContactIdNull() {
		
		// Create a new contact
		Contact contact = new Contact();
		
		// Check for exception when the contact Id is too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setContactId(null);
		});
	}
	

	
    /* Requirement 2: The contact class must have a first name string that is not null and is
     *                not longer than 10 characters.
     * Test 1: set the contact first name if it is less than 10 characters and is not null in new contact
     * Test 2: set the contact first name if it is less than 10 characters and not null in the 
     *         setContactFirstName() method
     * Test 3: throw exception when the first name is greater than 10 characters in a new contact
     * Test 4: throw exception when the first name is null in a new contact
     * Test 5: throw exception when the first name is greater than 10 characters in the 
     *         setContactFirstName() method.
     * Test 6: throw exception when the first name is null in the setContactFirstName() method       
	*/
	
	/* Requirement 2: Test 1: Set the contact first name if it is less than 10 characters and is not null
	 *  in a new contact
	 */
	@Test
	void testSetFirstName() {
		Contact contact = new Contact("123456789", "Sarah", "Smith", "1111122222", "Some Street");
		assertTrue(contact.getFirstName().equals("Sarah"));
	}
	
	/* Requirement 2: Test 2: set the contact first name if it less than 10 characters and not null in 
	 * in the setContactFirstName() method.
	 */
	@Test
	void testUpdateFirstName() {
		Contact contact = new Contact("123456789", "Sarah", "Spence", "1111122222", "Some Street");
		contact.setFirstName("John");
		assertTrue(contact.getFirstName().equals("John"));
	}
	
	/* Requirement 2: Test 3: throw exception when the first name is greater than 10 characters in 
	 * a new contact
	 */
	@Test
	void testNewContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("123456789", "Sarah!!!!!!!", "Spence", "1231212121", "Some Street");
		});
	}
	
	/* Requirement 2: Test 4: throw exception when the first name is greater than 10 characters in 
	 * a new contact
	 */
	@Test
	void testNewContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("123456789", null, "Spence", "1231212121", "Some Street");
		});
	}
	
	/* Requirement 2: Test 5: throw exception when the first name is greater than 10 characters in 
	 * the setContactFirstName() method
	 */
	@Test
	void testSetFirstNameTooLong() {
		Contact contact = new Contact("123456789", "Sarah", "Spence", "1111111111", "Unicorn Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setFirstName("John!!!!!!!!!!");
		});
	}
	
	/* Requirement 2: Test 6: throw exception when the first name is greater than 10 characters in 
	 * the setContactFirstName() method
	 */
	@Test
	void testSetFirstNameNull() {
		Contact contact = new Contact("123456789", "Sarah", "Spence", "1111111111", "Unicorn Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setFirstName(null);
		});
	}
	

	/* Requirement 3: The contact class must have a last name string that is not null and is not longer 
	 *                than 10 characters.
     * Test 1: set the contact last name if it is less than 10 characters and is not null in a new contact
     * Test 2: set the contact last name if it is less than 10 characters and is not null in the
     *         updateContactLastName() method
     * Test 3: throw exception when the last name is greater than 10 characters in a new contact
     * Test 4: throw exception when the last name if null in a new contact
     * Test 5: throw exception when the last name is greater than 10 characters in the setContactLastName()
     *          method
     * Test 6: throw exception when the last name is null in the setContactLastName() method
	 */
	
	/* Requirement 3: Test 1: Set the contact last name if it is less than 10 characters and is not null 
	 * in a new contact
	 */
	@Test
	void testSetLastName() {
		Contact contact = new Contact("123456789", "Sarah", "Smith", "1111122222", "Some Street");
		assertTrue(contact.getLastName().equals("Smith"));
	}
	
	/* Requirement 3: Test 2: set the contact last name if it less than 10 characters and is not null in 
	 * an updated contact
	 */
	@Test
	void testUpdateLastName() {
		Contact contact = new Contact("123456789", "Sarah", "Spence", "1111122222", "Some Street");
		contact.setLastName("Smith");
		assertTrue(contact.getLastName().equals("Smith"));
	}
	
	/* Requirement 3: Test 3: throw exception when the last name is greater than 10 characters in a 
	 * new contact
	 */
	@Test
	void testNewContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("123456789", "Sarah", "Spence!!!!!!!!", "1231212121", "Some Street");
		});
	}
	
	// Requirement 3: Test 4: throw exception when the last name is null in a new contact
	@Test
	void testNewContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("123456789", "Sarah", null, "1231212121", "Some Street");
		});
	}
	
	/* Requirement 3: Test 5: throw exception when the last name is greater than 10 characters in 
	 * the setContactLastName() method
	 */
	@Test
	void testSetLastNameTooLong() {
		Contact contact = new Contact("123456789", "Sarah", "Spence", "1111111111", "Unicorn Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setLastName("Smith!!!!!!!!!!");
		});
	}
	
	// Requirement 3: Test 6: throw exception when the last name is null in the setContactLastName() method
	@Test
	void testSetLastNameNull() {
		Contact contact = new Contact("123456789", "Sarah", "Spence", "1111111111", "Unicorn Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setLastName(null);
		});
	}
	

	/* Requirement 4: The contact class must have a phone number string that is not null and is exactly 
	 *                10 characters.
     * Test 1: set the contact phone number if it is exactly 10 characters and is not null in a new contact.
     * Test 2: set the contact phone number if it is exactly 10 characters and is not null in 
     *         the setContactPhoneNumber method().
     * Test 3: throw exception when the phone number is not 10 characters in a new contact.
     * Test 4: Throw exception when the phone number is null in a new contact.
     * Test 5: throw exception when the phone number is not 10 characters in the setContactPhoneNumer()
     *         method.
     * Test 6: throw exception when the phone number is null in the setContactPhoneNumer() method.
	 */
	
	/* Requirement 4: Test 1: set the contact phone number if it is exactly 10 characters and is not 
	 * null in a new contact
	 */
	@Test
	void testSetPhoneNumber() {
		Contact contact = new Contact("123456789", "Sarah", "Smith", "1111122222", "Some Street");
		assertTrue(contact.getPhoneNumber().equals("1111122222"));
	}
	
	/* Requirement 4: Test 2: set the contact phone number if it is exactly 10 characters and is not null 
	 *in the setContactPhoneNumber() method
	 */
	@Test
	void testUpdatePhoneNumber() {
		Contact contact = new Contact("123456789", "Sarah", "Spence", "1111122222", "Some Street");
		contact.setPhoneNumber("2222233333");
		assertTrue(contact.getPhoneNumber().equals("2222233333"));
	}
	
	// Requirement 4: Test 3: throw exception when the phone number is not 10 characters in a new contact
	@Test
	void testNewContactPhoneNumberInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("123456789", "Sarah", "Spence", "12312121211", "Some Street");
		});
	}
	
	// Requirement 4: Test 4: throw exception when the phone number is null in a new contact
	@Test
	void testNewContactPhoneNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("123456789", "Sarah", "Spence", null, "Some Street");
		});
	}
	
	/* Requirement 4: Test 5: throw exception when the phone number is not 10 characters in an the 
	 * setContactPhoneNumber() method
	 */
	@Test
	void testSetPhoneNumberInvalid() {
		Contact contact = new Contact("123456789", "Sarah", "Spence", "1111111111", "Unicorn Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setPhoneNumber("12312312312");
		});
	}
	
	/* Requirement 4: Test 6: throw exception when the phone number is null in an the 
	 * setContactPhoneNumber() method
	 */
	@Test
	void testSetPhoneNumberNull() {
		Contact contact = new Contact("123456789", "Sarah", "Spence", "1111111111", "Unicorn Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setPhoneNumber(null);
		});
	}

	/* Requirement 5: The contact class must have an address string that is not null and is not longer 
	 *                than 30 characters.
     * Test 1: set the contact address if it is less than 30 characters and is not null in a new contact
     * Test 2: set the contact address if it is less than 30 characters and is not null with the
     *         setContactAddress() method.
     * Test 3: throw exception when the address is greater than 30 characters in a new contact
     * Test 4: throw exception when the address is null in a new contact
     * Test 5: throw exception when the address is greater than 30 characters with the setContactAddress()
     *         method
     * Test 6: throw exception when the address is null with the setContactAddress() method.
	 */
	
	/* Requirement 5: Test 1: set the contact address if it is less than 30 characters and is not null 
	 * in a new contact
	 */
	@Test
	void testSetAddress() {
		Contact contact = new Contact("123456789", "Sarah", "Smith", "1111122222", "Some Street");
		assertTrue(contact.getAddress().equals("Some Street"));
	}
	
	/* Requirement 5: Test 2: set the contact address if it is less than 30 characters and is not null in 
	 * the setContactAddress() method
	 */
	@Test
	void testUpdateAddress() {
		Contact contact = new Contact("123456789", "Sarah", "Spence", "1111122222", "Some Street");
		contact.setAddress("222 Second Street");
		assertTrue(contact.getAddress().equals("222 Second Street"));
	}
	
	// Requirement 5: Test 3: throw exception when the address is more than 30 characters in new contact
	@Test
	void testNewContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("123456789", "Sarah", "Spence", "1231212121", "Some Street Address Too Long!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		});
	}
	
	// Requirement 5: Test 4: throw exception when the address is more than 30 characters in new contact
	@Test
	void testNewContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("123456789", "Sarah", "Spence", "1231212121", null);
		});
	}
	
	/* Requirement 5: Test 5: throw exception when the address is greater than 30 characters in the 
	 * setContactAddress() method
	 */
	@Test
	void testSetAddressTooLong() {
		Contact contact = new Contact("123456789", "Sarah", "Spence", "1111111111", "Unicorn Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setAddress("Some Street Address Too Long!!!!!!!!!!!!!!!!!!!!");
		});
	}
	
	/* Requirement 5: Test 6: throw exception when the address is null in the setContactAddress() method
	 */
	@Test
	void testSetAddressNull() {
		Contact contact = new Contact("123456789", "Sarah", "Spence", "1111111111", "Unicorn Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setAddress(null);
		});
	}
}
