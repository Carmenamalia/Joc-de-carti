import java.util.ArrayList;
import java.util.List;

public abstract class Game {

    private List<Card> setOfCards;
    private List<Player> players;

    public Game() {
        this.setOfCards = Deck.getDeckCards();
        this.players = new ArrayList<>();
    }


    public List<Card> getSetOfCards() {
        return setOfCards;
    }

    public void setSetOfCards(List<Card> setOfCards) {
        this.setOfCards = setOfCards;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;

    }

    public abstract void deal() throws Exception;

    public abstract String play() throws Exception;

    public void addPlayers(Player player) throws NoOfPlayersNotSuportedException {
        if (players.size() >= 4) {
            throw new NoOfPlayersNotSuportedException("Numărul maxim de jucători este 4.");
        }
        players.add(player);
    }
}

