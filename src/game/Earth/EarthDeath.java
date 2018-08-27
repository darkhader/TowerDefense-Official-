package game.Earth;

import base.GameObject;
import renderer.ImageRenderer;

public class EarthDeath  extends GameObject {
    public EarthDeath(){
        this.position.set(1000, 285);
        this.renderer = new ImageRenderer("resources/images/world.png", 150, 150);
    }
}
