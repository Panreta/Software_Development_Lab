import java.util.ArrayList;
import java.util.List;

class DocumentEditor {
    private List<Command> history = new ArrayList<>();

    public void executeCommand(Command cmd) {
        cmd.execute();
        history.add(cmd);
    }

    public void showHistory() {
        System.out.println("\nCommand History:");
        for (Command cmd : history) {
            System.out.println(" - " + cmd.getDescription());
        }
    }
}