public class Test {
    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife(10, 8);
        gol.setCellAlive(0, 1);
        gol.setCellAlive(1, 0);
        gol.setCellAlive(1, 2);
        gol.execCycle();
        gol.show();
    }
}
