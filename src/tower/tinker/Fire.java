/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.tinker;

import base.GameObjManager;
import base.GameObject;
import game.enemy.Alien;
import game.enemy.LinhKa;
import game.enemy.Meteor;
import physic.BoxCollider;
import physic.PhysicBody;
import player.PlayerBuild;
import renderer.ImageRenderer;
import tower.machineGun.MachineGun;
import tower.missile.MissileGun;
import tower.songoku.Goku;

/**
 *
 * @author Hiep Nguyen
 */
public class Fire extends GameObject {

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


