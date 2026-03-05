public class SymbolSelection {

    public static void assignSymbol(Person cross, Person circle) {
        GameRules.gameRules = new GameRules(cross, circle);
    }

    public static void drawSymbolSelection() {
        Console.print("\n > Select your symbol:\n");

        Console.print("    ╔═══╗     ╔═══╗ ");
        Console.print("    ║ O ║     ║ X ║ ");
        Console.print("    ╚═══╝     ╚═══╝ ");
        Console.print("     [1]       [2]\n");

        Console.print("\n > [ESCAP] to quit");
    }
}
