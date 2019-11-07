import java.time.*;

public class Routines {

    protected String source;
    protected String dest;
    protected int freq; // in days
    protected String start; // yyyy-mm-dd-hh:mm
    protected String end; // yyyy-mm-dd-hh:mm
    protected String host;
    protected String ip;
    protected String user;
    protected boolean networked;
    protected LocalDateTime lastSynced; // yyyy-mm-dd-hh:mm

    public Routines() {
        lastSynced = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
    }
}
