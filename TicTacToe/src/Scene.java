public class Scene {

    public static void drawGame(Grid grid, boolean GameOver) {
        if (GameOver == false) Message.title();
        Grid.showGrid(grid);

        if (GameOver) return;

        Message.ShowTurn(GameRules.currentTurn);
        Message.drawControl();
    }

    public static void gamePlay(Grid grid) {
        Console.clear();
        switch (TicTacToe.status) {
            case GAME:
                GameRules.gameManager(grid);
                drawGame(grid, false);
                break;
            case LOSE:
                Message.Lose();
                drawGame(grid, true);
                TicTacToe.isOver = true;
                break;
            case TIE:
                Message.Tie();
                drawGame(grid, true);
                TicTacToe.isOver = true;
                break;
            case WIN:
                Message.Win();
                drawGame(grid, true);
                TicTacToe.isOver = true;
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
