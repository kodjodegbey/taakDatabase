package be.kuleuven.csa.controller;

import Classes.Boerderij;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUpdateBoerderijController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text titel;

    @FXML
    private Button btnconfirm;

    @FXML
    private Button btnClose;

    @FXML
    private TextField textNaam;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textStraat;

    @FXML
    private TextField textHuisnummer;

    @FXML
    private TextField testPostcode;

    private boolean addModifyEnable;

    private Boerderij selectedBoerderij;

    // neemt de data van BeheerBoerderijen scene
    public void initData(Boerderij boerderij) {
        selectedBoerderij = boerderij;
        textNaam.setText(selectedBoerderij.getNaam());
    }
    @FXML
    void initialize() {
        assert titel != null : "fx:id=\"titel\" was not injected: check your FXML file 'addupdateboerderij.fxml'.";
        assert btnconfirm != null : "fx:id=\"btnconfirm\" was not injected: check your FXML file 'addupdateboerderij.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'addupdateboerderij.fxml'.";
        assert textNaam != null : "fx:id=\"textNaam\" was not injected: check your FXML file 'addupdateboerderij.fxml'.";
        assert textEmail != null : "fx:id=\"textEmail\" was not injected: check your FXML file 'addupdateboerderij.fxml'.";
        assert textStraat != null : "fx:id=\"textStraat\" was not injected: check your FXML file 'addupdateboerderij.fxml'.";
        assert textHuisnummer != null : "fx:id=\"textHuisnummer\" was not injected: check your FXML file 'addupdateboerderij.fxml'.";
        assert testPostcode != null : "fx:id=\"testPostcode\" was not injected: check your FXML file 'addupdateboerderij.fxml'.";


        btnClose.setOnAction(e -> {
            var stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        });
    }

    private void sendDataToDB(){
        //when clicked on confirm
        //send data to db
        //close the scene
    }
}
