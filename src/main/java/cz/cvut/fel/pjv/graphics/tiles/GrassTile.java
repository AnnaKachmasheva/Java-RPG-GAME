package cz.cvut.fel.pjv.graphics.tiles;

import cz.cvut.fel.pjv.graphics.Assets;

import java.awt.image.BufferedImage;

public class GrassTile extends Tile {

    /**
     * @param id integer unique image id for each type of grass tile.
     */
    public GrassTile(int id) { super(GrassTileChoice(id), id); }

    /**
     * Returns an image by id.
     *
     * @param id numerical identifier.
     * @return bufferedImage by id.
     */
    private static BufferedImage GrassTileChoice(int id) {
        BufferedImage grass;
        switch (id) {
            case 1:
                grass = Assets.grass;
                break;
            case 2:
                grass = Assets.grassFlowers1;
                break;
            case 3:
                grass = Assets.grassFlowers2;
                break;
            case 5:
                grass = Assets.grassNorthwest;
                break;
            case 6:
                grass = Assets.grassNorth;
                break;
            case 7:
                grass = Assets.grassNortheast;
                break;
            case 8:
                grass = Assets.grassEast;
                break;
            case 9:
                grass = Assets.grassSoutheast;
                break;
            case 10:
                grass = Assets.grassSouth;
                break;
            case 11:
                grass = Assets.grassSouthwest;
                break;
            case 12:
                grass = Assets.grassWest;
                break;
            case 13:
                grass = Assets.grassFull;
                break;
            case 30:
                grass = Assets.grassBorderSouth;
                break;
            case 31:
                grass = Assets.grassBorderWest;
                break;
            case 32:
                grass = Assets.grassBorderNorth;
                break;
            case 33:
                grass = Assets.grassBorderEast;
                break;
            case 34:
                grass = Assets.grassBorderSoutheast;
                break;
            case 35:
                grass = Assets.grassBorderNorthwest;
                break;
            case 36:
                grass = Assets.grassBorderNortheast;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
        return grass;
    }
}
