package lattices;

public class Player {
    private int[] position;
    private int[] nextPosition;

    public Player(int[] position) {
        this.position = position;
        this.nextPosition = new int[position.length];
    }

    public int[] willMoveTo(DirectionEnum direction) {
        int[] increments = direction.getIncrements();
        nextPosition[0] = position[0] + increments[0];
        nextPosition[1] = position[1] + increments[1];
        return nextPosition;
    }

    public void move() {
        position[0] = nextPosition[0];
        position[1] = nextPosition[1];
    }

    public boolean isOnThePosition(int positionX, int positionY) {
        return position[0] == positionX && position[1] == positionY;
    }

    public int[] getPosition() {
        return position;
    }

    public String getAppearance() {
        return "勇";
    }
}
