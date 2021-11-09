package controller;

import Model.AnnuallyIncomeReport;
import Model.MonthlyIncomeReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Admin_ShowReportsController implements Initializable {
    @FXML
    private AnchorPane reportRoot;

    @FXML
    private TableView<MonthlyIncomeReport> monthlyIncomeTable;

    @FXML
    private TableColumn<?, ?> week1;

    @FXML
    private TableColumn<?, ?> week2;

    @FXML
    private TableColumn<?, ?> week3;

    @FXML
    private TableColumn<?, ?> week4;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private LineChart<?, ?> AnnualLineChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private TableView<AnnuallyIncomeReport> AnnualReoportTable;

    @FXML
    private TableColumn<?, ?> jan;

    @FXML
    private TableColumn<?, ?> feb;

    @FXML
    private TableColumn<?, ?> mar;

    @FXML
    private TableColumn<?, ?> april;

    @FXML
    private TableColumn<?, ?> may;

    @FXML
    private TableColumn<?, ?> june;

    @FXML
    private TableColumn<?, ?> aug;

    @FXML
    private TableColumn<?, ?> sep;

    @FXML
    private TableColumn<?, ?> oct;

    @FXML
    private TableColumn<?, ?> nov;

    @FXML
    private TableColumn<?, ?> dec;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        week1.setCellValueFactory(new PropertyValueFactory<>("week1"));
        week2.setCellValueFactory(new PropertyValueFactory<>("week2"));
        week3.setCellValueFactory(new PropertyValueFactory<>("week3"));
        week4.setCellValueFactory(new PropertyValueFactory<>("week4"));
        monthlyIncomeTable.setItems(monthlyIncomeObservableList);

        jan.setCellValueFactory(new PropertyValueFactory<>("jan"));
        feb.setCellValueFactory(new PropertyValueFactory<>("feb"));
        mar.setCellValueFactory(new PropertyValueFactory<>("mar"));
        april.setCellValueFactory(new PropertyValueFactory<>("apr"));
        may.setCellValueFactory(new PropertyValueFactory<>("may"));
        june.setCellValueFactory(new PropertyValueFactory<>("june"));
        aug.setCellValueFactory(new PropertyValueFactory<>("aug"));
        sep.setCellValueFactory(new PropertyValueFactory<>("sep"));
        oct.setCellValueFactory(new PropertyValueFactory<>("oct"));
        nov.setCellValueFactory(new PropertyValueFactory<>("nov"));
        dec.setCellValueFactory(new PropertyValueFactory<>("dec"));
        AnnualReoportTable.setItems(annuallyIncomeObservableList);

        //---------------------------------------------------------------

        XYChart.Series m = new XYChart.Series<>();

        m.getData().add(new XYChart.Data<>("week 01",100000));
        m.getData().add(new XYChart.Data<>("week 02",120000));
        m.getData().add(new XYChart.Data<>("week 03",110000));
        m.getData().add(new XYChart.Data<>("week 04",140000));

        lineChart.getData().addAll(m);

        //--------------------------------------------------------------

        XYChart.Series a = new XYChart.Series<>();

        a.getData().add(new XYChart.Data<>("Jan",16000000));
        a.getData().add(new XYChart.Data<>("Feb",12000000));
        a.getData().add(new XYChart.Data<>("Mar",11000000));
        a.getData().add(new XYChart.Data<>("Apr",14000000));
        a.getData().add(new XYChart.Data<>("May",14000000));
        a.getData().add(new XYChart.Data<>("June",10000000));
        a.getData().add(new XYChart.Data<>("Aug",11000000));
        a.getData().add(new XYChart.Data<>("Sept",19000000));
        a.getData().add(new XYChart.Data<>("Oct",12300000));
        a.getData().add(new XYChart.Data<>("Nov",12000000));
        a.getData().add(new XYChart.Data<>("ADecug",19000000));

        AnnualLineChart.getData().addAll(a);

    }

    ObservableList<MonthlyIncomeReport> monthlyIncomeObservableList = FXCollections.observableArrayList(
           new MonthlyIncomeReport("30000.00","31000.00","28000.00","44000.00"),
            new MonthlyIncomeReport("20000.00","28000.00","28000.00","44000.00"),
            new MonthlyIncomeReport("40000.00","56000.00","28000.00","28000.00"),
            new MonthlyIncomeReport("56000.00","31000.00","28000.00","44000.00"),
            new MonthlyIncomeReport("76000.00","31000.00","28000.00","28000.00"),
            new MonthlyIncomeReport("89000.00","56000.00","56000.00","44000.00"),
            new MonthlyIncomeReport("120000.00","31000.00","28000.00","44000.00"),
            new MonthlyIncomeReport("10000.00","31000.00","28000.00","56000.00"),
            new MonthlyIncomeReport("420000.00","31000.00","28000.00","12000.00"),
            new MonthlyIncomeReport("12000.00","31000.00","56000.00","44000.00"),
            new MonthlyIncomeReport("76000.00","31000.00","28000.00","28000.00"),
            new MonthlyIncomeReport("89000.00","56000.00","56000.00","44000.00"),
            new MonthlyIncomeReport("120000.00","31000.00","28000.00","44000.00"),
            new MonthlyIncomeReport("10000.00","31000.00","28000.00","56000.00"),
            new MonthlyIncomeReport("420000.00","31000.00","28000.00","12000.00"),
            new MonthlyIncomeReport("12000.00","31000.00","56000.00","44000.00")
    );

    ObservableList<AnnuallyIncomeReport> annuallyIncomeObservableList = FXCollections.observableArrayList(
            new AnnuallyIncomeReport("100K","140K","130K","330K","220K","110K","220K","550K","440K","330","220"),
            new AnnuallyIncomeReport("140K","140K","220K","330K","220K","110K","550K","130K","220","330","440K"),
            new AnnuallyIncomeReport("140K","140K","330K","430K","550K","110K","110K","220K","280","930","480K"),
            new AnnuallyIncomeReport("140K","140K","330K","430K","550K","110K","110K","220K","280","930","480K"),
            new AnnuallyIncomeReport("140K","140K","330K","430K","550K","110K","110K","220K","280","930","480K"),
            new AnnuallyIncomeReport("140K","140K","220K","330K","220K","110K","550K","130K","220","330","440K"),
            new AnnuallyIncomeReport("140K","140K","330K","430K","550K","110K","110K","220K","280","930","480K"),
            new AnnuallyIncomeReport("140K","140K","330K","430K","550K","110K","110K","220K","280","930","480K"),
            new AnnuallyIncomeReport("140K","140K","330K","430K","550K","110K","110K","220K","280","930","480K"),
            new AnnuallyIncomeReport("140K","140K","220K","330K","220K","110K","550K","130K","220","330","440K"),
            new AnnuallyIncomeReport("140K","140K","330K","430K","550K","110K","110K","220K","280","930","480K"),
            new AnnuallyIncomeReport("140K","140K","330K","430K","550K","110K","110K","220K","280","930","480K"),
            new AnnuallyIncomeReport("140K","140K","330K","430K","550K","110K","110K","220K","280","930","480K"),
            new AnnuallyIncomeReport("140K","140K","220K","330K","220K","110K","550K","130K","220","330","440K"),
            new AnnuallyIncomeReport("140K","140K","330K","430K","550K","110K","110K","220K","280","930","480K"),
            new AnnuallyIncomeReport("140K","140K","330K","430K","550K","110K","110K","220K","280","930","480K"),
            new AnnuallyIncomeReport("140K","140K","330K","430K","550K","110K","110K","220K","280","930","480K")
    );

    @FXML
    void btnDone(ActionEvent event) throws IOException {
        boolean res = displayModalPopup(Alert.AlertType.CONFIRMATION,"Continue","Save data and Continue ?");

        if(res){
            URL resource = getClass().getResource("../view/FinalRoot.fxml");
            Parent load = FXMLLoader.load(resource);
            reportRoot.getChildren().clear();
            reportRoot.getChildren().add(load);
        }
    }

    @FXML
    void goBackBtn(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../view/Admin_MealOperator.fxml");
        Parent load = FXMLLoader.load(resource);
        reportRoot.getChildren().clear();
        reportRoot.getChildren().add(load);
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
