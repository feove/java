public class Scene {

    public static void gamePlay(Grid grid) {
        switch (TicTacToe.status) {
            case GAME:
                Grid.showGrid(grid);
                break;
            case LOSE:
                break;
            case TIE:
                break;
            case WIN:
                break;
            case SYMBOL_SELECTION:
                break;
            default:
                break;
        }

        Console.clear();

        Grid.showGrid(grid);
    }
}
