import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Bir sayı girin: ");
        int sayi = sc.nextInt();


        if (asalMi(sayi, sayi / 2)) {
            System.out.println(sayi + " asaldır.");
        } else {
            System.out.println(sayi + " asal değildir.");
        }
    }

    public static boolean asalMi(int sayi, int bolen) {

        if (bolen == 1) {
            return true; // 1'e kadar bölen bulunamadı, sayı asaldır
        } else {
            if (sayi == 1 || (sayi % bolen == 0)) {
                return false; // Sayı bölünüyor, asal değil
            } else {
                return asalMi(sayi, bolen - 1); // Recursive olarak bir sonraki böleni kontrol et
            }
        }
    }
}
