package cz.cvut.fel.pjv.inventory;

import cz.cvut.fel.pjv.graphics.Assets;
import cz.cvut.fel.pjv.main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {

    public static Item[] items = new Item[256]; // An array of all Item objects.

    // Creation items.
    public static Item appleItem = new Item(Assets.itemApple, "Apple", 0);
    public static Item strawberryItem = new Item(Assets.itemStrawberry, "Strawberry", 1);
    public static Item potionBlueItem = new Item(Assets.itemPotionBlue, "Potion Blue", 2);
    public static Item potionWhiteItem = new Item(Assets.itemPotionWhite, "Potion White", 3);
    public static Item potionRedItem = new Item(Assets.itemPotionRed, "Potion Red", 4);
    public static Item ringAttackItem = new Item(Assets.itemRingAttack, "Ring_Attack", 5);
    public static Item ringHealthItem = new Item(Assets.itemRingHealth, "Ring_Health", 6);
    public static Item amuletAttackItem = new Item(Assets.itemAmuletAttack, "Amulet_Attack", 7);
    public static Item amuletHealthItem = new Item(Assets.itemAmuletHealth, "Amulet_Health", 8);
    public static Item boot1Item = new Item(Assets.itemBoot1, "Boot_1", 9);
    public static Item boot2Item = new Item(Assets.itemBoot2, "Boot_2", 10);
    public static Item boot3Item = new Item(Assets.itemBoot3, "Boot_3", 11);
    public static Item gloves1Item = new Item(Assets.itemGloves1, "Gloves_1", 12);
    public static Item gloves2Item = new Item(Assets.itemGloves2, "Gloves_2", 13);
    public static Item gloves3Item = new Item(Assets.itemGloves3, "Gloves_3", 14);
    public static Item head1Item = new Item(Assets.itemHead1, "Head_1", 15);
    public static Item head2Item = new Item(Assets.itemHead2, "Head_2", 16);
    public static Item head3Item = new Item(Assets.itemHead3, "Head_3", 17);
    public static Item shield1Item = new Item(Assets.itemShield1, "Shield_1", 18);
    public static Item shield2Item = new Item(Assets.itemShield2, "Shield_2", 19);
    public static Item torso1Item = new Item(Assets.itemTorso1, "Torso_1", 20);
    public static Item torso2Item = new Item(Assets.itemTorso1, "Torso_2", 21);
    public static Item torso3Item = new Item(Assets.itemTorso1, "Torso_3", 22);
    public static Item weapon1Item = new Item(Assets.itemWeapon1, "Weapon_1", 23);
    public static Item weapon2Item = new Item(Assets.itemWeapon2, "Weapon_2", 24);
    public static Item weapon3Item = new Item(Assets.itemWeapon3, "Weapon_3", 25);
    public static Item keyItem = new Item(Assets.itemKey, "Key", 26);
    public static Item pants1Item = new Item(Assets.itemPants1, "Pants_1", 27);
    public static Item pants2Item = new Item(Assets.itemPants2, "Pants_2", 28);
    public static Item pants3Item = new Item(Assets.itemPants3, "Pants_3", 29);

    public static final int ITEM_WIDTH = 32, ITEM_HEIGHT = 32;

    protected Handler handler;
    protected BufferedImage image;
    protected String name;
    protected Rectangle bounds; // Object rectangle to interact with the player.
    protected boolean pickUp = false; // Indicates if the item was lifted off the ground.
    protected int x, y, count, id; // count - Number of items of one type.

    /**
     * @param image buffered image item.
     * @param name string name item.
     * @param id unique identifier item.
     */
    public Item(BufferedImage image, String name, int id) {
        this.image = image;
        this.name = name;
        this.id = id;
        count = 1;

        bounds = new Rectangle(x, y, ITEM_WIDTH, ITEM_HEIGHT);
        items[id] = this;
    }

    /**
     * Renewal of the item. Checking whether the character picks up the dropped awards.
     * The update rate is set in the class Game.
     */
    public void update() {
        if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f,0f).intersects(bounds)) {
            pickUp = true;
            handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
        }
    }

    /**
     * Render items on screen.
     *
     * @param g class object Graphics.
     */
    public void render(Graphics g) {
        if(handler == null) return;
        render(g,(int)(x - handler.getCamera().getxOffSet()), (int)(y - handler.getCamera().getyOffSet()));
    }

    /**
     * Render items on screen.
     *
     * @param g class object Graphics.
     * @param x x-coordinate in pixels of the upper-left corner of the rectangle of the item image.
     * @param y y-coordinate in pixels of the upper-left corner of the rectangle of the item image.
     */
    public void render(Graphics g, int x, int y) {
        g.drawImage(image, x , y, ITEM_WIDTH, ITEM_HEIGHT,null);
    }

    /**
     * Creates a new object item which drops out for example when opening chests.
     *
     * @param x x-coordinate location in pixels of the upper-left corner of the rectangle of the item image.
     * @param y y-coordinate location in pixels of the upper-left corner of the rectangle of the item image.
     * @return item new Item.
     */
    public Item createNew(int x, int y) {
        Item item = new Item(image,name,id);
        item.setPosition(x,y);
        item.setCount(count);
        return item;
    }

    /**
     * Establishing the position of an item on the screen.
     *
     * @param x x-coordinate position in pixels of the upper-left corner of the rectangle of the item image.
     * @param y x-coordinate position in pixels of the upper-left corner of the rectangle of the item image.
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }

    // Getters and setters
    public Handler getHandler() { return handler; }

    public void setHandler(Handler handler) { this.handler = handler; }

    public int getId() { return id; }

    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public BufferedImage getImage() { return image; }

    public void setImage(BufferedImage image) { this.image = image; }

    public boolean isPickUp() { return pickUp; }
}