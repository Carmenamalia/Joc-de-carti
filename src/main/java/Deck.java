import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static final List<Integer> numbers = List.of(1,2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
    private static final List<String> symbols = List.of("hearts", "spades", "diamonds", "clubs");
    private static List<Card> deckCards;


    private static void initializeDeck() {
        deckCards = new ArrayList<>();
        generateCards();
    }

    //adaug in lista de carti fiecare carte si simbolul
    public static void generateCards() {
        for (int number : numbers) {
            for (String symbol : symbols) {
                deckCards.add(new Card(number, symbol));
            }
        }
    }

    public static void shuffleCards() {
        Collections.shuffle(deckCards);
    }

    public static List<Card> getDeckCards() {
        if (deckCards == null || deckCards.isEmpty()) {
            initializeDeck();
        }
        shuffleCards();
        return deckCards;
    }
}
