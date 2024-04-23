package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private Feline feline;

    @Before
    public void init() {
        feline = Mockito.mock(Feline.class);
    }

    private final String sex;
    private final boolean actual;

    public LionParameterizedTest(String sex, boolean actual) {
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
}
