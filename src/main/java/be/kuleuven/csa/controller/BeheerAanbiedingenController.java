package be.kuleuven.csa.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Classes.Boerderij;
import Classes.BoerderijAanbod;
import Classes.Pakket;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class BeheerAanbiedingenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView tblAanbiedingen;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnModify;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField txtnaam;

    @FXML
    private TextField txtvolwassenen;

    @FXML
    private TextField txtkinderen;

    @FXML
    private TextField txtprijs;

    @FXML
    private Button btnRefresh;

    @FXML
    private ChoiceBox<String> cgrootte;

    @FXML
    private ChoiceBox<String> cboerderijid;

    @FXML
    private ChoiceBox<String> cpakketid;

    private ArrayList<BoerderijAanbod> aanbiedingen;
    private ArrayList<Boerderij> lijstBoerderijen;
    private ArrayList<Pakket> lijstPakketten;

    public void initialize() {
        aanbiedingen = new ArrayList<>();

        keuzeBoerderij();
        keuzePakket();
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
        });*/
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

    }

    private void initTable() {
        aanbiedingen = (ArrayList<BoerderijAanbod>) ProjectMainController.db.getBoerderijAanbod();

        tblAanbiedingen.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tblAanbiedingen.getColumns().clear();
        tblAanbiedingen.getItems().clear();

        int colIndex = 0;
        for(var colName : new String[]{"grootte", "naam", "volwassenen", "kinderen", "prijs", "pakket_id", "boerderij_id"}) {
            TableColumn<ObservableList<String>, String> col = new TableColumn<>(colName);
            final int finalColIndex = colIndex;
            col.setCellValueFactory(f -> new ReadOnlyObjectWrapper<>(f.getValue().get(finalColIndex)));
            tblAanbiedingen.getColumns().add(col);
            colIndex++;
        }
        for(int i = 0; i < aanbiedingen.size(); i++) {
            tblAanbiedingen.getItems().add(FXCollections.observableArrayList(
                    aanbiedingen.get(i).getGrootte(),
                    aanbiedingen.get(i).getNaam(),
                    String.valueOf(aanbiedingen.get(i).getVolwassenen()),
                    String.valueOf(aanbiedingen.get(i).getKinderen()),
                    String.valueOf(aanbiedingen.get(i).getPrijs()),
                    String.valueOf(aanbiedingen.get(i).getPakket_id()),
                    String.valueOf(aanbiedingen.get(i).getBoerderij_id())));
        }
    }
    private void keuzeBoerderij(){
        lijstBoerderijen = new ArrayList(ProjectMainController.db.getBoerderijen());
        ObservableList list = FXCollections.observableArrayList();
        list.removeAll();
        for (Boerderij boer : lijstBoerderijen) {
            list.add(boer.getBoerderij_id());
        }

        cboerderijid.getItems().addAll(list);
    }

    private void keuzePakket(){
        lijstPakketten = new ArrayList(ProjectMainController.db.getPakketen());
        ObservableList list = FXCollections.observableArrayList();
        list.removeAll();
        for (Pakket pakket : lijstPakketten) {
            list.add(pakket.getPakket_id());
        }

        cpakketid.getItems().addAll(list);
    }

    private void addNewRow() {
        System.out.println(String.valueOf(cboerderijid.getValue()));
        System.out.println(String.valueOf(cboerderijid.getValue()));
        System.out.println(txtprijs.getText());

        String strboer = String.valueOf(cboerderijid.getValue());
        String strpak = String.valueOf(cpakketid.getValue());
        try {
            //showAlert("foutieve waarden", cpakketid.getValue() + cboerderijid.getValue() + txtprijs.getText());
            ProjectMainController.db.maakAanbod(Integer.valueOf(strpak),
                    Integer.valueOf(strboer), Integer.valueOf(txtprijs.getText()));
        } catch(Exception e) {
            showAlert("foutieve waarden", "vergeet niet de noodzakelijke waarden in te vullen aub\n en geen kommagetallen aub ;)");
        }

    }

    public void showAlert(String title, String content) {
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
/*
    private void modifyCurrentRow() {
        try {
            Object selectedItems = tblAanbiedingen.getSelectionModel().getSelectedItems().get(0);
            String aanbiedingID = selectedItems.toString().split(",")[0].substring(1);
            Boerderij geUpdateBoerderij = new Boerderij(Integer.valueOf(boerID), bnaam.getText(), bstraat.getText(), Integer.valueOf(bnummer.getText()),
                    Integer.valueOf(bpostcode.getText()), bemail.getText());
            ProjectMainController.db.upDate_boerdrij(geUpdateBoerderij);
        } catch(Exception e) {
            showAlert("null waarden", "vergeet niet de noodzakelijke waarden in te vullen aub");
        }
    }*/

    private void deleteCurrentRow() {
        Object selectedItems = tblAanbiedingen.getSelectionModel().getSelectedItems().get(0);
        String boerID = selectedItems.toString().split(",")[5].substring(1);
        String pakketID = selectedItems.toString().split(",")[6].substring(1);

        showAlert("pakketid", pakketID);
        StringBuilder sb = new StringBuilder(pakketID);
        sb.deleteCharAt(pakketID.length() - 1);
        pakketID = sb.toString();
        ProjectMainController.db.verwijderAanbod(Integer.valueOf(boerID), Integer.valueOf(pakketID));
    }

    private boolean verifyOneRowSelected() {
        if(tblAanbiedingen.getSelectionModel().getSelectedCells().size() == 0) {
            showAlert("Hela!", "Selecteer een aanbieding aub!");
            return false;
        } else return true;
    }
}