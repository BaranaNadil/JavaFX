package dev.barana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {


    static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        stage.setTitle("Hello JavaFX");

        Scene scene = new Scene(root);

        String css = this.getClass().getResource("../../application.css").toExternalForm();

        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();
    }
}
