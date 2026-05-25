package Lab_9;

// Declare a class called book having author_name as private data member. Extend book 
// class to have two sub classes called book_publication & paper_publication. Each of 
// these classes have private member called title. Write a complete program to show 
// usage of dynamic method dispatch (dynamic polymorphism) to display book or paper 
// publications of given author. [B]


class Book {
    private String authorName;


    public Book(String authorName) {
        this.authorName = authorName;
    }


    public String getAuthorName() {
        return this.authorName;
    }

    public void displayPublication() {
        System.out.println("Publication by author: " + authorName);
    }
}

class BookPublication extends Book {
    private String title;

    public BookPublication(String authorName, String title) {
        super(authorName);
        this.title = title;
    }

    @Override
    public void displayPublication() {
        System.out.println("Book Publication:");
        System.out.println("Author: " + getAuthorName());
        System.out.println("Title: " + title);
        System.out.println("----------------------------");
    }
}

class PaperPublication extends Book {
    private String title;

    public PaperPublication(String authorName, String title) {
        super(authorName);
        this.title = title;
    }

    @Override
    public void displayPublication() {
        System.out.println("Paper Publication:");
        System.out.println("Author: " + getAuthorName());
        System.out.println("Title: " + title);
        System.out.println("----------------------------");
    }
}

public class Program_4 {
    public static void main(String[] args) {


        Book pub1 = new BookPublication("J.K. Rowling", "Harry Potter and the Sorcerer's Stone");
        Book pub2 = new PaperPublication("Albert Einstein", "Theory of Relativity");


        pub1.displayPublication();
        pub2.displayPublication();


        Book[] publications = new Book[3];
        publications[0] = new BookPublication("George Orwell", "1984");
        publications[1] = new PaperPublication("Isaac Newton", "Principia Mathematica");
        publications[2] = new BookPublication("J.R.R. Tolkien", "The Hobbit");

        System.out.println("\n--- Displaying all publications ---");
        for (Book b : publications) {
            b.displayPublication();
        }
    }
}
