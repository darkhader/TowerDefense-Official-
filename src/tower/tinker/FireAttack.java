/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.tinker;

import base.Attribute;
import base.FrameCounter;
import base.GameObjManager;

/**
 *
 * @author Hiep Nguyen
 */
public class FireAttack implements Attribute<Fire> {

    private FrameCounter frameCounter;

    public FireAttack() {
        this.frameCounter = new FrameCounter(1);

    }

    public void run(Fire gameObject) {

        if (this.frameCounter.run()) {
            BulletFire bulletTinker = GameObjManager.instance.recycle(BulletFire.class);
            bulletTinker.position.set(gameObject.position.x - 25, gameObject.position.y - 2);
          
                this.frameCounter.reset();
            
        }
    }

}
