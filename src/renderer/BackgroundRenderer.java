package renderer;

import base.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BackgroundRenderer implements Renderer {

    private Color color;
    private int width;
    private int height;
    private BufferedImage image;

    public BackgroundRenderer(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public BackgroundRenderer(String path, int width, int height) {
        this.image = this.loadImage(path);
        this.width = width;
        this.height = height;
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(this.color);
        graphics.fillRect((int) position.x, (int) position.y, this.width, this.height);
        graphics.drawImage(
                this.image,
                (int) position.x,
                (int) position.y,
                this.width,
                this.height,
                null
        );
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }

}
