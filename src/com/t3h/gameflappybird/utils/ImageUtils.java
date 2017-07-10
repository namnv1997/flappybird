package com.t3h.gameflappybird.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by namnv on 14/01/2017.
 */
public class ImageUtils {
    public static Image getImage(String path){
        return new ImageIcon(ImageUtils.class.getResource(path)).getImage();
    }
}
