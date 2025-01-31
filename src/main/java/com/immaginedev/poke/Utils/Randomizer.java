package com.immaginedev.poke.Utils;

import java.util.Random;

import com.immaginedev.poke.API.Exceptions.RandomizerException;

public class Randomizer {
    
    private static Random random = new Random();

    public static int getRandomNumber(int min, int max) {
        if(min < 0 || max < 0)
            throw new RandomizerException("Thresholds can't be negative");
        
        return random.nextInt((max - min) + 1) + min;
    }

}