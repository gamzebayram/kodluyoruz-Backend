import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int girilenSayi;
        Scanner sc = new Scanner(System.in);
        System.out.print("Kaç tane sayı gireceksiniz: ");
        girilenSayi = sc.nextInt();

        if (girilenSayi <= 0) {
            System.out.println("Lütfen geçerli bir sayı girin.");
            return;
        }
        System.out.print("1. Sayıyı giriniz: ");
        int firstNumber = sc.nextInt();
        int minSayi = firstNumber;
        int maxSayi = firstNumber;
        for (int i = 2; i <= girilenSayi; i++) {
            System.out.print(i + ". Sayıyı giriniz: ");
            int number = sc.nextInt();

            if (number < minSayi) {
                minSayi = number;
            } else if (number > maxSayi) {
                maxSayi = number;
            }
        }
        System.out.println("En büyük sayı: " + maxSayi);
        System.out.println("En küçük sayı: " + minSayi);
    }
}





