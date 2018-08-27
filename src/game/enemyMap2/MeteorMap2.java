package game.enemyMap2;

import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import tower.Snow.Goku;
import tower.Snow.Kamejoko;
import tower.machineGun.MachineGun;
import tower.missile.MissileGun;

public class MeteorMap2 extends GameObject implements PhysicBody {

    public Vector2D velocity;
    private int count = 10;
    public BoxCollider boxCollider;

    public MeteorMap2() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources\\images\\comet.png", 50, 50);
        this.boxCollider = new BoxCollider(50, 50);
        this.damage = 10;
        this.health = 10;
        this.money = 10;
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.getInsight(this);

        this.boxCollider.position.set(this.position.x - 20, this.position.y - 20);

          if(this.position.x<360){
         this.velocity.set(3, -1);
        }
        if (this.position.x == 360) {
            this.velocity.set(1.5f, 3);
        }
        if (this.position.x == 459 ) {//di xuong 300 300
            this.velocity.set(3, -1.5f);
        }
        if (this.position.x == 645) {//re phai 300 500
            this.velocity.set(1, 3);
        }
        if (this.position.x == 717 ) {//di len 500 500
            this.velocity.set(3, -2);
        }

    }

    @Override
    public void getHit(GameObject gameObject) {
        this.health -= gameObject.damage;
        if (health <= 0) {
            this.isAlive = false;
            GameObjManager.instance.allEnemyDied += this.money;
        }
        if (gameObject instanceof Kamejoko) {
            this.velocity.set(0, 0);
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
    }
}
