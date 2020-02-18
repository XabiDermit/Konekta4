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
        for (int j = 0; j<6;j++){
            int zenbatOndoJarraian =0;
            for (int i= 0;i<8;i++) {
                //errenkada osoa errekorritu
                String unekoFitxaMota = tableroa[5-j][i].getFitxaMota();
                String hurrengoFixtaMota = tableroa[5-j][i+1].getFitxaMota();
                if (unekoFitxaMota.equals(hurrengoFixtaMota)&& !"esleituGabe".equals(hurrengoFixtaMota) ) {
                    zenbatOndoJarraian++;
                    if (zenbatOndoJarraian == 3) {  //konekta 4 da, baina bikoteka konparatzen direnez fitxa, hiru bikote ondo baude, 4 fitxa jarraian daudela esan nahi du
                        return true;
                    }
                }
                else {
                    zenbatOndoJarraian = 0;
                }
            }
        }
        return false;
    }

    private boolean konprobatuBertikalean(){
        for (int j = 0; j<9;j++){
            int zenbatOndoJarraian =0;
            for (int i= 0;i<5;i++) {
                //errenkada osoa errekorritu
                String unekoFitxaMota = tableroa[5-i][j].getFitxaMota();
                String hurrengoFitxaMota = tableroa[4-i][j].getFitxaMota();
                if (unekoFitxaMota.equals(hurrengoFitxaMota) && !"esleituGabe".equals(hurrengoFitxaMota)) {
                    zenbatOndoJarraian++;
                    if (zenbatOndoJarraian == 3) {  //konekta 4 da, baina bikoteka konparatzen direnez fitxa, hiru bikote ondo baude, 4 fitxa jarraian daudela esan nahi du
                        return true;
                    }
                }
                else {
                    zenbatOndoJarraian = 0;
                }

            }

        }
        return false;
    }

    private boolean konprobatuDiagonaleanEzkerretikEskumara(){      //behetik gora /

        /*
        Horizontalean eta bertikalean konprobatzen dugunean, konprobatzen ditugun errenkada/zutabe guztiak luzeera berdina izango dute,
        eta horregaitik 'for' bat erabiltzen dugunean ez ditugu arazoak izango.
        Diagonalean konprobatzen dugunean, diagonal desberdinak izango ditugu eta luzeera desberdinak izango dituzte:
                -4 luzeerako diagonalak: 2
                -5 luzeerako diagonalak: 2
                -6 luzeerako diagonalak: 4
                (1, 2 eta 3 luzeerako diagonalean ez dira konprobatzen)
        */

        int zenbatOndoJarraian = 0;

        //4 luzeerako 1.kasua

        for (int i = 0; i<3; i++){
            String unekoFitxaMota = tableroa[3-i][i].getFitxaMota();
            String hurrengoFitxaMota = tableroa[2-i][i+1].getFitxaMota();
            if(unekoFitxaMota.equals(hurrengoFitxaMota) && !"esleituGabe".equals(hurrengoFitxaMota)){
                zenbatOndoJarraian++;
                if (zenbatOndoJarraian==3){
                    return true;
                }
            }else {
                zenbatOndoJarraian = 0;
            }
        }

        zenbatOndoJarraian = 0;     //no estoy seguro, solo por si acaso

        //4 luzeerako 2.kasua

        for (int i = 5; i<8;i++){
            String unekoFitxaMota = tableroa[10-i][i].getFitxaMota();
            String hurrengoFitxaMota  = tableroa[9-i][i+1].getFitxaMota();
            if(unekoFitxaMota.equals(hurrengoFitxaMota)&& !"esleituGabe".equals(hurrengoFitxaMota)){
                zenbatOndoJarraian++;
                if(zenbatOndoJarraian==3){
                    return true;
                }
            }else{
                zenbatOndoJarraian=0;
            }
        }

        zenbatOndoJarraian=0;       //no estoy seguro, solo por si acaso

        //5 luzeerako 1. kasua

        for (int i = 0;i<4;i++){
            String unekoFitxaMota = tableroa[4-i][i].getFitxaMota();
            String hurrengoFitxaMota = tableroa[3-i][i+1].getFitxaMota();
            if(unekoFitxaMota.equals(hurrengoFitxaMota)&& !"esleituGabe".equals(hurrengoFitxaMota)){
                zenbatOndoJarraian++;
                if(zenbatOndoJarraian==3){
                    return true;
                }
            }else{
                zenbatOndoJarraian=0;
            }
        }

        zenbatOndoJarraian=0;       //no estoy seguro, solo por si acaso

        //5 luzeerako 2.kasua

        for(int i= 4; i<8; i++){
            String unekoFitxaMota = tableroa[9-i][i].getFitxaMota();
            String hurrengoFitxaMota = tableroa[8-i][i+1].getFitxaMota();
            if(unekoFitxaMota.equals(hurrengoFitxaMota)&& !"esleituGabe".equals(hurrengoFitxaMota)){
                zenbatOndoJarraian++;
                if(zenbatOndoJarraian==3){
                    return true;
                }
            }else{
                zenbatOndoJarraian=0;
            }
        }

        zenbatOndoJarraian=0;       //no estoy seguro, solo por si acaso

        //6 luzeerako kasuak

        //horizontalean mugitzeko
        for (int j=0; j<4;j++){
            //diagonalean mugitzeko
            for(int i= 0; i<5; i++){
                String unekoFitxaMota = tableroa[5-i][i+j].getFitxaMota();
                String hurrengoFitxaMota = tableroa[4-i][i+1+j].getFitxaMota();
                if(unekoFitxaMota.equals(hurrengoFitxaMota)&& !"esleituGabe".equals(hurrengoFitxaMota)){
                    zenbatOndoJarraian++;
                    if(zenbatOndoJarraian==3){
                        return true;
                    }
                }else{
                    zenbatOndoJarraian=0;
                }
            }

        }
        return false;
    }

    private boolean konprobatuDiagonaleanEskumatikEzkerrera(){      //behetik gora \

        /*
        Horizontalean eta bertikalean konprobatzen dugunean, konprobatzen ditugun errenkada/zutabe guztiak luzeera berdina izango dute,
        eta horregaitik 'for' bat erabiltzen dugunean ez ditugu arazoak izango.
        Diagonalean konprobatzen dugunean, diagonal desberdinak izango ditugu eta luzeera desberdinak izango dituzte:
                -4 luzeerako diagonalak: 2
                -5 luzeerako diagonalak: 2
                -6 luzeerako diagonalak: 4
                (1, 2 eta 3 luzeerako diagonalean ez dira konprobatzen)
        */

        int zenbatOndoJarraian = 0;

        //4 luzeerako 1. kasua

        for (int i = 0; i<3; i++){
            String unekoFitxaMota = tableroa[2+i][i].getFitxaMota();
            String hurrengoFitxaMota = tableroa[3+i][i+1].getFitxaMota();
            if(unekoFitxaMota.equals(hurrengoFitxaMota) && !"esleituGabe".equals(hurrengoFitxaMota)){
                zenbatOndoJarraian++;
                if (zenbatOndoJarraian==3){
                    return true;
                }
            }else {
                zenbatOndoJarraian = 0;
            }
        }

        zenbatOndoJarraian = 0;

        //4 luzeerako 2. kasua

        for (int i = 5; i<8;i++){
            String unekoFitxaMota = tableroa[i-5][i].getFitxaMota();
            String hurrengoFitxaMota  = tableroa[i-4][i+1].getFitxaMota();
            if(unekoFitxaMota.equals(hurrengoFitxaMota)&& !"esleituGabe".equals(hurrengoFitxaMota)){
                zenbatOndoJarraian++;
                if(zenbatOndoJarraian==3){
                    return true;
                }
            }else{
                zenbatOndoJarraian=0;
            }
        }

        zenbatOndoJarraian = 0;

        //5 luzeerako 1. kasua

        for (int i = 0;i<4;i++){
            String unekoFitxaMota = tableroa[1+i][i].getFitxaMota();
            String hurrengoFitxaMota = tableroa[2+i][i+1].getFitxaMota();
            if(unekoFitxaMota.equals(hurrengoFitxaMota)&& !"esleituGabe".equals(hurrengoFitxaMota)){
                zenbatOndoJarraian++;
                if(zenbatOndoJarraian==3){
                    return true;
                }
            }else{
                zenbatOndoJarraian=0;
            }
        }

        zenbatOndoJarraian = 0;

        //5 luzeerako 2. kasua

        for(int i= 4; i<8; i++){
            String unekoFitxaMota = tableroa[i-4][i].getFitxaMota();
            String hurrengoFitxaMota = tableroa[i-3][i+1].getFitxaMota();
            if(unekoFitxaMota.equals(hurrengoFitxaMota)&& !"esleituGabe".equals(hurrengoFitxaMota)){
                zenbatOndoJarraian++;
                if(zenbatOndoJarraian==3){
                    return true;
                }
            }else{
                zenbatOndoJarraian=0;
            }
        }

        zenbatOndoJarraian = 0;

        //6 luzeerako kasuak

        //horizontalean mugitzeko
        for (int j=0; j<4;j++){
            //diagonalean mugitzeko
            for(int i= 0; i<5; i++){
                String unekoFitxaMota = tableroa[i][i+j].getFitxaMota();
                String hurrengoFitxaMota = tableroa[1+i][i+1+j].getFitxaMota();
                if(unekoFitxaMota.equals(hurrengoFitxaMota)&& !"esleituGabe".equals(hurrengoFitxaMota)){
                    zenbatOndoJarraian++;
                    if(zenbatOndoJarraian==3){
                        return true;
                    }
                }else{
                    zenbatOndoJarraian=0;
                }
            }

        }

        return false;
    }

    public int makinaNonSartu(){
        /*
        1. pausua: array bat lortu behar dugu, fitxak non satu dezakegun jakiteko
        2. pausua: array horren puntuazioak lortu
        3. pausua: puntuazio handiena duen lekuan sartu
        */

        //1.pausua:

        int[] fitxenHurrengoPosizioa = new int[9];     //fitxa bat sartzen badugu zutabe horretan zein errenkadan geratuko den
        int[] puntuazioenBektorea = new int[9];
        for(int i=0; i<9;i++){
            for(int j=0;i<6;j++){
                if("esleituGabe".equals(tableroa[5-j][i].getFitxaMota())) {
                    fitxenHurrengoPosizioa[i] = 5 - j;
                    break;
                }
            }
        }

        //2.pausua:

        /*
        emango diren puntuazioak:

            6: makinak hiru fitxa jarraian ditu
            5: beste jokalariak hiru fitxa jarraian ditu
            4: makina 2 fitxa jarraian ditu
            3: beste jokalariak 2 fitxa jarraian ditu
            2: makinak ez ditu 2 fitxa jarraian (bakarrik fitxa bat dauka)
            1: beste jokalariak ez ditu bi fitxa jarraian (bakarrik fitxa bat dauka)
            0: fitxarik ez badago

         */


        //zutabe bakoitzerako horizontalean, bertikalean eta diagonalean (bi kasuak) konprobatu

        //bertikalean konprobatu

        for (int x=0; x<9; x++) {
            int hurrengoFitxarenPosizioa = fitxenHurrengoPosizioa[x];   //[0...5]  (y ardatza)
            if(hurrengoFitxarenPosizioa <=3){       //bestela nullPointerException izango dugu
                String behekoFitxaMota = tableroa[hurrengoFitxarenPosizioa+1][x].getFitxaMota();
                int zenbatJarraian = 0;
                for (int lag= hurrengoFitxarenPosizioa + 2; lag <6; lag++){
                    if(behekoFitxaMota.equals(tableroa[lag][x].getFitxaMota())) {
                        zenbatJarraian++;
                    }else{break;}
                }

                if("fitxaGorria".equals(behekoFitxaMota)) {
                    if(zenbatJarraian==0) {      //ez daude fitxak jarraian, bakarrik gorri bat
                        puntuazioenBektorea[x] = 2;
                    }else if( zenbatJarraian==1) {       //bi fitxa gorri daude jarraian
                        puntuazioenBektorea[x] = 4;
                    }else if(zenbatJarraian==2) {       //hiru fitxa gorri daude jarraian
                        puntuazioenBektorea[x] = 6;
                    }
                }else if ("fitxaUrdina".equals(behekoFitxaMota)){
                    if(zenbatJarraian==0){      //ez daude fitxak jarraian, bakarrik urdin bat
                        puntuazioenBektorea[x]=1;
                    }else if(zenbatJarraian==1){        //beste jokalariak bi fitxa urdin ditu jarraian
                        puntuazioenBektorea[x] = 3;
                    }else if(zenbatJarraian==2) {        //beste jokalariak hiru fitxa urdin ditu jarraian
                        puntuazioenBektorea[x] = 5;
                    }
                }

            }else if( hurrengoFitxarenPosizioa==4){       //bakarrik fitxa  bat dago
                if ("fitxaGorria".equals(tableroa[5][x].getFitxaMota())){
                    puntuazioenBektorea[x]= 2;
                }else  if("fitxaUrdina".equals(tableroa[5][x].getFitxaMota())) {
                    puntuazioenBektorea[x]= 1;
                }
            }else {
                puntuazioenBektorea[x] = 0;
            }

        }
        return this.zeinDaZutaberikOnena(puntuazioenBektorea);
    }

    private int zeinDaZutaberikOnena(int[] pPuntuazioak){
        int zutaberikOnena = 4;         //erdiko zutabea, kasu gehienak aurkezten dituena da
        int puntuazioAltuena = 0;
        for (int i =0; i<9; i++){
            if (pPuntuazioak[i]> puntuazioAltuena){
                puntuazioAltuena = pPuntuazioak[i];
                zutaberikOnena =i;
            }
        }
        return zutaberikOnena;
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
