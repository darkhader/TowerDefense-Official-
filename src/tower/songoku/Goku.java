/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.songoku;

import base.GameObject;
import player.PlayerBuild;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class Goku extends GameObject{
        
    public Goku() {
        this.position.set(PlayerBuild.g, PlayerBuild.h);
        this.renderer = new ImageRenderer("resources/images/songoku.png", 25, 50);
        this.attributes.add(new GokuAttack());
        this.money = 100;
    }

    public void run() {	
        super.run();

    }
}