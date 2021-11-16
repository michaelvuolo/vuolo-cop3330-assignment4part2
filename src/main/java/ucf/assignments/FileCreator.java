/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ucf.assignments;


import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class FileCreator {

    @FXML
    private TextField txtNewListTitle;

    public void btnCreateList(ActionEvent actionEvent) throws IOException {
        // get title and make a new empty list with it
        String listTitle = txtNewListTitle.getText();
        ToDoList newList = new ToDoList(listTitle);

        // load parent app
        FXMLLoader loadApp = new FXMLLoader();
        loadApp.setLocation(getClass().getResource("/app.fxml"));
        Parent parentLoadApp = loadApp.load();
        ToDoController appController = loadApp.getController();

        // update to do list
        appController.toDoModel.setToDoList(newList);

        // refresh tasks
        appController.refreshToDoTasks();

        // go back to parent app window
        Scene scene = new Scene(parentLoadApp);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
