package cz.cvut.fel.pjv.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    @Order(1)
    public void parseInt_null_4_and_NumberFormatException() {
        System.out.println("Running parseInt_null_4");
        // Arrange
        Util util = new Util();
        String number = null;
        int extended = 4;

        // Act
        int result = util.parseInt(number);

        // Assert
        Assertions.assertEquals(extended, result);
    }

    @Test
    @Order(2)
    public void parseInt_StringNumber_Number() {
        System.out.println("Running parseInt_StringNumber_Number");
        // Arrange
        Util util = new Util();
        String number = "45";
        int extended = 45;

        // Act
        int result = util.parseInt(number);

        // Assert
        Assertions.assertEquals(extended, result);
    }
}