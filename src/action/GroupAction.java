/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import base.GameObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Hiep Nguyen
 */
public class GroupAction implements Action {

    private List<Action> actions;
 

    public GroupAction(Action... actions) {
        this.actions = Arrays.asList(actions);

    }

    @Override
    public boolean run(GameObject owner) {
        this.actions.removeIf(action -> action.run(owner));
        return this.actions.isEmpty();
    }
    
    @Override
    public void reset() {
  
    }
    
}
