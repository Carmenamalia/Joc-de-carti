import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class BlackJack extends Game {


    public BlackJack() {
    }

    @Override
    public void deal() {
        //parcurg lista de jucatori si la fiecare jucator
        //setez mana jucatorului cu 5 carti luate din setul de carti
        for (Player player : getPlayers()) {
            for (int i = 0; i < 3; i++) {
                player.getHand().add(getSetOfCards().remove(0));
            }
            System.out.println("player hand " + player.getName() + " " + player.getHand());
        }
    }

    @Override
    public String play() {
        //calculez suma cartilor pt fiecare jucator
        //vad care suma  are diferenta minima fata de 21
        Map<String, Integer> playersRecord = new HashMap<>();
        String winnerName = "";
        Integer minDifference = Math.abs(Integer.MAX_VALUE);//iau diferenta fara minus
        for (Player player : getPlayers()) {
            Integer currentPlayerSum = player.getHandSumValue();
            System.out.println(player.getName() + " " + player.getHandSumValue());
            if (21 - currentPlayerSum < minDifference) {
                minDifference = 21 - currentPlayerSum;
                playersRecord.put(player.getName(), Math.abs(minDifference));
            }
        }
        // Folosește un iterator separat pentru a evita NoSuchElementException
        Iterator<String> iterator = playersRecord.keySet().iterator();

        // Verifică dacă există vreun element înainte de a apela next()
        if (iterator.hasNext()) {
            winnerName = iterator.next();
            int minDiff = playersRecord.get(winnerName);

            // Iterăm prin perechile cheie-valoare și găsim cheia asociată celei mai mici valori
            for (Map.Entry<String, Integer> entry : playersRecord.entrySet()) {
                if (entry.getValue() < minDiff) {
                    minDiff = entry.getValue();
                    winnerName = entry.getKey();
                }
            }

        }
        System.out.println(playersRecord);
        return winnerName;
    }
}

