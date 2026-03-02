
public enum SymbolChoice {
    PAPER(1),
    SCISSORS(2),
    ROCK(3);
    
    private final int value;
    
    SymbolChoice(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}   