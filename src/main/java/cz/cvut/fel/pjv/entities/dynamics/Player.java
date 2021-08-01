package cz.cvut.fel.pjv.entities.dynamics;

import cz.cvut.fel.pjv.entities.Entity;
import cz.cvut.fel.pjv.graphics.Animation;
import cz.cvut.fel.pjv.graphics.Assets;
import cz.cvut.fel.pjv.inventory.Inventory;
import cz.cvut.fel.pjv.inventory.Item;
import cz.cvut.fel.pjv.main.Handler;
import cz.cvut.fel.pjv.main.Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;

public class Player extends EntityDynamic {

    // Creation of animation variables for movement, equipment, skills.
    private final Animation animationDownBody, animationUpBody, animationLeftBody, animationRightBody,
            animationDownBoots1, animationUpBoots1,  animationLeftBoots1, animationRightBoots1,
            animationDownBoots2, animationUpBoots2, animationLeftBoots2, animationRightBoots2,
            animationDownBoots3, animationUpBoots3, animationLeftBoots3, animationRightBoots3,
            animationDownHead1, animationUpHead1, animationLeftHead1, animationRightHead1,
            animationDownHead2, animationUpHead2, animationLeftHead2, animationRightHead2,
            animationDownHead3, animationUpHead3, animationLeftHead3, animationRightHead3,
            animationDownGloves1, animationUpGloves1, animationLeftGloves1, animationRightGloves1,
            animationDownGloves2, animationUpGloves2, animationLeftGloves2, animationRightGloves2,
            animationDownGloves3, animationUpGloves3, animationLeftGloves3, animationRightGloves3,
            animationDownTorso1, animationUpTorso1, animationLeftTorso1, animationRightTorso1,
            animationDownTorso2, animationUpTorso2, animationLeftTorso2, animationRightTorso2,
            animationDownTorso3, animationUpTorso3, animationLeftTorso3, animationRightTorso3,
            animationDownPants1, animationUpPants1, animationLeftPants1, animationRightPants1,
            animationDownPants2, animationUpPants2, animationLeftPants2, animationRightPants2,
            animationDownPants3, animationUpPants3, animationLeftPants3, animationRightPants3,
            animationDownShield1, animationUpShield1, animationLeftShield1,
            animationDownShield2, animationUpShield2, animationLeftShield2,
            animationDownWeapon1, animationUpWeapon1, animationRightWeapon1,
            animationDownWeapon2, animationUpWeapon2, animationRightWeapon2,
            animationDownWeapon3, animationUpWeapon3, animationRightWeapon3,
            animationSkill1,
            animationUpSkill2,
            animationDownSkill3, animationUpSkill3, animationRightSkill3, animationLeftSkill3;

    // The last position of the character when moving.
    private BufferedImage stateEndMove = Assets.player_down[1],
            stateEndMoveBoots, stateEndMoveHead, stateEndMoveGloves, stateEndMoveTorso, stateEndMovePants,
            stateEndMoveShield, stateEndMoveWeapon;

    // Timer attacks.
    private long lastAttackTimer; // Time last attack in milliseconds.
    private final long rechargeAttack = 80; // Reload time until next attack in milliseconds.
    private long attackTimer = rechargeAttack; // Attack time in milliseconds.
    private boolean attack = false; // No attack.
    public int powerAttack = 10; // Default attack strength.

    public int maxHealth, mana, poisoning, key;
    private static final int DEFAULT_MANA = 10000, DEFAULT_POISONING = 0, MAX_POISONING = 100;

    private List<Item> inventoryItem; // List of items in inventory.
    public Inventory inventory;

