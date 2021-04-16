/* --------------------------------------------------------------------------------------------------------
 * Title: Appointment Tests
 * Date: 2021-04-01
 * Author: Sarah Spence
 * Description: This file contains the unit tests for the appointment class.
 *---------------------------------------------------------------------------------------------------------
 */
package test;

import appointment.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	/* Requirement 1: The appointment object must have a required unique appointment ID that 
	 *                cannot exceed 10 characters. The appointment ID cannot be null or 
	 *                updateable. 
	 *                
	 * Test 1: create new appointment with a valid Id
	 * Test 2: test the setAppointmentId() method with a valid Id
	 * Test 3: throw exception when trying to update an appointment Id that is already set.
	 * Test 4: throw exception when creating a new appointment with an invalid Id.
	 * Test 5: throw exception when creating an appointment with a null Id.
	 * Test 6: throw exception when using the setAppointmentId() method with an invalid Id
	 * Test 7: throw exception when using the setAppointmentId() method with a null Id 
	 */
	
	// Requirement 1: Test 1: Create a new appointment with a valid ID
	@Test
	void testNewAppointmentValidId() {
		
		// Create a Calendar object
		Calendar appointmentDate = Calendar.getInstance();
		
		// Set the year, month, day, hour, and minute of new appointment
		appointmentDate.set(2021, Calendar.APRIL, 30, 13, 00);
		
		// Create a new appointment with valid fields
		Appointment appointment = new Appointment("123", appointmentDate, "A new appointment");
		
		// Test that the new appointment Id was set
		assertTrue(appointment.getAppointmentId().equals("123"));
	}
	
	/* Requirement 1: Test 2: Test the setAppointmetId() method with a valid Id
	 */
	@Test
	void testSetAppointmentValidId() {
		
		// Initialize an empty appointment and set the appointment Id
		Appointment appointment = new Appointment();           
		appointment.setAppointmentId("1234");
		
		// Test that the Id was set
		assertTrue(appointment.getAppointmentId().equals("1234"));	
	}
	
	// Requirement 1: Test 3: throw exception when trying to update an already set Id
	@Test
	void testAlreadySetAppointmentID() {
		
		// Create a Calendar object
		Calendar appointmentDate = Calendar.getInstance();
		
		// Set the year, month, day, hour, and minute of new appointment
		appointmentDate.set(2021, Calendar.APRIL, 30, 13, 00);
		
		// Create a new appointment with valid fields
		Appointment appointment = new Appointment("123", appointmentDate, "A new appointment");
		
		Assertions.assertThrows(UnsupportedOperationException.class, () ->{
			appointment.setAppointmentId("12333");
		});
	}
	
	// Requirement 1: Test 4: throw exception when creating a new appointment with an invalid Id
	@Test
	void testInvalidAppointmentId() {
		
		// Create a Calendar object
		Calendar appointmentDate = Calendar.getInstance();
		
		// Set the year, month, day, hour, and minute of new appointment
		appointmentDate.set(2021, Calendar.APRIL, 30, 13, 00);
		
		// Check for illegal argument exception when an invalid Id is provided
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("123456548888888", appointmentDate, "A new appointment");
		});
	}
	
	// Requirement 1: Test 5: Throw exception when creating a new appointment with a null Id
	@Test
	void testNewAppointmentIdNull() {
		
		// Create a Calendar object
		Calendar appointmentDate = Calendar.getInstance();
		
		// Set the year, month, day, hour, and minute of new appointment
		appointmentDate.set(2021, Calendar.APRIL, 31, 13, 00);
		
		// Check for illegal argument exception when a null Id is provided
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(null, appointmentDate, "A new appointment");
		});
	}
	
	// Requirement 1: Test 6: throw exception when using the setAppointmentID() method with an invalid id
	@Test
	void testSetInvalidAppointmentId() {
		
		// Create an empty appointment
		Appointment appointment = new Appointment();
		
		// throw exception with invalid Id
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appointment.setAppointmentId("1234567898765");
		});
	}
	
	// Requirement 1: Test 7: Throw exception when using the setAppointmentId() method with a null id
	@Test
	void testSetNullAppointmentId() {
		
		// Create an empty appointment
		Appointment appointment = new Appointment();
		
		// Test that the appointment class will not set a null value
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appointment.setAppointmentId(null);
		});
		
	}
	
	/* Requirement 2: The appointment object must have a required appointment Date field. 
	 *                The appointment cannot be in the past and cannot be null.
	 *                
	 * Test 1: Test that an appointment is created if the date provided is not in the past.
	 * Test 2: Test that an appointment can be updated with a valid date.
	 * Test 3: Test that an exception is thrown if the date provided for a new appointment is in the past.
	 * Test 4: Test that an exception is thrown if the appointment date is null for a new appointment.
	 * Test 5: Test that an exception is thrown when using the setAppointmentDate() method with an invalid date
	 * Test 6: Test that an exception is thrown when using the setAppointmentDate() method with a null id
	 * Test 7: Test that an appointment will not be scheduled for the same day if the hour has passed.
	 */
	
	// Requirement 2: Test 1: Test that an appointment is created if the date provided is not in the past or null
	@Test
	void testValidDateNewAppointment() {
		
		// Create a Calendar object
		Calendar appointmentDate = Calendar.getInstance();
		
		// Set the year, month, day, hour, and minute of new appointment
		appointmentDate.set(2021, Calendar.APRIL, 20, 00, 00);
		
		// Create a new appointment with valid fields
		Appointment appointment = new Appointment("12345654", appointmentDate, "A new appointment");
		
		// Test that the date was set 
		assertTrue(appointmentDate.equals(appointment.getAppointmentDate()));
	}
	
	// Requirement 2: Test 2: Test that an appointment can be updated with a valid date
	@Test
	void testUpdateValidDate() {
		
		// Create a Calendar object
		Calendar appointmentDate = Calendar.getInstance();
		
		// Set the year, month, day, hour, and minute of new appointment
		appointmentDate.set(2021, Calendar.APRIL, 20, 00, 00);
		
		// Create an empty appointment
		Appointment appointment = new Appointment();
		
		// Update the appointment date
		appointment.setAppointmentDate(appointmentDate);
		
		// Test that the appointment date was set
		assertTrue(appointment.getAppointmentDate().equals(appointmentDate));
	}
	
	/* Requirement 2: Test 3: Test that an exception is thrown when the date provided is
	 *  in the past for a new appointment. 
	 */
	@Test
	void testInvalidDateNewAppointment() {
		
		// Create a Calendar object
		Calendar appointmentDate = Calendar.getInstance();
		
		// Set the year, month, day, hour, and minute of new appointment
		appointmentDate.set(2021, Calendar.MARCH, 29, 00, 00);

		// Check for illegal argument exception when an invalid Id is provided
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345654", appointmentDate, "A new appointment");
		});
	}
	
	/* Requirement 2: Test 4: Test that an exception is thrown when an appointment
	 * date is null for a new appointment.
	 */
	@Test
	void testNullDateNewAppointment() {

		// Check for illegal argument exception when an invalid Id is provided
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345654", null, "A new appointment");
		});
	}
	
	/* Requirement 2: Test 5: Test that an exception is thrown when updating with an invalid
	 * date.
	 */
	@Test
	void testUpdateAppointmentInvalidDate() {
		
		// Create a Calendar object
		Calendar appointmentDate = Calendar.getInstance();
		
		// Set the year, month, day, hour, and minute of new appointment
		appointmentDate.set(2021, Calendar.MARCH, 20, 00, 00);
		
		// Create and empty appointment
		Appointment appointment = new Appointment();
		
		// Check for illegal argument exception when an invalid Id is provided
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appointment.setAppointmentDate(appointmentDate);
		});
	}
	
	// Requirement 2: Test 6: Test that an exception is thrown when updating with a null date
	 @Test
	 void testUpdateNullDate() {
		 
		// Create and empty appointment
		Appointment appointment = new Appointment();
			
		// Check for illegal argument exception when a null date is provided
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appointment.setAppointmentDate(null);
		});
	 }
	 
	 /* Requirement 2: Test 7: Check that the appointment will not be set for the same day if
	  * the hour has passed.
	  */
	 @Test
	 void testDateSameDayInvalidTime() {
		
		 // Create a Calendar object
		Calendar appointmentDate = Calendar.getInstance();
			
		// Set the date equal to the current time minus 1 hour
		appointmentDate.set(Calendar.HOUR, appointmentDate.get(Calendar.HOUR)-1);
			
		// Create an empty appointment
		Appointment appointment = new Appointment();
			
		// Check for illegal argument exception when an invalid Id is provided
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appointment.setAppointmentDate(appointmentDate);
		});
	 }
	 
	 /* Requirement 3: The appointment must have a required string field that does not
	  *                exceed 50 characters and cannot be null.
	  *                
	  * Test 1: Test that a new appointment is created with a valid appointment description
	  * Test 2: Test that an appointment is updated with a valid appointment description
	  * Test 3: Test that an exception is thrown when creating a new appointment with an
	  *         invalid description.
	  * Test 4: Test that an exception is thrown when setting an appointment with a null
	  *         description.
	  * Test 5: Test that an exception is thrown when updating an appointment with an invalid
	  *         description.
	  * Test 6: Test that an exception is thrown when updating an appointment with a null
	  * 		description.
	  */
	 
	 // Requirement 3: Test 1: Test that a new appointment is created with a valid description
	 @Test
	 void testNewAppointmentValidDescription() {
		 
		// Create a Calendar object
		Calendar appointmentDate = Calendar.getInstance();
		
		// Set the year, month, day, hour, and minute of new appointment
		appointmentDate.set(2021, Calendar.APRIL, 30, 13, 00);
			
		// Create a new appointment with valid fields
		Appointment appointment = new Appointment("123", appointmentDate, "A new appointment");
		
		// Test that the new description was set
		assertTrue(appointment.getDescription().equals("A new appointment"));
	 }
	 
	 /* Requirement 3: Test 2: Test that an appointment description is updated with a
	  * valid appointment description 
	  */
	 @Test
	 void testUpdateValidDescription() {
		 
		 // Create empty appointment and set description
		 Appointment appointment = new Appointment();
		 appointment.setDescription("A new appointment");
		 
		 // Test that the appointment description was set
		 assertTrue(appointment.getDescription().equals("A new appointment"));
	 }
	 
	 /* Requirement 3: Test 3: Test that an exception is thrown when creating a new appointment
	 * with an invalid description
	 */
	 @Test
	 void testNewAppointmentInvalidDescription() {
		
		 // Create a Calendar object
		Calendar appointmentDate = Calendar.getInstance();
			
		// Set the year, month, day, hour, and minute of new appointment
		appointmentDate.set(2021, Calendar.APRIL, 30, 13, 00);	 
		
		// Check for an exception with an invalid description that exceeds 50 characters
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("123", appointmentDate, "A description that exceeds 50 characters!!!!!!!!!!!!!!!!!!!!!!");
		});	
	 }
	 
	 /* Requirement 3: Test 4: Test that an exception is thrown when setting a new appointment
	  * with a null description
	  */
	 @Test
	 void testNewAppointmentNullDescription() {
		 
		 // Create a Calendar object
		Calendar appointmentDate = Calendar.getInstance();
			
		// Set the year, month, day, hour, and minute of new appointment
		appointmentDate.set(2021, Calendar.APRIL, 30, 13, 00);	 
		
		// Test for an exception when creating a new appointment with a null description
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("123", appointmentDate, null);
		});	 
	 }
	 
	 /* Requirement 3: Test 5: Test that an exception is thrown when updating a description
	  * with an invalid description
	  */
	 @Test 
	 void testUpdateInvalidDescription() {
		
		// Initialize an empty appointment
		Appointment appointment = new Appointment();
		
		// Test for an exception when setting the description with an invalid value
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appointment.setDescription("A desription that exceeds 50 characters!!!!!!!!!!!!!!!!!!!!!!");
		});	
	 }
	 
	 /* Requirement 3: Test 6: Test that an exception is thrown when updating an appointment
	  * with a null description
	  */
	 @Test
	 void testUpdateNullDescription() {
		
		 // Initialize an empty appointment
		Appointment appointment = new Appointment();
			
		// Test for an exception when setting the description with a null value
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appointment.setDescription(null);
		});	
	 }
}

