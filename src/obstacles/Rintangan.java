package obstacles;

public class Rintangan {
    // Penggunaan 'protected' agar bisa diakses oleh subclass (anak-anaknya)
    protected String nama;
    protected String deskripsi;
    protected String itemSolusi; // ID Item yang dibutuhkan untuk lewat
    protected int damageJikaGagal;

    // Constructor
    public Rintangan(String nama, String deskripsi, String itemSolusi, int damage) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.itemSolusi = itemSolusi;
        this.damageJikaGagal = damage;
    }

    // Method umum untuk menampilkan pesan saat pemain bertemu rintangan
    public void tampilkanEncounter() {
        System.out.println("=========================================");
        System.out.println("!! RINTANGAN DI DEPAN: " + this.nama.toUpperCase() + " !!");
        System.out.println("=========================================");
        System.out.println(this.deskripsi);
    }

    // Getter (Encapsulation)
    public String getItemSolusi() {
        return this.itemSolusi;
    }

    public int getDamage() {
        return this.damageJikaGagal;
    }

    public String getNama() {
        return this.nama;
    }
}