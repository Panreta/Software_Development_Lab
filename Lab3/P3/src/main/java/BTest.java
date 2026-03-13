public class BTest {
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Demo ===\n");

        // Test 1: Basic document
        System.out.println("Test 1: Basic PDF");
        Document pdf = new PDFDocument();
        pdf.open();
        System.out.println("Type: " + pdf.getType());
        System.out.println();

        // Test 2: Encrypted document
        System.out.println("Test 2: Encrypted PDF");
        Document encryptedPdf = new EncryptedDocument(new PDFDocument());
        encryptedPdf.open();
        System.out.println("Type: " + encryptedPdf.getType());
        System.out.println();

        // Test 3: Compressed document
        System.out.println("Test 3: Compressed PDF");
        Document compressedPdf = new CompressedDocument(new PDFDocument());
        compressedPdf.open();
        System.out.println("Type: " + compressedPdf.getType());
        System.out.println();

        // Test 4: Both encrypted and compressed (stacked decorators)
        System.out.println("Test 4: Encrypted + Compressed PDF");
        Document encryptedCompressedPdf = new EncryptedDocument(
                new CompressedDocument(new PDFDocument())
        );
        encryptedCompressedPdf.open();
        System.out.println("Type: " + encryptedCompressedPdf.getType());
        System.out.println();

        // Test 5: Different stacking order
        System.out.println("Test 5: Compressed + Encrypted PDF (different order)");
        Document compressedEncryptedPdf = new CompressedDocument(
                new EncryptedDocument(new PDFDocument())
        );
        compressedEncryptedPdf.open();
        System.out.println("Type: " + compressedEncryptedPdf.getType());
        System.out.println();

        // Test 6: Text document with decorators
        System.out.println("Test 6: Encrypted Text Document");
        Document encryptedText = new EncryptedDocument(new TextDocument());
        encryptedText.open();
        System.out.println("Type: " + encryptedText.getType());
        System.out.println();

        // Test 7: Spreadsheet with both decorators
        System.out.println("Test 7: Compressed + Encrypted Spreadsheet");
        Document decoratedSpreadsheet = new CompressedDocument(
                new EncryptedDocument(new SpreadsheetDocument())
        );
        decoratedSpreadsheet.open();
        System.out.println("Type: " + decoratedSpreadsheet.getType());
    }
}