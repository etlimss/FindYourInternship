package client.view.login;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import client.view.ViewHandler;
import client.viewmodel.app.AppViewModel;
import client.viewmodel.login.LoginViewModel;

public class LoginController {

    private ViewHandler viewHandler;
    private LoginViewModel loginViewModel;

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passTextField;

    @FXML
    Button loginButton;

    public void init(LoginViewModel viewModel, ViewHandler viewHandler) {
        loginViewModel = viewModel;
        this.viewHandler = viewHandler;

        loginViewModel.getUsernameProperty().bindBidirectional(usernameTextField.textProperty());
        loginViewModel.getPasswordProperty().bindBidirectional(passTextField.textProperty());

    }

    public void buttonPressed(KeyEvent e) {

        if (e.getCode() == KeyCode.ENTER) {
            onLogInButton();
        }
    }

    public void onLogInButton() {

        Stage stage = (Stage) passTextField.getScene().getWindow();

        if (loginViewModel.checkIfExists())
        {
            viewHandler.closeView(stage);
            if (loginViewModel.isStudent()) {

                viewHandler.openView("student");

            } else
                viewHandler.openView("company");

        } else {

            passTextField.textProperty().setValue("");
            usernameTextField.textProperty().setValue("");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Log in error");
            alert.setContentText("Invalid user name or password");
            alert.showAndWait();
        }
    }
}
