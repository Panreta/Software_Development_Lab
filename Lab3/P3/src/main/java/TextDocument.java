public class TextDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening text document: README.txt");
    }

    @Override
    public String getType() {
        return "Text";
    }
}
