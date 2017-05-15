package RemoteDatabase;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Raphael on 5/12/2017.
 */
public interface RemoteDatabase extends Remote {
    public int read() throws RemoteException;
    public void write(int value) throws RemoteException;
}
