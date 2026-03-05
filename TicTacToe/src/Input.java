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
            GameRules.HumanCanPlay == false ||
            GameRules.HumanPutSymbol
        ) return false;

        if (c == 'o' || c == 'O') {
            if (GameRules.gameRules.circle == Person.HUMAN) {
                Grid.setSymbol(grid, Symbol.CIRCLE, y, x);
                GameRules.HumanPutSymbol = true;
            }
        } else if (c == 'x' || c == 'X') {
            if (GameRules.gameRules.cross == Person.HUMAN) {
                Grid.setSymbol(grid, Symbol.CROSS, y, x);
                GameRules.HumanPutSymbol = true;
            }
        }

        return true;
    }

    private static boolean SymbolSelectionCase(char c) {
        if (TicTacToe.status != Status.SYMBOL_SELECTION) return false;

        if (c == 'o' || c == 'O' || c == '1') {
            SymbolSelection.assignSymbol(Person.BOT, Person.HUMAN);
        } else if (c == 'x' || c == 'X' || c == '2') {
            SymbolSelection.assignSymbol(Person.HUMAN, Person.BOT);
        }

        TicTacToe.status = Status.GAME;
        return true;
    }

    private static boolean Validatation(char c) {
        if (
            TicTacToe.status != Status.GAME || GameRules.HumanCanPlay == false
        ) return false;

        GameRules.HumanCanPlay = false;
        return true;
    }

    private static void characterInput(char c, Grid grid) {
        int x = grid.getSelector().getX();
        int y = grid.getSelector().getY();

        if (GameCase(grid, c, x, y)) return;

        if (SymbolSelectionCase(c)) return;

        if (Validatation(c)) return;
    }

    public static void manager(
        Terminal terminal,
        Grid grid,
        KeyStroke keyStroke
    ) throws IOException {
        // Add throws declaration

        switch (keyStroke.getKeyType()) {
            case ArrowUp:
                grid.getSelector().TopShift();
                break;
            case ArrowDown:
                grid.getSelector().BottomShift(grid);
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
