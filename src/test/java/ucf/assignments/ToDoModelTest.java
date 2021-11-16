/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ucf.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class ToDoModelTest {

    @Test
    void loadAll() {
        // create a new list and reset it
        // load test lists from file
        // check whether lists exists
    }

    @Test
    void loadList() {
        // create a new list and reset it
        // load test list from file
        // check whether list exists
        ToDoModel app = new ToDoModel();
        app.getToDoList().setTitle("Test");
        app.saveList();

        app.getToDoList().setTitle("newTest");
        app.loadList("Test");

        // check if loaded
        Assertions.assertEquals(app.getToDoList().getTitle(), "Test");
        String filepath = System.getenv("APPDATA") + File.separator + "ToDoList" + File.separator + "Test.csv";
        File file = new File(filepath);

        // cleanup
        file.delete();
    }

    @Test
    void saveAll() {
        // create a new list and reset it
        // save test lists to file
        // check whether file exists
    }

    @Test
    void saveList() {
        // create a new list and reset it
        // save test list to file
        // check whether file exists
        ToDoModel app = new ToDoModel();
        app.getToDoList().setTitle("Test");
        app.saveList();
        String path = System.getenv("APPDATA") + File.separator + "ToDoList" + File.separator + "Test.csv";
        File file = new File(path);

        // ensure file exists
        Assertions.assertTrue(file.exists());

        // cleanup
        file.delete();
    }

    @Test
    void addList() {
        // add test task to list
        // check whether task is added in list
    }

    @Test
    void removeList() {
        // add test list
        // remove test list
        // check whether list is removed
    }

    @Test
    void removeToDoTask() {
        // add test task to list
        // remove test task from list
        // check whether task is removed from list
    }

    @Test
    void markTaskCompleted() {
        // add test task to list
        // update test task and mark as completed
        // check whether task is marked complete
    }
}