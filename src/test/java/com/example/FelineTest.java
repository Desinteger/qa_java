package com.example;

import org.junit.Test;
import org.junit.Before;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {

    Feline feline;

    @Before
    public void setup() {
        feline = new Feline();
    }

    @Test
    public void checkGetFoodReturnsFelineFood() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void checkGetFamilyReturnsFeline() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void checkGetKittensReturnsOne() {
        int kittensCount = feline.getKittens();
        assertEquals(1, kittensCount);
    }

    @Test
    public void checkGetKittensWithCountReturnsValue() {
        int kittensCount = feline.getKittens(5);
        assertEquals(5, kittensCount);
    }
}