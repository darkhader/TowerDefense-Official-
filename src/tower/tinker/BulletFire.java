/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.tinker;

import base.FrameCounter;
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
    private RunHitObject runHitObject2;
    private RunHitObject runHitObject12;
    private RunHitObject runHitObjectLinhKa2;
    private FrameCounter frameCounter;

    public BulletFire() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/fire.png", 5, 5);
        this.boxCollider = new BoxCollider(5, 5);
        this.runHitObject = new RunHitObject(Alien.class);
        this.runHitObject1 = new RunHitObject(Meteor.class);
        this.runHitObjectLinhKa = new RunHitObject(LinhKa.class);
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
        this.runHitObject.run(this);
        this.runHitObject1.run(this);
        this.runHitObjectLinhKa.run(this);
        this.runHitObject2.run(this);
        this.runHitObject12.run(this);
        this.runHitObjectLinhKa2.run(this);
        this.velocity.set(0, 0);

        this.updateVelocity();

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
