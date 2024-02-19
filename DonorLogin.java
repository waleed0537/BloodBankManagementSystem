package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DonorLogin {
    @FXML
    private Button LOGINBACK;
    private DonorProfile donorProfile;
    public String help;
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Hyperlink hyperLinkRegister;

    @FXML
    private Stage primaryStagestage;
    public DonorLogin() {
        this.donorProfile = new DonorProfile();

    }
    public void LOGINBACKCLICKED(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.setScene(new Scene(root, 797, 582));
        registerStage.show();
    }
    public void setStage(Stage primaryStage) {
        this.primaryStagestage = primaryStage;
    }

    public void hyperlinkClickOnAction(ActionEvent event){
        hyperLinkRegister.setText("Daba hun jani");
        showRegisterWindow();
    }

    public void loginButtonOnAction(ActionEvent event){
        if(!usernameTextField.getText().isBlank() && !passwordTextField.getText().isBlank()){
            ValidateLogin();

        }
        else{
            loginMessageLabel.setText("Please enter username and Password!");
        }


    }
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void ValidateLogin() {
        DataBaseConnectivity connection = new DataBaseConnectivity();
        Connection connectDB = connection.getConnection();
        String verifylogin = "SELECT count(1) FROM DonorLogin WHERE name = '" + usernameTextField.getText() + "' AND password = '" + passwordTextField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("Congrats!");
                    try {
                        donorProfile.setUsername(usernameTextField.getText());
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("DonorProfile.fxml"));
                        Parent root = loader.load();
                        DonorProfile donorProfileController = loader.getController();

                        // Pass the existing DonorProfile object to the controller
                        donorProfileController.setDonorProfile(donorProfile);
                        //Register registerController = loader.getController();
                        Stage registerStage = new Stage();
                        // registerController.setRegisterStage(registerStage);

                        registerStage.initStyle(StageStyle.DECORATED);
                        registerStage.setTitle("Welcome to the profile " + usernameTextField.getText())  ;
                        registerStage.setScene(new Scene(root, 797, 582));
                        registerStage.show();

                        // Optionally, close the hello-view.fxml stage
                        if (primaryStagestage != null) {
                            primaryStagestage.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    loginMessageLabel.setText("Invalid Login. Try again");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., log it, show an error message)
        }
    }
    private void showRegisterWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
            Parent root = loader.load();

            Register registerController = loader.getController();
            Stage registerStage = new Stage();
            registerController.setRegisterStage(registerStage);
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setTitle("Register");
            registerStage.setScene(new Scene(root, 797, 582));
            registerStage.show();

            // Optionally, close the hello-view.fxml stage
            if (primaryStagestage != null) {
                primaryStagestage.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}