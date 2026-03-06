public class Scene {

    public static void gamePlay(Grid grid) {
        Console.clear();
        switch (TicTacToe.status) {
            case GAME:
                GameRules.gameManager(grid);
                Grid.showGrid(grid);
                Message.ShowTurn(GameRules.currentTurn);
                break;
            case LOSE:
                Message.Lose();
                break;
            case TIE:
                Message.Tie();
                break;
            case WIN:
                Message.Win();
                break;
            case INTRO:
                Message.intro();
                SymbolSelection.drawSymbolSelection();
                break;
            default:
                break;
        }
    }
}
