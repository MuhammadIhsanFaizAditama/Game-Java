package entities;

import items.Item;

public class Player {
    // ENCAPSULATION: Semua data pemain dirahasiakan
    private String nama;
    private int hp;
    private int maxHp;
    private Inventory tas; // Pemain memiliki satu objek Inventory

    // Constructor
    public Player(String nama, int maxHp, int kapasitasTas) {
        this.nama = nama;
        this.maxHp = maxHp;
        this.hp = maxHp; // Darah awal selalu penuh
        this.tas = new Inventory(kapasitasTas); // Membuat tas baru saat pemain dibuat
    }

    // --- LOGIKA HP (HEALTH POINTS) ---

    public void terimaDamage(int damage) {
        this.hp -= damage;
        System.out.println("ARGH! " + this.nama + " terkena jebakan! (-" + damage + " HP)");
        
        // Validasi Encapsulation: HP tidak boleh di bawah 0
        if (this.hp < 0) {
            this.hp = 0;
        }
        System.out.println("Sisa HP: " + this.hp + "/" + this.maxHp);
    }

    public void heal(int jumlahHeal) {
        this.hp += jumlahHeal;
        System.out.println(this.nama + " memulihkan diri. (+" + jumlahHeal + " HP)");
        
        // Validasi Encapsulation: HP tidak boleh melebihi maxHp
        if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    }

    public boolean isMati() {
        return this.hp <= 0;
    }

    // --- JEMBATAN KE INVENTORY ---
    // Pemain tidak mengakses list tas secara langsung, tapi menyuruh objek 'tas' yang bekerja

    public void ambilBarang(Item item) {
        this.tas.tambahItem(item);
    }

    public boolean cekTasUntukSolusi(String idItemDicari) {
        return this.tas.punyaItem(idItemDicari);
    }

    public void cekInventory() {
        this.tas.tampilkanIsiTas();
    }


    public int getHp() {
        return this.hp;
    }
}