package ehu.isad.model;

import javafx.fxml.FXML;

public class Fitxa {

    @FXML
    private Boolean hutsik = true;

    private String fitxaMota= "esleituGabe";

    private int[] kokapena;

    public Fitxa() {
        kokapena = new int[2];
    }

    public boolean hutsikDago(){
        return hutsik;
    }

    public void setHutsik(boolean pBeteta){
        hutsik=pBeteta;
    }

    public void setFitxaMota(String fitxaMota) {
        this.fitxaMota = fitxaMota;
    }

    public void setKokapena(int x, int y){
        kokapena[0]=x;
        kokapena[1]=y;
    }

    public String getFitxaMota(){return fitxaMota;}

    public int[] getKokapena(){
        return kokapena;
    }
}
