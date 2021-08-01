package cz.cvut.fel.pjv.states;

import cz.cvut.fel.pjv.graphics.Assets;
import cz.cvut.fel.pjv.graphics.World;
import cz.cvut.fel.pjv.main.Handler;
import cz.cvut.fel.pjv.main.Main;
import cz.cvut.fel.pjv.ui.Panel;
import cz.cvut.fel.pjv.utils.Save;

import java.awt.*;

public class GameState extends State {

    private World world;
    private Panel panel;

    private Rectangle rectangleMouse; // Mouse movement rectangle for collision detection.

    private boolean activeControl = false; // Window control closed.
    private boolean activeInventory = false; // Window inventory closed.
    private boolean activeSave = false; // Save button is inactive.
    private int isDie; // The identifier is death. Used to have inventory cleaned once.

    /**
     * @param handler class object Handler.
     */
    public GameState(Handler handler) {
        super(handler);

        world = new World(handler, "/files/world.txt"); // Loading the world using the path to a text file.

        handler.setWorld(world);
        panel = new Panel(handler);

        // A rectangle describing the position of the cursor on the screen with a width and height of 1 pixel.
        rectangleMouse = new Rectangle();
        rectangleMouse.width = 1;
        rectangleMouse.height = 1;

        isDie = 0; // The player is alive.
    }

    @Override
    public void update() {
        world.update(); // The world is drawn first, then the player character.
        if (activeControl) panel.setActiveControls(true); // Modify the variable to display the game rules panel.
        // Activation of inventory for display on the screen.
        if (activeInventory) handler.getWorld().getEntityManager().getPlayer().getInventory().setActive(true);
        panel.update();

        // Updating the starting coordinates of the mouse rectangle.
        rectangleMouse.x = handler.getMouseManager().getxMouse();
        rectangleMouse.y = handler.getMouseManager().getyMouse();

        if (activeSave) {
            Save.writeFileInventoryAndCharacteristics(handler.getWorld().getEntityManager().getPlayer());
            activeSave = !activeSave;
        }

        // If a player dies, then all his characteristics and equipment will be removed.
        if (handler.getWorld().getEntityManager().getPlayer().getHealth() <= 0) isDie++;
        if (isDie == 1) {
            Save.clearFileAfterGameOver();
            Main.getLOG().fine("Inventory has been cleared.");
        }
    }

    @Override
    public void render(Graphics g)  {
        world.renderLayerFirst(g);
        world.renderLayerSecond(g);
        panel.render(g);

        // Button exit behavior when the cursor is over it.
        if (rectangleMouse.intersects(1110, 750, 153,44)) {
            g.drawImage(Assets.button_game_exit[1], 1110, 750,  null);
            if (handler.getMouseManager().isRightClick() || handler.getMouseManager().isLeftClick()) {
                Main.getLOG().fine("The Exit button was pressed.");
                System.exit(1);
            }
        } else {
            g.drawImage(Assets.button_game_exit[0], 1110, 750,  null);
        }

        // Button control behavior when the cursor is over it.
        if (rectangleMouse.intersects(1110, 690, 153,44)) {
            g.drawImage(Assets.button_game_control[1], 1110, 690,  null);
            if (handler.getMouseManager().isRightClick() || handler.getMouseManager().isLeftClick()) {
                activeControl = true;
                Main.getLOG().fine("The Control button was pressed.");
            }
        } else {
            g.drawImage(Assets.button_game_control[0], 1110, 690,  null);
            activeControl = false;
        }

        // Button inventory behavior when the cursor is over it.
        if (rectangleMouse.intersects(1110, 630, 153,44)) {
            g.drawImage(Assets.button_game_inventory[1], 1110, 630,  null);
            if (handler.getMouseManager().isRightClick() || handler.getMouseManager().isLeftClick()) {
                activeInventory = true;
                Main.getLOG().fine("The Inventory button was pressed.");
            }
        } else {
            g.drawImage(Assets.button_game_inventory[0], 1110, 630,  null);
            activeInventory = false;
        }

        // Button save behavior when the cursor is over it.
        if (rectangleMouse.intersects(1110, 570, 153,44)) {
            g.drawImage(Assets.button_game_save[1], 1110, 570,  null);
            if (handler.getMouseManager().isRightClick() || handler.getMouseManager().isLeftClick()) {
                activeSave = true;
                Main.getLOG().fine("The Save button was pressed.");
            }
        } else {
            g.drawImage(Assets.button_game_save[0], 1110, 570,  null);
        }

        // Displaying an image of the end of the game on the screen if the player died.
        if (handler.getWorld().getEntityManager().getPlayer().getHealth() <= 0) {
            g.drawImage(Assets.gameOver, 0,0, null);
            Main.getLOG().info("Game over.");
        } else {
            g.drawImage(Assets.blank,0,0,null);
        }
    }
}
