package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BloodDonationController {
    private static final String INSERT_QUERY = "INSERT INTO blood_donations (donor_name, blood_type) VALUES (?, ?)";

    @FXML
    private  TextField donorNameField;

    @FXML
    private  TextField bloodTypeField;

    public void recordBloodDonation() {
        String donorName = donorNameField.getText();
        String bloodType = bloodTypeField.getText();


    }

    public void recordDonationButtonClicked(ActionEvent event) {
        String username1 = donorNameField.getText();
        String blood = bloodTypeField.getText();
        DataBaseConnectivity connection = new DataBaseConnectivity();
        try (Connection connectDB = connection.getConnection();
             PreparedStatement preparedStatement = connectDB.prepareStatement(INSERT_QUERY)) {

            preparedStatement.setString(1, username1);
            preparedStatement.setString(2, blood);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static class BloodDonation {
        private final String donorName;
        private final String bloodType;

        public BloodDonation(String donorName, String bloodType) {
            this.donorName = donorName;
            this.bloodType = bloodType;
        }

        public String getDonorName() {
            return donorName;
        }

        public String getBloodType() {
            return bloodType;
        }
    }


}

