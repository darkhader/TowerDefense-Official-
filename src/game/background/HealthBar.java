/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.background;

import base.GameObjManager;
import base.GameObject;
import game.Earth.Earth;
import renderer.ImageRenderer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Hiep Nguyen
 */
public class HealthBar extends GameObject{

    public HealthBar() {
     this.position.set(30,60);
        this.renderer = new ImageRenderer("resources/images/health.png",100,100 );
    }


}
