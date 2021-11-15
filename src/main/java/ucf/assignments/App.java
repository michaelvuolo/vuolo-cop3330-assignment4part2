/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ucf.assignments;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    // launch the application
    public static void main(String[] args) {
        launch(args);
    }

    // load FXML file and display it
    @Override
    public void start(Stage stage) {
        try {
            // load fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/app.fxml"));

            // display fxml
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("To Do List");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
