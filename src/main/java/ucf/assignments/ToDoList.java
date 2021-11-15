/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ucf.assignments;

import java.time.LocalDate;
import java.util.Collection;

public class ToDoList {

    // setup vars
    String title;
    Collection<ToDoTask> ToDoTasks;


    // mutators & accessors
    public Collection<ToDoTask> getToDoTasks() {
        return ToDoTasks;
    }

    public void setToDoTasks(Collection<ToDoTask> ToDoTasks) {
        this.ToDoTasks = ToDoTasks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addTask(String description, LocalDate dueDate, boolean isComplete) {
        // create new task
        // update data using mutators
        // add task to tasks collection
    }
    public void removeTask(String description) {
        // look for task in collection with description
        // remove task if found
    }
}