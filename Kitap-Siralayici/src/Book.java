public class Book {
    private String bookName;
    private int bookPage;
    private String bookAuthor;
    private int bookReleaseDate;

    public Book(String bookName, int bookPage, String bookAuthor, int bookReleaseDate) {
        this.bookName = bookName;
        this.bookPage = bookPage;
        this.bookAuthor = bookAuthor;
        this.bookReleaseDate = bookReleaseDate;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPage() {
        return bookPage;
    }

    public void setBookPage(int bookPage) {
        this.bookPage = bookPage;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookReleaseDate() {
        return bookReleaseDate;
    }

    public void setBookReleaseDate(int bookReleaseDate) {
        this.bookReleaseDate = bookReleaseDate;
    }
}
