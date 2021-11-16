/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ucf.assignments;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FileLoader implements Initializable {

    // setup files var
    public ArrayList<String> files = new ArrayList<>();

    @FXML
    private ListView<String> lvFilesItems;

    @FXML
    public void loadList(MouseEvent mouseEvent) throws IOException {
        // get files
        String fileToLoad = lvFilesItems.getSelectionModel().getSelectedItem();
        FXMLLoader loadApp = new FXMLLoader();

        // load parent app window
        loadApp.setLocation(getClass().getResource("/app.fxml"));
        Parent parentLoadApp = loadApp.load();
        ToDoController appController = loadApp.getController();

        // load list from selected file
        appController.toDoModel.loadList(fileToLoad);
        appController.refreshToDoTasks();

        // show parent window
        Scene scene = new Scene(parentLoadApp);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void loadFiles() {
        // get files from appdata folder
        File savedLists = new File(System.getenv("APPDATA") + File.separator + "ToDoList" + File.separator);
        File[] lists = savedLists.listFiles();

        // remove .csv from each file name
        if (lists != null) for (File l : lists) if (l.isFile()) files.add(l.getName().substring(0, l.getName().length() - 4));
    }

    public ObservableList<String> getObservableFileList() {
        // get files in format for list view
        ObservableList<String> returnList = FXCollections.observableArrayList();
        returnList.addAll(files);
        return returnList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // setup titles in list view
        loadFiles();
        lvFilesItems.setItems(getObservableFileList());
    }
}
