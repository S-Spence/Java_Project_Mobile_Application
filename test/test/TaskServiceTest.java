/* --------------------------------------------------------------------------------------------------------
 * Title: Task Service Tests
 * Date: 2021-03-28
 * Author: Sarah Spence
 * Description: This is the test class for the task service class. 
 *---------------------------------------------------------------------------------------------------------
 */
package test;
import task.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;

public class TaskServiceTest {
	
	/* Requirement 1: The task service must be able to add a task to the task list per
	 * unique Id. 
	 * Test 1: Add a new task to the list with a unique id.
	 * Test 2: Throw exception if the Id exists
	 */
	// Requirement 1: Test 1: Add a new task with a unique Id
	@Test
	public void addTask() {
		TaskService taskList = new TaskService(); // Instantiate a new task service list
		
		// Create two tasks with unique Ids
		Task task1 = new Task("12345654", "Task 1", "A new task");
		Task task2 = new Task("12345679", "Task 2", "Another task");
		
		// Add both tasks to the list
		taskList.addTask(task1);
		taskList.addTask(task2);
		
		// Test that two tasks were added to the task list
		assertTrue(taskList.getTaskList().size() == 2);	
	}
	
	// Requirement 1: Test 2: Throw exception if the task Id already exists
	@Test
	public void doNotAddTask() {
		TaskService taskList = new TaskService(); // Instantiate a new task service list
		
		// Create two tasks with the same ID
		Task task1 = new Task("12345659", "Task 1", "A new task");
		Task task2 = new Task("12345659", "Task 2", "Another task");
		
		// Add both tasks to the list
		taskList.addTask(task1);
		Assertions.assertThrows(UnsupportedOperationException.class, () ->{
			taskList.addTask(task2);
		});
	}
	
	/* Requirement 2: The task service shall be able to delete tasks per task Id
	 * Test 1: Delete task if the ID is valid
	 * Test 2: List remains unchanged when the task ID is invalid
	 */
	
	// Requirement 2: Test 1: Delete task if the ID is valid
	@Test
	public void deleteTask() {
		TaskService taskList = new TaskService(); // Instantiate a new task service list
		
		// Create two tasks with unique Ids
		Task task1 = new Task("12345654", "Task 1", "A new task");
		Task task2 = new Task("12345679", "Task 2", "Another task");
		
		// Add both tasks to the list
		taskList.addTask(task1);
		taskList.addTask(task2);
		
		// Delete one task from the list
		taskList.deleteTask("12345654");
		
		// Test that only one task remains in the list
		assertTrue(taskList.getTaskList().size() == 1);	
	}
	
	// Requirement 2: Test 2: List remains unchanged when the task ID is invalid
	@Test
	public void doNotDeleteTask() {
		TaskService taskList = new TaskService(); // Instantiate a new task service list
		
		// Create two tasks with unique Ids
		Task task1 = new Task("12345654", "Task 1", "A new task");
		Task task2 = new Task("12345679", "Task 2", "Another task");
		
		// Add both tasks to the list
		taskList.addTask(task1);
		taskList.addTask(task2);
		
		// Try to delete a task that does not exist
		taskList.deleteTask("123");
		
		// Test that two tasks remain in the list
		assertTrue(taskList.getTaskList().size() == 2);	
	}
	
	/* Requirement 3: The task service must be able to update task name and descriptions per task Id
	 * Test 1: update name when Id is valid
	 * Test 2: update description when Id is valid
	 * Test 3: throw exception when updating name with invalid ID
	 * Test 4: Throw exception when updating description with invalid ID
	 */
	
	// Requirement 3: Test 1: Update name when Id is valid
	@Test
	public void updateTaskName() {
		TaskService taskList = new TaskService(); // Instantiate a new task service list
		
		// Create two tasks with unique Ids
		Task task1 = new Task("12345654", "Task 1", "A new task");
		Task task2 = new Task("12345679", "Task 2", "Another task");
		
		// Add both tasks to the list
		taskList.addTask(task1);
		taskList.addTask(task2);
		
		// Update task name
		taskList.updateTaskName("12345654", "New name");
		
		// Test that the task name updated
		for(Task task : taskList.getTaskList()) {
			if(task.getTaskId().equals("12345654")) {
				assertTrue(task.getTaskName().equals("New name"));
			}
		}
	}
	
	// Requirement 3: Test 2: Update description when Id is valid
	@Test
	public void updateTaskDescription() {
		TaskService taskList = new TaskService(); // Instantiate a new task service list
		
		// Create two tasks with unique Ids
		Task task1 = new Task("12345654", "Task 1", "A new task");
		Task task2 = new Task("12345679", "Task 2", "Another task");
		
		// Add both tasks to the list
		taskList.addTask(task1);
		taskList.addTask(task2);
		
		// Update task description
		taskList.updateTaskDescription("12345654", "Another task description");
		
		// Test that the task description updated
		for(Task task : taskList.getTaskList()) {
			if(task.getTaskId().equals("12345654")) {
				assertTrue(task.getTaskDescription().equals("Another task description"));
			}
		}
	}
	
	// Requirement 3: Test 3: Throw exception when updating name with invalid ID
	@Test
	public void doNotUpdateTaskName() {
		TaskService taskList = new TaskService(); // Instantiate a new task service list
		
		// Create two tasks with unique Ids
		Task task1 = new Task("12345654", "Task 1", "A new task");
		Task task2 = new Task("12345679", "Task 2", "Another task");
		
		// Add both tasks to the list
		taskList.addTask(task1);
		taskList.addTask(task2);
		
		// Try to update a task name with an invalid ID
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskList.updateTaskName("123456", "New name");
		});
	}
	
	// Requirement 3: Test 4: Throw exception when updating description with invalid ID
	@Test
	public void doNotUpdateTaskDescription() {
		TaskService taskList = new TaskService(); // Instantiate a new task service list
		
		// Create two tasks with unique Ids
		Task task1 = new Task("12345654", "Task 1", "A new task");
		Task task2 = new Task("12345679", "Task 2", "Another task");
		
		// Add both tasks to the list
		taskList.addTask(task1);
		taskList.addTask(task2);
		
		// Try to update a task description with an invalid ID
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskList.updateTaskDescription("123456", "Something");
		});
	}
}

