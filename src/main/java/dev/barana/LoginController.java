package dev.barana;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField userNameInput;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label errorMassege;

    public void initialize() {
        // Listen for text changes
        userNameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Text changed from: " + oldValue + " to: " + newValue);
            errorMassege.setText("");
            if (newValue.length() > 10) {
                System.out.println("Username is getting long!");
            }
        });

        userNameInput.focusedProperty().addListener((observable, oldVal, newVal) -> {
            if (newVal) {
                System.out.println("User clicked/focused into the text field!");
                errorMassege.setText("");
            } else {
                System.out.println("User clicked away from the text field (lost focus).");
            }
        });
    }

    public void login(ActionEvent event) {
        String username = userNameInput.getText();

        if ("BaranaNadil".equals(username)) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a background task for progress & FXML loading
            Task<Parent> loginTask = new Task<>() {
                @Override
                protected Parent call() throws Exception {
                    // Simulate loading progress
                    for (int i = 0; i <= 100; i++) {
                        updateProgress(i, 100);
                        Thread.sleep(10);
                    }

                    // Properly instantiate FXMLLoader
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("helloPage.fxml"));
                    Parent root = loader.load();

                    // Pass data to the target controller
                    HelloController helloController = loader.getController();
                    helloController.setUserName(username);

                    return root;
                }

            };

            // Bind progress bar directly to task progress (automatically scales 0.0 to 1.0)
            progressBar.progressProperty().unbind();
            progressBar.progressProperty().bind(loginTask.progressProperty());

            // Executed automatically on JavaFX Application Thread upon task completion
            loginTask.setOnSucceeded(e -> {
                Parent root = loginTask.getValue();
                stage.getScene().setRoot(root);
            });

            loginTask.setOnFailed(e -> {
                Throwable exception = loginTask.getException();
                if (exception != null) {
                    exception.printStackTrace();
                }
                errorMassege.setText("Error loading page.");
            });

            // Start thread
            Thread thread = new Thread(loginTask);
            thread.setDaemon(true);
            thread.start();

        } else {
            errorMassege.setText("Invalid Username");
        }
    }
}