/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.enemy;

import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import tower.Snow.Goku;
import tower.machineGun.MachineGun;
import tower.missile.MissileGun;

/**
 *
 * @author Hiep Nguyen
 */
public class Alien extends GameObject implements PhysicBody {

    public static int a = 0;
    public Vector2D velocity;
    private int count = 5;
    public BoxCollider boxCollider;
    public FrameCounter frameCounter1 = new FrameCounter(
            this.random.nextInt(10)
            + 95);//300
    public FrameCounter frameCounter2 = new FrameCounter(
            this.random.nextInt(8)
            + 60);//200
    public FrameCounter frameCounter3 = new FrameCounter(
            this.random.nextInt(7)
            + 65);//200
    public FrameCounter frameCounter4 = new FrameCounter(
            this.random.nextInt(10)
            + 120);//400
    public FrameCounter frameCounter5 = new FrameCounter(
            this.random.nextInt(5)
            + 103);//300
    public FrameCounter frameCounter6 = new FrameCounter(
            this.random.nextInt(5)
            + 60);//200

    public Alien() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/Alien-Ship.png", 20, 20);
        this.boxCollider = new BoxCollider(20, 20);
        this.damage = 1;
        this.health = 5;
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.getInsight(this);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);

        this.velocity.set(3, 0);
        if (this.frameCounter1.run()) {//di xuong 300 300
            this.velocity.set(0, 3);
            if (this.frameCounter2.run()) {//re phai 300 500
                this.velocity.set(3, 0);
                if (frameCounter3.run()) {//di len 500 500
                    this.velocity.set(0, -3);
                    if (frameCounter4.run()) {//re phai 500 100 
                        this.velocity.set(3, 0);
                        if (frameCounter5.run()) {//di xuong 800 100
                            this.velocity.set(0, 3);
                            if (frameCounter6.run()) {//re phai 800 300
                                this.velocity.set(3, 0);
                            }
                        }
                    }
                }
            }

        }
     

    }

    @Override
    public void getHit(GameObject gameObject) {
        this.health -= gameObject.damage;
        if (health <= 0) {
            this.isAlive = false;
            
            GameObjManager.instance.allEnemyDied+=1;
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
