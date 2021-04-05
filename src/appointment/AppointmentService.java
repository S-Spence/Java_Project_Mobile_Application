/* --------------------------------------------------------------------------------------------------------
 * Title: 5-1 Milestone Appointment Service
 * Date: 2021-04-01
 * Author: Sarah Spence
 * Course: CS 330
 * Instructor: Bryant Moscon
 * Description: This is the appointment service class. The class creates a new appointment list object containing 
 * 				appointment objects. The appointment service only adds appointments with a unique ID where the date
 * 				is available. The appointment service deletes appointments per unique Id.
 *---------------------------------------------------------------------------------------------------------
 */
package appointment;

import java.util.ArrayList;

public class AppointmentService {
	ArrayList<Appointment> appointments = new ArrayList<Appointment>(); // Array list to store appointments

	// Empty class constructor
	public AppointmentService() {
		
	}
	
	/* Method to add appointments to the appointment service with a unique Id
	 * @Param Appointment: a new appointment
	 */
	public void addAppointment(Appointment newAppointment) {
		
		/*  Check the appointment list to see if the appointment time is available.
		 *  Then, Check the appointment list for the appointment ID and throw exception if found.
		 */
		for(Appointment appointment : appointments) {
			if(newAppointment.getAppointmentDate().equals(appointment.getAppointmentDate())) {
				throw new UnsupportedOperationException("The appointment date is not available. Please select another time.");
			}
			if(newAppointment.getAppointmentId().equals(appointment.getAppointmentId())) {
				throw new UnsupportedOperationException("The appointment ID already exists");		
			}
		}	
		appointments.add(newAppointment);   // Add new appointment if ID not found
	}
	
	/* Delete an appointment from the list per appointment ID
	 * @Param String appointment Id
	 */
	public void deleteAppointment(String appointmentId) {
		
		/* Remove appointment if ID is found. Included return statement after removal to work
		*  around concurrent modification error
		*/
		for(Appointment appointment : appointments) {
			if(appointment.getAppointmentId().equals(appointmentId)) {
				appointments.remove(appointment);
				return;
			}
		}
	}
	
	// Method to return the appointment list
	public ArrayList<Appointment> getAppointmentList(){
		return this.appointments;
	}
}
	
