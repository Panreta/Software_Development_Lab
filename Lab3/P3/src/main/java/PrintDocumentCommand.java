class PrintDocumentCommand implements Command {
    private Document document;

    public PrintDocumentCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        System.out.println("[Printer] Printing " + document.getType() + "...");
    }

    @Override
    public String getDescription() {
        return "Print Document";
    }
}