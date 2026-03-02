

public abstract class Player {

    protected String name;

    protected SymbolChoice choice;

    protected int score = 0;

    public Player(String name) {
        this.name = name;
        this.choice = null; 
    }
    
    public String getName() {
        return name;
    }

    public void incrementScore() {
        this.score++;
    }

    public abstract void choiceSetting();

    

}