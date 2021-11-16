/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ucf.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ToDoListTest {

    @Test
    void addTask() {
        // call add task from todolist class with test data
        // create a new task with same test data
        // check if task list has a task with same test data
        ToDoList testList = new ToDoList();
        ToDoTask testTask = new ToDoTask("TestTask", LocalDate.of(2022, 6, 20), true);
        testList.addTask("TestTask", LocalDate.of(2022, 6, 20), true);
        Assertions.assertTrue(testList.getToDoTasks().contains(testTask));
    }

    @Test
    void removeTask() {
        // call add task from todolist class with test data
        // create a new task with same test data
        // check if task list does not have a task with same test data
        ToDoList testList = new ToDoList();
        ToDoTask testTask = new ToDoTask("TestTask", LocalDate.of(2022, 6, 20), true);
        testList.addTask("TestTask", LocalDate.of(2022, 6, 20), true);
        testList.removeTask(testTask.getDescription());
        Assertions.assertFalse(testList.getToDoTasks().contains(testTask));
    }
}