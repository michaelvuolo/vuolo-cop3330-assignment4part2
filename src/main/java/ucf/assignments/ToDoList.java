/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ucf.assignments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ToDoList {

    // setup vars
    String title;
    Collection<ToDoTask> toDoTasks;

    // constructors
    public ToDoList() {
        this("New List", Collections.emptyList());
    }

    public ToDoList(String listTitle) {
        this(listTitle, Collections.emptyList());
    }

    public ToDoList(String title, Collection<ToDoTask> tasks) {
        this.title = title;
        this.toDoTasks = tasks;
    }

    // mutators & accessors
    public Collection<ToDoTask> getToDoTasks() {
        return this.toDoTasks;
    }

    public void setToDoTasks(Collection<ToDoTask> toDoTasks) {
        this.toDoTasks = toDoTasks;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addTask(String description, LocalDate dueDate, boolean isComplete) {
        // create new task
        // update data using mutators
        // add task to tasks collection
        ToDoTask task = new ToDoTask(description, dueDate, isComplete);
        this.toDoTasks.add(task);
    }

    public void removeTask(String description) {
        // look for task in collection with description
        // remove task if found
        if (!toDoTasks.isEmpty()) toDoTasks.removeIf(task -> description.equals(task.getDescription()));
    }

    public Collection<ToDoTask> getCompleteToDoTasks() {
        // setup empty tasks arr
        Collection<ToDoTask> completedTasks = Collections.emptyList();

        // populate tasks with completed tasks
        if (!toDoTasks.isEmpty()) for (ToDoTask task : toDoTasks) if (task.getComplete()) completedTasks.add(task);
        return completedTasks;
    }

    public Collection<ToDoTask> getIncompleteToDoTasks() {
        // setup empty tasks arr
        Collection<ToDoTask> incompleteTasks = new ArrayList<>();

        // populate tasks with incomplete tasks
        if (!toDoTasks.isEmpty()) for (ToDoTask task : toDoTasks) if (!task.getComplete()) incompleteTasks.add(task);
        return incompleteTasks;
    }
}