package controller;

import com.jfoenix.controls.JFXButton;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Reception_MainRootController implements Initializable {

    @FXML
    private  JFXButton bedIcon;

    @FXML
    private  JFXButton foodIcon;

    @FXML
    private  JFXButton payIcon;

    @FXML
    private AnchorPane changingRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            LoadUI("Reception_BookingRooms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LoadUI(String window) throws IOException {
        URL resource = getClass().getResource("../view/"+ window +".fxml");
        Parent load = FXMLLoader.load(resource);
        changingRoot.getChildren().clear();
        changingRoot.getChildren().add(load);
    }
}
