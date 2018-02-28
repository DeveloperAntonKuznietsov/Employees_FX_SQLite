package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Employee.CollectionEmployee;
import sample.Employee.Person;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerMainMenu {

    //private ObservableList<Person> usersData = FXCollections.observableArrayList();
    static CollectionEmployee collectionEmployee = new CollectionEmployee();

    @FXML
    private TableView<Person> tableView;

    @FXML
    private TableColumn<Person, Integer> columPosition;

    @FXML
    private TableColumn<Person, String> columFIO;

    @FXML
    private TableColumn<Person, String> columSex;

    @FXML
    private TableColumn<Person, String> columResume;
    @FXML
    private TableColumn<Person, String> columDOB;
    @FXML
    private TableColumn<Person, String> columUploadData;

    // инициализируем форму данными
    @FXML
    private void initialize() {
      try{

          DBConnector.Connect();// открываем соединение с бд
          DBConnector.CreateDB();// проверяем на наличие табл.(если нет создаем)
          DBConnector.ReadDB();// считываем  с табл.

        // устанавливаем тип и значение которое должно хранится в колонке и откуда беруться данные
        columPosition.setCellValueFactory(new PropertyValueFactory<Person, Integer>("position"));
        columFIO.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columSex.setCellValueFactory(new PropertyValueFactory<Person, String>("sex"));
        columDOB.setCellValueFactory(new PropertyValueFactory<Person, String>("dob"));
        columUploadData.setCellValueFactory(new PropertyValueFactory<Person, String>("uploadData"));
        columResume.setCellValueFactory(new PropertyValueFactory<Person, String>("resume"));

        // заполняем таблицу данными
        tableView.setItems(collectionEmployee.getPersonList());
        DBConnector.CloseDB();// заерываем все соединения
      }catch (Exception e){e.printStackTrace();}
    }


    public void shhowAddDialog(ActionEvent actionEvent) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/addmenu.fxml"));
            stage.setTitle("Добавление нового сотрудника");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception e){e.printStackTrace();}
    }
}