package cz.cvut.fel.pjv.utils;

import cz.cvut.fel.pjv.entities.dynamics.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class Save {

    /**
     * Writes data to a file txt.
     *
     * @param player class object Player.
     */
    public static void writeFileInventoryAndCharacteristics(Player player) {

        // The data in the file is completely updated.
        try (FileWriter writer = new FileWriter(getFullPath(), false)) {

            // Write characteristics.
            writer.write("Health:");
            writer.append('\n');
            writer.write(player.getHealth() + "/" + player.getMaxHealth());
            writer.append('\n');

            writer.write("Mana:");
            writer.append('\n');
            writer.write(String.valueOf(player.getMana()));
            writer.append('\n');

            writer.write("Poisoning:");
            writer.append('\n');
            writer.write(String.valueOf(player.getPoisoning()));
            writer.append('\n');

            writer.write("Attack power:");
            writer.append('\n');
            writer.write(String.valueOf(player.getPowerAttack()));
            writer.append('\n');

            writer.write("Inventory active things:");
            writer.append('\n');

            if (player.getInventory().activeHead != null) {
                writer.write(String.valueOf(player.getInventory().activeHead.getId()));
                writer.append('\n');
            }

            if (player.getInventory().activeTorso != null) {
                writer.write(String.valueOf(player.getInventory().activeTorso.getId()));
                writer.append('\n');
            }

            if (player.getInventory().activePants != null) {
                writer.write(String.valueOf(player.getInventory().activePants.getId()));
                writer.append('\n');
            }

            if (player.getInventory().activeBoots != null) {
                writer.write(String.valueOf(player.getInventory().activeBoots.getId()));
                writer.append('\n');
            }

            if (player.getInventory().activeGloves != null) {
                writer.write(String.valueOf(player.getInventory().activeGloves.getId()));
                writer.append('\n');
            }

            if (player.getInventory().activeWeapon != null) {
                writer.write(String.valueOf(player.getInventory().activeWeapon.getId()));
                writer.append('\n');
            }

            if (player.getInventory().activeShield != null) {
                writer.write(String.valueOf(player.getInventory().activeShield.getId()));
                writer.append('\n');
            }

            if (player.getInventory().activeAmulet != null) {
                writer.write(String.valueOf(player.getInventory().activeAmulet.getId()));
                writer.append('\n');
            }

            if (player.getInventory().activeRing != null) {
                writer.write(String.valueOf(player.getInventory().activeRing.getId()));
                writer.append('\n');
            }

            writer.flush(); // flush the stream.
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * File cleanup.
     */
    public static void clearFileAfterGameOver() {
        try (FileWriter writer = new FileWriter(getFullPath(), false)){
            writer.write("");
            writer.flush();
        } catch (Exception e) { System.err.println("Error in file cleaning: " + e.getMessage());}
    }

    /**
     * Builds the path to a text file.
     *
     * @return path to file.
     */
    public static String getFullPath() {
        final URL url = Util.class.getResource("/"); // Getting the project path address.
        String pathUrl = null; // Removing part of a line that refers to target.
        if (url != null) pathUrl = url.getPath().replace("target/classes/", "");
        pathUrl += "src/main/resources/files/inventory.txt"; // Getting the full path of a text file.
        return pathUrl;
    }
}
