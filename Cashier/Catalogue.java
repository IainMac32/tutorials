package Cashier;


public class Catalogue {
    public static Book winnie = new Book(20, "winnie the", "family",  "sheppard");
    public static Book dune = new Book(20, "dune", "adventure",  "mina");
    public static Book gonegirl = new Book(40, "GoneGirl", "mystery",  "Andrew");


    public static Book[] getBooks (){
        Book[] books = new Book[3];
        books[0] = winnie;
        books[1] = dune;
        books[2] = gonegirl;
        return books;
    }

}
