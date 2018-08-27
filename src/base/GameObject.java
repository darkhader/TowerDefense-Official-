package base;

import action.Action;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import renderer.Renderer;

import java.util.List;
import java.util.Random;

public class GameObject {

    public Vector2D position;

    public Renderer renderer;

    public List<Attribute> attributes;

    public int damage;
    public  int health;
    public int money;

    public boolean isAlive = true;
    public boolean inAction1 = false;
    public boolean inAction2 = false;
    public boolean inAction3 = false;
    public boolean inAction4 = false;
    public boolean inAction12 = false;
    public boolean inAction22 = false;
    public boolean inAction32 = false;
    public boolean inAction42 = false;
    public List<Action> actions;
    public int enemyDied = 0;
    public Random random = new Random();

    public GameObject() {
        this.position = new Vector2D();
        this.attributes = new ArrayList<>();
        this.actions = new ArrayList<>();
    }

    public void run() {
        this.attributes
                .forEach(attribute -> attribute.run(this));
        actions.removeIf(action -> action.run(this));
    }

    public void render(Graphics graphics) {
        if (this.renderer != null) {
            this.renderer.render(graphics, this.position);
        }
        
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }
}
