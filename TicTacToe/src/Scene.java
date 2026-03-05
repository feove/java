public class Scene {

    public static void gamePlay(Grid grid) {
        Console.clear();
        switch (TicTacToe.status) {
            case GAME:
                GameRules.gameManager(grid);
                Grid.showGrid(grid);
                break;
            case LOSE:
                break;
            case TIE:
                break;
            case WIN:
                break;
            case SYMBOL_SELECTION:
                SymbolSelection.drawSymbolSelection();
                break;
            default:
                break;
        }
    }
}
