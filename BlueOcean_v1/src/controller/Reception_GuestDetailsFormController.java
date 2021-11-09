package controller;

import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class Reception_GuestDetailsFormController {
    @FXML
    private AnchorPane guestDetailsRoot;

    @FXML
    private JFXRadioButton visaRadio;

    @FXML
    private ToggleGroup payMethod;

    @FXML
    private JFXRadioButton masterRadio;

    @FXML
    private JFXRadioButton paypalRadio;

    public static boolean repLoaded = false;

    @FXML
    void BackFromGuest(ActionEvent event) throws IOException {
            LoadUI("Reception_MealPackage");
    }

    @FXML
    void GoFromGuest(ActionEvent event) throws IOException {
        boolean res = displayModalPopup(Alert.AlertType.CONFIRMATION,"Continue","Save data and Continue ?");

        if(res){
            repLoaded = true;
            URL resource = getClass().getResource("../view/FinalRoot.fxml");
            Parent load = FXMLLoader.load(resource);
            guestDetailsRoot.getChildren().clear();
            guestDetailsRoot.getChildren().add(load);
        }
    }

    public void LoadUI(String window) throws IOException {
        boolean res = displayModalPopup(Alert.AlertType.CONFIRMATION,"Continue","Save data and Continue ?");

        if(res){
            URL resource = getClass().getResource("../view/"+ window +".fxml");
            Parent load = FXMLLoader.load(resource);
            guestDetailsRoot.getChildren().clear();
            guestDetailsRoot.getChildren().add(load);
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
