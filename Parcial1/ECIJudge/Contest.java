import java.time.LocalDateTime;
import java.util.HashMap;

public class Contest {
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private Problem[] problems;
    private HashMap<String, Team> enrolled;
}
