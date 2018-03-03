package de.Mediathek.UI;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SoftwareController implements Initializable{
    @FXML
    public AnchorPane artikelPane;
    @FXML
    public AnchorPane mitarbeiterPane;
    @FXML
    public AnchorPane kundenPane;
    @FXML
    public ChoiceBox<Fenster> navigationChoiceBox;

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
                artikelPane.setVisible(true);
                kundenPane.setVisible(false);
                mitarbeiterPane.setVisible(false);
                break;
            case Kunde:
                artikelPane.setVisible(false);
                kundenPane.setVisible(true);
                mitarbeiterPane.setVisible(false);
                break;
            case Mitarbeiter:
                artikelPane.setVisible(false);
                kundenPane.setVisible(false);
                mitarbeiterPane.setVisible(true);
                break;
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        navigationChoiceBox.getItems().addAll(Fenster.Artikel,Fenster.Kunde,Fenster.Mitarbeiter);
        navigationChoiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)-> aktualisieren());
        navigationChoiceBox.setValue(Fenster.Artikel);
    }

    public void aktualisieren()
    {

    }
}
