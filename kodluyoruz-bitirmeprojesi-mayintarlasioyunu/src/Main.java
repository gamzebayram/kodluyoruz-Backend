import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Mayın tarlası boyutu için satır sayısını girin: ");
        int rows = input.nextInt();

        System.out.print("Mayın tarlası boyutu için sütun sayısını girin: ");
        int cols = input.nextInt();

        MineSweeper game = new MineSweeper(rows, cols);
        game.play();

    }
}