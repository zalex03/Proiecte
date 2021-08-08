package teme.w06_collections.ex2_card_deck;

import java.util.Objects;

enum Suit {
    diamonds, clubs, hearts, spades
}

public class Card {
    private int numbers;
    public Suit suit;

    Card(int numbers, Suit suit) {
        this.numbers = numbers;
        this.suit = suit;
    }


    public int getNumbers() {
        return numbers;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return numbers == card.numbers &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "numbers=" + numbers +
                ", suit=" + suit +
                '}';
    }
}
