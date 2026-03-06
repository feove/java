public class Message extends TicTacToe {

    public static boolean HasSlept = false;

    public static void intro() {
        Console.hideCursor();
        System.out.println("\n   -==- Welcome to Tic Tac Toe! -==- \n");

        if (HasSlept == false) {
            Console.sleep(1);
            HasSlept = true;
        }
        // Console.clear();
    }

    public static void title() {
        System.out.println("\n   -==- Tic Tac Toe -==- \n");
    }

    public static void ShowTurn(Person p) {
        if (p == Person.HUMAN) {
            HumanTurn();
            return;
        }
        BotTurn();
    }

    private static final int box_width = 42;

    public static void drawValidate(String start, char border) {
        String content = start + " - [V] to Validate";

        String completion = buildLine(
            ' ',
            ' ',
            border,
            box_width - content.length() + 1
        );

        Console.print(content + completion);
    }

    public static void drawPutSymbol(String start, char border) {
        String content = start + " - [X] to place Symbol";

        String completion = buildLine(
            ' ',
            ' ',
            border,
            box_width - content.length() + 1
        );

        if (GameRules.whoSelected(Symbol.CROSS) == Person.HUMAN) {
            Console.print(content + completion);
            return;
        }

        content = start + " - [0] to place Symbol";

        Console.print(content + completion);
    }

    public static void drawDeletion(String start, char border) {
        String content = start + " - [BACKSPACE] to delete Symbol";

        String completion = buildLine(
            ' ',
            ' ',
            border,
            box_width - content.length() + 1
        );

        Console.print(content + completion);
    }

    public static void drawEscape(String start, char border) {
        String content = start + " - [ESCAP] to quit";
        String completion = buildLine(
            ' ',
            ' ',
            border,
            box_width - content.length() + 1
        );

        Console.print(content + completion);
    }

    public static void drawArrows(String start) {
        Console.print("\n" + start + "     ↑         ");
        Console.print(start + "    ← → to move");
        Console.print(start + "     ↓         ");
    }

    private static String buildLine(
        char start,
        char content,
        char end,
        int number
    ) {
        StringBuilder line = new StringBuilder(content);

        line.append(start);

        for (int i = 0; i < number - 2; i++) {
            line.append(content);
        }

        line.append(end);

        return line.toString();
    }

    public static void drawControl() {
        String start = " ┃ ";
        String gasp = " ";
        String border = gasp + buildLine('┃', ' ', '┃', box_width);

        //        int box_width = 42;

        String top_border = buildLine('┏', '━', '┓', box_width);
        String bottom_border = buildLine('┗', '━', '┛', box_width);

        Console.print(gasp + top_border);

        drawValidate(start, '┃');
        Console.print(border);

        drawPutSymbol(start, '┃');
        Console.print(border);

        drawDeletion(start, '┃');
        Console.print(border);

        drawEscape(start, '┃');
        Console.print(gasp + bottom_border);
        //  Console.print(border);
        // drawArrows(border_gasp);
    }

    public static void HumanTurn() {
        System.out.println("\n  > It's your Turn! \n");
    }

    private static void BotTurn() {
        System.out.println("\n  > Bot is thinking ... \n");
    }

    public static void Win() {
        Console.clear();
        System.out.println("\n   -==- You Win! -==-\n");
    }

    public static void Lose() {
        Console.clear();
        System.out.println("\n   -==- You Lose! -==-\n");
    }

    public static void Tie() {
        Console.clear();
        System.out.println("\n   -==- It's a Tie! -==-\n");
    }
}
