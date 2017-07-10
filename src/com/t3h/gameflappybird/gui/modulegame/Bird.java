package com.t3h.gameflappybird.gui.modulegame;

import com.t3h.gameflappybird.common.Constants;

import java.awt.*;

/**
 * Created by namnv on 14/01/2017.
 */
public class Bird extends Object2D implements Constants{
    public Bird(Image img, int x, int y, int size1, int size2) {
        super(img, x, y, size1, size2);
    }

    public void down() {
        y++;
    }

    public void up() {
        y -= FLY_SIZE ;
    }

}
