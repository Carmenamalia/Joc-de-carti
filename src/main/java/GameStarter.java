

public class GameStarter {

    public void startBlackJack() {
        Player player1 = new Player("Cornel");
        Player player2 = new Player("Marcel");
        BlackJack blackJack = new BlackJack();
//adaug jucatorii in lista de jucatori a jocului
        try {
            blackJack.addPlayers(player1);
            blackJack.addPlayers(player2);
        } catch (NoOfPlayersNotSuportedException e) {
            System.out.println(e.getMessage());
        }
        blackJack.deal();//se impart cartile
        System.out.println(blackJack.play());
    }

    public void startPoker() {
        Player player1 = new Player("Mihai");
        Player player2 = new Player("Marian");
        Player player3 = new Player("Paul");
        Player player4 = new Player("Maria");
        Player player5 = new Player("Sonia");//jucator in plus pt a testa exceptia
        Poker poker = new Poker();
//adaug jucatorii in lista de jucatori a jocului
        try {
            poker.addPlayers(player1);
            poker.addPlayers(player2);
            poker.addPlayers(player3);
            poker.addPlayers(player4);
            poker.addPlayers(player5);//jucator in plus pt a testa exceptia
        } catch (NoOfPlayersNotSuportedException e) {
            System.out.println(e.getMessage());
        }

        poker.deal();//se impart cartile
        System.out.println(poker.play());//se joaca jocul


    }
}
