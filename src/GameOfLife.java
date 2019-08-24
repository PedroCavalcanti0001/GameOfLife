public class GameOfLife {
    private boolean[][] arr;

    public GameOfLife(int colunms, int rows) {
        this.arr = new boolean[colunms][rows];
    }

    public void setCellAlive(int colunm, int row) {
        arr[colunm][row] = true;
    }

    public void setCellDead(int colunm, int row) {
        arr[colunm][row] = false;
    }

    public void execCycle() {
        boolean[][] deaths = new boolean[arr.length][arr[arr.length-1].length];
        for (int colunm = 0; colunm < arr.length; colunm++) {
            for (int row = 0; row < arr[colunm].length; row++) {
                int livingNeighbors = 0;
                if (row >= 1 && arr[colunm][row - 1]) livingNeighbors+=1;
                if (row <= arr[colunm].length - 2 && arr[colunm][row + 1]) livingNeighbors+=1;
                if (colunm >= 1 && arr[colunm - 1][row])  livingNeighbors+=1;
                if (colunm <= arr.length - 2 && arr[colunm + 1][row]) livingNeighbors+=1;
                if (arr[colunm][row]) {
                    if (livingNeighbors < 2) {
                        deaths[colunm][row] = false;
                    }
                    if (livingNeighbors > 3) {
                        deaths[colunm][row] = false;
                    }
                } else {
                    if (livingNeighbors == 3) {
                        deaths[colunm][row] = true;
                    }
                }

            }
        }
           for (int colunm = 0; colunm < deaths.length; colunm++) {
                for (int row = 0; row < deaths[colunm].length; row++) {
                    arr[colunm][row] = deaths[colunm][row];
                }
            }

    }

    public void show() {
        StringBuffer buffer = new StringBuffer();
        for (int colunm = 0; colunm < arr.length; colunm++) {
            for (int row = 0; row < arr[colunm].length; row++) {
                if (arr[colunm][row]) {
                    buffer.append(".  ");
                } else {
                    buffer.append("X  ");
                }
                if (row == arr[colunm].length - 1) {
                    buffer.append("\n");
                }
            }
        }
        System.out.print(buffer.toString());

    }
}
