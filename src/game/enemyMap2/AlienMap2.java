package game.enemyMap2;

import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import tower.songoku.Goku;
import tower.machineGun.MachineGun;
import tower.missile.MissileGun;
import tower.tinker.Fire;



public class AlienMap2 extends GameObject implements PhysicBody {
    public static int a = 0;
    public Vector2D velocity;
    private int count = 5;
    public BoxCollider boxCollider;
    public FrameCounter frameCounter1 = new FrameCounter(
            this.random.nextInt(10)
                    + 125);//300
    public FrameCounter frameCounter2 = new FrameCounter(
            this.random.nextInt(8)
                    + 60);//200
    public FrameCounter frameCounter3 = new FrameCounter(
            this.random.nextInt(7)
                    + 65);//200
    public FrameCounter frameCounter4 = new FrameCounter(
            this.random.nextInt(10)
                    + 60);//400


    public AlienMap2() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/Alien-Ship.png", 20, 20);
        this.boxCollider = new BoxCollider(20, 20);
        this.damage = 5;
        this.health = 5;
        this.money = 1;
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.getInsight(this);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        this.moveMap();
    }

    public void moveMap() {
     this.velocity.set(3, -1);
        if (this.frameCounter1.run()) {//di xuong 300 300
            this.velocity.set(1, 3);
            if (this.frameCounter2.run()) {//re phai 300 500
                this.velocity.set(3, -1);
                if (frameCounter3.run()) {//di len 500 500
                    this.velocity.set(1, 3);
                    if (frameCounter4.run()) {//re phai 500 100 
                        this.velocity.set(3, -2);

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

            GameObjManager.instance.allEnemyDied += this.money;
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
                this.inAction12 = true;
            } else {
                this.inAction12 = false;
            }

        }
        Goku goku = GameObjManager.instance.findGoku();
        if (goku != null) {
            if (Math.sqrt(Math.pow((goku.position.x - this.position.x), 2)
                    + Math.pow((goku.position.y - this.position.y), 2)) < 100) {
                this.inAction22 = true;
            } else {
                this.inAction22 = false;
            }

        }
       MissileGun missileGun = GameObjManager.instance.findMissileGun();
        if (missileGun != null) {
            float d = (float) Math.sqrt(Math.pow((missileGun.position.x - this.position.x), 2)
                    + Math.pow((missileGun.position.y - this.position.y), 2));
            if (d < 1000 && d > 500) {
                this.inAction32 = true;
            } else {
                this.inAction32 = false;
            }

        }
         Fire fireGun = GameObjManager.instance.findFireGun();
        if (fireGun != null) {
            float d = (float) Math.sqrt(Math.pow((fireGun.position.x - this.position.x), 2)
                    + Math.pow((fireGun.position.y - this.position.y), 2));
             if (d < 300) {
                this.inAction42 = true;
            } else {
                this.inAction42 = false;
            }
        }
    }
}
