package obstacles;

import java.util.Scanner;

public class JebakanLogika extends Rintangan {
    // Variabel khusus yang HANYA dimiliki oleh JebakanLogika
    private String pertanyaan;
    private String jawabanBenar;

    // Constructor
    public JebakanLogika(String nama, String deskripsi, int damage, String pertanyaan, String jawabanBenar) {
        // Memanggil induk. Karena tidak butuh item, kita isi itemSolusi dengan "None"
        super(nama, deskripsi, "None", damage); 
        this.pertanyaan = pertanyaan;
        this.jawabanBenar = jawabanBenar;
    }

    // Method Overriding: Mengubah cara pesan ditampilkan
    @Override
    public void tampilkanEncounter() {
        System.out.println("\n[TEKA-TEKI KUNO] - Langkahmu terhenti!");
        super.tampilkanEncounter(); // Memanggil teks dari Rintangan dasar
        System.out.println("Tidak ada alat yang bisa membantumu di sini, gunakan akalmu.");
    }

    // Method khusus untuk class ini: Berinteraksi dengan pemain
    public boolean selesaikanTekaTeki() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Pertanyaan: " + this.pertanyaan);
        System.out.print("Jawabanmu: ");
        String jawabanPemain = input.nextLine();

        // Validasi jawaban (equalsIgnoreCase agar huruf besar/kecil tidak masalah)
        if (jawabanPemain.equalsIgnoreCase(this.jawabanBenar)) {
            System.out.println("Benar! Terdengar suara roda gigi berputar, jalan terbuka.");
            return true;
        } else {
            System.out.println("Salah! Jebakan aktif...");
            // Asumsi HP pemain akan dikurangi oleh sistem utama menggunakan this.damageJikaGagal
            return false;
        }
    }
}