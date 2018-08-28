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
    private FrameCounter frameCounter1;

    public FireAttack() {
        this.frameCounter = new FrameCounter(1);
        this.frameCounter1 = new FrameCounter(1);

    }

    public void run(Fire gameObject) {

        if (this.frameCounter.run() && GameObjManager.instance.hiep==1) {
            BulletFire bulletTinker = GameObjManager.instance.recycle(BulletFire.class);
            bulletTinker.position.set(gameObject.position.x, gameObject.position.y);
          
                this.frameCounter.reset();
            
        }
        if (this.frameCounter1.run() && GameObjManager.instance.hiep==0) {
            BulletFire2 bulletTinker2 = GameObjManager.instance.recycle(BulletFire2.class);
            bulletTinker2.position.set(gameObject.position.x,gameObject.position.y);
          
            this.frameCounter1.reset();
        }
    }

}
