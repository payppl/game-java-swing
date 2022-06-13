package com.Paypl.Player;

import com.Paypl.Utils.Utils;
import com.Paypl.classes.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    public int dx;
    public int dy;
    public int x = 225;
    public int y = 350;
    public int player_movement = 4;
    public int orginalposY;

    int playerWidth = 25;
    int jump_height = 4;
    int playerheight = playerWidth;
    public boolean isColliding;
    public boolean CanJump;
    public boolean isGrounded;
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPlayerheight() {
        return playerheight;
    }

    public int getPlayerWidth() {
        return playerWidth;
    }

    public void move(Handler handler) {
        if(!Utils.collide(handler, this, dx,dy)) {
            x += dx;
            y += dy;
            isColliding = false;
            CanJump = true;
        } else {
            isColliding = true;
             CanJump = false;
             dy = 0;
        }
        isGrounded = isGround(handler);
        colider();
    }

    private void colider() {
        //move player down while hit ceiling
        if(!CanJump && isColliding && !isGrounded) {
            dy = jump_height;
        }
        //prevent player from jumping to high
        if(CanJump && !isColliding && isGrounded) {
            orginalposY = y;

        } else if(!isGrounded) {
            if(y - orginalposY == -60 || y - orginalposY == 0) {
                dy = jump_height;
            }
        }

    }

    public void resetposition() { x = 225; y = 250;}

    public void keypressd(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT) {dx = -player_movement; }
        if(key == KeyEvent.VK_RIGHT) { dx = player_movement; }
        if(key == KeyEvent.VK_SPACE) {

            //go up
            if(CanJump && isGrounded && !isColliding) {
                dy = -jump_height;

            }

        }
    }
    public void keyRelesed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT) {dx = 0;}
        if(key == KeyEvent.VK_RIGHT) {dx = 0;}
        if(key == KeyEvent.VK_SPACE) {

            //go down
            if(!isColliding && CanJump && !isGrounded) {
                dy = jump_height;
            }


        }
    }
    public Rectangle getbounds() {
        return new Rectangle(x,y,playerWidth,playerheight);
    }
    public Rectangle GroundCheck() {
        return new Rectangle(x, y + 10,playerWidth, playerheight);
    }
    public boolean isGround(Handler h) {
        return Utils.collide(h, this);
    }


}
