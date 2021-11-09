package controller;

import Model.Rooms;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
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
import java.util.Optional;
import java.util.ResourceBundle;

public class Admin_RoomOperatorController implements Initializable {


    @FXML
    private AnchorPane roomOperatorRoot;

    @FXML
    private JFXTextField roomNoTxt;

    @FXML
    private JFXButton roomBack;

    @FXML
    private JFXTextField bedTypeTxt;

    @FXML
    private JFXTextField priceTxt;

    @FXML
    private JFXTextField facilityTxt;

    @FXML
    private JFXButton savedRoomBtn;

    @FXML
    private TableColumn<Rooms, String> roomNoCol;

    @FXML
    private TableColumn<Rooms, String> bedTypeCol;

    @FXML
    private TableColumn<Rooms, String> facCol;

    @FXML
    private TableColumn<Rooms, String> availabilityCol;

    @FXML
    private TableColumn<Rooms, String> priceCol;

    @FXML
    private TableView<Rooms> AdminTableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roomNoCol.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        bedTypeCol.setCellValueFactory(new PropertyValueFactory<>("bedType"));
        facCol.setCellValueFactory(new PropertyValueFactory<>("facilities"));
        availabilityCol.setCellValueFactory(new PropertyValueFactory<>("availability"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        AdminTableView.setItems(observableList);
    }

    public static ObservableList<Rooms> observableList = FXCollections.observableArrayList(
            new Rooms("R1001","Double + single ","AC      Wifi      Pool","12000.00","Yes"),
            new Rooms("R1002","single ","AC     Wifi","8000.00","Booked"),
            new Rooms("R1003","Double + single ","non-AC      Wifi","6000.00","Yes"),
            new Rooms("R1004","single ","AC      Wifi      Pool","11000.00","Yes"),
            new Rooms("R1005","Double","AC      Wifi      Pool","12000.00","Booked"),
            new Rooms("R1006","Double + single ","non-AC      Wifi","4000.00","Yes"),
            new Rooms("R1007","single ","AC      Wifi      Pool","10000.00","Yes"),
            new Rooms("R1008","Double + Double","AC      Wifi      Pool","14000.00","yes"),
            new Rooms("R1009","Double + single ","non-AC      Wifi","11000.00","Yes"),
            new Rooms("R10010","single ","AC      Wifi      Pool","10000.00","Yes"),
            new Rooms("R10011","Double","AC      Wifi      Pool","9000.00","Booked"),
            new Rooms("R1002","single ","AC     Wifi","8000.00","Booked"),
            new Rooms("R1003","Double + single ","non-AC      Wifi","6000.00","Yes"),
            new Rooms("R1004","single ","AC      Wifi      Pool","11000.00","Yes"),
            new Rooms("R1005","Double","AC      Wifi      Pool","12000.00","Booked"),
            new Rooms("R1006","Double + single ","non-AC      Wifi","4000.00","Yes"),
            new Rooms("R1007","single ","AC      Wifi      Pool","10000.00","Yes"),
            new Rooms("R1008","Double + Double","AC      Wifi      Pool","14000.00","yes"),
            new Rooms("R1009","Double + single ","non-AC      Wifi","11000.00","Yes"),
            new Rooms("R10010","single ","AC      Wifi      Pool","10000.00","Yes"),
            new Rooms("R10011","Double","AC      Wifi      Pool","9000.00","Booked"),
            new Rooms("R1002","single ","AC     Wifi","8000.00","Booked"),
            new Rooms("R1003","Double + single ","non-AC      Wifi","6000.00","Yes"),
            new Rooms("R1004","single ","AC      Wifi      Pool","11000.00","Yes"),
            new Rooms("R1005","Double","AC      Wifi      Pool","12000.00","Booked"),
            new Rooms("R1006","Double + single ","non-AC      Wifi","4000.00","Yes"),
            new Rooms("R1007","single ","AC      Wifi      Pool","10000.00","Yes"),
            new Rooms("R1008","Double + Double","AC      Wifi      Pool","14000.00","yes"),
            new Rooms("R1009","Double + single ","non-AC      Wifi","11000.00","Yes"),
            new Rooms("R10010","single ","AC      Wifi      Pool","10000.00","Yes"),
            new Rooms("R10011","Double","AC      Wifi      Pool","9000.00","Booked")
    );


    @FXML
    void adRoomBtn(ActionEvent event) {
        boolean res = displayModalPopup(Alert.AlertType.CONFIRMATION,"Save Room","Are You sure add this room ?");

        if(res){
            observableList.add(new Rooms(roomNoTxt.getText(),bedTypeTxt.getText(),facilityTxt.getText(),priceTxt.getText(),"Yes"));
            roomNoTxt.clear(); bedTypeTxt.clear();facilityTxt.clear(); priceTxt.clear();
        }
    }

    @FXML
    void dltRoomBtn(ActionEvent event) {

    }

    @FXML
    void updateRoomBtn(ActionEvent event) {
        Rooms r = search(roomNoTxt.getText());
        if(r != null){
            r.setRoomNo(roomNoTxt.getText());
            r.setBedType(bedTypeTxt.getText());
            r.setFacilities(facilityTxt.getText());
            r.setAvailability("Yes");
            System.out.println("Y");
        }else{
            System.out.println("X");
        }
    }

    @FXML
    void doneBtn(ActionEvent event) throws Exception{
        boolean res = displayModalPopup(Alert.AlertType.CONFIRMATION,"Continue","Save data and Continue ?");

        if(res){
            URL resource = getClass().getResource("../view/Admin_MealOperator.fxml");
            Parent load = FXMLLoader.load(resource);
            roomOperatorRoot.getChildren().clear();
            roomOperatorRoot.getChildren().add(load);
        }
    }

    @FXML
    void goBackBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) roomBack.getScene().getWindow();
        stage.close();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"));

        primaryStage.setTitle("Blue Ocean v-1.0.0");
        primaryStage.setScene(new Scene(root,1230,739));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public Rooms search(String roomNo){
        for (Rooms r: observableList) {
            if(r.getRoomNo().equals(roomNo)){
                return r;
            }
        }
        return null;
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
