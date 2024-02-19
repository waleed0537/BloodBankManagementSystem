package com.example.demo5;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;


import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Admin {
    @FXML
    public Button ADMINBACK;
    @FXML
    public Button manageBloodButton;
    @FXML
    private Button bloodTransfusionButton;
    @FXML
    private Button manageBloodDrive;
    @FXML
    private Label sawalLabel;
    @FXML
    private RadioButton YesButton;
    @FXML
    private RadioButton NoButton;
    @FXML
    private Label A1Label;
    @FXML
    private Label A2Label;
    @FXML
    private Label B1Label;
    @FXML
    private Label B2Label;
    @FXML
    private Label AB1Label;
    @FXML
    private Label AB2Label;
    @FXML
    private Label O1Label;
    @FXML
    private Label O2Label;
    @FXML
    private TextField A1textField;
    @FXML
    private TextField A2textField;
    @FXML
    private TextField B1textField;
    @FXML
    private TextField B2textField;
    @FXML
    private TextField AB1textField;
    @FXML
    private TextField AB2textField;
    @FXML
    private TextField O1textField;
    @FXML
    private TextField O2textField;
    @FXML
    private AnchorPane bloodGroupPane;
    @FXML
    private Button searchDonorButton;
    @FXML
    private AnchorPane showTables;
    @FXML
    private AnchorPane showTables1;
    @FXML
    private Label labelforNot;
    @FXML
    private Button shor;
    @FXML
    private Button shor1;
    @FXML
    private TextField bloodtypeTextField;
    @FXML
    private TextField bloodtypeTextField1;
    @FXML
    private AnchorPane showTables2;
    @FXML
    private CheckBox notifyDonorCheckBox1;
    @FXML
    private Button notifyDonorButton;
    @FXML

    private Button updateBloodInventory;
    @FXML
    private Stage primaryStagestage;
    @FXML
    private DatePicker notificationDatePicker;

    @FXML
    public void setStage(Stage primaryStage) {
        this.primaryStagestage = primaryStage;
    }
    public void ADMINBACKCLICKED(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.setScene(new Scene(root, 797, 582));
        registerStage.show();
    }

    public void initialize() {
        showTables2.setVisible(false);
        bloodGroupPane.setVisible(false);
        A1Label.setVisible(false);
        A2Label.setVisible(false);
        B1Label.setVisible(false);
        B2Label.setVisible(false);
        AB1Label.setVisible(false);
        AB2Label.setVisible(false);
        O1Label.setVisible(false);
        O2Label.setVisible(false);
        sawalLabel.setVisible(false);
        YesButton.setVisible(false);
        NoButton.setVisible(false);

    }

    public void onManageInventoryButtonClicked(ActionEvent event) throws InterruptedException, IOException {

        YesButton.setVisible(true);
        NoButton.setVisible(true);
        A1Label.setVisible(true);
        A2Label.setVisible(true);
        B1Label.setVisible(true);
        B2Label.setVisible(true);
        AB1Label.setVisible(true);
        AB2Label.setVisible(true);
        O1Label.setVisible(true);
        O2Label.setVisible(true);
        bloodGroupPane.setVisible(true);
        DataBaseConnectivity connection = new DataBaseConnectivity();
        Connection connectDB = connection.getConnection();
        try {
            // Establish a database connection


            // Query to retrieve the total count of A+ blood bottles
            String query = "SELECT count_column FROM BloodInventory WHERE blood_type = 'A+'";

            try (PreparedStatement preparedStatement = connectDB.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there is a result
                if (resultSet.next()) {
                    // Retrieve the count from the result set
                    int totalCount = resultSet.getInt("count_column");

                    // Update the A1Label with the count
                    A1Label.setText("The total bottles available for blood type A+ are: " + String.valueOf(totalCount));
                } else {
                    // Handle the case where no result is found
                    A1Label.setText("0");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            // Establish a database connection


            // Query to retrieve the total count of A+ blood bottles
            String query = "SELECT count_column FROM BloodInventory WHERE blood_type = 'A-'";

            try (PreparedStatement preparedStatement = connectDB.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there is a result
                if (resultSet.next()) {
                    // Retrieve the count from the result set
                    int totalCount = resultSet.getInt("count_column");

                    // Update the A1Label with the count
                    A2Label.setText("The total bottles available for blood type A- are: " + String.valueOf(totalCount));
                } else {
                    // Handle the case where no result is found
                    A2Label.setText("0");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            // Establish a database connection


            // Query to retrieve the total count of A+ blood bottles
            String query = "SELECT count_column FROM BloodInventory WHERE blood_type = 'B+'";

            try (PreparedStatement preparedStatement = connectDB.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there is a result
                if (resultSet.next()) {
                    // Retrieve the count from the result set
                    int totalCount = resultSet.getInt("count_column");

                    // Update the A1Label with the count
                    B1Label.setText("The total bottles available for blood type B+ are: " + String.valueOf(totalCount));
                } else {
                    // Handle the case where no result is found
                    B1Label.setText("0");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            // Establish a database connection


            // Query to retrieve the total count of A+ blood bottles
            String query = "SELECT count_column FROM BloodInventory WHERE blood_type = 'B-'";

            try (PreparedStatement preparedStatement = connectDB.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there is a result
                if (resultSet.next()) {
                    // Retrieve the count from the result set
                    int totalCount = resultSet.getInt("count_column");

                    // Update the A1Label with the count
                    B2Label.setText("The total bottles available for blood type B- are: " + String.valueOf(totalCount));
                } else {
                    // Handle the case where no result is found
                    B2Label.setText("0");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            // Establish a database connection


            // Query to retrieve the total count of A+ blood bottles
            String query = "SELECT count_column FROM BloodInventory WHERE blood_type = 'AB+'";

            try (PreparedStatement preparedStatement = connectDB.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there is a result
                if (resultSet.next()) {
                    // Retrieve the count from the result set
                    int totalCount = resultSet.getInt("count_column");

                    // Update the A1Label with the count
                    AB1Label.setText("The total bottles available for blood type AB+ are: " + String.valueOf(totalCount));
                } else {
                    // Handle the case where no result is found
                    AB1Label.setText("0");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            // Establish a database connection


            // Query to retrieve the total count of A+ blood bottles
            String query = "SELECT count_column FROM BloodInventory WHERE blood_type = 'AB-'";

            try (PreparedStatement preparedStatement = connectDB.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there is a result
                if (resultSet.next()) {
                    // Retrieve the count from the result set
                    int totalCount = resultSet.getInt("count_column");

                    // Update the A1Label with the count
                    AB2Label.setText("The total bottles available for blood type AB- are: " + String.valueOf(totalCount));
                } else {
                    // Handle the case where no result is found
                    AB2Label.setText("0");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            // Establish a database connection


            // Query to retrieve the total count of A+ blood bottles
            String query = "SELECT count_column FROM BloodInventory WHERE blood_type = 'O+'";

            try (PreparedStatement preparedStatement = connectDB.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there is a result
                if (resultSet.next()) {
                    // Retrieve the count from the result set
                    int totalCount = resultSet.getInt("count_column");

                    // Update the A1Label with the count
                    O1Label.setText("The total bottles available for blood type O+ are: " + String.valueOf(totalCount));
                } else {
                    // Handle the case where no result is found
                    O1Label.setText("0");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            // Establish a database connection


            // Query to retrieve the total count of A+ blood bottles
            String query = "SELECT count_column FROM BloodInventory WHERE blood_type = 'O-'";

            try (PreparedStatement preparedStatement = connectDB.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there is a result
                if (resultSet.next()) {
                    // Retrieve the count from the result set
                    int totalCount = resultSet.getInt("count_column");

                    // Update the A1Label with the count
                    O2Label.setText("The total bottles available for blood type O- are: " + String.valueOf(totalCount));
                } else {
                    // Handle the case where no result is found
                    O2Label.setText("0");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
       /* boolean isSelected = YesButton.isSelected();
        if(isSelected){
            System.out.println("Chal rha hun");
            bloodGroupPane.setVisible(true);
        }
        else{
            System.out.println("Chal rha hun");
            bloodGroupPane.setVisible(false);
        }
        boolean isSelected1 = NoButton.isSelected();
        if(isSelected1){
            System.out.println("ni Chal rha hun");
            bloodGroupPane.setVisible(true);
           /* try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
                Parent root = loader.load();


                Stage registerStage = new Stage();
                registerStage.initStyle(StageStyle.UNDECORATED);

                registerStage.setTitle("Login");
                registerStage.setScene(new Scene(root, 797, 582));
                registerStage.show();

                // Optionally, close the hello-view.fxml stage
                if (primaryStagestage != null) {
                    primaryStagestage.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }*/


    }

    public void onupdateBloodInventoryButtonClicked(ActionEvent event) {

        DataBaseConnectivity connection = new DataBaseConnectivity();
        Connection connectDB = connection.getConnection();

        String A1 = A1textField.getText();
        String A2 = (A2textField.getText());
        String B1 = (B1textField.getText());
        String B2 = (B2textField.getText());
        String AB1 = (AB1textField.getText());
        String AB2 = (AB2textField.getText());
        String O1 = (O1textField.getText());
        String O2 = (O2textField.getText());

        try {
            String updateQuery = "UPDATE BloodInventory SET count_column = " + A1 + " WHERE blood_type = 'A+'";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery)) {
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected);
                // Handle the result if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            String updateQuery = "UPDATE BloodInventory SET count_column = " + A2 + " WHERE blood_type = 'A-'";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery)) {
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected);
                // Handle the result if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            String updateQuery = "UPDATE BloodInventory SET count_column = " + B1 + " WHERE blood_type = 'B+'";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery)) {
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected);
                // Handle the result if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            String updateQuery = "UPDATE BloodInventory SET count_column = " + B2 + " WHERE blood_type = 'B-'";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery)) {
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected);
                // Handle the result if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            String updateQuery = "UPDATE BloodInventory SET count_column = " + AB1 + " WHERE blood_type = 'AB+'";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery)) {
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected);
                // Handle the result if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            String updateQuery = "UPDATE BloodInventory SET count_column = " + AB2 + " WHERE blood_type = 'AB-'";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery)) {
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected);
                // Handle the result if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            String updateQuery = "UPDATE BloodInventory SET count_column = " + O1 + " WHERE blood_type = 'O+'";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery)) {
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected);
                // Handle the result if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }
        try {
            String updateQuery = "UPDATE DonorLogin SET count_column = " + O2 + " WHERE blood_group = 'O-'";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery)) {
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected);
                // Handle the result if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or show an alert
        }

    }

    public Admin() {

    }

    public void onNotifyDonorButtonClicked(ActionEvent event) throws IOException {

        String A1getString = A1textField.getText();
        String A2getString = A2textField.getText();
        String B1getString = B1textField.getText();
        String B2getString = B2textField.getText();
        String AB1getString = AB1textField.getText();
        String AB2getString = AB2textField.getText();
        String O1getString = O1textField.getText();
        String O2getString = O2textField.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NotifyDonor.fxml"));
        Parent root = loader.load();
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.setScene(new Scene(root, 797, 582));
        registerStage.show();

    }

    public void onshowresultButtonClicked1() throws IOException {

    }





    public void onsearchdonorButtonClicked(ActionEvent event) throws SQLException, IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchDonor.fxml"));
        Parent root = loader.load();
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.setScene(new Scene(root, 797, 582));
        registerStage.show();
    }


    public void onshowresultButtonClicked() throws SQLException {
        showTables2.setVisible(true);
        String bloodType = bloodtypeTextField.getText();
        DataBaseConnectivity connection = new DataBaseConnectivity();
        Connection connectDB = connection.getConnection();

        try {
            if (connectDB != null) {
                //showTables.setVisible(false);
                String selectQuery = "SELECT * FROM DonorLogin WHERE blood_group = '" + bloodType + "'";
                Statement statement = connectDB.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery);
                int columnIndex = 0; // Declare columnIndex before the while loop

                while (resultSet.next()) {
                    VBox personBox = new VBox(); // Create a VBox for each person
                    personBox.setSpacing(10.0); // Set spacing between labels

                    // Define the column order for each person
                    String[] columnOrder = {"name", "age", "email", "contact", "address","blood_group"};

                    // Display each column va lue in the VBox based on the specified order
                    for (String columnName : columnOrder) {
                        String columnValue = resultSet.getString(columnName);

                        Label label = new Label(columnName + ": " + columnValue);
                        personBox.getChildren().add(label);
                    }
                    showTables.setVisible(false);

                    // Add the VBox for the person to the main AnchorPane
                    AnchorPane.setTopAnchor(personBox, columnIndex * 120.0); // Adjust spacing between persons
                    showTables2.getChildren().add(personBox);

                    columnIndex++;
                }

            } else {
                System.out.println("Database connection is null.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources (statement, result set, connection) in a finally block
            try {
                if (connectDB != null) connectDB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
    public void onManageBloodDriveClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BloodDrive.fxml"));
        Parent root = loader.load();
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.DECORATED);
        registerStage.setScene(new Scene(root, 797, 582));
        registerStage.show();
    }
    public void onBloodTransfusionButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transfusion.fxml"));
        Parent root = loader.load();
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.DECORATED);
        registerStage.setScene(new Scene(root, 797, 582));
        registerStage.show();
    }


}
