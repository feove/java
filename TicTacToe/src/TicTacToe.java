import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.awt.event.KeyEvent;

public class TicTacToe {

    public static void main(String arg[]) {
        Message.intro();
        Grid grid = new Grid(3, 3, 3);

        try (
            Terminal terminal = new DefaultTerminalFactory().createTerminal()
        ) {
            terminal.enterPrivateMode();
            terminal.setCursorVisible(false);

            while (true) {
                Console.clear();
                Grid.showGrid(grid);

                int x = grid.getSelector().getX();
                int y = grid.getSelector().getY();

                KeyStroke keyStroke = terminal.readInput();

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
                        // Do nothing for other keys
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
