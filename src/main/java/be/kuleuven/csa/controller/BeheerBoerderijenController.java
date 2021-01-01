package be.kuleuven.csa.controller;

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

public class BeheerBoerderijenController {

    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnModify;
    @FXML
    private Button btnClose;
    @FXML
    private TableView tblBoerderijen;

    public void initialize() {
        initTable();
        btnAdd.setOnAction(e -> addNewRow());
        btnModify.setOnAction(e -> {
            verifyOneRowSelected();
            modifyCurrentRow();
        });
        btnDelete.setOnAction(e -> {
            verifyOneRowSelected();
            deleteCurrentRow();
        });
        
        btnClose.setOnAction(e -> {
            var stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        });
    }

    private void initTable() {
        tblBoerderijen.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tblBoerderijen.getColumns().clear();

        // TODO verwijderen en "echte data" toevoegen!
        int colIndex = 0;
        for(var colName : new String[]{"Naam", "Voornaam", "Oppervlakte", "Aantal varkens"}) {
            TableColumn<ObservableList<String>, String> col = new TableColumn<>(colName);
            final int finalColIndex = colIndex;
            col.setCellValueFactory(f -> new ReadOnlyObjectWrapper<>(f.getValue().get(finalColIndex)));
            tblBoerderijen.getColumns().add(col);
            colIndex++;
        }

        for(int i = 0; i < 10; i++) {
            tblBoerderijen.getItems().add(FXCollections.observableArrayList("Boer " + i, "Jozef V" + i, i*10 + "", i * 33 + ""));
        }
    }

    private void addNewRow() {
        var resourceName = "addupdateboerderij" + ".fxml";
        try {
            var stage = new Stage();
            var root = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource(resourceName));
            var scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Beheer van ");
            stage.initOwner(ProjectMain.getRootStage());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();

        } catch (Exception e) {
            throw new RuntimeException("Kan beheerscherm " + resourceName + " niet vinden", e);
        }
    }

    private void deleteCurrentRow() {
    }

    private void modifyCurrentRow() {
    }

    public void showAlert(String title, String content) {
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void verifyOneRowSelected() {
        if(tblBoerderijen.getSelectionModel().getSelectedCells().size() == 0) {
            showAlert("Hela!", "Eerst een boer selecteren hé.");
        }
    }
}
