import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Binanın kaç katlı olacak:");
        int katSayisi = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Her katta kaç daire olacak:");
        int daireSayisi = scanner.nextInt();
        scanner.nextLine();

        Bina bina = new Bina(katSayisi, daireSayisi);

        System.out.println("Bina sahibinin adını girin:");
        String binaSahibiAd = scanner.nextLine();

        System.out.println("Bina sahibinin soyadını girin:");
        String binaSahibiSoyad = scanner.nextLine();

        int binaSahibiDaireNo = 1;
        Konut binaSahibi = new Konut(binaSahibiAd, binaSahibiSoyad, binaSahibiDaireNo);
        bina.setBinaSahibi(binaSahibi);

        while (true) {
            System.out.println("1 - Kiracı Ekle");
            System.out.println("2 - Kiracı Çıkar");
            System.out.println("3 - Daire Durumu Göster");
            System.out.println("0 - Çıkış");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.println("Hangi kata kiracı eklemek istiyorsunuz: (Kat No: 1-" + katSayisi + ")");
                    int kiraciKat = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Kiracının adını girin:");
                    String kiraciAd = scanner.nextLine();

                    System.out.println("Kiracının soyadını girin:");
                    String kiraciSoyad = scanner.nextLine();

                    ArrayList<Konut> bosDaireler = bina.getBosKonutlar(kiraciKat);
                    if (!bosDaireler.isEmpty()) {
                        System.out.println("Boş Daireler: " + bosDaireler);
                        System.out.println("Hangi daireye kiracı eklemek istiyorsunuz:");
                        int secilenBosDaire = scanner.nextInt();
                        scanner.nextLine();

                        int kiraciDaireNo = (kiraciKat - 1) * daireSayisi + secilenBosDaire;
                        Konut kiraci = new Konut(kiraciAd, kiraciSoyad, kiraciDaireNo);
                        bina.addKiraci(kiraci);
                    } else {
                        System.out.println("Bu katta boş daire kalmadı.");
                    }
                    break;

                case 2:
                    System.out.println("Hangi kat ve daireden kiracı çıkarmak istiyorsunuz: (Kat No: 1-" + katSayisi + ")");
                    int cikarilanKat = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Hangi daireden kiracı çıkarmak istiyorsunuz:");
                    int cikarilanDaire = scanner.nextInt();
                    scanner.nextLine();

                    int cikarilanDaireNo = (cikarilanKat - 1) * daireSayisi + cikarilanDaire;

                    ArrayList<Konut> konutlar = bina.getBosKonutlar(cikarilanKat);
                    for (Konut konut : konutlar) {
                        if (konut.getDaireNo() == cikarilanDaireNo) {
                            bina.removeKiraci(konut);
                            System.out.println("Kiracıyı çıkardınız.");
                            break;
                        }
                    }
                    break;

                case 3:
                    bina.displayInfo();
                    break;

                case 0:
                    System.out.println("Çıkış Yaptınız!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Geçersiz seçim yaptınız. Lütfen   seçimlerden birini deneyin.");
                    break;
            }
        }
    }
}
