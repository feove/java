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

    public static void ShowTurn(Person p) {
        if (p == Person.HUMAN) {
            HumanTurn();
            return;
        }
        BotTurn();
    }

    public static void HumanTurn() {
        System.out.println("\n -==- Your Turn! -==-\n");
    }

    private static void BotTurn() {
        System.out.println("\n -==- Bot Turn! -==-\n");

        //Animation
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
