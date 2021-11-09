package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FinalRootController implements Initializable {

    @FXML
    private JFXButton backToLoginBtn;

    @FXML
    private AnchorPane finishingRoot;

    @FXML
    private JFXButton exitBtn;

    @FXML
    void exitWindow(ActionEvent event) throws IOException {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void goBackToLogin(ActionEvent event) throws Exception{
        Stage stage = (Stage) backToLoginBtn.getScene().getWindow();
        stage.close();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"));

        primaryStage.setTitle("Blue Ocean v-1.0.0");
        primaryStage.setScene(new Scene(root,1230,739));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Reception_GuestDetailsFormController.repLoaded){
            final Stage dialog = new Stage();

            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setTitle("Customer Total Bill");

            VBox dialogVBox = new VBox(20);

            dialogVBox.getChildren().add(new Text("\n\t\t~~~~~~~~~~~~~~~~~~ Total Bill ~~~~~~~~~~~~~~~~\n\n" +
                    "\t\t\tRoom Cost :  12000.00\n" +
                    "\t\t\tMeal Cost :  4000.00\n" +
                    "\t\t\tAdditional service : 2000.00\n\n" +
                    "\t\t\t------------------------------\n\n" +
                    "\t\t\tTotal Value        : 18000.00\n\n"+
                    "\t\t\t==============================\n\n"
            ));

            Scene dialogScene = new Scene(dialogVBox, 600, 250);
            dialog.setScene(dialogScene);
            dialog.show();
        }

    }
}
