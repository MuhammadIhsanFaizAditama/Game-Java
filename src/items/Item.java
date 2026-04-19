package items;

public abstract class Item {
    // Encapsulation: Field dibuat private
    private String nama;
    private String deskripsi;
    private String idItem; // Harus sama dengan itemSolusi di class Rintangan

    public Item(String nama, String deskripsi, String idItem) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.idItem = idItem;
    }

    // Method abstrak: Setiap item punya cara "pakai" yang berbeda
    public abstract void gunakan();

    // Getter untuk akses data (Encapsulation)
    public String getNama() { return nama; }
    public String getDeskripsi() { return deskripsi; }
    public String getIdItem() { return idItem; }
}