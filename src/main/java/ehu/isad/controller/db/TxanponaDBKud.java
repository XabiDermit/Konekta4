package ehu.isad.controller.db;

import ehu.isad.model.Txanpona;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TxanponaDBKud {

    //singleton patroia

    private static TxanponaDBKud instantzia = new TxanponaDBKud();
    private TxanponaDBKud(){}
    public static TxanponaDBKud getInstantzia(){ return instantzia;}

    public ArrayList<Txanpona> getBalioak(){
        ArrayList<Txanpona> balioak = new ArrayList<>();
        //declare select statement
        String statement = "SELECT * FROM txanponak;";
        try {
            ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(statement);

            Double azkenZenbatETH=0.0;
            Double azkenZenbatBTC=0.0;
            Double azkenZenbatLHC=0.0;

            while (rs.next()) {
                int id = rs.getInt("id");
                Date data = rs.getDate("data");
                Double zenbat = rs.getDouble("balioa");
                String mota =  rs.getString("mota");
                Double bolumena = rs.getDouble("bolumena");
                //portaera aztertzeko

                ImageView portaera;
                if ("ETH".equals(mota)){
                    if(azkenZenbatETH == 0.0 || zenbat == azkenZenbatETH){ portaera = new ImageView("argazkiak/equal.png");}
                    else if (zenbat > azkenZenbatETH){ portaera = new ImageView("argazkiak/up.png");}
                    else{ portaera= new ImageView("argazkiak/down.png");}
                    azkenZenbatETH=zenbat;}
                else if ("BTC".equals(mota)){
                    if(azkenZenbatBTC == 0.0 || zenbat == azkenZenbatBTC){ portaera = new ImageView("argazkiak/equal.png");}
                    else if (zenbat > azkenZenbatBTC){ portaera = new ImageView("argazkiak/up.png");}
                    else{ portaera= new ImageView("argazkiak/down.png");}
                    azkenZenbatBTC=zenbat;}
                else{
                    if(azkenZenbatLHC == 0.0 || zenbat == azkenZenbatLHC){ portaera = new ImageView("argazkiak/equal.png");}
                    else if (zenbat > azkenZenbatLHC){ portaera = new ImageView("argazkiak/up.png");}
                    else{ portaera= new ImageView("argazkiak/down.png");}
                    azkenZenbatLHC = zenbat;}

                Txanpona tx = new Txanpona(id,mota,data,zenbat,bolumena,portaera);
                balioak.add(tx);

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return balioak;
    }
}
