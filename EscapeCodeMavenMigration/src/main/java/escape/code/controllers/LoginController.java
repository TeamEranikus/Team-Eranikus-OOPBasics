package escape.code.controllers;

import escape.code.core.Game;
import escape.code.models.User;
import escape.code.services.userservices.UserService;
import escape.code.services.userservices.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Label messageLabel;

    private static UserService userService;

    private User user;

    static {
        userService = new UserServiceImpl();
    }

    public void login(ActionEvent actionEvent) {
        String userName = this.usernameField.getText();
        String password = this.passwordField.getText();
        try {
            this.checkForEmptyString(userName, password);
            this.user = userService.getUser(userName, password);
            Game.setUser(this.user);
            Game.loadMainMenu();
        } catch (IllegalArgumentException exception) {
            this.messageLabel.setText(exception.getMessage());
        }
    }


    public void register(ActionEvent actionEvent) {
        String userName = this.usernameField.getText();
        String password = this.passwordField.getText();
        try {
            this.checkForEmptyString(userName, password);
            userService.createUser(userName, password);
            this.login(actionEvent);
        } catch (IllegalArgumentException ex) {
            this.messageLabel.setText(ex.getMessage());
        }
    }

    private void checkForEmptyString(String userName, String password) {
        if (userName.trim().length() == 0) {
            throw new IllegalArgumentException("Username cannot be empty!");
        }

        if (password.trim().length() == 0) {
            throw new IllegalArgumentException("Password cannot be empty!");
        }
    }
}

