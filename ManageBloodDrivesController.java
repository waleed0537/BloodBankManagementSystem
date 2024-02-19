package com.example.demo5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageBloodDrivesController {
    @FXML
    private Button AddDriveButton;

    @FXML
    private TextField locationTextField;

    @FXML
    private TextField dateTextField;

    @FXML
    private TextField timeTextField;

    @FXML
    private TableView<BloodDrive> bloodDrivesTable;

    @FXML
    private TableColumn<BloodDrive, String> locationColumn;

    @FXML
    private TableColumn<BloodDrive, String> dateColumn;

    @FXML
    private TableColumn<BloodDrive, String> timeColumn;

    @FXML
    private Button yourButtonId;

    @FXML
    private Label labelManageBloodDrives;

    @FXML
    private ImageView imageView;

    private BloodDriveDAO bloodDriveDAO = new BloodDriveDAO();

    private static final String INSERT_QUERY = "INSERT INTO blood_drives (location, date, time) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM blood_drives";

    @FXML
    private void initialize() {
        // Initialize table columns
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        // Load existing blood drives from the database
        bloodDrivesTable.setItems(bloodDriveDAO.getAllBloodDrives());
    }

    @FXML
    private void onAddDriveButtonClicked(ActionEvent event) {
        addBloodDrive();
    }

    private void addBloodDrive() {
        String location = locationTextField.getText();
        String date = dateTextField.getText();
        String time = timeTextField.getText();

        if (!location.isEmpty() && !date.isEmpty() && !time.isEmpty()) {
            BloodDrive newBloodDrive = new BloodDrive(location, date, time);
            bloodDriveDAO.addBloodDrive(newBloodDrive);
            bloodDrivesTable.getItems().add(newBloodDrive);

            // Clear input fields
            locationTextField.clear();
            dateTextField.clear();
            timeTextField.clear();
        }
    }

    // Nested class for handling database operations
    private static class BloodDriveDAO {

        public void addBloodDrive(BloodDrive bloodDrive) {
            DataBaseConnectivity connection = new DataBaseConnectivity();
            Connection connectDB = connection.getConnection();
            try (
                    PreparedStatement preparedStatement = connectDB.prepareStatement(INSERT_QUERY)) {

                preparedStatement.setString(1, bloodDrive.getLocation());
                preparedStatement.setString(2, bloodDrive.getDate());
                preparedStatement.setString(3, bloodDrive.getTime());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public ObservableList<BloodDrive> getAllBloodDrives() {
            ObservableList<BloodDrive> bloodDrives = FXCollections.observableArrayList();
            DataBaseConnectivity connection = new DataBaseConnectivity();
            Connection connectDB = connection.getConnection();
            try (
                    PreparedStatement preparedStatement = connectDB.prepareStatement(SELECT_ALL_QUERY);
                    ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String location = resultSet.getString("location");
                    String date = resultSet.getString("date");
                    String time = resultSet.getString("time");

                    BloodDrive bloodDrive = new BloodDrive(location, date, time);
                    bloodDrives.add(bloodDrive);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return bloodDrives;
        }
    }
}
