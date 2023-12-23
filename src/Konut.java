
class Konut {
    private String ad;
    private String soyad;
    private int daireNo;

    public Konut(String ad, String soyad, int daireNo) {
        this.ad = ad;
        this.soyad = soyad;
        this.daireNo = daireNo;
    }

    public void displayInfo() {
        System.out.println("Kiracı: " + ad + " " + soyad + " - Daire No: " + daireNo);
    }

    public int getDaireNo() {
        return daireNo;
    }

    @Override
    public String toString() {
        return "Daire No: " + getDaireNo();
    }
}