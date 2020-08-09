package client.model.modelacc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAccountsModel extends Remote {
    boolean accountExists(String username,String password) throws RemoteException;
    boolean checkUsername(String username) throws RemoteException;
    void createAccount(String username,String password,boolean isManager) throws RemoteException;
    boolean accountIsStudent(String value, String value1) throws RemoteException;
    boolean accountIsCompany(String value, String value1) throws RemoteException;
}

