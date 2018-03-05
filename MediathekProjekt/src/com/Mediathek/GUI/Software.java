package com.Mediathek.GUI;

import com.Mediathek.Artikel.Artikel;
import com.Mediathek.Artikel.Buch;
import com.Mediathek.Artikel.Type;
import com.Mediathek.Personen.Kunde;
import com.Mediathek.Personen.Mitarbeiter;
import com.Mediathek.System.DateiManager;
import com.Mediathek.System.MSystem;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.*;

public class Software implements Initializable {

    @FXML
    AnchorPane softwarepane;
    @FXML
    JFXButton mitarbeiterMenuButton;

    //Profil
    @FXML
    private Label name;
    @FXML
    private Label vorname;
    @FXML
    private Label ort;
    @FXML
    private Label postleitzahl;
    @FXML
    private Label strasse;
    @FXML
    private Label hausnummer;


    //Artikel
    @FXML
    Label listSizeArtikel;
    @FXML
    VBox vboxArtikel;
    @FXML
    TableView artikelTableView;
    public static ObservableList<Artikel> dataArtikel;

    //Kunden
    @FXML
    Label listSizeKunden;
    @FXML
    VBox vboxKunden;
    @FXML
    Label listSizeAusgeliehen;
    @FXML
    VBox vboxAusgeliehen;
    @FXML
    TableView<Kunde> kundenTableView;
    @FXML
    TableView<Artikel> ausgeliehenTableView;
    public static ObservableList<Kunde> dataKunde;
    private static ObservableList<Artikel> dataAusgeliehen;
    public static SelectionModel sk;

    //Mitarbeiter
    @FXML
    private Label listSizeMitarbeiter;
    @FXML
    private VBox vboxMitarbeiter;
    @FXML
    private TableView<Mitarbeiter> mitarbeiterTableView;
    public static ObservableList<Mitarbeiter> dataMitarbeiter;


    //Menu
    @FXML
    AnchorPane profilPane;
    @FXML
    AnchorPane artikelPane;
    @FXML
    AnchorPane kundenPane;
    @FXML
    AnchorPane mitarbeiterPane;

    private Fenster fenster;

    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        softwarepane.setMinSize(1024,480);
        profilPane.setVisible(false);
        artikelPane.setVisible(false);
        kundenPane.setVisible(false);
        mitarbeiterPane.setVisible(false);
        aktualisiereArtikelTable();
        aktualisiereKundenTable();
        aktualisiereAusgeliehenTable();
        aktualisiereMitarbeiterTable();

        sk = kundenTableView.getSelectionModel();

        changeSelectedTextArtikel();
        changeSelectedTextKunde();
        changeSelectedTextAusgeliehen();
        changeSelectedTextMitarbeiter();

        //noinspection unchecked
        dataArtikel.addListener((ListChangeListener<? super Artikel>) c -> aktualisiereArtikelTable());

        //noinspection unchecked
        dataKunde.addListener((ListChangeListener<? super Kunde>) c -> aktualisiereKundenTable());

        //noinspection unchecked
        dataAusgeliehen.addListener((ListChangeListener<? super Artikel>) c -> aktualisiereAusgeliehenTable());

