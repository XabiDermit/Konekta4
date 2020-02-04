package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AukeratuKud implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Button btnNormal;
    @FXML
    private Button btnFacil;
    @FXML
    private Button btnDificil;

    private Main mainApp;


    @FXML
    public void onClickNormal(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickFacil(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickDificil(ActionEvent actionEvent) {
    }

    public void setMainApp(Main main) { this.mainApp=main;
    }
}
