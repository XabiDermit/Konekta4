package ehu.isad.model;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fitxa {

    @FXML
    private Boolean hutsik = true;

    private String fitxaMota;

    public Fitxa() {
    }

    public boolean hutsikDago(){
        return hutsik;
    }

    public void beteDa(){
        hutsik=false;
    }

    public void setFitxaMota(String fitxaMota) {
        this.fitxaMota = fitxaMota;
    }
}
