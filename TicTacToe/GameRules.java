public class GameRules {

    private final Person winner;

    private final Person cross;
    private final Person circle;

    public GameRules(Person _cross, Person _circle) {
        this.winner = Person.NONE;
        this.cross = _cross;
        this.circle = _circle;
    }

    public Person getWinner() {
        return this.winner;
    }

    private boolean checkColum(Grid grid, int col) {
        int size = grid.getSize();

        for (int i = 0; i < size; i++) {}
    }

    public static boolean isOver(Grid grid) {
        int size = grid.getSize();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {}
        }

        return false;
    }
}
