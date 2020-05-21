package ehu.isad.model;

public class Tableroa {

    //singleton patroia
    public static Tableroa instantzia= new Tableroa();
    public static Tableroa getInstantzia(){return instantzia;}
    private Fitxa[] fitxaIrabazleak = new Fitxa[4];

    private Tableroa(){
        for(int i=0;i<9;i++){
            for (int j=0;j<6;j++){
                Fitxa fitxa = new Fitxa();
                fitxa.setKokapena(i,j);
                tableroa[j][i]= fitxa;
            }
        }
        for (int i =0; i<4;i++){
            fitxaIrabazleak[i] = new Fitxa();
        }
    }

    private Fitxa[][] tableroa = new Fitxa[6][9];
    private int sakoneraMax = 8;
    private int hurrengoMugimenduaNon=-1;

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

    public void fitxaAtera(int pZutabea){
        for (int i=0;i<6;i++){
            boolean hutsikDago = tableroa[i][pZutabea].hutsikDago();
            if(!hutsikDago){
                tableroa[i][pZutabea].setFitxaMota("esleituGabe");
                tableroa[i][pZutabea].setHutsik(true);
                break;
            }
        }
    }

    public int konprobatu() {                         //konprobatu modu batean eta irabazlea badago ez dira besteak konprobatzen
        int fitxaUrdinPunt = 0;
        int fitxaGorriPunt = 0;
        String[] fitxaIrabazleKokapena;
        for(int i=5;i>=0;--i){
            for(int j=0;j<=8;++j){
                if(tableroa[i][j].getFitxaMota().equals("esleituGabe")) continue;                  //si esa casilla esta vacia no comprabar desde ahi

                if(j<=5){               //5 [0..8] es la ultima casilla de la que se puede empezar a contar hasta 4
                    for(int k=0;k<4;++k){
                        if(tableroa[i][j+k].getFitxaMota().equals("fitxaGorria")){
                            fitxaGorriPunt++;
                            fitxaIrabazleak[k].setKokapena(j+k,i);
                        }
                        else if(tableroa[i][j+k].getFitxaMota().equals("fitxaUrdina")) {
                            fitxaUrdinPunt++;
                            fitxaIrabazleak[k].setKokapena(j+k,i);
                        }
                        else break;
                    }
                    if(fitxaGorriPunt==4)return 1; else if (fitxaUrdinPunt==4)return 2;
                    fitxaGorriPunt = 0; fitxaUrdinPunt = 0;
                }

                if(i>=3){               //3 [0..5] es la ultima casilla de la que se puede empezar a contar hasta 4
                    for(int k=0;k<4;++k){
                        if(tableroa[i-k][j].getFitxaMota().equals("fitxaGorria")){
                            fitxaGorriPunt++;
                            fitxaIrabazleak[k].setKokapena(j,i-k);
                        }
                        else if(tableroa[i-k][j].getFitxaMota().equals("fitxaUrdina")) {
                            fitxaUrdinPunt++;
                            fitxaIrabazleak[k].setKokapena(j,i-k);
                        }
                        else break;
                    }
                    if(fitxaGorriPunt==4)return 1; else if (fitxaUrdinPunt==4)return 2;
                    fitxaGorriPunt = 0; fitxaUrdinPunt = 0;
                }


                if(j<=5 && i>= 3){
                    for(int k=0;k<4;++k){
                        if(tableroa[i-k][j+k].getFitxaMota().equals("fitxaGorria")){
                            fitxaGorriPunt++;
                            fitxaIrabazleak[k].setKokapena(j+k,i-k);
                        }
                        else if(tableroa[i-k][j+k].getFitxaMota().equals("fitxaUrdina")){
                            fitxaUrdinPunt++;
                            fitxaIrabazleak[k].setKokapena(j+k,i-k);
                        }
                        else break;
                    }
                    if(fitxaGorriPunt==4)return 1; else if (fitxaUrdinPunt==4)return 2;
                    fitxaGorriPunt = 0; fitxaUrdinPunt = 0;
                }

                if(j>=3 && i>=3){
                    for(int k=0;k<4;++k){
                        if(tableroa[i-k][j-k].getFitxaMota().equals("fitxaGorria")){
                            fitxaGorriPunt++;
                            fitxaIrabazleak[k].setKokapena(j-k,i-k);
                        }
                        else if(tableroa[i-k][j-k].getFitxaMota().equals("fitxaUrdina")){
                            fitxaUrdinPunt++;
                            fitxaIrabazleak[k].setKokapena(j-k,i-k);
                        }
                        else break;
                    }
                    if(fitxaGorriPunt==4)return 1; else if (fitxaUrdinPunt==4)return 2;
                    fitxaGorriPunt = 0; fitxaUrdinPunt = 0;
                }
            }
        }

        for(int j=0;j<8;++j){

            if(tableroa[0][j].getFitxaMota().equals("esleituGabe"))return -1;
        }

        return 0;
    }



    //AI metodoak

