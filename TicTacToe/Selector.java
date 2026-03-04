public class Selector {

    private int x;
    private int y;

    private int limit;

    public Selector(int _x, int _y, int _limit) {
        this.x = _x;
        this.y = _y;
        this.limit = _limit;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void leftShift() {
        if (this.x > 0) {
            this.x--;
        }
    }

    public void rightShift() {
        if (this.x + 1 < this.limit) {
            this.x++;
        }
    }

    public void TopShift() {
        if (this.y > 0) {
            this.y--;
        }
    }

    public void BottomShift(Grid grid) {
        if (this.y + 1 < this.limit) {
            this.y++;
        }
    }

    public static String addSelector(Grid grid, String line) {
        StringBuilder new_selector = new StringBuilder(line);

        int size = grid.getSize();

        int x_selector = grid.getSelector().getX();

        int c_width = grid.getCellWidth();
        int x_offset = (int) (c_width / 2) + 1;

        for (int i = 0; i < size; i++) {
            if (i == x_selector) {
                new_selector.setCharAt(x_offset + i * (c_width), '>');
                new_selector.setCharAt(x_offset + i * (c_width + 2), '<');
            }
        }

        //String result = new String(new_selector.toString());

        return new_selector.toString();
    }
}
