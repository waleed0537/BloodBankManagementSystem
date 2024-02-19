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

public class HelloController {

  @FXML
  private Button ReciepntButton;

  @FXML
  private Button donorButton;
  @FXML
  private Button adminButton;

  public void onDonorButtonClicked(ActionEvent event){
      donorButton.setText("Daba hub");
      showDonorLoginWindow();
  }
    public void onAdminButtonClicked(ActionEvent event){
        donorButton.setText("Daba hub");
        showAdminWindow();
    }

    @FXML
    private Stage primaryStagestage;
    public void setStage(Stage primaryStage) {
        this.primaryStagestage = primaryStage;
    }
    public void showDonorLoginWindow(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DonorLogin.fxml"));
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
        }
    }
    public void showAdminWindow(){
        try {
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
        }
    }




}