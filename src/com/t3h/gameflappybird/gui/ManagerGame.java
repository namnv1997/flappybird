package com.t3h.gameflappybird.gui;

import com.t3h.gameflappybird.common.Constants;
import com.t3h.gameflappybird.gui.modulegame.*;
import com.t3h.gameflappybird.utils.Audio;

import java.awt.*;
import java.util.*;

/**
 * Created by namnv on 14/01/2017.
 */
public class ManagerGame implements Constants{
    private Bird bird;
    private Background bg;
    private java.util.List<Pipes> pipes;
    private Pipes pipeTop, pipeBot;
    private Land land;
    private GameOver gameOver;
    private boolean check;
    private Audio audioPoint;
    private Audio audioWing;
    private Audio audioHit;


    public ManagerGame(){
        initBG();
        initBird();
        initPipe();
        initLand();
        initGameOver();
        initAudios();
    }

    private void initAudios() {
        audioPoint = new Audio(audio_Point);
        audioWing = new Audio(audio_Wing);
        audioHit = new Audio(audio_Hit);
    }

    private void initGameOver() {
        gameOver = new GameOver(GAME_OVER, WIDTH_GUI/2 - 100, HEIGHT_GUI/2 - 30, 200, 60);
    }

    private void initLand() {
        land = new Land(LAND, 0, HEIGHT_LAND, WIDTH_GUI, 100);
    }

    private void initBird() {
        bird = new Bird(BIRD, X_BIRD, Y_BIRD, SIZE_BIRD, SIZE_BIRD );
    }

    private void initBG() {
        bg = new Background(BACKGROUND, 0, 0, WIDTH_GUI, HEIGHT_GUI);
    }

    private void initPipe(){
        pipes = new ArrayList<>();
        Random rd = new Random();
        int x = FIRST_PIPE_X;
        for ( int i = 0; i < NUMBER_OF_PIPES; i++){
            int h = rd.nextInt(200) + 100; // random chieu cao cua ong nuoc
            pipeTop =  new Pipes(PIPE_TOP, x, 0, PIPE_SIZE, h);
            pipeBot = new Pipes(PIPE_BOT, x, h + SPACE_PIPE_TOP_BOT, PIPE_SIZE, HEIGHT_GUI);
            pipes.add(pipeTop);
            pipes.add(pipeBot);
            x += SPACE_PIPE_TO_PIPE; // tang x de ve ong nuoc khac
        }
    } // khai bao va add ong nuoc vao list

    public void drawAll(Graphics2D g2d){
        bg.draw(g2d);
        for (Pipes pipe : pipes){
            pipe.draw(g2d);
        }
        bird.draw(g2d);
        land.draw(g2d);
        if (check){
            gameOver.draw(g2d);
        }
        Font  font = new Font("Arial", Font.BOLD, 25);
        g2d.setFont(font);
        g2d.setColor(Color.BLUE);
        g2d.drawString("Score : " +score, 10, 30);
    } // ve cac doi tuong trong game

    private void runPipe(){
        for (Pipes pipe : pipes){
           int x = pipe.getX();
           x--;
           pipe.setX(x);

           if ( x == -PIPE_SIZE){
               pipe.setX(WIDTH_GUI);
           }
        }
    } // cho ong nuoc chay

    public void gamePlay(){
        runPipe();
        defaultBird();
    }

    private void defaultBird(){
        bird.down();
    } // khong lam gi thi chim se roi xuong

    public void moveBird(){
        if (bird.getY() > 0) {
            bird.up();
            audioWing.play();
        }
    }// di chuyen con chim

    private int score = 0;
    public boolean checkDie(){
        for (Pipes pipe : pipes){
            if (bird.getX() + SIZE_BIRD >= pipe.getX() && bird.getX() <= pipe.getX() + PIPE_SIZE ){
                // khi con chim trong WIDTH cua ong nuoc
                if (bird.getY() >= pipe.getY() + pipe.getSize2() &&
                        bird.getY()+SIZE_BIRD <= pipe.getY() + pipe.getSize2() + SPACE_PIPE_TOP_BOT){
                    // khi con chim nam trong khoang trong giua 2 ong nuoc thi van song
                    if (bird.getX() == pipe.getX() + PIPE_SIZE/2){
                        score ++; // khi con chim qua duoc
                        audioPoint.play();
                    }
                    return false;
                }else return true; // khong thoa man la chet
            }

        }
        if (bird.getY() + SIZE_BIRD  == land.getY() || bird.getY() == 0) {
            return true;
        }
        return false;
    }

    public boolean gameOver(){
        audioHit.play();
        return check = true;
    }


}
