/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.tinker;

import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import game.enemy.Alien;
import game.enemy.LinhKa;
import game.enemy.Meteor;
import game.enemyMap2.AlienMap2;
import game.enemyMap2.LinhKaMap2;
import game.enemyMap2.MeteorMap2;

import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class BulletFire extends GameObject implements PhysicBody {

    private int count = 5;
    public Vector2D velocity;
    private BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private RunHitObject runHitObject1;
    private RunHitObject runHitObjectLinhKa;

    private FrameCounter frameCounter;

    public BulletFire() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/fire.png", 5, 5);
        this.boxCollider = new BoxCollider(5, 5);
        this.runHitObject = new RunHitObject(Alien.class);
        this.runHitObject1 = new RunHitObject(Meteor.class);
        this.runHitObjectLinhKa = new RunHitObject(LinhKa.class);

        this.frameCounter = new FrameCounter(50);
        this.damage = 1;

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 2.5f, this.position.y - 2.5f);
        this.runHitObject.run(this);
        this.runHitObject1.run(this);
        this.runHitObjectLinhKa.run(this);

        this.velocity.set(0, 0);
        Alien alienMap1 = GameObjManager.instance.findAlien4();
        Meteor meteorMap1 = GameObjManager.instance.findMeteor4();
        LinhKa linhKaMap1 = GameObjManager.instance.findLinhKa4();
        Fire fire = GameObjManager.instance.findFireGun();
        if (meteorMap1 != null || alienMap1 != null || linhKaMap1 != null ) {
            if (fire.position.x > 530 && fire.position.x < 630 && fire.position.y > 125 && fire.position.y < 545) {
                this.updateVelocity();
            }
            if (fire.position.x > 340 && fire.position.x < 400 && fire.position.y > 250 && fire.position.y < 440) {
                this.updateVelocity();
            }
            if (fire.position.x > 850 && fire.position.x < 900 && fire.position.y > 80 && fire.position.y < 240) {
                this.updateVelocity();
            }

            if (fire.position.x > 410 && fire.position.x < 470 && fire.position.y > 125 && fire.position.y < 545) {
                this.updateVelocity1();
            }
            if (fire.position.x > 200 && fire.position.x < 280 && fire.position.y > 330 && fire.position.y < 520) {
                this.updateVelocity1();
            }
            if (fire.position.x > 740 && fire.position.x < 800 && fire.position.y > 125 && fire.position.y < 310) {
                this.updateVelocity1();
            }

            if (fire.position.x > 0 && fire.position.x < 280 && fire.position.y > 320 && fire.position.y < 380) {
                this.updateVelocity2();
            }
            if (fire.position.y > 490 && fire.position.x > 270 && fire.position.x < 540) {
                this.updateVelocity2();
            }
            if (fire.position.x >= 630 && fire.position.x <= 740 && fire.position.y > 125 && fire.position.y < 200) {
                this.updateVelocity2();
            }
            if (fire.position.x >= 800 && fire.position.x <= 1000 && fire.position.y > 330 && fire.position.y < 400) {
                this.updateVelocity2();
            }

            if (fire.position.y > 220 && fire.position.y < 260 && fire.position.x < 340) {
                this.updateVelocity3();
            }

            if (fire.position.y < 76 && fire.position.x > 460 && fire.position.x < 860) {
                this.updateVelocity3();
            }
            if (fire.position.y > 200 && fire.position.y < 256 && fire.position.x >= 900 && fire.position.x < 960) {
                this.updateVelocity3();
            }

        }

        if (frameCounter.run()) {
            this.isAlive = false;
            this.frameCounter.reset();
        }
    }

    public void updateVelocity() {

        this.velocity.set(random.nextInt(3) - 3, random.nextInt(3) - 1);
        if (count == 4) {
            this.velocity.set(random.nextInt(3) - 3, random.nextInt(3) - 1);
        }
        if (count == 3) {
            this.velocity.set(random.nextInt(3) - 3, random.nextInt(3) - 1);
        }
        if (count == 2) {
            this.velocity.set(random.nextInt(3) - 3, random.nextInt(3) - 1);
        }
        if (count == 1) {
            this.velocity.set(random.nextInt(3) - 3, random.nextInt(3) - 1);
        }
    }

    public void updateVelocity1() {

        this.velocity.set(random.nextInt(3), random.nextInt(3) - 1);
        if (count == 4) {
            this.velocity.set(random.nextInt(3), random.nextInt(3) - 1);
        }
        if (count == 3) {
            this.velocity.set(random.nextInt(3), random.nextInt(3) - 1);
        }
        if (count == 2) {
            this.velocity.set(random.nextInt(3), random.nextInt(3) - 1);
        }
        if (count == 1) {
            this.velocity.set(random.nextInt(3), random.nextInt(3) - 1);
        }
    }

    public void updateVelocity2() {

        this.velocity.set(random.nextInt(3), random.nextInt(3) - 3);
        if (count == 4) {
            this.velocity.set(random.nextInt(3), random.nextInt(3) - 3);
        }
        if (count == 3) {
            this.velocity.set(random.nextInt(3), random.nextInt(3) - 3);
        }
        if (count == 2) {
            this.velocity.set(random.nextInt(3), random.nextInt(3) - 3);
        }
        if (count == 1) {
            this.velocity.set(random.nextInt(3), random.nextInt(3) - 3);
        }
    }

    public void updateVelocity3() {

        this.velocity.set(random.nextInt(3) - 1, random.nextInt(3));
        if (count == 4) {
            this.velocity.set(random.nextInt(3) - 1, random.nextInt(3));
        }
        if (count == 3) {
            this.velocity.set(random.nextInt(3) - 1, random.nextInt(3));
        }
        if (count == 2) {
            this.velocity.set(random.nextInt(3) - 1, random.nextInt(3));
        }
        if (count == 1) {
            this.velocity.set(random.nextInt(3) - 1, random.nextInt(3));
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        //gameObject.health -= this.damage;
        count--;
        if (count == 0) {
            this.isAlive = false;
        }

    }

    @Override
    public void getInsight(GameObject gameObject) {

    }
}
