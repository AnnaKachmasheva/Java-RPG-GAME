package cz.cvut.fel.pjv.entities.statics;

import cz.cvut.fel.pjv.entities.Entity;
import cz.cvut.fel.pjv.main.Handler;

public abstract class EntityStatic extends Entity {

    /**
     * @param handler class object Handler.
     * @param x the x-coordinate in pixels of the upper-left corner of the rectangle of the static entity image.
     * @param y the y-coordinate in pixels of the upper-left corner of the rectangle of the static entity image.
     * @param width width in pixels of static entity.
     * @param height height in pixels of static entity.
     * @param health health of a static entity in whole units.
     */
    public EntityStatic(Handler handler, float x, float y, int width, int height, int health) {
        super(handler, x, y, width, height, health);
    }
}
