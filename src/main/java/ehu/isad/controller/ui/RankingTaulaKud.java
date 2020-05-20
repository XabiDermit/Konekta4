package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.RankingIADB;
import ehu.isad.controller.db.RankingTontoaDB;
import ehu.isad.model.Ranking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RankingTaulaKud implements Initializable {

    @FXML
    TableView tvTaula;
    @FXML
    TableColumn tcIzena;
    @FXML
    TableColumn tcDenbora;
    @FXML
    TextField tfIzena;
    @FXML
    Button btnDenboraGorde;
    @FXML
    Button btnABukatu;

    ObservableList<Ranking> ranking = FXCollections.observableArrayList();

    private String jokoModua;

    private Main mainApp;
    private long denbora;

    public void setMainApp(Main main) {
        mainApp = main;
    }

    public void onClickDenboraGorde(ActionEvent actionEvent) {
        this.denboraGorde();
    }

    public void onClickBukatu(ActionEvent actionEvent) {
        mainApp.aukerakErakutsi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}


    public void setRanking(){
        tcIzena.setCellValueFactory(new PropertyValueFactory<>("izena"));
        tcDenbora.setCellValueFactory(new PropertyValueFactory<>("denbora"));

        ranking.clear();

        if ("makinarenKontra".equals(jokoModua)){
            ArrayList<Ranking> rankings = RankingIADB.getInstantzia().getRanking();
            if (rankings.size()!=0){
                ranking.addAll(rankings);
                tvTaula.setItems(ranking);
            }
        }else{
            ArrayList<Ranking> rankings = RankingTontoaDB.getInstantzia().getRanking();
            if (rankings.size()!=0){
                ranking.addAll(rankings);
                tvTaula.setItems(ranking);
            }
        }

    }

    private void denboraGorde(){
        if (!tfIzena.getText().isEmpty()){
            if ("makinarenKontra".equals(jokoModua)){
                RankingIADB.getInstantzia().gordeDenbora(denbora, tfIzena.getText());

            }else{
                RankingTontoaDB.getInstantzia().gordeDenbora(denbora,tfIzena.getText());
            }
            setRanking();
            tfIzena.clear();
            tfIzena.setVisible(false);
            btnDenboraGorde.setVisible(false);
        }else{
            tfIzena.setText("Izena sartu!");
        }


    }

    public void guztiaPrestatu(String pJokoModua, long pDenbora){
        this.jokoModua=pJokoModua;
        this.denbora = pDenbora;
        btnDenboraGorde.setVisible(true);
        tfIzena.setVisible(true);
    }
}
