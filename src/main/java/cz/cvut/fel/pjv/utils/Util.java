package cz.cvut.fel.pjv.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util {

    /**
     * Loads a file to a string.
     *
     * @param path the path to the file.
     * @return a string made up of read data from a file.
     */
    public static String loadFileAsString(String path) {

        // Reading a text file with information about the world
        StringBuilder builder = new StringBuilder();
        InputStream in = Util.class.getResourceAsStream(path);

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null)
                builder.append(line).append('\n');
            br.close();
            in.close();
        } catch(IOException e) { e.printStackTrace(); }
        return builder.toString();
    }

    /**
     * Converts a string to a number.
     *
     * @param number a string containing a number.
     * @return the number obtained by converting the string.
     */
    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.getLocalizedMessage();
            return 4; // Return the number of the empty tile to continue processing
        }
    }
}
