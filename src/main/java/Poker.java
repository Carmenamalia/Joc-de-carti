import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Poker extends Game {


    public Poker() {

    }

    @Override
    public void deal() {
        //parcurg lista de jucatori si la fiecare jucator
        //setez mana jucatorului cu 8 carti luate din setul de carti
        for (Player player : getPlayers()) {
            for (int i = 0; i < 8; i++) {
                player.getHand().add(getSetOfCards().remove(0));
            }
            System.out.println("player hand " + player.getName() + " " + player.getHand());
        }
    }

    @Override
    public String play() {
        Map<String, Integer> playersRecord = getPlayersRecord();
        System.out.println(playersRecord);//afisare de control
        //initializez o variabila winner iterand cheile mapei
//        String winner = playersRecord.keySet().iterator().next();
        String winner = "";
        // Folosește un iterator separat pentru a evita NoSuchElementException
        Iterator<String> iterator = playersRecord.keySet().iterator();

        // Verifică dacă există vreun element înainte de a apela next()
        if (iterator.hasNext()) {
            winner = iterator.next();
            //initializez cu 0 valoarea maxima
            int maxValue = playersRecord.get(winner);
            // Iterăm prin perechile cheie-valoare și găsim cheia asociată celei mai mari valori
            for (Map.Entry<String, Integer> entry : playersRecord.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    //castigatorul va fi jucatorul cu valoarea cea mai mare
                    winner = entry.getKey();
                }
            }
        }
        return winner;
    }

    private Map<String, Integer> getPlayersRecord() {
        Map<String, Integer> playersRecord = new HashMap<>();
//parcurg lista de jucatori si la fiecare jucator parcurg lista de carti din mana
        for (Player player : getPlayers()) {
            Integer maxCardValue = 0;//initializez cartea cu valoarea maxima cu 0
            for (Card card : player.getHand()) {
                //aleg la fiecare jucator cartea cu valoarea cea mai mare
                if (card.getNumber() > maxCardValue) {
                    maxCardValue = card.getNumber();
                }
            }
            //pun in mapa la cheie numele jucatorului si ca valoare cartea cea mai mare a jucatorului
            playersRecord.put(player.getName(), maxCardValue);
        }
        return playersRecord;
    }
}
