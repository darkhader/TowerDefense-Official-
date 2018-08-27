/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import base.Attribute;
import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class Player extends GameObject {

    public Vector2D velocity;

    public Player() {
        this.position.set(1000,285);
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/human.png", 50, 50);

        this.attributes.add((Attribute) new PlayerMove());
        this.attributes.add((Attribute) new PlayerBuild());

    }

    @Override
    public void run() {
        super.run();

    }
}
