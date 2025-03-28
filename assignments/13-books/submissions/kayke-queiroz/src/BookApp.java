class Book {
    String title;
    int year;
    String author;

    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + year;
    }
}

class PrintBook extends Book {
    String publisher;
    String isbn;

    public PrintBook(String title, int year, String author, String publisher, String isbn) {
        super(title, year, author);
        this.publisher = publisher;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + publisher + ", " + isbn;
    }
}

class AudioBook extends Book {
    double fileSizeInMB;
    int playLengthInMinutes;
    String narrator;

    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + fileSizeInMB + "MB, " + playLengthInMinutes + " min, " + narrator;
    }
}

public class BookApp {
    public static void main(String[] args) {
        Book genericBook = new Book("Dom Quixote", 1605, "Miguel de Cervantes");
        PrintBook printBook = new PrintBook("1984", 1949, "George Orwell", "Companhia das Letras", "978-857-1234-56");
        AudioBook audioBook = new AudioBook("O Senhor dos Anéis", 1954, "J.R.R. Tolkien", 850.5, 1200, "Rob Inglis");

        System.out.println(genericBook);
        System.out.println(printBook);
        System.out.println(audioBook);
    }
}
