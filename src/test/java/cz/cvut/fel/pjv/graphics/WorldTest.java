package cz.cvut.fel.pjv.graphics;

import cz.cvut.fel.pjv.graphics.tiles.WaterTile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class WorldTest {

    @Test
    @Order(1)
    public void getTileFirstLayer_1_and_1_WaterTile15() {
        System.out.println("Running getTileFirstLayer_1_and_1_WaterTile15");
        // Arrange
        World world = new World();
        int extended = new WaterTile(14).getId();

        // Act
        int result = world.getTileFirstLayer(1,1).getId();

        // Assert
        Assertions.assertEquals(extended, result);
    }

    @Test
    @Order(2)
    public void getTileFirstLayer_0_and_minus10_TileWater14() {
        System.out.println("Running getTileFirstLayer_0_and_minus10_TileWater14");
        // Arrange
        World world = new World();
        int extended = new WaterTile(14).getId();

        // Act
        int result = world.getTileFirstLayer(0,-10).getId();

        // Assert
        Assertions.assertEquals(extended, result);
    }

    @Test
    @Order(3)
    public void getTileFirstLayer_0_and_100_TileWater14() {
        System.out.println("Running getTileFirstLayer_0_and_100_TileWater14");
        // Arrange
        World world = new World();
        int extended = new WaterTile(14).getId();

        // Act
        int result = world.getTileSecondLayer(0,100).getId();

        // Assert
        Assertions.assertEquals(extended, result);
    }

    @Test
    @Order(4)
    public void getTileSecondLayer_0_and_0_null() {
        System.out.println("Running getTileSecondLayer_0_and_0_null");
        // Arrange
        World world = new World();
        int extended = new WaterTile(14).getId();

        // Act
        int result = world.getTileSecondLayer(0,0).getId();

        // Assert
        Assertions.assertEquals(extended, result);
    }


}