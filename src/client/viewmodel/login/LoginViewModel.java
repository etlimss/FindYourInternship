package client.viewmodel.login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import client.model.modelacc.IAccountsModel;

import java.rmi.RemoteException;

public class LoginViewModel {

    private StringProperty username;
    private StringProperty password;

    private IAccountsModel accountsModel;

    public LoginViewModel(IAccountsModel accountsModel) {
        this.accountsModel = accountsModel;

        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public StringProperty getPasswordProperty() {
        return password;
    }



    public boolean checkIfExists() {
        try {
            if (accountsModel.accountExists(username.getValue(), password.getValue())) {
                System.out.println(accountsModel.accountExists(username.getValue(), password.getValue()));
                return true;
            }
            else {
                return false;
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }
}
