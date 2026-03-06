import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Input {

    private static boolean GameCase(Grid grid, char c, int x, int y) {
        if (
            TicTacToe.status != Status.GAME ||
            GameRules.HumanPutSymbol ||
            Grid.canPlaceAt(grid, x, y) == false
        ) return false;

        if (c == 'o' || c == 'O') {
            if (GameRules.gameRules.circle == Person.HUMAN) {
                Grid.setSymbol(grid, Symbol.CIRCLE, x, y);
                GameRules.HumanPutSymbol = true;
            }
        } else if (c == 'x' || c == 'X') {
            if (GameRules.gameRules.cross == Person.HUMAN) {
                Grid.setSymbol(grid, Symbol.CROSS, x, y);
                GameRules.HumanPutSymbol = true;
            }
        }

        return true;
    }

    private static boolean SymbolSelectionCase(char c) {
        if (TicTacToe.status == Status.GAME) {
            return false;
        }

        if (c == 'o' || c == 'O' || c == '2') {
            SymbolSelection.assignSymbol(Person.BOT, Person.HUMAN);
            TicTacToe.status = Status.GAME;
        } else if (c == 'x' || c == 'X' || c == '1') {
            SymbolSelection.assignSymbol(Person.HUMAN, Person.BOT);
            TicTacToe.status = Status.GAME;
        }

        return true;
    }

    private static boolean Validatation(char c) {
        if (
            TicTacToe.status != Status.GAME ||
            GameRules.CanHumanPlay() == false ||
            GameRules.HumanPutSymbol == false
        ) return false;

        if (c == 'v') {
            GameRules.setTurn(Person.BOT);
            return true;
        }

        return false;
    }

    private static boolean Deletion(Grid grid) {
        if (
            TicTacToe.status != Status.GAME ||
            GameRules.CanHumanPlay() == false ||
            GameRules.HumanPutSymbol == false
        ) return false;
        Selector s = grid.getSelector();

        if (
            grid.Field[s.getY()][s.getX()].getSymbol() == Symbol.VOID
        ) return false;

        grid.Field[s.getY()][s.getX()] = new Cell(Symbol.VOID);
        GameRules.HumanPutSymbol = false;

        return false;
    }

    private static void characterInput(char c, Grid grid) {
        int x = grid.getSelector().getX();
        int y = grid.getSelector().getY();

        if (SymbolSelectionCase(c)) return;

        if (GameCase(grid, c, x, y)) return;

        if (Validatation(c)) return;
    }

    public static void manager(
        Terminal terminal,
        Grid grid,
        KeyStroke keyStroke
    ) throws IOException {
        // Add throws declaration

        switch (keyStroke.getKeyType()) {
            case Backspace:
                Deletion(grid);
                break;
            case ArrowUp:
                grid.getSelector().TopShift();
                break;
            case ArrowDown:
                grid.getSelector().BottomShift();
                break;
            case ArrowLeft:
                grid.getSelector().leftShift();
                break;
            case ArrowRight:
                grid.getSelector().rightShift();
                break;
            case Escape:
                terminal.exitPrivateMode();
                System.exit(0);
                return;
            case Character:
                char c = keyStroke.getCharacter();

                characterInput(c, grid);

                break;
            default:
                break;
        }
    }
}
