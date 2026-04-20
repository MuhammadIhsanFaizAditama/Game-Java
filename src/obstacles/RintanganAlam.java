package obstacles;

// Menggunakan keyword 'extends' untuk mewarisi class Rintangan
public class RintanganAlam extends Rintangan {
    
    // Constructor
    public RintanganAlam(String nama, String deskripsi, String itemSolusi, int damage) {
        // 'super' digunakan untuk memanggil constructor milik induk (Rintangan)
        super(nama, deskripsi, itemSolusi, damage);
    }

    @Override
    public void tampilkanEncounter() {
        System.out.println("\n[MEDAN TERJAL] - Hati-hati langkahmu!");
        super.tampilkanEncounter(); // Tetap memanggil teks dasar dari induk
        System.out.println("Jika kamu salah langkah, kamu bisa terluka parah.");
    }
}