package com.t3h.gameflappybird.gui.modulegame;

import java.awt.*;

/**
 * Created by namnv on 14/01/2017.
 */
public class Object2D {
    protected int x;
    protected int y;
    protected Image img;
    protected int size1;
    protected int size2;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getSize2() {
        return size2;
    }

    public int getY() {
        return y;
    }

    public Object2D(Image img, int x, int y, int size1, int size2) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.size1 = size1;
        this.size2 = size2;
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(img, x, y, size1, size2, null);
    }

}
