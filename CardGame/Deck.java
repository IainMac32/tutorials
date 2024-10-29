package CardGame;

import java.util.*;

public class Deck {
    private List<CardG> deck;

    public Deck(){
        deck = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 13; j++){
                deck.add(new CardG(i,j));
            }
        }
    }


    public int draw(int i) {
        CardG card = deck.get(i);
        int rank = card.getRank();
        deck.remove(i);
        return rank;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }
}
