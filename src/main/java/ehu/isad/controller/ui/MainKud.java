package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.DBKudeatzaile;
import ehu.isad.controller.db.MainDBKUd;
import ehu.isad.controller.db.TxanponaDBKud;
import ehu.isad.model.Txanpona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.util.*;

public class MainKud implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private Main mainApp;

    @FXML
    private Button btnSartu;
    @FXML
    private Button btnGorde;
    @FXML
    private ComboBox cb;
    @FXML
    private TableView<Txanpona> taula;
    @FXML
    private TableColumn<Txanpona, Integer> id;
    @FXML
    private TableColumn<Txanpona, String> txanpon;
    @FXML
    private TableColumn<Txanpona, java.sql.Date> noiz;
    @FXML
    private TableColumn<Txanpona,Double> zenbat;
    @FXML
    private TableColumn<Txanpona,Float> bolumena;
    @FXML
    private TableColumn<Txanpona, ImageView> portaera;

    private ObservableList<Txanpona> txanponDatuak = FXCollections.observableArrayList();

    public void setMainApp(Main main) {mainApp = main; }

    @FXML
    public void onClickSartu(ActionEvent actionEvent) throws IOException {
        String aukeratutakoa = (String) cb.getValue();
        String txanponURL = null;
        if (aukeratutakoa.equals("Ethereum")){
            txanponURL = "ETH";
        }else if(aukeratutakoa.equals("Bitcoin")){
            txanponURL = "BTC";
        }else{
            txanponURL = "LTC";
        }
        Double[] datuak = readFromURL(txanponURL);


        //portaera aztertzeko:

        ImageView portaera =null;
        ObservableList<Txanpona> txanponak = taula.getItems();
        Double zenbat = datuak[0];
        int luzera = txanponak.size();
        for(int i=0; i< luzera;i++){
            Txanpona tx =txanponak.get(luzera-(i+1));
            Double unekoZenbat = tx.getBalioa();
            String unekoMota = tx.getMota();
            if (txanponURL.equals(unekoMota)){

                if(zenbat == 0.0 || zenbat.equals(unekoZenbat)){ portaera = new ImageView("argazkiak/equal.png");}
                else if (zenbat > unekoZenbat){ portaera = new ImageView("argazkiak/up.png");}
                else{ portaera= new ImageView("argazkiak/down.png");}
                break;

            }
        }
        //portaera aztertuta

        java.sql.Date data = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Txanpona tx = new Txanpona(new Random().nextInt(100),txanponURL,data,zenbat,datuak[1],portaera);
        taula.getItems().add(tx);


    }

    @FXML
    public void onClickGorde(ActionEvent actionEvent) {
        MainDBKUd.getInstantzia().guztiaEzabatu();
        MainDBKUd.getInstantzia().datuakDBgorde(taula.getItems());
    }


    public void taulaBete(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        txanpon.setCellValueFactory(new PropertyValueFactory<>("mota"));
        noiz.setCellValueFactory( new PropertyValueFactory<>("data"));
        zenbat.setCellValueFactory( new PropertyValueFactory<>("balioa"));
        bolumena.setCellValueFactory( new PropertyValueFactory<>("bolumena"));
        portaera.setCellValueFactory(new PropertyValueFactory<>("portaera"));

        txanponDatuak.clear();
        txanponDatuak.addAll(TxanponaDBKud.getInstantzia().getBalioak());
       // taula.getColumns().clear();
        taula.setItems(txanponDatuak);


    }

    public void comboBoxBete(){
        ObservableList<String> txanponIzenak = FXCollections.observableArrayList();
        txanponIzenak.addAll(("Ethereum"),("Bitcoin"), ("Litecoin"));
        cb.setItems(txanponIzenak);
        cb.getSelectionModel().selectFirst();
    }

    private Double[] readFromURL (String txanpona) throws IOException{

        URL coinmarket = new URL("https://api.gdax.com/products/"+txanpona+"-eur/ticker");
        URLConnection yc = coinmarket.openConnection();

        Double[] lista = new Double[2];

        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

        String inputLine;

        inputLine = in.readLine();
        String[] zatiak = inputLine.split(",");         //lerroak banatu
        String[] lag = zatiak[1].split(":");            //lerro bakoitzaren izena eta balioa banatu
        Double zenbat = Double.parseDouble(lag[1].substring(1,lag[1].length()-1));     //balioa String-etik Float-era pasatu
        lista[0]=zenbat;

        String[] lag2 = zatiak[6].split(":");            //lerro bakoitzaren izena eta balioa banatu
        Double bolumena = Double.parseDouble(lag2[1].substring(1,lag[1].length()-1));     //balioa String-etik Float-era pasatu
        lista[1]= bolumena;

        in.close();

        return lista;
    }
}
