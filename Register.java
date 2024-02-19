package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Register {
    @FXML
    private TextField donorName;
    @FXML
    private TextField donorAge;
    @FXML
    private TextField donorEmail;
    @FXML
    private TextField donorContact;
    @FXML
    private TextField donorAddress;
    @FXML
    private TextField donorBloodGroup;
    @FXML
    private TextField donorPassword;
    @FXML
    private Button donorSignUp;
    @FXML
    private Label labelSignUp;

    @FXML
    private Stage registerStage;

    public void setRegisterStage(Stage registerStage) {
        this.registerStage = registerStage;
    }

    @FXML
    public void onClickDonorSignUpButton(ActionEvent event) {

        if (!donorName.getText().isBlank() && !donorAge.getText().isBlank() && !donorEmail.getText().isBlank()
        && !donorContact.getText().isBlank() && !donorAddress.getText().isBlank() && !donorBloodGroup.getText().isBlank()
        && !donorPassword.getText().isBlank()) {
            DonorSignUp();
        } else {
            labelSignUp.setText("Please provide full information!");
        }
    }
    public void DonorSignUp() {
        try {
            DataBaseConnectivity connection = new DataBaseConnectivity();
            Connection connectDB = connection.getConnection();
            String insertDataQuery = "INSERT INTO DonorLogin (name, age, email, contact, address, blood_group,password) VALUES ('"

                    + donorName.getText() + "', '"
                    + donorAge.getText() + "', '"
                    + donorEmail.getText() + "', '"
                    + donorContact.getText() + "', '"
                    + donorAddress.getText() + "', '"
                    + donorBloodGroup.getText() + "', '"
                    + donorPassword.getText() + "')";

            Statement statement = connectDB.createStatement();

            // Execute the update
            statement.executeUpdate(insertDataQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}