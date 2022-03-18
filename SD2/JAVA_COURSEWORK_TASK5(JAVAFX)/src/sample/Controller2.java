package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller2 {
    @FXML
    Label fNameText;
    Label cityText;
    Label nicText;
    Label ageText;
    Label lNameText;



    public void displayInfo(String firstName, String lastName, String cityName, String idNumber) {
        fNameText.setText(firstName);
        lNameText.setText(lastName);
        nicText.setText(idNumber);
        cityText.setText(cityName);
    }
}
