package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class PartidaAmaieraKud implements Initializable {

    private Main mainApp;
    @FXML
    private Button btnJarraitu;
    @FXML
    private ImageView ivMezua;

    private String jokoModua;
    private long denbora;
    private String irabazlea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void onClickJarraitu(ActionEvent actionEvent) {
        if((("random").equals(jokoModua)&& ("fitxaUrdina").equals(irabazlea))||(("makinarenKontra").equals(jokoModua)&&("fitxaUrdina").equals(irabazlea))){
            mainApp.rankingTaulaErakutsi(jokoModua,denbora);
        }else{
            mainApp.aukerakErakutsi();
        }

    }

    public void setJokoModua(String pMota){
        this.jokoModua=pMota;
    }

    public void setIrabazlea(String pIrabazlea){
        if("fitxaUrdina".equals(pIrabazlea)){
            ivMezua.setImage(new Image("/Irudiak/UrdinaIrabazle.gif"));
        }else if ("fitxaGorria".equals(pIrabazlea)){
            ivMezua.setImage(new Image("/Irudiak/GorriaIrabazle.gif"));
        }else{
            ivMezua.setImage(new Image("/Irudiak/berdinketa.gif"));
        }
        irabazlea = pIrabazlea;
    }

    public void setMainApp(Main main) {
        mainApp=main;
    }

    public void setDenbora(long pDenbora) {
        this.denbora = pDenbora;
    }
}
