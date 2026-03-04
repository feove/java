import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.awt.event.KeyEvent;

public class TicTacToe {

    public static Status status = Status.INTRO;

    public static void main(String arg[]) {
        Message.intro();
        Grid grid = new Grid(3, 3, 3);

        try (
            Terminal terminal = new DefaultTerminalFactory().createTerminal()
        ) {
            terminal.enterPrivateMode();
            terminal.setCursorVisible(false);

            while (true) {
                Scene.gamePlay(grid);

                KeyStroke keyStroke = terminal.readInput();

                Input.manager(terminal, grid, keyStroke);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
