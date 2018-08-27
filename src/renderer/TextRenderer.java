/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import base.Vector2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hiep Nguyen
 */
public class TextRenderer implements Renderer{
private String text;
private Color color;
private Font font;

    @Override
    public void render(Graphics graphics, Vector2D position) {
    graphics.setColor(color);
    graphics.setFont(font);
    graphics.drawString(text,(int) position.x,(int) position.y);
    }

    public TextRenderer(String text, Color color, String path, int fontSize) {
    try {
        this.text = text;
        this.color = color;
        
        this.font = Font.createFont(Font.PLAIN, new File(path)).deriveFont(Font.PLAIN, fontSize);
    } catch (FontFormatException ex) {
        Logger.getLogger(TextRenderer.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(TextRenderer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

  
    
}
