/* --------------------------------------------------------------------------------------------------------
 * Title: Appointments
 * Date: 2021-04-01
 * Author: Sarah Spence
 * Description: This is the appointment class. The class creates a new appointment object containing a unique 
 * 		appointment ID, an appointment date, and an appointment description. The appointment ID is 
 * 		immutable once set. 
 *---------------------------------------------------------------------------------------------------------
 */
package appointment;

import java.util.Calendar;

public class Appointment {
	String appointmentId;        // Variable for appointment Id
	Calendar appointmentDate;    // Variable for appointment date
	String description;          // Variable for appointment description
	
	// Initialize an empty constructor
	public Appointment() {
		
	}
	
	/* Overloaded constructor parameterized with exception handling for invalid arguments.
	 * @Param String appointment Id
	 * @Param Calendar appointment date
	 * @Param String appointment description
	 */
	public Appointment(String appointmentId, Calendar appointmentDate, String description) {
		
		// Throw exception if the Id is already set
		if(this.appointmentId != null) {
			throw new UnsupportedOperationException("The appointment Id is not updateable");
		}
		// Ensure the appointment ID is 10 characters or less and is not null
		else if(appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("The appointment ID cannot exceed 10 characters and cannot be null.");
		}
		else {
			this.appointmentId = appointmentId;
		}
		
		// Ensure the appointment date is not in the past and is not null
		if(appointmentDate == null || appointmentDate.before(Calendar.getInstance())) {
			throw new IllegalArgumentException("The date cannot be in the past and cannot be null");
		}
		else {
			this.appointmentDate = appointmentDate;
		}
		
		// Ensure the description is 50 characters or less and is not null
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("The description cannot exceed 50 characters and cannot be null.");
		}
		else {
			this.description = description;
		}
	}
	
	/*Methods to set the id, date, and description for an appointment*/
	
	/* Set appointment Id. Handle exceptions for null and invalid arguments
	 * @Param String appointment Id
	 */
	public void setAppointmentId(String appointmentId) {
		
		/* Throw an exception if the appointment is already set or the value provided is
		** invalid or null
		*/
		if(this.appointmentId != null) {
			throw new UnsupportedOperationException("The appointment Id is not updateable.");
		}
		else if(appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("The appointment Id cannot exceed 10 characters and cannot be null.");
		}
		else {
			this.appointmentId = appointmentId;
		}
		
	}
	
	/* Set appointment date if the date is not in the past (yyyy/mm/dd) and is not null
	 * @Param Calendar appointment date
	 */
	public void setAppointmentDate(Calendar appointmentDate) {
		
		// Throw exception if the appointment date is in the past or null
		if(appointmentDate == null || appointmentDate.before(Calendar.getInstance())) {
			throw new IllegalArgumentException("The date cannot be in the past and cannot be null.");
		}
		else {
			this.appointmentDate = appointmentDate;
		}
	}
	
	/* Set the appointment description if it is 50 characters or less and is not null
	 * @Param String description
	 */
	public void setDescription(String description) {
		
		// Throw exception if the description exceeds 50 characters or is null
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("The description cannot exceed 50 characters and cannot be null.");
		}
		else {
			this.description = description;
		}
	}
	
	/* Methods to return class values */
	
	// Get appointment Id
	public String getAppointmentId() {
		return this.appointmentId;
	}
	
	// Get appointment date
	public Calendar getAppointmentDate() {
		return this.appointmentDate;
	}
	
	// Get appointment description
	public String getDescription() {
		return this.description;
	}
}
