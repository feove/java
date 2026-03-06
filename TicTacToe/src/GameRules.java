public class GameRules {

    public static GameRules gameRules;

    private Person winner;
    private boolean tie;

    public final Person cross;
    public final Person circle;

    public static Person currentTurn;

    public static boolean HumanPutSymbol = false;

    public GameRules(Person _cross, Person _circle) {
        this.winner = Person.NONE;
        this.cross = _cross;
        this.circle = _circle;
        this.tie = true;
        GameRules.currentTurn = Person.HUMAN; // Should be random
    }

    public static boolean CanHumanPlay() {
        return GameRules.currentTurn == Person.HUMAN;
    }

    public static boolean CanBotPlay() {
        return GameRules.currentTurn == Person.BOT;
    }

    public static void setTurn(Person p) {
        GameRules.currentTurn = p;
    }

    public static void gameManager(Grid grid) {
        if (gameRules.isOver(grid)) {
            if (gameRules.tie) {
                TicTacToe.status = Status.TIE;
                return;
            }

            if (gameRules.winner == Person.BOT) {
                TicTacToe.status = Status.WIN;
                return;
            }

            TicTacToe.status = Status.LOSE;
        }

        if (CanBotPlay()) {
            Grid.showGrid(grid);
            Message.ShowTurn(GameRules.currentTurn);

            Console.sleep(3);
            Console.clear();
            Bot.play(grid);
            setTurn(Person.HUMAN);
            GameRules.HumanPutSymbol = false;
        }
    }

    public static Symbol whatSelected(Person p) {
        if (p == gameRules.cross) {
            return Symbol.CROSS;
        }

        return Symbol.CIRCLE;
    }

    public static Person whoSelected(Symbol s) {
        if (s == Symbol.CROSS) {
            return gameRules.cross;
        }

        return gameRules.circle;
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

            if (grid.Field[i][col].getSymbol() == Symbol.VOID) {
                gameRules.tie = false;
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

            if (grid.Field[j][line].getSymbol() == Symbol.VOID) {
                gameRules.tie = false;
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
        return grid.Field[y][x].getSymbol() == Symbol.VOID;
    }

    private boolean columChecker(Grid grid) {
        if (is_void_at(grid, 1, 0) == false) {
            if (checkColum(grid, Symbol.CIRCLE, 1)) {
                this.winner = whoSelected(Symbol.CIRCLE);
                return true;
            }

            if (checkColum(grid, Symbol.CROSS, 1)) {
                this.winner = whoSelected(Symbol.CROSS);
                return true;
            }
        }
        return false;
    }

    private boolean lineChecker(Grid grid) {
        if (is_void_at(grid, 0, 1) == false) {
            if (checkLine(grid, Symbol.CIRCLE, 1)) {
                this.winner = whoSelected(Symbol.CIRCLE);
                return true;
            }

            if (checkLine(grid, Symbol.CROSS, 1)) {
                this.winner = whoSelected(Symbol.CROSS);
                return true;
            }
        }
        return false;
    }

    private boolean diagonaleChecker(Grid grid) {
        if (is_void_at(grid, 0, 0) == false) {
            if (checkLeftDiagonal(grid, Symbol.CIRCLE)) {
                this.winner = whoSelected(Symbol.CIRCLE);
                return true;
            }

            if (checkLeftDiagonal(grid, Symbol.CROSS)) {
                this.winner = whoSelected(Symbol.CROSS);
                return true;
            }
        }

        if (is_void_at(grid, 0, 2) == false) {
            if (checkRightDiagonal(grid, Symbol.CIRCLE)) {
                this.winner = whoSelected(Symbol.CIRCLE);
                return true;
            }

            if (checkRightDiagonal(grid, Symbol.CROSS)) {
                this.winner = whoSelected(Symbol.CROSS);
                return true;
            }
        }

        return false;
    }

    //Set Winner also
    public boolean isOver(Grid grid) {
        //Assume it can change
        this.tie = false;

        if (columChecker(grid)) return true;

        if (lineChecker(grid)) return true;

        if (diagonaleChecker(grid)) return true;

        return this.tie;
    }
}
