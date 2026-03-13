public class EncryptedDocument extends DocumentDecorator {
    public EncryptedDocument(Document document) {
        super(document);
    }

    @Override
    public void open() {
        System.out.println("[Locker] Decrypting...");
        wrappedDocument.open();
    }

    @Override
    public String getType() {
        return "Encrypted " + wrappedDocument.getType();
    }
}