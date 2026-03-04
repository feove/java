public class TicTacToe {

    public static void main(String arg[]) {
        System.out.println("Hello");

        Grid grid = new Grid();
        Selector selector = new Selector(0, 0);

        Message.showGrid(grid);
    }
}
