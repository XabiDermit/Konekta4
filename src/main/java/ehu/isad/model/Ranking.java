package ehu.isad.model;

public class Ranking {

    private String izena;
    private int denbora;

    public Ranking(String pIzena, int pDenbora){
        izena = pIzena;
        denbora = pDenbora;
    }

    public String getIzena() {
        return izena;
    }

    public int getDenbora() {
        return denbora;
    }
}
