package main;

// Mengimpor class GameEngine dari package 'engine'
import engine.GameEngine;

public class Main {
    
    // Method khusus yang otomatis dijalankan pertama kali oleh Java
    public static void main(String[] args) {
        
        // 1. Membuat "mesin" permainannya
        GameEngine indianaJonesGame = new GameEngine();
        
        // 2. Menyalakan mesinnya
        indianaJonesGame.mulai();
        
        // 3. Menutup program dengan aman saat game selesai
        System.out.println("\n[Sistem Game Dimatikan. Terima Kasih Telah Bermain!]");
        System.exit(0); 
    }
}