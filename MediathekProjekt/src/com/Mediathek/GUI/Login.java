package com.Mediathek.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login{
    @FXML
    TextField benutzername;
    @FXML
    PasswordField passwort;
    @FXML
    Label loginmessage;

    public void anmelden(){

        loginmessage.setText("");
        if(GuiController.getmSystem().anmeldenGUI(benutzername.getText(), passwort.getText()))
        {
            GuiController.getStage().close();
            GuiController.softwareScene();
        }else
        {
            loginmessage.setText("Falsche Benutzerdaten!");
        }
    }
}
