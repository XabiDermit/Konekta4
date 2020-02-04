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

  private Parent mainUI;

  private Stage stage;

  private MainKud mainKud;

  private Scene mainScene;

  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Txanponak");
    stage.setScene(new Scene(mainUI, 600, 400));
    mainKud.comboBoxBete();
    mainKud.taulaBete();
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loadermain = new FXMLLoader(getClass().getResource("/main.fxml"));
    mainUI = (Parent) loadermain.load();
    mainKud = loadermain.getController();
    mainKud.setMainApp(this);

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
