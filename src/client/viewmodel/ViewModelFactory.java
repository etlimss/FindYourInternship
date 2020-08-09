package client.viewmodel;

import client.model.*;

import client.viewmodel.login.LoginViewModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        try {
            loginViewModel= new LoginViewModel(modelFactory.getAccountsModel());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public  LoginViewModel getLoginViewModel() {

        return loginViewModel;
    }
}
