package classes;

import interfaces.Shiftable;

public class ShiftRobot extends Robot implements Shiftable {
    private int start_pos, end_pos;
    private boolean movingForward = true; // напрямок руху

    public ShiftRobot(int x, int y, int course, int start_pos, int end_pos) {
        super(x, y, course);
        this.start_pos = start_pos;
        this.end_pos = end_pos;
    }

    public class Position {
        private int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void showPosition() {
            System.out.println("Поточна позиція: (" + x + ", " + y + ")");
        }
    }

    @Override
    public void shiftForward() {
        if (course == 0) y += step_shift;
        else if (course == 90) x += step_shift;
        else if (course == 180) y -= step_shift;
        else if (course == 270) x -= step_shift;

        System.out.println("Робот пересувається вперед до позиції: (" + x + ", " + y + ")");
    }

    @Override
    public void shiftBackward() {
        if (course == 0) y -= step_shift;
        else if (course == 90) x -= step_shift;
        else if (course == 180) y += step_shift;
        else if (course == 270) x += step_shift;

        System.out.println("Робот пересувається назад до позиції: (" + x + ", " + y + ")");
    }

    @Override
    public void move() {
        if (movingForward && y < end_pos) {
            shiftForward();
        } else if (!movingForward && y > start_pos) {
            shiftBackward();
        } else {
            movingForward = !movingForward; // змінюємо напрямок
        }
        doSomething();
    }
}

