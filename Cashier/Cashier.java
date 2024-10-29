package Cashier;

public class Cashier {
    private int total;
    public Cashier(Cart cart){
        total = 0;

        for (Book b : cart){
            total += b.getPrice();
        }
    }

    public int getTotal(){
        return this.total;
    }
}
