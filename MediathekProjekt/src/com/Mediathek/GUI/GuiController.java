package com.Mediathek.GUI;

import com.Mediathek.System.MSystem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiController extends Application{




    private static Stage stage;
    private static Stage stage2;
    private static Stage stage3;
    private static Stage stage4;
    private static Stage stage5;
    private static Scene loginScene;
    private static Scene softwareScene;
    private static Scene artikelAnlegenScene;
    private static Scene kundeAnlegenScene;
    private static Scene artikelAusleihenScene;
    private static Scene mitarbeiterAnlegenScene;

    private static MSystem mSystem;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        mSystem = new MSystem();
        GuiController.stage = stage;
        stage2 = new Stage();
        stage3 = new Stage();
        stage4 = new Stage();
        stage5 = new Stage();
        Parent loginParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        loginScene = new Scene(loginParent);
        Parent softwareParent = FXMLLoader.load(getClass().getResource("software.fxml"));
        softwareScene = new Scene(softwareParent);
        Parent artikelAnlegenParent = FXMLLoader.load(getClass().getResource("Anlegen/ArtikelAnlegen.fxml"));
        artikelAnlegenScene = new Scene(artikelAnlegenParent);
        Parent kundeAnlegenParent = FXMLLoader.load(getClass().getResource("Anlegen/KundeAnlegen.fxml"));
        kundeAnlegenScene = new Scene(kundeAnlegenParent);
        Parent artikelAusleihenParent = FXMLLoader.load(getClass().getResource("Ausleihen/ArtikelAusleihen.fxml"));
        artikelAusleihenScene = new Scene(artikelAusleihenParent);
        Parent mitarbeiterAnlegenParent = FXMLLoader.load(getClass().getResource("Anlegen/MitarbeiterAnlegen.fxml"));
        mitarbeiterAnlegenScene = new Scene(mitarbeiterAnlegenParent);
        loginScene();
    }

    private static void loginScene()
    {
        stage.setTitle("Mediathek Login");
        stage.setResizable(false);
        stage.setScene(loginScene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void softwareScene()
    {
        stage.setScene(softwareScene);
        stage.setTitle("Mediathek Verwaltung");
        stage.setResizable(true);
        stage.setMinWidth(1024);
        stage.setMinHeight(720);
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.centerOnScreen();
        stage.show();
    }

    public static void openArtikelAnlegen()
    {
        stage2.setScene(artikelAnlegenScene);
        stage2.setTitle("Artikel Anlegen");
        stage2.setResizable(false);
        stage2.show();
    }

    public static void openKundeAnlegen()
    {
        stage3.setScene(kundeAnlegenScene);
        stage3.setTitle("Kunde Anlegen");
        stage3.setResizable(false);
        stage3.show();
    }

    public static void openArtikelAusleihen()
    {
        stage4.setScene(artikelAusleihenScene);
        stage4.setTitle("Artikel Ausleihen");
        stage4.setResizable(false);
        stage4.show();
    }

    public static void openMitarbeiterAnlegen()
    {
        stage5.setScene(mitarbeiterAnlegenScene);
        stage5.setTitle("Mitarbeiter Anlegen");
        stage5.setResizable(false);
        stage5.show();
    }

    public static MSystem getmSystem() {
        return mSystem;
    }

    public static Stage getStage() {
        return stage;
    }

    public static Stage getStage2() {
        return stage2;
    }

    public static Stage getStage3(){
        return stage3;
    }

    public static Stage getStage5()
    {
        return stage5;
    }


}
