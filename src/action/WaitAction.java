/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import base.FrameCounter;
import base.GameObject;

/**
 *
 * @author Hiep Nguyen
 */
public class WaitAction implements Action {

    private FrameCounter frameCounter;

    public WaitAction(int timeInterval) {
        this.frameCounter = new FrameCounter(timeInterval);
    }

   
    public boolean run(GameObject owner) {
        return this.frameCounter.run();
    }

   
    public void reset() {
        this.frameCounter.reset();
    }

}
