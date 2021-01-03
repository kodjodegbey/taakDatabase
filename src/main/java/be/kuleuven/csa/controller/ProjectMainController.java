package be.kuleuven.csa.controller;

import be.kuleuven.csa.ProjectMain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import JDBI.dBJDBI;
import java.io.IOException;

public class ProjectMainController {

    @FXML
    private Button btnBoerderijen;
    @FXML
    private Button btnTips;
    @FXML
    private Button btnKlanten;
    @FXML
    private Button btnPakketten;
    @FXML
    private Button btnAanbiedingen;
    @FXML
    private Button btnInschrijvingen;
    @FXML
    private Button btnProducten;

    // aangezien we eenzelfde database gebruiken, is het logisch als we dit een keer instantieren
    // en een static final maken zodat we het overal kunnen gebruiken
    public static final dBJDBI db = new dBJDBI("jdbc:sqlite:CSA2.db");

    public void initialize() {
        btnBoerderijen.setOnAction(e -> showBeheerScherm("boerderijen"));
        btnTips.setOnAction(e -> showBeheerScherm("tips"));
        btnKlanten.setOnAction(e -> showBeheerScherm("klanten"));
        btnInschrijvingen.setOnAction(e -> showBeheerScherm("inschrijvingen"));
        btnProducten.setOnAction(e -> showBeheerScherm("producten"));
        btnPakketten.setOnAction(e -> showBeheerScherm("pakketten"));
        btnAanbiedingen.setOnAction(e -> showBeheerScherm("aanbiedingen"));
    }

    private void showBeheerScherm(String id) {
        var resourceName = "beheer" + id + ".fxml";
        try {
            var stage = new Stage();
            var root = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource(resourceName));
            var scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Beheer van " + id);
            stage.initOwner(ProjectMain.getRootStage());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();

        } catch (Exception e) {
            throw new RuntimeException("Kan beheerscherm " + resourceName + " niet vinden", e);
        }
    }
}
