package sample.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.sql.SQLException;

public class ControllerAddMenu {
    @FXML
    private Button btnCancel;
    //-----Строки-----
    @FXML
    private TextField fldPosition;
    @FXML
    private TextField fldFIO;
    @FXML
    private TextField fldSex;
    @FXML
    private TextArea fldResume;
    @FXML
    private TextField fldDOB;
    @FXML
    private TextField fldUploadData;




    @FXML
    private void initialize(){



    }

    public void close(ActionEvent actionEvent) {
        CloseWindow();

    }

    public void Adding(ActionEvent actionEvent) throws ClassNotFoundException {
        try {
            DBConnector.Connect();
            DBConnector.CreateDB();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String position = fldPosition.getText();
        String fio = fldFIO.getText();
        String sex = fldSex.getText();
        String resume = fldResume.getText();
        String dob = fldDOB.getText();
        String uploadData = fldUploadData.getText();
        try {
            DBConnector.WriteDB(position, fio, sex, resume, dob, uploadData);
            DBConnector.CloseDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseWindow();
    }
    private void CloseWindow(){
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
