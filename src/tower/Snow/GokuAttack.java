/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.Snow;

import base.Attribute;
import base.FrameCounter;
import base.GameObjManager;

/**
 *
 * @author Hiep Nguyen
 */
public class GokuAttack implements Attribute<Goku> {

    private FrameCounter frameCounter;

    public GokuAttack() {
        this.frameCounter = new FrameCounter(100);

    }

    @Override
    public void run(Goku gameObject) {
        if (this.frameCounter.run()) {
            Kamejoko kamejoko = GameObjManager.instance.recycle(Kamejoko.class);
            kamejoko.position.set(gameObject.position.x - 10, gameObject.position.y - 2);

            this.frameCounter.reset();

        }
    }

}
