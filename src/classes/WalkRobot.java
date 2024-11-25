package classes;


import interfaces.Rotetable;
import interfaces.Shiftable;


import java.util.List;

public class WalkRobot extends Robot implements Rotetable, Shiftable {

    public enum ActionTypes { RotF, RotB, ShiftF, ShiftB, DoSomth }

    public class Action {
        private ActionTypes actionType;
        private int steps_count;

        public Action(ActionTypes actionType, int steps_count) {
            this.actionType = actionType;
            this.steps_count = steps_count;
        }

        public ActionTypes getActionType() { return actionType; }
        public int getStepsCount() { return steps_count; }
    }

    public class Battery {
        private int chargeLevel;

        public Battery(int initialCharge) {
            this.chargeLevel = initialCharge;
        }

        public int getChargeLevel() {
            return chargeLevel;
        }

        public void useEnergy(int amount) {
            if (chargeLevel >= amount) {
                chargeLevel -= amount;
                System.out.println("Використано " + amount + " одиниць енергії. Поточний рівень заряду: " + chargeLevel);
            } else {
                System.out.println("Недостатньо заряду! Поточний рівень: " + chargeLevel);
            }
        }

        public void recharge(int amount) {
            chargeLevel += amount;
            System.out.println("Батарея підзаряжена на " + amount + " одиниць. Поточний рівень заряду: " + chargeLevel);
        }
    }

    private List<Action> actionList;

    public WalkRobot(int x, int y, int course) {
        super(x, y, course);
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    public void viewActionList() {
        for (Action action : actionList) {
            System.out.println("Дія: " + action.getActionType() + ", кроків: " + action.getStepsCount());
        }
    }

    @Override
    public void rotateForward() {
        course = (course + step_angle) % 360;
        System.out.println("WalkRobot повертається вперед, кут: " + course);
    }

    @Override
    public void rotateBackward() {
        course = (course - step_angle + 360) % 360;
        System.out.println("WalkRobot повертається назад, кут: " + course);
    }

    @Override
    public void shiftForward() {
        if (course == 0) y += step_shift;
        else if (course == 90) x += step_shift;
        else if (course == 180) y -= step_shift;
        else if (course == 270) x -= step_shift;

        System.out.println("WalkRobot пересувається вперед до позиції: (" + x + ", " + y + ")");
    }

    @Override
    public void shiftBackward() {
        if (course == 0) y -= step_shift;
        else if (course == 90) x -= step_shift;
        else if (course == 180) y += step_shift;
        else if (course == 270) x += step_shift;

        System.out.println("WalkRobot пересувається назад до позиції: (" + x + ", " + y + ")");
    }

    @Override
    public void move() {
        for (Action action : actionList) {
            switch (action.getActionType()) {
                case RotF:
                    for (int i = 0; i < action.getStepsCount(); i++) rotateForward();
                    break;
                case RotB:
                    for (int i = 0; i < action.getStepsCount(); i++) rotateBackward();
                    break;
                case ShiftF:
                    for (int i = 0; i < action.getStepsCount(); i++) shiftForward();
                    break;
                case ShiftB:
                    for (int i = 0; i < action.getStepsCount(); i++) shiftBackward();
                    break;
                case DoSomth:
                    doSomething();
                    break;
            }
        }
    }
}
