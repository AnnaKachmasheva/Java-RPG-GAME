package cz.cvut.fel.pjv.inventory;

import cz.cvut.fel.pjv.entities.dynamics.Player;
import cz.cvut.fel.pjv.graphics.Assets;
import cz.cvut.fel.pjv.main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private Handler handler;
    public  Player player;

    private boolean active = false; // Shows if the inventory is active.
    private Item activeItem = null; // The image item on which the player clicks with the mouse in the inventory window.

    public List<Item> inventoryItem; // Array of inventory objects.

    // Auxiliary distance values for display in pixels.
    private final int xInventory = 310, yInventory = 202, xItemInventory = 352, yItemInventory = 276,
            widthItemInventory = 32, heightItemInventory =32, distanceItems = 16;
    private int xItemCount, yItemCount, xNumberCount, xActiveItem, yActiveItem;

    private Rectangle rectangleMouse; // Mouse rectangle, used for collision detection.

    // Equipment worn by the player.
    public Item activeRing, activeAmulet, activeHead, activeBoots, activeGloves, activeTorso, activePants,
            activeWeapon, activeShield;

    private int attack, maxHealth;

    /**
     * @param handler class object Handler.
     */
    public Inventory(Handler handler) {
        this.handler = handler;

        inventoryItem = new ArrayList<>();
        xItemCount = 0;
        yItemCount = 0;
        xNumberCount = 0;
        rectangleMouse = new Rectangle();
    }

    /**
     * Inventory update. The update rate is set in the class Game.
     */
    public void update() {
        player = handler.getWorld().getEntityManager().getPlayer();

        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) active = !active; // Open close inventory window.
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) active = false; // Close open inventory.
        if (!active) return;

        xItemCount = 0;
        yItemCount = 0;
        xNumberCount = 0;

        rectangleMouse.width = 1;
        rectangleMouse.height = 1;
        rectangleMouse.x = handler.getMouseManager().getxMouse();
        rectangleMouse.y = handler.getMouseManager().getyMouse();
    }

    /**
     * Display on the screen. Rendering rate is set in the class Game.
     *
     * @param g lass object Graphics.
     */
    public void render(Graphics g) {
        if (!active) return; // If the inventory window is inactive.

        g.drawImage(Assets.inventory, xInventory, yInventory, 660, 384,null);

        renderItem(g);
        renderPlayer(g);
        renderActiveItemDraw(g);
        renderExitSmall(g);
        renderActiveItemClick(g);
    }

    /**
     * Character display in actual equipment.
     *
     * @param g lass object Graphics.
     */
    public void renderPlayer(Graphics g) {
        int xHero = 720, yHero = 320, widthHero = 160, heightHero = 160;

        g.drawImage(Assets.player_down[1], xHero, yHero, widthHero, heightHero,null);

        if (activePants != null && activePants.getId() == 27)
            g.drawImage(Assets.player_down_pants1[1], xHero, yHero, widthHero, heightHero,null);
        else if (activePants != null && activePants.getId() == 28)
            g.drawImage(Assets.player_down_pants2[1], xHero, yHero, widthHero, heightHero,null);
        else if (activePants != null && activePants.getId() == 29)
            g.drawImage(Assets.player_down_pants3[1], xHero, yHero, widthHero, heightHero,null);

        if (activeBoots != null && activeBoots.getId() == 9)
            g.drawImage(Assets.player_down_boots1[1], xHero, yHero, widthHero, heightHero,null);
        else if (activeBoots != null && activeBoots.getId() == 10)
            g.drawImage(Assets.player_down_boots2[1], xHero, yHero, widthHero, heightHero,null);
        else if (activeBoots != null && activeBoots.getId() == 11)
            g.drawImage(Assets.player_down_boots3[1], xHero, yHero, widthHero, heightHero,null);

        if (activeHead != null && activeHead.getId() == 15)
            g.drawImage(Assets.player_down_head1[1], xHero, yHero, widthHero, heightHero,null);
        else if (activeHead != null && activeHead.getId() == 16)
            g.drawImage(Assets.player_down_head2[1], xHero, yHero, widthHero, heightHero,null);
        else if (activeHead != null && activeHead.getId() == 17)
            g.drawImage(Assets.player_down_head3[1], xHero, yHero, widthHero, heightHero,null);

        if (activeTorso != null && activeTorso.getId() == 20)
            g.drawImage(Assets.player_down_torso1[1], xHero, yHero, widthHero, heightHero,null);
        else if (activeTorso != null && activeTorso.getId() == 21)
            g.drawImage(Assets.player_down_torso2[1], xHero, yHero, widthHero, heightHero,null);
        else if (activeTorso != null && activeTorso.getId() == 22)
            g.drawImage(Assets.player_down_torso3[1], xHero, yHero, widthHero, heightHero,null);

        if (activeWeapon != null && activeWeapon.getId() == 23)
            g.drawImage(Assets.player_down_weapon1[1], xHero, yHero, widthHero, heightHero,null);
        else if (activeWeapon != null && activeWeapon.getId() == 24)
            g.drawImage(Assets.player_down_weapon2[1], xHero, yHero, widthHero, heightHero,null);
        else if (activeWeapon != null && activeWeapon.getId() == 25)
            g.drawImage(Assets.player_down_weapon3[1], xHero, yHero, widthHero, heightHero,null);

        if (activeGloves != null && activeGloves.getId() == 12)
            g.drawImage(Assets.player_down_gloves1[1], xHero, yHero, widthHero, heightHero,null);
        else if (activeGloves != null && activeGloves.getId() == 13)
            g.drawImage(Assets.player_down_gloves2[1], xHero, yHero, widthHero, heightHero,null);
        else if (activeGloves != null &&  activeGloves.getId() == 14)
            g.drawImage(Assets.player_down_gloves3[1], xHero, yHero, widthHero, heightHero,null);

        if (activeShield != null && activeShield.getId() == 18)
            g.drawImage(Assets.player_down_shield1[1], xHero, yHero, widthHero, heightHero,null);
        else if (activeShield != null && activeShield.getId() == 19)
            g.drawImage(Assets.player_down_shield2[1], xHero, yHero, widthHero, heightHero,null);
    }
    public void renderActiveItemDraw(Graphics g) {
        int activeItemWidth = 44, activeItemHeight = 44;

        if (activeHead != null)
            g.drawImage(getImageItem(activeHead), xItemInventory + 324, yItemInventory + 18,
                    activeItemWidth, activeItemHeight,null);
        if (activeTorso != null)
            g.drawImage(getImageItem(activeTorso), xItemInventory + 324, yItemInventory + 38 + activeItemHeight,
                    activeItemWidth, activeItemHeight,null);
        if (activePants != null)
            g.drawImage(getImageItem(activePants), xItemInventory + 324, yItemInventory + 2*(28 + activeItemHeight),
                    activeItemWidth, activeItemHeight,null);
        if (activeBoots != null)
            g.drawImage(getImageItem(activeBoots), xItemInventory + 324, yItemInventory +3*(28 + activeItemHeight),
                    activeItemWidth, activeItemHeight,null);
        if (activeGloves != null)
            g.drawImage(getImageItem(activeGloves), xItemInventory + 428, yItemInventory +3*(28 + activeItemHeight),
                    activeItemWidth, activeItemHeight,null);
        if (activeWeapon != null)
            g.drawImage(getImageItem(activeWeapon), xItemInventory + 525, yItemInventory + 18, activeItemWidth,
                    activeItemHeight,null);
        if (activeShield != null)
            g.drawImage(getImageItem(activeShield), xItemInventory + 525, yItemInventory + 38 + activeItemHeight,
                    activeItemWidth, activeItemHeight,null);
        if (activeAmulet != null)
            g.drawImage(getImageItem(activeAmulet), xItemInventory + 525, yItemInventory + 2*(30 + activeItemHeight),
                    activeItemWidth, activeItemHeight,null);
        if (activeRing != null)
            g.drawImage(getImageItem(activeRing), xItemInventory + 525, yItemInventory +3*(28 + activeItemHeight),
                    activeItemWidth, activeItemHeight,null);
    }

    /**
     * Tracking mouse clicks when the cursor is over the selected area.
     *
     * @param g class object Graphics.
     */
    public void renderActiveItemClick(Graphics g) {
        if (activeItem != null) {
            g.drawImage(Assets.border, (xItemInventory - 5 + xActiveItem * (distanceItems + widthItemInventory)),
                    (yItemInventory - 8 + yActiveItem * (distanceItems + heightItemInventory)), null);
            if (rectangleMouse.intersects(xItemInventory + 394, yItemInventory  - 20, 112,39)) {
                g.drawImage(Assets.button_game_use[1], xItemInventory + 394,
                        yItemInventory - 20, 112, 39, null);
                if(handler.getMouseManager().isRightClick() || handler.getMouseManager().isLeftClick()) {
                    useActiveItem(activeItem);
                }
            } else {
                g.drawImage(Assets.button_game_use[0], xItemInventory + 394,
                        yItemInventory  - 20, 112, 39, null);
            }
        }
    }

    /**
     * Displaying a window close button.
     *
     * @param g class object Graphics.
     */
    public void renderExitSmall(Graphics g) {
        if (rectangleMouse.intersects(xInventory + 620, yInventory - 10, 64,64)) {
            g.drawImage(Assets.button_exit_small[1], xInventory + 620,yInventory - 10, 64, 64, null);
            if (handler.getMouseManager().isRightClick() || handler.getMouseManager().isLeftClick()) {
                active = false;
                activeItem = null;
            }
        } else {
            g.drawImage(Assets.button_exit_small[0], xInventory + 620,yInventory - 10, 64, 64, null);
        }
    }

    /**
     * Displaying inventory contents.
     *
     * @param g  class object Graphics.
     */
    public void renderItem(Graphics g) {
        for (Item i: inventoryItem) {
            if (i.getCount() > 0) {
                g.drawImage(getImageItem(i), (xItemInventory + xItemCount * (distanceItems + widthItemInventory)),
                        (yItemInventory + yItemCount * (distanceItems + heightItemInventory)),
                        widthItemInventory, heightItemInventory, null);
                renderItemNumber(g, i);
                xItemCount++;
                if (xItemCount == 6) {
                    xItemCount = 0;
                    xNumberCount = 0;
                    yItemCount++;
                }
            }
            renderItemDescription(g, i);
        }
    }

    /**
     * Display of numbers indicating the number of items of each type in the inventory
     *
     * @param g class object Graphics.
     * @param item class object Item.
     */
    public void renderItemNumber(Graphics g, Item item) {
        int number  = item.count;
        xNumberCount = 0;
        // List with numbers.
        List<Integer> numeralArray = new ArrayList<>();
        while (number > 0) {
            numeralArray.add(number % 10);
            number /= 10;
        }
        for (int i = numeralArray.toArray().length - 1; i >= 0; i--) {
            int distanceNumerals = 6;
            int distanceNumber = 48;
            g.drawImage(getImageCountItem(numeralArray.get(i)), (xItemInventory + xNumberCount * distanceNumerals
                    + xItemCount * distanceNumber - 10), (yItemInventory + yItemCount * (distanceItems +
                    heightItemInventory) - 10), widthItemInventory, heightItemInventory, null);
            xNumberCount++;
        }
    }

    /**
     * Display item description on hover.
     *
     * @param g class object Graphics.
     * @param i class object Item.
     */
    public void renderItemDescription(Graphics g, Item i) {
        if (rectangleMouse.intersects((xItemInventory - widthItemInventory * 1.5 + xItemCount * (distanceItems +
                        widthItemInventory)), (yItemInventory + yItemCount * (distanceItems + heightItemInventory)),
                widthItemInventory, heightItemInventory) && i.getCount() > 0) {
            g.drawImage(getImageItemDescription(i), (xItemInventory - widthItemInventory + (xItemCount - 1) *
                            (distanceItems + widthItemInventory)), (yItemInventory - 100 + yItemCount * (distanceItems +
                            heightItemInventory)), widthItemInventory * 3, heightItemInventory * 3, null);
            if (handler.getMouseManager().isLeftClick() || handler.getMouseManager().isRightClick()) {
                activeItem = i;
                xActiveItem = xItemCount - 1;
                yActiveItem = yItemCount;
            }
        }
    }

    /**
     * Changing the characteristics of the player depending on the equipment worn.
     *
     * @param i class object Item.
     */
    public void useActiveItem(Item i) {
        int healthCurrent = player.getMaxHealth();
        int attackCurrent = player.getPowerAttack();

        if (i.id == 0 && (player.getHealth() < player.getMaxHealth())) {
            player.setHealth(player.getHealth() + 1000);
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 1 && (player.getHealth() < player.getMaxHealth())) {
            player.setHealth(player.getHealth() + 500);
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 2 && player.getMana() < player.getDefaultMana()) {
            player.setMana( player.getMana() + 100);
            if (player.getPoisoning() <= player.getMaxPoisoning()) player.setPoisoning(player.getPoisoning() + 10);
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 3 && player.getPoisoning() <= player.getMaxPoisoning()
                && player.getPoisoning() >= player.getDefaultPoisoning()) {
            if (player.getPoisoning() >= player.getDefaultPoisoning()) player.setPoisoning(player.getPoisoning() - 10);
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 4 && player.getHealth() < player.getMaxHealth()) {
            player.setHealth(player.getHealth() + 1000);
            if (player.getPoisoning() <= player.getMaxPoisoning()) player.setPoisoning(player.getPoisoning() + 10);
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 5) {
            attack += 5;
            if (activeRing != null) attack = attackCurrent / 2;
            activeRing = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 6) {
            maxHealth = healthCurrent * 2;
            if (activeRing != null) attack -= 5;
            activeRing = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 7) {
            attack += 10;
            if (activeAmulet != null) maxHealth = healthCurrent / 2;
            activeAmulet = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 8) {
            maxHealth = healthCurrent * 2;
            if (activeAmulet != null) attack -= 10;
            activeAmulet = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 9) {
            maxHealth += 100;
            if (activeBoots != null && activeBoots.id == 10)  maxHealth -= 1000;
            if (activeBoots != null && activeBoots.id == 11)  maxHealth -= 10000;
            activeBoots = i;
            setActiveBoots(activeBoots);
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 10) {
            maxHealth += 1000;
            if (activeBoots != null && activeBoots.id == 9)  maxHealth -= 100;
            if (activeBoots != null && activeBoots.id == 10)  maxHealth -= 1000;
            activeBoots = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 11) {
            maxHealth += 10000;
            if (activeBoots != null && activeBoots.id == 9)  maxHealth -= 100;
            if (activeBoots != null && activeBoots.id == 11)  maxHealth -= 10000;
            activeBoots = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 12) {
            maxHealth += 100;
            if (activeGloves != null && activeGloves.id == 13)  maxHealth -= 1000;
            if (activeGloves != null && activeGloves.id == 14)  maxHealth -= 10000;
            activeGloves = i;
            activeItem = null;
            i.setCount(i.getCount() - 1);
        } else if (i.id == 13) {
            maxHealth += 1000;
            if (activeGloves != null && activeGloves.id == 12)  maxHealth -= 100;
            if (activeGloves != null && activeGloves.id == 14)  maxHealth -= 10000;
            activeGloves = i;
            activeItem = null;
            i.setCount(i.getCount() - 1);
        } else if (i.id == 14) {
            maxHealth += 10000;
            if (activeGloves != null && activeGloves.id == 12)  maxHealth -= 100;
            if (activeGloves != null && activeGloves.id == 13)  maxHealth -= 1000;
            activeGloves = i;
            activeItem = null;
            i.setCount(i.getCount() - 1);
        } else if (i.id == 15) {
            maxHealth += 100;
            if (activeHead != null && activeHead.id == 16)  maxHealth -= 1000;
            if (activeHead != null && activeHead.id == 17)  maxHealth -= 10000;
            activeHead = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        }  else if (i.id == 16) {
            maxHealth += 1000;
            if (activeHead != null && activeHead.id == 15)  maxHealth -= 100;
            if (activeHead != null && activeHead.id == 17)  maxHealth -= 10000;
            activeHead = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 17) {
            maxHealth += 10000;
            if (activeHead != null && activeHead.id == 15)  maxHealth -= 100;
            if (activeHead != null && activeHead.id == 16)  maxHealth -= 1000;
            activeHead = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 18) {
            maxHealth += 1000;
            if (activeShield != null && activeShield.id == 19) maxHealth -= 10000;
            activeShield = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 19) {
            maxHealth += 10000;
            if (activeShield != null && activeShield.id == 18)  maxHealth -= 1000;
            activeShield = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 20) {
            maxHealth += 100;
            if (activeTorso != null && activeTorso.id == 21)  maxHealth -= 1000;
            if (activeTorso != null && activeTorso.id == 22)  maxHealth -= 10000;
            activeTorso = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 21) {
            maxHealth += 1000;
            if (activeTorso != null && activeTorso.id == 20)  maxHealth -= 100;
            if (activeTorso != null && activeTorso.id == 22)  maxHealth -= 10000;
            activeTorso = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 22) {
            maxHealth += 10000;
            if (activeTorso != null && activeTorso.id == 20)  maxHealth -= 100;
            if (activeTorso != null && activeTorso.id == 21)  maxHealth -= 1000;
            activeTorso = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        }  else if (i.id == 23) {
            attack += 5;
            if (activeWeapon != null && activeWeapon.id == 24) attack -= 10;
            if (activeWeapon != null && activeWeapon.id == 25) attack -= 15;
            activeWeapon = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 24) {
            attack += 10;
            if (activeWeapon != null && activeWeapon.id == 23) attack -= 5;
            if (activeWeapon != null && activeWeapon.id == 25) attack -= 15;
            activeWeapon = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 25) {
            attack += 15;
            if (activeWeapon != null && activeWeapon.id == 23) attack -= 5;
            if (activeWeapon != null && activeWeapon.id == 24) attack -= 10;
            activeWeapon = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 27) {
            maxHealth += 100;
            if (activePants != null && activePants.id == 28) maxHealth -= 1000;
            if (activePants != null && activePants.id == 29) maxHealth -= 10000;
            activePants = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 28) {
            maxHealth += 1000;
            if (activePants != null && activePants.id == 27) maxHealth -= 100;
            if (activePants != null && activePants.id == 29) maxHealth -= 10000;
            activePants = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        } else if (i.id == 29) {
            maxHealth += 10000;
            if (activePants != null && activePants.id == 28) maxHealth -= 1000;
            if (activePants != null && activePants.id == 29) maxHealth -= 10000;
            activePants = i;
            i.setCount(i.getCount() - 1);
            activeItem = null;
        }
        player.setMaxHealth(healthCurrent + maxHealth);
        player.setPowerAttack(attackCurrent + attack);
        maxHealth = 0;
        attack = 0;
    }

    /**
     *  Adding item to inventory.
     *
     * @param item class object Item.
     */
    public void addItem(Item item) {
        for (Item i: inventoryItem) {
            if (i.getId() == item.getId()) {
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItem.add(item);
    }

    /**
     * Getting an item in inventory.
     *
     * @param item class object Item.
     * @return bufferedImage by id.
     */
    public BufferedImage getImageItem(Item item) {
        if (item.id == 0) return Assets.itemApple;
        else if (item.id == 1) return Assets.itemStrawberry;
        else if (item.id == 2) return Assets.itemPotionBlue;
        else if (item.id == 3) return Assets.itemPotionWhite;
        else if (item.id == 4) return Assets.itemPotionRed;
        else if (item.id == 5) return Assets.itemRingAttack;
        else if (item.id == 6) return Assets.itemRingHealth;
        else if (item.id == 7) return Assets.itemAmuletAttack;
        else if (item.id == 8) return Assets.itemAmuletHealth;
        else if (item.id == 9) return Assets.itemBoot1;
        else if (item.id == 10) return Assets.itemBoot2;
        else if (item.id == 11) return Assets.itemBoot3;
        else if (item.id == 12) return Assets.itemGloves1;
        else if (item.id == 13) return Assets.itemGloves2;
        else if (item.id == 14) return Assets.itemGloves3;
        else if (item.id == 15) return Assets.itemHead1;
        else if (item.id == 16) return Assets.itemHead2;
        else if (item.id == 17) return Assets.itemHead3;
        else if (item.id == 18) return Assets.itemShield1;
        else if (item.id == 19) return Assets.itemShield2;
        else if (item.id == 20) return Assets.itemTorso1;
        else if (item.id == 21) return Assets.itemTorso2;
        else if (item.id == 22) return Assets.itemTorso3;
        else if (item.id == 23) return Assets.itemWeapon1;
        else if (item.id == 24) return Assets.itemWeapon2;
        else if (item.id == 25) return Assets.itemWeapon3;
        else if (item.id == 26) return Assets.itemKey;
        else if (item.id == 27) return Assets.itemPants1;
        else if (item.id == 28) return Assets.itemPants2;
        else if (item.id == 29) return Assets.itemPants3;
        return null;
    }

    /**
     * Getting an item in inventory.
     *
     *@param item class object Item.
     * @return bufferedImage by id.
     */
    public BufferedImage getImageItemDescription(Item item) {
        if (item.id == 0) return Assets.itemAppleDescription;
        else if (item.id == 1) return Assets.itemStrawberryDescription;
        else if (item.id == 2) return Assets.itemPotionBlueDescription;
        else if (item.id == 3) return Assets.itemPotionWhiteDescription;
        else if (item.id == 4) return Assets.itemPotionRedDescription;
        else if (item.id == 5) return Assets.itemRingAttackDescription;
        else if (item.id == 6) return Assets.itemRingHealthDescription;
        else if (item.id == 7) return Assets.itemAmuletHealthDescription;
        else if (item.id == 8) return Assets.itemAmuletAttackDescription;
        else if (item.id == 9) return Assets.itemBoot1Description;
        else if (item.id == 10) return Assets.itemBoot2Description;
        else if (item.id == 11) return Assets.itemBoot3Description;
        else if (item.id == 12) return Assets.itemGloves1Description;
        else if (item.id == 13) return Assets.itemGloves2Description;
        else if (item.id == 14) return Assets.itemGloves3Description;
        else if (item.id == 15) return Assets.itemHead1Description;
        else if (item.id == 16) return Assets.itemHead2Description;
        else if (item.id == 17) return Assets.itemHead3Description;
        else if (item.id == 18) return Assets.itemShield1Description;
        else if (item.id == 19) return Assets.itemShield2Description;
        else if (item.id == 20) return Assets.itemTorso1Description;
        else if (item.id == 21) return Assets.itemTorso2Description;
        else if (item.id == 22) return Assets.itemTorso3Description;
        else if (item.id == 23) return Assets.itemWeapon1Description;
        else if (item.id == 24) return Assets.itemWeapon2Description;
        else if (item.id == 25) return Assets.itemWeapon3Description;
        else if (item.id == 26) return Assets.itemKeyDescription;
        else if (item.id == 27) return Assets.itemPants1Description;
        else if (item.id == 28) return Assets.itemPants2Description;
        else if (item.id == 29) return Assets.itemPants3Description;
        return null;
    }

    /**
     * Getting an image of the number of items.
     *
     * @param i class object Item.
     * @return bufferedImage by id.
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

    // Getters and setters
    public Handler getHandler() { return handler; }

    public void setHandler(Handler handler) { this.handler = handler; }

    public void setActive(boolean active) { this.active = active; }

    public Item getActiveHead() { return activeHead; }

    public Item getActiveBoots() { return activeBoots; }

    public Item getActiveGloves() { return activeGloves; }

    public Item getActiveTorso() { return activeTorso; }

    public Item getActivePants() { return activePants; }

    public Item getActiveWeapon() { return activeWeapon; }

    public Item getActiveShield() { return activeShield; }

    public void setActiveBoots(Item activeBoots) { this.activeBoots = activeBoots; }

    public void setActiveAmulet(Item activeAmulet) { this.activeAmulet = activeAmulet; }

    public void setActiveHead(Item activeHead) { this.activeHead = activeHead; }

    public void setActiveGloves(Item activeGloves) { this.activeGloves = activeGloves; }

    public void setActiveRing(Item activeRing) { this.activeRing = activeRing; }

    public void setActiveTorso(Item activeTorso) { this.activeTorso = activeTorso; }

    public void setActivePants(Item activePants) { this.activePants = activePants; }

    public void setActiveWeapon(Item activeWeapon) { this.activeWeapon = activeWeapon; }

    public void setActiveShield(Item activeShield) { this.activeShield = activeShield; }

    public List<Item> getInventoryItem() { return inventoryItem; }
}