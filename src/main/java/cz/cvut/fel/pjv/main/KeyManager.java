package cz.cvut.fel.pjv.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    // An array to listen for keystrokes, for pressed keys only, for keys that cannot be pressed repeatedly.
    private final boolean[] keys = new boolean[256];
    private final boolean[] justPressed = new boolean[256];
    private final boolean[] cannotPressed = new boolean[256];

    // Key event variables.
    public boolean up, down, left, right, menu,
            pick, skill1, skill2, skill3, openChest, potionBlue, potionRed, potionWhite, apple, strawberry;

    /**
     * Keys update.
     */
    public void update() {
        for (int i = 0; i < keys.length; i++) {
            if(cannotPressed[i] && !keys[i]) {
                cannotPressed[i] = false;
            } else if (justPressed[i]) {
                cannotPressed[i] = true;
                justPressed[i] = false;
            }
            if (!cannotPressed[i] && keys[i]) {
                justPressed[i] = true;
            }
        }

        up = (keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP]) && !(keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN]);
        down = (keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN]) && !(keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP]);
        left = (keys[KeyEvent.VK_A] ||  keys[KeyEvent.VK_LEFT]) && !(keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT]);
        right = (keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT]) && !(keys[KeyEvent.VK_A] ||  keys[KeyEvent.VK_LEFT]);

        pick = keys[KeyEvent.VK_1];
        skill1 = keys[KeyEvent.VK_2];
        skill2 = keys[KeyEvent.VK_3];
        skill3 = keys[KeyEvent.VK_4];
        openChest = keys[KeyEvent.VK_5];
        potionBlue = keys[KeyEvent.VK_6];
        potionRed = keys[KeyEvent.VK_7];
        potionWhite = keys[KeyEvent.VK_8];
        apple =  keys[KeyEvent.VK_9];
        strawberry =  keys[KeyEvent.VK_0];
        menu =  keys[KeyEvent.VK_ESCAPE];
    }

    /**
     *  Registers whether a key was pressed once.
     *
     * @param keyCode the index of the position of the event in the array justPressed.
     * @return true if the key was pressed once, otherwise returns false.
     */
    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= keys.length) return false;
        return justPressed[keyCode];
    }

    // Called by the system every time the user presses a Unicode character key on the keyboard.
    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    // Called by the system when any key on the keyboard is pressed.
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() < 0 || keyEvent.getKeyCode() >= keys.length) return;
        keys[keyEvent.getKeyCode()] = true;
        Main.getLOG().fine("A key was pressed " + keyEvent.getKeyChar());
    }

    // Called when any key on the keyboard is released.
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() < 0 || keyEvent.getKeyCode() >= keys.length) return;
        keys[keyEvent.getKeyCode()] = false;
    }
}