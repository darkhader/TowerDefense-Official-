/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.background;

import Scene.Map1Scene;
import Scene.SceneManager;
import base.GameObjManager;
import base.GameObject;
import game.Earth.CreateEarth;
import game.Earth.Earth;
import game.Earth.EarthDeath;
import input.KeyBoardInput;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import renderer.TextRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class GameOver extends GameObject {

    public GameOver() {

    }

    public void run() {
   
        GameObjManager.instance.add(new EarthDeath());
        
        if (KeyBoardInput.instance.isR) {
            GameObjManager.instance.allEnemyDied=50;
            SceneManager.instance.changeScene(new Map1Scene());
        }
    }

    public void render(Graphics graphics) {
        super.render(graphics);
        this.position.set(300, 300);
        this.renderer = new TextRenderer("GameOver         Score:" + GameObjManager.instance.allEnemyDied, Color.yellow, "resources/FiraMono-Bold.ttf", 33);

    }

}
