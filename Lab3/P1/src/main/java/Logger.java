import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    // Eager initialization with INSTANCE
    private static final Logger Instance = new Logger(); // INSTANCE: holding my object here
    // must be static since getInstance is static. And getInstance is static since otherwise you can't implement that quick

    private final DateTimeFormatter formatter;

    private final List<LogObserver> observers;


    private Logger() {
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.observers = new ArrayList<>();  // ADD THIS - Initialize observer list
    }

    public static Logger getInstance() {
        return Instance;
    }

    public void attach(LogObserver observer) {
        observers.add(observer);
    }

    public void log(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[LOG] [" + timestamp + "] " + message);

        notifyObservers(message);

    }

    private void notifyObservers(String message) {
        for (LogObserver observer : observers) {
            observer.update(message);
        }
    }


}
