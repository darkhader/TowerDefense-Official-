package base;

import game.Earth.Earth;
import game.enemy.Alien;
import game.enemy.LinhKa;
import game.enemy.Meteor;
import game.enemyMap2.AlienMap2;
import game.enemyMap2.LinhKaMap2;
import game.enemyMap2.MeteorMap2;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import physic.BoxCollider;
import physic.PhysicBody;
import tower.songoku.Goku;
import tower.machineGun.MachineGun;
import tower.missile.MissileGun;
import tower.tinker.Fire;

public class GameObjManager {

    static public GameObjManager instance = new GameObjManager();
    private FrameCounter frameCounter;
    private List<GameObject> list;
    private List<GameObject> tempList;
    public int allEnemyDied = 50;
    public int hiep = 0;

    private GameObjManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();

    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public void runAll() {

        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();

    }

    public void renderAll(Graphics graphics) {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
    }

    public Alien findAlien1() {
        return (Alien) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Alien)
                .filter(gameObject -> gameObject.inAction1)
                .findFirst()
                .orElse(null);
    }

    public Meteor findMeteor1() {
        return (Meteor) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Meteor)
                .filter(gameObject -> gameObject.inAction1)
                .findFirst()
                .orElse(null);
    }

    public LinhKa findLinhKa1() {
        return (LinhKa) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof LinhKa)
                .filter(gameObject -> gameObject.inAction1)
                .findFirst()
                .orElse(null);
    }

    public Alien findAlien2() {
        return (Alien) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Alien)
                .filter(gameObject -> gameObject.inAction2)
                .findFirst()
                .orElse(null);
    }

    public Meteor findMeteor2() {
        return (Meteor) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Meteor)
                .filter(gameObject -> gameObject.inAction2)
                .findFirst()
                .orElse(null);
    }

    public LinhKa findLinhKa2() {
        return (LinhKa) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof LinhKa)
                .filter(gameObject -> gameObject.inAction2)
                .findFirst()
                .orElse(null);
    }

    public Alien findAlien3() {
        return (Alien) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Alien)
                .filter(gameObject -> gameObject.inAction3)
                .findFirst()
                .orElse(null);
    }

    public Meteor findMeteor3() {
        return (Meteor) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Meteor)
                .filter(gameObject -> gameObject.inAction3)
                .findFirst()
                .orElse(null);
    }

    public LinhKa findLinhKa3() {
        return (LinhKa) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof LinhKa)
                .filter(gameObject -> gameObject.inAction3)
                .findFirst()
                .orElse(null);
    }
       public Alien findAlien4() {
        return (Alien) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Alien)
                .filter(gameObject -> gameObject.inAction4)
                .findFirst()
                .orElse(null);
    }

    public Meteor findMeteor4() {
        return (Meteor) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Meteor)
                .filter(gameObject -> gameObject.inAction4)
                .findFirst()
                .orElse(null);
    }

    public LinhKa findLinhKa4() {
        return (LinhKa) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof LinhKa)
                .filter(gameObject -> gameObject.inAction4)
                .findFirst()
                .orElse(null);
    }

    public AlienMap2 findAlienMap2() {
        return (AlienMap2) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof AlienMap2)
                .filter(gameObject -> gameObject.inAction12)
                .findFirst()
                .orElse(null);
    }

    public MeteorMap2 findMeteorMap21() {
        return (MeteorMap2) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof MeteorMap2)
                .filter(gameObject -> gameObject.inAction12)
                .findFirst()
                .orElse(null);
    }

    public LinhKaMap2 findLinhKaMap21() {
        return (LinhKaMap2) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof LinhKaMap2)
                .filter(gameObject -> gameObject.inAction12)
                .findFirst()
                .orElse(null);
    }

    public AlienMap2 findAlienMap22() {
        return (AlienMap2) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof AlienMap2)
                .filter(gameObject -> gameObject.inAction22)
                .findFirst()
                .orElse(null);
    }

    public MeteorMap2 findMeteorMap22() {
        return (MeteorMap2) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof MeteorMap2)
                .filter(gameObject -> gameObject.inAction22)
                .findFirst()
                .orElse(null);
    }

    public LinhKaMap2 findLinhKamap22() {
        return (LinhKaMap2) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof LinhKaMap2)
                .filter(gameObject -> gameObject.inAction22)
                .findFirst()
                .orElse(null);
    }

    public AlienMap2 findAlienMap23() {
        return (AlienMap2) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof AlienMap2)
                .filter(gameObject -> gameObject.inAction32)
                .findFirst()
                .orElse(null);
    }

    public MeteorMap2 findMeteorMap23() {
        return (MeteorMap2) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof MeteorMap2)
                .filter(gameObject -> gameObject.inAction32)
                .findFirst()
                .orElse(null);
    }

    public LinhKaMap2 findLinhKaMap23() {
        return (LinhKaMap2) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof LinhKaMap2)
                .filter(gameObject -> gameObject.inAction32)
                .findFirst()
                .orElse(null);
    }
          public AlienMap2 findAlienMap24() {
        return (AlienMap2) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof AlienMap2)
                .filter(gameObject -> gameObject.inAction42)
                .findFirst()
                .orElse(null);
    }

    public MeteorMap2 findMeteorMap24() {
        return (MeteorMap2) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof MeteorMap2)
                .filter(gameObject -> gameObject.inAction42)
                .findFirst()
                .orElse(null);
    }

    public LinhKaMap2 findLinhKaMap24() {
        return (LinhKaMap2) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof LinhKaMap2)
                .filter(gameObject -> gameObject.inAction42)
                .findFirst()
                .orElse(null);
    }

    public Earth findEarth() {
        return (Earth) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Earth)
                .findFirst()
                .orElse(null);
    }

    public MachineGun findGun() {
        return (MachineGun) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof MachineGun)
                .findFirst()
                .orElse(null);
    }

    public Goku findGoku() {
        return (Goku) this.list.stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Goku)
                .findFirst()
                .orElse(null);
    }

    public Goku findSnow() {
        return (Goku) this.list.stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Goku)
                .findFirst()
                .orElse(null);
    }

    public MissileGun findMissileGun() {
        return (MissileGun) this.list.stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof MissileGun)
                .findFirst()
                .orElse(null);
    }
    public Fire findFireGun() {
        return (Fire) this.list.stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject.inAction1)
                .filter(gameObject -> gameObject instanceof Fire)
                .findFirst()
                .orElse(null);
    }

    public <T extends GameObject & PhysicBody> T checkCollision(BoxCollider boxCollider, Class<T> cls) {
        return (T) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .filter(gameObject -> {
                    BoxCollider other = ((T) gameObject).getBoxCollider();
                    return boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }

    public <T extends GameObject> T recycle(Class<T> cls) {
        T object = (T) this.list
                .stream()
                .filter(gameObject -> !gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .findFirst()
                .orElse(null);

        if (object != null) {
            object.isAlive = true;
            return object;
        } else {
            try {
                object = cls.newInstance();
                this.add(object);
                return object;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

    }

    public void clear() {
        this.list.clear();
        this.tempList.clear();
    }

}
