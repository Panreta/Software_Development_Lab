public class PDFDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening PDF with rendering engine: Report.pdf");
    }

    @Override
    public String getType() {
        return "pdf";
    }
}

