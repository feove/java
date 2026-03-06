public class Grid {

    public Cell[][] Field;

    private int size;

    private int cell_width;
    private int cell_height;

    private Selector s;

    public Grid(int _size, int _cell_width, int _cell_height) {
        initField(_size);

        this.size = _size;
        this.cell_width = _cell_width;
        this.cell_height = _cell_height;

        this.s = new Selector(2, 2, _size);
    }

    private void initField(int size) {
        Field = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Field[j][i] = new Cell(3); // Void
            }
        }
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
        char separator,
        int line
    ) {
        StringBuilder l = new StringBuilder(start);

        int c_width = grid.getCellWidth();

        int size = grid.getSize();

        l.append(start);

        // System.out.println("DEBUG");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < c_width; j++) {
                if (j == (int) (c_width / 2) && start == end) {
                    Symbol currentSymbol = grid.Field[line][i].getSymbol();

                    if (currentSymbol == Symbol.CIRCLE) {
                        l.append('O');
                        continue;
                    }

                    if (currentSymbol == Symbol.CROSS) {
                        l.append('X');
                        continue;
                    }
                }

                l.append(border);
            }

            char sep = (i + 1 != size) ? separator : end;
            l.append(sep);
        }

        return l.toString();
    }

    public static void setSymbol(Grid grid, Symbol s, int x, int y) {
        grid.Field[y][x] = new Cell(s);
    }

    public static boolean canPlaceAt(Grid grid, int x, int y) {
        return grid.Field[y][x].getSymbol() == Symbol.VOID;
    }

    private static String buildArrows(int i) {
        switch (i) {
            case 1:
                return "     ↑         ";
            case 2:
                return "    ← → to move";
            case 3:
                return "     ↓         ";
            default:
                return "";
        }
    }

    public static void showGrid(Grid grid) {
        // Unicodes used : ╩ ╦ ╠ ╣ ║ ═ ╚ ╝ ╗ ╔ ╬

        String blank_gasp = "      ";

        int size = grid.getSize();

        Selector sel = grid.getSelector();

        String l_top = buildCustomLine(grid, '╔', '╗', '═', '╦', 0);
        Console.print(blank_gasp + l_top);

        int arrow_line = 0;

        for (int i = 0; i < size; i++) {
            String line = buildCustomLine(grid, '║', '║', ' ', '║', i);

            if (i == sel.getY()) {
                line = Selector.addSelector(grid, line);
            }

            String arrows = buildArrows(i);

            if (arrows != "") arrow_line++;

            Console.print(blank_gasp + line + arrows);
            if (i + 1 == size) break;

            if (i < arrow_line) arrows = buildArrows(i + 1);

            String border = buildCustomLine(grid, '╠', '╣', '═', '╬', i);
            Console.print(blank_gasp + border + arrows);
        }

        String l_bottom = buildCustomLine(grid, '╚', '╝', '═', '╩', 2);
        Console.print(blank_gasp + l_bottom);
        /*/
        System.out.print("DEBUG\n\n");
        System.out.print(grid.Field[sel.getY()][sel.getX()].getSymbol());
        System.out.print("\n x=" + sel.getX() + "\n y=" + sel.getY());
        System.out.println("HumanCanPlay = " + GameRules.CanHumanPlay());
        System.out.println(
            " HumanPutSymbol = " + GameRules.gameRules.HumanPutSymbol
        );
   *
        //  System.out.println("Expected :");
        /*
        Console.print("╔═══╦═══╦═══╗");
        Console.print("║ O ║ X ║ X ║");
        Console.print("╠═══╬═══╬═══╣");
        Console.print("║   ║ O ║   ║");
        Console.print("╠═══╬═══╬═══╣");
        Console.print("║ X ║   ║   ║");
        Console.print("╚═══╩═══╩═══╝");
        */
    }
}
