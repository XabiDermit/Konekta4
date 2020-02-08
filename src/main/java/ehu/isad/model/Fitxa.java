package ehu.isad.model;

import javafx.fxml.FXML;

public class Fitxa {

    @FXML
    private Boolean hutsik = true;

    private String fitxaMota= "esleituGabe";

    public Fitxa() {
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

    public String getFitxaMota(){return fitxaMota;}
}
