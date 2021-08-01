package cz.cvut.fel.pjv.ui;

import cz.cvut.fel.pjv.graphics.Assets;
import cz.cvut.fel.pjv.inventory.Item;
import cz.cvut.fel.pjv.main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Panel {

    private Handler handler;

    private List<Item> inventoryItem; // List of items in inventory.

    private final int y = 742, xProperties = 126, distanceProperties = 12;
    private int count, countProperties;

    private boolean activeControls = true; // Panel with control rules is displayed.
    private Rectangle rectangleMouse; // Mouse movement rectangle for collision detection.

    /**
     * @param handler class object Handler.
     */
    public Panel(Handler handler) {
        this.handler = handler;

        inventoryItem = handler.getWorld().getEntityManager().getPlayer().getInventory().inventoryItem;

        rectangleMouse = new Rectangle();
        rectangleMouse.width = 1;
        rectangleMouse.height = 1;
    }

    /**
     * Updating the state panel Control. The update rate is set in the class Game.
     * Updating the coordinates of the rectangle anchored to the cursor.
     */
    public void update(){
        count = 0;
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_R)) activeControls = !activeControls;
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) activeControls = false;
        if (!activeControls) return;

        rectangleMouse.x = handler.getMouseManager().getxMouse();
        rectangleMouse.y = handler.getMouseManager().getyMouse();
    }

    /**
     * Render panel on the screen.
     *
     * @param g class object Graphics.
     */
    public void render(Graphics g) {
        g.drawImage(Assets.panel, 0, 0, null); // Display panel UI.

        renderSKills(g);
        renderItems(g);
        renderHealth(g);
        renderMana(g);
        renderPoisoning(g);

        // Displays a button to close the panel Control, if it is active.
        if (activeControls) {
            int xControl = 310, yControl = 202, widthControl = 660, heightControl = 384;

            g.drawImage(Assets.control, xControl, yControl, widthControl, heightControl, null);
            if (rectangleMouse.intersects(xControl + 620, yControl - 10, 64,64)) {
                g.drawImage(Assets.button_exit_small[1], xControl + 620, yControl - 10, 64, 64, null);
                if (handler.getMouseManager().isRightClick() || handler.getMouseManager().isLeftClick()) {
                    activeControls = false;
                }
            } else {
                g.drawImage(Assets.button_exit_small[0], xControl + 620, yControl - 10, 64, 64, null);
            }
        }
    }

    /**
     * Displaying the active use of a skill when pressing the corresponding skill button.
     *
     * @param g class object Graphics.
     */
    public void renderSKills(Graphics g) {
        int xItemActive = 344, yItemActive = 736, widthItemActive = 60, heightItemActive = 60;

        if (handler.getKeyManager().pick)
            g.drawImage(Assets.item1Active, xItemActive, yItemActive, widthItemActive, heightItemActive, null);

        if (handler.getKeyManager().skill1)
            g.drawImage(Assets.item2Active,(xItemActive + widthItemActive), yItemActive,
                    widthItemActive, heightItemActive, null);

        if (handler.getKeyManager().skill2)
            g.drawImage(Assets.item3Active,(xItemActive + 2 * widthItemActive -2), yItemActive,
                    widthItemActive, heightItemActive, null);

        if (handler.getKeyManager().skill3)
            g.drawImage(Assets.item4Active,(xItemActive + 3 * widthItemActive -2), yItemActive,
                    widthItemActive, heightItemActive, null);

        if (handler.getKeyManager().openChest)
            g.drawImage(Assets.item5Active,(xItemActive + 4 * widthItemActive -2), yItemActive,
                    widthItemActive, heightItemActive, null);

        if (handler.getKeyManager().potionBlue)
            g.drawImage(Assets.item6Active,(xItemActive + 5 * widthItemActive -4), yItemActive,
                    widthItemActive, heightItemActive, null);

        if (handler.getKeyManager().potionRed)
            g.drawImage(Assets.item7Active,(xItemActive + 6 * widthItemActive -4), yItemActive,
                    widthItemActive, heightItemActive, null);

        if (handler.getKeyManager().potionWhite)
            g.drawImage(Assets.item8Active,(xItemActive + 7 * widthItemActive -4), yItemActive,
                    widthItemActive, heightItemActive, null);

        if (handler.getKeyManager().apple)
            g.drawImage(Assets.item9Active,(xItemActive + 8 * widthItemActive -6), yItemActive,
                    widthItemActive, heightItemActive, null);

        if (handler.getKeyManager().strawberry)
            g.drawImage(Assets.item0Active,(xItemActive + 9 * widthItemActive -6), yItemActive,
                    widthItemActive, heightItemActive, null);
    }

    /**
     * Display of potions, food and their quantity on the screen.
     *
     * @param g class object Graphics.
     */
    public void renderItems(Graphics g) {
        for (Item i: inventoryItem) {
            int distance = 59, widthItem = 34, heightItem = 34, xItem = 600, yItem = y + 6;

            if (i.getId() == 26) {
                g.drawImage(Assets.itemKey, xItem, yItem, widthItem, heightItem, null);
                renderItemNumber(g, i, 0);
            } else if (i.getId() == 2) {
                g.drawImage(Assets.itemPotionBlue,(xItem + distance), yItem, widthItem, heightItem, null);
                renderItemNumber(g, i, distance);
            } else if (i.getId() == 4) {
                g.drawImage(Assets.itemPotionRed,(xItem + 2 * distance), yItem, widthItem, heightItem, null);
                renderItemNumber(g, i, 2* distance);
            } else if (i.getId() == 3) {
                g.drawImage(Assets.itemPotionWhite,(xItem + 3 * distance), yItem, widthItem, heightItem, null);
                renderItemNumber(g, i, 3* distance);
            } else if (i.getId() == 0) {
                g.drawImage(Assets.itemApple,(xItem + 4 * distance), yItem, widthItem, heightItem, null);
                renderItemNumber(g, i, 4* distance);
            } else if (i.getId() == 1) {
                g.drawImage(Assets.itemStrawberry,(xItem + 5 * distance), yItem, widthItem, heightItem, null);
                renderItemNumber(g, i, 5* distance);
            }
        }
    }

    /**
     * Render items number on the screen.
     *
     * @param g class object Graphics.
     * @param item class object Item.
     * @param d distance in pixels for correct display of digits of one number.
     */
    public void renderItemNumber(Graphics g, Item item, int d) {
        int number = item.getCount();
        count = 0;
        // List of numbers.
        List<Integer> numeralArray = new ArrayList<>();
        while (number > 0) {
            numeralArray.add(number % 10);
            number /= 10;
        }
        for (int i = numeralArray.toArray().length - 1; i >= 0; i--) {
            // Variable distances
            int x = 584, width = 30, height = 30, distanceCount = 8;
            g.drawImage(getImageCountItem(numeralArray.get(i)), (x + d + count * distanceCount), y, width, height, null);
            count++;
        }
    }

    /**
     * Getting an image of a digit.
     *
     * @param i unique index number.
     * @return bufferedImage number by index.
     */
    public BufferedImage getImageCountItem(int i) {
        if (i == 0) return Assets.number0;
        else if (i == 1) return Assets.number1;
        else if (i == 2) return Assets.number2;
        else if (i == 3) return Assets.number3;
        else if (i == 4) return Assets.number4;
        else if (i == 5) return Assets.number5;
        else if (i == 6) return Assets.number6;
        else if (i == 7) return Assets.number7;
        else if (i == 8) return Assets.number8;
        else if (i == 9) return Assets.number9;
        return null;
    }

    /**
     * Displaying the player's current health using bars.
     *
     * @param g class object Graphics.
     */
    public void renderHealth(Graphics g) {
        countProperties = 0; // Health bar number.
        int health = handler.getWorld().getEntityManager().getPlayer().getHealth(); // Current health.
        int ownLinkHealth = handler.getWorld().getEntityManager().getPlayer().getMaxHealth() / 10; // The amount of health in one bars.
        int count = health / ownLinkHealth; // Number of health bars.

        /*
        * Display of all health bars. If the health value is not enough to fill the first health bar at the moment
        * and the player has not died, then one health bar will be displayed.
        */
        int yHealth = 13;
        if (health > 0 && health < ownLinkHealth) {
            g.drawImage(Assets.ownHealth, (xProperties + countProperties * distanceProperties), yHealth, null);
            countProperties ++;
        } else {
            for (int i = 0; i < count; i++) {
                g.drawImage(Assets.ownHealth, (xProperties + countProperties * distanceProperties), yHealth, null);
                countProperties++;
            }
        }
    }

    /**
     *  Displaying the player's current mana using bars.
     *
     * @param g class object Graphics.
     */
    public void renderMana(Graphics g) {
        countProperties = 0; // Mana bar number.
        int mana = handler.getWorld().getEntityManager().getPlayer().getMana(); // Current mana.
        int count = mana / 1000; // Number of mana bars.
        // Display of all mana bars.
        for (int i = 0; i < count; i++) {
            int yMana = 40;
            g.drawImage(Assets.ownMana, (xProperties + countProperties * distanceProperties), yMana, null);
            countProperties++;
        }
    }

    /**
     *  Displaying the player's current poisoning using bars.
     *
     * @param g class object Graphics.
     */
    public void renderPoisoning(Graphics g) {
        countProperties = 0; // Poisoning bar number.
        int poisoning = handler.getWorld().getEntityManager().getPlayer().getPoisoning(); // Current poisoning.
        int count = poisoning / 10;  // Number of poisoning bars.
        // Display of all poisoning bars.
        for (int i = 0; i < count; i++) {
            int yPoisoning = 65;
            g.drawImage(Assets.owmPoisoning, (xProperties  + countProperties * distanceProperties), yPoisoning, null);
            countProperties++;
        }
    }

    // Getters and Setters
    public void setActiveControls(boolean activeControls) { this.activeControls = activeControls; }
}
