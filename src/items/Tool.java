package items;

public class Tool extends Item {
    private int jumlahPakai;

    public Tool(String nama, String deskripsi, String idItem, int jumlahPakai) {
        super(nama, deskripsi, idItem);
        this.jumlahPakai = jumlahPakai;
    }

    @Override
    public void gunakan() {
        if (jumlahPakai > 0) {
            jumlahPakai--;
            System.out.println("Menggunakan " + getNama() + ". Sisa penggunaan: " + jumlahPakai);
        } else {
            System.out.println(getNama() + " sudah rusak/habis!");
        }
    }
}