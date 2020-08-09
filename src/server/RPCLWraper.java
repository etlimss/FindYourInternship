package server;

import shared.RemotePropertyChangeListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;

public class RPCLWraper implements PropertyChangeListener {

    private RemotePropertyChangeListener remotePropertyChangeListener;

    public void RPCLWrapper(RemotePropertyChangeListener remotePropertyChangeListener) {
        this.remotePropertyChangeListener = remotePropertyChangeListener;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        try {
            remotePropertyChangeListener.propertyChange(evt);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
