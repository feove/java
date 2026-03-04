public class GameRules {

    private Person winner;

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

    public Person setWinner(Person _winner) {
        return this.winner = _winner;
    }

    private static boolean checkColum(Grid grid, Symbol s, int col) {
        int size = grid.getSize();

        for (int i = 0; i < size; i++) {
            if (grid.Field[i][col].getSymbol() != s) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkLine(Grid grid, Symbol s, int line) {
        int size = grid.getSize();

        for (int j = 0; j < size; j++) {
            if (grid.Field[line][j].getSymbol() != s) {
                return false;
            }
        }

        return true;
    }

    private boolean checkLeftDiagonal(Grid grid, Symbol s) {
        boolean res = grid.Field[0][0].getSymbol() == s;
        res = res && grid.Field[1][1].getSymbol() == s;
        res = res && grid.Field[2][2].getSymbol() == s;

        return res;
    }

    private boolean checkRightDiagonal(Grid grid, Symbol s) {
        boolean res = grid.Field[2][0].getSymbol() == s;
        res = res && grid.Field[1][1].getSymbol() == s;
        res = res && grid.Field[0][2].getSymbol() == s;

        return res;
    }

    private boolean is_void_at(Grid grid, int x, int y) {
        return grid.Field[x][y].getSymbol() == Symbol.VOID;
    }

    private boolean columChecker(Grid grid) {
        if (is_void_at(grid, 1, 0) == false) {
            if (checkColum(grid, Symbol.CIRCLE, 1)) {
                this.winner = this.circle;
                return true;
            }

            if (checkColum(grid, Symbol.CROSS, 1)) {
                this.winner = this.cross;
                return true;
            }
        }
        return false;
    }

    private boolean lineChecker(Grid grid) {
        if (is_void_at(grid, 0, 1) == false) {
            if (checkLine(grid, Symbol.CIRCLE, 1)) {
                this.winner = this.circle;
                return true;
            }

            if (checkLine(grid, Symbol.CROSS, 1)) {
                this.winner = this.cross;
                return true;
            }
        }
        return false;
    }

    private boolean diagonaleChecker(Grid grid) {
        if (is_void_at(grid, 0, 0) == false) {
            if (checkLeftDiagonal(grid, Symbol.CIRCLE)) {
                this.winner = this.circle;
                return true;
            }

            if (checkLeftDiagonal(grid, Symbol.CROSS)) {
                this.winner = this.cross;
                return true;
            }
        }

        if (is_void_at(grid, 0, 2) == false) {
            if (checkRightDiagonal(grid, Symbol.CIRCLE)) {
                this.winner = this.circle;
                return true;
            }

            if (checkRightDiagonal(grid, Symbol.CROSS)) {
                this.winner = this.cross;
                return true;
            }
        }

        return false;
    }

    //Set Winner also
    public boolean isOver(Grid grid) {
        boolean res;
        boolean cross;
        boolean circle;

        if (columChecker(grid)) return true;

        if (lineChecker(grid)) return true;

        if (diagonaleChecker(grid)) return true;

        return false;
    }
}
