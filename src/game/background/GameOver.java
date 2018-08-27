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

/**
 *
 * @author Hiep Nguyen
 */
public class GameOver extends GameObject {

    public GameOver() {

    }
public void run(){
        GameObjManager.instance.add( new EarthDeath());
    if(KeyBoardInput.instance.isR){
        SceneManager.instance.changeScene(new Map1Scene());
    }
}

    public void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.BOLD, 33));
        graphics.drawString("GameOver         Score:" + GameObjManager.instance.allEnemyDied, 300, 300);
      
        }
   
    }

