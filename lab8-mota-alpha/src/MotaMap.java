import lattices.Lattice;
import lattices.Player;

public class MotaMap {
    private Lattice[][] lattices;
    private Player player;

    public MotaMap(Lattice[][] lattices, Player player) {
        this.lattices = lattices;
        this.player = player;
    }

    // 勇者确定目标后更新地图
    public void update(int[] targetPosition) {
        Lattice target = lattices[targetPosition[0]][targetPosition[1]];
        target.affectWith(player);
    }

    public void print() {
        int row = lattices.length;
        int column = lattices[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (player.isOnThePosition(i, j)) {
                    System.out.print(player.getAppearance());
                } else {
                    System.out.print(lattices[i][j].getAppearance());
                }
            }
            // 换行
            System.out.println();
        }
    }
}
