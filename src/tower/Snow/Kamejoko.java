/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.Snow;

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
public class Kamejoko extends GameObject implements PhysicBody {

    public Vector2D velocity;
    private BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private RunHitObject runHitObjectMeteor;
    private RunHitObject runHitObjectLinhKa;
    private FrameCounter frameCounter;
    private RunHitObject runHitObject2;
    private RunHitObject runHitObject12;
    private RunHitObject runHitObjectLinhKa2;

    public Kamejoko() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/kamekameha.png", 20, 20);
        this.boxCollider = new BoxCollider(20, 20);
        this.frameCounter = new FrameCounter(100);
        this.runHitObject = new RunHitObject(Alien.class);
        this.runHitObjectMeteor = new RunHitObject(Meteor.class);
        this.runHitObjectLinhKa = new RunHitObject(LinhKa.class);
        this.runHitObject2 = new RunHitObject(AlienMap2.class);
        this.runHitObject12 = new RunHitObject(MeteorMap2.class);
        this.runHitObjectLinhKa2 = new RunHitObject(LinhKaMap2.class);

        this.damage = 100;

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        this.runHitObject.run(this);
        this.runHitObjectMeteor.run(this);
        this.runHitObjectLinhKa.run(this);
        this.runHitObject2.run(this);
        this.runHitObject12.run(this);
        this.runHitObjectLinhKa2.run(this);
        this.velocity.set(0, 0);
        Alien alienMap1 = GameObjManager.instance.findAlien2();
        Meteor meteorMap1 = GameObjManager.instance.findMeteor2();
        LinhKa linhKaMap1 = GameObjManager.instance.findLinhKa2();
        AlienMap2 alienMap2 = GameObjManager.instance.findAlienMap22();
        MeteorMap2 meteorMap2 = GameObjManager.instance.findMeteorMap22();
        LinhKaMap2 linhKaMap2 = GameObjManager.instance.findLinhKamap22();

        if (alienMap1 != null) {
            this.update(alienMap1.position);
        } else if (meteorMap1 != null) {
            this.update(meteorMap1.position);
        } else if (meteorMap1 != null && alienMap1 != null && linhKaMap1 != null) {
            this.update(linhKaMap1.position);
        } else if (alienMap2 != null) {
            this.update(alienMap2.position);
        } else if (meteorMap2 != null) {
            this.update(meteorMap2.position);
        } else if (meteorMap2 != null && alienMap2 != null && linhKaMap2 != null) {
            this.update(linhKaMap2.position);
        }
        if (this.frameCounter.run()) {
            this.isAlive = false;
            this.frameCounter.reset();
        }
        if (this.isAlive = false) {
            this.frameCounter.reset();
        }

    }

    private void update(Vector2D position) {

        this.velocity.set(
                position.subtract(this.position).normalized()
        ).multiply(3);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public void getInsight(GameObject gameObject) {

    }
}
