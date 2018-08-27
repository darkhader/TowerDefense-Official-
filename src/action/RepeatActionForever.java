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
public class RepeatActionForever implements Action {

    public Action action;

    public RepeatActionForever(Action action) {
        this.action = action;
    }

    @Override
    public boolean run(GameObject owner) {
        if (this.action.run(owner)) {
            this.action.reset();
        }
        return false;
    }

    @Override
    public void reset() {

    }

}
