package com.Paypl.classes;

import com.Paypl.Player.Player;
import com.Paypl.Utils.Utils;

import java.awt.*;

public class GameObject {

    public int x;
    public int y;
    public int WIDTH;
    public int HEIGHT;
    public Color color;
    public String name;

    public GameObject(int x, int y, int WIDTH, int HEIGHT, Color color, String name) {
        this.x = x;
        this.y = y;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.color = color;
        this.name = name;

    }

    public String getName() { return name; }
    public Color getColor() {
        return color;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWIDTH() {
        return WIDTH;
    }
    public int getHEIGHT() {
        return HEIGHT;
    }
    public Rectangle getbounds() {
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }
    public void paintObject(Graphics2D g) {
        g.fillRect(x,y,WIDTH,HEIGHT);
        g.setColor(color);
    }


}
