package classes;

import interfaces.Rotetable;

public class RotRobot extends Robot implements Rotetable {
    private int start_angle, end_angle;
    private boolean rotatingForward = true; // напрямок обертання

    public RotRobot(int x, int y, int course, int start_angle, int end_angle) {
        super(x, y, course);
        this.start_angle = start_angle;
        this.end_angle = end_angle;
    }

    @Override
    public void rotateForward() {
        course = (course + step_angle) % 360;
        System.out.println("Робот повертається вперед, кут: " + course);
    }

    @Override
    public void rotateBackward() {
        course = (course - step_angle + 360) % 360;
        System.out.println("Робот повертається назад, кут: " + course);
    }

    @Override
    public void move() {
        if (rotatingForward && course < end_angle) {
            rotateForward();
        } else if (!rotatingForward && course > start_angle) {
            rotateBackward();
        } else {
            rotatingForward = !rotatingForward; // змінюємо напрямок
        }
        doSomething();
    }
}
