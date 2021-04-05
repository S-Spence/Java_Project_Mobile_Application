/* --------------------------------------------------------------------------------------------------------
 * Title: 5-1 Milestone Appointment Service
 * Date: 2021-04-01
 * Author: Sarah Spence
 * Course: CS 330
 * Instructor: Bryant Moscon
 * Description: This file contains the test cases for the appointment service class.
 *---------------------------------------------------------------------------------------------------------
 */
package test;

import appointment.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

	/* Requirement 1: The appointment service shall be able to add appointments with a unique
	 *                appointment Id.
	 * Test 1: Add a new appointment to the appointment list with a unique Id and available date
	 * Test 2: Throw an exception when adding an appointment with an invalid Id
	 * Test 3: Throw an exception when adding an appointment with an unavailable date
	 */
	
	/* Requirement 1: Test 1: Add a new appointment to the appointment list with a unique Id
	*  and an available date.
	*/
	@Test
	void testAddNewAppointment() {
		
		// Initialize a new appointment service list
		AppointmentService appointmentList = new AppointmentService();
		
		// Create dates for the appointments
		Calendar appointment1Date = Calendar.getInstance();
		Calendar appointment2Date = Calendar.getInstance();
		Calendar appointment3Date = Calendar.getInstance();
			
		// Set the year, month, day, hour, and minute of new appointments
		appointment1Date.set(2021, Calendar.APRIL, 30, 13, 00);
		appointment2Date.set(2021, Calendar.APRIL, 29, 10, 00);
		appointment3Date.set(2021, Calendar.APRIL, 15, 12, 00);
		
		// Create new appointments to add to the list
		Appointment appointment1 = new Appointment("123", appointment1Date, "Appointment 1" );
		Appointment appointment2 = new Appointment("321", appointment2Date, "Appointment 2");
		Appointment appointment3 = new Appointment("234", appointment3Date, "Appointment 3");
		
		// Add the values to the list
		appointmentList.addAppointment(appointment1);
		appointmentList.addAppointment(appointment2);
		appointmentList.addAppointment(appointment3);
		
		// Test that all three appointments were added to the list
		assertTrue(appointmentList.getAppointmentList().size() == 3);
	}
	
	/* Requirement 1: Test 2: Throw an exception when adding an appointment with an Id that is
	*  already in the list
	*/
	@Test
	void testAddNewAppointmentExistingId() {
		
		// Initialize a new appointment service list
		AppointmentService appointmentList = new AppointmentService();
		
		// Create dates for the appointments
		Calendar appointment1Date = Calendar.getInstance();
		Calendar appointment2Date = Calendar.getInstance();
		Calendar appointment3Date = Calendar.getInstance();
			
		// Set the year, month, day, hour, and minute of new appointments
		appointment1Date.set(2021, Calendar.APRIL, 30, 13, 00);
		appointment2Date.set(2021, Calendar.APRIL, 29, 10, 00);
		appointment3Date.set(2021, Calendar.APRIL, 15, 12, 00);
		
		// Create new appointments to add to the list
		Appointment appointment1 = new Appointment("123", appointment1Date, "Appointment 1" );
		Appointment appointment2 = new Appointment("321", appointment2Date, "Appointment 2");
		Appointment appointment3 = new Appointment("123", appointment3Date, "Appointment 3");
		
		// Add the first two values to the list
		appointmentList.addAppointment(appointment1);
		appointmentList.addAppointment(appointment2);
		
		// Test that an exception is thrown when the Id is already in the list
		Assertions.assertThrows(UnsupportedOperationException.class, () ->{
			appointmentList.addAppointment(appointment3);
		});
	}
	
	/* Requirement 1: Test 3: Test that an exception is thrown when adding a new appointment
	 * with an unavailable date
	 */
	@Test
	void addAppointmentDateUnavailable() {
		
		// Initialize a new appointment service list
		AppointmentService appointmentList = new AppointmentService();
		
		// Create dates for the appointments
		Calendar appointment1Date = Calendar.getInstance();
		Calendar appointment2Date = Calendar.getInstance();
		Calendar appointment3Date = Calendar.getInstance();
			
		// Set the year, month, day, hour, and minute of new appointments
		appointment1Date.set(2021, Calendar.APRIL, 30, 13, 00);
		appointment2Date.set(2021, Calendar.APRIL, 29, 10, 00);
		appointment3Date.set(2021, Calendar.APRIL, 30, 13, 00);
		
		// Create new appointments to add to the list
		Appointment appointment1 = new Appointment("123", appointment1Date, "Appointment 1" );
		Appointment appointment2 = new Appointment("321", appointment2Date, "Appointment 2");
		Appointment appointment3 = new Appointment("124", appointment3Date, "Appointment 3");
		
		// Add the first two values to the list
		appointmentList.addAppointment(appointment1);
		appointmentList.addAppointment(appointment2);
		
		// Test that an exception is thrown when the date is already scheduled
		Assertions.assertThrows(UnsupportedOperationException.class, () ->{
			appointmentList.addAppointment(appointment3);
		});
	}
	
	
	/* Requirement 2: The appointment service shall be able to delete an appointment per
	 *                appointment Id. 
	 * Test 1: Delete an appointment from the list with a valid Id
	 * Test 2: Test that the list remains unchanged when deleting with an invalid Id
	 */
	
	// Requirement 2: Test 1: Delete an appointment from the list with a valid Id
	@Test
	void testDeleteAppointmentValidId() {
		
		// Initialize a new appointment service list
		AppointmentService appointmentList = new AppointmentService();
		
		// Create dates for the appointments
		Calendar appointment1Date = Calendar.getInstance();
		Calendar appointment2Date = Calendar.getInstance();
		Calendar appointment3Date = Calendar.getInstance();
			
		// Set the year, month, day, hour, and minute of new appointments
		appointment1Date.set(2021, Calendar.APRIL, 30, 13, 00);
		appointment2Date.set(2021, Calendar.APRIL, 29, 10, 00);
		appointment3Date.set(2021, Calendar.APRIL, 20, 12, 00);
		
		// Create new appointments to add to the list
		Appointment appointment1 = new Appointment("111", appointment1Date, "Appointment 1" );
		Appointment appointment2 = new Appointment("222", appointment2Date, "Appointment 2");
		Appointment appointment3 = new Appointment("333", appointment3Date, "Appointment 3");
		
		// Add the values to the list
		appointmentList.addAppointment(appointment1);
		appointmentList.addAppointment(appointment2);
		appointmentList.addAppointment(appointment3);
		
		// Delete an appointment from the list by appointment Id
		appointmentList.deleteAppointment("333");
		
		// Test that the list contains only two appointments
		assertTrue(appointmentList.getAppointmentList().size() == 2);
	}
	
	/* Requirement 2: Test 2: Test that list remains unchanged when deleting with an 
	*  invalid Id.
	*/
	@Test
	void testDeleteAppointmentInvalidId() {
		
		// Initialize a new appointment service list
		AppointmentService appointmentList = new AppointmentService();
		
		// Create dates for the appointments
		Calendar appointment1Date = Calendar.getInstance();
		Calendar appointment2Date = Calendar.getInstance();
		Calendar appointment3Date = Calendar.getInstance();
			
		// Set the year, month, day, hour, and minute of new appointments
		appointment1Date.set(2021, Calendar.APRIL, 30, 13, 00);
		appointment2Date.set(2021, Calendar.APRIL, 29, 10, 00);
		appointment3Date.set(2021, Calendar.APRIL, 20, 12, 00);
		
		// Create new appointments to add to the list
		Appointment appointment1 = new Appointment("123", appointment1Date, "Appointment 1" );
		Appointment appointment2 = new Appointment("321", appointment2Date, "Appointment 2");
		Appointment appointment3 = new Appointment("124", appointment3Date, "Appointment 3");
		
		// Add the first values to the list
		appointmentList.addAppointment(appointment1);
		appointmentList.addAppointment(appointment2);
		appointmentList.addAppointment(appointment3);
		
		// Delete an appointment from the list with invalid Id
		appointmentList.deleteAppointment("127");
		
		// Test that the list remains unchanged
		assertTrue(appointmentList.getAppointmentList().size() == 3);
	}
}

