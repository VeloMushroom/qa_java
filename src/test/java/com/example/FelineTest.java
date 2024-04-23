package com.example;

import org.junit.Assert;
import org.junit.Test;
import static com.example.constants.Constants.*;

public class FelineTest {

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals(HUNTER_FOOD, feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals(FAMILY, feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        Assert.assertEquals(KITTENS, feline.getKittens());
    }

    @Test
    public void getIntKittensTest() {
        Feline feline = new Feline();
        int actual = feline.getKittens(FELINE_KITTENS);
        Assert.assertEquals(FELINE_KITTENS, actual);
    }
}
