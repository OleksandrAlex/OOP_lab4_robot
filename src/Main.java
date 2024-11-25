import classes.Robot;
import classes.RotRobot;
import classes.ShiftRobot;
import classes.WalkRobot;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Тестування RotRobot
        RotRobot rotRobot = new RotRobot(0, 0, 0, 0, 180);
        System.out.println("Тестування RotRobot:");
        rotRobot.move();
        rotRobot.move();
        rotRobot.move();

        // Тестування ShiftRobot
        ShiftRobot shiftRobot = new ShiftRobot(0, 0, 0, 0, 5);
        System.out.println("\nТестування ShiftRobot:");
        shiftRobot.move();
        shiftRobot.move();
        shiftRobot.move();

        // Тестування WalkRobot
        WalkRobot walkRobot = new WalkRobot(0, 0, 0);
        walkRobot.setActionList(Arrays.asList(
                walkRobot.new Action(WalkRobot.ActionTypes.RotF, 1),
                walkRobot.new Action(WalkRobot.ActionTypes.ShiftF, 2),
                walkRobot.new Action(WalkRobot.ActionTypes.DoSomth, 1)
        ));

        System.out.println("\nТестування WalkRobot:");
        walkRobot.move();

        Robot customRobot = new Robot(0, 0, 0) {
            @Override
            public void doSomething() {
                System.out.println("Анонімний робот виконує спеціальну місію!");
            }
        };

        ShiftRobot specialShiftRobot = new ShiftRobot(0, 0, 0, 0, 5) {
            @Override
            public void shiftForward() {
                super.shiftForward();
                System.out.println("Special ShiftRobot: Здійснив спеціальний зсув!");
            }
        };

        System.out.println("\nТестування анонімного класу:");
        customRobot.doSomething();

        System.out.println("\nТестування спеціального ShiftRobot:");
        specialShiftRobot.move();

        System.out.println("\nТестування вкладеного класу Battery:");
        WalkRobot.Battery Bat = walkRobot.new Battery(50);
        System.out.println(Bat.getChargeLevel());
        //WalkRobot.Battery(50);
    }
}