    public int puntuazioaKalkulatu(int aiPuntuazioa, int mugimenduGehiago){
        int mugitzekoPuntuazioa = 4 - mugimenduGehiago;
        if(aiPuntuazioa==0)return 0;
        else if(aiPuntuazioa==1)return 1*mugitzekoPuntuazioa;
        else if(aiPuntuazioa==2)return 10*mugitzekoPuntuazioa;
        else if(aiPuntuazioa==3)return 100*mugitzekoPuntuazioa;
        else return 1000;
    }

    public int tableroaEbaluatu(){

        int aiPuntuazioa=1;
        int puntuazioa=0;
        int zuriuneak = 0;
        int k=0;
        int mugimenduGehiago=0;
        for(int i=5;i>=0;--i){      //recorre el tablero
            for(int j=0;j<9;++j){

                if(tableroa[i][j].getFitxaMota().equals("esleituGabe") || tableroa[i][j].getFitxaMota().equals("fitxaUrdina")) continue;  //si la casilla esta vacia o es de HUMANO --> seguimos

                if(j<=5){           //a partir de x=5 [0..8] ya no puede haber 4 seguidas
                    for(k=1;k<4;++k){       //k=1 al principio porque ya sabemos que k=0 es la ficha que queremos (ia)
                        //sumando 'k' a el parametro j (eje x) mira a ver si hay 4 seguidas
                        if(tableroa[i][j+k].getFitxaMota().equals("fitxaGorria"))aiPuntuazioa++;    //si =1 --> aiScore +1
                        else if(tableroa[i][j+k].getFitxaMota().equals("fitxaUrdina")){aiPuntuazioa=0;zuriuneak = 0;break;}    //si =2 -->aiScore= 0 y terminas
                        else zuriuneak++;  //otra --> casilla en blanco, blanks++
                    }

                    mugimenduGehiago = 0;
                    if(zuriuneak>0) {      //si hay casillas en blanco
                        for (int c = 1; c < 4; ++c) {
                            int column = j + c;
                            for (int m = i; m <= 5; m++) {
                                if (tableroa[m][column].getFitxaMota().equals("esleituGabe")) {
                                    mugimenduGehiago++;
                                }
                                else break;
                            }
                        }
                    }
                    if(mugimenduGehiago!=0) puntuazioa += puntuazioaKalkulatu(aiPuntuazioa, mugimenduGehiago);
                    aiPuntuazioa=1;
                    zuriuneak = 0;
                }

                if(i>=3){           //a partir de i=3[0..5] ya no puede haber 4 seguidas
                    for(k=1;k<4;++k){
                        if(tableroa[i-k][j].getFitxaMota().equals("fitxaGorria"))aiPuntuazioa++;
                        else if(tableroa[i-k][j].getFitxaMota().equals("fitxaUrdina")){aiPuntuazioa=0;break;}
                    }
                    mugimenduGehiago = 0;

                    if(aiPuntuazioa>0){
                        int column = j;
                        for(int m=i-k+1; m<=i-1;m++){
                            if(tableroa[m][column].getFitxaMota().equals("esleituGabe"))mugimenduGehiago++;
                            else break;
                        }
                    }
                    if(mugimenduGehiago!=0) puntuazioa += puntuazioaKalkulatu(aiPuntuazioa, mugimenduGehiago);
                    aiPuntuazioa=1;
                    zuriuneak = 0;
                }

                if(j>=5){
                    for(k=1;k<4;++k){
                        if(tableroa[i][j-k].getFitxaMota().equals("fitxaGorria"))aiPuntuazioa++;
                        else if(tableroa[i][j-k].getFitxaMota().equals("fitxaUrdina")){aiPuntuazioa=0; zuriuneak=0;break;}
                        else zuriuneak++;
                    }
                    mugimenduGehiago=0;
                    if(zuriuneak>0)
                        for(int c=1;c<4;++c){
                            int column = j- c;
                            for(int m=i; m<= 5;m++){
                                if(tableroa[m][column].getFitxaMota().equals("esleituGabe"))mugimenduGehiago++;
                                else break;
                            }
                        }

                    if(mugimenduGehiago!=0) puntuazioa += puntuazioaKalkulatu(aiPuntuazioa, mugimenduGehiago);
                    aiPuntuazioa=1;
                    zuriuneak = 0;
                }

                if(j<=5 && i>=3){
                    for(k=1;k<4;++k){
                        if(tableroa[i-k][j+k].getFitxaMota().equals("fitxaGorria"))aiPuntuazioa++;
                        else if(tableroa[i-k][j+k].getFitxaMota().equals("fitxaUrdina")){aiPuntuazioa=0;zuriuneak=0;break;}
                        else zuriuneak++;
                    }
                    mugimenduGehiago=0;
                    if(zuriuneak>0){
                        for(int c=1;c<4;++c){
                            int column = j+c, row = i-c;
                            for(int m=row;m<=5;++m){
                                if(tableroa[m][column].getFitxaMota().equals("esleituGabe"))mugimenduGehiago++;
                                else if(tableroa[m][column].getFitxaMota().equals("fitxaGorria"));
                                else break;
                            }
                        }
                        if(mugimenduGehiago!=0) puntuazioa += puntuazioaKalkulatu(aiPuntuazioa, mugimenduGehiago);
                        aiPuntuazioa=1;
                        zuriuneak = 0;
                    }
                }

                if(i>=5 && j>=3){
                    for(k=1;k<4;++k){
                        if(tableroa[i-k][j-k].getFitxaMota().equals("fitxaGorria"))aiPuntuazioa++;
                        else if(tableroa[i-k][j-k].getFitxaMota().equals("fitxaUrdina")){aiPuntuazioa=0;zuriuneak=0;break;}
                        else zuriuneak++;
                    }
                    mugimenduGehiago=0;
                    if(zuriuneak>0){
                        for(int c=1;c<4;++c){
                            int column = j-c, row = i-c;
                            for(int m=row;m<=5;++m){
                                if(tableroa[m][column].getFitxaMota().equals("esleituGabe"))mugimenduGehiago++;
                                else if(tableroa[m][column].getFitxaMota().equals("fitxaGorria"));
                                else break;
                            }
                        }
                        if(mugimenduGehiago!=0) puntuazioa += puntuazioaKalkulatu(aiPuntuazioa, mugimenduGehiago);
                        aiPuntuazioa=1;
                        zuriuneak = 0;
                    }
                }
            }
        }
        return puntuazioa;
    }

