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
            boolean hutsikDago = tableroa[5-i][pZutabea].hutsikDago();
            if(hutsikDago){
                tableroa[5-i][pZutabea].setFitxaMota(pTxanda);
                tableroa[5-i][pZutabea].setHutsik(false);
                return 5-i;
            }
        }
        return 10;
    }

    public boolean konprobatu() {                         //konprobatu modu batean eta irabazlea badago ez dira besteak konprobatzen
        if (this.konprobatuHorizontalean()){return true;}
        else if (this.konprobatuBertikalean()) { return true;}
        else if (this.konprobatuDiagonaleanEzkerretikEskumara()) {return true;}
        else if (this.konprobatuDiagonaleanEskumatikEzkerrera()) {return true;}
        else{ return false;}
    }
    private boolean konprobatuHorizontalean(){
        boolean irabazi = false;
        for (int j = 0; j<6;j++){
            int zenbatOndoJarraian =0;
            for (int i= 0;i<8;i++) {
                //errenkada osoa errekorritu
                String unekoFitxaMota = tableroa[5-j][i].getFitxaMota();
                String hurrengoFixtaMota = tableroa[5-j][i+1].getFitxaMota();
                if (unekoFitxaMota.equals(hurrengoFixtaMota)&& !"esleituGabe".equals(hurrengoFixtaMota) ) {
                    zenbatOndoJarraian++;
                    if (zenbatOndoJarraian == 3) {  //konekta 4 da, baina bikoteka konparatzen direnez fitxa, hiru bikote ondo baude, 4 fitxa jarraian daudela esan nahi du
                        irabazi= true;
                        break;
                    }
                }
                else {
                    zenbatOndoJarraian = 0;
                }
            }
        }
        return irabazi;
    }

    private boolean konprobatuBertikalean(){
        boolean irabazi = false;
        for (int j = 0; j<9;j++){
            int zenbatOndoJarraian =0;
            for (int i= 0;i<5;i++) {
                //errenkada osoa errekorritu
                String unekoFitxaMota = tableroa[5-i][j].getFitxaMota();
                String hurrengoFitxaMota = tableroa[4-i][j].getFitxaMota();
                if (unekoFitxaMota.equals(hurrengoFitxaMota) && !"esleituGabe".equals(hurrengoFitxaMota)) {
                    zenbatOndoJarraian++;
                    if (zenbatOndoJarraian == 3) {  //konekta 4 da, baina bikoteka konparatzen direnez fitxa, hiru bikote ondo baude, 4 fitxa jarraian daudela esan nahi du
                        irabazi= true;
                        break;
                    }
                }
                else {
                    zenbatOndoJarraian = 0;
                }

            }


        }
        return irabazi;
    }

    private boolean konprobatuDiagonaleanEzkerretikEskumara(){      //behetik gora /
        return false;
    }

    private boolean konprobatuDiagonaleanEskumatikEzkerrera(){      //behetik gora \
        return false;
    }


    public void tableroaEzabatu(){
        for(int i=0;i<9;i++){
            for (int j=0;j<6;j++){
                tableroa[j][i].setHutsik(true);
                tableroa[j][i].setFitxaMota("esleituGabe");
            }
        }
    }
}
