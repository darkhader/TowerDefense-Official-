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
public abstract class ActionAdapter implements Action
{

    public boolean run(GameObject owner) {
        return false;
    }

    public void reset() {
     
    }
    
}
