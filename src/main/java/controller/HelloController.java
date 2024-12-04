package controller;

import dao.DataDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DataEntity;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField field;

    @FXML
    private SubPageController subPageController; // fx:idcontroller

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        DataDAO dataDAO = new DataDAO();
        DataEntity dataEntity = dataDAO.findById(1);
        if (dataEntity != null) {
            label.setText(dataEntity.toString());
        } else {
            label.setText("Aucune donnée trouvée.");
        }
    }


    public void handleChangeScene(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //  cherche la page où on est a partir de quel element on a declencher qlq chose

        // Chargement du FXML et du contrôleur associé
        VBox root = (VBox) FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource(
                "fxml/home.fxml")));

        // Changement de scene
        currentStage.setScene(new Scene(root));
    }

    public void handleClick(ActionEvent event) {
        String valueFromUser = field.getText();
        label.setText(valueFromUser);
        subPageController.updateLabel(valueFromUser);

        DataDAO dataDAO = new DataDAO();
        DataEntity dataEntity = dataDAO.findById(Integer.parseInt(valueFromUser));
        if (dataEntity != null) {
            label.setText(dataEntity.toString());
        } else {
            label.setText("Aucune donnée trouvée.");
        }
    }
}
