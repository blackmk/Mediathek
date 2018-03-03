package com.Mediathek.GUI.Ausleihen;

import com.Mediathek.Artikel.Artikel;
import com.Mediathek.Artikel.Buch;
import com.Mediathek.Artikel.Type;
import com.Mediathek.GUI.GuiController;
import com.Mediathek.GUI.Software;
import com.Mediathek.Personen.Kunde;
import com.Mediathek.System.MSystem;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.UncheckedIOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArtikelAusleihen implements Initializable
{
    @FXML
    Label target;
    @FXML
    Label freeText;
    @FXML
    Label warenkorbText;
    @FXML
    TableView<Artikel> freieListe;
    @FXML
    TableView<Artikel> warenkorbListe;

    private static ObservableList<Artikel> freieArtikelListe;
    private static ObservableList<Artikel> warenkorbArtikelListe;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        target.setText("Kunde");
        warenkorbArtikelListe = FXCollections.observableArrayList(new ArrayList<Artikel>());

        for(int i = 0; i < warenkorbArtikelListe.size(); i++)
            if(warenkorbArtikelListe.get(i).isStatus())
                warenkorbArtikelListe.remove(i);

        freieArtikelListe = FXCollections.observableArrayList(GuiController.getmSystem().getArtikelListe());

        for(int i = 0; i < freieArtikelListe.size(); i++)
            if(freieArtikelListe.get(i).isStatus())
                freieArtikelListe.remove(i);

        freieArtikelListe.addListener((ListChangeListener<? super Artikel>) c -> aktualisiereFreieListe());
        warenkorbArtikelListe.addListener((ListChangeListener<? super Artikel>) c -> aktualisiereWarenkorbListe());
    }

    private void aktualisiereFreieListe()
    {
        freieListe.setEditable(false);
    }

    private void aktualisiereWarenkorbListe() {
        warenkorbListe.setEditable(false);

        TableColumn<Artikel, Number> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<Artikel, Type> typeCol= new TableColumn<>("Typ");
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Artikel, String> bezeichnungCol = new TableColumn<>("Bezeichnung");
        bezeichnungCol.setCellValueFactory(new PropertyValueFactory<>("bezeichnung"));

        TableColumn<Artikel, Number> preisCol = new TableColumn<>("Preis");
        preisCol.setCellValueFactory(new PropertyValueFactory<>("preis"));

        TableColumn<Artikel, String> erscheinungsjahrCol = new TableColumn<>("Erscheinungsjahr");
        erscheinungsjahrCol.setCellValueFactory(new PropertyValueFactory<>("erscheinungsjahr"));

        TableColumn<Artikel, String> ausleihdatumCol = new TableColumn<>("Ausleihdatum");
        ausleihdatumCol.setCellValueFactory(new PropertyValueFactory<>("ausleihdatum"));

        TableColumn<Artikel, String> statusCol = new TableColumn<>("Ausgeliehen");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("ausgeliehen"));

        //TODO: Die Fehlermeldung der nicht gefundenen Attribute entfernen
        TableColumn<Buch, String> verlagCol = new TableColumn<>("Verlag");
        verlagCol.setCellValueFactory(new PropertyValueFactory<>("verlag"));

        TableColumn<Buch, String> interpretCol = new TableColumn<>("Interpret");
        interpretCol.setCellValueFactory(new PropertyValueFactory<>("interpret"));


        idCol.setPrefWidth(50);
        idCol.setResizable(false);
        typeCol.setPrefWidth(70);
        bezeichnungCol.setPrefWidth(200);
        preisCol.setPrefWidth(100);
        erscheinungsjahrCol.setPrefWidth(200);
        ausleihdatumCol.setPrefWidth(200);
        statusCol.setPrefWidth(100);
        verlagCol.setPrefWidth(150);
        interpretCol.setPrefWidth(150);

        //noinspection unchecked
        //warenkorbListe.getColumns().setAll(idCol,typeCol,bezeichnungCol,preisCol,erscheinungsjahrCol,ausleihdatumCol,statusCol,verlagCol,interpretCol);
    }

    public void changeTarget() {
        int selectedIndex = Software.sk.getSelectedIndex();
        Kunde kunde = GuiController.getmSystem().getKundenListe().get(selectedIndex);
        setTarget(kunde.getKundenNummer()+ " : " + kunde.getVorname() + " " + kunde);
    }

    private void setTarget(String text)
    {
        target.setText(text);
    }

    public void pushUp()
    {
        //TODO:
        int sel = warenkorbListe.getSelectionModel().getFocusedIndex();
        warenkorbArtikelListe.remove(sel);

    }

    public void pushDown()
    {

    }

    public void ausleihen()
    {

    }
}
