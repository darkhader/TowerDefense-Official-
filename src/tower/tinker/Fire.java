/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.tinker;

import base.GameObject;
import player.PlayerBuild;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class Fire extends GameObject{
        
    public Fire() {
        this.position.set(PlayerBuild.c, PlayerBuild.d);
        this.renderer = new ImageRenderer("resources/images/laser-gun.png", 30, 30);
        this.attributes.add(new FireAttack());
        this.money = 50;
    }

    public void run() {	
        super.run();

    }
}


