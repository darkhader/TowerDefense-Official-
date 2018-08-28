package game.enemyMap2;

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

public class LinhKaMap2 extends GameObject implements PhysicBody {

    public static int a = 0;
    public Vector2D velocity;
    private int count = 5;
    public BoxCollider boxCollider;

    public LinhKaMap2() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/ka.png", 100, 100);
        this.boxCollider = new BoxCollider(20, 50);
        this.damage = 50;
        this.health = 100;
        this.money = 100;
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.getInsight(this);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 25);
         if(this.position.x >360 && this.position.x < 366 && this.position.y <=180 && this.position.y<178){
            this.isAlive=false;
        }
        if (this.position.x < 360) {
            this.velocity.set(3, -1);
        }
        if (this.position.x == 360) {
            this.velocity.set(1.5f, 3);
        }
        if (this.position.x == 459) {
            this.velocity.set(3, -1.5f);
        }
        if (this.position.x == 645) {
            this.velocity.set(1, 3);
        }
        if (this.position.x == 717) {
            this.velocity.set(3, -2);
        }
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.health -= gameObject.damage;
        gameObject.isAlive = false;
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
            if (d < 700 && d > 200) {
                this.inAction32 = true;
            } else {
                this.inAction32 = false;
            }

        }
        Fire fireGun = GameObjManager.instance.findFireGun();
        if (fireGun != null) {
            float d = (float) Math.sqrt(Math.pow((fireGun.position.x - this.position.x), 2)
                    + Math.pow((fireGun.position.y - this.position.y), 2));
            if (d < 100) {
                this.inAction42 = true;
            } else {
                this.inAction42 = false;
            }
        }
    }
}
