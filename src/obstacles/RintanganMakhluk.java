package obstacles;

public class RintanganMakhluk extends Rintangan {
    
    // Constructor
    public RintanganMakhluk(String nama, String deskripsi, String itemSolusi, int damage) {
        super(nama, deskripsi, itemSolusi, damage);
    }

    @Override
    public void tampilkanEncounter() {
        System.out.println("\n[BAHAYA BIOLOGIS] - Sesuatu mendekat!");
        super.tampilkanEncounter();
        System.out.println("Makhluk ini terlihat agresif. Kamu harus bertindak cepat.");
    }
}