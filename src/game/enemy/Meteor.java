/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.enemy;

import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import tower.Snow.Goku;
import tower.Snow.Kamejoko;
import tower.machineGun.MachineGun;
import tower.missile.MissileGun;


/**
 *
 * @author Hiep Nguyen
 */
public class Meteor extends GameObject implements PhysicBody {
    
    public Vector2D velocity;
    private int count = 10;
    public BoxCollider boxCollider;

    public Meteor() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources\\images\\comet.png", 50, 50);
        this.boxCollider = new BoxCollider(50, 50);
        this.damage = 10;
        this.health = 10;
    }
    
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.getInsight(this);
       
        this.boxCollider.position.set(this.position.x - 25, this.position.y - 25);

        
       if (this.position.x < 300) {
            this.velocity.set(1, 0);
        }
        if (this.position.x == 300 && this.position.y == 280) {//di xuong 300 300
            this.velocity.set(0, 2);
        }
        if (this.position.y == 480 && this.position.x == 300) {//re phai 300 500
            this.velocity.set(2,0);
        }
        if (this.position.x == 500 && this.position.y == 480) {//di len 500 500
            this.velocity.set(0, -2);
        }
        if (this.position.y == 100 && this.position.x == 500) {//re phai 500 100 
            this.velocity.set(2, 0);
        }
        if (this.position.x == 830 && this.position.y == 100) {//di xuong 800 100
            this.velocity.set(0, 2);
        }
        if (this.position.y == 300 && this.position.x == 830) {//re phai 800 300
            this.velocity.set(2, 0);
        }

    }
    
    @Override
    public void getHit(GameObject gameObject) {
        this.health -= gameObject.damage;
        if (health <= 0) {
            this.isAlive = false;
            GameObjManager.instance.allEnemyDied +=10;
        }
        if(gameObject instanceof Kamejoko){
            this.velocity.set(0, 0);
        }
    }
    

    
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
    
    @Override
    public void getInsight(GameObject gameObject) {
        MachineGun machine = GameObjManager.instance.findGun();
        if (machine != null) {
            if (Math.sqrt(Math.pow((machine.position.x - this.position.x), 2)
                    + Math.pow((machine.position.y - this.position.y), 2)) < 80) {
                this.inAction1 = true;
            } else {
                this.inAction1 = false;
            }
            
        }
    Goku goku = GameObjManager.instance.findGoku();
        if (goku != null) {
            if (Math.sqrt(Math.pow((goku.position.x - this.position.x), 2)
                    + Math.pow((goku.position.y - this.position.y), 2)) < 100) {
                this.inAction2 = true;
            } else {
                this.inAction2 = false;
            }

        }
      MissileGun missileGun = GameObjManager.instance.findMissileGun();
        if (missileGun != null) {
            float d = (float) Math.sqrt(Math.pow((missileGun.position.x - this.position.x), 2)
                    + Math.pow((missileGun.position.y - this.position.y), 2));
            if (d < 1000 && d > 500) {
                this.inAction3 = true;
            } else {
                this.inAction3 = false;
            }

        }
    }
}
