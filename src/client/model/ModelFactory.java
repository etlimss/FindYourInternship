package client.model;

import client.model.modelacc.AccountModel;
import client.model.modelacc.IAccountsModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModelFactory {

    private IAccountsModel iaccountsModel;
    private ILogger iloggerModel;

    public IAccountsModel getAccountsModel() throws RemoteException, NotBoundException {
        if(iaccountsModel == null) {
            iaccountsModel = new AccountModel();
        }
        return iaccountsModel;
    }

    public ILogger getLogModel() {
        if(iloggerModel == null)
        {
            iloggerModel= Logger.getInstance();
        }
        return iloggerModel;
    }
}
