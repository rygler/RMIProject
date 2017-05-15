package RemoteDatabase;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteDatabaseServer extends UnicastRemoteObject implements RemoteDatabase {
    protected int data = 0; // The "database"

    @Override
    public int read() throws RemoteException {
        return data;
    }

    @Override
    public void write(int value) throws RemoteException {
        data = value;
        System.out.println("new value is: " + data);
    }

    // Constructor required because of the throw clause
    public RemoteDatabaseServer() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try{
            // create a remote database server object
            RemoteDatabaseServer server = new RemoteDatabaseServer();

            // register name and start serving
            String name = "rmi://whatever:1234/database";
            Naming.bind(name, server);
            System.out.println(name + " is running");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
