package com.Paypl.Frame;

import com.Paypl.Player.Player;
import com.Paypl.classes.GameObject;
import com.Paypl.classes.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameEngine extends JPanel implements ActionListener, KeyListener, MouseListener {

    private final int DELAY = 10;
    public Player player = new Player();
    private Timer timer;
    public Handler handler;
    public JButton resetbutton = new JButton("Reset position");
    public JButton PlatformCreate = new JButton("Platform");
    public Point MousePosition;
    public boolean EditorMode = false;

    public GameEngine() {

        Update();
        add(resetbutton);
        resetbutton.addActionListener(e -> {
            player.resetposition();
        });
        add(PlatformCreate);
        PlatformCreate.addActionListener(e -> {
            CreateEditorObjects();
        });
    }
    public void Update() {
        handler = new Handler();
        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener( this);
        setBackground(Color.gray);
        timer = new Timer(DELAY, this);
        timer.start();
    }
    void PlayerMovement() {
        player.move(handler);
        repaint();
    }


    //Paint Environment
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintPlayer(g);
        paintWorld(g);
        ColorEditorObjects(g);
        DisplayDebugText(g);
        Toolkit.getDefaultToolkit().sync();

    }

    void paintWorld(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        handler.addGameObjects(new GameObject(100,400,200,25,Color.white, "1"));
        handler.addGameObjects(new GameObject(50,100,200,25,Color.white, "2"));
        for (GameObject go: handler.getGameObjects()) {
            go.paintObject(g2d);
        }
    }

    void paintPlayer(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.fillRect(player.getX(),player.getY(), player.getPlayerWidth(), player.getPlayerheight());
    }

    //Debug Text
    void DisplayDebugText(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString(String.format("(%d, %d)", player.x, player.y), 10, 20);
        g.drawString(String.format("[EditorMode is: %s, ]", EditorMode), 10, 100);
        g.drawString(String.format("(%d, %d)", MousePosition.x, MousePosition.y), 10, 80);
        g.drawString(String.format("(Y: %s, \n ,Original: %s, Sr: %s)",player.y ,player.orginalposY, player.y - player.orginalposY), 10, 60);
        g.drawString(String.format("(%s, %s, %s)", "Jump: "+ player.CanJump, "Collide: "+player.isColliding,"Ground "+ player.isGrounded), 10, 40);
    }

    //Editor Mode
    private void ColorEditorObjects(Graphics g) {
        if(EditorMode) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.white);
            g2d.fillRect(MousePosition.x, MousePosition.y, 200, 25);
        }
    }

    public void CreateEditorObjects() {
        if(EditorMode) {
            new Rectangle(MousePosition.x, MousePosition.y, 200, 25);
        }
    }

    public void PlaceEditorObjects() {
        if(EditorMode) {
            int x = MousePosition.x;
            int y = MousePosition.y;
            handler.addGameObjects(new GameObject(x, y, 200, 25, Color.white, "Platform" + x));
        }
    }

    //Actions Keyboard & mouse
    @Override
    public void actionPerformed(ActionEvent e) {
        PlayerMovement();
        MousePosition = MouseInfo.getPointerInfo().getLocation();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_E) {
            EditorMode = !EditorMode;
        }
        player.keypressd(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyRelesed(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(EditorMode) {
            PlaceEditorObjects();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
