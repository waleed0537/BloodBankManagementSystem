package com.example.demo5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchDonor {
    @FXML
    private Button p3;

    @FXML
    private TableView<Donor> donorTable;

    @FXML
    private TextField bloodtypeTextField;

    @FXML
    private void initialize() {
        // Assuming Donor has fields like name, age, email, contact, address, blood_group
        // ... (your existing code for column setup)

        loadDonors(); // Load data from the database
    }

    @FXML
    private void loadDonors() {
        // Your existing loadDonors() method
    }
    public void p4(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
        Parent root = loader.load();
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.setScene(new Scene(root, 797, 582));
        registerStage.show();
    }

    @FXML
    private void onSearchButtonClicked() {
        String bloodType = bloodtypeTextField.getText();
        ObservableList<Donor> filteredDonors = filterDonorsByBloodType(bloodType);
        donorTable.setItems(filteredDonors);
    }
    private ObservableList<Donor> filterDonorsByBloodType(String bloodType) {
        System.out.println("Blood Type: " + bloodType);

        ObservableList<Donor> filteredDonors = FXCollections.observableArrayList();
        DataBaseConnectivity connection = new DataBaseConnectivity();
        Connection connectDB = connection.getConnection();

        try {
            if (connectDB != null) {
                String selectQuery = "SELECT * FROM DonorLogin WHERE blood_group = ?";
                PreparedStatement statement = connectDB.prepareStatement(selectQuery);
                statement.setString(1, bloodType);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String age = resultSet.getString("age");
                    String email = resultSet.getString("email");
                    String contact = resultSet.getString("contact");
                    String address = resultSet.getString("address");
                    String bloodGroup = resultSet.getString("blood_group");

                    Donor donor = new Donor(name, age, email, contact, address, bloodGroup);
                    filteredDonors.add(donor);
                }
            } else {
                System.out.println("Database connection is null.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connectDB != null) connectDB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return filteredDonors;
    }

}

