abstract class DocumentDecorator implements Document {
    protected Document wrappedDocument;

    public DocumentDecorator(Document document) {
        this.wrappedDocument = document;
    }

    @Override
    public void open() {
        wrappedDocument.open();
    }

    @Override
    public String getType() {
        return wrappedDocument.getType();
    }
}