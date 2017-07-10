package com.t3h.gameflappybird.gui;

import com.t3h.gameflappybird.common.Constants;
import com.t3h.gameflappybird.utils.Audio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by nam on 09/02/2017.
 */
public class MenuPanel extends JPanel implements Constants, ActionListener {
    private JButton play;
    private JButton exit;
    private Audio audioMenu;
    private GUI gui;
    private IGUI igui;

    public MenuPanel(){
        setLayout(null);
        initComponents();
        addComponents();
        addEvents();
    }

    private void initComponents() {
        audioMenu = new Audio(audio_Menu);

        Font font = new Font("Arial", Font.BOLD, 30);
        play = new JButton();
        play.setText("PLAY");
        play.setFont(font);
        play.setBackground(Color.BLACK);
        play.setForeground(Color.GREEN);
        play.setLocation(WIDTH_GUI/2 - 100, HEIGHT_GUI - 170);
        play.setSize(WIDTH_BUTTON, HEIGHT_BUTTON);
        play.setActionCommand("play");

        exit = new JButton();
        exit.setText("EXIT");
        exit.setFont(font);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.GREEN);
        exit.setLocation(WIDTH_GUI/2 - 100, HEIGHT_GUI - 100);
        exit.setSize(WIDTH_BUTTON, HEIGHT_BUTTON);
        exit.setActionCommand("exit");
    }

    private void addComponents(){
        add(play);
        add(exit);
        audioMenu.loop();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(BG_MENU, 0, 0, WIDTH_GUI, HEIGHT_GUI, null);

    }

    private void addEvents(){
        play.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = e.getActionCommand();
        switch (id){
            case "play":
                audioMenu.stop();
                igui.play();
                break;
            case "exit":
                igui.exit();
                break;
            default:
                break;
        }
    }

    public void addGUI(GUI gui){
        this.gui = gui;
    }

    public void setIGUI (IGUI igui){
        this.igui = igui;
    }
}
