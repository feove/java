

public abstract class Player {

    protected String name;

    protected SymbolChoice choice;

    public Player(String name) {
        this.name = name;
        this.choice = null; 
    }
    
    public String getName() {
        return name;
    }


    public abstract void choiceSetting();

 

}