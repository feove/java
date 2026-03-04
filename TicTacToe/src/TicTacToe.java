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

                switch (keyStroke.getKeyType()) {
                    case KeyType.ArrowUp -> {
                        grid.getSelector().TopShift();
                    }
                    case KeyType.ArrowDown -> {
                        grid.getSelector().BottomShift(grid);
                    }
                    case KeyType.ArrowLeft -> {
                        grid.getSelector().leftShift();
                    }
                    case KeyType.ArrowRight -> {
                        grid.getSelector().rightShift();
                    }
                    case KeyType.Escape -> {
                        Console.clear();
                        terminal.exitPrivateMode();
                        return;
                    }
                    default -> {
                        if (keyStroke.getKeyType() == KeyType.Character) {
                            char c = keyStroke.getCharacter();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
