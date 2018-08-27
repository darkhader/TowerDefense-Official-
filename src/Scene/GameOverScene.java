package Scene;

import base.GameObjManager;
import game.background.Background;
import game.background.GameOver;
import javax.sound.sampled.Clip;
import utils.Utils;

public class GameOverScene implements Scene {

    private Clip clip;

    @Override

    public void init() {
        GameObjManager.instance.recycle(Background.class);
        GameObjManager.instance.add(new GameOver());
        this.clip = Utils.loadAudio("resources/audio/BTS.wav");
        this.clip.loop(-1);
        this.clip.start();
    }

    @Override
    public void deinit() {
        this.clip.stop();
    }
}
