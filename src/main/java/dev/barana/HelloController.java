package dev.barana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label nameLable;

    @FXML
    private AnchorPane ancherPain;

    private Stage stage;

    public void setUserName(String userName){

        nameLable.setText(userName);
    }

    public void exitApplication(ActionEvent event){
        if(showAlert()){
            stage = (Stage) ancherPain.getScene().getWindow();
            System.out.println("You Successfully Logout");
            stage.close();
        }
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
