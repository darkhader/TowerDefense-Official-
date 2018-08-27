/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import base.GameObject;

/**
 *
 * @author Hiep Nguyen
 */
public class LimitAction implements Action {

    private Action action;
    private int max;

    public LimitAction(int max, Action action) {
        this.action = action;
        this.max = max;
    }

    @Override
    public boolean run(GameObject owner) {
        if (this.action.run(owner)) {
            this.action.reset();
            this.max -= 1;
        }
        return this.max == 1;
    }

    @Override
    public void reset() {

    }

}
