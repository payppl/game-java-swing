package com.Paypl.Frame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainMenu extends JFrame {

    public JButton StartButton = new JButton("Start Game");

    public JButton ExitButton = new JButton("Exit");
    public JLabel GameName =  new JLabel("<html><h1><strong>Cube Puzzle</h1></strong><hr></html>");
    public JPanel btn = new JPanel();
    GameEngine game = new GameEngine();
    public MainMenu() {
        super("tak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(500,500));
        add(btn);
        setVisible(true);

        btn.setBorder(new EmptyBorder(10,10,10,10));
        btn.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        btn.add(GameName, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttonsLayout = new JPanel(new GridBagLayout());
        buttonsLayout.add(StartButton, gbc);
        buttonsLayout.add(ExitButton, gbc);
        gbc.weighty = 1;
        btn.add(buttonsLayout, gbc);
        StartButton.addActionListener(e -> {
            StartGame();
        });
        ExitButton.addActionListener(e -> {
            System.exit(0);
        });
    }
    void StartGame() {
        btn.setVisible(false);
        this.repaint();
        add(game);
        game.requestFocusInWindow();
        game.setVisible(true);

    }

}
