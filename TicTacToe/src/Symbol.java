public enum Symbol {
    CROSS(1),
    CIRCLE(2),
    VOID(3);

    private final int value;

    Symbol(int _value) {
        this.value = _value;
    }

    public int getValue() {
        return this.value;
    }
}
