

public class Message {
    
    
    public static void introduce() {

        Console.clear();
        Console.hideCursor();
        System.out.println("-===- Welcome To Shi Fu Mi  ! -===- \n");
        Console.sleep(1000);
        
    }

    public static void askRoundNumber() {

        System.out.println("How many rounds do you want to play?");

    }

    public static void askPlayerMove() {

       
        System.out.println("-> Please enter your move (rock or R, paper or P, or scissors or S):");
        Console.sleep(1000);
        System.err.print("\n > your choice : ");
        Console.showCursor();

    }

    public static void invalidChoice() {

        System.out.println("\nInvalid choice. Please enter rock, paper, or scissors.");
    }

    public static void loadingAnimation() {

        String default_p1String = "\n  ----  Loading";
        String default_p2String = "   ----  ";
        String animation_dots = "";

        for (int i = 0; i < 3; i++) {
            animation_dots += ".";
            System.out.print(default_p1String + animation_dots + default_p2String);
            Console.sleep(500);
        }

        Console.sleep(1000);
        System.err.println("");

    }

       public static void showPlayerMove(Player player) {
        String name = player.getName();

        Console.sleep(500);
        System.out.println("\n - " + name + " chose: " + player.choice);
        Console.sleep(1000);
    }

    public static void GameResult(Player player1, Player player2) {

        GameIssue gameIssue = GameRules.getGameIssue(player1.choice, player2.choice);

        switch (gameIssue) {
            case WON -> System.out.println("\n > Congratulations! You won the game!");
            case LOOSE -> System.out.println("\n > Sorry, you lost the game. Better luck next time!");
            case TIE -> System.out.println("\n > It's a tie! Try again.");
        }

        Console.showCursor();
        
    }
}
