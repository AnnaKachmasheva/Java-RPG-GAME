package cz.cvut.fel.pjv.graphics;

import java.awt.image.BufferedImage;

public class Assets {

    // Width and height of images in pixels.
    public static final int width = 32, height = 32,  widthPlayer = 64, heightPlayer = 64,
            widthItemActive = 60, heightItemActive = 60, widthProperties = 12, heightProperties = 21;

    // Buffered image variables.
    public static BufferedImage water1, water2, water3, water4,
            grassWest, grassNortheast, grassNorthwest, grassSouth,
            grassSoutheast, grassSouthwest, grassNorth, grassFull,
            grass, grassFlowers1, grassFlowers2, grassEast,
            waterBorderNorthwest, waterBorderNorth, waterBorderNortheast,
            waterBorderEast, waterBorderSoutheast, waterBorderSouth,
            waterBorderSouthwest, waterBorderWest,
            spiderDie, border, blank,
            angleBorderWaterNorthwest, angleBorderWaterNortheast, angleBorderWaterSoutheast,
            angleBorderWaterSouthwest,
            tree, bush, chestClosed, enter,
            grassBorderNorth, grassBorderWest, grassBorderSouth, grassBorderEast, grassBorderSoutheast,
            grassBorderNorthwest, grassBorderNortheast,
            menuBackand, panel, panelItemZero, inventory, gameOver,
            itemApple, itemStrawberry, itemPotionBlue, itemPotionWhite, itemPotionRed,
            itemRingAttack, itemRingHealth,
            itemAmuletAttack,itemAmuletHealth,
            itemBoot1, itemBoot2,  itemBoot3,
            itemGloves1, itemGloves2, itemGloves3,
            itemHead1, itemHead2, itemHead3,
            itemShield1, itemShield2, itemKey,
            itemTorso1,  itemTorso2,  itemTorso3,
            itemWeapon1, itemWeapon2, itemWeapon3,
            itemPants1, itemPants2, itemPants3,
            itemAppleDescription, itemStrawberryDescription, itemKeyDescription,
            itemPotionBlueDescription, itemPotionWhiteDescription, itemPotionRedDescription,
            itemRingAttackDescription, itemRingHealthDescription,
            itemAmuletAttackDescription,itemAmuletHealthDescription,
            itemBoot1Description, itemBoot2Description,  itemBoot3Description,
            itemGloves1Description, itemGloves2Description, itemGloves3Description,
            itemHead1Description, itemHead2Description, itemHead3Description,
            itemShield1Description, itemShield2Description,
            itemTorso1Description,  itemTorso2Description,  itemTorso3Description,
            itemWeapon1Description, itemWeapon2Description, itemWeapon3Description,
            itemPants1Description, itemPants2Description, itemPants3Description,
            number0, number1, number2 ,number3, number4, number5, number6, number7, number8, number9,
            ownHealth, ownMana, owmPoisoning,
            item0Active, item1Active, item2Active, item3Active, item4Active, item5Active, item6Active, item7Active,
            item8Active, item9Active, control,
            spiderHealth, spiderHealthOwn;

    // Array of images for animating the player's body.
    public static BufferedImage[] player_down, player_up, player_right, player_left;

    // Array of images for animating boots.
    public static BufferedImage[] player_down_boots1, player_up_boots1, player_right_boots1, player_left_boots1,
            player_down_boots2, player_up_boots2, player_right_boots2, player_left_boots2,
            player_down_boots3, player_up_boots3, player_right_boots3, player_left_boots3;

    // Array of images for animating hats.
    public static BufferedImage[] player_down_head1, player_up_head1, player_right_head1, player_left_head1,
            player_down_head2, player_up_head2, player_right_head2,player_left_head2,
            player_down_head3, player_up_head3, player_right_head3, player_left_head3;

    // Array of images for animating torso.
    public static BufferedImage[] player_down_torso1, player_up_torso1, player_right_torso1, player_left_torso1,
            player_down_torso2, player_up_torso2, player_right_torso2, player_left_torso2,
            player_down_torso3, player_up_torso3, player_right_torso3, player_left_torso3;

    // Array of images for animating pants.
    public static BufferedImage[] player_down_pants1, player_up_pants1, player_right_pants1, player_left_pants1,
            player_down_pants2, player_up_pants2, player_right_pants2, player_left_pants2,
            player_down_pants3, player_up_pants3, player_right_pants3, player_left_pants3;

    // Array of images for animating gloves.
    public static BufferedImage[] player_down_gloves1, player_up_gloves1, player_right_gloves1, player_left_gloves1,
            player_down_gloves2, player_up_gloves2, player_right_gloves2, player_left_gloves2,
            player_down_gloves3, player_up_gloves3, player_right_gloves3, player_left_gloves3;

    // Array of images for animating shields.
    public static BufferedImage[] player_down_shield1, player_up_shield1, player_left_shield1,
            player_down_shield2, player_up_shield2, player_left_shield2;

    // Array of images for animating weapons.
    public static BufferedImage[] player_down_weapon1, player_up_weapon1, player_right_weapon1,
            player_down_weapon2, player_up_weapon2, player_right_weapon2,
            player_down_weapon3, player_up_weapon3, player_right_weapon3;

    // Array of images for animating buttons.
    public static BufferedImage[] button_start, button_exit, music_on_off, button_music_on, button_music_off,
            button_exit_small, button_game_exit, button_game_control, button_game_inventory, button_game_use,
            button_game_save;

    // Array of images for animating skills.
    public static BufferedImage[] skill1_1, skill_2, skill_3_down, skill_3_up, skill_3_right, skill_3_left;

    // Array of images for animating spiders.
    public static BufferedImage[] spider_down, spider_up, spider_right, spider_left, spider_attack;


