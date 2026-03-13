class OpenDocumentCommand implements Command {
    private Document document;

    public OpenDocumentCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.open();
    }

    @Override
    public String getDescription() {
        return "Open Document";
    }
}