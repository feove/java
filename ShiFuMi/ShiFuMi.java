
public class ShiFuMi {

    

    public static void main(String[] args) {

        Message.introduce();

        //TODO : Round number selection

        Human player = new Human("Leo");

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
