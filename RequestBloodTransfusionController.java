package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestBloodTransfusionController {
    @FXML
    private TextField donorNameField;
    @FXML
    private TextField bloodTypeField;
    @FXML
    private Button record;


    @FXML
    private TextField quantityTextField;

    @FXML
    private Button requestButton;

    @FXML
    private Label requestStatusLabel;

    private Stage requestStage;

    public void recordClicked(ActionEvent event){
        try {
            DataBaseConnectivity connection = new DataBaseConnectivity();
            Connection connectDB = connection.getConnection();

            String insertDataQuery = "INSERT INTO BloodTransfusionRequests (blood_type, quantity) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connectDB.prepareStatement(insertDataQuery)) {
                preparedStatement.setString(1, donorNameField.getText());
                preparedStatement.setString(2, bloodTypeField.getText());

                // Execute the update
                preparedStatement.executeUpdate();
            }

           // clearInputs();
            requestStatusLabel.setText("Blood Transfusion Request submitted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            requestStatusLabel.setText("Error occurred during the request. Please try again.");
        }
    }

}
