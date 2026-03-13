package P4;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private String genre;
    private double rating; // 0.0 to 5.0
    private int pageCount;
    public Book(String title, String author, int publicationYear,
                String genre, double rating, int pageCount) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.rating = rating;
        this.pageCount = pageCount;
    }
    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
    public int getPageCount() { return pageCount; }
}