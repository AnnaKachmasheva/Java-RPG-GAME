package cz.cvut.fel.pjv.utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music implements AutoCloseable{

    private static boolean released = false; // It is not released.
    private static boolean playing = false; // Music is off.
    private AudioInputStream stream = null; // No input audio stream.
    private static Clip clip = null; // Clip interface is null.

    /**
     * @param file class object File.
     */
    public Music(File file) {
        try {
            stream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(stream); // opening clip
            clip.addLineListener(new Listener()); // adding listener
            released = true;
        } catch (Exception  e) {
            e.printStackTrace();
            released = false;
            close();
        }
    }

    /**
     * Run breakOld defines the behavior if the sound is already playing
     * If breakOld == true, the sound will be interrupted and restarted. Otherwise nothing will happen.
     *
     * @param breakOld is true/false. It is true if music play.
     */
    public static void play(boolean breakOld) {
        if (released) {
            if (breakOld) { // restart music
                clip.stop();
                clip.setFramePosition(0);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY); // indefinite looping
                playing = true;
            } else if (!isPlaying()) {
                clip.setFramePosition(0);
                clip.start();
                playing = true;
            }
        }
    }

    /**
     * Playing music.
     */
    public static void play() { play(true); }

    /**
     * Stop playback.
     */
    public static void stop() { if (playing) clip.stop(); }

    // Close clip.
    @Override
    public void close() {
        if (clip != null)
            clip.close();
        if (stream != null)
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    /**
     * Waits for the end of sound playback.
     */
    public static void join() {
        if (!released) return;
        synchronized(clip) {
            try {
                while (playing) clip.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Starts playing music.
     *
     * @param path music file path.
     * @return calls the method play.
     */
    public static Music playSound(String path) {
        File f = new File(path);
        Music snd = new Music(f);
        snd.play();
        return snd;
    }

    private class Listener implements LineListener {
        /**
         * Informs the listener that a line's state has changed.
         *
         * @param ev class object LineEvent.
         */
        public void update(LineEvent ev) {
            // The line stopped outputting audio data in response to a stop request
            if (ev.getType() == LineEvent.Type.STOP) {
                playing = false;
                synchronized(clip) {
                    clip.notify();
                }
            }
        }
    }

    // Getters and setters
    public static boolean isPlaying() { return playing; }
}

