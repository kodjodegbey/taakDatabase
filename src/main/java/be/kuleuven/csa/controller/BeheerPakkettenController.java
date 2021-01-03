package be.kuleuven.csa.controller;

import Classes.Boerderij;
import Classes.Pakket;
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

public class BeheerPakkettenController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnModify;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField pkinderen;

    @FXML
    private TextField pvolwassenen;

    @FXML
    private TextField pgrootte;

    @FXML
    private Button btnRefresh;


    public TableView tblPakketten;
    private ArrayList<Pakket> pakketten;
    //dBJDBI db;

    public void initialize() {
        //db = new dBJDBI("jdbc:sqlite:CSA2.db");
        pakketten = new ArrayList<>();
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
    }

    private void initTable() {
        pakketten = (ArrayList<Pakket>) ProjectMainController.db.getPakketen();

        tblPakketten.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tblPakketten.getColumns().clear();
        tblPakketten.getItems().clear();

        int colIndex = 0;
        for(var colName : new String[]{"id", "kinderen", "volwassenen", "grootte"}) {
            TableColumn<ObservableList<String>, String> col = new TableColumn<>(colName);
            final int finalColIndex = colIndex;
            col.setCellValueFactory(f -> new ReadOnlyObjectWrapper<>(f.getValue().get(finalColIndex)));
            tblPakketten.getColumns().add(col);
            colIndex++;
        }
        for(int i = 0; i < pakketten.size(); i++) {
            tblPakketten.getItems().add(FXCollections.observableArrayList(
                    String.valueOf(pakketten.get(i).getPakket_id()),
                    String.valueOf(pakketten.get(i).getKinderen()),
                    String.valueOf(pakketten.get(i).getVolwassenen()),
                    pakketten.get(i).getGrootte()));
        }
    }

    private void addNewRow() {
        try {
            ProjectMainController.db.voegPakketToe(pgrootte.getText());
        } catch(Exception e) {
            showAlert("null waarden", "vergeet niet de pakketgrootte in te vullen aub");
        }
    }

    private void modifyCurrentRow() {
        try {
            Object selectedItems = tblPakketten.getSelectionModel().getSelectedItems().get(0);
            String pakketID = selectedItems.toString().split(",")[0].substring(1);
            ProjectMainController.db.upDataPakket(Integer.valueOf(pakketID), pgrootte.getText());
        } catch(Exception e) {
            showAlert("onjuiste waarden", "vul een correcte grootte in");
        }
    }

    private void deleteCurrentRow() {
        Object selectedItems = tblPakketten.getSelectionModel().getSelectedItems().get(0);
        String pakketID = selectedItems.toString().split(",")[0].substring(1);
        ProjectMainController.db.verwijderPakket(Integer.valueOf(pakketID));
    }

    public void showAlert(String title, String content) {
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean verifyOneRowSelected() {
        if(tblPakketten.getSelectionModel().getSelectedCells().size() == 0) {
            showAlert("Hela!", "Selecteer een pakket aub!");
            return false;
        } else return true;
    }
}
