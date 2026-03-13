class ConsoleObserver implements LogObserver {
    /**
     * Displays the message to the console dashboard.
     *
     * @param message the log message to display
     */
    @Override
    public void update(String message) {
        System.out.println("Console Dashboard: " + message);
    }
}