

public class Message {
    
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }   

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
    }

    public static void introduce() {

        
        clearConsole();

        System.out.println("Welcome to the game of Rock, Paper, Scissors!");
        sleep(1000);
        
    }

    public static void askRoundNumber() {

        System.out.println("How many rounds do you want to play?");

    }

    public static void askPlayerMove() {

        System.out.println("Please enter your move (rock, paper, or scissors):");

    }

    public static void invalidChoice() {

        System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
    }

    public static void loadingAnimation() {

        
        System.out.println("Loading...");

    }
}
