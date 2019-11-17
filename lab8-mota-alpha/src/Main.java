import lattices.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lattice[][] lattices = {
            {new Wall(), new Wall(), new Wall(), new Wall(), new Wall()},
            {new Wall(), new Lattice(), new Merchant(), new Stairs(), new Wall()},
            {new Wall(), new Lattice(), new Lattice(), new Lattice(), new Wall()},
            {new Wall(), new Material(), new Door(), new Monster(), new Wall()},
            {new Wall(), new Wall(), new Wall(), new Wall(), new Wall()}
        };
        int[] position = {1, 1};
        Player player = new Player(position);

        MotaMap motaMap = new MotaMap(lattices, player);
        motaMap.print();

        Scanner inputAction = new Scanner(System.in);
        String inputString;
        while (true) {
            inputString = inputAction.nextLine();
            switch (inputString) {
                case "exit":
                    System.exit(0);
                    break;
                case "w":
                    motaMap.update(player.willMoveTo(DirectionEnum.UP));
                    break;
                case "a":
                    motaMap.update(player.willMoveTo(DirectionEnum.LEFT));
                    break;
                case "s":
                    motaMap.update(player.willMoveTo(DirectionEnum.DOWN));
                    break;
                case "d":
                    motaMap.update(player.willMoveTo(DirectionEnum.RIGHT));
                    break;
                default:
                    System.out.println("无效指令");
                    break;
            }
            motaMap.print();
        }
    }
}
