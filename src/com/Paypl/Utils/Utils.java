package com.Paypl.Utils;

import com.Paypl.Player.Player;
import com.Paypl.classes.GameObject;
import com.Paypl.classes.Handler;

import java.awt.*;

public class Utils {

    private static boolean intersect(GameObject g, Player player, int offsX, int offsY) {
        return g.getbounds().intersects(player.x + offsX , player.y + offsY , player.getPlayerWidth(), player.getPlayerheight());
    }

    public static boolean collide(Handler h, Player player, int offsX, int offsY) {
        for (GameObject go: h.getGameObjects()) {
            if (intersect(go,player, offsX,offsY)) {
                return true;
            }
        }
        return false;
    }
    public static boolean collide(Handler h, Player player) {
        for (GameObject go: h.getGameObjects()) {
            if(player.GroundCheck().intersects(go.getbounds())) {
                return true;
            }
        }
        return false;
    }

}
