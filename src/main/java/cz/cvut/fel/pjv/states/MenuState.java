package cz.cvut.fel.pjv.states;

import cz.cvut.fel.pjv.graphics.Assets;
import cz.cvut.fel.pjv.main.Handler;
import cz.cvut.fel.pjv.main.Main;
import cz.cvut.fel.pjv.ui.ClickListener;
import cz.cvut.fel.pjv.ui.UIImageButton;
import cz.cvut.fel.pjv.ui.UIManager;
import cz.cvut.fel.pjv.utils.Music;

import java.awt.*;

public class MenuState extends State{

    public static UIManager uiManager;
    private boolean musicOn = true; // Music plays.

    /**
     * @param handler class object Handler.
     */
    public MenuState(Handler handler) {
         super(handler);

        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        // Button of the specified size and with the desired buffered image with a new mouse listener.
        uiManager.addObject(new UIImageButton(480, 260, 320, 64,
                Assets.button_start, new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getGame().gameState); // A walk from the menu in the game.
                handler.getMouseManager().setUiManager(null); // Disabling user interface input for menu status buttons.
                Main.getLOG().info("Start game.");
            }
        }));

        // Music buttons
        uiManager.addObject(new UIImageButton(514, 430, 116, 60,
                Assets.button_music_on, new ClickListener() {
            @Override
            public void onClick() {
                Music.play(true);
                musicOn = true;
                Main.getLOG().info("Music ON.");
            }
        }));

        uiManager.addObject(new UIImageButton(650, 430, 116, 60,
                Assets.button_music_off, new ClickListener() {
            @Override
            public void onClick() {
                Music.stop();
                musicOn = false;
                Main.getLOG().info("Music OFF.");
            }
        }));

        uiManager.addObject(new UIImageButton(480, 548, 320, 64,
                Assets.button_exit, new ClickListener() {
            @Override
            public void onClick() {
                Main.getLOG().info("Menu game exit. Game the end.");
                System.exit(0); // Out the game.
            }
        }));
    }

    @Override
    public void update() {
        uiManager.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.menuBackand, 0,0,null); // Display menu background image
        uiManager.render(g);

        renderMusicIcon(g); // Display icon on or off music
    }

    /**
     * Displays an icon on the screen indicating whether the music is on or not.
     *
     * @param g class object Graphics.
     */
    public void renderMusicIcon(Graphics g) {
        if (musicOn)
            g.drawImage(Assets.music_on_off[0], 680,378, 32, 32,null);
        else
            g.drawImage(Assets.music_on_off[1], 680,378, 32, 32,null);
    }
}
