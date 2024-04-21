package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static com.example.constants.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        Assert.assertEquals(HUNTER_FOOD, feline.eatMeat());
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals(FAMILY, feline.getFamily());
        Mockito.verify(feline, Mockito.times(1)).getFamily();
    }

    @Test
    public void getKittensTest() {
        Assert.assertEquals(KITTENS, feline.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getIntKittensTest() {
        int actual = feline.getKittens(FELINE_KITTENS);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        Assert.assertEquals(FELINE_KITTENS, actual);
    }
}
