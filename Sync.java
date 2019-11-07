import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Sync {

    Scanner sourceDestinationFile = null;

    public Sync() {

    }

    // Need to make host abstract
    protected void sync(ArrayList<Routines> quedRoutines) {

        for (int i = 0; i < quedRoutines.size(); i++) {
            String ip = quedRoutines.get(i).ip;
            String user = quedRoutines.get(i).user;
            String dest = quedRoutines.get(i).dest;
            String source = quedRoutines.get(i).source;

            String command = "rsync -ah --progress ssh " + source + " " + user + "@" + ip + ":" + dest;

            Process proc = null;
            try {
                proc = Runtime.getRuntime().exec(command);

                // Read the output

                BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

                String line = "";
                while ((line = reader.readLine()) != null) {
                    System.out.print(line + "\n");
                }
            } catch (IOException e) {
                System.exit(1);
            }

            try {
                proc.waitFor();
            } catch (InterruptedException e) {
                System.exit(1);
            }

            // update routines lastSynced time
            quedRoutines.get(i).lastSynced = LocalDateTime.now();
        }
    }
}