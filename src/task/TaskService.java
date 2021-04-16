/* --------------------------------------------------------------------------------------------------------
 * Title: Task Service
 * Date: 2021-03-28
 * Author: Sarah Spence
 * Description: This is the task service class. The class creates a new task list. This class also adds,
 *              deletes, and updates tasks in the task list.  
 *---------------------------------------------------------------------------------------------------------
 */
package task;
import java.util.*;

public class TaskService {
	ArrayList<Task> tasks = new ArrayList<Task>(); // Array list to store tasks
	
	// Empty Class Constructor
	public TaskService(){
		
	}
	
	// Get task list
	public ArrayList<Task> getTaskList() {
		return this.tasks;
	}
	
	/* Add a new task to the task list with a unique ID
	 * @Param Task a new task
	 */
	public void addTask(Task newTask) {
		
		// Check the task list for the task ID and throw exception if found
		for(Task task : tasks) {
			if(newTask.getTaskId() == task.getTaskId()) {
				throw new UnsupportedOperationException("The task ID already exists");		
			}
		}
		tasks.add(newTask);   // Add new task if ID not found
	}
	
	/* Delete a task from the task list per task ID
	 * @Param String taskId
	 */
	public void deleteTask(String taskId) {
		
		/* Remove task if ID is found, included return statement after removal to work around
		* concurrent modification error
		*/
		for(Task task : tasks) {
			if(task.getTaskId() == taskId) {
				tasks.remove(task);
				return;
			}
		}
	}
	
	
	/* Update name per task Id
	 * @Param String taskId
	 * @Param String taskName
	 */
	public void updateTaskName(String taskId, String name) {
		boolean found = false;   // Boolean to check if task not found
		
		// Search for task Id and update name if found
		for(Task task : tasks) {
			if(task.getTaskId() == taskId) {
				task.setTaskName(name);
				found = true;	
			}
		}
		// Throw exception when the task Id is invalid
		if(found == false) {
			throw new IllegalArgumentException("The task Id is invalid");		
		}
	}
	
	/* Update description per task Id
	 * @Param String taskId
	 * @Param String description
	 */
	public void updateTaskDescription(String taskId, String description) {
		boolean found = false;   // Boolean to check if task not found
		
		// Search for task Id and update name if found
		for(Task task : tasks) {
			if(task.getTaskId() == taskId) {
				task.setTaskDescription(description);
				found = true;	
			}
		}
		// Throw exception when the task Id is invalid
		if(found == false) {
			throw new IllegalArgumentException("The task Id is invalid");		
		}
	}
}
