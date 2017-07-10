package com.t3h.gameflappybird.gui;

import com.t3h.gameflappybird.common.Constants;
import com.t3h.gameflappybird.utils.Audio;

import javax.swing.*;

/**
 * Created by namnv on 14/01/2017.
 */
public class GUI extends JFrame implements Constants {
    private PanelGame panelGame;
    private MenuPanel menuPanel;

    public GUI(){
        initGUI();
        initComponents();
        addComponents();
    }

    private void initGUI() {
        setTitle("Flappy by NamNV");
        setSize(WIDTH_GUI, HEIGHT_GUI);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void initComponents(){
        menuPanel = new MenuPanel();
    }

    private void addComponents(){
        add(menuPanel);

        menuPanel.addGUI(this);
        menuPanel.setVisible(true);

        IGUI igui = new IGUI() {
            @Override
            public void play() {
                playGame();
            }

            @Override
            public void exit() {
                System.exit(0);
            }
        };

        menuPanel.setIGUI(igui);
    }

    public void playGame(){
        panelGame = new PanelGame();
        add(panelGame);
        menuPanel.setVisible(false);
        panelGame.setVisible(true);
    }
}
