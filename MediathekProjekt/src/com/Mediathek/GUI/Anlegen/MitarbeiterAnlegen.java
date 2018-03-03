package com.Mediathek.GUI.Anlegen;

import com.Mediathek.GUI.GuiController;
import com.Mediathek.GUI.Software;
import com.Mediathek.Personen.Mitarbeiter;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.paint.Paint;

public class MitarbeiterAnlegen {
    @FXML
    private JFXTextField nameField;
    @FXML
    private JFXTextField vornameField;
    @FXML
    private JFXTextField ortField;
    @FXML
    private JFXTextField plzField;
    @FXML
    private JFXTextField strasseField;
    @FXML
    private JFXTextField hausnummerField;
    @FXML
    private JFXTextField benutzernameField;
    @FXML
    private JFXPasswordField passwortField;


    public void fertigstellen()
    {
        String name;
        String vorname;
        String ort;
        int plz=0;
        String strasse;
        String hausnummer;
        String benutzername;
        String passwort;
        boolean valid = true;

        name = nameField.getText();
        if(name.equals(""))
        {
            nameField.setUnFocusColor(Paint.valueOf("FF0000"));
            valid=false;
        }else
        {
            nameField.setUnFocusColor(Paint.valueOf("6f6e6e"));
        }
        vorname = vornameField.getText();
        if(vorname.equals(""))
        {
            vornameField.setUnFocusColor(Paint.valueOf("FF0000"));
            valid=false;
        }else
        {
            vornameField.setUnFocusColor(Paint.valueOf("6f6e6e"));
        }
        ort = ortField.getText();
        if(ort.equals(""))
        {
            ortField.setUnFocusColor(Paint.valueOf("FF0000"));
            valid=false;
        }else
        {
            ortField.setUnFocusColor(Paint.valueOf("6f6e6e"));
        }

        if(plzField.getText().matches("[0-9][0-9][0-9][0-9][0-9]")&& !(plzField.getText().contains(",")))
        {
            System.out.println(true);
            plz = Integer.parseInt(plzField.getText());
            plzField.setUnFocusColor(Paint.valueOf("6f6e6e"));
        }else
        {
            plzField.setUnFocusColor(Paint.valueOf("FF0000"));
            valid=false;
        }

        strasse= strasseField.getText();
        if(strasse.equals(""))
        {
            strasseField.setUnFocusColor(Paint.valueOf("FF0000"));
            valid=false;
        }else
        {
            strasseField.setUnFocusColor(Paint.valueOf("6f6e6e"));
        }

        hausnummer = hausnummerField.getText();
        if(hausnummer.equals(""))
        {
            hausnummerField.setUnFocusColor(Paint.valueOf("FF0000"));
            valid=false;
        }else
        {
            hausnummerField.setUnFocusColor(Paint.valueOf("6f6e6e"));
        }

        benutzername=benutzernameField.getText();
        if(benutzername.equals("")||!benutzername.matches("[A-Za-z]*"))
        {
            benutzernameField.setUnFocusColor(Paint.valueOf("FF0000"));
            valid=false;
        }else
        {
            benutzernameField.setUnFocusColor(Paint.valueOf("6f6e6e"));
        }

        passwort= passwortField.getText();
        if(benutzername.equals("")||!benutzername.matches("[A-Za-z]*"))
        {
            passwortField.setUnFocusColor(Paint.valueOf("FF0000"));
            valid=false;
        }else
        {
            passwortField.setUnFocusColor(Paint.valueOf("6f6e6e"));
        }

        if(valid)
        {
            Mitarbeiter tmp = new Mitarbeiter(name,vorname,ort,plz,strasse,hausnummer,benutzername,passwort);
            GuiController.getmSystem().getMitarbeiterListe().add(tmp);
            Software.dataMitarbeiter.add(tmp);
            GuiController.getStage5().close();
        }
    }

    public void abbrechen()
    {
        GuiController.getStage3().close();
    }
}
