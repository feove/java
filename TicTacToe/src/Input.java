import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Input {

    public static void manager(
        Terminal terminal,
        Grid grid,
        KeyStroke keyStroke
    ) throws IOException {
        // Add throws declaration
        int x = grid.getSelector().getX();
        int y = grid.getSelector().getY();

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
                if (c == 'o' || c == 'O') {
                    Grid.setSymbol(grid, Symbol.CIRCLE, y, x);
                } else if (c == 'x' || c == 'X') {
                    Grid.setSymbol(grid, Symbol.CROSS, y, x);
                }
                break;
            default:
                break;
        }
    }
}
