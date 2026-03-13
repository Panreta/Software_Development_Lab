public abstract class DocumentFactory {
    abstract Document createDocument();

    // Template method using factory method:
    public Document openDocument() { //If it is a pdf, then the open will be the open in pdf
        Document doc = createDocument();
        doc.open();
        return doc;
    }

}
