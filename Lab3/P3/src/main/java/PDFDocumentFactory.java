public class PDFDocumentFactory extends DocumentFactory{
    @Override
    Document createDocument() {
        return new PDFDocument();
    }
}
