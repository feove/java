public class Message {

    public static void intro() {
        System.out.println(" -==- Welcome to Tic Tac Toe! -==-");
    }

    public static void showGrid(Grid grid) {
        int size = grid.getSize();

        for (int i = 0; i < size; i++) {
            System.out.print("[");
            for (int j = 0; j < size; j++) {
                System.out.print(" " + grid.Field[i][j]);
            }

            System.out.println(" ]");
        }
    }
}
