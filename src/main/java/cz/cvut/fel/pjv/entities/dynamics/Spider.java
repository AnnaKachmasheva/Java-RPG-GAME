package cz.cvut.fel.pjv.entities.dynamics;

import cz.cvut.fel.pjv.entities.Entity;
import cz.cvut.fel.pjv.graphics.Animation;
import cz.cvut.fel.pjv.graphics.Assets;
import cz.cvut.fel.pjv.graphics.tiles.Tile;
import cz.cvut.fel.pjv.inventory.Item;
import cz.cvut.fel.pjv.main.Handler;
import cz.cvut.fel.pjv.main.Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Spider extends EntityDynamic {

    private final Animation animationDown, animationUp, animationLeft, animationRight; // Spider move animation.
    private BufferedImage stateEndMove; // Zero speed position.
    private boolean die = false; // Displays the state of life.

    Random random; // Used to generate motion.
    private int numberSpiderMove = 0; // Used to generate motion.
    private int count; // Used to slow down the generation of random moves.

    /**
     * @param handler class object Handler.
     * @param x the x-coordinate in pixels of the upper-left corner of the rectangle of the spider image.
     * @param y the y-coordinate in pixels of the upper-left corner of the rectangle of the spider image.
     */
    public Spider(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH * 2/3, Tile.TILE_HEIGHT* 2/3, 1000);

        // Rectangle for single collision
        bounds.x = 10;
        bounds.y = 10;
        bounds.width = 20;
        bounds.height = 14;

        // Generating random values to move.
        random = new Random();
        count = 0;

        // Create animation.
        animationDown = new Animation(100, Assets.spider_down);
        animationUp = new Animation(100, Assets.spider_up);
        animationLeft = new Animation(100, Assets.spider_left);
        animationRight = new Animation(100, Assets.spider_right);

        createRectangleAttack();
    }

    /**
     * Create an attack rectangle.
     */
    public void createRectangleAttack() {
        // It is used for clashes and fights.
        Rectangle rectangleSpider = new Rectangle();
        int raSize = 30; // Used to define the base attack rectangle.

        // Sizing a rectangle.
        rectangleSpider.x = bounds.x + raSize;
        rectangleSpider.y = bounds.y + raSize;
        rectangleSpider.width = 4 * raSize;
        rectangleSpider.height = 4 * raSize;
    }

    @Override
    public void update() {
        // Animation updates.
        animationDown.update();
        animationUp.update();
        animationLeft.update();
        animationRight.update();

        getInput();
        move();

        // Lessening the player if he attacks. Only attacks the creature that takes damage.
        for (Entity entity : handler.getWorld().getEntityManager().getEntitiesDynamic()) {
            // Reducing the health of the player.
            if (entity.equals(this) && handler.getWorld().getEntityManager().getPlayer().isAttack())
                    handler.getWorld().getEntityManager().getPlayer().damageDealt(2);
        }
    }

    @Override
    public void render(Graphics g) {
        // Screen image if live.
        if (handler.getWorld().getEntityManager().getPlayer().isAttack() && !die) {
            g.drawImage(getCurrentAnimationImage(), (int) (x - handler.getCamera().getxOffSet()),
                    (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            g.drawImage(Assets.spiderHealth, (int) (x - handler.getCamera().getxOffSet()),
                    (int) (y - handler.getCamera().getyOffSet()), 32,5, null);
            renderHealth(g);
        } else if (die) { //  Screen image if spider died.
            g.drawImage(Assets.spiderDie, (int) (x - handler.getCamera().getxOffSet()),
                    (int) (y - handler.getCamera().getyOffSet()), width, height, null);
        } else { // Screen image if dead.
            g.drawImage(getCurrentAnimationImage(), (int) (x - handler.getCamera().getxOffSet()),
                (int) (y - handler.getCamera().getyOffSet()), width, height, null);
            g.drawImage(Assets.spiderHealth, (int) (x - handler.getCamera().getxOffSet()),
                    (int) (y - handler.getCamera().getyOffSet()), 32,5, null);
            renderHealth(g);
        }
    }

    /**
     * Displays health entity.
     *
     * @param g class object Graphics.
     */
    public void renderHealth(Graphics g) {
        int counter = 0; // Number of health bars.
        int count = this.getHealth()/100; // One health bar maximum equal to 10
        // Display of all health bars.
        for (int i = 0; i < count; i++) {
            g.drawImage(Assets.spiderHealthOwn, (int) (x - handler.getCamera().getxOffSet() + counter * 3 + 1),
                    (int)(y - handler.getCamera().getyOffSet() + 1), 3,4, null);
            counter++;
        }
    }

    @Override
    public void die() {
        die = true;
        stateEndMove = Assets.spiderDie; // Dead state image.
        random = new Random();
        int count  = random.nextInt(3); // After death, a maximum of 2 keys can be dropped.
        // Creation of dropped keys.
        for (int i = 0; i < count; i++) {
            handler.getWorld().getItemManager().addItem(Item.keyItem.createNew((int) x, (int) y));
        }
        Main.getLOG().info("Spider died. Dropped " + count + " keys." );
    }

    /**
     * Retrieving values for generating displacement.
     */
    private void getInput() {
        xMove = 0;
        yMove = 0;
        count++; // Auxiliary integer.
        if (count == 60) {
            numberSpiderMove = random.nextInt(4); // Randomly selects 1 of 4 directions of movement
            count = 0;
        }
        if (numberSpiderMove == 0) yMove = -speed;
        if (numberSpiderMove == 1) yMove = speed;
        if (numberSpiderMove == 2) xMove = -speed;
        if (numberSpiderMove == 3) xMove = speed;
    }

    /**
     * Returns the actual buffered image of the spider animation on motion.
     *
     * @return  bufferedImage of the spider motion animation.
     */
    public BufferedImage getCurrentAnimationImage() {
        if (xMove < 0) return animationLeft.getCurrentImages();
        else if (xMove > 0) return animationRight.getCurrentImages();
        else if (yMove < 0) return animationUp.getCurrentImages();
        else if (yMove > 0) return animationDown.getCurrentImages();
        return stateEndMove;
    }
 }