package com.example;

import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button modifyButton;

    @FXML
    private Button saveButton;

    @FXML
    private TextField usernameField;

    @FXML
    private ListView<String> usernameListView;

    BooleanProperty editMode = new SimpleBooleanProperty(false);

    @FXML
    void initialize() {
        System.out.println("Initialize fut");

        addButton.disableProperty().bind(editMode);
        modifyButton.disableProperty().bind(editMode.not());
        deleteButton.disableProperty().bind(editMode);
        saveButton.disableProperty().bind(editMode);
    }

    @FXML
    void onClickAboutButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Névjegy");
        alert.setHeaderText("Névjegy");
        alert.setContentText("Ez egy egyszerű JavaFX alkalmazás, amiben CRUD műveleteket lehet végbevinni.\n" +
                "Készítette: Nagy Imre, I/2/E\n" +
                " ");
        alert.showAndWait();
    }


    @FXML
    void onClickAddButton(ActionEvent event) {
        String username = usernameField.getText();
        if(username.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Figyelmeztetés");
            alert.setHeaderText("Üres mező");
            alert.setContentText("Kérem adjon meg egy felhasználónevet.");
            alert.showAndWait();
            return;
        }else{
            usernameListView.getItems().add(username);
            usernameField.clear();
        }
    }

    @FXML
    void onClickDeleteButton(ActionEvent event) {
        int selectedUsernameIndex = usernameListView.getSelectionModel().getSelectedIndex();
        if (selectedUsernameIndex == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Figyelmeztetés");
            alert.setHeaderText("Nincs kiválasztva felhasználónév");
            alert.setContentText("Kérem válasszon egy felhasználónevet a törléshez.");
            alert.showAndWait();
        } else {
            usernameListView.getItems().remove(selectedUsernameIndex);
        }
    }

    @FXML
    void onClickModifyButton(ActionEvent event) {
        String username = usernameField.getText();
        if (username.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Figyelmeztetés");
            alert.setHeaderText("Üres mező");
            alert.setContentText("Kérem adjon meg egy felhasználónevet a módosításhoz.");
            alert.showAndWait();
            return;
        } else {
            int selectedUsernameIndex = usernameListView.getSelectionModel().getSelectedIndex();
            usernameListView.getItems().set(selectedUsernameIndex, username);
            usernameField.clear();
            usernameListView.setDisable(false);
            editMode.set(false);
        }
}

    @FXML
    void onClickSaveButton(ActionEvent event) {

    }

    @FXML
    void onMouseClickedUsernameListView(MouseEvent event) {
        if (event.getClickCount() == 2) {
            String selectedUsername = usernameListView.getSelectionModel().getSelectedItem();
            usernameField.setText(selectedUsername);
            usernameListView.setDisable(true);
            editMode.set(true);
            }
        }
}