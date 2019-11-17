package lattices;

public class Lattice {

    public Lattice() {
    }

    public void affectWith(Player player) {
        player.move();
    }

    public String getAppearance() {
        return "空";
    }
}
