package com.example;

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
    private ListView<?> usernameListView;

    @FXML
    void onClickAboutButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Névjegy");
        alert.setHeaderText(" ");
        alert.setContentText("Ez egy egyszerű JavaFX alkalmazás, amiben CRUD műveleteket lehet végbevinni.\n" +
                "Készítette: Nagy Imre, I/2/E\n" +
                " ");
        alert.showAndWait();
    }

    @FXML
    void onClickAddButton(ActionEvent event) {

    }

    @FXML
    void onClickDeleteButton(ActionEvent event) {

    }

    @FXML
    void onClickModifyButton(ActionEvent event) {

    }

    @FXML
    void onClickSaveButton(ActionEvent event) {

    }

    @FXML
    void onMouseClickedUsernameListView(MouseEvent event) {

    }

}
