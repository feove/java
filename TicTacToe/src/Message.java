public class Message extends TicTacToe {

    public static void intro() {
        Console.clear();
        System.out.println("\n -==- Welcome to Tic Tac Toe! -==-\n");
        Console.sleep(2);
        Console.clear();

        TicTacToe.status = Status.SYMBOL_SELECTION;
    }
}
