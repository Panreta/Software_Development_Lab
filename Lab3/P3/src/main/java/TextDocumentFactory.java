public class TextDocumentFactory extends DocumentFactory{
    @Override
    Document createDocument() {
        return new TextDocument();
    }
}
