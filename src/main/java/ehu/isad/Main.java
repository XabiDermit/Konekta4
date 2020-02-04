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
  private Parent mainUI;

  private Stage stage;

  private AukeratuKud aukeratuKud;
  private MainKud mainKud;

  private Scene aukeratuScene;
  private Scene mainScene;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Auketatu");
    aukeratuScene = new Scene(aukeratuUI);
    stage.setScene(aukeratuScene);
    stage.show();
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

  }


  public static void main(String[] args) {
    launch(args);
  }

  public void mainErakutsi() {
      if(mainScene==null){
          mainScene =new Scene(mainUI);
      }
        stage.setScene(mainScene);
        stage.show();
  }

  public void aukerakErakutsi(){
    if(aukeratuScene==null){
      aukeratuScene = new Scene(aukeratuUI);
    }
    stage.setScene(aukeratuScene);
    stage.show();
  }
}
