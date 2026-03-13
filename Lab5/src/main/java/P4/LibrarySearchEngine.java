package P4;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.time.Year;

public class LibrarySearchEngine {

    /**
     * Filters books based on a single predicate criteria.
     * Uses functional programming with Streams to filter books.
     *
     * @param books List of Book objects to search
     * @param criteria Predicate to test each book against
     * @return List of books that match the criteria
     */
    public List<Book> searchBooks(List<Book> books, Predicate<Book> criteria) {
        return books.stream()
                .filter(criteria)
                .collect(Collectors.toList());
    }

    /**
     * Filters books based on multiple predicate criteria using AND logic.
     * All predicates must be satisfied for a book to be included.
     * Uses Predicate.and() to combine multiple predicates.
     *
     * @param books List of Book objects to search
     * @param criteria Variable number of Predicate objects (varargs)
     * @return List of books that match ALL provided criteria
     */
    @SafeVarargs
    public final List<Book> advancedSearch(List<Book> books, Predicate<Book>... criteria) {
        if (criteria.length == 0) {
            return new ArrayList<>(books);
        }

        // Combine all predicates using AND logic
        Predicate<Book> combinedPredicate = Arrays.stream(criteria)
                .reduce(Predicate::and)
                .orElse(book -> true);

        return books.stream()
                .filter(combinedPredicate)
                .collect(Collectors.toList());
    }

    /**
     * Filters books and transforms them into formatted summary strings.
     * Uses functional programming with Streams to filter and map books.
     *
     * @param books List of Book objects to process
     * @param filter Predicate to filter books
     * @param formatter Function to transform each Book into a String summary
     * @return List of formatted string summaries for matching books
     */
    public List<String> generateBookSummaries(List<Book> books,
                                              Predicate<Book> filter,
                                              Function<Book, String> formatter) {
        return books.stream()
                .filter(filter)
                .map(formatter)
                .collect(Collectors.toList());
    }

    /**
     * Filters books and applies a consumer action to each matching book.
     * Typically used for printing or displaying book recommendations.
     * Uses Streams with forEach for side effects.
     *
     * @param books List of Book objects to process
     * @param criteria Predicate to filter books
     * @param printer Consumer to apply to each matching book (e.g., for printing)
     */
    public void printRecommendations(List<Book> books,
                                     Predicate<Book> criteria,
                                     Consumer<Book> printer) {
        books.stream()
                .filter(criteria)
                .forEach(printer);
    }

    /**
     * Helper method that returns a predicate for highly-rated books.
     *
     * @param minRating Minimum rating threshold (inclusive)
     * @return Predicate that tests if a book's rating is >= minRating
     */
    public Predicate<Book> isHighlyRated(double minRating) {
        return book -> book.getRating() >= minRating;
    }

    /**
     * Helper method that returns a predicate for books of a specific genre.
     *
     * @param genre Genre to match (case-sensitive)
     * @return Predicate that tests if a book's genre matches the specified genre
     */
    public Predicate<Book> isGenre(String genre) {
        return book -> book.getGenre().equals(genre);
    }

    /**
     * Helper method that returns a predicate for recently published books.
     *
     * @param yearsAgo Number of years back from current year to consider as "recent"
     * @return Predicate that tests if a book was published within the last N years
     */
    public Predicate<Book> isRecentlyPublished(int yearsAgo) {
        int currentYear = Year.now().getValue();
        int cutoffYear = currentYear - yearsAgo;
        return book -> book.getPublicationYear() >= cutoffYear;
    }

    // Main method for testing
    public static void main(String[] args) {
        LibrarySearchEngine engine = new LibrarySearchEngine();

        // Create sample books
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", 1965, "Science Fiction", 4.5, 688),
                new Book("Foundation", "Isaac Asimov", 1951, "Science Fiction", 4.3, 255),
                new Book("The Martian", "Andy Weir", 2011, "Science Fiction", 4.6, 369),
                new Book("Project Hail Mary", "Andy Weir", 2021, "Science Fiction", 4.7, 496),
                new Book("1984", "George Orwell", 1949, "Dystopian", 4.4, 328),
                new Book("Brave New World", "Aldous Huxley", 1932, "Dystopian", 4.1, 288),
                new Book("The Road", "Cormac McCarthy", 2006, "Dystopian", 4.0, 287),
                new Book("Never Let Me Go", "Kazuo Ishiguro", 2005, "Dystopian", 3.8, 288)
        );

        System.out.println("=== Library Search Engine Demo ===\n");

        // Test 1: Simple search - highly rated books
        System.out.println("1. Books with rating >= 4.5:");
        List<Book> highlyRated = engine.searchBooks(books, engine.isHighlyRated(4.5));
        highlyRated.forEach(book -> System.out.println("   " + book.getTitle() + " - " + book.getRating() + "★"));

        // Test 2: Advanced search - highly rated, recent science fiction
        System.out.println("\n2. Highly-rated (>= 4.0) Science Fiction books published in last 15 years:");
        Predicate<Book> criteria1 = engine.isHighlyRated(4.0);
        Predicate<Book> criteria2 = engine.isGenre("Science Fiction");
        Predicate<Book> criteria3 = engine.isRecentlyPublished(15);
        List<Book> results = engine.advancedSearch(books, criteria1, criteria2, criteria3);
        results.forEach(book -> System.out.println("   " + book.getTitle() + " (" + book.getPublicationYear() + ") - " + book.getRating() + "★"));

        // Test 3: Generate summaries
        System.out.println("\n3. Summaries of highly-rated books:");
        Function<Book, String> formatter = book ->
                book.getTitle() + " by " + book.getAuthor() + " (" + book.getRating() + "★)";
        List<String> summaries = engine.generateBookSummaries(books, engine.isHighlyRated(4.5), formatter);
        summaries.forEach(summary -> System.out.println("   " + summary));

        // Test 4: Print recommendations
        System.out.println("\n4. Dystopian Book Recommendations:");
        Consumer<Book> printer = book ->
                System.out.println("   �책 " + book.getTitle() + " by " + book.getAuthor() +
                        " - " + book.getRating() + "★ (" + book.getPageCount() + " pages)");
        engine.printRecommendations(books, engine.isGenre("Dystopian"), printer);
    }
}