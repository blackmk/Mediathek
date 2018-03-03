package com.Mediathek.GUI.Anlegen;

import com.Mediathek.Artikel.Buch;
import com.Mediathek.Artikel.CD;
import com.Mediathek.Artikel.Type;
import com.Mediathek.GUI.GuiController;
import com.Mediathek.GUI.Software;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class ArtikelAnlegen implements Initializable {
    @FXML
    ChoiceBox<Type> artikelAnlegenChoicebox;
    @FXML
    private JFXTextField bezeichnungField;
    @FXML
    private JFXTextField preisField;
    @FXML
    private JFXDatePicker erscheinungsjahrField;
    @FXML
    private JFXTextField interpretField;
    @FXML
    private JFXTextField verlagField;


    public void fertigstellen()
    {
        boolean valid = true;
        String bezeichnung;
        double preis=0;
        Date erscheinungsjahr;
        bezeichnung = bezeichnungField.getText();
        if(bezeichnung.equals(""))
        {
            bezeichnungField.setUnFocusColor(Paint.valueOf("FF0000"));
            valid=false;
        }else
        {
            bezeichnungField.setUnFocusColor(Paint.valueOf("6f6e6e"));
        }
        if(preisField.getText().matches("[0-9]*.[0-9]*")&& !(preisField.getText().contains(",")))
        {
            preis = Double.parseDouble(preisField.getText());
            preisField.setUnFocusColor(Paint.valueOf("6f6e6e"));
        }else
        {
            preisField.setUnFocusColor(Paint.valueOf("FF0000"));
            valid=false;
        }
        erscheinungsjahr = null;
        try {
            erscheinungsjahr = Date.from(erscheinungsjahrField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        if(erscheinungsjahr != null)
        {
            erscheinungsjahrField.setDefaultColor(Paint.valueOf("6f6e6e"));
        }else
        {
            valid = false;
            erscheinungsjahrField.setDefaultColor(Paint.valueOf("FF0000"));
        }
        switch (artikelAnlegenChoicebox.getValue())
        {
            case CD:
                String interpret = interpretField.getText();
                if(interpret.equals(""))
                {
                    valid = false;
                    interpretField.setUnFocusColor(Paint.valueOf("FF0000"));
                }else
                {
                    interpretField.setUnFocusColor(Paint.valueOf("6f6e6e"));
                }

                if(valid)
                {
                    CD tmp = new CD(bezeichnung,preis,erscheinungsjahr,null ,interpret);
                    GuiController.getmSystem().getArtikelListe().add(tmp);
                    Software.dataArtikel.add(tmp);
                    GuiController.getStage2().close();
                }
                break;
            case Buch:
                String verlag = verlagField.getText();
                if(verlag.equals(""))
                {
                    valid = false;
                    verlagField.setUnFocusColor(Paint.valueOf("FF0000"));
                }else
                {
                    verlagField.setUnFocusColor(Paint.valueOf("6f6e6e"));
                }

                if(valid)
                {
                    Buch tmp = new Buch(bezeichnung,preis,erscheinungsjahr,null,verlag);
                    GuiController.getmSystem().getArtikelListe().add(tmp);
                    Software.dataArtikel.add(tmp);
                    GuiController.getStage2().close();
                }
        }
        reset();
    }

    public void abbrechen()
    {
        GuiController.getStage2().close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        artikelAnlegenChoicebox.getItems().addAll(Type.Buch,Type.CD);
        artikelAnlegenChoicebox.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)-> aktualisieren());
        artikelAnlegenChoicebox.setValue(Type.Buch);
        erscheinungsjahrField.setValue(LocalDate.now());
    }

    private void aktualisieren() {
        switch(artikelAnlegenChoicebox.getValue())
        {
            case Buch:
                interpretField.setVisible(false);
                verlagField.setVisible(true);
                break;
            case CD:
                interpretField.setVisible(true);
                verlagField.setVisible(false);
        }
    }

    private void reset()
    {
        bezeichnungField.setText("");
        preisField.setText("");
        erscheinungsjahrField.setValue(LocalDate.now());
        interpretField.setText("");
        verlagField.setText("");
    }
}
