interface LogObserver {
    /**
     * Called when a new log message is created.
     *
     * @param message the log message to process
     */
    void update(String message);
}