
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Human extends Player {

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
