public class LegacyBuildingMonitor implements OldLogger {
    @Override
    public void writeLog(String message, int level) {
        String levelName;
        switch (level) {
            case 0: levelName = "INFO"; break;
            case 1: levelName = "WARNING"; break;
            case 2: levelName = "ERROR"; break;
            default: levelName = "UNKNOWN"; break;
        }
        System.out.println("[LEGACY] [" + levelName + "] " + message);
    }
}