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

        System.out.println(
            "\u2554\u2550\u2550\u2550\u2566\u2550\u2550\u2550\u2566\u2550\u2550\u2550\u2557"
        );
        System.out.println("\u2551 O \u2551 X \u2551 X \u2551");
        System.out.println(
            "\u2560\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2563"
        );
        System.out.println("\u2551   \u2551 O \u2551   \u2551");
        System.out.println(
            "\u2560\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2563"
        );
        System.out.println("\u2551 X \u2551   \u2551   \u2551");
        System.out.println(
            "\u255A\u2550\u2550\u2550\u2569\u2550\u2550\u2550\u2569\u2550\u2550\u2550\u255D"
        );

        /*
        System.out.println("╔═══╦═══╦═══╗");
        System.out.println("║ O ║ X ║ X ║");
        System.out.println("╠═══╬═══╬═══╣");
        System.out.println("║   ║ O ║   ║");
        System.out.println("╠═══╬═══╬═══╣");
        System.out.println("║ X ║   ║   ║");
        System.out.println("╚═══╩═══╩═══╝");

        for (int i = 0; i < size; i++) {

            char symbol = '╚';
            System.out.print("[");
            for (int j = 0; j < size; j++) {
                System.out.print(" " + grid.Field[i][j]);
            }

            System.out.println(" ]");
        }
         */
    }
}
