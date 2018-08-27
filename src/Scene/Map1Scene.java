package Scene;

import base.GameObjManager;
import game.Earth.CreateEarth;
import game.background.Background;
import game.background.Demo;
import game.background.HealthBar;
import game.enemy.CreateAlien;
import game.enemy.CreateLinhKa;
import game.enemy.CreateMeteor;
import javax.sound.sampled.Clip;
import player.Player;
import utils.Utils;


public class Map1Scene implements Scene {
private Clip clip;
  @Override
  public void init() {
      GameObjManager.instance.add(new Background());
      GameObjManager.instance.add(new CreateEarth());
      GameObjManager.instance.add(new Player());

      GameObjManager.instance.add(new Demo());
      GameObjManager.instance.add(new HealthBar());
      GameObjManager.instance.add(new CreateAlien());
      GameObjManager.instance.add(new CreateMeteor());
      GameObjManager.instance.add(new CreateLinhKa());
      this.clip = Utils.loadAudio("resources/audio/Aoe.wav");
      this.clip.loop(-1);
      this.clip.start();
  }

      @Override
      public void deinit () {
        GameObjManager.instance.clear();
        this.clip.stop();
      }
  }
