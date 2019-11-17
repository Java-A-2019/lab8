package lattices;

public class Wall extends Lattice {

    public Wall() {
        super();
    }

    @Override
    public void affectWith(Player player) {
        System.out.println("撞墙了！");

    }

    @Override
    public String getAppearance() {
        return "墙";
    }
}
