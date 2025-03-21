package buoi9.btvn;

public interface ILibrary {

    void addBook(Book book);
    void updateBook(int id,Book book);
    void deleteBook(int id);
    void searchByAuthor(String author);
    void displayAllBooks();
    Book findById(int id);
}
