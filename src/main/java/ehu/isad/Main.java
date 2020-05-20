package ehu.isad;

import ehu.isad.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends Application {

  private Parent aukeratuUI;
  private Parent mainUI;
  private Parent partidaAmaieraUI;
  private Parent rankingTaulaUI;

  private Stage stage;

  private AukeratuKud aukeratuKud;
  private MainKud mainKud;
  private PartidaAmaieraKud partidaAmaieraKud;
  private RankingTaulaKud rankingTaulaKud;

  private Scene aukeratuScene;
  private Scene mainScene;
  private Scene partidaAmaieraScene;
  private Scene rankingTaulaScene;


  @Override
  public void start(Stage primaryStage) throws Exception {

    datuBaseaHasieratu();
    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("KONEKTA 4");
    aukeratuScene = new Scene(aukeratuUI);
    stage.setScene(aukeratuScene);
    stage.show();
  }

  private void datuBaseaHasieratu(){

    Path source = null;
    Path destination = null;

    String path = System.getProperty("user.home") + File.separatorChar + ".Konekta4" + File.separatorChar + "Konekta4.sqlite";
    if(!(new File(path).exists())) {
      try {
        File sourceFile = new File( getClass().getClassLoader().getResource("Konekta4.sqlite").toURI() );
        Path sourcePath = sourceFile.toPath();

        File destFile = new File(path);
        Path destPath = destFile.toPath();

        File destDir = new File(System.getProperty("user.home") + File.separatorChar + ".Konekta4" + File.separatorChar);
        Path destPathDir = destDir.toPath();
        Files.createDirectories(destPathDir);


        Files.copy( sourcePath, destPath );

      } catch (URISyntaxException | IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderAukeratu = new FXMLLoader(getClass().getResource("/aukeratu.fxml"));
    aukeratuUI = (Parent) loaderAukeratu.load();
    aukeratuKud = loaderAukeratu.getController();
    aukeratuKud.setMainApp(this);

    FXMLLoader laoderMain = new FXMLLoader(getClass().getResource("/main.fxml"));
    mainUI = (Parent) laoderMain.load();
    mainKud = laoderMain.getController();
    mainKud.setMainApp(this);

    FXMLLoader laoderPartidaAmaiera = new FXMLLoader(getClass().getResource("/partidaAmaiera.fxml"));
    partidaAmaieraUI = (Parent) laoderPartidaAmaiera.load();
    partidaAmaieraKud = laoderPartidaAmaiera.getController();
    partidaAmaieraKud.setMainApp(this);

    FXMLLoader loaderRankingTaula = new FXMLLoader(getClass().getResource("/rankingTaula.fxml"));
    rankingTaulaUI = (Parent) loaderRankingTaula.load();
    rankingTaulaKud = loaderRankingTaula.getController();
    rankingTaulaKud.setMainApp(this);
  }

  public static void main(String[] args) {
    launch(args);
  }

  public void mainErakutsi(String pJokoModua) {
      if(mainScene==null){
          mainScene =new Scene(mainUI);
      }
        stage.setScene(mainScene);
        stage.show();
        mainKud.setJokoModua(pJokoModua);
        mainKud.guztiaPrestatu();

  }

  public void aukerakErakutsi(){
    if(aukeratuScene==null){
      aukeratuScene = new Scene(aukeratuUI);
    }
    stage.setScene(aukeratuScene);
    stage.show();
  }


  public void partidareEmaitzaIkusi(String emaitza, String pJokoModua, long pDenbora){
    if(partidaAmaieraScene==null){
      partidaAmaieraScene = new Scene(partidaAmaieraUI);
    }
    stage.setScene(partidaAmaieraScene);
    stage.show();
    partidaAmaieraKud.setIrabazlea(emaitza);
    partidaAmaieraKud.setDenbora(pDenbora);
    partidaAmaieraKud.setJokoModua(pJokoModua);

  }
  public void rankingTaulaErakutsi(String pJokoModua, long pDenbora){
    if (rankingTaulaScene==null){
      rankingTaulaScene = new Scene(rankingTaulaUI);
    }
    stage.setScene(rankingTaulaScene);
    stage.show();
    rankingTaulaKud.guztiaPrestatu(pJokoModua,pDenbora);
    rankingTaulaKud.setRanking();
  }
}
