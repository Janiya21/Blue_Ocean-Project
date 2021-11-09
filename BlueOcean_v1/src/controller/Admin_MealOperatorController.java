package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class Admin_MealOperatorController implements Initializable {

    @FXML
    private AnchorPane mealChangeRoot;

    @FXML
    private JFXButton backBtn;

    @FXML
    private JFXButton nextBtn;

    @FXML
    private ComboBox<String> mealCombo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mealCombo.getItems().addAll("Morning Meal", "Lunch Meal", "Dinner Meal");
        mealCombo.getSelectionModel().select("Morning Meal");

//        Admin_MainRootController.rootChanged = "mealOperator";
    }

    @FXML
    void goBackBtn(ActionEvent event) throws Exception{
        boolean res = displayModalPopup(Alert.AlertType.CONFIRMATION,"Go Back","Go back Without saving Data ?");

        if(res){
            URL resource = getClass().getResource("../view/Admin_RoomOperator.fxml");
            Parent load = FXMLLoader.load(resource);
            mealChangeRoot.getChildren().clear();
            mealChangeRoot.getChildren().add(load);
        }
    }

    @FXML
    void goNextBtn(ActionEvent event) throws IOException {
        boolean res = displayModalPopup(Alert.AlertType.CONFIRMATION,"Continue","Save data and Continue ?");

        if(res){
            URL resource = getClass().getResource("../view/Admin_ShowReports.fxml");
            Parent load = FXMLLoader.load(resource);
            mealChangeRoot.getChildren().clear();
            mealChangeRoot.getChildren().add(load);
        }
    }

    @FXML
    void addMealBtn(ActionEvent event) {
        displayModalPopup(Alert.AlertType.CONFIRMATION,"Adding meal","Save this meal to the database ?");
    }

    @FXML
    void delMealPlan(ActionEvent event) {
        displayModalPopup(Alert.AlertType.CONFIRMATION,"Delete meal","Delete this meal from database  ?");
    }

    @FXML
    void updateMealPlan(ActionEvent event) {
        displayModalPopup(Alert.AlertType.CONFIRMATION,"Update Meal","Update with new meals ?");
    }

    // -----------------------------------------------------------------------------------------

    public boolean displayModalPopup(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.getDialogPane().setPrefSize(600, 200);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }
}
