package items;

public class Weapon extends Item {
    private int damage;

    public Weapon(String nama, String deskripsi, String idItem, int damage) {
        super(nama, deskripsi, idItem);
        this.damage = damage;
    }

    @Override
    public void gunakan() {
        System.out.println("Mengayunkan " + getNama() + "! Memberikan " + damage + " damage.");
    }

    public int getDamage() { return damage; }
}