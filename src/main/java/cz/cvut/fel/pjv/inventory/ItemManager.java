package cz.cvut.fel.pjv.inventory;

import cz.cvut.fel.pjv.main.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemManager {

    private Handler handler;

    private List<Item> items; // Array List consisting of items.

    /**
     * @param handler  class object Handler.
     */
    public ItemManager(Handler handler) {
        this.handler = handler;

        items = new ArrayList<>();
    }

    /**
     *  Renewal of the item. The update rate is set in the class Game.
     *  Checks if the player has picked up a reward.
     */
    public void update() {
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            item.update();
            if(item.isPickUp()) it.remove(); // If the player picks up an item.
        }
     }

    /**
     * Displays all items.
     *
     * @param g class object Graphics.
     */
    public void render(Graphics g) {
        for (Item item: items) item.render(g);
    }

    /**
     * Adds a new item to the Array List.
     *
     * @param item class object Item.
     */
    public void addItem(Item item) {
        item.setHandler(handler);
        items.add(item);
    }

    // Getters and setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
