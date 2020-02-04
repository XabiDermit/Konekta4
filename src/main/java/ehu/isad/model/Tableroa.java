package ehu.isad.model;

public class Tableroa {

    //singleton patroia
    public static Tableroa instantzia= new Tableroa();
    public static Tableroa getInstantzia(){return instantzia;}

    private Tableroa(){
        for(int i=0;i<9;i++){
            for (int j=0;j<6;j++){
                tableroa[j][i]= new Fitxa();
            }
        }
    }

    private Fitxa[][] tableroa = new Fitxa[6][9];

    public int fitxaSartu(int pZutabea,String pTxanda){
        for (int i=0;i<6;i++){
            if(tableroa[5-i][pZutabea].hutsikDago()){
                tableroa[5-i][pZutabea].setFitxaMota(pTxanda);
                tableroa[5-i][pZutabea].beteDa();
                return 5-i;
            }
        }
        return 10;
    }
}
