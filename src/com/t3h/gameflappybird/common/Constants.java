package com.t3h.gameflappybird.common;

import com.t3h.gameflappybird.utils.ImageUtils;

import java.awt.*;

/**
 * Created by namnv on 14/01/2017.
 */
public interface Constants {
    int WIDTH_GUI = 700;
    int HEIGHT_GUI = 500;
    int HEIGHT_LAND = HEIGHT_GUI - 50;
    int FIRST_PIPE_X = WIDTH_GUI - 250;
    int SIZE_BIRD = 35;
    int FLY_SIZE = 30;
    int PIPE_SIZE = 65;
    int SPACE_PIPE_TOP_BOT = 100;
    int NUMBER_OF_PIPES = 4;
    int SPACE_PIPE_TO_PIPE = 200;
    int WIDTH_BUTTON = 200;
    int HEIGHT_BUTTON = 50;
    int X_BIRD = 100;
    int Y_BIRD = 150;

    String audio_Menu = "/audios/lactroi.wav";
    String audio_Wing = "/audios/wing.wav";
    String audio_Point = "/audios/point.wav";
    String audio_Hit = "/audios/hit.wav";


    Image BIRD = ImageUtils.getImage("/images/Bird.png");
    Image PIPE_TOP = ImageUtils.getImage("/images/pipe_top.png");
    Image PIPE_BOT = ImageUtils.getImage("/images/pipe_bottom.png");
    Image BACKGROUND = ImageUtils.getImage("/images/background.png");
    Image LAND = ImageUtils.getImage("/images/land.png");
    Image GAME_OVER = ImageUtils.getImage("/images/game_over.png");
    Image BG_MENU = ImageUtils.getImage("/images/bg_game.jpg");
}
