package de.Mediathek.UI;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SoftwareController{
    @FXML
    public AnchorPane artikelAnchor;
    @FXML
    public AnchorPane mitarbeiterAnchor;
    @FXML
    public AnchorPane kundenAnchor;

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
}
