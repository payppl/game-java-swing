package com.Paypl.classes;

import java.awt.*;

public interface ObjectCreator {

    int x = 0;
    int y = 0;
    int width = 0;
    int height = 0;
    String objectcolor = null;
    default int getX() { return x; }
    default int getY() { return y; }
    default int getWidth() { return width; }
    default int getHeight() {return height; }
    default void paintObject(Graphics2D g) {
        g.fillRect(x,y,width,height);
        g.setColor(Color.getColor(objectcolor));
    }
    default Rectangle getbounds() { return new Rectangle(x,y,width,height); }
}
