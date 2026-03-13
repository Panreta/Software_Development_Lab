public class CTest {
    public static void main(String[] args) {
        System.out.println("=== Command Pattern Demo ===\n");

        // Create document
        Document doc = new TextDocument();

        // Create commands
        Command open = new OpenDocumentCommand(doc);
        Command save = new SaveDocumentCommand(doc);
        Command print = new PrintDocumentCommand(doc);

        // Execute commands through invoker
        DocumentEditor editor = new DocumentEditor();
        editor.executeCommand(open);
        editor.executeCommand(save);
        editor.executeCommand(print);

        // Show command history
        editor.showHistory();
    }
}