/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import base.GameObject;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Hiep Nguyen
 */
public class SequenceAction implements Action {

    private List<Action> actions;
    private int currentIndex;

    public SequenceAction(Action... actions) {
        this.actions = Arrays.asList(actions);
    }

    public boolean run(GameObject owner) {
        Action action = this.actions.get(currentIndex);
        if (action.run(owner)) {
            if (this.currentIndex == this.actions.size() - 1) {
                return true;
            } else {
                currentIndex += 1;
            }
        }
        return false;
    }

    @Override
    public void reset() {
        this.actions.forEach(action -> action.reset());
        currentIndex = 0;
    }

}