    //algoritmo minimax con alpha-beta pruning --> para decidir que camino coger
    public int minimax(int sakonera, String txanda, int alpha, int beta){


        if(beta<=alpha){if(txanda.equals("fitxaGorria")) return Integer.MAX_VALUE; else return Integer.MIN_VALUE; }
        /*
        alpha-beta pruning
        alpha >= beta --> pruning (ignorar el resto de casos por debajo de ese nodo para ahorrar gasto computacional)
            si hay pruning y el turno es 1 (AI) se devuelve el MAX_VALUE y gana IA, si no se devuelve MIN_VALUE y gana HUMANO
         */

        int partidaEmaitza = konprobatu();
        /*
        si gana la IA :1
        si gana HUMANO:2
        si hay empate :0
        si no ha terminado: -1
         */

        if(partidaEmaitza==1)return Integer.MAX_VALUE/2;
        else if(partidaEmaitza==2)return Integer.MIN_VALUE/2;
        else if(partidaEmaitza==0)return 0;

        if(sakonera==sakoneraMax)return tableroaEbaluatu();
        //depth es un atributo de la clase y es la maxima profundidad a la que se compprueba el arbol

        int puntuazioMax=Integer.MIN_VALUE;         //la puntuacion que se quiere maximizar empieza con el valor mas bajo posible y va subiendo
        int puntuazioMin = Integer.MAX_VALUE;       //la puntuacion que se quiere minimizar empieza con el valor mas alto posible y va bajando

        for(int j=0;j<9;++j){           //recorre todas la columnas

            int hunekoPuntuazioa = 0;

            if(!lekuaDagoZutabean(j)) continue;

            if(txanda.equals("fitxaGorria")){            //turno de la IA
                fitxaSartu(j,"fitxaGorria");      //mete una ficha en la columna j y vuelve a llamar a minimax
                hunekoPuntuazioa = minimax(sakonera+1, "fitxaUrdina", alpha, beta);

                if(sakonera==0){
                    System.out.println("Score for location "+j+" = "+hunekoPuntuazioa);
                    if(hunekoPuntuazioa > puntuazioMax)hurrengoMugimenduaNon = j;
                    if(hunekoPuntuazioa == Integer.MAX_VALUE/2){fitxaAtera(j);break;} //ha ganado HUMANO (creo)
                }

                puntuazioMax = Math.max(hunekoPuntuazioa, puntuazioMax);

                alpha = Math.max(hunekoPuntuazioa, alpha);
            }
            else if(txanda.equals("fitxaUrdina")){       //turdo del HUMANO
                fitxaSartu(j,"fitxaUrdina");
                hunekoPuntuazioa = minimax(sakonera+1, "fitxaGorria", alpha, beta);
                puntuazioMin = Math.min(hunekoPuntuazioa, puntuazioMin);

                beta = Math.min(hunekoPuntuazioa, beta);
            }
            fitxaAtera(j);
            //como hemos metido fichas para calcular, ahora las quitamos

            if(hunekoPuntuazioa == Integer.MAX_VALUE || hunekoPuntuazioa == Integer.MIN_VALUE) break;
        }
        return txanda.equals("fitxaGorria")?puntuazioMax:puntuazioMin;
    }

    private boolean lekuaDagoZutabean(int j) {
        return tableroa[0][j].getFitxaMota().equals("esleituGabe");
    }

    public int lortuAImugimendua(){
        hurrengoMugimenduaNon = -1;
        minimax(0, "fitxaGorria", Integer.MIN_VALUE, Integer.MAX_VALUE);
        return hurrengoMugimenduaNon;
    }

    public void tableroaEzabatu(){
        for(int i=0;i<9;i++){
            for (int j=0;j<6;j++){
                tableroa[j][i].setHutsik(true);
                tableroa[j][i].setFitxaMota("esleituGabe");
            }
        }
    }

    public Fitxa[] getFitxaIrabazleakKokapena(){
        return fitxaIrabazleak;
    }
}
