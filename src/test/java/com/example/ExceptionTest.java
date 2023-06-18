package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExceptionTest {

    @Test
    public void checkGetFoodExceptionThrown() {
        Feline feline = new Feline();
        boolean exceptionThrown = false;

        try {
            Lion lion = new Lion("Лев", feline);
            lion.getFood();
        } catch (Exception exception) {
            System.out.println("Текст исключения: " + exception.getMessage());
            assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}
