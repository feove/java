import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

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

                KeyStroke keyStroke = terminal.readInput();

                if (keyStroke.getKeyType() == KeyType.ArrowUp) {
                    grid.getSelector().TopShift();
                } else if (keyStroke.getKeyType() == KeyType.Escape) {
                    break;
                }
            }

            terminal.exitPrivateMode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
