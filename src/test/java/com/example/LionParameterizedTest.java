package com.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.runners.Parameterized;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

    @RunWith(Parameterized.class)
    public class LionParameterizedTest {

        @Parameterized.Parameters(name = "Пол льва. Тестовые данные: {0}")
        public static Collection<String> sex() {
            return Arrays.asList("Самец", "Самка");
        }

        @Parameterized.Parameter
        public String sex;

        @Before
        public void setUp() {
            MockitoAnnotations.initMocks(this);
        }

        @Mock
        Feline feline;

        @Test
        public void checkLionConstructor() throws Exception {
            Lion lion = new Lion(sex, feline);
            assertEquals(sex.equals("Самец"), lion.doesHaveMane());
        }

        @Test
        public void checkDoesHaveManeDeterminesLionSex() throws Exception {
            try {
                Lion lion = new Lion(sex, feline);
                assertEquals(sex.equals("Самец"), lion.doesHaveMane());
            } catch (Exception exception) {
                fail("Используйте допустимые значения пола животного - самец или самка");
            }
        }

        @Test
        public void checkGetFoodReturnsLionFood() throws Exception {
            when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Lion lion = new Lion(sex, feline);
            List<String> food = lion.getFood();
            assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        }
    }

