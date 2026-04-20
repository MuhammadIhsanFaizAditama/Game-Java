package entities;

import items.Item;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> daftarItem;
    private int kapasitasMaksimal;

    // Constructor
    public Inventory(int kapasitas) {
        this.daftarItem = new ArrayList<>();
        this.kapasitasMaksimal = kapasitas;
    }

    // Method resmi untuk menambah item (Pintu masuk data)
    public boolean tambahItem(Item barangBaru) {
        if (daftarItem.size() < kapasitasMaksimal) {
            daftarItem.add(barangBaru);
            System.out.println("[+] " + barangBaru.getNama() + " dimasukkan ke dalam tas.");
            return true;
        } else {
            System.out.println("[!] Tas penuh! Tidak bisa membawa " + barangBaru.getNama());
            return false;
        }
    }

    // Method untuk mengecek apakah pemain punya item yang dibutuhkan rintangan
    public boolean punyaItem(String idItemDicari) {
        for (Item barang : daftarItem) {
            if (barang.getIdItem().equalsIgnoreCase(idItemDicari)) {
                return true; // Item ditemukan!
            }
        }
        return false; // Item tidak ada di tas
    }

// Menampilkan isi tas ke terminal
    public void tampilkanIsiTas() {
        System.out.println("\n=== ISI TAS (" + daftarItem.size() + "/" + kapasitasMaksimal + ") ===");
        if (daftarItem.isEmpty()) {
            System.out.println("(Tas Kosong)");
        } else {
            for (int i = 0; i < daftarItem.size(); i++) {
                System.out.println((i + 1) + ". [" + daftarItem.get(i).getIdItem() + "] " 
                                   + daftarItem.get(i).getNama() + 
                                   " - " + daftarItem.get(i).getDeskripsi());
            }
        }
        System.out.println("=====================");
    }
}