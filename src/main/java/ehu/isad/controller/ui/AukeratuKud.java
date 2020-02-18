package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class AukeratuKud implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ivLogo.setImage(new Image("/argazkiak/logo.png"));
        lblTaldea.setText("PK_ClevelandChavaliers");
    }

    @FXML
    private Button btn2Jokalari;
    @FXML
    private Button btnErraza;
    @FXML
    private Button btnZaila;
    @FXML
    private ImageView ivLogo;
    @FXML
    private Label lblTaldea;

    private Main mainApp;


    @FXML
    public void onClick2Jokalari(ActionEvent actionEvent) {
        this.mainApp.mainErakutsi("biJokalari");
    }

    @FXML
    public void onClickErraza(ActionEvent actionEvent) {

        this.mainApp.mainErakutsi("random");
    }

    @FXML
    public void onClickZaila(ActionEvent actionEvent) {

        this.mainApp.mainErakutsi("makinarenKontra");
    }

    public void setMainApp(Main main) { this.mainApp=main;}

}
