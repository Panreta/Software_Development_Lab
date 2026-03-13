class FileObserver implements LogObserver {
    /**
     * Simulates writing the message to a file.
     *
     * @param message the log message to write
     */
    @Override
    public void update(String message) {
        System.out.println("Writing to file: " + message);
    }
}