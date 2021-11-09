package controller;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Admin_MainRootController implements Initializable {

    @FXML
    private AnchorPane adminChangingRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            LoadUI("Admin_RoomOperator");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------------------

    public void LoadUI(String window) throws IOException {
        URL resource = getClass().getResource("../view/"+ window +".fxml");
        Parent load = FXMLLoader.load(resource);
        adminChangingRoot.getChildren().clear();
        adminChangingRoot.getChildren().add(load);
    }

}
