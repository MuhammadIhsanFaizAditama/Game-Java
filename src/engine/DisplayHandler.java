package engine;

public class DisplayHandler {

    // === ANSI ESCAPE CODES UNTUK WARNA ===
    // Kode ini digunakan agar teks di terminal/CMD kalian punya warna.
    // Dosen pasti suka fitur kecil seperti ini karena menunjukkan effort lebih.
    public static final String RESET = "\u001B[0m";
    public static final String MERAH = "\u001B[31m";
    public static final String HIJAU = "\u001B[32m";
    public static final String KUNING = "\u001B[33m";
    public static final String BIRU = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    // --- METHOD UNTUK MENAMPILKAN TEKS UMUM ---

    // Mencetak garis pemisah agar rapi
    public static void cetakGaris() {
        System.out.println(CYAN + "==================================================" + RESET);
    }

    // Mencetak judul suatu kejadian/level
    public static void cetakJudul(String judul) {
        cetakGaris();
        System.out.println(CYAN + "   " + judul.toUpperCase() + "   " + RESET);
        cetakGaris();
    }

    // --- METHOD UNTUK STATUS ---

    // Warna merah untuk hal buruk (Damage, Error, Mati)
    public static void cetakBahaya(String pesan) {
        System.out.println(MERAH + "[BAHAYA] " + pesan + RESET);
    }

    // Warna hijau untuk hal baik (Lolos, Heal, Item Baru)
    public static void cetakSukses(String pesan) {
        System.out.println(HIJAU + "[BERHASIL] " + pesan + RESET);
    }

    // Warna kuning untuk cerita atau instruksi
    public static void cetakInfo(String pesan) {
        System.out.println(KUNING + "[INFO] " + pesan + RESET);
    }

    // --- METHOD KHUSUS TAMPILAN ---

    // Trik sederhana untuk membersihkan layar terminal
    public static void bersihkanLayar() {
        // Mencetak baris kosong sebanyak 50 kali
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // Logo judul menggunakan ASCII Art
    public static void tampilkanLogo() {
        System.out.println(KUNING);
        System.out.println("  _____           _ _                       ");
        System.out.println(" |_   _|         | (_)                      ");
        System.out.println("   | |  _ __   __| |_  __ _ _ __   __ _     ");
        System.out.println("   | | | '_ \\ / _` | |/ _` | '_ \\ / _` |    ");
        System.out.println("  _| |_| | | | (_| | | (_| | | | | (_| |    ");
        System.out.println(" |_____|_| |_|\\__,_|_|\\__,_|_| |_|\\__,_|    ");
        System.out.println("                                            ");
        System.out.println("        J O N E S  E X P E D I T I O N      ");
        System.out.println(RESET);
    }
}