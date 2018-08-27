/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.machineGun;

import Scene.Map1Scene;
import Scene.SceneManager;
import base.Attribute;
import base.FrameCounter;
import base.GameObjManager;

/**
 *
 * @author Hiep Nguyen
 */
public class MachineGunAttack implements Attribute<MachineGun> {

    private FrameCounter frameCounter;
    private FrameCounter frameCounter1;


    public MachineGunAttack() {
        this.frameCounter = new FrameCounter(5);
        this.frameCounter1 = new FrameCounter(5);

    }

    public void run(MachineGun gameObject) {

        if (this.frameCounter.run() && GameObjManager.instance.hiep==0) {
            BulletMachineGun bulletMachineGun = GameObjManager.instance.recycle(BulletMachineGun.class);
            bulletMachineGun.position.set(gameObject.position.x-14,gameObject.position.y-1);
          
            this.frameCounter.reset();
        }
        if (this.frameCounter1.run() && GameObjManager.instance.hiep==1) {
            BulletMachineGun2 bulletMachineGun2 = GameObjManager.instance.recycle(BulletMachineGun2.class);
            bulletMachineGun2.position.set(gameObject.position.x-14,gameObject.position.y-1);
          
            this.frameCounter1.reset();
        }
    }

}
