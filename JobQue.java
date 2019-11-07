import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class JobQue {

    protected ArrayList<Routines> que = new ArrayList<Routines>(0);
    private int jobs;

    protected JobQue(ConfiguredRoutines routines) {

        jobs = routines.routineObj.size();

        for (int i = 0; i < jobs; i++) {
            if (routines.routineObj.get(i).networked
                    && sync(routines.routineObj.get(i).lastSynced, routines.routineObj.get(i).freq,
                            routines.routineObj.get(i).start, routines.routineObj.get(i).end)) {
                que.add(routines.routineObj.get(i));
            }
        }
    }

    private boolean sync(LocalDateTime last, int freq, String start, String end) {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
        LocalDateTime formateStart = LocalDateTime.parse(start, formatter);
        LocalDateTime formateEnd = LocalDateTime.parse(end, formatter);
        // check if it is between start and end time

        if (current.isAfter(formateStart) && formateEnd.isAfter(current)) {
            // check if it is time to sync in reffrence to frequency
            return current.minusDays(freq).isAfter(last);
        }
        return false;
    }

    protected ArrayList<Routines> getQue() {
        return que;
    }
}
