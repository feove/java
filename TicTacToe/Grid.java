public class Grid {

    public int[][] Field = new int[3][3];

    private int size;

    private int cell_width;
    private int cell_height;

    private Selector s;

    public Grid(int _size, int _cell_width, int _cell_height) {
        for (int i = 0; i < _size; i++) {
            for (int j = 0; j < _size; j++) {
                Field[i][j] = 0;
            }
        }
        this.size = _size;
        this.cell_width = _cell_width;
        this.cell_height = _cell_height;

        this.s = new Selector(2, 2, _size);
    }

    public int getCellWidth() {
        return this.cell_width;
    }

    public int getCellHeight() {
        return this.cell_height;
    }

    public Selector getSelector() {
        return this.s;
    }

    public int getSize() {
        return this.size;
    }

    private static String buildCustomLine(
        Grid grid,
        char start,
        char end,
        char border,
        char separator
    ) {
        StringBuilder l = new StringBuilder(start);

        int c_width = grid.getCellWidth();

        int size = grid.getSize();

        l.append(start);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < c_width; j++) {
                l.append(border);
            }

            char sep = (i + 1 != size) ? separator : end;
            l.append(sep);
        }

        return l.toString();
    }

    public static void showGrid(Grid grid) {
        // Unicodes used : ╩ ╦ ╠ ╣ ║ ═ ╚ ╝ ╗ ╔ ╬

        int size = grid.getSize();

        Selector sel = grid.getSelector();

        String l_top = buildCustomLine(grid, '╔', '╗', '═', '╦');
        Console.print(l_top);

        for (int i = 0; i < size; i++) {
            String line = buildCustomLine(grid, '║', '║', ' ', '║');

            if (i == sel.getY()) {
                line = Selector.addSelector(grid, line);
            }

            Console.print(line);
            if (i + 1 == size) break;

            String border = buildCustomLine(grid, '╠', '╣', '═', '╬');
            Console.print(border);
        }

        String l_bottom = buildCustomLine(grid, '╚', '╝', '═', '╩');
        Console.print(l_bottom);

        System.out.println("Expected :");

        Console.print("╔═══╦═══╦═══╗");
        Console.print("║ O ║ X ║ X ║");
        Console.print("╠═══╬═══╬═══╣");
        Console.print("║   ║ O ║   ║");
        Console.print("╠═══╬═══╬═══╣");
        Console.print("║ X ║   ║   ║");
        Console.print("╚═══╩═══╩═══╝");
    }
}
