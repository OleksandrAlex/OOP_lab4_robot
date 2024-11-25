package classes;

import actionType.ActionType;

public class Action {
    private ActionType action;
    private int step_count = 0;
    public Action(ActionType action, int step_count) {
        this.action = action;
        this.step_count = step_count;
    }
}
