/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ucf.assignments;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Scanner;

public class ToDoModel {
    static ToDoList toDoList = new ToDoList();

    public ToDoList getToDoList() {
        return this.toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public static void saveList() {
        // save list to specified file name as a .csv
        // ex: getDesc() + "," + getDueDate + "," + getCompleted + "\n"

        // save all local files to appdata folder
        String fileName = System.getenv("APPDATA") + File.separator + "ToDoList" + File.separator + toDoList.getTitle() + ".csv";
        File listToSave = new File(fileName);

        // attempt to save to file
        try {
            Files.deleteIfExists(Path.of(listToSave.getPath()));
            listToSave.createNewFile();
            FileWriter fileWriter = new FileWriter(listToSave);

            // continue if list contains tasks
            if (!toDoList.toDoTasks.isEmpty()){
                for (ToDoTask task : toDoList.getToDoTasks()) {
                    StringBuilder s = new StringBuilder("\"" + task.getDescription() + "\"" + "," + "\"" + String.valueOf(task.getDueDate()) + "\"" + "," + "\"" + String.valueOf(task.getComplete()) + "\"" + "\n");
                    fileWriter.write(String.valueOf(s));
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void loadList(String fileName) {
        // try to read .csv file by separating description, due date, and completed by commas
        // catch if errors
        // create new task with data and add to toDoList

        // load list from appdata folder
        String path = System.getenv("APPDATA") + File.separator + "ToDoList" + File.separator;
        String fullPath = path + fileName + ".csv";

        // ensure the directory is present
        File dir = new File(path);
        if (!dir.exists()) dir.mkdir();

        // make file if doesnt exist and save
        File newFile = new File(fullPath);
        if (!newFile.exists()) {
            ToDoList missingList = new ToDoList(fileName);
            toDoList = missingList;
            saveList();
        }

        // load csv file and parse into tasks
        Scanner file = new Scanner(fullPath);
        ToDoList loadedList = new ToDoList(fileName);

        // use buffer reader to read csv
        try (BufferedReader br = new BufferedReader(new FileReader(fullPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 3) {
                    String description = values[0].substring(1, values[0].length() - 1);
                    LocalDate dueDate = LocalDate.parse(values[1].substring(1, values[1].length() - 1));
                    Boolean isComplete = Boolean.parseBoolean(values[2].substring(1, values[2].length() - 1));
                    loadedList.addTask(description, dueDate, isComplete);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // update list
        toDoList.setTitle(loadedList.getTitle());
        toDoList.setToDoTasks(loadedList.getToDoTasks());
    }
}