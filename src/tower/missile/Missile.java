/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.missile;

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
public class Missile extends GameObject implements PhysicBody {

    public Vector2D velocity;
    private BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private RunHitObject runHitObjectMeteor;
    private RunHitObject runHitObjectLinhKa;

    public Missile() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/Missile.png", 25, 15);
        this.boxCollider = new BoxCollider(25, 15);
        this.runHitObject = new RunHitObject(Alien.class);
        this.runHitObjectMeteor = new RunHitObject(Meteor.class);
        this.runHitObjectLinhKa = new RunHitObject(LinhKa.class);

        this.damage = 10;
        this.money = 50;
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 12.5f, this.position.y - 7.5f);
        this.runHitObject.run(this);
        this.runHitObjectMeteor.run(this);
        this.runHitObjectLinhKa.run(this);
        this.velocity.set(0, 0);
        Alien alienMap1 = GameObjManager.instance.findAlien3();
        Meteor meteorMap1 = GameObjManager.instance.findMeteor3();
        LinhKa linhKaMap1 = GameObjManager.instance.findLinhKa3();
        if (alienMap1 == null && linhKaMap1 == null && meteorMap1 == null) {
            this.isAlive = false;
        }
        if (alienMap1 != null && meteorMap1 == null && linhKaMap1 == null) {
            this.update(alienMap1.position);
        }

        if (meteorMap1 != null && alienMap1 == null && linhKaMap1 == null) {
            this.update(meteorMap1.position);
        }
        if (alienMap1 != null && meteorMap1 != null && linhKaMap1 == null) {
            this.update(meteorMap1.position);
        }
       if (alienMap1 != null && meteorMap1 != null && linhKaMap1 != null) {
            this.update(linhKaMap1.position);
        }
       if (alienMap1 == null && meteorMap1 != null && linhKaMap1 != null) {
            this.update(linhKaMap1.position);
        }
       if (alienMap1 != null && meteorMap1 == null && linhKaMap1 != null) {
            this.update(linhKaMap1.position);
        }
       if (alienMap1 == null && meteorMap1 == null && linhKaMap1 != null) {
            this.update(linhKaMap1.position);
        }
        
    }

    private void update(Vector2D position) {

        this.velocity.set(
                position.subtract(this.position).normalized()
        ).multiply(6);

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
