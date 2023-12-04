public class Card {
    private Integer number;
    private String symbol;

    public Card(Integer number, String symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
