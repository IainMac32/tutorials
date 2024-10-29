package Cashier;

import java.util.*;

public class Book {
    private int price;
    private String title;
    private String genre;
    private String author;

    public Book(int price, String title, String genre, String author){
        this.price = price;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public double getPrice(){
        return this.price;
    }



    @Override


    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Book book = (Book) o;

        return this.price == book.price && 
                Objects.equals(this.title, book.title) &&
                Objects.equals(this.genre, book.genre) &&
                Objects.equals(this.author, book.author);

    }
}
