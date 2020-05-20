package ehu.isad.controller.db;

import ehu.isad.model.Ranking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RankingIADB {

    private static RankingIADB instantzia = new RankingIADB();
    private RankingIADB(){}
    public static RankingIADB getInstantzia(){return instantzia;}

    public ArrayList<Ranking> getRanking(){
        String statement = "select * from rankingIA;";
        ArrayList<Ranking> emaitza = new ArrayList<Ranking>();
        try {
            ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(statement);
            while(rs.next()){
                String hunekoIzena = rs.getString("izena");
                int hunekoDenbora = rs.getInt("denbora");
                Ranking ranking = new Ranking(hunekoIzena,hunekoDenbora);
                emaitza.add(ranking);
            }
        }catch (SQLException e){
            System.out.println("SQL error");
        }
        return emaitza;
    }

    public void gordeDenbora(long pDenbora, String pIzena) {
        String statement = "insert into rankingIA values ('" +pIzena + "',"+pDenbora + ");";
        DBKudeatzaile.getInstantzia().execSQL(statement);
    }
}
