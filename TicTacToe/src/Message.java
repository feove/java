public class Message extends TicTacToe {

    public static void intro() {
        Console.clear();
        System.out.println("\n -==- Welcome to Tic Tac Toe! -==-\n");
        Console.sleep(2);
        Console.clear();

        TicTacToe.status = Status.SYMBOL_SELECTION;
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
