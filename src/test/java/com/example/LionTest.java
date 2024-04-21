package com.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import static com.example.constants.Constants.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    Feline feline;

    @Before
    public void init() {
        feline = Mockito.mock(Feline.class);
    }

    private final String sex;
    private final boolean actual;

    public LionTest(String sex, boolean actual) {
        this.sex = sex;
        this.actual = actual;
    }

    @Parameterized.Parameters
    public static Object[][] sexData() {
        return new Object[][] {
                {"Самка", false},
                {"Самец", true},
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(actual, lion.doesHaveMane());
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(LION_KITTENS);
        Assert.assertEquals(LION_KITTENS, lion.getKittens());
    }

    @Test
    public void getFoodLionTest() throws Exception {
        Lion lion = new Lion(sex, feline);
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
