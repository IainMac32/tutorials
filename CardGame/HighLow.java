package CardGame;

public class HighLow {
    private Deck clientDeck;
    private Deck comDeck;
    
    public HighLow(){
        clientDeck = new Deck();
        comDeck = new Deck();
    }

    public void play(){
        clientDeck.shuffle();
        comDeck.shuffle();

        int clientValue = clientDeck.draw(0);
        int comValue = comDeck.draw(0);

        if (clientValue > comValue){
            System.out.println("YOU WINNNNNN!!!!!! OMMGGG");
        } else if (comValue > clientValue){
            System.out.println("YOU LOSEEE BOOO HOOOOOO");
        } else{
            System.out.println("tie");
        }

    }

}
