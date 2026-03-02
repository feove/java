public class GameRules {
    
    public static GameIssue getGameIssue(SymbolChoice playerChoice, SymbolChoice botChoice) {
        if (playerChoice == botChoice) {
            return GameIssue.TIE;

        } else {

            int human = playerChoice.getValue();
            int bot = botChoice.getValue();
            int computeChoices = human + bot;

            if (computeChoices == 4 && human == 1) {
                return GameIssue.WON;
            }
            if (computeChoices == 5 && human == 3) {
                return GameIssue.WON;
            }
            if (computeChoices == 3 && human == 2) {
                return GameIssue.WON;
            } 
        
            else {
                return GameIssue.LOOSE;
            }
        }
    }
}
