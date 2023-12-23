import java.util.ArrayList;
class Bina {
    private int katSayisi;
    private int daireSayisi;
    private ArrayList<ArrayList<Konut>> katlar;
    private Konut binaSahibi;

    public Bina(int katSayisi, int daireSayisi) {
        this.katSayisi = katSayisi;
        this.daireSayisi = daireSayisi;
        this.katlar = new ArrayList<>(katSayisi);

        for (int i = 0; i < katSayisi; i++) {
            katlar.add(new ArrayList<>());

            for (int j = 1; j <= daireSayisi; j++) {
                int daireNo = i * daireSayisi + j;
                Daire daire = new Daire("", "", daireNo);
                katlar.get(i).add(daire);
            }
        }
    }

    public void setBinaSahibi(Konut binaSahibi) {
        this.binaSahibi = binaSahibi;
    }

    public void addKiraci(Konut kiraci) {
        int daireNo = kiraci.getDaireNo();
        int katIndex = (daireNo - 1) / daireSayisi;
        int daireIndex = (daireNo - 1) % daireSayisi;

        if (katlar.get(katIndex).get(daireIndex) instanceof Daire) {
            katlar.get(katIndex).set(daireIndex, kiraci);
            System.out.println("Kiracı eklendi.");
        } else {
            System.out.println("Bu daire zaten dolu.");
        }
    }

    public void removeKiraci(Konut kiraci) {
        int daireNo = kiraci.getDaireNo();
        int katIndex = (daireNo - 1) / daireSayisi;
        int daireIndex = (daireNo - 1) % daireSayisi;

        katlar.get(katIndex).set(daireIndex, new Daire("", "", daireNo));
    }

    public void displayInfo() {
        System.out.println("Kat Sayısı: " + katSayisi);

        for (int i = 0; i < katSayisi; i++) {
            int daireSayisi = katlar.get(i).size();
            System.out.println("Kat " + (i + 1) + " - Daire Sayısı: " + daireSayisi);

            for (Konut konut : katlar.get(i)) {
                konut.displayInfo();
            }

            System.out.println("--------------------");
        }
    }

    public ArrayList<Konut> getBosKonutlar(int katNo) {
        return katlar.get(katNo - 1);
    }
}