    /**
     * Method for loading and cropping images.
     */
    public static void initialization() {
        // Adding images along the path from the resources folder.
        String pathTU = "/textures/user/";
        SpriteSheet sheetPlayerDown = new SpriteSheet(ImageLoader.loadImage(pathTU + "base_body_front.png"));
        SpriteSheet sheetPlayerUp = new SpriteSheet(ImageLoader.loadImage(pathTU + "base_body_back.png"));
        SpriteSheet sheetPlayerRight = new SpriteSheet(ImageLoader.loadImage(pathTU + "base_body_right.png"));
        SpriteSheet sheetPlayerLeft = new SpriteSheet(ImageLoader.loadImage(pathTU + "base_body_left.png"));

        // Boots
        String pathTIEB = "/textures/inventory/equipment/boots/";
        SpriteSheet sheetPlayerDownBoots1 = new SpriteSheet(ImageLoader.loadImage( pathTIEB + "boots_1_front.png"));
        SpriteSheet sheetPlayerUpBoots1 = new SpriteSheet(ImageLoader.loadImage(pathTIEB + "boots_1_up.png"));
        SpriteSheet sheetPlayerRightBoots1 = new SpriteSheet(ImageLoader.loadImage(pathTIEB + "boots_1_right.png"));
        SpriteSheet sheetPlayerLeftBoots1 = new SpriteSheet(ImageLoader.loadImage(pathTIEB + "boots_1_left.png"));
        SpriteSheet sheetPlayerDownBoots2 = new SpriteSheet(ImageLoader.loadImage(pathTIEB + "boots_2_front.png"));
        SpriteSheet sheetPlayerUpBoots2 = new SpriteSheet(ImageLoader.loadImage(pathTIEB + "boots_2_up.png"));
        SpriteSheet sheetPlayerRightBoots2 = new SpriteSheet(ImageLoader.loadImage(pathTIEB + "boots_2_right.png"));
        SpriteSheet sheetPlayerLeftBoots2 = new SpriteSheet(ImageLoader.loadImage(pathTIEB + "boots_2_left.png"));
        SpriteSheet sheetPlayerDownBoots3 = new SpriteSheet(ImageLoader.loadImage(pathTIEB + "boots_3_front.png"));
        SpriteSheet sheetPlayerUpBoots3 = new SpriteSheet(ImageLoader.loadImage(pathTIEB + "boots_3_up.png"));
        SpriteSheet sheetPlayerRightBoots3 = new SpriteSheet(ImageLoader.loadImage(pathTIEB + "boots_3_right.png"));
        SpriteSheet sheetPlayerLeftBoots3 = new SpriteSheet(ImageLoader.loadImage(pathTIEB + "boots_3_left.png"));

        // Head
        String pathTIEH = "/textures/inventory/equipment/head/";
        SpriteSheet sheetPlayerDownHead1 = new SpriteSheet(ImageLoader.loadImage(pathTIEH + "head_1_down.png"));
        SpriteSheet sheetPlayerUpHead1 = new SpriteSheet(ImageLoader.loadImage(pathTIEH + "head_1_up.png"));
        SpriteSheet sheetPlayerRightHead1 = new SpriteSheet(ImageLoader.loadImage(pathTIEH + "head_1_right.png"));
        SpriteSheet sheetPlayerLeftHead1 = new SpriteSheet(ImageLoader.loadImage(pathTIEH + "head_1_left.png"));
        SpriteSheet sheetPlayerDownHead2 = new SpriteSheet(ImageLoader.loadImage(pathTIEH + "head_2_down.png"));
        SpriteSheet sheetPlayerUpHead2 = new SpriteSheet(ImageLoader.loadImage(pathTIEH + "head_2_up.png"));
        SpriteSheet sheetPlayerRightHead2 = new SpriteSheet(ImageLoader.loadImage(pathTIEH + "head_2_right.png"));
        SpriteSheet sheetPlayerLeftHead2 = new SpriteSheet(ImageLoader.loadImage(pathTIEH + "head_2_left.png"));
        SpriteSheet sheetPlayerDownHead3 = new SpriteSheet(ImageLoader.loadImage(pathTIEH + "head_3_down.png"));
        SpriteSheet sheetPlayerUpHead3 = new SpriteSheet(ImageLoader.loadImage(pathTIEH + "head_3_up.png"));
        SpriteSheet sheetPlayerRightHead3 = new SpriteSheet(ImageLoader.loadImage(pathTIEH + "head_3_right.png"));
        SpriteSheet sheetPlayerLeftHead3 = new SpriteSheet(ImageLoader.loadImage(pathTIEH + "head_3_left.png"));

        // Gloves
        String pathTIEG = "/textures/inventory/equipment/gloves/";
        SpriteSheet sheetPlayerDownGloves1 = new SpriteSheet(ImageLoader.loadImage(pathTIEG + "gloves_1_down.png"));
        SpriteSheet sheetPlayerUpGloves1 = new SpriteSheet(ImageLoader.loadImage(pathTIEG + "gloves_1_up.png"));
        SpriteSheet sheetPlayerRightGloves1 = new SpriteSheet(ImageLoader.loadImage(pathTIEG + "gloves_1_right.png"));
        SpriteSheet sheetPlayerLeftGloves1 = new SpriteSheet(ImageLoader.loadImage(pathTIEG + "gloves_1_left.png"));
        SpriteSheet sheetPlayerDownGloves2 = new SpriteSheet(ImageLoader.loadImage(pathTIEG + "gloves_2_down.png"));
        SpriteSheet sheetPlayerUpGloves2 = new SpriteSheet(ImageLoader.loadImage(pathTIEG + "gloves_2_up.png"));
        SpriteSheet sheetPlayerRightGloves2 = new SpriteSheet(ImageLoader.loadImage(pathTIEG + "gloves_2_right.png"));
        SpriteSheet sheetPlayerLeftGloves2 = new SpriteSheet(ImageLoader.loadImage(pathTIEG + "gloves_2_left.png"));
        SpriteSheet sheetPlayerDownGloves3 = new SpriteSheet(ImageLoader.loadImage(pathTIEG + "gloves_3_down.png"));
        SpriteSheet sheetPlayerUpGloves3 = new SpriteSheet(ImageLoader.loadImage(pathTIEG + "gloves_3_up.png"));
        SpriteSheet sheetPlayerRightGloves3 = new SpriteSheet(ImageLoader.loadImage(pathTIEG + "gloves_3_right.png"));
        SpriteSheet sheetPlayerLeftGloves3 = new SpriteSheet(ImageLoader.loadImage(pathTIEG + "gloves_3_left.png"));

        // Legs
        String pathTIEL = "/textures/inventory/equipment/legs/";
        SpriteSheet sheetPlayerDownLegs1 = new SpriteSheet(ImageLoader.loadImage(pathTIEL + "legs_1_down.png"));
        SpriteSheet sheetPlayerUpLegs1 = new SpriteSheet(ImageLoader.loadImage(pathTIEL + "legs_1_up.png"));
        SpriteSheet sheetPlayerRightLegs1 = new SpriteSheet(ImageLoader.loadImage(pathTIEL + "legs_1_right.png"));
        SpriteSheet sheetPlayerLeftLegs1 = new SpriteSheet(ImageLoader.loadImage(pathTIEL + "legs_1_left.png"));
        SpriteSheet sheetPlayerDownLegs2 = new SpriteSheet(ImageLoader.loadImage(pathTIEL + "legs_2_down.png"));
        SpriteSheet sheetPlayerUpLegs2 = new SpriteSheet(ImageLoader.loadImage(pathTIEL + "legs_2_up.png"));
        SpriteSheet sheetPlayerRightLegs2 = new SpriteSheet(ImageLoader.loadImage(pathTIEL + "legs_2_right.png"));
        SpriteSheet sheetPlayerLeftLegs2 = new SpriteSheet(ImageLoader.loadImage(pathTIEL + "legs_2_left.png"));
        SpriteSheet sheetPlayerDownLegs3 = new SpriteSheet(ImageLoader.loadImage(pathTIEL + "legs_3_down.png"));
        SpriteSheet sheetPlayerUpLegs3 = new SpriteSheet(ImageLoader.loadImage(pathTIEL + "legs_3_up.png"));
        SpriteSheet sheetPlayerRightLegs3 = new SpriteSheet(ImageLoader.loadImage(pathTIEL + "legs_3_right.png"));
        SpriteSheet sheetPlayerLeftLegs3 = new SpriteSheet(ImageLoader.loadImage(pathTIEL + "legs_3_left.png"));

        // Torso
        String pathTIET = "/textures/inventory/equipment/tors/";
        SpriteSheet sheetPlayerDownTorso1 = new SpriteSheet(ImageLoader.loadImage(pathTIET + "torso_1_down.png"));
        SpriteSheet sheetPlayerUpTorso1 = new SpriteSheet(ImageLoader.loadImage(pathTIET + "torso_1_up.png"));
        SpriteSheet sheetPlayerRightTorso1 = new SpriteSheet(ImageLoader.loadImage(pathTIET + "torso_1_right.png"));
        SpriteSheet sheetPlayerLeftTorso1 = new SpriteSheet(ImageLoader.loadImage(pathTIET + "torso_1_left.png"));
        SpriteSheet sheetPlayerDownTorso2 = new SpriteSheet(ImageLoader.loadImage(pathTIET + "torso_2_down.png"));
        SpriteSheet sheetPlayerUpTorso2 = new SpriteSheet(ImageLoader.loadImage(pathTIET + "torso_2_up.png"));
        SpriteSheet sheetPlayerRightTorso2 = new SpriteSheet(ImageLoader.loadImage(pathTIET + "torso_2_right.png"));
        SpriteSheet sheetPlayerLeftTorso2 = new SpriteSheet(ImageLoader.loadImage(pathTIET + "torso_2_left.png"));
        SpriteSheet sheetPlayerDownTorso3 = new SpriteSheet(ImageLoader.loadImage(pathTIET + "torso_3_down.png"));
        SpriteSheet sheetPlayerUpTorso3 = new SpriteSheet(ImageLoader.loadImage(pathTIET + "torso_3_up.png"));
        SpriteSheet sheetPlayerRightTorso3 = new SpriteSheet(ImageLoader.loadImage(pathTIET + "torso_3_right.png"));
        SpriteSheet sheetPlayerLeftTorso3 = new SpriteSheet(ImageLoader.loadImage(pathTIET + "torso_3_left.png"));

        // Shield
        String pathTIES = "/textures/inventory/equipment/shield/";
        SpriteSheet sheetPlayerDownShield1 = new SpriteSheet(ImageLoader.loadImage(pathTIES + "shield_1_down.png"));
        SpriteSheet sheetPlayerUpShield1 = new SpriteSheet(ImageLoader.loadImage(pathTIES + "shield_1_up.png"));
        SpriteSheet sheetPlayerLeftShield1 = new SpriteSheet(ImageLoader.loadImage(pathTIES + "shield_1_left.png"));
        SpriteSheet sheetPlayerDownShield2 = new SpriteSheet(ImageLoader.loadImage(pathTIES + "shield_2_down.png"));
        SpriteSheet sheetPlayerUpShield2 = new SpriteSheet(ImageLoader.loadImage(pathTIES + "shield_2_up.png"));
        SpriteSheet sheetPlayerLeftShield2 = new SpriteSheet(ImageLoader.loadImage(pathTIES + "shield_2_left.png"));

        // Weapon
        String pathTIEW = "/textures/inventory/equipment/weapon/";
        SpriteSheet sheetPlayerDownWeapon1 = new SpriteSheet(ImageLoader.loadImage(pathTIEW + "weapon_1_down.png"));
        SpriteSheet sheetPlayerUpWeapon1 = new SpriteSheet(ImageLoader.loadImage(pathTIEW + "weapon_1_up.png"));
        SpriteSheet sheetPlayerRightWeapon1 = new SpriteSheet(ImageLoader.loadImage(pathTIEW + "weapon_1_right.png"));
        SpriteSheet sheetPlayerDownWeapon2 = new SpriteSheet(ImageLoader.loadImage(pathTIEW + "weapon_2_down.png"));
        SpriteSheet sheetPlayerUpWeapon2 = new SpriteSheet(ImageLoader.loadImage(pathTIEW + "weapon_2_up.png"));
        SpriteSheet sheetPlayerRightWeapon2 = new SpriteSheet(ImageLoader.loadImage(pathTIEW + "weapon_2_right.png"));
        SpriteSheet sheetPlayerDownWeapon3 = new SpriteSheet(ImageLoader.loadImage(pathTIEW + "weapon_3_down.png"));
        SpriteSheet sheetPlayerUpWeapon3 = new SpriteSheet(ImageLoader.loadImage(pathTIEW + "weapon_3_up.png"));
        SpriteSheet sheetPlayerRightWeapon3 = new SpriteSheet(ImageLoader.loadImage(pathTIEW + "weapon_3_right.png"));

        SpriteSheet sheetBlank = new SpriteSheet(ImageLoader.loadImage("/textures/layerTwo/blank.png"));

        // Spider
        String pathTM = "/textures/mobs/";
        SpriteSheet sheetSpiderDown = new SpriteSheet(ImageLoader.loadImage(pathTM + "spiderDown.png"));
        SpriteSheet sheetSpiderUp = new SpriteSheet(ImageLoader.loadImage(pathTM + "spiderUp.png"));
        SpriteSheet sheetSpiderRight = new SpriteSheet(ImageLoader.loadImage(pathTM + "spiderRight.png"));
        SpriteSheet sheetSpiderLeft = new SpriteSheet(ImageLoader.loadImage(pathTM + "spiderLeft.png"));
        SpriteSheet sheetSpiderDie = new SpriteSheet(ImageLoader.loadImage(pathTM + "spiderDie.png"));
        SpriteSheet sheetSpiderAttack1 = new SpriteSheet(ImageLoader.loadImage(pathTM + "spiderAttack_1.png"));
        SpriteSheet sheetSpiderAttack2 = new SpriteSheet(ImageLoader.loadImage(pathTM + "spiderAttack_2.png"));
        SpriteSheet sheetSpiderAttack3 = new SpriteSheet(ImageLoader.loadImage(pathTM + "spiderAttack_3.png"));
        SpriteSheet sheetSpiderHealth = new SpriteSheet(ImageLoader.loadImage(pathTM + "spiderHealth.png"));
        SpriteSheet sheetSpiderHealthOwn = new SpriteSheet(ImageLoader.loadImage(pathTM + "spiderHealthOwn.png"));

        // Buttons
        String pathTB = "/textures/buttons/";
        SpriteSheet sheetButtonStart = new SpriteSheet(ImageLoader.loadImage(pathTB + "buttonStart.png"));
        SpriteSheet sheetMusicOnOff = new SpriteSheet(ImageLoader.loadImage(pathTB + "musicOnOff.png"));
        SpriteSheet sheetButtonOn = new SpriteSheet(ImageLoader.loadImage(pathTB + "button_music_on.png"));
        SpriteSheet sheetButtonOff = new SpriteSheet(ImageLoader.loadImage(pathTB + "button_music_off.png"));
        SpriteSheet sheetButtonExit = new SpriteSheet(ImageLoader.loadImage(pathTB + "buttonExit.png"));
        SpriteSheet sheetButtonExitSmall = new SpriteSheet(ImageLoader.loadImage(pathTB + "exit.png"));
        SpriteSheet sheetButtonExitSave = new SpriteSheet(ImageLoader.loadImage(pathTB + "button_game_save.png"));
        SpriteSheet sheetButtonGameInventory = new SpriteSheet(ImageLoader.loadImage(pathTB + "button_game_inventory.png"));
        SpriteSheet sheetButtonGAmeControl = new SpriteSheet(ImageLoader.loadImage(pathTB + "button_game_control.png"));
        SpriteSheet sheetButtonGameExit = new SpriteSheet(ImageLoader.loadImage(pathTB + "button_game_exit.png"));
        SpriteSheet sheetButtonGameUse = new SpriteSheet(ImageLoader.loadImage(pathTB + "button_game_use.png"));

        // Panels
        String pathT = "/textures/";
        SpriteSheet sheetMenuBackand = new SpriteSheet(ImageLoader.loadImage(pathT + "backandMenu.png"));
        SpriteSheet sheetPanel = new SpriteSheet(ImageLoader.loadImage(pathT + "ui.png"));
        SpriteSheet sheetPanelItemZero = new SpriteSheet(ImageLoader.loadImage(pathT + "panelItemZero.png"));
        SpriteSheet sheetMenuGameOver = new SpriteSheet(ImageLoader.loadImage(pathT + "gameOver.png"));
        SpriteSheet sheetControl = new SpriteSheet(ImageLoader.loadImage(pathT + "control.png"));

        // For Layers tiles
        String pathTLO = "/textures/layerOwn/";
        SpriteSheet sheetGrass = new SpriteSheet(ImageLoader.loadImage(pathTLO + "grass.png"));
        SpriteSheet sheetGrassFlowers1 = new SpriteSheet(ImageLoader.loadImage(pathTLO + "grass_flowers_1.png"));
        SpriteSheet sheetGrassFlowers2 = new SpriteSheet(ImageLoader.loadImage(pathTLO + "grass_flowers_2.png"));

        SpriteSheet sheetGrassNorthwest = new SpriteSheet(ImageLoader.loadImage(pathTLO + "/grass_northwest.png"));
        SpriteSheet sheetGrassNorth = new SpriteSheet(ImageLoader.loadImage(pathTLO + "grass_north.png"));
        SpriteSheet sheetGrassNortheast = new SpriteSheet(ImageLoader.loadImage(pathTLO + "grass_northeast.png"));
        SpriteSheet sheetGrassEast = new SpriteSheet(ImageLoader.loadImage(pathTLO + "grass_east.png"));
        SpriteSheet sheetGrassSoutheast = new SpriteSheet(ImageLoader.loadImage(pathTLO + "grass_southeast.png"));
        SpriteSheet sheetGrassSouth = new SpriteSheet(ImageLoader.loadImage(pathTLO + "grass_south.png"));
        SpriteSheet sheetGrassSouthwest = new SpriteSheet(ImageLoader.loadImage(pathTLO + "grass_southwest.png"));
        SpriteSheet sheetGrassWest = new SpriteSheet(ImageLoader.loadImage(pathTLO + "/grass_west.png"));

        SpriteSheet sheetGrassFull = new SpriteSheet(ImageLoader.loadImage(pathTLO + "grass_full.png"));

        SpriteSheet sheetWater1 = new SpriteSheet(ImageLoader.loadImage(pathTLO + "water_1.png"));
        SpriteSheet sheetWater2 = new SpriteSheet(ImageLoader.loadImage(pathTLO + "water_2.png"));
        SpriteSheet sheetWater3 = new SpriteSheet(ImageLoader.loadImage(pathTLO + "water_3.png"));
        SpriteSheet sheetWater4 = new SpriteSheet(ImageLoader.loadImage(pathTLO + "water_4.png"));

        String pathTLT = "/textures/layerTwo/";
        SpriteSheet sheetGrassBorderNorth = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_grass_north.png"));
        SpriteSheet sheetGrassBorderWest = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_grass_west.png"));
        SpriteSheet sheetGrassBorderSouth = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_grass_south.png"));
        SpriteSheet sheetGrassBorderEast = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_grass_east.png"));
        SpriteSheet sheetGrassBorderSoutheast = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_grass_southwest.png"));
        SpriteSheet sheetGrassBorderNorthwest = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_grass_northwest.png"));
        SpriteSheet sheetGrassBorderNortheast = new SpriteSheet(ImageLoader.loadImage(pathTLT + "/border_grass_northeast.png"));

        SpriteSheet sheetWaterBorderNorthwest = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_water_northwest.png"));
        SpriteSheet sheetWaterBorderNorth = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_water_north.png"));
        SpriteSheet sheetWaterBorderNortheast = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_water_northeast.png"));
        SpriteSheet sheetWaterBorderEast = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_water_east.png"));
        SpriteSheet sheetWaterBorderSoutheast = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_water_southeast.png"));
        SpriteSheet sheetWaterBorderSouth = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_water_south.png"));
        SpriteSheet sheetWaterBorderSouthwest = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_water_southwest.png"));
        SpriteSheet sheetWaterBorderWest = new SpriteSheet(ImageLoader.loadImage(pathTLT + "border_water_west.png"));

        SpriteSheet sheetAngleBorderWaterNorthwest = new SpriteSheet(ImageLoader.loadImage(pathTLT + "angle_border_water_northwest.png"));
        SpriteSheet sheetAngleBorderWaterNortheast = new SpriteSheet(ImageLoader.loadImage(pathTLT + "angle_border_water_northeast.png"));
        SpriteSheet sheetAngleBorderWaterSoutheast = new SpriteSheet(ImageLoader.loadImage(pathTLT + "angle_border_water_southeast.png"));
        SpriteSheet sheetAngleBorderWaterSouthwest = new SpriteSheet(ImageLoader.loadImage(pathTLT + "angle_border_water_southwest.png"));

        SpriteSheet sheetTree = new SpriteSheet(ImageLoader.loadImage(pathTLT + "tree.png"));
        SpriteSheet sheetBush = new SpriteSheet(ImageLoader.loadImage(pathTLT + "bush.png"));

        SpriteSheet sheetChestClosed = new SpriteSheet(ImageLoader.loadImage(pathT + "сhest/chest_closed.png"));

        SpriteSheet sheetEnter = new SpriteSheet(ImageLoader.loadImage(pathT + "enters/enter.png"));

        // Items
        String pathTII = "/textures/inventory/item/";
        SpriteSheet sheetItemApple = new SpriteSheet(ImageLoader.loadImage(pathTII + "food/apple.png"));
        SpriteSheet sheetItemStrawberry = new SpriteSheet(ImageLoader.loadImage(pathTII + "food/strawberry.png"));
        SpriteSheet sheetItemPotionBlue = new SpriteSheet(ImageLoader.loadImage(pathTII + "potion/blue.png"));
        SpriteSheet sheetItemPotionWhite = new SpriteSheet(ImageLoader.loadImage(pathTII + "potion/white.png"));
        SpriteSheet sheetItemPotionRed = new SpriteSheet(ImageLoader.loadImage(pathTII + "potion/red.png"));
        SpriteSheet sheetItemRingAttack = new SpriteSheet(ImageLoader.loadImage(pathTII + "ring/ring1.png"));
        SpriteSheet sheetItemRingHealth = new SpriteSheet(ImageLoader.loadImage(pathTII + "ring/ring3.png"));
        SpriteSheet sheetItemAmuletAttack = new SpriteSheet(ImageLoader.loadImage(pathTII + "amulet/attack.png"));
        SpriteSheet sheetItemAmuletHealth = new SpriteSheet(ImageLoader.loadImage(pathTII + "amulet/health.png"));
        SpriteSheet sheetItemBoot1 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/boot/boot1.png"));
        SpriteSheet sheetItemBoot2 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/boot/boot2.png"));
        SpriteSheet sheetItemBoot3 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/boot/boot3.png"));
        SpriteSheet sheetItemGloves1 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/hands/glove1.png"));
        SpriteSheet sheetItemGloves2 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/hands/glove2.png"));
        SpriteSheet sheetItemGloves3 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/hands/glove3.png"));
        SpriteSheet sheetItemHead1 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/head/head1.png"));
        SpriteSheet sheetItemHead2 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/head/head2.png"));
        SpriteSheet sheetItemHead3 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/head/head3.png"));
        SpriteSheet sheetItemShield1 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/shield/shield1.png"));
        SpriteSheet sheetItemShield2 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/shield/shield2.png"));
        SpriteSheet sheetItemTorso1 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/torso/torso1.png"));
        SpriteSheet sheetItemTorso2 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/torso/torso2.png"));
        SpriteSheet sheetItemTorso3 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/torso/torso3.png"));
        SpriteSheet sheetItemWeapon1 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/weapon/weapon1.png"));
        SpriteSheet sheetItemWeapon2 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/weapon/weapon2.png"));
        SpriteSheet sheetItemWeapon3 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/weapon/weapon3.png"));
        SpriteSheet sheetItemKey = new SpriteSheet(ImageLoader.loadImage(pathTII + "key.png"));
        SpriteSheet sheetItemPants1 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/pants/pants1.png"));
        SpriteSheet sheetItemPants2 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/pants/pants2.png"));
        SpriteSheet sheetItemPants3 = new SpriteSheet(ImageLoader.loadImage(pathTII + "armor/pants/pants3.png"));

        // Items Description
        String pathTIID = "/textures/inventory/itemDescription/";
        SpriteSheet sheetItemAppleDescription = new SpriteSheet(ImageLoader.loadImage(pathTIID + "apple.png"));
        SpriteSheet sheetItemStrawberryDescription = new SpriteSheet(ImageLoader.loadImage(pathTIID + "strawberry.png"));
        SpriteSheet sheetItemPotionBlueDescription = new SpriteSheet(ImageLoader.loadImage(pathTIID + "mana.png"));
        SpriteSheet sheetItemPotionWhiteDescription = new SpriteSheet(ImageLoader.loadImage(pathTIID + "poisoning.png"));
        SpriteSheet sheetItemPotionRedDescription = new SpriteSheet(ImageLoader.loadImage(pathTIID + "health.png"));
        SpriteSheet sheetItemRingAttackDescription = new SpriteSheet(ImageLoader.loadImage(pathTIID + "ringHealth.png"));
        SpriteSheet sheetItemRingHealthDescription = new SpriteSheet(ImageLoader.loadImage(pathTIID + "ringAttack.png"));
        SpriteSheet sheetItemAmuletAttackDescription = new SpriteSheet(ImageLoader.loadImage(pathTIID + "amuletHealth.png"));
        SpriteSheet sheetItemAmuletHealthDescription = new SpriteSheet(ImageLoader.loadImage(pathTIID + "amuletAttack.png"));
        SpriteSheet sheetItemBoot1Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "boots1.png"));
        SpriteSheet sheetItemBoot2Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "boots2.png"));
        SpriteSheet sheetItemBoot3Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "boots3.png"));
        SpriteSheet sheetItemGloves1Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "gloves1.png"));
        SpriteSheet sheetItemGloves2Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "gloves2.png"));
        SpriteSheet sheetItemGloves3Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "gloves3.png"));
        SpriteSheet sheetItemHead1Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "head1.png"));
        SpriteSheet sheetItemHead2Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "head2.png"));
        SpriteSheet sheetItemHead3Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "head3.png"));
        SpriteSheet sheetItemShield1Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "shield1.png"));
        SpriteSheet sheetItemShield2Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "shield2.png"));
        SpriteSheet sheetItemTorso1Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "torso1.png"));
        SpriteSheet sheetItemTorso2Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "torso2.png"));
        SpriteSheet sheetItemTorso3Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "torso3.png"));
        SpriteSheet sheetItemWeapon1Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "weapon1.png"));
        SpriteSheet sheetItemWeapon2Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "weapon2.png"));
        SpriteSheet sheetItemWeapon3Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "weapon3.png"));
        SpriteSheet sheetItemPants1Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "pants1.png"));
        SpriteSheet sheetItemPants2Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "pants2.png"));
        SpriteSheet sheetItemPants3Description = new SpriteSheet(ImageLoader.loadImage(pathTIID + "/pants3.png"));
        SpriteSheet sheetItemKeyDescription = new SpriteSheet(ImageLoader.loadImage(pathTIID + "key.png"));

        // Inventory
        String pathTI = "/textures/inventory/";
        SpriteSheet sheetItemBorder = new SpriteSheet(ImageLoader.loadImage(pathTI + "border.png"));
        SpriteSheet sheetInventory = new SpriteSheet(ImageLoader.loadImage(pathTI + "inventory_background.png"));

        // Skill
        String pathTS1 = "/textures/skills/skill_1/";
        SpriteSheet sheetSkill1_1 = new SpriteSheet(ImageLoader.loadImage(pathTS1 + "skill1.png"));
        SpriteSheet sheetSkill1_2 = new SpriteSheet(ImageLoader.loadImage(pathTS1 + "skill2.png"));
        SpriteSheet sheetSkill1_3 = new SpriteSheet(ImageLoader.loadImage(pathTS1 + "skill3.png"));
        SpriteSheet sheetSkill1_4 = new SpriteSheet(ImageLoader.loadImage(pathTS1 + "skill4.png"));
        SpriteSheet sheetSkill1_5 = new SpriteSheet(ImageLoader.loadImage(pathTS1 + "skill5.png"));

        String pathTS2 = "/textures/skills/skill_2/";
        SpriteSheet sheetSkill2_1 = new SpriteSheet(ImageLoader.loadImage(pathTS2 + "skill_2_1.png"));
        SpriteSheet sheetSkill2_2 = new SpriteSheet(ImageLoader.loadImage(pathTS2 + "skill_2_2.png"));
        SpriteSheet sheetSkill2_3 = new SpriteSheet(ImageLoader.loadImage(pathTS2 + "skill_2_3.png"));
        SpriteSheet sheetSkill2_4 = new SpriteSheet(ImageLoader.loadImage(pathTS2 + "skill_2_4.png"));
        SpriteSheet sheetSkill2_5 = new SpriteSheet(ImageLoader.loadImage(pathTS2 + "skill_2_5.png"));
        SpriteSheet sheetSkill2_6 = new SpriteSheet(ImageLoader.loadImage(pathTS2 + "skill_2_6.png"));
        SpriteSheet sheetSkill2_7 = new SpriteSheet(ImageLoader.loadImage(pathTS2 + "skill_2_7.png"));
        SpriteSheet sheetSkill2_8 = new SpriteSheet(ImageLoader.loadImage(pathTS2 + "skill_2_8.png"));

        String pathTS3 = "/textures/skills/skill_3/";
        SpriteSheet sheetSkill3Down1 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_down/skill_3_down_1.png"));
        SpriteSheet sheetSkill3Down2 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_down/skill_3_down_2.png"));
        SpriteSheet sheetSkill3Down3 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_down/skill_3_down_3.png"));
        SpriteSheet sheetSkill3Down4 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_down/skill_3_down_4.png"));
        SpriteSheet sheetSkill3Down5 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_down/skill_3_down_5.png"));
        SpriteSheet sheetSkill3Up1 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_up/skill_3_up_1.png"));
        SpriteSheet sheetSkill3Up2 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_up/skill_3_up_2.png"));
        SpriteSheet sheetSkill3Up3 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_up/skill_3_up_3.png"));
        SpriteSheet sheetSkill3Up4 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_up/skill_3_up_4.png"));
        SpriteSheet sheetSkill3Up5 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_up/skill_3_up_5.png"));
        SpriteSheet sheetSkill3Left1 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_left/skill_3_left_1.png"));
        SpriteSheet sheetSkill3Left2 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_left/skill_3_left_2.png"));
        SpriteSheet sheetSkill3Left3 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_left/skill_3_left_3.png"));
        SpriteSheet sheetSkill3Left4 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_left/skill_3_left_4.png"));
        SpriteSheet sheetSkill3Left5 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_left/skill_3_left_5.png"));
        SpriteSheet sheetSkill3Right1 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_right/skill_3_right_1.png"));
        SpriteSheet sheetSkill3Right2 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_right/skill_3_right_2.png"));
        SpriteSheet sheetSkill3Right3 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_right/skill_3_right_3.png"));
        SpriteSheet sheetSkill3Right4 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_right/skill_3_right_4.png"));
        SpriteSheet sheetSkill3Right5 = new SpriteSheet(ImageLoader.loadImage(pathTS3 + "skill_3_right/skill_3_right_5.png"));

        String pathTN = "/textures/numbers/";
        SpriteSheet sheetNumber_0 = new SpriteSheet(ImageLoader.loadImage(pathTN + "number_0.png"));
        SpriteSheet sheetNumber_1 = new SpriteSheet(ImageLoader.loadImage(pathTN + "number_1.png"));
        SpriteSheet sheetNumber_2 = new SpriteSheet(ImageLoader.loadImage(pathTN + "number_2.png"));
        SpriteSheet sheetNumber_3 = new SpriteSheet(ImageLoader.loadImage(pathTN + "number_3.png"));
        SpriteSheet sheetNumber_4 = new SpriteSheet(ImageLoader.loadImage(pathTN + "number_4.png"));
        SpriteSheet sheetNumber_5 = new SpriteSheet(ImageLoader.loadImage(pathTN + "number_5.png"));
        SpriteSheet sheetNumber_6 = new SpriteSheet(ImageLoader.loadImage(pathTN + "number_6.png"));
        SpriteSheet sheetNumber_7 = new SpriteSheet(ImageLoader.loadImage(pathTN + "number_7.png"));
        SpriteSheet sheetNumber_8 = new SpriteSheet(ImageLoader.loadImage(pathTN + "number_8.png"));
        SpriteSheet sheetNumber_9 = new SpriteSheet(ImageLoader.loadImage(pathTN + "number_9.png"));

        // Properties
        String pathTP = "/textures/properties/";
        SpriteSheet sheetOwnHealth = new SpriteSheet(ImageLoader.loadImage(pathTP + "health.png"));
        SpriteSheet sheetOwnMana = new SpriteSheet(ImageLoader.loadImage(pathTP + "/mana.png"));
        SpriteSheet sheetOwnPoisoning = new SpriteSheet(ImageLoader.loadImage(pathTP + "poisoning.png"));

        // Items active
        String pathTBAI = "/textures/buttons/activeIcons/";
        SpriteSheet sheetItem0Active = new SpriteSheet(ImageLoader.loadImage(pathTBAI + "0_icon_active.png"));
        SpriteSheet sheetItem1Active = new SpriteSheet(ImageLoader.loadImage(pathTBAI + "1_icon_active.png"));
        SpriteSheet sheetItem2Active = new SpriteSheet(ImageLoader.loadImage(pathTBAI + "2_icon_active.png"));
        SpriteSheet sheetItem3Active = new SpriteSheet(ImageLoader.loadImage(pathTBAI + "3_icon_active.png"));
        SpriteSheet sheetItem4Active = new SpriteSheet(ImageLoader.loadImage(pathTBAI + "4_icon_active.png"));
        SpriteSheet sheetItem5Active = new SpriteSheet(ImageLoader.loadImage(pathTBAI + "5_icon_active.png"));
        SpriteSheet sheetItem6Active = new SpriteSheet(ImageLoader.loadImage(pathTBAI + "6_icon_active.png"));
        SpriteSheet sheetItem7Active = new SpriteSheet(ImageLoader.loadImage(pathTBAI + "7_icon_active.png"));
        SpriteSheet sheetItem8Active = new SpriteSheet(ImageLoader.loadImage(pathTBAI + "8_icon_active.png"));
        SpriteSheet sheetItem9Active = new SpriteSheet(ImageLoader.loadImage(pathTBAI + "9_icon_active.png"));


        // Cropped images for these elements to match the titles
        player_down = new BufferedImage[3];
        player_up = new BufferedImage[3];
        player_right = new BufferedImage[3];
        player_left = new BufferedImage[3];

        player_down[0] = sheetPlayerDown.cropImage(0,0,widthPlayer,heightPlayer);
        player_down[1] = sheetPlayerDown.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down[2] = sheetPlayerDown.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up[0] = sheetPlayerUp.cropImage(0,0,widthPlayer,heightPlayer);
        player_up[1] = sheetPlayerUp.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up[2] = sheetPlayerUp.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right[0] = sheetPlayerRight.cropImage(0,0,widthPlayer,heightPlayer);
        player_right[1] = sheetPlayerRight.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right[2] = sheetPlayerRight.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left[0] = sheetPlayerLeft.cropImage(0,0,widthPlayer,heightPlayer);
        player_left[1] = sheetPlayerLeft.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left[2] = sheetPlayerLeft.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        // Boot
        player_down_boots1 = new BufferedImage[3];
        player_up_boots1 = new BufferedImage[3];
        player_right_boots1 = new BufferedImage[3];
        player_left_boots1 = new BufferedImage[3];
        player_down_boots2 = new BufferedImage[3];
        player_up_boots2 = new BufferedImage[3];
        player_right_boots2 = new BufferedImage[3];
        player_left_boots2 = new BufferedImage[3];
        player_down_boots3 = new BufferedImage[3];
        player_up_boots3 = new BufferedImage[3];
        player_right_boots3 = new BufferedImage[3];
        player_left_boots3 = new BufferedImage[3];

        player_down_boots1[0] = sheetPlayerDownBoots1.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_boots1[1] = sheetPlayerDownBoots1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_boots1[2] = sheetPlayerDownBoots1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_boots1[0] = sheetPlayerUpBoots1.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_boots1[1] = sheetPlayerUpBoots1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_boots1[2] = sheetPlayerUpBoots1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_boots1[0] = sheetPlayerRightBoots1.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_boots1[1] = sheetPlayerRightBoots1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_boots1[2] = sheetPlayerRightBoots1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_boots1[0] = sheetPlayerLeftBoots1.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_boots1[1] = sheetPlayerLeftBoots1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_boots1[2] = sheetPlayerLeftBoots1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_boots2[0] = sheetPlayerDownBoots2.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_boots2[1] = sheetPlayerDownBoots2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_boots2[2] = sheetPlayerDownBoots2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_boots2[0] = sheetPlayerUpBoots2.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_boots2[1] = sheetPlayerUpBoots2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_boots2[2] = sheetPlayerUpBoots2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_boots2[0] = sheetPlayerRightBoots2.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_boots2[1] = sheetPlayerRightBoots2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_boots2[2] = sheetPlayerRightBoots2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_boots2[0] = sheetPlayerLeftBoots2.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_boots2[1] = sheetPlayerLeftBoots2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_boots2[2] = sheetPlayerLeftBoots2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_boots3[0] = sheetPlayerDownBoots3.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_boots3[1] = sheetPlayerDownBoots3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_boots3[2] = sheetPlayerDownBoots3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_boots3[0] = sheetPlayerUpBoots3.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_boots3[1] = sheetPlayerUpBoots3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_boots3[2] = sheetPlayerUpBoots3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_boots3[0] = sheetPlayerRightBoots3.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_boots3[1] = sheetPlayerRightBoots3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_boots3[2] = sheetPlayerRightBoots3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_boots3[0] = sheetPlayerLeftBoots3.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_boots3[1] = sheetPlayerLeftBoots3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_boots3[2] = sheetPlayerLeftBoots3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        // Head
        player_down_head1 = new BufferedImage[3];
        player_up_head1 = new BufferedImage[3];
        player_right_head1 = new BufferedImage[3];
        player_left_head1 = new BufferedImage[3];
        player_down_head2 = new BufferedImage[3];
        player_up_head2 = new BufferedImage[3];
        player_right_head2 = new BufferedImage[3];
        player_left_head2 = new BufferedImage[3];
        player_down_head3 = new BufferedImage[3];
        player_up_head3 = new BufferedImage[3];
        player_right_head3 = new BufferedImage[3];
        player_left_head3 = new BufferedImage[3];

        player_down_head1[0] = sheetPlayerDownHead1.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_head1[1] = sheetPlayerDownHead1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_head1[2] = sheetPlayerDownHead1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_head1[0] = sheetPlayerUpHead1.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_head1[1] = sheetPlayerUpHead1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_head1[2] = sheetPlayerUpHead1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_head1[0] = sheetPlayerRightHead1.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_head1[1] = sheetPlayerRightHead1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_head1[2] = sheetPlayerRightHead1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_head1[0] = sheetPlayerLeftHead1.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_head1[1] = sheetPlayerLeftHead1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_head1[2] = sheetPlayerLeftHead1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_head2[0] = sheetPlayerDownHead2.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_head2[1] = sheetPlayerDownHead2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_head2[2] = sheetPlayerDownHead2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_head2[0] = sheetPlayerUpHead2.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_head2[1] = sheetPlayerUpHead2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_head2[2] = sheetPlayerUpHead2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_head2[0] = sheetPlayerRightHead2.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_head2[1] = sheetPlayerRightHead2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_head2[2] = sheetPlayerRightHead2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_head2[0] = sheetPlayerLeftHead2.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_head2[1] = sheetPlayerLeftHead2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_head2[2] = sheetPlayerLeftHead2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_head3[0] = sheetPlayerDownHead3.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_head3[1] = sheetPlayerDownHead3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_head3[2] = sheetPlayerDownHead3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_head3[0] = sheetPlayerUpHead3.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_head3[1] = sheetPlayerUpHead3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_head3[2] = sheetPlayerUpHead3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_head3[0] = sheetPlayerRightHead3.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_head3[1] = sheetPlayerRightHead3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_head3[2] = sheetPlayerRightHead3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_head3[0] = sheetPlayerLeftHead3.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_head3[1] = sheetPlayerLeftHead3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_head3[2] = sheetPlayerLeftHead3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        // Gloves
        player_down_gloves1 = new BufferedImage[3];
        player_up_gloves1 = new BufferedImage[3];
        player_right_gloves1 = new BufferedImage[3];
        player_left_gloves1 = new BufferedImage[3];
        player_down_gloves2 = new BufferedImage[3];
        player_up_gloves2 = new BufferedImage[3];
        player_right_gloves2 = new BufferedImage[3];
        player_left_gloves2 = new BufferedImage[3];
        player_down_gloves3 = new BufferedImage[3];
        player_up_gloves3 = new BufferedImage[3];
        player_right_gloves3 = new BufferedImage[3];
        player_left_gloves3 = new BufferedImage[3];

        player_down_gloves1[0] = sheetPlayerDownGloves1.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_gloves1[1] = sheetPlayerDownGloves1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_gloves1[2] = sheetPlayerDownGloves1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_gloves1[0] = sheetPlayerUpGloves1.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_gloves1[1] = sheetPlayerUpGloves1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_gloves1[2] = sheetPlayerUpGloves1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_gloves1[0] = sheetPlayerRightGloves1.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_gloves1[1] = sheetPlayerRightGloves1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_gloves1[2] = sheetPlayerRightGloves1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_gloves1[0] = sheetPlayerLeftGloves1.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_gloves1[1] = sheetPlayerLeftGloves1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_gloves1[2] = sheetPlayerLeftGloves1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_gloves2[0] = sheetPlayerDownGloves2.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_gloves2[1] = sheetPlayerDownGloves2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_gloves2[2] = sheetPlayerDownGloves2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_gloves2[0] = sheetPlayerUpGloves2.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_gloves2[1] = sheetPlayerUpGloves2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_gloves2[2] = sheetPlayerUpGloves2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_gloves2[0] = sheetPlayerRightGloves2.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_gloves2[1] = sheetPlayerRightGloves2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_gloves2[2] = sheetPlayerRightGloves2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_gloves3[0] = sheetPlayerLeftGloves2.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_gloves3[1] = sheetPlayerLeftGloves2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_gloves3[2] = sheetPlayerLeftGloves2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_gloves3[0] = sheetPlayerDownGloves3.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_gloves3[1] = sheetPlayerDownGloves3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_gloves3[2] = sheetPlayerDownGloves3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_gloves3[0] = sheetPlayerUpGloves3.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_gloves3[1] = sheetPlayerUpGloves3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_gloves3[2] = sheetPlayerUpGloves3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_gloves3[0] = sheetPlayerRightGloves3.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_gloves3[1] = sheetPlayerRightGloves3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_gloves3[2] = sheetPlayerRightGloves3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_gloves3[0] = sheetPlayerLeftGloves3.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_gloves3[1] = sheetPlayerLeftGloves3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_gloves3[2] = sheetPlayerLeftGloves3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        // Torso
        player_down_torso1 = new BufferedImage[3];
        player_up_torso1 = new BufferedImage[3];
        player_right_torso1 = new BufferedImage[3];
        player_left_torso1 = new BufferedImage[3];
        player_down_torso2 = new BufferedImage[3];
        player_up_torso2 = new BufferedImage[3];
        player_right_torso2 = new BufferedImage[3];
        player_left_torso2 = new BufferedImage[3];
        player_down_torso3 = new BufferedImage[3];
        player_up_torso3 = new BufferedImage[3];
        player_right_torso3 = new BufferedImage[3];
        player_left_torso3 = new BufferedImage[3];

        player_down_torso1[0] = sheetPlayerDownTorso1.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_torso1[1] = sheetPlayerDownTorso1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_torso1[2] = sheetPlayerDownTorso1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_torso1[0] = sheetPlayerUpTorso1.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_torso1[1] = sheetPlayerUpTorso1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_torso1[2] = sheetPlayerUpTorso1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_torso1[0] = sheetPlayerRightTorso1.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_torso1[1] = sheetPlayerRightTorso1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_torso1[2] = sheetPlayerRightTorso1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_torso1[0] = sheetPlayerLeftTorso1.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_torso1[1] = sheetPlayerLeftTorso1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_torso1[2] = sheetPlayerLeftTorso1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_torso2[0] = sheetPlayerDownTorso2.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_torso2[1] = sheetPlayerDownTorso2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_torso2[2] = sheetPlayerDownTorso2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_torso2[0] = sheetPlayerUpTorso2.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_torso2[1] = sheetPlayerUpTorso2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_torso2[2] = sheetPlayerUpTorso2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_torso2[0] = sheetPlayerRightTorso2.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_torso2[1] = sheetPlayerRightTorso2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_torso2[2] = sheetPlayerRightTorso2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_torso2[0] = sheetPlayerLeftTorso2.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_torso2[1] = sheetPlayerLeftTorso2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_torso2[2] = sheetPlayerLeftTorso2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_torso3[0] = sheetPlayerDownTorso3.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_torso3[1] = sheetPlayerDownTorso3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_torso3[2] = sheetPlayerDownTorso3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_torso3[0] = sheetPlayerUpTorso3.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_torso3[1] = sheetPlayerUpTorso3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_torso3[2] = sheetPlayerUpTorso3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_torso3[0] = sheetPlayerRightTorso3.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_torso3[1] = sheetPlayerRightTorso3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_torso3[2] = sheetPlayerRightTorso3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_torso3[0] = sheetPlayerLeftTorso3.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_torso3[1] = sheetPlayerLeftTorso3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_torso3[2] = sheetPlayerLeftTorso3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        // Legs
        player_down_pants1 = new BufferedImage[3];
        player_up_pants1 = new BufferedImage[3];
        player_right_pants1 = new BufferedImage[3];
        player_left_pants1 = new BufferedImage[3];
        player_down_pants2 = new BufferedImage[3];
        player_up_pants2 = new BufferedImage[3];
        player_right_pants2 = new BufferedImage[3];
        player_left_pants2 = new BufferedImage[3];
        player_down_pants3 = new BufferedImage[3];
        player_up_pants3 = new BufferedImage[3];
        player_right_pants3 = new BufferedImage[3];
        player_left_pants3 = new BufferedImage[3];

        player_down_pants1[0] = sheetPlayerDownLegs1.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_pants1[1] = sheetPlayerDownLegs1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_pants1[2] = sheetPlayerDownLegs1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_pants1[0] = sheetPlayerUpLegs1.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_pants1[1] = sheetPlayerUpLegs1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_pants1[2] = sheetPlayerUpLegs1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_pants1[0] = sheetPlayerRightLegs1.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_pants1[1] = sheetPlayerRightLegs1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_pants1[2] = sheetPlayerRightLegs1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_pants1[0] = sheetPlayerLeftLegs1.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_pants1[1] = sheetPlayerLeftLegs1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_pants1[2] = sheetPlayerLeftLegs1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_pants2[0] = sheetPlayerDownLegs2.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_pants2[1] = sheetPlayerDownLegs2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_pants2[2] = sheetPlayerDownLegs2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_pants2[0] = sheetPlayerUpLegs2.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_pants2[1] = sheetPlayerUpLegs2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_pants2[2] = sheetPlayerUpLegs2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_pants2[0] = sheetPlayerRightLegs2.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_pants2[1] = sheetPlayerRightLegs2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_pants2[2] = sheetPlayerRightLegs2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_pants2[0] = sheetPlayerLeftLegs2.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_pants2[1] = sheetPlayerLeftLegs2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_pants2[2] = sheetPlayerLeftLegs2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_pants3[0] = sheetPlayerDownLegs3.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_pants3[1] = sheetPlayerDownLegs3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_pants3[2] = sheetPlayerDownLegs3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_pants3[0] = sheetPlayerUpLegs3.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_pants3[1] = sheetPlayerUpLegs3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_pants3[2] = sheetPlayerUpLegs3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_pants3[0] = sheetPlayerRightLegs3.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_pants3[1] = sheetPlayerRightLegs3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_pants3[2] = sheetPlayerRightLegs3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_pants3[0] = sheetPlayerLeftLegs3.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_pants3[1] = sheetPlayerLeftLegs3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_pants3[2] = sheetPlayerLeftLegs3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        // Shield
        player_down_shield1 = new BufferedImage[3];
        player_up_shield1 = new BufferedImage[3];
        player_left_shield1 = new BufferedImage[3];
        player_down_shield2 = new BufferedImage[3];
        player_up_shield2 = new BufferedImage[3];
        player_left_shield2 = new BufferedImage[3];

        player_down_shield1[0] = sheetPlayerDownShield1.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_shield1[1] = sheetPlayerDownShield1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_shield1[2] = sheetPlayerDownShield1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_shield1[0] = sheetPlayerUpShield1.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_shield1[1] = sheetPlayerUpShield1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_shield1[2] = sheetPlayerUpShield1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_shield1[0] = sheetPlayerLeftShield1.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_shield1[1] = sheetPlayerLeftShield1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_shield1[2] = sheetPlayerLeftShield1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_shield2[0] = sheetPlayerDownShield2.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_shield2[1] = sheetPlayerDownShield2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_shield2[2] = sheetPlayerDownShield2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_shield2[0] = sheetPlayerUpShield2.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_shield2[1] = sheetPlayerUpShield2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_shield2[2] = sheetPlayerUpShield2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_left_shield2[0] = sheetPlayerLeftShield2.cropImage(0,0,widthPlayer,heightPlayer);
        player_left_shield2[1] = sheetPlayerLeftShield2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_left_shield2[2] = sheetPlayerLeftShield2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        // Weapon
        player_down_weapon1 = new BufferedImage[3];
        player_up_weapon1 = new BufferedImage[3];
        player_right_weapon1 = new BufferedImage[3];
        player_down_weapon2 = new BufferedImage[3];
        player_up_weapon2 = new BufferedImage[3];
        player_right_weapon2 = new BufferedImage[3];
        player_down_weapon3 = new BufferedImage[3];
        player_up_weapon3 = new BufferedImage[3];
        player_right_weapon3 = new BufferedImage[3];

        player_down_weapon1[0] = sheetPlayerDownWeapon1.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_weapon1[1] = sheetPlayerDownWeapon1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_weapon1[2] = sheetPlayerDownWeapon1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_weapon1[0] = sheetPlayerUpWeapon1.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_weapon1[1] = sheetPlayerUpWeapon1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_weapon1[2] = sheetPlayerUpWeapon1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_weapon1[0] = sheetPlayerRightWeapon1.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_weapon1[1] = sheetPlayerRightWeapon1.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_weapon1[2] = sheetPlayerRightWeapon1.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_weapon2[0] = sheetPlayerDownWeapon2.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_weapon2[1] = sheetPlayerDownWeapon2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_weapon2[2] = sheetPlayerDownWeapon2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_weapon2[0] = sheetPlayerUpWeapon2.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_weapon2[1] = sheetPlayerUpWeapon2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_weapon2[2] = sheetPlayerUpWeapon2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_weapon2[0] = sheetPlayerRightWeapon2.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_weapon2[1] = sheetPlayerRightWeapon2.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_weapon2[2] = sheetPlayerRightWeapon2.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        player_down_weapon3[0] = sheetPlayerDownWeapon3.cropImage(0,0,widthPlayer,heightPlayer);
        player_down_weapon3[1] = sheetPlayerDownWeapon3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_down_weapon3[2] = sheetPlayerDownWeapon3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_up_weapon3[0] = sheetPlayerUpWeapon3.cropImage(0,0,widthPlayer,heightPlayer);
        player_up_weapon3[1] = sheetPlayerUpWeapon3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_up_weapon3[2] = sheetPlayerUpWeapon3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);
        player_right_weapon3[0] = sheetPlayerRightWeapon3.cropImage(0,0,widthPlayer,heightPlayer);
        player_right_weapon3[1] = sheetPlayerRightWeapon3.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        player_right_weapon3[2] = sheetPlayerRightWeapon3.cropImage(2* widthPlayer,0,widthPlayer,heightPlayer);

        blank = sheetBlank.cropImage(0,0,width,height);

        // Spider
        spider_down = new BufferedImage[3];
        spider_up = new BufferedImage[3];
        spider_right = new BufferedImage[3];
        spider_left = new BufferedImage[3];
        spider_attack = new BufferedImage[3];

        spider_down[0] = sheetSpiderDown.cropImage(0,0,widthPlayer,heightPlayer);
        spider_down[1] = sheetSpiderDown.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        spider_down[2] = sheetSpiderDown.cropImage(widthPlayer * 2,0,widthPlayer,heightPlayer);
        spider_up[0] = sheetSpiderUp.cropImage(0,0,widthPlayer,heightPlayer);
        spider_up[1] = sheetSpiderUp.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        spider_up[2] = sheetSpiderUp.cropImage(widthPlayer * 2,0,widthPlayer,heightPlayer);
        spider_right[0] = sheetSpiderRight.cropImage(0,0,widthPlayer,heightPlayer);
        spider_right[1] = sheetSpiderRight.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        spider_right[2] = sheetSpiderRight.cropImage(widthPlayer * 2,0,widthPlayer,heightPlayer);
        spider_left[0] = sheetSpiderLeft.cropImage(0,0,widthPlayer,heightPlayer);
        spider_left[1] = sheetSpiderLeft.cropImage(widthPlayer,0,widthPlayer,heightPlayer);
        spider_left[2] = sheetSpiderLeft.cropImage(widthPlayer * 2,0,widthPlayer,heightPlayer);
        spider_attack[0] = sheetSpiderAttack1.cropImage(0,0,3*widthPlayer,3*heightPlayer);
        spider_attack[1] = sheetSpiderAttack2.cropImage(0,0,3*widthPlayer,3*heightPlayer);
        spider_attack[2] = sheetSpiderAttack3.cropImage(0,0,3*widthPlayer,3*heightPlayer);
        spiderDie =sheetSpiderDie.cropImage(0,0,widthPlayer,heightPlayer);
        spiderHealth =sheetSpiderHealth.cropImage(0,0,2*width,10);
        spiderHealthOwn =sheetSpiderHealthOwn.cropImage(0,0,6,8);

        // UI menu
        button_start = new BufferedImage[2];
        music_on_off = new BufferedImage[2];
        button_music_on = new BufferedImage[2];
        button_music_off = new BufferedImage[2];
        button_exit = new BufferedImage[2];
        button_exit_small = new BufferedImage[2];

        button_start[0] = sheetButtonStart.cropImage(0,0,5*width,height);
        button_start[1] = sheetButtonStart.cropImage(0,height,5*width,height);
        button_exit[0] = sheetButtonExit.cropImage(0,0,5*width,height);
        button_exit[1] = sheetButtonExit.cropImage(0,height,5*width,height);
        button_exit_small[0] = sheetButtonExitSmall.cropImage(0,0,3*width, 3*height);
        button_exit_small[1] = sheetButtonExitSmall.cropImage(3*width,0,3*width,3*height);

        music_on_off[0] = sheetMusicOnOff.cropImage(0,0,66,60);
        music_on_off[1] = sheetMusicOnOff.cropImage(75,0,66,60);
        button_music_on[0] = sheetButtonOn.cropImage(0,0,116,60);
        button_music_on[1] = sheetButtonOn.cropImage(0,60,116,60);
        button_music_off[0] = sheetButtonOff.cropImage(0,0,116,60);
        button_music_off[1] = sheetButtonOff.cropImage(0,60,116,60);

        // Panels
        menuBackand = sheetMenuBackand.cropImage(0,0,40*width,25*height);
        control = sheetControl.cropImage(0,0,660,12*height);
        panel = sheetPanel.cropImage(0,0,40*width,25*height);
        panelItemZero = sheetPanelItemZero.cropImage(0,0, width, height);
        inventory = sheetInventory.cropImage(0,0,660,12*height);
        gameOver = sheetMenuGameOver.cropImage(0,0,40*width,25*height);

        // Panel buttons
        button_game_inventory = new BufferedImage[2];
        button_game_control = new BufferedImage[2];
        button_game_exit= new BufferedImage[2];
        button_game_use = new BufferedImage[2];
        button_game_save = new BufferedImage[2];

        button_game_inventory[0] = sheetButtonGameInventory.cropImage(0,0,153,44);
        button_game_inventory[1] = sheetButtonGameInventory.cropImage(0,44,153,44);
        button_game_control[0] = sheetButtonGAmeControl.cropImage(0,0,153,44);
        button_game_control[1] = sheetButtonGAmeControl.cropImage(0,44,153,44);
        button_game_exit[0] = sheetButtonGameExit.cropImage(0,0,153,44);
        button_game_exit[1] = sheetButtonGameExit.cropImage(0,44,153,44);
        button_game_save[0] = sheetButtonExitSave.cropImage(0,0,153,44);
        button_game_save[1] = sheetButtonExitSave.cropImage(0,44,153,44);
        button_game_use[0] = sheetButtonGameUse.cropImage(0,0,6*width, 2*height);
        button_game_use[1] = sheetButtonGameUse.cropImage(0,2*height,6*width, 2*height);

        // Skill 1
        skill1_1 = new BufferedImage[5];

        skill1_1[0] = sheetSkill1_1.cropImage(0,0,96,96);
        skill1_1[1] = sheetSkill1_2.cropImage(0,0,96,96);
        skill1_1[2] = sheetSkill1_3.cropImage(0,0,96,96);
        skill1_1[3] = sheetSkill1_4.cropImage(0,0,96,96);
        skill1_1[4] = sheetSkill1_5.cropImage(0,0,96,96);

        // Skill2
        skill_2 = new BufferedImage[8];

        skill_2[0] = sheetSkill2_1.cropImage(0,0,6*width,6*height);
        skill_2[1] = sheetSkill2_2.cropImage(0,0,6*width,6*height);
        skill_2[2] = sheetSkill2_3.cropImage(0,0,6*width,6*height);
        skill_2[3] = sheetSkill2_4.cropImage(0,0,6*width,6*height);
        skill_2[4] = sheetSkill2_5.cropImage(0,0,6*width,6*height);
        skill_2[5] = sheetSkill2_6.cropImage(0,0,6*width,6*height);
        skill_2[6] = sheetSkill2_7.cropImage(0,0,6*width,6*height);
        skill_2[7] = sheetSkill2_8.cropImage(0,0,6*width,6*height);

        // Skill3
        skill_3_down = new BufferedImage[5];
        skill_3_up = new BufferedImage[5];
        skill_3_right = new BufferedImage[5];
        skill_3_left = new BufferedImage[5];

        skill_3_down[0] = sheetSkill3Down1.cropImage(0,0,2*width,6*height);
        skill_3_down[1] = sheetSkill3Down2.cropImage(0,0,2*width,6*height);
        skill_3_down[2] = sheetSkill3Down3.cropImage(0,0,2*width,6*height);
        skill_3_down[3] = sheetSkill3Down4.cropImage(0,0,2*width,6*height);
        skill_3_down[4] = sheetSkill3Down5.cropImage(0,0,2*width,6*height);
        skill_3_up[0] = sheetSkill3Up1.cropImage(0,0,2*width,6*height);
        skill_3_up[1] = sheetSkill3Up2.cropImage(0,0,2*width,6*height);
        skill_3_up[2] = sheetSkill3Up3.cropImage(0,0,2*width,6*height);
        skill_3_up[3] = sheetSkill3Up4.cropImage(0,0,2*width,6*height);
        skill_3_up[4] = sheetSkill3Up5.cropImage(0,0,2*width,6*height);
        skill_3_right[0] = sheetSkill3Right1.cropImage(0,0,6*width,2*height);
        skill_3_right[1] = sheetSkill3Right2.cropImage(0,0,6*width,2*height);
        skill_3_right[2] = sheetSkill3Right3.cropImage(0,0,6*width,2*height);
        skill_3_right[3] = sheetSkill3Right4.cropImage(0,0,6*width,2*height);
        skill_3_right[4] = sheetSkill3Right5.cropImage(0,0,6*width,2*height);
        skill_3_left[0] = sheetSkill3Left1.cropImage(0,0,6*width,2*height);
        skill_3_left[1] = sheetSkill3Left2.cropImage(0,0,6*width,2*height);
        skill_3_left[2] = sheetSkill3Left3.cropImage(0,0,6*width,2*height);
        skill_3_left[3] = sheetSkill3Left4.cropImage(0,0,6*width,2*height);
        skill_3_left[4] = sheetSkill3Left5.cropImage(0,0,6*width,2*height);

        // Numbers
        number0 = sheetNumber_0.cropImage(0,0,width,height);
        number1 = sheetNumber_1.cropImage(0,0,width,height);
        number2 = sheetNumber_2.cropImage(0,0,width,height);
        number3 = sheetNumber_3.cropImage(0,0,width,height);
        number4 = sheetNumber_4.cropImage(0,0,width,height);
        number5 = sheetNumber_5.cropImage(0,0,width,height);
        number6 = sheetNumber_6.cropImage(0,0,width,height);
        number7 = sheetNumber_7.cropImage(0,0,width,height);
        number8 = sheetNumber_8.cropImage(0,0,width,height);
        number9 = sheetNumber_9.cropImage(0,0,width,height);

        // Tiles
        grass = sheetGrass.cropImage(0,0,width,height);
        grassFlowers1 = sheetGrassFlowers1.cropImage(0,0,width,height);
        grassFlowers2 = sheetGrassFlowers2.cropImage(0,0,width,height);

        grassNorthwest = sheetGrassNorthwest.cropImage(0,0,width,height);
        grassNorth = sheetGrassNorth.cropImage(0,0,width,height);
        grassNortheast = sheetGrassNortheast.cropImage(0,0,width,height);
        grassEast = sheetGrassEast.cropImage(0,0,width,height);
        grassSouthwest = sheetGrassSouthwest.cropImage(0,0,width,height);
        grassSouth = sheetGrassSouth.cropImage(0,0,width,height);
        grassSoutheast = sheetGrassSoutheast.cropImage(0,0,width,height);
        grassWest = sheetGrassWest.cropImage(0,0,width,height);

        grassBorderNorth = sheetGrassBorderNorth.cropImage(0,0,width,height);
        grassBorderWest = sheetGrassBorderWest.cropImage(0,0,width,height);
        grassBorderSouth = sheetGrassBorderSouth.cropImage(0,0,width,height);
        grassBorderEast = sheetGrassBorderEast.cropImage(0,0,width,height);
        grassBorderSoutheast = sheetGrassBorderSoutheast.cropImage(0,0,width,height);
        grassBorderNorthwest = sheetGrassBorderNorthwest.cropImage(0,0,width,height);
        grassBorderNortheast = sheetGrassBorderNortheast.cropImage(0,0,width,height);

        grassFull = sheetGrassFull.cropImage(0,0,width,height);

        water1 = sheetWater1.cropImage(0,0,width,height);
        water2= sheetWater2.cropImage(0,0,width,height);
        water3 = sheetWater3.cropImage(0,0,width,height);
        water4 = sheetWater4.cropImage(0,0,width,height);

        waterBorderNorthwest = sheetWaterBorderNorthwest.cropImage(0,0,width,height);
        waterBorderNorth = sheetWaterBorderNorth.cropImage(0,0,width,height);
        waterBorderNortheast = sheetWaterBorderNortheast.cropImage(0,0,width,height);
        waterBorderEast = sheetWaterBorderEast.cropImage(0,0,width,height);
        waterBorderSoutheast = sheetWaterBorderSoutheast.cropImage(0,0,width,height);
        waterBorderSouth = sheetWaterBorderSouth.cropImage(0,0,width,height);
        waterBorderSouthwest = sheetWaterBorderSouthwest.cropImage(0,0,width,height);
        waterBorderWest = sheetWaterBorderWest.cropImage(0,0,width,height);

        angleBorderWaterNorthwest = sheetAngleBorderWaterNorthwest.cropImage(0,0,width,height);
        angleBorderWaterNortheast = sheetAngleBorderWaterNortheast.cropImage(0,0,width,height);
        angleBorderWaterSoutheast = sheetAngleBorderWaterSoutheast.cropImage(0,0,width,height);
        angleBorderWaterSouthwest = sheetAngleBorderWaterSouthwest.cropImage(0,0,width,height);

        tree = sheetTree.cropImage(0,0,width,height);
        bush = sheetBush.cropImage(0,0,width,height);

        chestClosed = sheetChestClosed.cropImage(0,0,width,height);

        enter = sheetEnter.cropImage(0,0,width,height);

        // Items
        itemApple = sheetItemApple.cropImage(0,0,width,height);
        itemStrawberry = sheetItemStrawberry.cropImage(0,0,width,height);
        itemPotionBlue = sheetItemPotionBlue.cropImage(0,0,width,height);
        itemPotionWhite = sheetItemPotionWhite.cropImage(0,0,width,height);
        itemPotionRed = sheetItemPotionRed.cropImage(0,0,width,height);
        itemRingAttack = sheetItemRingAttack.cropImage(0,0,width,height);
        itemRingHealth = sheetItemRingHealth.cropImage(0,0,width,height);
        itemAmuletAttack = sheetItemAmuletAttack.cropImage(0,0,width,height);
        itemAmuletHealth = sheetItemAmuletHealth.cropImage(0,0,width,height);
        itemBoot1 = sheetItemBoot1.cropImage(0,0,width,height);
        itemBoot2 = sheetItemBoot2.cropImage(0,0,width,height);
        itemBoot3 = sheetItemBoot3.cropImage(0,0,width,height);
        itemGloves1 = sheetItemGloves1.cropImage(0,0,width,height);
        itemGloves2 = sheetItemGloves2.cropImage(0,0,width,height);
        itemGloves3 = sheetItemGloves3.cropImage(0,0,width,height);
        itemHead1 = sheetItemHead1.cropImage(0,0,width,height);
        itemHead2 = sheetItemHead2.cropImage(0,0,width,height);
        itemHead3 = sheetItemHead3.cropImage(0,0,width,height);
        itemShield1 = sheetItemShield1.cropImage(0,0,width,height);
        itemShield2 = sheetItemShield2.cropImage(0,0,width,height);
        itemTorso1 = sheetItemTorso1.cropImage(0,0,width,height);
        itemTorso2 = sheetItemTorso2.cropImage(0,0,width,height);
        itemTorso3 = sheetItemTorso3.cropImage(0,0,width,height);
        itemWeapon1 = sheetItemWeapon1.cropImage(0,0,width,height);
        itemWeapon2 = sheetItemWeapon2.cropImage(0,0,width,height);
        itemWeapon3 = sheetItemWeapon3.cropImage(0,0,width,height);
        itemKey = sheetItemKey.cropImage(0,0,width,height);
        itemPants1 = sheetItemPants1.cropImage(0,0,width,height);
        itemPants2 = sheetItemPants2.cropImage(0,0,width,height);
        itemPants3 = sheetItemPants3.cropImage(0,0,width,height);
        border = sheetItemBorder.cropImage(0,0,46,46);

        // Items description
        itemAppleDescription = sheetItemAppleDescription.cropImage(0,0,6*width,6*height);
        itemStrawberryDescription = sheetItemStrawberryDescription.cropImage(0,0,6*width,6*height);
        itemPotionBlueDescription = sheetItemPotionBlueDescription.cropImage(0,0,6*width,6*height);
        itemPotionWhiteDescription = sheetItemPotionWhiteDescription.cropImage(0,0,6*width,6*height);
        itemPotionRedDescription = sheetItemPotionRedDescription.cropImage(0,0,6*width,6*height);
        itemRingAttackDescription = sheetItemRingAttackDescription.cropImage(0,0,6*width,6*height);
        itemRingHealthDescription = sheetItemRingHealthDescription.cropImage(0,0,6*width,6*height);
        itemAmuletAttackDescription = sheetItemAmuletAttackDescription.cropImage(0,0,6*width,6*height);
        itemAmuletHealthDescription = sheetItemAmuletHealthDescription.cropImage(0,0,6*width,6*height);
        itemBoot1Description = sheetItemBoot1Description.cropImage(0,0,6*width,6*height);
        itemBoot2Description = sheetItemBoot2Description.cropImage(0,0,6*width,6*height);
        itemBoot3Description = sheetItemBoot3Description.cropImage(0,0,6*width,6*height);
        itemGloves1Description = sheetItemGloves1Description.cropImage(0,0,6*width,6*height);
        itemGloves2Description = sheetItemGloves2Description.cropImage(0,0,6*width,6*height);
        itemGloves3Description = sheetItemGloves3Description.cropImage(0,0,6*width,6*height);
        itemHead1Description = sheetItemHead1Description.cropImage(0,0,6*width,6*height);
        itemHead2Description = sheetItemHead2Description.cropImage(0,0,6*width,6*height);
        itemHead3Description = sheetItemHead3Description.cropImage(0,0,6*width,6*height);
        itemShield1Description = sheetItemShield1Description.cropImage(0,0,6*width,6*height);
        itemShield2Description = sheetItemShield2Description.cropImage(0,0,6*width,6*height);
        itemTorso1Description = sheetItemTorso1Description.cropImage(0,0,6*width,6*height);
        itemTorso2Description = sheetItemTorso2Description.cropImage(0,0,6*width,6*height);
        itemTorso3Description = sheetItemTorso3Description.cropImage(0,0,6*width,6*height);
        itemWeapon1Description = sheetItemWeapon1Description.cropImage(0,0,6*width,6*height);
        itemWeapon2Description = sheetItemWeapon2Description.cropImage(0,0,6*width,6*height);
        itemWeapon3Description = sheetItemWeapon3Description.cropImage(0,0,6*width,6*height);
        itemPants1Description = sheetItemPants1Description.cropImage(0,0,6*width,6*height);
        itemPants2Description = sheetItemPants2Description.cropImage(0,0,6*width,6*height);
        itemPants3Description = sheetItemPants3Description.cropImage(0,0,6*width,6*height);
        itemKeyDescription = sheetItemKeyDescription.cropImage(0,0,6*width,6*height);

        // Properties
        ownHealth = sheetOwnHealth.cropImage(0,0,widthProperties,heightProperties);
        ownMana = sheetOwnMana.cropImage(0,0,widthProperties,heightProperties);
        owmPoisoning = sheetOwnPoisoning.cropImage(0,0,widthProperties,heightProperties);

        // Items active
        item0Active = sheetItem0Active.cropImage(0,0,widthItemActive,heightItemActive);
        item1Active = sheetItem1Active.cropImage(0,0,widthItemActive,heightItemActive);
        item2Active = sheetItem2Active.cropImage(0,0,widthItemActive,heightItemActive);
        item3Active = sheetItem3Active.cropImage(0,0,widthItemActive,heightItemActive);
        item4Active = sheetItem4Active.cropImage(0,0,widthItemActive,heightItemActive);
        item5Active = sheetItem5Active.cropImage(0,0,widthItemActive,heightItemActive);
        item6Active = sheetItem6Active.cropImage(0,0,widthItemActive,heightItemActive);
        item7Active = sheetItem7Active.cropImage(0,0,widthItemActive,heightItemActive);
        item8Active = sheetItem8Active.cropImage(0,0,widthItemActive,heightItemActive);
        item9Active = sheetItem9Active.cropImage(0,0,widthItemActive,heightItemActive);
    }
}