    /**
     * @param handler class object Handler.
     * @param x the x-coordinate in pixels of the upper-left corner of the rectangle of the player image.
     * @param y the y-coordinate in pixels of the upper-left corner of the rectangle of the player image.
     */
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, 64, 64, 10000);

        // The player's rectangle is used for clashes and fights.
        bounds.x = 16;
        bounds.y = 28;
        bounds.width = 32;
        bounds.height = 28;

        // Characteristics player.
        mana = DEFAULT_MANA;
        poisoning = DEFAULT_POISONING;
        maxHealth = health;

        // Create animation.
        animationDownBody = new Animation(100, Assets.player_down);
        animationUpBody = new Animation(100, Assets.player_up);
        animationLeftBody = new Animation(100, Assets.player_left);
        animationRightBody = new Animation(100, Assets.player_right);

        animationDownBoots1 = new Animation(100, Assets.player_down_boots1);
        animationUpBoots1 = new Animation(100, Assets.player_up_boots1);
        animationLeftBoots1 = new Animation(100, Assets.player_left_boots1);
        animationRightBoots1 = new Animation(100, Assets.player_right_boots1);

        animationDownBoots2 = new Animation(100, Assets.player_down_boots2);
        animationUpBoots2 = new Animation(100, Assets.player_up_boots2);
        animationLeftBoots2 = new Animation(100, Assets.player_left_boots2);
        animationRightBoots2 = new Animation(100, Assets.player_right_boots2);

        animationDownBoots3 = new Animation(100, Assets.player_down_boots3);
        animationUpBoots3 = new Animation(100, Assets.player_up_boots3);
        animationLeftBoots3 = new Animation(100, Assets.player_left_boots3);
        animationRightBoots3 = new Animation(100, Assets.player_right_boots3);

        animationDownHead1 = new Animation(100, Assets.player_down_head1);
        animationUpHead1 = new Animation(100, Assets.player_up_head1);
        animationLeftHead1 = new Animation(100, Assets.player_left_head1);
        animationRightHead1 = new Animation(100, Assets.player_right_head1);

        animationDownHead2 = new Animation(100, Assets.player_down_head2);
        animationUpHead2 = new Animation(100, Assets.player_up_head2);
        animationLeftHead2 = new Animation(100, Assets.player_left_head2);
        animationRightHead2 = new Animation(100, Assets.player_right_head2);

        animationDownHead3 = new Animation(100, Assets.player_down_head3);
        animationUpHead3 = new Animation(100, Assets.player_up_head3);
        animationLeftHead3 = new Animation(100, Assets.player_left_head3);
        animationRightHead3 = new Animation(100, Assets.player_right_head3);

        animationDownGloves1 = new Animation(100, Assets.player_down_gloves1);
        animationUpGloves1 = new Animation(100, Assets.player_up_gloves1);
        animationLeftGloves1 = new Animation(100, Assets.player_left_gloves1);
        animationRightGloves1 = new Animation(100, Assets.player_right_gloves1);

        animationDownGloves2 = new Animation(100, Assets.player_down_gloves2);
        animationUpGloves2 = new Animation(100, Assets.player_up_gloves2);
        animationLeftGloves2 = new Animation(100, Assets.player_left_gloves2);
        animationRightGloves2 = new Animation(100, Assets.player_right_gloves2);

        animationDownGloves3 = new Animation(100, Assets.player_down_gloves3);
        animationUpGloves3 = new Animation(100, Assets.player_up_gloves3);
        animationLeftGloves3 = new Animation(100, Assets.player_left_gloves3);
        animationRightGloves3 = new Animation(100, Assets.player_right_gloves3);

        animationDownPants1 = new Animation(100, Assets.player_down_pants1);
        animationUpPants1 = new Animation(100, Assets.player_up_pants1);
        animationLeftPants1 = new Animation(100, Assets.player_left_pants1);
        animationRightPants1 = new Animation(100, Assets.player_right_pants1);

        animationDownPants2 = new Animation(100, Assets.player_down_pants2);
        animationUpPants2 = new Animation(100, Assets.player_up_pants2);
        animationLeftPants2 = new Animation(100, Assets.player_left_pants2);
        animationRightPants2 = new Animation(100, Assets.player_right_pants2);

        animationDownPants3 = new Animation(100, Assets.player_down_pants3);
        animationUpPants3 = new Animation(100, Assets.player_up_pants3);
        animationLeftPants3 = new Animation(100, Assets.player_left_pants3);
        animationRightPants3 = new Animation(100, Assets.player_right_pants3);

        animationDownTorso1 = new Animation(100, Assets.player_down_torso1);
        animationUpTorso1 = new Animation(100, Assets.player_up_torso1);
        animationLeftTorso1 = new Animation(100, Assets.player_left_torso1);
        animationRightTorso1 = new Animation(100, Assets.player_right_torso1);

        animationDownTorso2 = new Animation(100, Assets.player_down_torso2);
        animationUpTorso2 = new Animation(100, Assets.player_up_torso2);
        animationLeftTorso2 = new Animation(100, Assets.player_left_torso2);
        animationRightTorso2 = new Animation(100, Assets.player_right_torso2);

        animationDownTorso3 = new Animation(100, Assets.player_down_torso3);
        animationUpTorso3 = new Animation(100, Assets.player_up_torso3);
        animationLeftTorso3 = new Animation(100, Assets.player_left_torso3);
        animationRightTorso3 = new Animation(100, Assets.player_right_torso3);

        animationDownShield1 = new Animation(100, Assets.player_down_shield1);
        animationUpShield1 = new Animation(100, Assets.player_up_shield1);
        animationLeftShield1 = new Animation(100, Assets.player_left_shield1);

        animationDownShield2 = new Animation(100, Assets.player_down_shield2);
        animationUpShield2 = new Animation(100, Assets.player_up_shield2);
        animationLeftShield2 = new Animation(100, Assets.player_left_shield2);

        animationDownWeapon1 = new Animation(100, Assets.player_down_weapon1);
        animationUpWeapon1 = new Animation(100, Assets.player_up_weapon1);
        animationRightWeapon1 = new Animation(100, Assets.player_right_weapon1);

        animationDownWeapon2 = new Animation(100, Assets.player_down_weapon2);
        animationUpWeapon2 = new Animation(100, Assets.player_up_weapon2);
        animationRightWeapon2 = new Animation(100, Assets.player_right_weapon2);

        animationDownWeapon3 = new Animation(100, Assets.player_down_weapon3);
        animationUpWeapon3 = new Animation(100, Assets.player_up_weapon3);
        animationRightWeapon3 = new Animation(100, Assets.player_right_weapon3);

        animationSkill1 = new Animation(100, Assets.skill1_1);

        animationUpSkill2 = new Animation(100, Assets.skill_2);

        animationDownSkill3 = new Animation(20, Assets.skill_3_down);
        animationUpSkill3 = new Animation(20, Assets.skill_3_up);
        animationRightSkill3 = new Animation(20, Assets.skill_3_right);
        animationLeftSkill3 = new Animation(20, Assets.skill_3_left);

        inventory = new Inventory(handler); // Creating inventory.

        setSpeed(4.0f); // Setting the speed of movement.
    }

    @Override
    public void update() {
        updateAnimationMove();

        animationSkill1.update();
        animationUpSkill2.update();
        animationDownSkill3.update();
        animationUpSkill3.update();
        animationRightSkill3.update();
        animationLeftSkill3.update();

        getInput();
        move();

        handler.getCamera().centerOnEntity(this); // Camera position setting.
        inventory.update();
        for (Item i: inventory.getInventoryItem()) {
            if (i.getId() == 26) key = i.getCount();
        }

        checkAttack();
        setHealthWhenPotionMax();
        drinkPotion();
        eatingFood();
    }

    /**
     * Changing characteristics depending on the used potion. Quantity update.
     */
    public void drinkPotion() {
        inventoryItem = inventory.inventoryItem;
        for (Item i: inventoryItem) {
            if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_6)
                    && i.getId() == 2 && i.getCount() > 0 && getMana() < DEFAULT_MANA) {
                setMana(getMana() + 1000); // Increase the player's mana value.

                // Control that the value does not exceed the maximum possible.
                if (getMana() > getDefaultMana()) setMana(getDefaultMana());

                // Correction of poisoning if it is not maximal.
                if (getPoisoning() <= MAX_POISONING) {
                    setPoisoning(getPoisoning() + 10); // Increased player poisoning value.

                    // Control that the value poisoning does not exceed the maximum possible.
                    if (getPoisoning() > getMaxPoisoning()) setPoisoning(getMaxPoisoning());
                }
                i.setCount(i.getCount() - 1); // Reducing the amount of potion mana in inventory.
                Main.getLOG().info("One mana potion was drunk. Mana values: " + getMana() + "/" + DEFAULT_MANA +
                        ". The poisoning has increased. Poisoning value: " + getPoisoning() + "/" + MAX_POISONING  +  ".");
            } else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_7) && i.getId() == 4 && i.getCount() > 0 &&
                    getHealth() < maxHealth) {
                setHealth(getHealth() + 1000);  // Increase the player's health value.

                // Control that the value does not exceed the maximum possible
                if (getHealth() > getMaxHealth()) setHealth(getMaxHealth());

                // Correction of poisoning if it is not maximal.
                if (getPoisoning() <= MAX_POISONING) {
                    setPoisoning(getPoisoning() + 10); // Increased player poisoning value.

                    // Control that the value does not exceed the maximum possible.
                    if (getPoisoning() > getMaxPoisoning()) setPoisoning(getMaxPoisoning());
                }
                i.setCount(i.getCount() - 1); // Reducing the amount of potion health in inventory.
                Main.getLOG().info("One health potion was drunk. Health values: " + getHealth() + "/" +
                        getMaxHealth() + ". The poisoning has increased. Poisoning value: " + getPoisoning()
                        + "/" + MAX_POISONING  +  ".");
            } else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_8) && getPoisoning() <= MAX_POISONING
                    && getPoisoning() > DEFAULT_POISONING && i.getId() == 3 && i.getCount() > 0) {
                setPoisoning(getPoisoning() - 10); // Reducing player poisoning

                // Control that the value is not less than the minimum possible value
                if (getPoisoning() < getDefaultPoisoning()) setPoisoning(getDefaultPoisoning());

                i.setCount(i.getCount() - 1); // Reducing the amount of potion poisoning in inventory.
                Main.getLOG().info("One poisoning potion was drunk. Poisoning values: " + getPoisoning() + "/"
                        + MAX_POISONING + ".");
            }
        }
    }

    /**
     * Changes in characteristics depending on the fruit used. Quantity update.
     */
    public void eatingFood() {
        inventoryItem = handler.getWorld().getEntityManager().getPlayer().getInventory().inventoryItem;

        for (Item i: inventoryItem) {
            if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_9) && i.getId() == 0 && getHealth() < maxHealth
                    && i.getCount() > 0) {
                setHealth(getHealth() + 1000); // Increase the player's health value.
                i.setCount(i.getCount() - 1); // Reducing the amount of apples in inventory.

                // Control that the value does not exceed the maximum possible.
                if (getHealth() > getMaxHealth()) setHealth(getMaxHealth());
                Main.getLOG().info("One apple was eaten. Health values: " + getHealth() + "/" + getMaxHealth() + ".");
            } else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_0) && i.getId() == 1 &&
                    getHealth() < maxHealth && i.getCount() > 0) {
                setHealth(getHealth() + 500); // Increase the player's health value.
                i.setCount(i.getCount() - 1); // Reducing the amount of strawberries in inventory.

                // Control that the value does not exceed the maximum possible.
                if (getHealth() > getMaxHealth()) setHealth(getMaxHealth());
                Main.getLOG().info("One strawberry was eaten. Health values: " + getHealth() + "/" + getMaxHealth() + ".");
            }
        }
    }

    /**
     *  Decrease in health, if the poisoning is maximum.
     */
    public void setHealthWhenPotionMax() {
        if (getPoisoning() >= MAX_POISONING) {
            setHealth(getHealth() - 5);
            Main.getLOG().info("Poisoning is maximum. Health decreases." + getHealth() + "/" + getMaxHealth() + ".");
        }
        else setHealth(health);
    }

    /**
     * Updating the actual animation for movement. Only active equipment animations are updated.
     */
    public void updateAnimationMove() {

        // Body animation update.
        animationDownBody.update();
        animationUpBody.update();
        animationLeftBody.update();
        animationRightBody.update();

        // Shoes animation update.
        if (getInventory() != null && getInventory().getActiveBoots() != null) {
            if (getInventory().getActiveBoots().getId() == 9) {
                animationDownBoots1.update();
                animationUpBoots1.update();
                animationLeftBoots1.update();
                animationRightBoots1.update();
            } else if (getInventory().getActiveBoots().getId() == 10) {
                animationDownBoots2.update();
                animationUpBoots2.update();
                animationLeftBoots2.update();
                animationRightBoots2.update();
            }else if (getInventory().getActiveBoots().getId() == 11) {
                animationDownBoots3.update();
                animationUpBoots3.update();
                animationLeftBoots3.update();
                animationRightBoots3.update();
            }
        }

        // Glove animation update.
        if (getInventory() != null && getInventory().getActiveGloves() != null) {
            if (getInventory().getActiveGloves().getId() == 12) {
                animationDownGloves1.update();
                animationUpGloves1.update();
                animationLeftGloves1.update();
                animationRightGloves1.update();
            } else if (getInventory().getActiveGloves().getId() == 13) {
                animationDownGloves2.update();
                animationUpGloves2.update();
                animationLeftGloves2.update();
                animationRightGloves2.update();
            }else if (getInventory().getActiveGloves().getId() == 14) {
                animationDownGloves3.update();
                animationUpGloves3.update();
                animationLeftGloves3.update();
                animationRightGloves3.update();
            }
        }

        // Helmet animation update.
        if (getInventory() != null && getInventory().getActiveHead() != null) {
            if (getInventory().getActiveHead().getId() == 15) {
                animationDownHead1.update();
                animationUpHead1.update();
                animationLeftHead1.update();
                animationRightHead1.update();
            } else if (getInventory().getActiveHead().getId() == 16) {
                animationDownHead2.update();
                animationUpHead2.update();
                animationLeftHead2.update();
                animationRightHead2.update();
            }else if (getInventory().getActiveHead().getId() == 17) {
                animationDownHead3.update();
                animationUpHead3.update();
                animationLeftHead3.update();
                animationRightHead3.update();
            }
        }

        // Armor animation update.
        if (getInventory() != null && getInventory().getActiveTorso() != null) {
            if (getInventory().getActiveTorso().getId() == 20) {
                animationDownTorso1.update();
                animationUpTorso1.update();
                animationLeftTorso1.update();
                animationRightTorso1.update();
            } else if (getInventory().getActiveTorso().getId() == 21) {
                animationDownTorso2.update();
                animationUpTorso2.update();
                animationLeftTorso2.update();
                animationRightTorso2.update();
            }else if (getInventory().getActiveTorso().getId() == 22) {
                animationDownTorso3.update();
                animationUpTorso3.update();
                animationLeftTorso3.update();
                animationRightTorso3.update();
            }
        }

        // Pants animation update.
        if (getInventory() != null && getInventory().getActivePants() != null) {
            if (getInventory().getActivePants().getId() == 20) {
                animationDownPants1.update();
                animationUpPants1.update();
                animationLeftPants1.update();
                animationRightPants1.update();
            } else if (getInventory().getActivePants().getId() == 21) {
                animationDownPants2.update();
                animationUpPants2.update();
                animationLeftPants2.update();
                animationRightPants2.update();
            }else if (getInventory().getActivePants().getId() == 22) {
                animationDownPants3.update();
                animationUpPants3.update();
                animationLeftPants3.update();
                animationRightPants3.update();
            }
        }

        // Shield animation update.
        if (getInventory() != null && getInventory().getActiveShield() != null) {
            if (getInventory().getActiveShield().getId() == 18) {
                animationDownShield1.update();
                animationUpShield1.update();
                animationLeftShield1.update();
            } else if (getInventory().getActiveShield().getId() == 19) {
                animationDownShield2.update();
                animationUpShield2.update();
                animationLeftShield2.update();
            }
        }

        // Weapon animation update.
        if (getInventory() != null && getInventory().getActiveWeapon() != null) {
            if (getInventory().getActiveWeapon().getId() == 23) {
                animationDownWeapon1.update();
                animationUpWeapon1.update();
                animationRightWeapon1.update();
            } else if (getInventory().getActiveWeapon().getId() == 24) {
                animationDownWeapon2.update();
                animationUpWeapon2.update();
                animationRightWeapon2.update();
            } else if (getInventory().getActiveWeapon().getId() == 25) {
                animationDownWeapon3.update();
                animationUpWeapon3.update();
                animationRightWeapon3.update();
            }
        }
    }

    /**
     * Checks if the player can attack.
     */
    public void checkAttack() {

        attackTimer += System.currentTimeMillis() - lastAttackTimer; // Attack time in milliseconds.
        lastAttackTimer = System.currentTimeMillis(); // How much time has passed until now.
        if (attackTimer < rechargeAttack) return; // If the player cannot yet attack.

        // There will be no gap between the player and the collision object.
        Rectangle rc = getCollisionBounds(0f, 0f);

        // Rectangles for player and entity interaction.
        Rectangle rectangleBaseAttack = new Rectangle(); // Basic attack (gathering food, opening chests, skill 1).
        Rectangle rectangleSkill2 = new Rectangle(); // Attack rectangle for skill 2.
        Rectangle rectangleSkill3 = new Rectangle(); // Attack rectangle for skill 3.

        int raSize = 30; // Used to define the base attack rectangle.

        // Setting the width and height of the rectangle.
        rectangleBaseAttack.width = raSize;
        rectangleBaseAttack.height = raSize;
        // Depending on the direction of attack, the position of the attack rectangle changes.
        if (stateEndMove == Assets.player_left[1]) {
            rectangleBaseAttack.x = rc.x - raSize;
            rectangleBaseAttack.y = rc.y + rc.height / 2 - raSize / 2;
        } else if (stateEndMove == Assets.player_right[1]) {
            rectangleBaseAttack.x = rc.x + rc.width;
            rectangleBaseAttack.y = rc.y + rc.height / 2 - raSize / 2;
        } else if (stateEndMove == Assets.player_up[1]) {
            rectangleBaseAttack.x = rc.x + rc.width / 2 - raSize / 2;
            rectangleBaseAttack.y = rc.y - raSize;
        } else{
            rectangleBaseAttack.x = rc.x + rc.width / 2 - raSize / 2;
            rectangleBaseAttack.y = rc.y + rc.height;
        }

        // Setting the width and height of the rectangle.
        rectangleSkill2.x = rc.x - 2*raSize;
        rectangleSkill2.y = rc.y - 2 * raSize;
        rectangleSkill2.width = 5 * raSize;
        rectangleSkill2.height = 5 * raSize;

        // Depending on the direction of attack, the position of the attack rectangle changes.
        if (stateEndMove == Assets.player_left[1]) {
            rectangleSkill3.x = rc.x - 6 * raSize;
            rectangleSkill3.y = rc.y + rc.height / 2 - raSize / 2;
            rectangleSkill3.width = 6 * raSize;
            rectangleSkill3.height =raSize;
        } else if (stateEndMove == Assets.player_right[1]) {
            rectangleSkill3.x = rc.x + rc.width;
            rectangleSkill3.y = rc.y + rc.height / 2 - raSize / 2;
            rectangleSkill3.width =  6 * raSize;
            rectangleSkill3.height =raSize;
        } else if (stateEndMove == Assets.player_up[1]) {
            rectangleSkill3.x = rc.x + rc.width / 2 - raSize / 2;
            rectangleSkill3.y = rc.y - 6 * raSize;
            rectangleSkill3.width = raSize;
            rectangleSkill3.height = 6*raSize;
        } else {
            rectangleSkill3.x = (rc.x + (rc.width / 2)) - (raSize / 2);
            rectangleSkill3.y = rc.y + rc.height;
            rectangleSkill3.width = raSize;
            rectangleSkill3.height = 6 * raSize;
        }

        // Updating variables for calculating attack potential.
        attackTimer = 0;
        attack = false;

        // Damage dealt on basic attack collecting fruits, opening chests.
        for (Entity entity : handler.getWorld().getEntityManager().getEntitiesStatic()) {
            if (entity.equals(this)) continue; // Prevents the player from interacting with himself.
            if (equalsChest(entity)
                    && handler.getKeyManager().openChest
                    && entity.getCollisionBounds(0, 0).intersects(rectangleBaseAttack)
                    && key > 0) {
                entity.damageDealt(powerAttack); // Reducing the amount of life of the chest.
                for (Item i: inventory.getInventoryItem()) {
                    if (i.getId() == 26) i.setCount(key - 1);
                }
            } else if (!equalsChest(entity)
                    && entity.getCollisionBounds(0, 0).intersects(rectangleBaseAttack)
                    && handler.getKeyManager().pick) {
                entity.damageDealt(powerAttack*2); // Decrease in the amount of food life.
            }
        }

        // Dealing damage to moving objects using skills. Each use reduces mana.
        for (Entity entity : handler.getWorld().getEntityManager().getEntitiesDynamic()) {
            if (!equalsChest(entity)
                    && entity.getCollisionBounds(0, 0).intersects(rectangleBaseAttack)
                    && handler.getKeyManager().skill1
                    && handler.getWorld().getEntityManager().getPlayer().getMana() > 0) {
                entity.damageDealt(powerAttack); // Reducing the life of the object that is attacked.
                handler.getWorld().getEntityManager().getPlayer().setMana(getMana() - 5); // Reducing the mana of the object that attacks.
                attack = true;
            } else if (!equalsChest(entity)
                    && entity.getCollisionBounds(0, 0).intersects(rectangleSkill2)
                    && handler.getKeyManager().skill2
                    && handler.getWorld().getEntityManager().getPlayer().getMana() > 0) {
                entity.damageDealt(powerAttack*2); // Reducing the life of the object that is attacked.
                handler.getWorld().getEntityManager().getPlayer().setMana(getMana() - 10); // Reducing the mana of the object that attacks.
                attack = true;
            }  else if (!equalsChest(entity)
                    && entity.getCollisionBounds(0, 0).intersects(rectangleSkill3)
                    && handler.getKeyManager().skill3
                    && handler.getWorld().getEntityManager().getPlayer().getMana() > 0) {
                entity.damageDealt(powerAttack*3); // Reducing the life of the object that is attacked.
                handler.getWorld().getEntityManager().getPlayer().setMana(getMana() - 20); //Reducing the mana of the object that attacks.
                attack = true;
            }
        }
    }

    /**
     * Returns whether the player can interact with the chest. Only one can be opened at a time.
     *
     * @param entity class object Entity.
     * @return true if the player is near the given chest, otherwise returns false.
     */
    public boolean equalsChest(Entity entity) {
        for (Entity e: handler.getWorld().getEntityManager().getEntitiesChest()) {
            if (entity.equals(e))  return true;
        }
        return false;
    }

    @Override
    public void render(Graphics g) {
        // Displays the effects of attacks with skills.
        if (handler.getKeyManager().skill1  && getMana() > 0) {
            renderAnimationMove(g);
            g.drawImage(getCurrentAnimationImageSkill1(), (int) (x - handler.getCamera().getxOffSet()),
                    (int) (y - handler.getCamera().getyOffSet()), width, height, null);

        } else if (handler.getKeyManager().skill2  && getMana() > 0) {
            g.drawImage(getCurrentAnimationImageSkill2(), (int) (x - handler.getCamera().getxOffSet() - 3/2*width),
                    (int) (y - handler.getCamera().getyOffSet() - 3/2*height),  3*width, 3*height, null);
            g.drawImage(getCurrentAnimationImageBody(), (int) (x - handler.getCamera().getxOffSet()),
                    (int) (y - handler.getCamera().getyOffSet()), width, height, null);

        } else if (handler.getKeyManager().skill3  && getMana() > 0) {
            if(stateEndMove == Assets.player_right[1]) {
                g.drawImage(getCurrentAnimationImageSkill3(), (int) (x - handler.getCamera().getxOffSet()+ width),
                        (int) (y - handler.getCamera().getyOffSet()), 3 * width, height, null);
            } else if (stateEndMove == Assets.player_left[1]) {
                g.drawImage(getCurrentAnimationImageSkill3(), (int) (x - handler.getCamera().getxOffSet() - 3 * width),
                        (int) (y - handler.getCamera().getyOffSet()), 3 * width, height, null);
            }
            else if (stateEndMove == Assets.player_down[1]) {
                g.drawImage(getCurrentAnimationImageSkill3(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()+ height), width, 3*height, null);
            } else {
                g.drawImage(getCurrentAnimationImageSkill3(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()-3*height), width, 3*height, null);
            }

        }
        renderAnimationMove(g);
    }

    /**
     * Displays the player's movement on the screen.
     *
     * @param g class object Graphics.
     */
    public void renderAnimationMove(Graphics g) {
        g.drawImage(getCurrentAnimationImageBody(), (int) (x - handler.getCamera().getxOffSet()),
                (int) (y - handler.getCamera().getyOffSet()), width, height, null);
        if (getInventory() != null && getInventory().getActivePants() != null) {
            if (getInventory().getActivePants().getId() == 27)
                g.drawImage(getCurrentAnimationImagePants1(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            if (getInventory().getActivePants().getId() == 28)
                g.drawImage(getCurrentAnimationImagePants2(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            if (getInventory().getActivePants().getId() == 29)
                g.drawImage(getCurrentAnimationImagePants3(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
        }
        if (getInventory() != null && getInventory().getActiveBoots() != null) {
            if (getInventory().getActiveBoots().getId() == 9)
                g.drawImage(getCurrentAnimationImageBoots1(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            else if(getInventory().getActiveBoots().getId() == 10)
                g.drawImage(getCurrentAnimationImageBoots2(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            else if(getInventory().getActiveBoots().getId() == 11)
                g.drawImage(getCurrentAnimationImageBoots3(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
        }
        if (getInventory() != null && getInventory().getActiveHead() != null) {
            if (getInventory().getActiveHead().getId() == 15)
                g.drawImage(getCurrentAnimationImageHead1(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            if (getInventory().getActiveHead().getId() == 16)
                g.drawImage(getCurrentAnimationImageHead2(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            if (getInventory().getActiveHead().getId() == 17)
                g.drawImage(getCurrentAnimationImageHead3(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
        }
        if (getInventory() != null && getInventory().getActiveTorso() != null) {
            if (getInventory().getActiveTorso().getId() == 20)
                g.drawImage(getCurrentAnimationImageTorso1(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            if (getInventory().getActiveTorso().getId() == 21)
                g.drawImage(getCurrentAnimationImageTorso2(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            if (getInventory().getActiveTorso().getId() == 22)
                g.drawImage(getCurrentAnimationImageTorso3(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
        }
        if (getInventory() != null && getInventory().getActiveWeapon() != null) {
            if (getInventory().getActiveWeapon().getId() == 23)
                g.drawImage(getCurrentAnimationImageWeapon1(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            if (getInventory().getActiveWeapon().getId() == 24)
                g.drawImage(getCurrentAnimationImageWeapon2(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            if (getInventory().getActiveWeapon().getId() == 25)
                g.drawImage(getCurrentAnimationImageWeapon3(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
        }
        if (getInventory() != null && getInventory().getActiveShield() != null) {
            if (getInventory().getActiveShield().getId() == 18)
                g.drawImage(getCurrentAnimationImageShield1(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            if (getInventory().getActiveShield().getId() == 19)
                g.drawImage(getCurrentAnimationImageShield2(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
        }
        if (getInventory() != null && getInventory().getActiveGloves() != null) {
            if (getInventory().getActiveGloves().getId() == 12)
                g.drawImage(getCurrentAnimationImageGloves1(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            if (getInventory().getActiveGloves().getId() == 13)
                g.drawImage(getCurrentAnimationImageGloves2(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            if (getInventory().getActiveGloves().getId() == 14)
                g.drawImage(getCurrentAnimationImageGloves3(), (int) (x - handler.getCamera().getxOffSet()),
                        (int) (y - handler.getCamera().getyOffSet()), width, height, null);
        }
    }

    /**
     * Displays inventory in the EntityManager class.
     *
     * @param g class object Graphics.
     */
    public void postRender(Graphics g) {inventory.render(g);}

    @Override
    public void die() {}

    /**
     * Changing the speed (movement) with fixed keystrokes.
     */
    private void getInput() {
        xMove = 0;
        yMove = 0;
        if (handler.getKeyManager().up) yMove = -speed;
        if (handler.getKeyManager().down) yMove = speed;
        if (handler.getKeyManager().left) xMove = -speed;
        if (handler.getKeyManager().right) xMove = speed;
    }

    /**
     * Returns the actual buffered image of the character animation on motion
     *
     * @return bufferedImage of a player motion animation.
     */
    public BufferedImage getCurrentAnimationImageBody() {
        if (xMove < 0) {
            stateEndMove = Assets.player_left[1];
            return animationLeftBody.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMove = Assets.player_right[1];
            return animationRightBody.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMove = Assets.player_up[1];
            return animationUpBody.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMove = Assets.player_down[1];
            return animationDownBody.getCurrentImages();
        }
        return stateEndMove; // If the player does not move.
    }

    /**
     * @return bufferedImage of a boot_1 animation.
     */
    public BufferedImage getCurrentAnimationImageBoots1() {
        if (xMove < 0) {
            stateEndMoveBoots = Assets.player_left_boots1[1];
            return animationLeftBoots1.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveBoots = Assets.player_right_boots1[1];
            return animationRightBoots1.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveBoots = Assets.player_up_boots1[1];
            return animationUpBoots1.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveBoots = Assets.player_down_boots1[1];
            return animationDownBoots1.getCurrentImages();
        } else
            return stateEndMoveBoots;  // If the player does not move.
    }

    /**
     * @return bufferedImage of a boot_2 animation.
     */
    public BufferedImage getCurrentAnimationImageBoots2() {
        if (xMove < 0) {
            stateEndMoveBoots = Assets.player_left_boots2[1];
            return animationLeftBoots2.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveBoots = Assets.player_right_boots2[1];
            return animationRightBoots2.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveBoots = Assets.player_up_boots2[1];
            return animationUpBoots2.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveBoots = Assets.player_down_boots2[1];
            return animationDownBoots2.getCurrentImages();
        }
        return stateEndMoveBoots; // If the player does not move.
    }

    /**
     * @return bufferedImage of a boot_3 animation.
     */
    public BufferedImage getCurrentAnimationImageBoots3() {
        if (xMove < 0) {
            stateEndMoveBoots = Assets.player_left_boots3[1];
            return animationLeftBoots3.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveBoots = Assets.player_right_boots3[1];
            return animationRightBoots3.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveBoots = Assets.player_up_boots3[1];
            return animationUpBoots3.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveBoots = Assets.player_down_boots3[1];
            return animationDownBoots3.getCurrentImages();
        }
        return stateEndMoveBoots; // If the player does not move.
    }

    /**
     * @return bufferedImage of a head_1 animation.
     */
    public BufferedImage getCurrentAnimationImageHead1() {
        if (xMove < 0) {
            stateEndMoveHead = Assets.player_left_head1[1];
            return animationLeftHead1.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveHead = Assets.player_right_head1[1];
            return animationRightHead1.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveHead = Assets.player_up_head1[1];
            return animationUpHead1.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveHead = Assets.player_down_head1[1];
            return animationDownHead1.getCurrentImages();
        }
        return stateEndMoveHead; // If the player does not move.
    }

    /**
     * @return bufferedImage of a head_2 animation.
     */
    public BufferedImage getCurrentAnimationImageHead2() {
        if (xMove < 0) {
            stateEndMoveHead = Assets.player_left_head2[1];
            return animationLeftHead2.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveHead = Assets.player_right_head2[1];
            return animationRightHead2.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveHead = Assets.player_up_head2[1];
            return animationUpHead2.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveHead = Assets.player_down_head2[1];
            return animationDownHead2.getCurrentImages();
        }
        return stateEndMoveHead; // If the player does not move.
    }

    /**
     * @return bufferedImage of a head_1=3 animation.
     */
    public BufferedImage getCurrentAnimationImageHead3() {
        if (xMove < 0) {
            stateEndMoveHead = Assets.player_left_head3[1];
            return animationLeftHead3.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveHead = Assets.player_right_head3[1];
            return animationRightHead3.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveHead = Assets.player_up_head3[1];
            return animationUpHead3.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveHead = Assets.player_down_head3[1];
            return animationDownHead3.getCurrentImages();
        }
        return stateEndMoveHead; // If the player does not move.
    }

    /**
     * @return bufferedImage of a torso_1 animation.
     */
    public BufferedImage getCurrentAnimationImageTorso1() {
        if (xMove < 0) {
            stateEndMoveTorso = Assets.player_left_torso1[1];
            return animationLeftTorso1.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveTorso = Assets.player_right_torso1[1];
            return animationRightTorso1.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveTorso = Assets.player_up_torso1[1];
            return animationUpTorso1.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveTorso = Assets.player_down_torso1[1];
            return animationDownTorso1.getCurrentImages();
        }
        return stateEndMoveTorso; // If the player does not move.
    }

    /**
     * @return bufferedImage of a torso_2 animation.
     */
    public BufferedImage getCurrentAnimationImageTorso2() {
        if (xMove < 0) {
            stateEndMoveTorso = Assets.player_left_torso2[1];
            return animationLeftTorso2.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveTorso = Assets.player_right_torso2[1];
            return animationRightTorso2.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveTorso = Assets.player_up_torso2[1];
            return animationUpTorso2.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveTorso = Assets.player_down_torso2[1];
            return animationDownTorso2.getCurrentImages();
        }
        return stateEndMoveTorso; // If the player does not move.
    }

    /**
     * @return bufferedImage of a torso_3 animation.
     */
    public BufferedImage getCurrentAnimationImageTorso3() {
        if (xMove < 0) {
            stateEndMoveTorso = Assets.player_left_torso3[1];
            return animationLeftTorso3.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveTorso = Assets.player_right_torso3[1];
            return animationRightTorso3.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveTorso = Assets.player_up_torso3[1];
            return animationUpTorso3.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveTorso = Assets.player_down_torso3[1];
            return animationDownTorso3.getCurrentImages();
        }
        return stateEndMoveTorso; // If the player does not move.
    }

    /**
     * @return bufferedImage of a gloves_1 animation.
     */
    public BufferedImage getCurrentAnimationImageGloves1() {
        if (xMove < 0) {
            stateEndMoveGloves = Assets.player_left_gloves1[1];
            return animationLeftGloves1.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveGloves = Assets.player_right_gloves1[1];
            return animationRightGloves1.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveGloves = Assets.player_up_gloves1[1];
            return animationUpGloves1.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveGloves = Assets.player_down_gloves1[1];
            return animationDownGloves1.getCurrentImages();
        }
        return stateEndMoveGloves; // If the player does not move.
    }

    /**
     * @return bufferedImage of a gloves_2 animation.
     */
    public BufferedImage getCurrentAnimationImageGloves2() {
        if (xMove < 0) {
            stateEndMoveGloves = Assets.player_left_gloves2[1];
            return animationLeftGloves2.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveGloves = Assets.player_right_gloves2[1];
            return animationRightGloves2.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveGloves = Assets.player_up_gloves2[1];
            return animationUpGloves2.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveGloves = Assets.player_down_gloves2[1];
            return animationDownGloves2.getCurrentImages();
        }
        return stateEndMoveGloves; // If the player does not move.
    }

    /**
     * @return bufferedImage of a gloves_3 animation.
     */
    public BufferedImage getCurrentAnimationImageGloves3() {
        if (xMove < 0) {
            stateEndMoveGloves = Assets.player_left_gloves3[1];
            return animationLeftGloves3.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveGloves = Assets.player_right_gloves3[1];
            return animationRightGloves3.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveGloves = Assets.player_up_gloves3[1];
            return animationUpGloves3.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveGloves = Assets.player_down_gloves3[1];
            return animationDownGloves3.getCurrentImages();
        }
        return stateEndMoveGloves; // If the player does not move.
    }

    /**
     * @return bufferedImage of a pants_1 animation.
     */
    public BufferedImage getCurrentAnimationImagePants1() {
        if (xMove < 0) {
            stateEndMovePants = Assets.player_left_pants1[1];
            return animationLeftPants1.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMovePants = Assets.player_right_pants1[1];
            return animationRightPants1.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMovePants = Assets.player_up_pants1[1];
            return animationUpPants1.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMovePants = Assets.player_down_pants1[1];
            return animationDownPants1.getCurrentImages();
        }
        return stateEndMovePants; // If the player does not move.
    }

    /**
     * @return bufferedImage of a pants_2 animation.
     */
    public BufferedImage getCurrentAnimationImagePants2() {
        if (xMove < 0) {
            stateEndMovePants = Assets.player_left_pants2[1];
            return animationLeftPants2.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMovePants = Assets.player_right_pants2[1];
            return animationRightPants2.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMovePants = Assets.player_up_pants2[1];
            return animationUpPants2.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMovePants = Assets.player_down_pants2[1];
            return animationDownPants2.getCurrentImages();
        }
        return stateEndMovePants; // If the player does not move.
    }

    /**
     * @return bufferedImage of a pants_3 animation.
     */
    public BufferedImage getCurrentAnimationImagePants3() {
        if (xMove < 0) {
            stateEndMovePants = Assets.player_left_pants3[1];
            return animationLeftPants3.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMovePants = Assets.player_right_pants3[1];
            return animationRightPants3.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMovePants = Assets.player_up_pants3[1];
            return animationUpPants3.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMovePants = Assets.player_down_pants3[1];
            return animationDownPants3.getCurrentImages();
        }
        return stateEndMovePants; // If the player does not move.
    }

    /**
     * @return bufferedImage of a shield_1 animation.
     */
    public BufferedImage getCurrentAnimationImageShield1() {
        if (xMove < 0) {
            stateEndMoveShield = Assets.player_left_shield1[1];
            return animationLeftShield1.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveShield = Assets.blank;
        } else if (yMove < 0) {
            stateEndMoveShield = Assets.player_up_shield1[1];
            return animationUpShield1.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveShield = Assets.player_down_shield1[1];
            return animationDownShield1.getCurrentImages();
        }
        return stateEndMoveShield; // If the player does not move.
    }

    /**
     * @return bufferedImage of a shield_2 animation.
     */
    public BufferedImage getCurrentAnimationImageShield2() {
        if (xMove < 0) {
            stateEndMoveShield = Assets.player_left_shield2[1];
            return animationLeftShield2.getCurrentImages();
        } else if (xMove > 0) {
            stateEndMoveShield = Assets.blank;
        } else if (yMove < 0) {
            stateEndMoveShield = Assets.player_up_shield2[1];
            return animationUpShield2.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveShield = Assets.player_down_shield2[1];
            return animationDownShield2.getCurrentImages();
        }
        return stateEndMoveShield; // If the player does not move.
    }

    /**
     * @return bufferedImage of a weapon_1 animation.
     */
    public BufferedImage getCurrentAnimationImageWeapon1() {
         if (xMove < 0) {
             stateEndMoveWeapon = Assets.blank;
        } else if (xMove > 0) {
            stateEndMoveWeapon = Assets.player_right_weapon1[1];
            return animationRightWeapon1.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveWeapon = Assets.player_up_weapon1[1];
            return animationUpWeapon1.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveWeapon = Assets.player_down_weapon1[1];
            return animationDownWeapon1.getCurrentImages();
        }
        return stateEndMoveWeapon; // If the player does not move.
    }

    /**
     * @return bufferedImage of a weapon_2 animation.
     */
    public BufferedImage getCurrentAnimationImageWeapon2() {
        if (xMove < 0) {
            stateEndMoveWeapon = Assets.blank;
        } else if (xMove > 0) {
            stateEndMoveWeapon = Assets.player_right_weapon2[1];
            return animationRightWeapon2.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveWeapon = Assets.player_up_weapon2[1];
            return animationUpWeapon2.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveWeapon = Assets.player_down_weapon2[1];
            return animationDownWeapon2.getCurrentImages();
        }
        return stateEndMoveWeapon; // If the player does not move.
    }

    /**
     * @return bufferedImage of a weapon_3 animation.
     */
    public BufferedImage getCurrentAnimationImageWeapon3() {
        if (xMove < 0) {
            stateEndMoveWeapon = Assets.blank;
        } else if (xMove > 0) {
            stateEndMoveWeapon = Assets.player_right_weapon3[1];
            return animationRightWeapon3.getCurrentImages();
        } else if (yMove < 0) {
            stateEndMoveWeapon = Assets.player_up_weapon3[1];
            return animationUpWeapon3.getCurrentImages();
        } else if (yMove > 0) {
            stateEndMoveWeapon = Assets.player_down_weapon3[1];
            return animationDownWeapon3.getCurrentImages();
        }
        return stateEndMoveWeapon; // If the player does not move.
    }

    /**
     * @return bufferedImage of a skill_1 animation.
     */
    public BufferedImage getCurrentAnimationImageSkill1() { return animationSkill1.getCurrentImages(); }

    /**
     * @return bufferedImage of a skill_2 animation.
     */
    public BufferedImage getCurrentAnimationImageSkill2() { return animationUpSkill2.getCurrentImages(); }

    /**
     * @return bufferedImage of a skill_3 animation.
     */
    public BufferedImage getCurrentAnimationImageSkill3() {
        if(stateEndMove == Assets.player_left[1]) return animationLeftSkill3.getCurrentImages();
        else if (stateEndMove == Assets.player_right[1]) return animationRightSkill3.getCurrentImages();
        else if (stateEndMove == Assets.player_down[1]) return animationDownSkill3.getCurrentImages();
        else if (stateEndMove == Assets.player_up[1]) return animationUpSkill3.getCurrentImages();
        return stateEndMove;
    }

    // Getters and setters
    public Inventory getInventory() { return inventory; }

    public void setInventory(Inventory inventory) { this.inventory = inventory; }

    public boolean isAttack() { return attack; }

    public int getPowerAttack() { return powerAttack; }

    public void setPowerAttack(int powerAttack) { this.powerAttack = powerAttack; }

    public int getMana() { return mana; }

    public void setMana(int mana) { this.mana = mana; }

    public int getMaxHealth() { return maxHealth; }

    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }

    public static int getDefaultMana() { return DEFAULT_MANA; }

    public int getPoisoning() { return poisoning; }

    public void setPoisoning(int poisoning) { this.poisoning = poisoning; }

    public static int getDefaultPoisoning() { return DEFAULT_POISONING; }

    public static int getMaxPoisoning() { return MAX_POISONING; }
}