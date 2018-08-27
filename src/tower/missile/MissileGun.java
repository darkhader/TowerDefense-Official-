/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.missile;

import base.GameObject;
import player.PlayerBuild;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class MissileGun extends GameObject {

  

    /**
     * Constructor
     */
    
    public MissileGun() {
        this.position.set(PlayerBuild.e, PlayerBuild.f);
        this.renderer = new ImageRenderer("resources/images/canon.png", 30, 30);
        this.attributes.add(new MissileAttack());
    }

    public void run() {	
        super.run();

    }
}

