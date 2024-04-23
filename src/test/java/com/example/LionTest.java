package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.example.constants.Constants.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(LION_KITTENS);
        Assert.assertEquals(LION_KITTENS, lion.getKittens());
    }

    @Test
    public void getFoodLionTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(HUNTER_FOOD);
        Assert.assertEquals(HUNTER_FOOD, lion.getFood());
    }

    @Test
    public void doesHaveManeFaledTest(){
        try {
            new Lion("Другое", feline);
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
        }
    }

}
