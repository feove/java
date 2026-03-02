public class Bot extends Player {

    public Bot(String name) {
        super(name);
    }

    @Override
    public void choiceSetting() {
        int randomChoice = (int)(Math.random() * 3); 

        switch (randomChoice) {
            case 0 -> this.choice = SymbolChoice.ROCK;
            case 1 -> this.choice = SymbolChoice.PAPER;
            case 2 -> this.choice = SymbolChoice.SCISSORS;
        }
    }

   
}
