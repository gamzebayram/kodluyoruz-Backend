import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double mesafe, indirimOrani = 0.0, mesafebasiucret = 0.10;;
        int yas, yolculukTipi;

        Scanner sc = new Scanner(System.in);

        System.out.print("Lütfen mesafe (KM) giriniz : ");
        mesafe = sc.nextDouble();
        System.out.print("Lütfen yaşınızı giriniz : ");
        yas = sc.nextInt();
        System.out.print("Lütfen yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ): ");
        yolculukTipi = sc.nextInt();

        if ((mesafe >= 0.0) && (yas >= 0) && (yolculukTipi == 1 || yolculukTipi == 2)) {

            if (yas < 12) {
                indirimOrani = 0.5; // %50 indirim
            } else if (yas >= 12 && yas <= 24) {
                indirimOrani = 0.1; // %10 indirim
            } else if (yas >= 65) {
                indirimOrani = 0.3; // %30 indirim
            }

            double biletFiyati = mesafe * mesafebasiucret;
            double indirimMiktari = biletFiyati * indirimOrani;
            double odenecekFiyat = biletFiyati - indirimMiktari;

            if (yolculukTipi == 2) {
                indirimOrani = 0.2; // Gidiş dönüş ise ekstra %20 indirim
                indirimMiktari = odenecekFiyat * indirimOrani;
                double toplamFiyat = (odenecekFiyat - indirimMiktari) * 2;
                System.out.println("uçak bileti fiyatı : " + toplamFiyat + " TL");
            } else {
                System.out.println("uçak bileti fiyatı : " + odenecekFiyat + " TL");
            }
        } else {
            System.out.println("Hatalı Veri Girdiniz !");
        }
    }
}