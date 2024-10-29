package Cashier;


public class Main {
    
    public static void main(String[] args){

        Book winnie = Catalogue.winnie;

        Cart cart = new Cart();

        cart.add(winnie);
    
        Cashier cashier = new Cashier(cart);
    
        int total = cashier.getTotal();
    
        System.out.println(total);
    
    }


}
