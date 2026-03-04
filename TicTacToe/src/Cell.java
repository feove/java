public class Cell {

    private Symbol s;

    public Cell(int symbol_value) {
        switch (symbol_value) {
            case 1 -> this.s = Symbol.CROSS;
            case 2 -> this.s = Symbol.CIRCLE;
            default -> this.s = Symbol.VOID;
        }
    }

    public Cell(Symbol symbol) {
        this.s = symbol;
    }

    public int getIntValue() {
        return this.s.getValue();
    }

    public Symbol getSymbol() {
        return this.s;
    }
}
