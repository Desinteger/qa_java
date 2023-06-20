package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void checkGetKittensReturnsValue() throws Exception {
        when(feline.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самка", feline);
        int kittensCount = lion.getKittens();
        assertEquals(2, kittensCount);
    }
}
