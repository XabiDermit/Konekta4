package ehu.isad.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Date;
import java.util.ArrayList;

public class Txanpona {

    private int id;
    private String  mota;
    private java.sql.Date data;
    private Double balioa;
    private Double bolumena;
    private ImageView portaera;

    public Txanpona(int pId, String pMota, java.sql.Date pData, Double pBalioa, Double pBolumena, ImageView pPortaera) {
        this.id = pId;
        this.mota = pMota;
        this.data = pData;
        this.balioa = pBalioa;
        this.bolumena = pBolumena;
        this.portaera = pPortaera;
    }

    public int getId(){
        return id;
    }

    public String getMota() {
        return mota;
    }

    public Date getData() {
        return data;
    }

    public Double getBalioa() {
        return balioa;
    }

    public Double getBolumena() {
        return bolumena;
    }

    public ImageView getPortaera(){return portaera;}

    public Image aurrekoBalioarekinKonparatu(Txanpona tx){
        Double zenbat = tx.getBalioa();
        if ( zenbat > this.balioa){ return new Image("argazkiak/up.png");}
        else if ((zenbat < this.balioa)){return new Image(("argazkiak/down.png"));}
        else return new Image("argazkiak/equal.png");
    }
}
