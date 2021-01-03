package be.kuleuven.csa.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BeheerKlantenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> tblBoerderijen;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnModify;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField kvoornaam;

    @FXML
    private TextField krijksregister;

    @FXML
    private TextField kgsmnummer;

    @FXML
    private TextField knaam;

    @FXML
    private TextField kstraat;

    @FXML
    private Button btnRefresh;

    @FXML
    private TextField khuisnummer;

    @FXML
    private TextField kpostcode;

    @FXML
    private TextField kweek;

    @FXML
    private TextField kafgehaald;

    @FXML
    private TextField kcontractid;

    @FXML
    private TextField kemail;

    @FXML
    void initialize() {
        assert tblBoerderijen != null : "fx:id=\"tblBoerderijen\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert btnModify != null : "fx:id=\"btnModify\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert kvoornaam != null : "fx:id=\"kvoornaam\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert krijksregister != null : "fx:id=\"krijksregister\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert kgsmnummer != null : "fx:id=\"kgsmnummer\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert knaam != null : "fx:id=\"knaam\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert kstraat != null : "fx:id=\"kstraat\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert btnRefresh != null : "fx:id=\"btnRefresh\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert khuisnummer != null : "fx:id=\"khuisnummer\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert kpostcode != null : "fx:id=\"kpostcode\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert kweek != null : "fx:id=\"kweek\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert kafgehaald != null : "fx:id=\"kafgehaald\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert kcontractid != null : "fx:id=\"kcontractid\" was not injected: check your FXML file 'beheerklanten.fxml'.";
        assert kemail != null : "fx:id=\"kemail\" was not injected: check your FXML file 'beheerklanten.fxml'.";

    }
}

