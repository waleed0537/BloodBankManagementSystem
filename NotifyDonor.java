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

public class NotifyDonor {

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField bloodtypeTextField;
    @FXML
    private Button UpdateButton;
@FXML
private Button p5;
public void p6(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
    Parent root = loader.load();
    Stage registerStage = new Stage();
    registerStage.initStyle(StageStyle.UNDECORATED);
    registerStage.setScene(new Scene(root, 797, 582));
    registerStage.show();
}

    public void onShowResult(ActionEvent event){

        LocalDate selectedDate = datePicker.getValue();
        String formattedDate = selectedDate.toString();
        System.out.println(formattedDate);
        String bloodType = bloodtypeTextField.getText();
        System.out.println(bloodType);
        //shor1.setText("Daba hun");
        // showTables.setVisible(true);

        DataBaseConnectivity connection = new DataBaseConnectivity();
        Connection connectDB = connection.getConnection();
        try {
            if (connectDB != null) {
                //showTables.setVisible(false);
                String updateQuery = "UPDATE DonorLogin SET Notification = '" + formattedDate + "' WHERE blood_group = '" + bloodType + "'";

                try (Statement statement = connectDB.createStatement()) {
                    // Execute the update
                    int rowsAffected;
                    rowsAffected = statement.executeUpdate(updateQuery);

                    System.out.println("Rows affected: " + rowsAffected);
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
}
