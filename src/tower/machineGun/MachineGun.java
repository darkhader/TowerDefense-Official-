package tower.machineGun;

import base.Attribute;
import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import java.awt.Graphics;
import java.util.List;
import player.PlayerBuild;
import renderer.ImageRenderer;

/**
 * This class creates a single blackhole tower
 *
 * @author basilvetas
 */
public class MachineGun extends GameObject {

  

    /**
     * Constructor
     */
    
    public MachineGun() {
        
        this.position.set(PlayerBuild.a, PlayerBuild.b);
        
        this.renderer = new ImageRenderer("resources/images/machine_gun_PNG56.png", 30, 30);
        this.attributes.add(new MachineGunAttack());
        this.money = 25;
    }

    public void run() {	
        super.run();

    }
}
