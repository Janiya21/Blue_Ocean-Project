package controller;

import Model.Rooms;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class Reception_BookingRoomsController implements Initializable {
    @FXML
    private AnchorPane roomRoot;

    @FXML
    private JFXButton goToLogin;

    @FXML
    private JFXTextField pickRoomTxt;

    @FXML
    private JFXButton savedRoomBtn;

    @FXML
    private TableView<Rooms> customerRoomDetails;

    @FXML
    private TableColumn<Rooms, String> roomID;

    @FXML
    private TableColumn<Rooms, String> bedType;

    @FXML
    private TableColumn<Rooms, String> facilities;

    @FXML
    private TableColumn<Rooms, String> availability;

    @FXML
    private TableColumn<Rooms, String> price;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roomID.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        bedType.setCellValueFactory(new PropertyValueFactory<>("bedType"));
        facilities.setCellValueFactory(new PropertyValueFactory<>("facilities"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        availability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        customerRoomDetails.setItems(Admin_RoomOperatorController.observableList); // This list located in Admin_RoomOperator class
    }


    public void goFromRoom(ActionEvent event) throws IOException {
        boolean res = displayModalPopup(Alert.AlertType.CONFIRMATION,"Continue","Save data and Continue ?");

        if(res){
            URL resource = getClass().getResource("../view/Reception_MealPackage.fxml");
            Parent load = FXMLLoader.load(resource);
            roomRoot.getChildren().clear();
            roomRoot.getChildren().add(load);
        }
    }

    @FXML
    void btnMaintain(ActionEvent event) {
        displayModalPopup(Alert.AlertType.CONFIRMATION,"Mark as maintain","Save this room as a maintain ?");
    }

    public void backFromRoom(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) goToLogin.getScene().getWindow();
            stage.close();

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"));

            primaryStage.setTitle("Blue Ocean v-1.0.0");
            primaryStage.setScene(new Scene(root,1230,739));
            primaryStage.setResizable(false);
            primaryStage.show();

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public boolean displayModalPopup(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.getDialogPane().setPrefSize(600, 200);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }
}
