package de.Mediathek.UI;

import de.Mediathek.Artikel.Artikel;
import de.Mediathek.Person.Kunde;
import de.Mediathek.Person.Mitarbeiter;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

/*
*   Project Mediathek 03.03.2018
*   Blackmk : Origin
 */

public class Verwaltung extends Application{
    private static Mitarbeiter Currnetuser;
    private ObservableList<Artikel> artikelliste;
    private ObservableList<Mitarbeiter> mitarrbeiterliste;
    private ObservableList<Kunde> kundenliste;
    private Scene softwareScene;
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        setArtikelliste(FXCollections.observableArrayList(new ArrayList<Artikel>()));
        setMitarrbeiterliste(FXCollections.observableArrayList(new ArrayList<Mitarbeiter>()));
        setKundenliste(FXCollections.observableArrayList(new ArrayList<Kunde>()));

        stage = primaryStage;
        Parent softwareparent = (Parent) FXMLLoader.load(getClass().getResource("Software.fxml"));
        softwareScene = new Scene(softwareparent);
        softwareScene();
    }

    public void softwareScene(){
        stage.setTitle("Geben sie mir bitte 15 Notenpunkte");
        stage.setResizable(true);
        stage.setScene(softwareScene);
        stage.centerOnScreen();
        stage.setMinWidth(1024);
        stage.setMinHeight(720);
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.show();
    }

    public static Mitarbeiter getCurrnetuser() {
        return Currnetuser;
    }

    public static void setCurrnetuser(Mitarbeiter currnetuser) {
        Currnetuser = currnetuser;
    }

    public ObservableList<Artikel> getArtikelliste() {
        return artikelliste;
    }

    public void setArtikelliste(ObservableList<Artikel> artikelliste) {
        this.artikelliste = artikelliste;
    }

    public ObservableList<Mitarbeiter> getMitarrbeiterliste() {
        return mitarrbeiterliste;
    }

    public void setMitarrbeiterliste(ObservableList<Mitarbeiter> mitarrbeiterliste) {
        this.mitarrbeiterliste = mitarrbeiterliste;
    }

    public ObservableList<Kunde> getKundenliste() {
        return kundenliste;
    }

    public void setKundenliste(ObservableList<Kunde> kundenliste) {
        this.kundenliste = kundenliste;
    }
}
