import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerADifferentInstance {
    private final DateTimeFormatter formatter;

    // Make constructor PUBLIC (not private)
    public LoggerADifferentInstance() {
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    // Remove the static INSTANCE and getInstance() entirely

    public void log(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[LOG] [" + timestamp + "] " + message);
    }
}