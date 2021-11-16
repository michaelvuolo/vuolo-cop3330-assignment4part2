/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class ToDoTask {

    // setup vars
    String description;
    LocalDate dueDate;
    Boolean complete;

    // constructors
    public ToDoTask(String description, LocalDate dueDate, boolean complete) {
        this.description = description;
        this.dueDate = dueDate;
        this.complete = complete;
    }

    // mutators & accessors
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}