public class Selector {

    private int x;
    private int y;

    public Selector(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public static String addSelector(Grid grid, String line) {
        StringBuilder new_selector = new StringBuilder(line);

        int size = grid.getSize();

        int x_selector = grid.getSelector().getX();

        int c_width = grid.getCellWidth();
        int x_offset = c_width / 2 + 1;

        int x = 0;

        for (int i = x_offset; i < size * c_width; i += c_width) {
            if (x == x_selector) {
                new_selector.setCharAt(x * c_width - 2, '>');
                new_selector.setCharAt(x * c_width, '<');
            }

            x++;
        }

        String result = new String(new_selector.toString());

        return result;
    }
}
