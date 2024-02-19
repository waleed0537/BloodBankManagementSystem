package com.example.demo5;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;
import java.util.BitSet;

public class DonorProfile {
    @FXML
    private Button p1;
    @FXML
    private TextField donorNameField;
    @FXML
    private Button recordDonation;

    @FXML
    private TextField bloodTypeField;
    @FXML
    private Button BloodDonateButton;
    private String username;
    @FXML
    private Label showNotificationMsg;
    private String password;
    @FXML
    private Button profileButton;
    @FXML
    private Button appointmentButton;
    @FXML
    private Button donationHistoryButton;
    @FXML
    private Button notificationsButton;
    @FXML
    private Pane profilePane;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField contactTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField bloodgroupTextField;
    @FXML
    private TextField passwordTextField;

    public DonorProfile() {
        // Default constructor
    }

    public String getUsername() {
        return username;
    }

    public void onBloodDonateButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BloodDonation.fxml"));
        Parent root = loader.load();
        //DonorProfile donorProfileController = loader.getController();
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.DECORATED);
        registerStage.setScene(new Scene(root, 797, 582));
        registerStage.show();

    }
    public void p2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DonorLogin.fxml"));
        Parent root = loader.load();
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.setScene(new Scene(root, 797, 582));
        registerStage.show();
    }
    public DonorProfile(String username, String password) {
        this.username = username;
        this.password = password;

    }


    public void setUsername(String username) {
        this.username = username;
    }

    @FXML
    public void initialize() {

        profilePane.setVisible(false);
        showNotificationMsg.setVisible(false);
    }


    public void onProfileButtonClick(ActionEvent event) {
        profilePane.setVisible(true);
        DataBaseConnectivity connection = new DataBaseConnectivity();
        Connection connectDB = connection.getConnection();
        System.out.println(username);
        String selectQuery = "SELECT * FROM DonorLogin WHERE name = '" + username + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            if (resultSet.next()) {
                // Retrieve data from the result set
                String retrievedUsername = resultSet.getString("name");
                String retrievedAge = resultSet.getString("age");
                String retrievedEmail = resultSet.getString("email");
                String retrievedContact = resultSet.getString("contact");
                String retrievedAddress = resultSet.getString("address");
                String retrievedBloodGroup = resultSet.getString("blood_group");
                String retrievedPassword = resultSet.getString("password");

                nameTextField.setText(retrievedUsername);
                ageTextField.setText(retrievedAge);
                emailTextField.setText(retrievedEmail);
                contactTextField.setText(retrievedContact);
                addressTextField.setText(retrievedAddress);
                bloodgroupTextField.setText(retrievedBloodGroup);
                passwordTextField.setText(retrievedPassword);

                // Now you can use the retrieved data as needed
            } else {
                // Handle the case where no results are found
                System.out.println("No user found with the given username.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDonorProfile(DonorProfile donorProfile) {
        this.username = donorProfile.getUsername();
        // Copy other relevant fields if needed
    }

    public void onnotificationsButtonClicked(ActionEvent event) {
        profilePane.setVisible(false);
        showNotificationMsg.setVisible(true);
        DataBaseConnectivity connection = new DataBaseConnectivity();
        Connection connectDB = connection.getConnection();
        System.out.println(username);
        String selectQuery = "SELECT * FROM DonorLogin WHERE name = '" + username + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            if (resultSet.next()) {
                String retrievedUsername = resultSet.getString("name");
                String retrieveNotification =  resultSet.getString("Notification");
                showNotificationMsg.setText("You have been called up for Blood donation by the admin at: "+ retrieveNotification);
                //nameTextField.setText(retrievedUsername);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}




    // Setter for username


