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

        this.frameCounter = new FrameCounter(70);
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
    Alien alienMap1 = GameObjManager.instance.findAlien4();
        Meteor meteorMap1 = GameObjManager.instance.findMeteor4();
        LinhKa linhKaMap1 = GameObjManager.instance.findLinhKa4();
        AlienMap2 alienMap2 = GameObjManager.instance.findAlienMap24();
        MeteorMap2 meteorMap2 = GameObjManager.instance.findMeteorMap24();
        LinhKaMap2 linhKaMap2 = GameObjManager.instance.findLinhKaMap24();
        if(meteorMap1 !=null || alienMap1!=null || linhKaMap1!=null ||
                alienMap2!=null ||   meteorMap2!=null ||  linhKaMap2!=null){
            if(this.position.x>473 && this.position.x< 660 && this.position.y>100){
                this.updateVelocity();
            }
            if(this.position.x>278 && this.position.x< 380 && this.position.y>100 && this.position.y<485){
                this.updateVelocity();
            }
            if(this.position.x>800 && this.position.x< 900 && this.position.y>100 && this.position.y<260){
                this.updateVelocity();
            }
            
            if(this.position.x>400 && this.position.x< 535 && this.position.y>100){
                this.updateVelocity1();
            }
            if(this.position.x>200 && this.position.x< 340 && this.position.y>100 && this.position.y<485){
                this.updateVelocity1();
            }
            if(this.position.x>750 && this.position.x< 860 && this.position.y>100 && this.position.y<500){
                this.updateVelocity1();
            }
            if(this.position.x>0 && this.position.x< 200 && this.position.y>255){
                this.updateVelocity2();
            }
            if(this.position.y>450){
                this.updateVelocity2();
            }
            if(this.position.x>=660 && this.position.x<= 750 && this.position.y>70 && this.position.y<200){
                this.updateVelocity2();
            }
            if(this.position.x>=780 && this.position.x<= 1000 && this.position.y>260 && this.position.y<500){
                this.updateVelocity2();
            }
           
            else this.updateVelocity3();
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

        this.velocity.set(random.nextInt(3) , random.nextInt(3) - 1);
        if (count == 4) {
            this.velocity.set(random.nextInt(3) , random.nextInt(3) - 1);
        }
        if (count == 3) {
            this.velocity.set(random.nextInt(3) , random.nextInt(3) - 1);
        }
        if (count == 2) {
            this.velocity.set(random.nextInt(3) , random.nextInt(3) - 1);
        }
        if (count == 1) {
            this.velocity.set(random.nextInt(3) , random.nextInt(3) - 1);
        }
    }
    public void updateVelocity2() {

        this.velocity.set(random.nextInt(3) , random.nextInt(3) - 3);
        if (count == 4) {
            this.velocity.set(random.nextInt(3) , random.nextInt(3) - 3);
        }
        if (count == 3) {
            this.velocity.set(random.nextInt(3) , random.nextInt(3) - 3);
        }
        if (count == 2) {
            this.velocity.set(random.nextInt(3) , random.nextInt(3) - 3);
        }
        if (count == 1) {
            this.velocity.set(random.nextInt(3) , random.nextInt(3) - 3);
        }
    }
    public void updateVelocity3() {

        this.velocity.set(random.nextInt(3)-1 , random.nextInt(3) );
        if (count == 4) {
            this.velocity.set(random.nextInt(3)-1 , random.nextInt(3));
        }
        if (count == 3) {
            this.velocity.set(random.nextInt(3)-1 , random.nextInt(3) );
        }
        if (count == 2) {
            this.velocity.set(random.nextInt(3)-1 , random.nextInt(3) );
        }
        if (count == 1) {
            this.velocity.set(random.nextInt(3)- 1 , random.nextInt(3) );
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
