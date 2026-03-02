
public class ShiFuMi {

    
    public static  boolean isGameOver(Human human, Bot bot) {
        return human.score >= human.roundMod || bot.score >= human.roundMod;
    }

    public static void updateScores(GameIssue gameIssue,Human human, Bot bot) {
        
        
        switch (gameIssue) {
            case WON ->  human.incrementScore();
            case LOOSE ->  bot.incrementScore();
            case TIE ->  {}
        }

    }

    public static void main(String[] args) {

        Message.introduce();

        Message.askModeLetter();

        Human player = new Human("You");

        Human.listenRoundConfig(player);
        Console.hideCursor();

        while (true) { 
            Message.askPlayerMove();

            Human.listenChoice(player);
            Console.hideCursor();

            Message.showPlayerMove(player);       

            Bot bot = new Bot("Bot");
            bot.choiceSetting();
            Message.showPlayerMove(bot);

            Message.loadingAnimation();
            
            GameIssue gameIssue = GameRules.getGameIssue(player.choice, bot.choice);

            updateScores(gameIssue, player, bot);

            Message.GameResult(gameIssue, player, bot);   
            Message.showScores(player, bot);
            

            if (isGameOver(player, bot)) {
                break;
            }      
        }
           

    }
}
