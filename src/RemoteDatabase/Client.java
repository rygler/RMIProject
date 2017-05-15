package RemoteDatabase;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            // Set the standard RMI security manager
            System.setSecurityManager(new SecurityManager());

            // Get remote database object
            String name = "rmi://whatever:1234/database";
            RemoteDatabase db = (RemoteDatabase) Naming.lookup(name);

            // Read command-line argument and access database
            int value, rounds = Integer.parseInt(args[0]);
            for (int i = 0; i < rounds; i++) {
                value = db.read();
                System.out.println("read: " + value);
                db.write(value + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
