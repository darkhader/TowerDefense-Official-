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
import static java.lang.Math.random;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class BulletFire2 extends GameObject implements PhysicBody {

    private int count = 5;
    public Vector2D velocity;
    private BoxCollider boxCollider;
    private RunHitObject runHitObject2;
    private RunHitObject runHitObject12;
    private RunHitObject runHitObjectLinhKa2;
    private FrameCounter frameCounter;

    public BulletFire2() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/fire.png", 5, 5);
        this.boxCollider = new BoxCollider(5, 5);
 
        this.runHitObject2 = new RunHitObject(AlienMap2.class);
        this.runHitObject12 = new RunHitObject(MeteorMap2.class);
        this.runHitObjectLinhKa2 = new RunHitObject(LinhKaMap2.class);

        this.frameCounter = new FrameCounter(50);
        this.damage = 1;

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 2.5f, this.position.y - 2.5f);
     
        this.runHitObject2.run(this);
        this.runHitObject12.run(this);
        this.runHitObjectLinhKa2.run(this);
        this.velocity.set(0, 0);
  
        AlienMap2 alienMap2 = GameObjManager.instance.findAlienMap24();
        MeteorMap2 meteorMap2 = GameObjManager.instance.findMeteorMap24();
        LinhKaMap2 linhKaMap2 = GameObjManager.instance.findLinhKaMap24();
          if (linhKaMap2 != null) {
            this.updateVelocity(linhKaMap2.position);
        } else if (meteorMap2 != null) {
            this.updateVelocity(meteorMap2.position);
        } else if (alienMap2 != null) {
            this.updateVelocity(alienMap2.position);
        }
        else this.isAlive =false;
        if (frameCounter.run()) {
            this.isAlive = false;
            this.frameCounter.reset();
        }
    }

    public void updateVelocity(Vector2D position) {

           this.velocity.set(
                position.subtract(this.position).normalized()
        ).multiply(random.nextInt(2)+2);
        if (count == 4) {
            this.velocity.set(
                position.subtract(this.position).normalized()
        ).multiply(random.nextInt(2));
        }
        if (count == 3) {
             this.velocity.set(
                position.subtract(this.position).normalized()
        ).multiply(random.nextInt(2)+1);
        }
        if (count == 2) {
             this.velocity.set(
                position.subtract(this.position).normalized()
        ).multiply(random.nextInt(2));
        }
        if (count == 1) {
            this.velocity.set(
                position.subtract(this.position).normalized()
        ).multiply(random.nextInt(1)+2);
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
