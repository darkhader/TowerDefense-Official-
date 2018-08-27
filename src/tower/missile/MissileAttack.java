/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.missile;

import base.Attribute;
import base.FrameCounter;
import base.GameObjManager;

/**
 *
 * @author Hiep Nguyen
 */
public class MissileAttack implements Attribute<MissileGun> {

    private FrameCounter frameCounter;
    private FrameCounter frameCounter1;

    public MissileAttack() {
        this.frameCounter = new FrameCounter(70);
        this.frameCounter1 = new FrameCounter(80);

    }

    @Override
    public void run(MissileGun gameObject) {
        if (this.frameCounter.run() && GameObjManager.instance.hiep==0) {
            Missile missile = GameObjManager.instance.recycle(Missile.class);
            missile.position.set(gameObject.position.x - 25, gameObject.position.y - 2);
            this.frameCounter.reset();
        }
        if (this.frameCounter1.run() && GameObjManager.instance.hiep==0) {
            Missile missile1 = GameObjManager.instance.recycle(Missile.class);
            missile1.position.set(gameObject.position.x - 25, gameObject.position.y - 2);
            this.frameCounter1.reset();
        }
        if (this.frameCounter.run() && GameObjManager.instance.hiep==1) {
            Missile2 missile2 = GameObjManager.instance.recycle(Missile2.class);
            missile2.position.set(gameObject.position.x - 25, gameObject.position.y - 2);
            this.frameCounter.reset();
        }
        if (this.frameCounter1.run() && GameObjManager.instance.hiep==1) {
            Missile2 missile12 = GameObjManager.instance.recycle(Missile2.class);
            missile12.position.set(gameObject.position.x - 25, gameObject.position.y - 2);
            this.frameCounter1.reset();
        }
    }

}
