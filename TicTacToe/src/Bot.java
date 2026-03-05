public class Bot {

    public static void play(Grid grid) {
        if (GameRules.currentTurn != Person.BOT) return;

        Symbol s = GameRules.whatSelected(Person.BOT);

        int size = grid.getSize();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid.Field[i][j].getSymbol() == Symbol.VOID) {
                    grid.Field[i][j] = new Cell(s);
                    return;
                }
            }
        }
    }
}
