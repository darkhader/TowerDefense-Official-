/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.machineGun;

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
public class BulletMachineGun extends GameObject implements PhysicBody {

    public Vector2D velocity;
    private BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private RunHitObject runHitObjectMeteor;
    private RunHitObject runHitObjectLinhKa;
   

    public BulletMachineGun() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/bullet.png", 7, 7);
        this.boxCollider = new BoxCollider(7, 7);
        this.runHitObject = new RunHitObject(Alien.class);
        this.runHitObjectMeteor = new RunHitObject(Meteor.class);
        this.runHitObjectLinhKa = new RunHitObject(LinhKa.class);
        
        this.damage = 1;

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 3.5f, this.position.y - 3.5f);
        this.runHitObject.run(this);
        this.runHitObjectMeteor.run(this);
        this.runHitObjectLinhKa.run(this);
        this.velocity.set(0, 0);
        Alien alienMap1 = GameObjManager.instance.findAlien1();
        Meteor meteorMap1 = GameObjManager.instance.findMeteor1();
        LinhKa linhKaMap1 = GameObjManager.instance.findLinhKa1();
        
        if (alienMap1 != null && meteorMap1 == null && linhKaMap1 == null) {
            this.update(alienMap1.position);
        }
        if (alienMap1 == null && linhKaMap1 == null && meteorMap1 == null) {
            this.isAlive = false;
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
//        if (alienMap2 != null && meteorMap2 == null && linhKaMap2 == null) {
//            this.update(alienMap2.position);
//        }
//        if (alienMap2 == null && linhKaMap2 == null && meteorMap2 == null) {
//            this.isAlive = false;
//        }
//        if (meteorMap2!= null && alienMap2 == null && linhKaMap2 == null) {
//            this.update(meteorMap2.position);
//        }
//        if (alienMap2 != null && meteorMap2 != null && linhKaMap2 == null) {
//            this.update(meteorMap2.position);
//        }
//        if (alienMap2 != null && meteorMap2 != null && linhKaMap2 != null) {
//            this.update(linhKaMap2.position);
//        }
     
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
