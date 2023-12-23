import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    private int[][] field;
    private boolean[][] mines;
    private int rows;
    private int cols;
    private int remainingCells;


    public MineSweeper(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.field = new int[rows][cols];
        this.mines = new boolean[rows][cols];
        this.remainingCells = rows * cols;
        initializeField();
        placeMines();
    }

    private void initializeField() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.field[i][j] = -1;
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int totalMines = remainingCells / 4;
        while (totalMines > 0) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            if (!mines[row][col]) {
                mines[row][col] = true;
                totalMines--;
            }
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isValid(i, j) && mines[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
    public void play() {
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz !");
        Scanner scanner = new Scanner(System.in);
        while (remainingCells != ((rows * cols) / 4)) {
            printField();
            System.out.print("Satır Giriniz: ");
            int row = scanner.nextInt() - 1;
            System.out.print("Sütun Giriniz: ");
            int col = scanner.nextInt() - 1;

            if (!isValid(row, col)) {
                System.out.println("Geçersiz bir seçim, lütfen tekrar deneyin.");
                continue;
            } else if (mines[row][col]) {
                System.out.println("Mayına bastınız! Oyun bitti.");
                return;
            } else {
                field[row][col] = countAdjacentMines(row, col);
                remainingCells--;
            }
        }
        printField();
        System.out.println("Tebrikler, tüm mayınları buldunuz! Oyunu kazandınız.");
    }
    private void printField() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (field[i][j] == -1) {
                    System.out.print("- ");
                } else {
                    System.out.print(field[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}






