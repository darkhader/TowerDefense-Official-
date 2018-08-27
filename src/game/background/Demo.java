/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.background;

import base.GameObjManager;
import base.GameObject;
import game.Earth.Earth;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import renderer.TextRenderer;

/**
 * @author Hiep Nguyen
 */
public class Demo extends GameObject {

    public Demo() {

    }

    public void render(Graphics graphics) {
        super.render(graphics);
        this.position.set(10, 30);
        this.renderer = new TextRenderer("Money:  "
                + GameObjManager.instance.allEnemyDied + " Gold", Color.yellow, "resources/FiraMono-Bold.ttf", 16);

        Earth earth = GameObjManager.instance.findEarth();
        if (earth != null) {
            if (earth.health > 150) {
                graphics.setColor(Color.GREEN);
            }
            if (earth.health <= 150 && earth.health > 50) {
                graphics.setColor(Color.YELLOW);
            }
            if (earth.health <= 50) {
                graphics.setColor(Color.RED);
            }
            graphics.fillRect(20, 50, earth.health, 20);
        }
        if (GameObjManager.instance.hiep == 1) {
            GameObjManager.instance.allEnemyDied = 50;
            Earth earth1 = GameObjManager.instance.findEarth();

            if (earth1 != null) {
                earth1.health = 200;
            }

            if (earth1 != null) {
                if (earth1.health > 150) {
                    graphics.setColor(Color.GREEN);
                }
                if (earth1.health <= 150 && earth1.health > 50) {
                    graphics.setColor(Color.YELLOW);
                }
                if (earth1.health <= 50) {
                    graphics.setColor(Color.RED);
                }
                graphics.fillRect(20, 50, earth1.health, 20);
            }
        }
    }
}
