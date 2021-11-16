/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ucf.assignments;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.net.URL;

public class ToDoController implements Initializable {

    // setup model reference
    static ToDoModel toDoModel = new ToDoModel();

    @FXML
    private TableView<ToDoTask> tableView;
    @FXML
    private TableColumn<ToDoTask, String> colDescription;
    @FXML
    private TableColumn<ToDoTask, LocalDate> colDueDate;
    @FXML
    private TableColumn<ToDoTask, Boolean> colCompleted;

    @FXML
    private TextField txtNewDescription;
    @FXML
    private DatePicker dtNewDueDate;
    @FXML
    private CheckBox chkbxNewCompleted;

    @FXML
    private CheckBox chkbxShowIncomplete;
    @FXML
    private CheckBox chkbxShowComplete;

    @FXML
    private boolean showIncomplete = true;
    @FXML
    private boolean showComplete = true;

    @FXML
    public void btnLoadClicked(ActionEvent actionEvent) throws IOException {
        // load file loader
        Parent parentLoadList = FXMLLoader.load(getClass().getResource("/fileLoader.fxml"));
        Scene sceneLoadList = new Scene(parentLoadList);

        // show file loader window
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(sceneLoadList);
        window.show();
    }

    @FXML
    public void btnDeleteToDoTaskClicked(ActionEvent actionEvent) {
        // call removeToDoTask() with title and description
        toDoModel.getToDoList().removeTask(tableView.getSelectionModel().getSelectedItem().description);
        refreshToDoTasks();
    }

    @FXML
    public void btnNewTaskClicked(ActionEvent actionEvent) {
        // call addTask to create list with data
        // refresh view
        toDoModel.getToDoList().addTask(txtNewDescription.getText(), dtNewDueDate.getValue(), chkbxNewCompleted.isSelected());
        refreshToDoTasks();
    }

    @FXML
    public void btnCreateNewListClicked(ActionEvent actionEvent) throws IOException {
        // load file creator window
        Parent parentNewList = FXMLLoader.load(getClass().getResource("/fileCreator.fxml"));
        Scene sceneNewList = new Scene(parentNewList);

        // show window
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(sceneNewList);
        window.show();
    }

    @FXML
    public void btnSaveListClicked(ActionEvent actionEvent) {
        // call saveList() with title
        toDoModel.saveList();
    }

    @FXML
    public void chkbxShowIncompleteClicked() {
        // toggle showIncomplete according to chkbxShowIncomplete.isSelected()
        // refresh
        showIncomplete = chkbxShowIncomplete.isSelected();
        refreshToDoTasks();
    }

    @FXML
    public void chkbxShowCompleteClicked() {
        // toggle showCompleted according to chkbxShowCompleted.isSelected()
        // refresh
        showComplete = chkbxShowComplete.isSelected();
        refreshToDoTasks();
    }

    @FXML
    public void refreshToDoTasks() {
        // setup vars
        ToDoList filteredTasks = new ToDoList();
        ToDoList fullList;
        fullList = toDoModel.getToDoList();

        // check which tasks to show
        if (showComplete && showIncomplete) filteredTasks = fullList; else if (showComplete && !showIncomplete) filteredTasks.setToDoTasks(fullList.getCompleteToDoTasks()); else if (!showComplete && showIncomplete) filteredTasks.setToDoTasks(fullList.getIncompleteToDoTasks());

        // set default values
        txtNewDescription.setText("");
        dtNewDueDate.setValue(null);
        chkbxNewCompleted.setSelected(false);

        // refresh table view
        tableView.setItems(getTasksToDisplay(filteredTasks));
        tableView.refresh();
    }

    private ObservableList<ToDoTask> getTasksToDisplay(ToDoList list) {
        // get tasks in table view format
        ObservableList<ToDoTask> tasks = FXCollections.observableArrayList();
        if (list.getToDoTasks() != null) tasks.addAll(list.getToDoTasks());
        return tasks;
    }

    public void initialize(URL url, ResourceBundle rb) {
        // setup gui and controller
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colCompleted.setCellValueFactory(parameters -> {
            ToDoTask task = parameters.getValue();

            SimpleBooleanProperty booleanProperty = new SimpleBooleanProperty(task.getComplete());

            booleanProperty.addListener((observable, oldValue, newValue) -> task.setComplete(newValue));

            return booleanProperty;
        });
        colCompleted.setCellFactory(f -> {
            CheckBoxTableCell<ToDoTask, Boolean> cell = new CheckBoxTableCell<>();
            cell.setAlignment(Pos.BASELINE_CENTER);
            return cell;
        });
        tableView.setEditable(true);

        // refresh
        refreshToDoTasks();
    }
}