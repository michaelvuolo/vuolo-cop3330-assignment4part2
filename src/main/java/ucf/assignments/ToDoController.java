/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ucf.assignments;

import java.time.LocalDate;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class ToDoController {

    @FXML
    ObservableList ToDoList = FXCollections.observableArrayList();

    @FXML
    private ListView<String> lvTitles;

    @FXML
    private TableView<ToDoList> tableView;
    @FXML
    private TableColumn<ToDoList, String> colDescription;
    @FXML
    private TableColumn<ToDoList, LocalDate> colDueDate;
    @FXML
    private TableColumn<ToDoList, Boolean> colCompleted;

    @FXML
    private TextField txtNewDescription;
    @FXML
    private DatePicker dtNewDueDate;
    @FXML
    private CheckBox chkbxNewCompleted;

    @FXML
    private ToDoList activeToDoList;
    @FXML
    private ToDoTask activeToDoTask;

    @FXML
    public void refreshTitleList() {
        // remove all tasks from list
        // add all tasks to display from list
    }

    @FXML
    public void refreshToDoTasks() {
        // reset view
        // add tasks from tasks class
    }

    @FXML
    public void btnSaveClicked(ActionEvent actionEvent) {
        // call saveAll()
    }

    @FXML
    public void btnLoadClicked(ActionEvent actionEvent) {
        // call loadAll()
    }

    @FXML
    public void btnDeleteListClicked(ActionEvent actionEvent) {
        // call removeList() with title
    }

    @FXML
    public void btnDeleteToDoTaskClicked(ActionEvent actionEvent) {
        // call removeToDoTask() with title and description
    }

    @FXML
    public void btnMarkCompleteClicked(ActionEvent actionEvent) {
        // call markTaskCompleted() with title and description
    }

    @FXML
    public void btnNewTaskClicked(ActionEvent actionEvent) {
        // call addTask to create list with data
        // refresh view
    }

    @FXML
    public void listTitleClicked(MouseEvent mouseEvent) {
        // edit title of list
        // refresh view
    }

    @FXML
    public void btnCreateNewListClicked(ActionEvent actionEvent) {
        // call addList()
    }

    @FXML
    public void btnSaveListClicked(ActionEvent actionEvent) {
        //call saveList() with title
    }

    public void initialize(URL url, ResourceBundle rb) {
        // create new ToDoModel class
        // setup data on tableview columns
        // refresh to display tasks
    }
}