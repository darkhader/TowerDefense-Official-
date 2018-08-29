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
public class Fire extends GameObject implements PhysicBody{
        
    public Fire() {
        this.position.set(PlayerBuild.c, PlayerBuild.d);
        this.renderer = new ImageRenderer("resources/images/laser-gun.png", 30, 30);
        this.attributes.add(new FireAttack());
        this.money = 50;
    }

    public void run() {	
        super.run();
        this.getInsight(this);

    }

    @Override
    public BoxCollider getBoxCollider() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getHit(GameObject gameObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getInsight(GameObject gameObject) {
        Alien machine = GameObjManager.instance.findAlien4();
        if (machine != null) {
            if (Math.sqrt(Math.pow((machine.position.x - this.position.x), 2)
                    + Math.pow((machine.position.y - this.position.y), 2)) < 100) {
                this.inAction1 = true;
            } else {
                this.inAction1 = false;
            }

        }
        Meteor goku = GameObjManager.instance.findMeteor4();
        if (goku != null) {
            if (Math.sqrt(Math.pow((goku.position.x - this.position.x), 2)
                    + Math.pow((goku.position.y - this.position.y), 2)) < 100) {
                this.inAction1 = true;
            } else {
                this.inAction1 = false;
            }

        }
        LinhKa missileGun = GameObjManager.instance.findLinhKa4();
        if (missileGun != null) {
            float d = (float) Math.sqrt(Math.pow((missileGun.position.x - this.position.x), 2)
                    + Math.pow((missileGun.position.y - this.position.y), 2));
            if (d < 100) {
                this.inAction1 = true;
            } else {
                this.inAction1 = false;
            }

        }
      
    }
}


