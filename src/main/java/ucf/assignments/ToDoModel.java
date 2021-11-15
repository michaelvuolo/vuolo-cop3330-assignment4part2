/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ucf.assignments;

import java.util.ArrayList;
import java.util.Collection;

public class ToDoModel {
    Collection<ToDoList> toDoList = new ArrayList<>();

    public Collection<ToDoList> getToDoList() {
        return toDoList;
    }

    public void markTaskCompleted(String title, String description) {
        // loop through tasks collection
        // if title and description match then mark completed
    }

    public void removeToDoTask(String title, String description) {
        // loop through tasks collection
        // if title and description match then remove from list
    }

    public void removeList(String title) {
        // loop through list
        // check if title matches, then remove list

    }

    public void addList() {
        // create new list with empty data
        // add list to toDoList
    }

    public void saveList(String fileName) {
        // save list to specified file name as a .csv
        // ex: getDesc() + "," + getDueDate + "," + getCompleted + "\n"
    }

    public void saveAll() {
        // loop through each list and save it with saveList()

    }

    public void loadList(String fileName) {
        // try to read .csv file by separating description, due date, and completed by commas
        // catch if errors
        // create new task with data and add to toDoList
    }

    public void loadAll() {
        // read lists from file using loadList()
    }
}