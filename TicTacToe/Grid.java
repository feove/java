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
}
