import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ConfiguredRoutines {

    protected ArrayList<Routines> routineObj = new ArrayList<Routines>(0);

    public ConfiguredRoutines() {
        Scanner sourceDestinationFile = null;
        try {
            sourceDestinationFile = new Scanner(new File("configRoutines.txt"));
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        while (sourceDestinationFile.hasNext()) {
            String tempMem = "";
            String tempFront = "";
            String tempBack = "";

            // USER PARMS ... mirror into Routines Class
            final String SOURCE = "SOURCE:";
            final String DEST = "DEST:";
            final String FREQ = "FREQ:";
            final String START = "START:";
            final String END = "END:";
            final String HOST = "HOST:";
            final String IP = "IP:";
            final String USER = "USER:";

            final int NUMBER_OF_USER_PARMS = 8;

            Routines routine = new Routines();

            tempMem = sourceDestinationFile.next();
            tempFront = tempFront + tempMem.charAt(0);
            tempBack = tempBack + tempMem.charAt(tempMem.length() - 1);
            for (int i = 0; i < NUMBER_OF_USER_PARMS; i++) {
                tempMem = sourceDestinationFile.next();
                System.out.print(tempMem);
                switch (tempMem) {
                case SOURCE:
                    routine.source = sourceDestinationFile.next();
                    System.out.println(" " + routine.source);
                    break;
                case DEST:
                    routine.dest = sourceDestinationFile.next();
                    System.out.println(" " + routine.dest);
                    break;
                case FREQ:
                    routine.freq = sourceDestinationFile.nextInt();
                    System.out.println(" " + routine.freq);
                    break;
                case START:
                    routine.start = sourceDestinationFile.next();
                    System.out.println(" " + routine.start);
                    break;
                case END:
                    routine.end = sourceDestinationFile.next();
                    System.out.println(" " + routine.end);
                    break;
                case HOST:
                    routine.host = sourceDestinationFile.next();
                    System.out.println(" " + routine.host);
                    break;
                case IP:
                    routine.ip = sourceDestinationFile.next();
                    System.out.println(" " + routine.ip);
                    routine.networked = NetworkJobs.isServerNetworked(routine.ip);
                    break;
                case USER:
                    routine.user = sourceDestinationFile.next();
                    System.out.println(" " + routine.user);
                default:
                    break;

                }
            }
            routineObj.add(routine);
        }
    }

    protected ArrayList<Routines> getRoutine() {
        return routineObj;
    }
}