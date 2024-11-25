package interfaces;

public interface Shiftable extends Movable {
    public static final int step_shift = 1;
    public void shiftForward();
    public void shiftBackward();
}
