package be.kuleuven.csa.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Classes.Boerderij;
import Classes.Product;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class BeheerProductenController {
    @FXML
    private TextField txtnaam;

    @FXML
    private TextField txtinbegrepen;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView tblProducten;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnModify;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnRefresh;

    private ArrayList<Product> producten;
    @FXML
    void initialize() {
        producten = new ArrayList<>();
        initTable();

        btnAdd.setOnAction(e -> {
            addNewRow();
            initTable();
        });
/*
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
*/
        btnClose.setOnAction(e -> {
            var stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        });

        btnRefresh.setOnAction(e -> {
            initTable();
        });


        tblProducten.setOnMouseClicked(e -> {
            try {
                Object selectie = tblProducten.getSelectionModel().getSelectedItems().get(0);

                String selNaam = selectie.toString().split(",")[0].substring(1);
                txtnaam.setText(selNaam);

                String selInbegrepen = selectie.toString().split(",")[1].substring(1);
                txtinbegrepen.setText(selInbegrepen);

                // Door een onbekende reden wordt een ']' getoond op het einde van de string
                // in de textField, vandaar dat de laatste character verwijdert wordt
                StringBuilder sb = new StringBuilder(selInbegrepen);
                sb.deleteCharAt(selInbegrepen.length() - 1);
                selInbegrepen = sb.toString();
                txtinbegrepen.setText(selInbegrepen);
            } catch(Exception f) {
                //verifyOneRowSelected();
            }
        });

    }

    private void initTable() {
        producten = (ArrayList<Product>) ProjectMainController.db.getProducten();

        tblProducten.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tblProducten.getColumns().clear();
        tblProducten.getItems().clear();

        int colIndex = 0;
        for(var colName : new String[]{"productnaam", "inbegrepen?"}) {
            TableColumn<ObservableList<String>, String> col = new TableColumn<>(colName);
            final int finalColIndex = colIndex;
            col.setCellValueFactory(f -> new ReadOnlyObjectWrapper<>(f.getValue().get(finalColIndex)));
            tblProducten.getColumns().add(col);
            colIndex++;
        }
        for(int i = 0; i < producten.size(); i++) {
            String inbegrepen;
            if (producten.get(i).isInbegrepen()) inbegrepen = "ja"; else inbegrepen = "nee";
            tblProducten.getItems().add(FXCollections.observableArrayList(
                    producten.get(i).getNaam(),
                    inbegrepen
                    ));
        }
    }

    private void addNewRow() {

        try {
            boolean inb = false;
            if (txtinbegrepen.getText() == "ja") inb = true;
            else if (txtinbegrepen.getText() == "nee") inb = false;
            ProjectMainController.db.voegProductToe(txtnaam.getText(), inb);
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
        if(tblProducten.getSelectionModel().getSelectedCells().size() == 0) {
            showAlert("Hela!", "Selecteer een boer aub!");
            return false;
        } else return true;
    }
}
