package cz.cvut.fel.pjv.entities;

import cz.cvut.fel.pjv.main.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected float x, y;
    protected int width, height, health;
    protected Rectangle bounds; // Object bounds, used for collision.
    protected boolean active = true; // Shows whether the object is alive.

    /**
     * @param handler class object Handler.
     * @param x the x-coordinate in pixels of the upper-left corner of the rectangle of the entity image.
     * @param y the y-coordinate in pixels of the upper-left corner of the rectangle of the entity image.
     * @param width width in pixels of entity.
     * @param height height in pixels of entity.
     * @param health health of an entity in whole units.
     */
    public Entity(Handler handler, float x, float y, int width, int height, int health) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;

        bounds = new Rectangle(0,0,width, height); // Rectangle entity.
    }

    /**
     * Update in the game. The frequency is set in the class Game.
     */
    public abstract void update();

    /**
     *  The entity will be displayed on the screen. The frequency is set in the class Game.
     *
     * @param g class object Graphics.
     */
    public abstract void render (Graphics g);

    /**
     * Events after death entity.
     */
    public abstract void die();

    /**
     * Subtracts damage dealt and controls death.
     *
     * @param decreasedHealth the amount by which health is reduced.
     */
    public void damageDealt(int decreasedHealth) {
        health -= decreasedHealth;
        if(health <= 0) {
            active = false;
            die();
        }
    }

    /**
     *  Checks if an entity collision occurs.
     *
     * @param xOffSet the x offset in pixels of the collision rectangle.
     * @param yOffSet the y offset in pixels of the collision rectangle.
     * @return false if a collision is detected (equivalent in value isSolid for tiles), otherwise it returns true.
     */
    public boolean checkEntityCollision(float xOffSet, float yOffSet) {
        for (Entity entity : handler.getWorld().getEntityManager().getEntitiesStatic()) {
            if (entity.equals(this)) continue; // Prevents the edit from checking collisions on itself.
            if (entity.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffSet, yOffSet)))
                return false;
        }
        for (Entity entity : handler.getWorld().getEntityManager().getEntitiesDynamic()) {
            if (entity.equals(this)) continue; // Prevents the edit from checking collisions on itself.
            if (entity.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffSet, yOffSet)))
                return false;
        }
        return true;
    }

    /**
     * Create rectangle for collision.
     *
     * @param xOffSet the x offset in pixels of the collision rectangle.
     * @param yOffSet the y offset in pixels of the collision rectangle.
     * @return collision rectangle.
     */
    public Rectangle getCollisionBounds(float xOffSet, float yOffSet) {
        return new Rectangle((int)(x + bounds.x + xOffSet), (int)(y + bounds.y + yOffSet), bounds.width, bounds.height);
    }

    // Getters and Setters
    public void setX(float x) { this.x = x; }

    public float getX() { return x; }

    public void setY(float y) { this.y = y; }

    public float getY() { return y; }

    public void setWidth(int width) { this.width = width; }

    public int getWidth() { return width; }

    public void setHeight(int height) { this.height = height; }

    public int getHeight() { return height; }

    public int getHealth() { return health; }

    public void setHealth(int health) { this.health = health; }

    public boolean isActive() {
        return active;
    }
}
