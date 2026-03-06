public class Message extends TicTacToe {

    public static boolean HasSlept = false;

    public static void intro() {
        Console.hideCursor();
        System.out.println("\n -==- Welcome to Tic Tac Toe! -==- \n");

        if (HasSlept == false) {
            Console.sleep(1);
            HasSlept = true;
        }
        // Console.clear();
    }

    public static void title() {
        System.out.println("\n -==- Tic Tac Toe -==- \n");
    }

    public static void ShowTurn(Person p) {
        if (p == Person.HUMAN) {
            HumanTurn();
            return;
        }
        BotTurn();
    }

    public static void drawValidate() {
        Console.print("\n - [V] to Validate");
    }

    public static void drawPutSymbol() {
        if (GameRules.whoSelected(Symbol.CROSS) == Person.HUMAN) {
            Console.print("\n - [X] to place Symbol");
            return;
        }
        Console.print("\n - [0] to place Symbol");
    }

    public static void drawDeletion() {
        Console.print("\n - [BACKSPACE] to delete Symbol");
    }

    public static void drawEscape() {
        Console.print("\n - [ESCAP] to quit");
    }

    public static void drawArrows() {
        Console.print("\n    ↑         ");
        Console.print("   ← → to move");
        Console.print("    ↓         ");
    }

    public static void drawControl() {
        drawValidate();
        drawPutSymbol();
        drawDeletion();
        drawEscape();
        drawArrows();
    }

    public static void HumanTurn() {
        System.out.println("\n > It's your Turn! \n");
    }

    private static void BotTurn() {
        System.out.println("\n > Bot is thinking ... \n");
    }

    public static void Win() {
        Console.clear();
        System.out.println("\n -==- You Win! -==-\n");
    }

    public static void Lose() {
        Console.clear();
        System.out.println("\n -==- You Lose! -==-\n");
    }

    public static void Tie() {
        Console.clear();
        System.out.println("\n -==- It's a Tie! -==-\n");
    }
}