        //noinspection unchecked
        dataMitarbeiter.addListener((ListChangeListener<? super Mitarbeiter>) c -> aktualisiereMitarbeiterTable());


    }

    public void profileButton()
    {
        fenster = Fenster.Profil;
        aktualisiereProfil();
        changeAnchor();
    }

    public void artikelButton()
    {
        fenster = Fenster.Artikel;
        changeAnchor();
    }

    public void kundenButton()
    {
        fenster = Fenster.Kunden;
        changeAnchor();
    }

    public void mitarbeiterButton()
    {
        if(MSystem.isAdmin())
        {
            fenster = Fenster.Mitarbeiter;
            changeAnchor();
        }
    }

    public void checkAdmin()
    {
        if(!MSystem.isAdmin())
        {
            mitarbeiterMenuButton.setRipplerFill(Paint.valueOf("FF0000"));
        }
    }

    private void changeAnchor()
    {
        switch (fenster)
        {
            case Profil:
                profilPane.setVisible(true);
                artikelPane.setVisible(false);
                kundenPane.setVisible(false);
                mitarbeiterPane.setVisible(false);
                break;
            case Artikel:
                profilPane.setVisible(false);
                artikelPane.setVisible(true);
                kundenPane.setVisible(false);
                mitarbeiterPane.setVisible(false);
                break;
            case Kunden:
                profilPane.setVisible(false);
                artikelPane.setVisible(false);
                kundenPane.setVisible(true);
                mitarbeiterPane.setVisible(false);
                break;
            case Mitarbeiter:
                profilPane.setVisible(false);
                artikelPane.setVisible(false);
                kundenPane.setVisible(false);
                mitarbeiterPane.setVisible(true);
                break;
        }
    }


    //Profil
    private void aktualisiereProfil()
    {
        Mitarbeiter tmp = GuiController.getmSystem().getCurrentUser();
        name.setText(tmp.getName());
        vorname.setText(tmp.getVorname());
        ort.setText(tmp.getOrt());
        postleitzahl.setText(Integer.toString(tmp.getPlz()));
        strasse.setText(tmp.getStrasse());
        hausnummer.setText(tmp.getHausnummer());
    }

    //===================================//
    //              Artikel              //
    //===================================//

    public void artikelAnlegen()
    {
        GuiController.openArtikelAnlegen();
    }

    public void artikelBearbeiten()
    {

    }

    public void artikelLoeschen()
    {
        int i=artikelTableView.getSelectionModel().getFocusedIndex();
        System.out.println(i);
        if(dataArtikel.size()!=0)
        {
            if (dataArtikel.get(i) != null) dataArtikel.remove(i);
            if (GuiController.getmSystem().getArtikelListe().get(i) != null)
                if(!GuiController.getmSystem().getArtikelListe().get(i).isStatus())
                    GuiController.getmSystem().getArtikelListe().remove(i);
        }
    }

    public void aktualisiereArtikelTable()
    {
        dataArtikel = FXCollections.observableArrayList(GuiController.getmSystem().getArtikelListe());
        System.out.println("Aktualisiere Artikel");
        artikelTableView.setEditable(false);

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
        artikelTableView.getColumns().setAll(idCol,typeCol,bezeichnungCol,preisCol,erscheinungsjahrCol,ausleihdatumCol,statusCol,verlagCol,interpretCol);
        //noinspection unchecked
        artikelTableView.setItems(dataArtikel);
        vboxArtikel.setSpacing(5);
    }


    public void changeSelectedTextArtikel()
    {
        int tmp = GuiController.getmSystem().getArtikelListe().size();
        int sel = artikelTableView.getFocusModel().getFocusedIndex();
        String tmpText = ++sel + " von " + tmp;
        listSizeArtikel.setText(tmpText);
    }

    //===================================//
    //              Kunden               //
    //===================================//

    public void kundenAnlegen()
    {
        GuiController.openKundeAnlegen();
    }

    public void kundenBearbeiten()
    {

    }

    public void kundenLoeschen()
    {
        int i=kundenTableView.getSelectionModel().getFocusedIndex();
        System.out.println(i);
        if(dataKunde.size()!=0)
        {
            if (dataKunde.get(i) != null) dataKunde.remove(i);
            if (GuiController.getmSystem().getKundenListe().get(i) != null)
                if(GuiController.getmSystem().getKundenListe().get(i).getAusgeliehenListe().size()==0)
                        GuiController.getmSystem().getKundenListe().remove(i);
        }
    }

    public void aktualisiereKundenTable()
    {
        dataKunde = FXCollections.observableArrayList(GuiController.getmSystem().getKundenListe());
        System.out.println("Aktualisiere Kunden");
        kundenTableView.setEditable(false);

        TableColumn<Kunde, Number> kundenNummerCol = new TableColumn<>("KundenNummer");
        kundenNummerCol.setCellValueFactory(new PropertyValueFactory<>("kundenNummer"));

        TableColumn<Kunde, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Kunde, String> vornameCol = new TableColumn<>("Vorname");
        vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));

        TableColumn<Kunde, String> ortCol = new TableColumn<>("Ort");
        ortCol.setCellValueFactory(new PropertyValueFactory<>("ort"));

        TableColumn<Kunde, Number> plzCol = new TableColumn<>("Postleitzahl");
        plzCol.setCellValueFactory(new PropertyValueFactory<>("plz"));

        TableColumn<Kunde, String> strasseCol = new TableColumn<>("Straße");
        strasseCol.setCellValueFactory(new PropertyValueFactory<>("strasse"));

        TableColumn<Kunde, String> hausnummerCol = new TableColumn<>("Hausnummer");
        hausnummerCol.setCellValueFactory(new PropertyValueFactory<>("hausnummer"));

        TableColumn<Kunde, String> ausgeliehenCol = new TableColumn<>("Ausgeliehen");
        ausgeliehenCol.setCellValueFactory(new PropertyValueFactory<>("anzahlAusgeliehen"));

        kundenNummerCol.setPrefWidth(110);
        nameCol.setPrefWidth(120);
        vornameCol.setPrefWidth(120);
        ortCol.setPrefWidth(120);
        plzCol.setPrefWidth(100);
        strasseCol.setPrefWidth(120);
        hausnummerCol.setPrefWidth(100);
        ausgeliehenCol.setPrefWidth(150);


        //noinspection unchecked
        kundenTableView.getColumns().setAll(kundenNummerCol,nameCol,vornameCol,ortCol,plzCol,strasseCol,hausnummerCol,ausgeliehenCol);

        kundenTableView.setItems(dataKunde);
        vboxKunden.setSpacing(5);

        aktualisiereAusgeliehenTable();
    }

    @SuppressWarnings("unchecked")
    private void aktualisiereAusgeliehenTable()
    {
        if(kundenTableView.getFocusModel().getFocusedIndex()==-1)
            dataAusgeliehen = FXCollections.observableArrayList(new ArrayList<Artikel>());
        else
            dataAusgeliehen = FXCollections.observableArrayList(GuiController.getmSystem().getKundenListe().get(kundenTableView.getFocusModel().getFocusedIndex()).getAusgeliehenListe());

        System.out.println("Aktualisiere Ausgeliehen");
        ausgeliehenTableView.setEditable(false);


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
       /* TableColumn verlagCol = new TableColumn("Verlag");
        verlagCol.setCellValueFactory(new PropertyValueFactory<Buch, String>("verlag"));

        TableColumn interpretCol = new TableColumn("Interpret");
        interpretCol.setCellValueFactory(new PropertyValueFactory<Buch, String>("interpret"));*/

        idCol.setPrefWidth(50);
        idCol.setResizable(false);
        typeCol.setPrefWidth(70);
        bezeichnungCol.setPrefWidth(200);
        preisCol.setPrefWidth(100);
        erscheinungsjahrCol.setPrefWidth(200);
        ausleihdatumCol.setPrefWidth(200);
        statusCol.setPrefWidth(100);
        /*verlagCol.setPrefWidth(150);
        interpretCol.setPrefWidth(150);*/

        ausgeliehenTableView.getColumns().setAll(idCol,typeCol,bezeichnungCol,preisCol,erscheinungsjahrCol,ausleihdatumCol,statusCol/*,verlagCol,interpretCol*/);
        ausgeliehenTableView.setItems(dataAusgeliehen);
        vboxAusgeliehen.setSpacing(5);

    }

    public void artikelAusleihen()
    {
        GuiController.openArtikelAusleihen();
    }

    public void artikelZurueckgeben()
    {

    }

    //===================================//
    //              Mitarbeiter          //
    //===================================//

    public void mitarbeiterAnlegen()
    {
        GuiController.openMitarbeiterAnlegen();
    }

    public void mitarbeiterBearbeiten()
    {

    }

    public void mitarbeiterLoeschen()
    {

    }

    public void aktualisiereMitarbeiterTable()
    {
        dataMitarbeiter = FXCollections.observableArrayList(GuiController.getmSystem().getMitarbeiterListe());
        System.out.println("Aktualisiere Mitarbeiter");
        mitarbeiterTableView.setEditable(false);

        TableColumn<Mitarbeiter, Number> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<Mitarbeiter, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Mitarbeiter, String> vornameCol = new TableColumn<>("Vorname");
        vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));

        TableColumn<Mitarbeiter, String> ortCol = new TableColumn<>("Ort");
        ortCol.setCellValueFactory(new PropertyValueFactory<>("ort"));

        TableColumn<Mitarbeiter, Number> plzCol = new TableColumn<>("Postleitzahl");
        plzCol.setCellValueFactory(new PropertyValueFactory<>("plz"));

        TableColumn<Mitarbeiter, String> strasseCol = new TableColumn<>("Straße");
        strasseCol.setCellValueFactory(new PropertyValueFactory<>("strasse"));

        TableColumn<Mitarbeiter, String> hausnummerCol = new TableColumn<>("Hausnummer");
        hausnummerCol.setCellValueFactory(new PropertyValueFactory<>("hausnummer"));

        idCol.setPrefWidth(110);
        nameCol.setPrefWidth(120);
        vornameCol.setPrefWidth(120);
        ortCol.setPrefWidth(120);
        plzCol.setPrefWidth(100);
        strasseCol.setPrefWidth(120);
        hausnummerCol.setPrefWidth(100);

        //noinspection unchecked
        mitarbeiterTableView.getColumns().setAll(idCol, nameCol, vornameCol, ortCol, plzCol, strasseCol, hausnummerCol);
        mitarbeiterTableView.setItems(dataMitarbeiter);
        vboxMitarbeiter.setSpacing(5);
    }

    public void changeSelectedTextKunde()
    {
        int tmp = GuiController.getmSystem().getKundenListe().size();
        int sel = kundenTableView.getFocusModel().getFocusedIndex();
        String tmpText = ++sel + " von " + tmp;
        listSizeKunden.setText(tmpText);
        changeSelectedTextAusgeliehen();
        aktualisiereAusgeliehenTable();
    }

    public void changeSelectedTextMitarbeiter()
    {
        int tmp = GuiController.getmSystem().getMitarbeiterListe().size();
        int sel = mitarbeiterTableView.getFocusModel().getFocusedIndex();
        String tmpText = ++sel + " von " + tmp;
        listSizeMitarbeiter.setText(tmpText);
    }

    public void changeSelectedTextAusgeliehen()
    {
        int tmp;
        if(kundenTableView.getFocusModel().getFocusedIndex()!=-1)
            tmp = GuiController.getmSystem().getKundenListe().get(kundenTableView.getFocusModel().getFocusedIndex()).getAusgeliehenListe().size();
        else
            tmp = 0;
        int sel = ausgeliehenTableView.getFocusModel().getFocusedIndex();
        String tmpText = ++sel + " von " + tmp;
        listSizeAusgeliehen.setText(tmpText);
    }

    public void logout()
    {
        DateiManager.dateiSpeichern("Artikel",GuiController.getmSystem().getArtikelListe());
        DateiManager.dateiSpeichern("Kunden",GuiController.getmSystem().getKundenListe());
        DateiManager.dateiSpeichern("Mitarbeiter",GuiController.getmSystem().getMitarbeiterListe());
        GuiController.getStage().close();
        GuiController.getStage2().close();
        System.exit(1);
    }

    public void prozentsatzAnheben()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Artikel um prozentsatz Anheben");
        dialog.setHeaderText("Gebe einen prozentsatz ein\n20 = 120%");
        dialog.setContentText("Prozentsatz: ");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(this::extractPreis);


    }

    private void extractPreis(String result) {
        double num = Double.parseDouble(result);
            LinkedList<Artikel> a = GuiController.getmSystem().getArtikelListe();
            for (Artikel artikel : a)
            {
                double preis = (artikel.getPreis() / 100.0) * (100.0 + num);
                //Nachkommastellen beachten
                artikel.setPreis(Math.round(preis*100.0)/100.0);
            }
        aktualisiereArtikelTable();
    }

    public void jahreLoeschen()
    {
        LinkedList<Artikel> a = GuiController.getmSystem().getArtikelListe();
        for(Artikel artikel : a)
        {
            if(artikel.isStatus())
            {
                Date tmp = artikel.getAusleihdatum();
                if(tmp.getYear()+5 < new Date(System.currentTimeMillis()).getYear())
                {
                    a.remove(artikel);
                }
            }
        }
    }

}
