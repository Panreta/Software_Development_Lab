public class LoggerAdapter implements NewLogger {
    private OldLogger oldLogger;

    public LoggerAdapter(OldLogger oldLogger) {
        this.oldLogger = oldLogger;
    }

    @Override
    public void log(String message) {
        // Translates new interface to old interface
        // Default to level 0 (INFO)
        oldLogger.writeLog(message, 0);
    }
}