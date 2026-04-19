package engine;

import entities.Player;
import items.*;
import obstacles.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameEngine {
    private Player indiana;
    private ArrayList<Rintangan> daftarLevel;
    private Scanner input;
    private int levelSaatIni; // Menyimpan informasi level yang sedang dimainkan

    // Constructor: Dijalankan pertama kali saat objek GameEngine dibuat
    public GameEngine() {
        // Membuat karakter utama (HP 100, Kapasitas Tas 5)
        indiana = new Player("Indiana Jones", 100, 5);
        input = new Scanner(System.in);
        levelSaatIni = 1;
        
        siapkanGame();
    }

    // Method private untuk menyiapkan kondisi awal permainan
    private void siapkanGame() {
        DisplayHandler.cetakInfo("Menyiapkan perlengkapan ekspedisi...");
        
        // Menambahkan item awal ke dalam tas pemain
        indiana.ambilBarang(new Tool("Tali Tambang", "Tali tambang tebal sepanjang 15 meter.", "TALI_01", 3));
        indiana.ambilBarang(new Weapon("Cambuk Kulit", "Cambuk andalan keluarga Jones.", "CAMBUK_01", 20));
        
        // Memuat rintangan Level 1 dari LevelManager
        daftarLevel = LevelManager.muatLevel1();
    }

    // Method utama yang akan dipanggil oleh Main.java untuk memulai permainan
    public void mulai() {
        DisplayHandler.bersihkanLayar();
        DisplayHandler.tampilkanLogo();
        DisplayHandler.cetakJudul("Misi Dimulai: Harta Karun Suku Maya");
        
        // Menampilkan narasi awal
        LevelManager.putarNarasi(levelSaatIni);
        System.out.println("\nTekan ENTER untuk memulai petualangan...");
        input.nextLine();

        // Game Loop Utama: Akan terus berjalan selama pemain hidup
        while (!indiana.isMati()) {
            
            // Loop untuk setiap rintangan di level saat ini
            for (int i = 0; i < daftarLevel.size(); i++) {
                
                // Cek kondisi pemain setiap berganti rintangan
                if (indiana.isMati()) {
                    DisplayHandler.cetakBahaya("GAME OVER! Indiana Jones telah gugur dalam ekspedisi.");
                    return; // Mengakhiri method mulai(), yang berarti game selesai
                }

                DisplayHandler.bersihkanLayar();
                Rintangan rintanganSaatIni = daftarLevel.get(i);
                
                // Menampilkan deskripsi rintangan
                rintanganSaatIni.tampilkanEncounter();

                // --- LOGIKA PENYELESAIAN RINTANGAN ---
                
                // 1. Jika rintangan adalah Jebakan Logika (Teka-teki)
                if (rintanganSaatIni instanceof JebakanLogika) {
                    JebakanLogika jebakan = (JebakanLogika) rintanganSaatIni;
                    boolean lolos = jebakan.selesaikanTekaTeki();
                    
                    if (!lolos) {
                        indiana.terimaDamage(jebakan.getDamage());
                    }
                } 
                // 2. Jika rintangan biasa (Butuh Item)
                else {
                    selesaikanRintanganFisik(rintanganSaatIni);
                }
                
                // Jeda sebelum rintangan berikutnya
                System.out.println("\nTekan ENTER untuk melanjutkan...");
                input.nextLine();
            }

            // --- LOGIKA PERPINDAHAN LEVEL ---
            if (!indiana.isMati()) {
                DisplayHandler.cetakSukses("Level " + levelSaatIni + " Selesai!");
                levelSaatIni++; 
                
                if (levelSaatIni == 2) {
                    DisplayHandler.bersihkanLayar();
                    LevelManager.putarNarasi(levelSaatIni);
                    daftarLevel = LevelManager.muatLevel2();
                    System.out.println("\nTekan ENTER untuk melanjutkan...");
                    input.nextLine();
                } else if (levelSaatIni == 3) {
                    DisplayHandler.bersihkanLayar();
                    LevelManager.putarNarasi(levelSaatIni);
                    daftarLevel = LevelManager.muatLevel3();
                    System.out.println("\nTekan ENTER untuk kabur...");
                    input.nextLine();
                } else {
                    DisplayHandler.bersihkanLayar();
                    DisplayHandler.cetakSukses("SELAMAT! Indiana Jones berhasil lolos dari reruntuhan dengan Patung Emas Suku Maya!");
                    DisplayHandler.cetakInfo("Sisa HP: " + indiana.getHp()); // Jangan lupa pastikan kamu membuat getHp() di Player.java
                    return; 
                }
            }
        }
    }

    // Method bantuan untuk menangani rintangan yang membutuhkan item
    // Method bantuan untuk menangani rintangan yang membutuhkan item
    private void selesaikanRintanganFisik(Rintangan r) {
        // Tampilkan isi tas pemain
        indiana.cekInventory();
        
        System.out.println("\nPilihan Aksi:");
        System.out.println("1. Gunakan Item (Ketik ID Item, contoh: TALI_01)");
        System.out.println("2. Terobos dengan tangan kosong (Ketik 'LARI')");
        System.out.print("> Keputusanmu: ");
        
        String pilihan = input.nextLine();

        // --- BAGIAN YANG KAMU TANYAKAN ADA DI SINI ---
        if (pilihan.equalsIgnoreCase("LARI")) {
            if (r.getItemSolusi().equalsIgnoreCase("LARI")) {
                 DisplayHandler.cetakSukses("Kamu berlari sekuat tenaga dan berhasil lolos!");
            } else {
                 DisplayHandler.cetakBahaya("Kamu mencoba menerobos tanpa pikir panjang!");
                 indiana.terimaDamage(r.getDamage());
            }
        } 
        // ----------------------------------------------
        
        else if (indiana.cekTasUntukSolusi(pilihan)) {
            // Pemain punya item di tas, cek apakah cocok
            if (pilihan.equalsIgnoreCase(r.getItemSolusi())) {
                DisplayHandler.cetakSukses("Keputusan tepat! Rintangan berhasil dilewati dengan aman.");
            } else {
                DisplayHandler.cetakBahaya("Item yang kamu gunakan tidak memberikan efek! Rintangan memakan korban.");
                indiana.terimaDamage(r.getDamage());
            }
        } 
        else {
            // Pemain mengetik ID item yang tidak ada di tas
            DisplayHandler.cetakBahaya("Kamu tidak memiliki item dengan ID tersebut di tasmu!");
            indiana.terimaDamage(r.getDamage());
        }
    }
}