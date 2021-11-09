package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class Reception_MealPackageController {

    @FXML
    private AnchorPane mealRoot;

    @FXML
    private RadioButton radMealPlan01;

    @FXML
    private ToggleGroup mealPlan;

    @FXML
    private RadioButton radMealPlan02;

    @FXML
    void BackFromMeal(ActionEvent event) throws IOException {
        LoadUI("Reception_BookingRooms");
    }

    @FXML
    void GoFromMeal(ActionEvent event) throws IOException {
        boolean res = displayModalPopup(Alert.AlertType.CONFIRMATION,"Continue","Save meals and Continue ?");

        if(res){
            LoadUI("Reception_GuestDetailsForm");
        }
    }

    public void LoadUI(String window) throws IOException {
        URL resource = getClass().getResource("../view/"+ window +".fxml");
        Parent load = FXMLLoader.load(resource);
        mealRoot.getChildren().clear();
        mealRoot.getChildren().add(load);
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
