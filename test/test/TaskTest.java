/* --------------------------------------------------------------------------------------------------------
 * Title: 4-1 Milestone Task Service
 * Date: 2021-03-28
 * Author: Sarah Spence
 * Course: CS 330
 * Instructor: Bryant Moscon
 * Description: This is the test class for the task class.  
 *---------------------------------------------------------------------------------------------------------
 */
package test;

import task.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

	/*Requirement 1: The task object shall have a required unique ID that is not longer than 10 characters 
	 *               and is not null. The task Id is not updateable.
	 * Test 1: set the task Id in a new task when the ID is 10 characters or less and is not null
	 * Test 2: set the task Id in the setTaskId() method with a valid Id
	 * Test 3: throw exception when trying to update an already set task Id
	 * Test 4: throw exception when creating a new task with an invalid Id
	 * Test 5: throw exception when creating a new task with a null Id
	 * Test 6: throw exception when passing an invalid task id to the setTaskId() method
	 * Test 7: throw exception when passing a null Id to the setTaskId() method
	 */
	// Requirement 1: Test 1: Set a valid contact Id of 10 characters or less
	@Test
	void testValidTaskID() {
		Task task = new Task("1234543", "Task 1", "A new task");
		assertTrue(task.getTaskId().equals("1234543"));	
	}
	
	// Requirement 1: Test 2: set the task Id in the setTaskId() method with a valid Id
	@Test
	void testSetValidTaskId() {
		
		// Create an empty task
		Task task = new Task();
		
		// Set the task Id
		task.setTaskId("123");
		
		// Test that the task Id set
		assertTrue(task.getTaskId().equals("123"));
	}
	
	// Requirement 1: Test 3: Throw exception when trying to set a task Id that is already set
	@Test
	void testAlreadySetTaskId() {
		
		// Create a new task with a set Id
		Task task = new Task("123", "Task 1", "A new task");
		
		// check for exception when the Id is too long
		Assertions.assertThrows(UnsupportedOperationException.class, () ->{
			task.setTaskId("111");
		});
	}
	
	// Requirement 1: Test 4: Throw exception when creating a new task with an invalid Id
	@Test
	void testInvalidTaskID() {
		
		// check for exception when the Id is too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("12345678910", "Task 1", "A new task");
		});
	}
	
	// Requirement 1: Test 5: Throw exception when creating a new task with a null Id
	@Test
	void testNullTaskID() {
		
		// check for exception when the Id is too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task(null, "Task 1", "A new task");
		});
	}
	
	// Requirement 1: Test 6: Throw exception when try to use the setTaskId() method with an invalid Id
	@Test
	void testSetInvalidTaskId() {
		
		// Create an empty task
		Task task = new Task();
		
		// check for exception when the Id is too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task.setTaskId("123123123123");
		});
	}
	
	// Requirement 1: Test 7: Throw exception when try to use the setTaskId() method with a null Id
	@Test
	void testSetNullTaskId() {
		
		// Create an empty task
		Task task = new Task();
		
		// check for exception when the Id is too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task.setTaskId(null);
		});
	}
		
	/* Requirement 2: The task object shall have a required task name that is not longer than 20 characters
	 *               and is not null. 
	 * Test 1: tests that a new object is created with a valid task name
	 * Test 2: tests that the setTaskName() method with a valid task name
	 * Test 3: throw an exception when a new task name is too long
	 * Test 4: throw exception when the a new task name is null
	 * Test 5: throw exception when using the setTaskName() method with an invalid task name
	 * Test 6: throw exception when using the setTaskName() method with a null task name
	 */
	// Requirement 2: Test 1: Tests that a new object is created with a valid task name
	@Test
	void testValidTaskName() {
		Task task = new Task("1234323", "Task 1", "A new task");
		assertTrue(task.getTaskName().equals("Task 1"));
	}
	
	// Requirement 2: Test 2: Tests the setTaskName() method with a valid task name
	@Test
	void testUpdateValidTaskName() {
		Task task = new Task("123432", "Task 1", "A new task");
		task.setTaskName("Task 2");
		assertTrue(task.getTaskName().equals("Task 2"));
	}
	
	/* Requirement 2: Test 3: Throw exception when a new task name is invalid
	 */
	@Test
	void testInvalidTaskName() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("123456789", "Task that is longer than twenty characters", "A new task");
		});	
	}
	
	/* Requirement 2: Test 4: Throw exception when a new task name is null
	 */
	@Test
	void testNullTaskName() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("123456789", null, "A new task");
		});	
	}
	
	/* Requirement 2: Test 5: Throw exception when using the setTaskName() method with an invalid
	 * name
	 */
	@Test
	void testSetInvalidTaskName() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task.setTaskName("A task name that is longer than twenty characters");
		});
	}
	
	// Requirement 2: Test 6: Throw exception when using the setTaskName() method with a null name
	@Test
	void testSetNullTaskName() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task.setTaskName(null);
		});
	}
	
	/* Requirement 3: The task object shall have a required task description that is not null and is not 
	 *                longer than 50 characters. 
	 * Test 1: test that a new object is created with a valid task description
	 * Test 2: test the setTaskDescription() method with a valid description
	 * Test 3: throw an exception when the task description is too long
	 * Test 4: throw an exception when the task description is null
	 * Test 5: throw an exception when the task description is too long in the setTaskDescription() method
	 * Test 6: throw an exception when the task description is null in the setTaskDescription() method
	 */
	
	//Requirement 3: Test 1: Tests that a new object is created with a valid task description
	@Test
	void testValidTaskDescription() {
		Task task = new Task("1234323", "Task 1", "A new task");
		assertTrue(task.getTaskDescription().equals("A new task"));
		
	}
	
	//Requirement 3: Test 2: Tests the setTaskDescription() method with a valid task description 
	@Test
	void testUpdateValidTaskDescription() {
		Task task = new Task("123432", "Task 1", "A new task");
		task.setTaskDescription("A new task description");
		assertTrue(task.getTaskDescription().equals("A new task description"));
	}
	
	// Requirement 3: Test 3: Throw an exception when the task description is too long in a new task
	@Test
	void testInvalidTaskDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("123456789", "Task 1", "A new task that is longer than 50 characters and will trigger the exception");
		});	
	}
	
	// Requirement 3: Test 4: Throw an exception when the task description is too long in a new task
	@Test
	void testNullTaskDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("123456789", "Task 1", null);
		});	
	}
	
	/*Requirement 3: Test 5: Throw exception when the task description is too long in the setTaskDescription()
	 * method
	 */
	@Test
	void testSetInvalidTaskDescription() {
		Task task = new Task("12345675", "Task 1", "A new task");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task.setTaskDescription("A task description that is longer than 50 characters to trigger the exception");
		});
	} 
	
	/*Requirement 3: Test 6: Throw exception when the task description is null in the setTaskDescription()
	 * method
	 */
	@Test
	void testSetNullTaskDescription() {
		Task task = new Task("12345675", "Task 1", "A new task");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task.setTaskDescription(null);
		});
	} 
}
