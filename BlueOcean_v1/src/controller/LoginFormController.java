package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable{

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField signInUserName;

    @FXML
    private JFXRadioButton adminRadioBtnS;

    @FXML
    private JFXRadioButton receptionRadioBtnS;

    @FXML
    private JFXTextField signInPassWordText;

    @FXML
    private JFXTextField signInPassWordConfirm;

    @FXML
    private Button signBtn;

    @FXML
    private Button LoginBtn;

    @FXML
    private ToggleGroup grp1;

    @FXML
    private JFXTextField loginUserNameTxt;

    @FXML
    private JFXTextField loginPasswordTxt;

    @FXML
    private JFXRadioButton adminRadioBtnL;

    @FXML
    private JFXRadioButton receptionRadioBtnL;

    @FXML
    private Pane vb_content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    void left(ActionEvent event) {
        TranslateTransition translate = new TranslateTransition(Duration.seconds(2), vb_content);
        translate.setToX(root.getLayoutX());
        translate.play();
    }

    @FXML
    void right(ActionEvent event) {
        TranslateTransition translate = new TranslateTransition(Duration.seconds(2), vb_content);
        translate.setToX((root.getPrefWidth() - vb_content.getPrefWidth())+ 7);
        translate.play();
    }

    @FXML
    void signIn(ActionEvent event) {

        if(signInPassWordText.getText().equals(signInPassWordConfirm.getText()) &&  !signInUserName.getText().trim().isEmpty()
         && (adminRadioBtnS.isSelected() || receptionRadioBtnS.isSelected())){

                boolean res = displayModalPopup(Alert.AlertType.CONFIRMATION,"Sign-in successful !","Continue to Log-In ? ");
                if(res){
                    signInUserName.clear(); signInPassWordText.clear(); signInPassWordConfirm.clear();
                    left(event);
                }
        }
    }

    @FXML
    public void ButtonLoginAction(ActionEvent event) {

        if(!loginUserNameTxt.getText().trim().isEmpty() && !loginPasswordTxt.getText().trim().isEmpty()){

            boolean res = displayModalPopup(Alert.AlertType.INFORMATION,"Log-in","Log-in Successful! Click OK to Continue");
            if(res){
                signInUserName.clear(); signInPassWordText.clear(); signInPassWordConfirm.clear();
                if(adminRadioBtnL.isSelected()){
                    loadStage("Admin_MainRoot");
                }else{
                    loadStage("Reception_MainRoot");
                }
            }
        }else{
            displayModalPopup(Alert.AlertType.ERROR,"Error","Please Fill The Fields Correctly..");
        }
    }

    //---------------------------------------------------------------------------------------------//

    public void loadStage(String name){
        try {
            Stage stage = (Stage) LoginBtn.getScene().getWindow();
            stage.close();

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../view/"+name+".fxml"));

            primaryStage.setTitle("Blue Ocean v-1.0.0");
            primaryStage.setScene(new Scene(root,1228,730));
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
