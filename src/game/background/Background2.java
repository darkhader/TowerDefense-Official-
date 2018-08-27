package game.background;

import base.GameObject;
import renderer.BackgroundRenderer;

public class Background2 extends GameObject {
    public Background2() {
        this.renderer = new BackgroundRenderer("resources/images/BackGround2.png", 1024, 553);
    }

}
