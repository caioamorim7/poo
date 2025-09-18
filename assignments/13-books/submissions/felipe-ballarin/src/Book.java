public class Book {
    public String title;
    public int year;
    public  String author;

    @Override 
    public String toString(){
        System.out.print("O título é: " + title);
        System.out.print("O ano é: " + year);
        System.out.print("O autor é: " + author);
    }
}

public class PrintBook extends Book {
    public String publisher;
    public String isbn;

    @Override 
    public String toString(){
        System.out.print("O título é: " + title);
        System.out.print("O ano é: " + year);
        System.out.print("O autor é: " + author);
        System.out.print("A editora é: " + publisher);
        System.out.print("O isbn é: " + isbn);
    }
}

public class AudioBook extends Book {
    public double fileSizeInMB;
    public int playLengthInMinutes;
    public String narrator;

    @Override 
    public String toString(){
        System.out.print("O título é: " + title);
        System.out.print("O ano é: " + year);
        System.out.print("O autor é: " + author);
        System.out.print("A tamanho do arquivo em MB é: " + fileSizeInMB);
        System.out.print("O tempo de execução em minutos é: " + playLengthInMinutes);
        System.out.print("O narrador é: " + narrator);
    }
}

public class BookApp {
    public static void main(String[] args){
        new Book();
        new PrintBook();
        new AudioBook();
        System.out.print(Book.toString());
        System.out.print(PrintBook.toString());
        System.out.print(AudioBook.toString());
    }
}