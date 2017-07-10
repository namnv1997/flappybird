package com.t3h.gameflappybird.utils;

import javax.sound.sampled.*;
import java.io.IOException;

/**
 * Created by nam on 08/02/2017.
 */
public class Audio implements LineListener {
    private Clip clip;
    private String path;

    public Audio(String path) {
        this.path = path;
    }

    private void init(){
        try {
            AudioInputStream in = AudioSystem.getAudioInputStream(getClass().getResource(path));
            clip = AudioSystem.getClip();
            clip.open(in);
            clip.addLineListener(this);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play(){
        if (clip != null){
            clip.stop();
        }
        init();
        clip.start();
    }

    public void loop(){
        if (clip != null){
            clip.stop();
        }
        init();

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        if ( clip != null && clip.isRunning()){
            clip.stop();
        }
    }

    @Override
    public void update(LineEvent event) {

    }
}
