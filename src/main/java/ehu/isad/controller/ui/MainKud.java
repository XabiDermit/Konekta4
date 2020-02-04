package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainKud implements Initializable {

    //atributuak

    private Main mainApp;

    //botoiak

    @FXML
    private Button btnSartu1;
    @FXML
    private Button btnSartu2;
    @FXML
    private Button btnSartu3;
    @FXML
    private Button btnSartu4;
    @FXML
    private Button btnSartu5;
    @FXML
    private Button btnSartu6;
    @FXML
    private Button btnSartu7;
    @FXML
    private Button btnSartu8;
    @FXML
    private Button btnSartu9;
    @FXML
    private Button btnAmoreEman;

    //Txanda

    @FXML
    private Label lblTxanda;
    @FXML
    private TextField tfTxanda;

    //Fitxak

    @FXML
    private ImageView iv1x1;
    @FXML
    private ImageView iv1x2;
    @FXML
    private ImageView iv1x3;
    @FXML
    private ImageView iv1x4;
    @FXML
    private ImageView iv1x5;
    @FXML
    private ImageView iv1x6;
    @FXML
    private ImageView iv1x7;
    @FXML
    private ImageView iv1x8;
    @FXML
    private ImageView iv1x9;

    @FXML
    private ImageView iv2x1;
    @FXML
    private ImageView iv2x2;
    @FXML
    private ImageView iv2x3;
    @FXML
    private ImageView iv2x4;
    @FXML
    private ImageView iv2x5;
    @FXML
    private ImageView iv2x6;
    @FXML
    private ImageView iv2x7;
    @FXML
    private ImageView iv2x8;
    @FXML
    private ImageView iv2x9;

    @FXML
    private ImageView iv3x1;
    @FXML
    private ImageView iv3x2;
    @FXML
    private ImageView iv3x3;
    @FXML
    private ImageView iv3x4;
    @FXML
    private ImageView iv3x5;
    @FXML
    private ImageView iv3x6;
    @FXML
    private ImageView iv3x7;
    @FXML
    private ImageView iv3x8;
    @FXML
    private ImageView iv3x9;

    @FXML
    private ImageView iv4x1;
    @FXML
    private ImageView iv4x2;
    @FXML
    private ImageView iv4x3;
    @FXML
    private ImageView iv4x4;
    @FXML
    private ImageView iv4x5;
    @FXML
    private ImageView iv4x6;
    @FXML
    private ImageView iv4x7;
    @FXML
    private ImageView iv4x8;
    @FXML
    private ImageView iv4x9;

    @FXML
    private ImageView iv5x1;
    @FXML
    private ImageView iv5x2;
    @FXML
    private ImageView iv5x3;
    @FXML
    private ImageView iv5x4;
    @FXML
    private ImageView iv5x5;
    @FXML
    private ImageView iv5x6;
    @FXML
    private ImageView iv5x7;
    @FXML
    private ImageView iv5x8;
    @FXML
    private ImageView iv5x9;

    @FXML
    private ImageView iv6x1;
    @FXML
    private ImageView iv6x2;
    @FXML
    private ImageView iv6x3;
    @FXML
    private ImageView iv6x4;
    @FXML
    private ImageView iv6x5;
    @FXML
    private ImageView iv6x6;
    @FXML
    private ImageView iv6x7;
    @FXML
    private ImageView iv6x8;
    @FXML
    private ImageView iv6x9;



    //botoien metodoak

    @FXML
    public void onClickSartu1(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickSartu2(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickSartu3(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickSartu4(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickSartu5(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickSartu6(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickSartu7(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickSartu8(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickSartu9(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickAmoreEman(ActionEvent actionEvent) {
        this.mainApp.aukerakErakutsi();
    }


    //beste metodoak

    public void setMainApp(Main main) { this.mainApp = main;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
