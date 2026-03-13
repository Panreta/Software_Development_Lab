public class SpreadsheetDocumentFactory extends DocumentFactory{
@Override
    Document createDocument() {
    return new PDFDocument();
    }
}
