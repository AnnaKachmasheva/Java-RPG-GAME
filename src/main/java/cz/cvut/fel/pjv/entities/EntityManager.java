package cz.cvut.fel.pjv.entities;

import cz.cvut.fel.pjv.entities.dynamics.Player;
import cz.cvut.fel.pjv.main.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class EntityManager {

    private Handler handler;
    private Player player;

    // Entity Lists from static entities, dynamic entities, dead entities, entity chests.
    private List<Entity> entitiesStatic, entitiesDynamic, entitiesDie, entitiesChest;

    // Adjusts the order of displaying entities.
    private Comparator<Entity> renderSortEntities = new Comparator<Entity>() {
        @Override
        public int compare(Entity entityFirst, Entity entitySecond) {
            if (entityFirst.getY() + entityFirst.getHeight() < entitySecond.getY() + entitySecond.getHeight())
                return -1;
            return 1;
        }
    };

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;

        entitiesStatic = new ArrayList<>();
        entitiesDynamic = new ArrayList<>();
        entitiesChest = new ArrayList<>();
        entitiesDie = new ArrayList<>();

        entitiesStatic.add(player); // Added to correctly display the player when interacting with static entities.
    }

    /**
     * Updating the number of static and dynamic objects with which the player can interact.
     * An iterator is used to easily remove items from a collection.
     */
    public void update() {

        Iterator<Entity> iterator = entitiesStatic.iterator();
        while (iterator.hasNext()){
            Entity entity = iterator.next();
            entity.update();
            if(!entity.isActive()) {
               iterator.remove();
            }
        }

        Iterator<Entity> iteratorD = entitiesDynamic.iterator();
        while (iteratorD.hasNext()){
            Entity entity = iteratorD.next();
            entity.update();
            if(!entity.isActive()) {
                iteratorD.remove();
                entitiesDie.add(entity);
            }
        }
        // Sorting entities.
        entitiesStatic.sort(renderSortEntities);
        entitiesDynamic.sort(renderSortEntities);
    }

    /**
     * Screen image
     *
     * @param g class object Graphics.
     */
    public void render(Graphics g) {
        for (Entity entity : entitiesDie) { entity.render(g); }
        for (Entity entity : entitiesDynamic) { entity.render(g); }
        for (Entity entity : entitiesStatic) { entity.render(g); }
        player.postRender(g); // Updating the inventory image.
    }

    /**
     * Adds to the list static entities.
     *
     * @param entity class object Entity.
     */
    public void addEntityStatic(Entity entity) {
        entitiesStatic.add(entity);
    }

    /**
     * Adds to the list dynamic entities.
     *
     * @param entity class object Entity.
     */
    public void addEntityDynamic(Entity entity) {
        entitiesDynamic.add(entity);
    }

    /**
     * Adds to the list chests.
     *
     * @param entity class object Entity.
     */
    public void addEntityChest(Entity entity) {
        entitiesChest.add(entity);
        addEntityStatic(entity);
    }

    // Getters ans setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Entity> getEntitiesChest() {
        return entitiesChest;
    }

    public List<Entity> getEntitiesStatic() {
        return entitiesStatic;
    }

    public List<Entity> getEntitiesDynamic() {
        return entitiesDynamic;
    }
}
