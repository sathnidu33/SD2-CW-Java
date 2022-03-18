package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Controller1 {

    @FXML
    TextField firstnameField;
    @FXML
    TextField cityField;
    @FXML
    TextField nicNumberField;
    @FXML
    TextField ageField;
    @FXML
    TextField lastNameField;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void showOutput(ActionEvent event) throws IOException {

        String firstName=firstnameField.getText();
        String lastName=lastNameField.getText();
        String cityName=cityField.getText();
        String idNumber=nicNumberField.getText();

        FXMLLoader loader=new FXMLLoader(getClass().getResource("output.fxml"));
        root=loader.load();

        Controller2 controller2=loader.getController();
        controller2.displayInfo(firstName,lastName,cityName, idNumber);

    }
}
