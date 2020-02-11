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
                if("esleituGabe".equals(tableroa[5-j][i].getFitxaMota())){
                    fitxenHurrengoPosizioa[i]=5-j;
                    break;
            }
        }

        //2.pausua:

        /*
        emango diren puntuazioak:

            5: makinak hiru fitxa jarraian ditu
            4: beste jokalariak hiru fitxa jarraian ditu
            3: makina 2 fitxa jarraian ditu
            2: beste jokalariak 2 fitxa jarraian ditu
            1: makinak ez ditu 2 fitxa jarraian

         */

        //zutabe bakoitzerako horizontalean, bertikalean eta diagonalean (bi kasuak) konprobatu

        //bertikalean konprobatu

        for (int x=0; x<9; x++) {
            int hurrengoFitxarenPosizioa = fitxenHurrengoPosizioa[x];   //[0...5]
            int makinarenZenbatFitxaJarraian = 0;
            int jokalariarenZenbatFitxaJarraian = 0;
            if (hurrengoFitxarenPosizioa <= 3) {

                //makinaren fitxak nola dauden jakiteko
                for (int y = hurrengoFitxarenPosizioa + 1; y < 5; y++){
                    if ("fitxaGorria".equals(tableroa[y][x].getFitxaMota())){
                        makinarenZenbatFitxaJarraian++;
                    }else{
                        break;
                    }
                }

                //jokalariaren fitxak nola dauden jakiteko


            }else if (hurrengoFitxarenPosizioa== 4 && "fitxaGorria".equals(tableroa[5][x].getFitxaMota())){

            }
            if(makinarenZenbatFitxaJarraian==2){      //hiru fitxa jarraian ditugu
                puntuazioenBektorea[x]=5;
            }else if(makinarenZenbatFitxaJarraian==1) {    //bi fitxa jarraian ditugu
                puntuazioenBektorea[x]=3;
            }


        }
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
