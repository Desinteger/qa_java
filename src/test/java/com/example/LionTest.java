package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runners.Parameterized;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Parameterized.Parameters
    public static Collection<Object[]> sex() {
        return Arrays.asList(new Object[][] {
                {"Самец"},
                {"Самка"}
        });
    }

    @Parameterized.Parameter
    public String sex;

    @Mock
    Feline feline;

    @Test
    public void checkLionConstructor() throws Exception {
        Lion lionMale = new Lion("Самец", feline);
        Lion lionFemale = new Lion("Самка", feline);
        assertTrue(lionMale.doesHaveMane());
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test
    public void checkGetKittensReturnsValue() throws Exception {
        when(feline.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самка", feline);
        int kittensCount = lion.getKittens();
        assertEquals(2, kittensCount);
    }

    @Test
    public void checkDoesHaveManetDeterminesLionSex() throws Exception {
        try {
            Lion lionMale = new Lion("Самец", feline);
            assertTrue(lionMale.doesHaveMane());
            Lion lionFemale = new Lion("Самка", feline);
            assertFalse(lionFemale.doesHaveMane());
        } catch (Exception exception) {
             fail("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    @Test
    public void checkGetFoodReturnsLionFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);
        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

}
