package client;

import client.view.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import client.model.*;
import client.viewmodel.*;

public class VOIApplication extends Application {

    public void start(Stage stage) throws RemoteException, NotBoundException {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vm = new ViewModelFactory(mf);
        ViewHandler view = new ViewHandler(vm,stage);
        view.openView("logIn");
    }
}
