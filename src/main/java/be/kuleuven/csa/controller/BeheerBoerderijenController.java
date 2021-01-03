package be.kuleuven.csa.controller;

import Classes.Boerderij;
import JDBI.dBJDBI;
import be.kuleuven.csa.ProjectMain;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BeheerBoerderijenController {

    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnRefresh;
    @FXML
    private Button btnModify;
    @FXML
    private Button btnClose;
    @FXML
    private TextField bnaam;

    @FXML
    private TextField bstraat;

    @FXML
    private TextField bnummer;

    @FXML
    private TextField bpostcode;

    @FXML
    private TextField bemail;
    @FXML
    private TableView tblBoerderijen;

    private ArrayList<Boerderij> boerderijen;

    //dBJDBI db;
    public void initialize() {
        boerderijen = new ArrayList<>();
        initTable();
        btnAdd.setOnAction(e -> {
            addNewRow();
            initTable();
        });

        btnModify.setOnAction(e -> {
            if (verifyOneRowSelected()) {
                modifyCurrentRow();
                initTable();
            }
        });
        btnDelete.setOnAction(e -> {
            if (verifyOneRowSelected()) {
                deleteCurrentRow();
                initTable();
            }
        });
        
        btnClose.setOnAction(e -> {
            var stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        });

        btnRefresh.setOnAction(e -> {
            initTable();
        });


        tblBoerderijen.setOnMouseClicked(e -> {
                try {
                    Object selectie = tblBoerderijen.getSelectionModel().getSelectedItems().get(0);

                    String selNaam = selectie.toString().split(",")[1].substring(1);
                    bnaam.setText(selNaam);

                    String selStraat = selectie.toString().split(",")[2].substring(1);
                    bstraat.setText(selStraat);

                    String selNummer = selectie.toString().split(",")[3].substring(1);
                    bnummer.setText(selNummer);

                    String selPostcode = selectie.toString().split(",")[4].substring(1);
                    bpostcode.setText(selPostcode);

                    String selEmail = selectie.toString().split(",")[5].substring(1);
                    // Door een onbekende reden wordt een ']' getoond op het einde van de string
                    // in de textField, vandaar dat de laatste character verwijdert wordt
                    StringBuilder sb = new StringBuilder(selEmail);
                    sb.deleteCharAt(selEmail.length() - 1);
                    selEmail = sb.toString();
                    bemail.setText(selEmail);
                } catch(Exception f) {
                    //verifyOneRowSelected();
                }
        });

    }

    private void initTable() {
        boerderijen = (ArrayList<Boerderij>) ProjectMainController.db.getBoerderijen();

        tblBoerderijen.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tblBoerderijen.getColumns().clear();
        tblBoerderijen.getItems().clear();

        int colIndex = 0;
        for(var colName : new String[]{"id", "naam", "straat", "nummer", "postcode", "email"}) {
            TableColumn<ObservableList<String>, String> col = new TableColumn<>(colName);
            final int finalColIndex = colIndex;
            col.setCellValueFactory(f -> new ReadOnlyObjectWrapper<>(f.getValue().get(finalColIndex)));
            tblBoerderijen.getColumns().add(col);
            colIndex++;
        }
        for(int i = 0; i < boerderijen.size(); i++) {
            tblBoerderijen.getItems().add(FXCollections.observableArrayList(
                    String.valueOf(boerderijen.get(i).getBoerderij_id()),
                    boerderijen.get(i).getNaam(),
                    boerderijen.get(i).getStraat(),
                    String.valueOf(boerderijen.get(i).getNummer()),
                    String.valueOf(boerderijen.get(i).getPostcode()),
                    boerderijen.get(i).getEmails()));
        }
    }

    private void addNewRow() {

        try {
            Boerderij nieuwBoerderij = new Boerderij(0, bnaam.getText(), bstraat.getText(), Integer.valueOf(bnummer.getText()),
                    Integer.valueOf(bpostcode.getText()), bemail.getText());
            ProjectMainController.db.voegBoerderijToe(nieuwBoerderij);
        } catch(Exception e) {
            showAlert("null waarden", "vergeet niet de noodzakelijke waarden in te vullen aub");
        }

    }

    private void deleteCurrentRow() {
        Object selectedItems = tblBoerderijen.getSelectionModel().getSelectedItems().get(0);
        String boerID = selectedItems.toString().split(",")[0].substring(1);
        String boerNaam = selectedItems.toString().split(",")[1].substring(1);
        String boerStraat = selectedItems.toString().split(",")[2].substring(1);
        String boerNummer = selectedItems.toString().split(",")[3].substring(1);
        String boerPostcode = selectedItems.toString().split(",")[4].substring(1);
        String boerEmail = selectedItems.toString().split(",")[5].substring(1);
        Boerderij verwijderdeBoerderij = new Boerderij(Integer.valueOf(boerID), boerNaam, boerStraat, Integer.valueOf(boerNummer),
                Integer.valueOf(boerPostcode), boerEmail);

        ProjectMainController.db.verwijderBoerderijTransaction(verwijderdeBoerderij);
    }

    private void modifyCurrentRow() {
        try {
            Object selectedItems = tblBoerderijen.getSelectionModel().getSelectedItems().get(0);
            String boerID = selectedItems.toString().split(",")[0].substring(1);
            Boerderij geUpdateBoerderij = new Boerderij(Integer.valueOf(boerID), bnaam.getText(), bstraat.getText(), Integer.valueOf(bnummer.getText()),
                    Integer.valueOf(bpostcode.getText()), bemail.getText());
            ProjectMainController.db.upDate_boerdrij(geUpdateBoerderij);
        } catch(Exception e) {
            showAlert("null waarden", "vergeet niet de noodzakelijke waarden in te vullen aub");
        }
    }

    public void showAlert(String title, String content) {
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean verifyOneRowSelected() {
        if(tblBoerderijen.getSelectionModel().getSelectedCells().size() == 0) {
            showAlert("Hela!", "Selecteer een boer aub!");
            return false;
        } else return true;
    }
}
