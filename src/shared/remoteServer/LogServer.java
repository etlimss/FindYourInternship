package shared.remoteServer;

import shared.RemotePropertyChangeListener;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LogServer extends Remote {

    void logToDatabase(String log) throws RemoteException;
    void wrappLogListener(String names, RemotePropertyChangeListener listener) throws RemoteException;
}
