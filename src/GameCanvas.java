
import Scene.Map1Scene;
import Scene.Map2Scene;
import Scene.SceneManager;
import base.GameObjManager;

import game.background.Background;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameCanvas extends JPanel {

    private BufferedImage backBuffered;
    private Background background = new Background();

    private Graphics graphics;

    private Random random = new Random();

    public GameCanvas() {

        this.setSize(1024, 600);

        this.setupBackBuffered();

        SceneManager.instance.changeScene(new Map1Scene());

        this.setVisible(true);
        JOptionPane.showMessageDialog(null,  "Luật chơi:\n" +
        		"1. Di chuyển Golden Man bằng các phím mũi tên để đặt Tower ngăn chặn Alien, Meteor và Linh Ka xâm chiếm Trái đất(tiêu diệt đc Enemy sẽ được thưởng gold).\n" +
        		"2. Nhấn z để đặt trụ Súng - 25 gold.\n" +
        		"3. Nhấn x để đặt trụ Lửa - 100 gold.\n" +
        		"4. Nhấn c để đặt trụ Tên lửa - 50 gold.\n"+
        		"5. Nhấn v để đặt trụ Songoku - 200 gold.\n"+
        		"6. Nhấn SpaceBar để bắt đầu trò chơi.\n" +
        		"7. Khi Trái đất bị nổ nhấn R để chơi lại."  );

    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {

        GameObjManager.instance.renderAll(graphics);

        this.repaint();
    }

    public void runAll() {
     
        GameObjManager.instance.runAll();

        SceneManager.instance.performChangeSceneIfNeeded();
       

    }

 
}
