package ehu.isad.controller.ui;

import ehu.isad.Main;
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
import java.util.Timer;
import java.util.TimerTask;

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


    //botoien metodoak

    @FXML
    public void onClickSartu1(ActionEvent actionEvent) {
        this.erronda++;
        this.lblZutabeaBeteta.setVisible(false);
        int errenkada = this.fitxaSartu(0, this.txanda);
        Image irudia = this.irudiaEsleitu();

        if (errenkada==10){
            //aukeratu duen zutabea beteta dago
            lblZutabeaBeteta.setVisible(true);
            this.erronda--;

        }else {
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

            this.txandaAldatu();

            if (this.erronda >= 7 && this.konprobatu()) {
                this.itxaron(5000);
                this.amoreEman();
            }

        }if("random".equals(this.jokoModua) && "fitxaGorria".equals(this.txanda)){
            this.fitxaZorizSartu();
        }
    }

    @FXML
    public void onClickSartu2(ActionEvent actionEvent) {
        this.erronda++;
        this.lblZutabeaBeteta.setVisible(false);
        int errenkada = this.fitxaSartu(1, this.txanda);
        Image irudia = this.irudiaEsleitu();

        if(errenkada==10){
            //aukeratu duen zutabea beteta dago
            lblZutabeaBeteta.setVisible(true);
            this.erronda--;
        }else{
            if (errenkada == 0){
                iv1x2.setImage(irudia);
            }else if(errenkada==1){
                iv2x2.setImage(irudia);
            }else if(errenkada==2){
                iv3x2.setImage(irudia);
            }else if(errenkada==3){
                iv4x2.setImage(irudia);
            }else if(errenkada==4){
                iv5x2.setImage(irudia);
            }else {
                iv6x2.setImage(irudia);
            }

            this.txandaAldatu();

            if(this.erronda>=7 && this.konprobatu()){
                this.itxaron(1000);
                this.amoreEman();
            }
        }

        if("random".equals(this.jokoModua) && "fitxaGorria".equals(this.txanda)){
            this.fitxaZorizSartu();
        }
    }

    @FXML
    public void onClickSartu3(ActionEvent actionEvent) {
        this.erronda++;
        this.lblZutabeaBeteta.setVisible(false);
        int errenkada = this.fitxaSartu(2, this.txanda);
        Image irudia = this.irudiaEsleitu();

        if(errenkada ==10){
            //aukeratu duen zutabea beteta dago
            lblZutabeaBeteta.setVisible(true);
            this.erronda--;
        }else{
            if (errenkada == 0){
                iv1x3.setImage(irudia);
            }else if(errenkada==1){
                iv2x3.setImage(irudia);
            }else if(errenkada==2){
                iv3x3.setImage(irudia);
            }else if(errenkada==3){
                iv4x3.setImage(irudia);
            }else if(errenkada==4){
                iv5x3.setImage(irudia);
            }else {
                iv6x3.setImage(irudia);
            }
            this.txandaAldatu();
            if(this.erronda>=7 && this.konprobatu()){
                this.itxaron(1000);
                this.amoreEman();
            }
        }
        if("random".equals(this.jokoModua) && "fitxaGorria".equals(this.txanda)){
            this.fitxaZorizSartu();
        }

    }

    @FXML
    public void onClickSartu4(ActionEvent actionEvent) {
        this.erronda++;
        this.lblZutabeaBeteta.setVisible(false);
        int errenkada = this.fitxaSartu(3, this.txanda);
        Image irudia = this.irudiaEsleitu();
        if(errenkada==10){
            //aukeratu duen zutabea beteta dago
            lblZutabeaBeteta.setVisible(true);
            this.erronda--;
        }else{
            if (errenkada == 0){
                iv1x4.setImage(irudia);
            }else if(errenkada==1){
                iv2x4.setImage(irudia);
            }else if(errenkada==2){
                iv3x4.setImage(irudia);
            }else if(errenkada==3){
                iv4x4.setImage(irudia);
            }else if(errenkada==4){
                iv5x4.setImage(irudia);
            }else {
                iv6x4.setImage(irudia);
            }
            this.txandaAldatu();
            if(this.erronda>=7 && this.konprobatu()){
                this.itxaron(1000);
                this.amoreEman();
            }
        }
        if("random".equals(this.jokoModua) && "fitxaGorria".equals(this.txanda)){
            this.fitxaZorizSartu();
        }

    }

    @FXML
    public void onClickSartu5(ActionEvent actionEvent) {
        this.erronda++;
        this.lblZutabeaBeteta.setVisible(false);
        int errenkada = this.fitxaSartu(4, this.txanda);
        Image irudia = this.irudiaEsleitu();
        if(errenkada==10){
            //aukeratu duen zutabea beteta dago
            lblZutabeaBeteta.setVisible(true);
            this.erronda--;
        }else{
            if (errenkada == 0){
                iv1x5.setImage(irudia);
            }else if(errenkada==1){
                iv2x5.setImage(irudia);
            }else if(errenkada==2){
                iv3x5.setImage(irudia);
            }else if(errenkada==3){
                iv4x5.setImage(irudia);
            }else if(errenkada==4){
                iv5x5.setImage(irudia);
            }else {
                iv6x5.setImage(irudia);
            }
            this.txandaAldatu();
            if(this.erronda>=7 && this.konprobatu()){
                this.itxaron(1000);
                this.amoreEman();
            }
        }
        if("random".equals(this.jokoModua) && "fitxaGorria".equals(this.txanda)){
            this.fitxaZorizSartu();
        }

    }

    @FXML
    public void onClickSartu6(ActionEvent actionEvent) {
        this.erronda++;
        this.lblZutabeaBeteta.setVisible(false);
        int errenkada = this.fitxaSartu(5, this.txanda);
        Image irudia = this.irudiaEsleitu();
        if(errenkada==10){
            //aukeratu duen zutabea beteta dago
            lblZutabeaBeteta.setVisible(true);
            this.erronda--;
        }else{
            if (errenkada == 0){
                iv1x6.setImage(irudia);
            }else if(errenkada==1){
                iv2x6.setImage(irudia);
            }else if(errenkada==2){
                iv3x6.setImage(irudia);
            }else if(errenkada==3){
                iv4x6.setImage(irudia);
            }else if(errenkada==4){
                iv5x6.setImage(irudia);
            }else {
                iv6x6.setImage(irudia);
            }
            this.txandaAldatu();
            if(this.erronda>=7 && this.konprobatu()){
                this.itxaron(1000);
                this.amoreEman();
            }
        }
        if("random".equals(this.jokoModua) && "fitxaGorria".equals(this.txanda)){
            this.fitxaZorizSartu();
        }

    }

    @FXML
    public void onClickSartu7(ActionEvent actionEvent) {
        this.erronda++;
        this.lblZutabeaBeteta.setVisible(false);
        int errenkada = this.fitxaSartu(6, this.txanda);
        Image irudia = this.irudiaEsleitu();
        if(errenkada==10){
            //aukeratu duen zutabea beteta dago
            lblZutabeaBeteta.setVisible(true);
            this.erronda--;
        }else{
            if (errenkada == 0){
                iv1x7.setImage(irudia);
            }else if(errenkada==1){
                iv2x7.setImage(irudia);
            }else if(errenkada==2){
                iv3x7.setImage(irudia);
            }else if(errenkada==3){
                iv4x7.setImage(irudia);
            }else if(errenkada==4){
                iv5x7.setImage(irudia);
            }else {
                iv6x7.setImage(irudia);
            }
            this.txandaAldatu();
            if(this.erronda>=7 && this.konprobatu()){
                this.itxaron(1000);
                this.amoreEman();
            }
        }
        if("random".equals(this.jokoModua) && "fitxaGorria".equals(this.txanda)){
            this.fitxaZorizSartu();
        }

    }

    @FXML
    public void onClickSartu8(ActionEvent actionEvent) {
        this.erronda++;
        this.lblZutabeaBeteta.setVisible(false);
        int errenkada = this.fitxaSartu(7, this.txanda);
        Image irudia = this.irudiaEsleitu();
        if(errenkada==10){
            //aukeratu duen zutabea beteta dago
            lblZutabeaBeteta.setVisible(true);
            this.erronda--;
        }else{
            if (errenkada == 0){
                iv1x8.setImage(irudia);
            }else if(errenkada==1){
                iv2x8.setImage(irudia);
            }else if(errenkada==2){
                iv3x8.setImage(irudia);
            }else if(errenkada==3){
                iv4x8.setImage(irudia);
            }else if(errenkada==4){
                iv5x8.setImage(irudia);
            }else {
                iv6x8.setImage(irudia);
            }
            this.txandaAldatu();
            if(this.erronda>=7 && this.konprobatu()){
                this.itxaron(1000);
                this.amoreEman();
            }
        }
        if("random".equals(this.jokoModua) && "fitxaGorria".equals(this.txanda)){
            this.fitxaZorizSartu();
        }

    }

    @FXML
    public void onClickSartu9(ActionEvent actionEvent) {
        this.erronda++;
        this.lblZutabeaBeteta.setVisible(false);
        int errenkada = this.fitxaSartu(8, this.txanda);
        Image irudia = this.irudiaEsleitu();
        if(errenkada==10){
            //aukeratu duen zutabea beteta dago
            lblZutabeaBeteta.setVisible(true);
            this.erronda--;
        }else{
            if (errenkada == 0){
                iv1x9.setImage(irudia);
            }else if(errenkada==1){
                iv2x9.setImage(irudia);
            }else if(errenkada==2){
                iv3x9.setImage(irudia);
            }else if(errenkada==3){
                iv4x9.setImage(irudia);
            }else if(errenkada==4){
                iv5x9.setImage(irudia);
            }else {
                iv6x9.setImage(irudia);
            }
            this.txandaAldatu();

            if(this.erronda>=7 && this.konprobatu()){
                this.itxaron(1000);
                this.amoreEman();
            }
        }
        if("random".equals(this.jokoModua) && "fitxaGorria".equals(this.txanda)){
            this.fitxaZorizSartu();
        }

    }

    @FXML
    public void onClickAmoreEman(ActionEvent actionEvent) {
        this.amoreEman();
    }

    private void amoreEman(){
        this.fitxakKendu();
        Tableroa.getInstantzia().tableroaEzabatu();
        this.erronda=0;
        this.setJokoModua(" ");
        this.mainApp.aukerakErakutsi();
    }


    //beste metodoak

    public void setMainApp(Main main) { this.mainApp = main;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //defektuz hasieran
        lblTxanda.setText("Txanda: Fitxa Urdina");
        ivLogo.setImage(new Image("/argazkiak/logo.png"));
        this.fitxakKendu();
    }

    private int fitxaSartu(int pZutabea,String pTxanda){
        return Tableroa.getInstantzia().fitxaSartu(pZutabea, pTxanda);
    }

    private Image irudiaEsleitu(){
        if ("fitxaUrdina".equals(txanda)){ return new Image("/argazkiak/fitxaUrdina.png");}
        else{ return new Image("/argazkiak/fitxaGorria.png");}
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

    public boolean konprobatu(){
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
        //this.itxaron(1000);
        ActionEvent actionEvent = new ActionEvent();
        Random rd = new Random();
        int zutabea = rd.nextInt(9);
        if(zutabea==0){
            this.onClickSartu1(actionEvent);
        }
        if(zutabea==1){
            this.onClickSartu2(actionEvent);
        }
        else if(zutabea==2){
            this.onClickSartu3(actionEvent);
        }
        else if(zutabea==3){
            this.onClickSartu4(actionEvent);
        }
        else if(zutabea==4){
            this.onClickSartu5(actionEvent);
        }
        else if(zutabea==5){
            this.onClickSartu6(actionEvent);
        }
        else if(zutabea==6){
            this.onClickSartu7(actionEvent);
        }
        else if(zutabea==7){
            this.onClickSartu8(actionEvent);
        }
        else if(zutabea==8){
            this.onClickSartu9(actionEvent);
        }
    }

    private void fitxakKendu(){
        //fitxak hasieran hutsi
        iv1x1.setImage(new Image("/argazkiak/hutsik.png"));
        iv1x2.setImage(new Image("/argazkiak/hutsik.png"));
        iv1x3.setImage(new Image("/argazkiak/hutsik.png"));
        iv1x4.setImage(new Image("/argazkiak/hutsik.png"));
        iv1x5.setImage(new Image("/argazkiak/hutsik.png"));
        iv1x6.setImage(new Image("/argazkiak/hutsik.png"));
        iv1x7.setImage(new Image("/argazkiak/hutsik.png"));
        iv1x8.setImage(new Image("/argazkiak/hutsik.png"));
        iv1x9.setImage(new Image("/argazkiak/hutsik.png"));
        iv2x1.setImage(new Image("/argazkiak/hutsik.png"));
        iv2x2.setImage(new Image("/argazkiak/hutsik.png"));
        iv2x3.setImage(new Image("/argazkiak/hutsik.png"));
        iv2x4.setImage(new Image("/argazkiak/hutsik.png"));
        iv2x5.setImage(new Image("/argazkiak/hutsik.png"));
        iv2x6.setImage(new Image("/argazkiak/hutsik.png"));
        iv2x7.setImage(new Image("/argazkiak/hutsik.png"));
        iv2x8.setImage(new Image("/argazkiak/hutsik.png"));
        iv2x9.setImage(new Image("/argazkiak/hutsik.png"));
        iv3x1.setImage(new Image("/argazkiak/hutsik.png"));
        iv3x2.setImage(new Image("/argazkiak/hutsik.png"));
        iv3x3.setImage(new Image("/argazkiak/hutsik.png"));
        iv3x4.setImage(new Image("/argazkiak/hutsik.png"));
        iv3x5.setImage(new Image("/argazkiak/hutsik.png"));
        iv3x6.setImage(new Image("/argazkiak/hutsik.png"));
        iv3x7.setImage(new Image("/argazkiak/hutsik.png"));
        iv3x8.setImage(new Image("/argazkiak/hutsik.png"));
        iv3x9.setImage(new Image("/argazkiak/hutsik.png"));
        iv4x1.setImage(new Image("/argazkiak/hutsik.png"));
        iv4x2.setImage(new Image("/argazkiak/hutsik.png"));
        iv4x3.setImage(new Image("/argazkiak/hutsik.png"));
        iv4x4.setImage(new Image("/argazkiak/hutsik.png"));
        iv4x5.setImage(new Image("/argazkiak/hutsik.png"));
        iv4x6.setImage(new Image("/argazkiak/hutsik.png"));
        iv4x7.setImage(new Image("/argazkiak/hutsik.png"));
        iv4x8.setImage(new Image("/argazkiak/hutsik.png"));
        iv4x9.setImage(new Image("/argazkiak/hutsik.png"));
        iv5x1.setImage(new Image("/argazkiak/hutsik.png"));
        iv5x2.setImage(new Image("/argazkiak/hutsik.png"));
        iv5x3.setImage(new Image("/argazkiak/hutsik.png"));
        iv5x4.setImage(new Image("/argazkiak/hutsik.png"));
        iv5x5.setImage(new Image("/argazkiak/hutsik.png"));
        iv5x6.setImage(new Image("/argazkiak/hutsik.png"));
        iv5x7.setImage(new Image("/argazkiak/hutsik.png"));
        iv5x8.setImage(new Image("/argazkiak/hutsik.png"));
        iv5x9.setImage(new Image("/argazkiak/hutsik.png"));
        iv6x1.setImage(new Image("/argazkiak/hutsik.png"));
        iv6x2.setImage(new Image("/argazkiak/hutsik.png"));
        iv6x3.setImage(new Image("/argazkiak/hutsik.png"));
        iv6x4.setImage(new Image("/argazkiak/hutsik.png"));
        iv6x5.setImage(new Image("/argazkiak/hutsik.png"));
        iv6x6.setImage(new Image("/argazkiak/hutsik.png"));
        iv6x7.setImage(new Image("/argazkiak/hutsik.png"));
        iv6x8.setImage(new Image("/argazkiak/hutsik.png"));
        iv6x9.setImage(new Image("/argazkiak/hutsik.png"));
    }



}
