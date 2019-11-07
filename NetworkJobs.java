import java.io.*;
import java.net.*;

public class NetworkJobs {

    public NetworkJobs() {

    }

    protected static boolean isServerNetworked(String IP) {
        boolean isIt = false;

        try {
            InetAddress server = InetAddress.getByName(IP);
            System.out.println("Sending Ping Request to " + IP);

            if (server.isReachable(5000)) {
                System.out.println(IP + " is networked");
                isIt = true;
            } else {
                System.out.println(IP + " not reachable");
            }
        } catch (IOException e) {
            System.exit(1);
        }
        return isIt;
    }
}