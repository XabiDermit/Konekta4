package ehu.isad.controller.db;

import ehu.isad.Main;
import ehu.isad.model.Txanpona;
import javafx.collections.ObservableList;

public class MainDBKUd {

    //singleton patroia

    private static MainDBKUd instantzia = new MainDBKUd();
    public static MainDBKUd getInstantzia(){return instantzia;}

    private MainDBKUd(){}

    public void guztiaEzabatu(){
        //Declare SELECT statement
        String statement = "DELETE FROM txanponak;";
        DBKudeatzaile.getInstantzia().execSQL(statement);
    }

    public void datuakDBgorde(ObservableList<Txanpona> lista){
        for (int i=0; lista.size()> i; i++){
            Txanpona unekoTx = lista.get(i);
            //Declare INSERT statement
            String unekoStatement = "INSERT INTO txanponak VALUES ("+ unekoTx.getId()+",'" + unekoTx.getData() + "','" +unekoTx.getBalioa()+"','"+ unekoTx.getMota()+"','" + unekoTx.getBolumena()+ "');";
            DBKudeatzaile.getInstantzia().execSQL(unekoStatement);
        }
    }
}
