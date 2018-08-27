package Scene;

import base.GameObjManager;
import game.Earth.CreateEarth;
import game.background.Background2;
import game.background.Demo;

import game.background.HealthBar;
import game.enemyMap2.CreateAlienMap2;
import game.enemyMap2.CreateLinhKaMap2;
import game.enemyMap2.CreateMeteorMap2;
import javax.sound.sampled.Clip;
import player.Player;
import utils.Utils;

public class Map2Scene implements Scene {
    private Clip clip;
    @Override
    public void init() {
        GameObjManager.instance.add(new Background2());
        GameObjManager.instance.add(new CreateEarth());
        GameObjManager.instance.add(new Player());
       GameObjManager.instance.add(new Demo());
        GameObjManager.instance.add(new HealthBar());
        GameObjManager.instance.add(new CreateAlienMap2());
        GameObjManager.instance.add(new CreateMeteorMap2());
        GameObjManager.instance.add(new CreateLinhKaMap2());
        this.clip = Utils.loadAudio("resources/audio/songoku.wav");
        this.clip.loop(-1);
        this.clip.start();
    }

    @Override
    public void deinit () {
        GameObjManager.instance.clear();
        this.clip.stop();
    }
}

