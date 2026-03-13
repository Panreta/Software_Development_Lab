class SaveDocumentCommand implements Command {
    private Document document;

    public SaveDocumentCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        System.out.println("[Disk] Saving " + document.getType() + "...");
    }

    @Override
    public String getDescription() {
        return "Save Document";
    }
}