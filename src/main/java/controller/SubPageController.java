package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class SubPageController implements Initializable {

    @FXML
    private HelloController parentController;

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        label.setText("text");
    }

    public void updateLabel(String value){
        label.setText(value);
    }

    public void setParentController(HelloController parentController) {
        this.parentController = parentController;
    }
}
