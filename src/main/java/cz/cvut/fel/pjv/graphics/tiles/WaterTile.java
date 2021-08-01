package cz.cvut.fel.pjv.graphics.tiles;

import cz.cvut.fel.pjv.graphics.Assets;

import java.awt.image.BufferedImage;

public class WaterTile extends Tile {

    /**
     * @param id integer unique image id for each type of water tile.
     */
    public WaterTile(int id) { super(WaterTileChoice(id), id); }

    /**
     * Returns an image by id.
     *
     * @param id numerical identifier.
     * @return bufferedImage by id.
     */
    private static BufferedImage WaterTileChoice(int id) {
        BufferedImage water;
        switch (id) {
            case 14:
                water = Assets.water1;
                break;
            case 15:
                water = Assets.water2;
                break;
            case 16:
                water = Assets.water3;
                break;
            case 17:
                water = Assets.water4;
                break;
            case 18:
                water = Assets.waterBorderNorthwest;
                break;
            case 19:
                water = Assets.waterBorderNorth;
                break;
            case 20:
                water = Assets.waterBorderNortheast;
                break;
            case 21:
                water = Assets.waterBorderEast;
                break;
            case 22:
                water = Assets.waterBorderSoutheast;
                break;
            case 23:
                water = Assets.waterBorderSouth;
                break;
            case 24:
                water = Assets.waterBorderSouthwest;
                break;
            case 25:
                water = Assets.waterBorderWest;
                break;
            case 26:
                water = Assets.angleBorderWaterNorthwest;
                break;
            case 27:
                water = Assets.angleBorderWaterNortheast;
                break;
            case 28:
                water = Assets.angleBorderWaterSoutheast;
                break;
            case 29:
                water = Assets.angleBorderWaterSouthwest;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
        return water;
    }

    /**
     * On the tile can't pass.
     *
     * @return true if the tile has an identifier (from 14 to 17), otherwise returns false.
     */
    @Override
    public boolean isSolid() {
        return id == 14 || id == 15 || id == 16 || id == 17;
    }
}
