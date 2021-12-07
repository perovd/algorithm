package ru.mail.perovd.sprint1;


import org.junit.Assert;
import org.junit.Test;

public class FinalTask2Test {
    @Test
    public void test1() {
        int[] input = new int[]{0,2,7,1,0,0,0,0,0,0};
        Assert.assertEquals(2, FinalTask2.score(input, 3));
    }
    @Test
    public void test2() {
        int[] input = new int[]{0,10,0,0,0,0,0,0,0,6};
        Assert.assertEquals(1, FinalTask2.score(input, 4));
    }
}