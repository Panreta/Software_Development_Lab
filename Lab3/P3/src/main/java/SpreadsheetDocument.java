public class SpreadsheetDocument implements Document{
    @Override
    public void open() {
        System.out.println("Loading spreadsheet with formulas:\n" +
                "Data.xlsx");
    }

    @Override
    public String getType() {
        return "xlsx";
    }
}


