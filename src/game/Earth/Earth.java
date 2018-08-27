/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Earth;

import Scene.GameOverScene;
import Scene.Map1Scene;
import Scene.Map2Scene;
import Scene.SceneManager;
import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import game.background.GameOver;
import game.enemy.Alien;
import game.enemy.LinhKa;
import game.enemy.Meteor;
import game.enemyMap2.AlienMap2;
import game.enemyMap2.LinhKaMap2;
import game.enemyMap2.MeteorMap2;
import input.KeyBoardInput;

import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class Earth extends GameObject implements PhysicBody {

    private BoxCollider boxCollider;
    private RunHitObject runHitObjectAlien;
    private RunHitObject runHitObjectMeteor;
    private RunHitObject runHitObjectLinhKa;
    private RunHitObject runHitObjectAlien2;
    private RunHitObject runHitObjectMeteor2;
    private RunHitObject runHitObjectLinhKa2;

    private FrameCounter frameCounter;

    public Earth() {

        this.renderer = new ImageRenderer("resources/images/worldwide.png", 150, 150);
        this.boxCollider = new BoxCollider(150, 150);
        this.runHitObjectAlien = new RunHitObject(Alien.class);
        this.runHitObjectMeteor = new RunHitObject(Meteor.class);
        this.runHitObjectLinhKa = new RunHitObject(LinhKa.class);
        this.runHitObjectAlien2 = new RunHitObject(AlienMap2.class);
        this.runHitObjectMeteor2 = new RunHitObject(MeteorMap2.class);
        this.runHitObjectLinhKa2 = new RunHitObject(LinhKaMap2.class);
        this.health = 200;
        this.frameCounter = new FrameCounter(10000);
    }

    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 75, this.position.y - 75);
        this.runHitObjectAlien.run(this);
        this.runHitObjectMeteor.run(this);
        this.runHitObjectLinhKa.run(this);
        this.runHitObjectAlien2.run(this);
        this.runHitObjectMeteor2.run(this);
        this.runHitObjectLinhKa2.run(this);
        if (this.frameCounter.run() && GameObjManager.instance.hiep == 0) {
            SceneManager.instance.changeScene(new Map2Scene());
            GameObjManager.instance.hiep = 1;
            KeyBoardInput.instance.isSpace = false;
            this.frameCounter.reset();
        }
        if (this.frameCounter.run() && GameObjManager.instance.hiep == 1) {
            SceneManager.instance.changeScene(new Map1Scene());
            GameObjManager.instance.hiep = 0;
            KeyBoardInput.instance.isSpace = false;
        }

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.health -= gameObject.damage;

        gameObject.isAlive = false;

        if (this.health <= 0) {
            this.isAlive = false;
            SceneManager.instance.changeScene(new GameOverScene());
        }
        if(this.isAlive==false){
            SceneManager.instance.changeScene(new GameOverScene());
        }

    }

    @Override
    public void getInsight(GameObject gameObject) {

    }

}
