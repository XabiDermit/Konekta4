package ehu.isad;

import ehu.isad.controller.db.DBKudeatzaile;
import ehu.isad.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent aukeratuUI;

  private Stage stage;

  private AukeratuKud aukeratuKud;

  private Scene mainScene;

  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Auketatu");
    stage.setScene(new Scene(aukeratuUI, 600, 400));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderAukeratu = new FXMLLoader(getClass().getResource("/aukeratu.fxml"));
    aukeratuUI = (Parent) loaderAukeratu.load();
    aukeratuKud = loaderAukeratu.getController();
    aukeratuKud.setMainApp(this);

  }


  public static void main(String[] args) {
    launch(args);
  }
/*
  public void herrialdeakErakutsi() {
      if(UI2Scene==null){
          UI2Scene =new Scene(UI2);
      }
        stage.setScene(UI2Scene);
        stage.show();
        UI2Kud.partaideakErakutsi();
  }*/
}
