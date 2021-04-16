/* --------------------------------------------------------------------------------------------------------
 * Title: Tasks
 * Date: 2021-03-28
 * Author: Sarah Spence
 * Description: This is the task class. The class creates a new task object containing a unique task ID,
 *              a task name, and a task description. The task ID is immutable once set. The values cannot
 *              be null.  
 *---------------------------------------------------------------------------------------------------------
 */
package task;

public class Task {
	String taskId;          // Task ID
	String taskName;        // Task name
	String taskDescription; // Task description 
	
	// Empty class contructor
	public Task() {
		
	}
	
	/* Overloaded Constructor (parameterized) with exception handling for invalid arguments
	 * @Param String task Id
	 * @Param String task name
	 * @Param String task description
	 */
	
	public Task(String taskId, String taskName, String taskDescription) {
		
		// Throw exception if the task id is already set
		if(this.taskId != null) {
			throw new UnsupportedOperationException("The task ID is not updateable");
			
		}
		// Set the task Id if it is not null and does not exceed 10 characters
		else if (taskId != null && taskId.length() <= 10) {
			this.taskId = taskId;
		}
		else {
			throw new IllegalArgumentException("The task ID cannot exceed 10 characters and cannot be null.");
		}
		
		// Set the task name if it is not null and does not exceed 20 characters
		if (taskName != null && taskName.length() <= 20) {
			this.taskName = taskName;
		}
		else {
			throw new IllegalArgumentException("The task name cannot exceed 20 characters and cannot be null.");
		}
		
		// Set the task description if it is not null and does not exceed 50 characters
		if (taskDescription != null && taskDescription.length() <= 50) {
			this.taskDescription = taskDescription;
		}
		else {
			throw new IllegalArgumentException("The task description cannot exceed 50 characters and cannot be null");
		}	
	}
	
	/* Methods to set the task Id, name and description*/
	
	/* Set task Id
	 * @Param String taskId: 10 characters or less
	 */
	public void setTaskId(String taskId) {
		
		// Throw exception if the task id is already set
		if(this.taskId != null) {
			throw new UnsupportedOperationException("The task ID is not updateable");
			
		}
		// Set the task Id if it is not null and does not exceed 10 characters, else throw exception
		else if (taskId != null && taskId.length() <= 10) {
			this.taskId = taskId;
		}
		else {
			throw new IllegalArgumentException("The task ID cannot exceed 10 characters and cannot be null.");
		}
		
	}
	/* Set task name
	 * @Param String taskName: The name of the current task (20 characters or less)
	 */
	public void setTaskName(String taskName) {
		if(taskName != null && taskName.length() <= 20) {
			this.taskName = taskName;
		}
		else {
			throw new IllegalArgumentException("The task name cannot exceed 20 characters and cannot be null.");
		}
	}
	
	/* Set task description
	 * @Param taskDescription: The description of the current task (50 characters or less) 
	 */
	public void setTaskDescription(String taskDescription) {
		if(taskDescription != null && taskDescription.length() <= 50) {
			this.taskDescription = taskDescription;
		}
		else {
			throw new IllegalArgumentException("The task description exceed 50 characters and cannot be null.");
		}
	}
	
	/* Methods to return task Id, name, and description */
	
	// Get task Id
	public String getTaskId() {
		return this.taskId;
	}
	
	// Get task name
	public String getTaskName() {
		return this.taskName;
	}
	
	// Get task description
	public String getTaskDescription() {
		return this.taskDescription;
	}
}
