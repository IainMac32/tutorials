package Cashier;

import java.util.*;


public class Cart implements Iterable<Book>{
    private List<Book> cart;

    private boolean contains(Book b){

        for (int i = 0; i < Catalogue.getBooks().length; i++){
            if (Catalogue.getBooks()[i] == b){
                return true;
            }
        }
        return false;
    }

    public void add(Book b){
        if (contains(b)){
            cart.add(b);
        }
        cart.add(b);
    }

    public Cart(){
        this.cart = new ArrayList<Book>();
    }

    @Override 
    public Iterator<Book> iterator(){
        return cart.iterator();
    }
}
