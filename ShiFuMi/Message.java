

public class Message {
    
    private static int lodingCharlength = 12;

    public static void introduce() {
        Console.clear();
        Console.hideCursor();
        System.out.println("\n-===- Welcome To Shi Fu Mi  ! -===- \n");
        Console.sleep(400);
        
    }

    public static void askPlayerMove() {

       Console.hideCursor();
        System.out.println("-> Please enter your move: \n\n [R]ock or [P]aper or [S]cissors");
        Console.sleep(800);
        System.err.print("\n > your choice : ");
        Console.showCursor();

    }

    public static void invalidChoice() {

        System.out.println("\nInvalid choice. Please enter rock, paper, or scissors.\n");
    }

    public static void loadingAnimation() {

        Console.sleep(400);
        Console.clear();

        String default_p1String = "\n  >> Loading [";
        String default_p2String = "]";
        String animation_dots = "";

        int spaceTotal = lodingCharlength;

        for (int i = 0; i < spaceTotal; i++) {

            for (int j = 0; j < i; j++) {        
                animation_dots += "=";
            }        
            for (int e = 0; e < spaceTotal - i; e++) {
                animation_dots += " ";
            }

            System.out.print(default_p1String + animation_dots + default_p2String);
            animation_dots = "";
            Console.sleep(200);
            Console.clear();
        }
      
        System.out.println("");

    }

       public static void showPlayerMove(Player player) {
        String name = player.getName();

        Console.sleep(500);
        System.out.println("\n - " + name + " chose: " + player.choice);
        Console.sleep(800);
    }

    public static void invalidModLetter() {
        System.out.println("\n X Invalid letter. Please enter a, b, or c\n");
    }

    public static void selectionRoundMod(int roundMod) {

        System.err.println("\n > You have selected: BO" + roundMod + "\n");
    }

    public static void askModeLetter() {

        Console.sleep(1000);
        System.out.println(" > Type the letter corresponding to the game mode\n");
        Console.sleep(500);
        System.out.println(" a) BO1\n b) BO3\n c) BO5 \n");
        Console.showCursor();
        System.out.print(" >  ");
        Console.sleep(500);
    }


    public static void showScores(Human human, Bot bot) {

        Console.sleep(1000);
        System.out.println("\n -===- Scores: -===-\n");
        System.out.println("   - " + human.getName() + ": " + human.score);
        System.out.println("   - " + bot.getName() + ": " + bot.score+"\n");
        Console.sleep(500);
    }

   
    public static void GameResult(GameIssue gameIssue, Human human, Bot bot) {
        
        boolean isGameOver = ShiFuMi.isGameOver(human, bot); 
    
        System.out.println(gameIssue.gameIssueMessage(isGameOver));

        Console.showCursor();
        
    }

    public static int getLodingCharlength() {
        return lodingCharlength;
    }
}
