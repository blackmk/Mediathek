package de.Mediathek.UI;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import de.Mediathek.Artikel.Artikel;
import de.Mediathek.Artikel.Type;
import de.Mediathek.Person.Kunde;
import de.Mediathek.Person.Mitarbeiter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class SoftwareController implements Initializable{
    @FXML
    public AnchorPane artikelAnchor;
    @FXML
    public AnchorPane mitarbeiterAnchor;
    @FXML
    public AnchorPane kundenAnchor;
    @FXML
    public JFXButton logoutButton;
    @FXML
    public TableView artikelTable;
    @FXML
    public TableView mitarbeiterTable;
    @FXML
    public TableView kundenTable;


    private Fenster fenster;

    public void artikelButton(){
        fenster = Fenster.Artikel;
        changeFenster();
    }

    public void kundenButton(){
        fenster = Fenster.Kunde;
        changeFenster();
    }

    public void mitarbeiterButton(){
        fenster = Fenster.Mitarbeiter;
        changeFenster();
    }

    public void changeFenster(){
        switch (fenster) {
            case Artikel:
                artikelAnchor.setVisible(true);
                kundenAnchor.setVisible(false);
                mitarbeiterAnchor.setVisible(false);
                break;
            case Kunde:
                artikelAnchor.setVisible(false);
                kundenAnchor.setVisible(true);
                mitarbeiterAnchor.setVisible(false);
                break;
            case Mitarbeiter:
                artikelAnchor.setVisible(false);
                kundenAnchor.setVisible(false);
                mitarbeiterAnchor.setVisible(true);
                break;
        }

    }
    public void aktualisieren()
    {

    }

    //Aktualisieren

    public void aktualisiereArtikelTable()
    {
        TableColumn<Artikel, Type> typeCol = new TableColumn<>("Typ");
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Artikel, String> bezeichnungCol = new TableColumn<>("Bezeichung");
        bezeichnungCol.setCellValueFactory(new PropertyValueFactory<>("bezeichung"));

        TableColumn<Artikel, Number> preisCol = new TableColumn<>("Preis");
        preisCol.setCellValueFactory(new PropertyValueFactory<>("preis"));

        TableColumn<Artikel, Number> erscheinungsjahrCol = new TableColumn<>("Erscheinungsjahr");
        erscheinungsjahrCol.setCellValueFactory(new PropertyValueFactory<>("erscheinungsjahr"));

        TableColumn<Artikel, Date> ausleihdatumCol = new TableColumn<>("Ausleihdatum");
        ausleihdatumCol.setCellValueFactory(new PropertyValueFactory<>("ausleihdatum"));

        TableColumn<Artikel, String> ausgeliehenCol = new TableColumn<>("Ausgeliehen");
        ausgeliehenCol.setCellValueFactory(new PropertyValueFactory<>("ausgeliehen"));

        artikelTable.setEditable(false);

        artikelTable.getColumns().setAll(typeCol,bezeichnungCol,preisCol,erscheinungsjahrCol,ausleihdatumCol,ausgeliehenCol);

        artikelTable.setItems(Verwaltung.getArtikelliste());


    }

    public void aktualisiereKundenTable()
    {
        TableColumn<Kunde, Number> knrCol = new TableColumn<>("KundenNr");
        knrCol.setCellValueFactory(new PropertyValueFactory<>("knr"));

        TableColumn<Kunde, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Kunde,String > ortCol = new TableColumn<>("Ort");
        ortCol.setCellValueFactory(new PropertyValueFactory<>("ort"));

        TableColumn<Kunde, Number> plzCol = new TableColumn<>("Postleitzahl");
        plzCol.setCellValueFactory(new PropertyValueFactory<>("plz"));

        TableColumn<Kunde, String> hausnummerCol = new TableColumn<>("Hausnummer");
        hausnummerCol.setCellValueFactory(new PropertyValueFactory<>("hausnummer"));

        kundenTable.setEditable(false);

        kundenTable.getColumns().setAll(knrCol,nameCol,ortCol,plzCol,hausnummerCol);

        kundenTable.setItems(Verwaltung.getKundenliste());
    }

    public void aktualiserenMitarbeiterTable()
    {

        TableColumn<Mitarbeiter, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Mitarbeiter,String > ortCol = new TableColumn<>("Ort");
        ortCol.setCellValueFactory(new PropertyValueFactory<>("ort"));

        TableColumn<Mitarbeiter, Number> plzCol = new TableColumn<>("Postleitzahl");
        plzCol.setCellValueFactory(new PropertyValueFactory<>("plz"));

        TableColumn<Mitarbeiter, Number> strasseCol = new TableColumn<>("Strasse");
        strasseCol.setCellValueFactory(new PropertyValueFactory<>("strasse"));

        TableColumn<Mitarbeiter, String> hausnummerCol = new TableColumn<>("Hausnummer");
        hausnummerCol.setCellValueFactory(new PropertyValueFactory<>("hausnummer"));

        TableColumn<Mitarbeiter, String> benutzernameCol = new TableColumn<>("Benutzername");
        benutzernameCol.setCellValueFactory(new PropertyValueFactory<>("benutzername"));

        TableColumn<Mitarbeiter, Number> passwortCol = new TableColumn<>("Passwort");
        passwortCol.setCellValueFactory(new PropertyValueFactory<>("passwort"));

        mitarbeiterTable.setEditable(false);

        mitarbeiterTable.getColumns().setAll(nameCol,ortCol,plzCol,strasseCol,benutzernameCol,passwortCol);

        mitarbeiterTable.setItems(Verwaltung.getMitarrbeiterliste());
    }
    /*
    ###############################
    ###     Buttons Menu Bar    ###
    ###############################
     */
    public void anlegen()
    {

    }
    public void bearbeiten()
    {

    }
    public void loeschen()
    {

    }


    /*
    #######################
    ###     Artikel     ###
    #######################
     */
    public void artikelAnlegen()
    {

    }
    public void artikelBearbeiten()
    {

    }
    public void artikelLoeschen()
    {

    }

    /*
    ###########################
    ###     Mitarbeiter     ###
    ###########################
     */
    public void mitarbeiterAnlegen()
    {

    }
    public void mitarbeiterBearbeiten()
    {

    }
    public void mitarbeiterLoeschen()
    {

    }

    /*
    #####################
    ###     Kunde     ###
    #####################
     */
    public void kundeAnlegen()
    {

    }
    public void kundeBearbeiten()
    {

    }
    public void kundeLoeschen()
    {

    }


    public void logout()
    {
        System.exit(1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aktualisiereArtikelTable();
        aktualiserenMitarbeiterTable();
        aktualisiereKundenTable();
    }
}
