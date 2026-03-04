public class Grid {

    public int[][] Field = new int[3][3];

    private int size;

    public Grid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Field[i][j] = 0;
            }
        }

        this.size = 3;
    }

    public int getSize() {
        return this.size;
    }

    public static void showGrid(Grid grid, Selector selector) {
        // Unicodes ╩ ╦ ║ ╠ ╣ ║ ═ ╚ ╝ ╗ ╔ ╬

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
