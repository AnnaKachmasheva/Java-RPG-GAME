package cz.cvut.fel.pjv.utils;

import cz.cvut.fel.pjv.entities.dynamics.Player;
import cz.cvut.fel.pjv.inventory.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoadInventory {

    /**
     * Loading characteristics of a player and his equipment.
     *
     * @param player class object Player.
     */
    public static void loadInventoryStart(Player player) {

        InputStream in = Util.class.getResourceAsStream("/files/inventory.txt");
        int count = 1; // Auxiliary variable.
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null || count < 20) {
                count++;
                if (count == 2) {
                    if (line != null) {
                        String[] str = line.split("/");
                        player.setHealth(Integer.parseInt(str[0]));
                        player.setMaxHealth(Integer.parseInt(str[1]));
                    }
                } else if (count == 4) {
                    if (line != null) player.setMana(Integer.parseInt(line));
                } else if (count == 6) {
                    if (line != null) player.setPoisoning(Integer.parseInt(line));
                } else if (count == 8) {
                    if (line != null) player.setPowerAttack(Integer.parseInt(line));
                } else if (count > 9 && line != null) {
                    int id = Integer.parseInt(line);
                    if (id == 5) player.getInventory().setActiveRing(Item.ringAttackItem);
                    if (id == 6) player.getInventory().setActiveRing(Item.ringHealthItem);
                    if (id == 7) player.getInventory().setActiveAmulet(Item.amuletAttackItem);
                    if (id == 8) player.getInventory().setActiveAmulet(Item.amuletHealthItem);
                    if (id == 9) player.getInventory().setActiveBoots(Item.boot1Item);
                    if (id == 10) player.getInventory().setActiveBoots(Item.boot2Item);
                    if (id == 11) player.getInventory().setActiveBoots(Item.boot3Item);
                    if (id == 12) player.getInventory().setActiveGloves(Item.gloves1Item);
                    if (id == 13) player.getInventory().setActiveGloves(Item.gloves2Item);
                    if (id == 14) player.getInventory().setActiveGloves(Item.gloves3Item);
                    if (id == 15) player.getInventory().setActiveHead(Item.head1Item);
                    if (id == 16) player.getInventory().setActiveHead(Item.head2Item);
                    if (id == 17) player.getInventory().setActiveHead(Item.head3Item);
                    if (id == 18) player.getInventory().setActiveShield(Item.shield1Item);
                    if (id == 19) player.getInventory().setActiveShield(Item.shield2Item);
                    if (id == 20) player.getInventory().setActiveTorso(Item.torso1Item);
                    if (id == 21) player.getInventory().setActiveTorso(Item.torso2Item);
                    if (id == 22) player.getInventory().setActiveTorso(Item.torso3Item);
                    if (id == 23) player.getInventory().setActiveWeapon(Item.weapon1Item);
                    if (id == 24) player.getInventory().setActiveWeapon(Item.weapon2Item);
                    if (id == 25) player.getInventory().setActiveWeapon(Item.weapon3Item);
                    if (id == 27) player.getInventory().setActivePants(Item.pants1Item);
                    if (id == 28) player.getInventory().setActivePants(Item.pants2Item);
                    if (id == 29) player.getInventory().setActivePants(Item.pants3Item);
                }
            }
            br.close();
            in.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
