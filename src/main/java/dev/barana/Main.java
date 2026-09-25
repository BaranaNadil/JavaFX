package dev.barana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {


    static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage.setTitle("Hello JavaFX");

        Scene scene = new Scene(root);

//        String css = this.getClass().getResource("../../application.css").toExternalForm();

//        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event ->{
            exitApplication(stage);
        });

    }

    public void exitApplication(Stage stage){
        if(showAlert()){
            System.out.println("You successfully Logout");
            stage.close();
        }
    }

    private boolean showAlert(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You about to logout");
        alert.setContentText("Do you want to exit this application ? ");

        return alert.showAndWait().get() == ButtonType.OK;
    }

}
