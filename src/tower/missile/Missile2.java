/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.missile;

import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
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
public class Missile2 extends GameObject implements PhysicBody {

    public Vector2D velocity;
    private BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private RunHitObject runHitObjectMeteor;
    private RunHitObject runHitObjectLinhKa;


    public Missile2() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/Missile.png", 25, 15);
        this.boxCollider = new BoxCollider(25, 15);
        this.runHitObject = new RunHitObject(AlienMap2.class);
        this.runHitObjectMeteor = new RunHitObject(MeteorMap2.class);
        this.runHitObjectLinhKa = new RunHitObject(LinhKaMap2.class);

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

        AlienMap2 alienMap2 = GameObjManager.instance.findAlienMap23();
        MeteorMap2 meteorMap2 = GameObjManager.instance.findMeteorMap23();
        LinhKaMap2 linhKaMap2 = GameObjManager.instance.findLinhKaMap23();

        if (alienMap2 != null && meteorMap2 == null && linhKaMap2 == null) {
            this.update(alienMap2.position);
        }

        if (meteorMap2 != null && alienMap2 == null && linhKaMap2 == null) {
            this.update(meteorMap2.position);
        }
        if (alienMap2 != null && meteorMap2 != null && linhKaMap2 == null) {
            this.update(meteorMap2.position);
        }
        if (alienMap2 != null && meteorMap2 != null && linhKaMap2 != null) {
            this.update(linhKaMap2.position);
        }
        if (alienMap2 == null && meteorMap2 != null && linhKaMap2 != null) {
            this.update(linhKaMap2.position);
        }
        if (alienMap2 != null && meteorMap2 == null && linhKaMap2 != null) {
            this.update(linhKaMap2.position);
        }
        if (alienMap2 == null && meteorMap2 == null && linhKaMap2 != null) {
            this.update(linhKaMap2.position);
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
