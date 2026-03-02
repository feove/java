
public class ShiFuMi {

    public static  void setPlayerChoice(Player player) {
        
        while (true) {
            player.choiceSetting();

            if (player.choice != null) {
                break;
            }

            Message.invalidChoice();
        }

    }

    public static void main(String[] args) {

        Message.introduce();

        //TODO : Round number selection

        Human player = new Human("Leo");

        Message.askPlayerMove();

        setPlayerChoice(player);

        player.showPlayerMove();        

    }
}
