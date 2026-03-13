class CompressedDocument extends DocumentDecorator {
    public CompressedDocument(Document document) {
        super(document);
    }

    @Override
    public void open() {
        System.out.println("[Package] Decompressing...");
        wrappedDocument.open();
    }

    @Override
    public String getType() {
        return "Compressed " + wrappedDocument.getType();
    }
}