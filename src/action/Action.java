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
public interface Action {
    
    boolean run(GameObject owner);
    void reset();
}
