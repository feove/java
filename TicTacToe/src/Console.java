import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Console {

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void hideCursor() {
        System.out.print("\033[?25l");
    }

    public static void showCursor() {
        System.out.print("\033[?25h");
    }

    public static void print(String str) {
        try {
            PrintStream out = new PrintStream(
                System.out,
                true,
                StandardCharsets.UTF_8.name()
            );
            out.println(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void print(char c) {
        try {
            PrintStream out = new PrintStream(
                System.out,
                true,
                StandardCharsets.UTF_8.name()
            );
            out.print(c);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
