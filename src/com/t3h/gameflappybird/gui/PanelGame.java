package com.t3h.gameflappybird.gui;

import com.t3h.gameflappybird.Main;
import com.t3h.gameflappybird.gui.modulegame.Bird;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by namnv on 14/01/2017.
 */
public class PanelGame extends JPanel implements Runnable{
    private ManagerGame managerGame;
    private Thread thread;

    public PanelGame(){
        setLayout(null);
        initComponents();
        addEvents();
    }

    private void initComponents() {
        managerGame = new ManagerGame();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        managerGame.drawAll(g2d);

    }

    @Override
    public void run() {
        while (true) {
            managerGame.gamePlay();
            repaint();
            try {
                thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (managerGame.checkDie()){
                managerGame.gameOver();
                repaint();
                thread.stop();
            }
        }
    }

    private void addEvents(){
        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    managerGame.moveBird();

                }

            }
        };
        addKeyListener(keyListener);
        setFocusable(true);
    }
}
