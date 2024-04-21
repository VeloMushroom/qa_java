package com.example;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import static com.example.constants.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline;

    @Test
    public void getSoundCatTest(){
        Cat cat = new Cat(feline);
        Assert.assertEquals(MAY, cat.getSound());
    }

    @Test
    public void getFoodCatTest() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(HUNTER_FOOD);
        Assert.assertEquals(cat.getFood(), HUNTER_FOOD);
    }

}
