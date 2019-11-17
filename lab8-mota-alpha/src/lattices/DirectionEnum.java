package lattices;

public enum DirectionEnum {
    UP(new int[]{-1, 0}),
    DOWN(new int[]{1, 0}),
    LEFT(new int[]{0, -1}),
    RIGHT(new int[]{0, 1});

    private int[] increments;

    DirectionEnum(int[] increments) {
        this.increments = increments;
    }

    public int[] getIncrements() {
        return increments;
    }
}
