package com.lucky.game2048.util;

import java.util.Random;

/**
 * This class has some useful utilities for working with numbers.
 */
public class NumberUtil {

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + min);
    }

    public static int generateRandomTileNumber() {
        return generateRandomNumber(1, 2) == 1 ? 2 : 4;
    }

}
