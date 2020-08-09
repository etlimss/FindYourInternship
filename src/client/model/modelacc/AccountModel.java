package client.model.modelacc;

import client.model.logmodel.ILogger;
import client.model.logmodel.Logger;
import shared.remoteServer.AccountsRServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Logger;

public class AccountModel implements IAccountsModel {

    private AccountsRServer rmi;
    private Account acc;
    private ILogger log = Logger.getInstance();

    public AccountModel() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry reg = LocateRegistry.getRegistry("Localhost", 1099);
        rmi = (AccountsRServer) reg.lookup("server");
        System.out.println("Connected to Server");
    }

    public boolean accountExists(String username, String password) throws RemoteException {

        try {
            if (rmi.checkIfExists(username, password)) {
                log.setUsername(username);
                System.out.println("username is    " + username);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return rmi.checkIfExists(username, password);

    }

    public boolean accountIsStudent(String username, String password) {
        try {
            return rmi.accountIsStudent(username, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean accountIsCompany(String username, String password) {
        try {
            return rmi.accountIsCompany(username, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkUsername(String username) {

        try {
            return rmi.checkUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createAccount(String username, String password, boolean isStudent) throws RemoteException {

        if (isStudent) {
            acc = new Student(username, password);
        } else if (isCompany) {
            acc = new Company(username, password);
        }
        else {
            acc = new VOS(username, password);
        }
        rmi.addAccount(acc, isStudent, isCompany);

    }
}
