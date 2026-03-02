
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Human extends Player {

    public int roundMod = 0;

    public int getRoundMod() {
        return roundMod;
    }

    public void setRoundMod(char letter) {

        switch (letter) {
            case 'a' -> this.roundMod = 1;
            case 'b' -> this.roundMod = 3;
            case 'c' -> this.roundMod = 5;
        }
    }
   
    public Human(String name) {
        super(name);
    }

    public String getStringChoice() {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            return input;
        } catch (Exception e) {
            
            System.out.println("Error reading input: " + e.getMessage());
            return null;
        }

    }

    private char listenLetterMod() {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            return input.charAt(0);
        } catch (Exception e) {
            
            System.out.println("Error reading input: " + e.getMessage());
            return '\0';
        }

    }


    @Override
    public void choiceSetting() {
        

        String input = getStringChoice();

        String loweString = input.toLowerCase();
       
        switch (loweString) {
            case "rock":
            case "r":   
                this.choice = SymbolChoice.ROCK;
                break;

            case "paper":
            case "p":
                this.choice = SymbolChoice.PAPER;
                break;

            case "scissors":
            case "s":   
                this.choice = SymbolChoice.SCISSORS;
                break;  
            default:
                this.choice = null;
                break;
        }
    }

    private boolean isValidRoundModLetter(char letter) {
        return letter == 'a' || letter == 'b' || letter == 'c';
    }

    public static void listenRoundConfig(Human human) {
        
    
        while (true) {
            char letter = human.listenLetterMod();

            if (human.isValidRoundModLetter(letter)) {
                human.setRoundMod(letter);
                Message.selectionRoundMod(human.roundMod);
                break;
            }

            Message.invalidModLetter();
            Message.askModeLetter();
        }
    }


    public static void listenChoice(Player player) {
        
        while (true) {
            player.choiceSetting();

            if (player.choice != null) {
                break;
            }

            Message.invalidChoice();
            Message.askPlayerMove();
        }
    }

    

}
