package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void checkGetSoundReturnsMeowString() {
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
        }

    @Test
    public void checkGetFoodReturnsExpectedFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> food = cat.getFood();
        assertEquals(expectedFood, food);
    }
    }
