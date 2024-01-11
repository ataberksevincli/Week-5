import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> book = new TreeSet<>(new OrderNameComparable());
        book.add(new Book("Lord of the Rings", 1200, "J.R.R Tolkien", 1954));
        book.add(new Book("Hunger Games", 1805, "Suzanne Collins", 2008));
        book.add(new Book("Harry Potter", 4224, "J.K Rowling", 1997));
        book.add(new Book("Game of Thrones", 5264, "George R.R. Martin", 1996));
        book.add(new Book("Divergent", 1920, "Veronico Roth", 2012));


        for (Book books : book){
            System.out.println(books.getBookName() + " Kitap Serisi Toplam" +  " " + books.getBookPage() + " Sayfaya Sahiptir." );
        }

    }
}
