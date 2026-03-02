
public class ShiFuMi {

    

    public static void main(String[] args) {

        Message.introduce();

        Message.askModeLetter();

        Human player = new Human("You");

        Human.listenRoundConfig(player);
        Console.hideCursor();

        Message.askPlayerMove();

        Human.listenChoice(player);
        Console.hideCursor();

        Message.showPlayerMove(player);       

        Bot bot = new Bot("Bot");
        bot.choiceSetting();
        Message.showPlayerMove(bot);

        Message.loadingAnimation();
        

        Message.GameResult(player, bot);      

    }
}
