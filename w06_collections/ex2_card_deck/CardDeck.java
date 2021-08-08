package teme.w06_collections.ex2_card_deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardDeck {
    Random generate = new Random();
    private ArrayList<Card> cards = new ArrayList<>(52);
    private ArrayList<Card> dealtCards = new ArrayList<>(52);

    public CardDeck() {
        for (int i = 2; i < 15; i++) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(i, suit);
                cards.add(card);
            }
        }
    }

    //TODO: add fields, constructors, fill method bodies, etc..

    void shuffle() {
        cards.addAll(dealtCards);
        dealtCards.removeAll(dealtCards);
        Collections.shuffle(cards);
        System.out.println("Shuffled cards" + cards);
    }

    List<Card> dealHand(int handSize) {
        Collections.shuffle(cards);
        ArrayList<Card> count = new ArrayList<>();
        for (int i = 0; i < handSize; i++) {
            if (cards.isEmpty()) {
                return count;
            }
            count.add(cards.get(0));
            dealtCards.add(cards.get(0));
            cards.remove(0);
        }
        /*for(int i = 0 ; i < handSize ; i++){
            if(cards.isEmpty()){
                return count;
            }
            if(i>=cards.size()){
                i = 0;
            }
            count.add(cards.get(i));
            dealtCards.add(cards.get(i));
            cards.remove(i);*/

        System.out.println("Dealt cards are" + dealtCards);
        return count;
    }

    int getAvailableCardCount() {
        //???
        return cards.size();
    }

    int getUsedCardCount() {
        //???
        return dealtCards.size();
    }


    /**
     * Just for some manual tests
     */
    public static void main(String[] args) {

        CardDeck deck = new CardDeck();
        System.out.println(deck.dealHand(5)); // <- print 5 cards 3 times
        System.out.println(deck.dealHand(5));
        System.out.println(deck.dealHand(5));
        System.out.println(deck.dealHand(50)); // <- only 39 cards should be printed here
        System.out.println(deck.dealHand(50)); // <- and empty list should be printed
        deck.shuffle();
        System.out.println(deck.dealHand(5)); // <- another 5 cards

    }

    @Override
    public String toString() {
        return "CardDeck{" +
                "cards=" + cards +
                '}';
    }
}
