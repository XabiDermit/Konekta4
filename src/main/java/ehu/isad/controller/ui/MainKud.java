package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.model.Fitxa;
import ehu.isad.model.Tableroa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Random;
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
    @FXML
    private Button btnBukatu;

    //Txanda

    @FXML
    private Label lblTxanda;

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

    private int erronda = 0;

    private String txanda = "fitxaUrdina"; //fitxaGorria edo fitxaUrdina(hasieran)

    @FXML
    private ImageView ivLogo;

    @FXML
    private Label lblZutabeaBeteta;
    @FXML
    private Label lblTaldea;

    private String jokoModua;

    private int partidarenEmaitza=-1;

    private long denbora;


    //botoien metodoak

    @FXML
    public void onClickSartu1(ActionEvent actionEvent) { this.botoiaSakatu(0); }

    @FXML
    public void onClickSartu2(ActionEvent actionEvent) { this.botoiaSakatu(1); }

    @FXML
    public void onClickSartu3(ActionEvent actionEvent) { this.botoiaSakatu(2); }

    @FXML
    public void onClickSartu4(ActionEvent actionEvent) { this.botoiaSakatu(3); }

    @FXML
    public void onClickSartu5(ActionEvent actionEvent) { this.botoiaSakatu(4); }

    @FXML
    public void onClickSartu6(ActionEvent actionEvent) { this.botoiaSakatu(5); }

    @FXML
    public void onClickSartu7(ActionEvent actionEvent) { this.botoiaSakatu(6); }

    @FXML
    public void onClickSartu8(ActionEvent actionEvent) { this.botoiaSakatu(7); }

    @FXML
    public void onClickSartu9(ActionEvent actionEvent) { this.botoiaSakatu(8); }

    @FXML
    public void onClickAmoreEman(ActionEvent actionEvent) {
        this.partidaBukatu();mainApp.aukerakErakutsi();
    }

    @FXML
    public void onClickBukatu(ActionEvent actionEvent){
        if(partidarenEmaitza==0){
            mainApp.partidareEmaitzaIkusi("",jokoModua,denbora);
        }else if(partidarenEmaitza==1){
            mainApp.partidareEmaitzaIkusi("fitxaGorria",jokoModua,denbora);
        }else if (partidarenEmaitza==2){
            mainApp.partidareEmaitzaIkusi("fitxaUrdina",jokoModua,denbora);
        }
        partidaBukatu();
    }


    //beste metodoak

    public void botoiaSakatu(int i){
        this.erronda++;
        this.lblZutabeaBeteta.setVisible(false);
        int errenkada = this.fitxaSartu(i, this.txanda);
        Image irudia = this.irudiaEsleitu();

        if (errenkada==10){
            //aukeratu duen zutabea beteta dago
            lblZutabeaBeteta.setVisible(true);
            this.erronda--;
            return;

        }else if(i==0) {
            if (errenkada == 0) {
                iv1x1.setImage(irudia);
            } else if (errenkada == 1) {
                iv2x1.setImage(irudia);
            } else if (errenkada == 2) {
                iv3x1.setImage(irudia);
            } else if (errenkada == 3) {
                iv4x1.setImage(irudia);
            } else if (errenkada == 4) {
                iv5x1.setImage(irudia);
            } else if (errenkada == 5) {
                iv6x1.setImage(irudia);
            }
        }else if(i==1) {
            if (errenkada == 0) {
                iv1x2.setImage(irudia);
            } else if (errenkada == 1) {
                iv2x2.setImage(irudia);
            } else if (errenkada == 2) {
                iv3x2.setImage(irudia);
            } else if (errenkada == 3) {
                iv4x2.setImage(irudia);
            } else if (errenkada == 4) {
                iv5x2.setImage(irudia);
            } else if (errenkada == 5) {
                iv6x2.setImage(irudia);
            }
        }else if(i==2) {
            if (errenkada == 0) {
                iv1x3.setImage(irudia);
            } else if (errenkada == 1) {
                iv2x3.setImage(irudia);
            } else if (errenkada == 2) {
                iv3x3.setImage(irudia);
            } else if (errenkada == 3) {
                iv4x3.setImage(irudia);
            } else if (errenkada == 4) {
                iv5x3.setImage(irudia);
            } else if (errenkada == 5) {
                iv6x3.setImage(irudia);
            }
        }else if(i==3) {
            if (errenkada == 0) {
                iv1x4.setImage(irudia);
            } else if (errenkada == 1) {
                iv2x4.setImage(irudia);
            } else if (errenkada == 2) {
                iv3x4.setImage(irudia);
            } else if (errenkada == 3) {
                iv4x4.setImage(irudia);
            } else if (errenkada == 4) {
                iv5x4.setImage(irudia);
            } else if (errenkada == 5) {
                iv6x4.setImage(irudia);
            }
        }else if(i==4) {
            if (errenkada == 0) {
                iv1x5.setImage(irudia);
            } else if (errenkada == 1) {
                iv2x5.setImage(irudia);
            } else if (errenkada == 2) {
                iv3x5.setImage(irudia);
            } else if (errenkada == 3) {
                iv4x5.setImage(irudia);
            } else if (errenkada == 4) {
                iv5x5.setImage(irudia);
            } else if (errenkada == 5) {
                iv6x5.setImage(irudia);
            }
        }else if(i==5) {
            if (errenkada == 0) {
                iv1x6.setImage(irudia);
            } else if (errenkada == 1) {
                iv2x6.setImage(irudia);
            } else if (errenkada == 2) {
                iv3x6.setImage(irudia);
            } else if (errenkada == 3) {
                iv4x6.setImage(irudia);
            } else if (errenkada == 4) {
                iv5x6.setImage(irudia);
            } else if (errenkada == 5) {
                iv6x6.setImage(irudia);
            }
        }else if(i==6) {
            if (errenkada == 0) {
                iv1x7.setImage(irudia);
            } else if (errenkada == 1) {
                iv2x7.setImage(irudia);
            } else if (errenkada == 2) {
                iv3x7.setImage(irudia);
            } else if (errenkada == 3) {
                iv4x7.setImage(irudia);
            } else if (errenkada == 4) {
                iv5x7.setImage(irudia);
            } else if (errenkada == 5) {
                iv6x7.setImage(irudia);
            }
        }else if(i==7) {
            if (errenkada == 0) {
                iv1x8.setImage(irudia);
            } else if (errenkada == 1) {
                iv2x8.setImage(irudia);
            } else if (errenkada == 2) {
                iv3x8.setImage(irudia);
            } else if (errenkada == 3) {
                iv4x8.setImage(irudia);
            } else if (errenkada == 4) {
                iv5x8.setImage(irudia);
            } else if (errenkada == 5) {
                iv6x8.setImage(irudia);
            }
        }else if(i==8) {
            if (errenkada == 0) {
                iv1x9.setImage(irudia);
            } else if (errenkada == 1) {
                iv2x9.setImage(irudia);
            } else if (errenkada == 2) {
                iv3x9.setImage(irudia);
            } else if (errenkada == 3) {
                iv4x9.setImage(irudia);
            } else if (errenkada == 4) {
                iv5x9.setImage(irudia);
            } else if (errenkada == 5) {
                iv6x9.setImage(irudia);
            }
        }

        if (this.erronda >= 7){
            partidarenEmaitza = this.konprobatu();
            /*
            partidaEmaitza== -1 --> partida ez da bukatu
            partidaEmaitza== 0 --> enpate bat egon da
            partidaEmaitza== 1 --> fitxaGorriak irabazi dute
            partidaEmaitza== 2 --> fitxaUrdinak irabazi dute
             */
            if (partidarenEmaitza==0){
                denbora = (System.nanoTime() -denbora)/1000000000;
                btnAmoreEman.setVisible(false);
                btnSartu1.setVisible(false);
                btnSartu2.setVisible(false);
                btnSartu3.setVisible(false);
                btnSartu4.setVisible(false);
                btnSartu5.setVisible(false);
                btnSartu6.setVisible(false);
                btnSartu7.setVisible(false);
                btnSartu8.setVisible(false);
                btnSartu9.setVisible(false);
                btnBukatu.setVisible(true);
                return;
            }else if (partidarenEmaitza== 1){
                denbora = (System.nanoTime() -denbora)/1000000000;
                fitxaIrabazleakAldatu(txanda);
                return;

            }else if (partidarenEmaitza == 2){
                denbora = (System.nanoTime() -denbora)/1000000000;
                fitxaIrabazleakAldatu(txanda);
                return;
            }
        }

        this.txandaAldatu();


        if("random".equals(this.jokoModua) && "fitxaGorria".equals(this.txanda)){
            this.fitxaZorizSartu();
        }else if("makinarenKontra".equals(this.jokoModua) && "fitxaGorria".equals(this.txanda)){
            this.makinarenKontraJolastu();
        }

    }

    private void fitxaIrabazleakAldatu(String txanda) {
        btnAmoreEman.setVisible(false);
        btnSartu1.setVisible(false);
        btnSartu2.setVisible(false);
        btnSartu3.setVisible(false);
        btnSartu4.setVisible(false);
        btnSartu5.setVisible(false);
        btnSartu6.setVisible(false);
        btnSartu7.setVisible(false);
        btnSartu8.setVisible(false);
        btnSartu9.setVisible(false);
        btnBukatu.setVisible(true);
        Image fitxaIrabazleaIrudia;
        if (txanda.equals("fitxaUrdina")){
            fitxaIrabazleaIrudia = new Image("/Irudiak/fitxaUrdinaIrabazle.png");
        }else{
            fitxaIrabazleaIrudia = new Image("/Irudiak/fitxaGorriaIrabazle.png");
        }
        Fitxa[] fitxaIrabazleak = Tableroa.getInstantzia().getFitxaIrabazleakKokapena();
        for (int i=0; i<4;i++){
            int[] hunekoFitxaIrabazleaKokapena = fitxaIrabazleak[i].getKokapena();
            int hunekoX = hunekoFitxaIrabazleaKokapena[0];
            int hunekoY = hunekoFitxaIrabazleaKokapena[1];
            if (hunekoX==0){
                if(hunekoY==0){
                    iv1x1.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==1){
                    iv2x1.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==2){
                    iv3x1.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==3){
                    iv4x1.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==4){
                    iv5x1.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==5){
                    iv6x1.setImage(fitxaIrabazleaIrudia);
                }
            }
            if (hunekoX==1){
                if(hunekoY==0){
                    iv1x2.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==1){
                    iv2x2.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==2){
                    iv3x2.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==3){
                    iv4x2.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==4){
                    iv5x2.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==5){
                    iv6x2.setImage(fitxaIrabazleaIrudia);
                }
            }
            if (hunekoX==2){
                if(hunekoY==0){
                    iv1x3.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==1){
                    iv2x3.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==2){
                    iv3x3.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==3){
                    iv4x3.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==4){
                    iv5x3.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==5){
                    iv6x3.setImage(fitxaIrabazleaIrudia);
                }
            }
            if (hunekoX==3){
                if(hunekoY==0){
                    iv1x4.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==1){
                    iv2x4.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==2){
                    iv3x4.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==3){
                    iv4x4.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==4){
                    iv5x4.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==5){
                    iv6x4.setImage(fitxaIrabazleaIrudia);
                }
            }
            if (hunekoX==4){
                if(hunekoY==0){
                    iv1x5.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==1){
                    iv2x5.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==2){
                    iv3x5.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==3){
                    iv4x5.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==4){
                    iv5x5.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==5){
                    iv6x5.setImage(fitxaIrabazleaIrudia);
                }
            }
            if (hunekoX==5){
                if(hunekoY==0){
                    iv1x6.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==1){
                    iv2x6.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==2){
                    iv3x6.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==3){
                    iv4x6.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==4){
                    iv5x6.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==5){
                    iv6x6.setImage(fitxaIrabazleaIrudia);
                }
            }
            if (hunekoX==6){
                if(hunekoY==0){
                    iv1x7.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==1){
                    iv2x7.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==2){
                    iv3x7.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==3){
                    iv4x7.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==4){
                    iv5x7.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==5){
                    iv6x7.setImage(fitxaIrabazleaIrudia);
                }
            }
            if (hunekoX==7){
                if(hunekoY==0){
                    iv1x8.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==1){
                    iv2x8.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==2){
                    iv3x8.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==3){
                    iv4x8.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==4){
                    iv5x8.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==5){
                    iv6x8.setImage(fitxaIrabazleaIrudia);
                }
            }
            if (hunekoX==8){
                if(hunekoY==0){
                    iv1x9.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==1){
                    iv2x9.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==2){
                    iv3x9.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==3){
                    iv4x9.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==4){
                    iv5x9.setImage(fitxaIrabazleaIrudia);
                }
                if(hunekoY==5){
                    iv6x9.setImage(fitxaIrabazleaIrudia);
                }
            }

        }
    }

    private void partidaBukatu(){
        txanda= "fitxaUrdina";
        lblTxanda.setText("Txanda: Fitxa Urdina");
        this.fitxakKendu();
        Tableroa.getInstantzia().tableroaEzabatu();
        this.erronda=0;
        this.setJokoModua(" ");
    }


    public void setMainApp(Main main) { this.mainApp = main;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    private int fitxaSartu(int pZutabea,String pTxanda){
        return Tableroa.getInstantzia().fitxaSartu(pZutabea, pTxanda);
    }

    private Image irudiaEsleitu(){
        if ("fitxaUrdina".equals(txanda)){ return new Image("/Irudiak/fitxaUrdina.png");}
        else{ return new Image("/Irudiak/fitxaGorria.png");}
    }

    private void txandaAldatu(){
        if ("fitxaUrdina".equals(txanda)){
            txanda = "fitxaGorria";
            lblTxanda.setText("Txanda: Fitxa Gorria");
        }
        else{
            txanda = "fitxaUrdina";
            lblTxanda.setText("Txanda: Fitxa Urdina");
        }
    }

    public int konprobatu(){
        return Tableroa.getInstantzia().konprobatu();
    }

    private void itxaron(long pZenbat){
        try {
            Thread.sleep(pZenbat);
        }catch (InterruptedException e ){
            e.printStackTrace();
        }
    }

    public void setJokoModua(String jokoModua) {
        this.jokoModua = jokoModua;
    }

    private void fitxaZorizSartu(){
        Random rd = new Random();
        int zutabea = rd.nextInt(9);
        while(fitxaSartu(zutabea,txanda)==10){
            zutabea = rd.nextInt(9);
        }
        Tableroa.getInstantzia().fitxaAtera(zutabea);
        this.botoiaSakatu(zutabea);
    }

    private void makinarenKontraJolastu(){
        int aImugimendua;
        if (erronda==1){
            aImugimendua=4;
        }else {
            aImugimendua = Tableroa.getInstantzia().lortuAImugimendua();
        }
        this.botoiaSakatu(aImugimendua);
    }

    private void fitxakKendu(){
        //fitxak hasieran hutsi
        Image hutsik = new Image("/Irudiak/hutsik.png");
        iv1x1.setImage(hutsik);
        iv1x2.setImage(hutsik);
        iv1x3.setImage(hutsik);
        iv1x4.setImage(hutsik);
        iv1x5.setImage(hutsik);
        iv1x6.setImage(hutsik);
        iv1x7.setImage(hutsik);
        iv1x8.setImage(hutsik);
        iv1x9.setImage(hutsik);
        iv2x1.setImage(hutsik);
        iv2x2.setImage(hutsik);
        iv2x3.setImage(hutsik);
        iv2x4.setImage(hutsik);
        iv2x5.setImage(hutsik);
        iv2x6.setImage(hutsik);
        iv2x7.setImage(hutsik);
        iv2x8.setImage(hutsik);
        iv2x9.setImage(hutsik);
        iv3x1.setImage(hutsik);
        iv3x2.setImage(hutsik);
        iv3x3.setImage(hutsik);
        iv3x4.setImage(hutsik);
        iv3x5.setImage(hutsik);
        iv3x6.setImage(hutsik);
        iv3x7.setImage(hutsik);
        iv3x8.setImage(hutsik);
        iv3x9.setImage(hutsik);
        iv4x1.setImage(hutsik);
        iv4x2.setImage(hutsik);
        iv4x3.setImage(hutsik);
        iv4x4.setImage(hutsik);
        iv4x5.setImage(hutsik);
        iv4x6.setImage(hutsik);
        iv4x7.setImage(hutsik);
        iv4x8.setImage(hutsik);
        iv4x9.setImage(hutsik);
        iv5x1.setImage(hutsik);
        iv5x2.setImage(hutsik);
        iv5x3.setImage(hutsik);
        iv5x4.setImage(hutsik);
        iv5x5.setImage(hutsik);
        iv5x6.setImage(hutsik);
        iv5x7.setImage(hutsik);
        iv5x8.setImage(hutsik);
        iv5x9.setImage(hutsik);
        iv6x1.setImage(hutsik);
        iv6x2.setImage(hutsik);
        iv6x3.setImage(hutsik);
        iv6x4.setImage(hutsik);
        iv6x5.setImage(hutsik);
        iv6x6.setImage(hutsik);
        iv6x7.setImage(hutsik);
        iv6x8.setImage(hutsik);
        iv6x9.setImage(hutsik);
    }


    public void guztiaPrestatu() {
        //defektuz hasieran
        btnBukatu.setVisible(false);
        btnAmoreEman.setVisible(true);
        btnSartu1.setVisible(true);
        btnSartu2.setVisible(true);
        btnSartu3.setVisible(true);
        btnSartu4.setVisible(true);
        btnSartu5.setVisible(true);
        btnSartu6.setVisible(true);
        btnSartu7.setVisible(true);
        btnSartu8.setVisible(true);
        btnSartu9.setVisible(true);
        lblTxanda.setText("Txanda: Fitxa Urdina");
        ivLogo.setImage(new Image("/Irudiak/logo.png"));
        this.fitxakKendu();
        partidarenEmaitza=-1;
        denbora = System.nanoTime();
    }
}
