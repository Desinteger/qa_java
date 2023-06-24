package com.example;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class ExceptionTest {

    @Test
    public void checkGetFoodExceptionThrown() {
        Feline feline = new Feline();

        Throwable thrownException = catchThrowable(() -> {
            Lion lion = new Lion("Лев", feline);
            lion.getFood();
        });

        assertThat(thrownException)
                .isInstanceOf(Exception.class)
                .hasMessage("Используйте допустимые значения пола животного - самец или самка");
        System.out.println(thrownException);
    }
}

