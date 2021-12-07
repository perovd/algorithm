package ru.mail.perovd.sprint1;


import org.junit.Assert;
import org.junit.Test;

public class FinalTask1Test {
    @Test
    public void test1() {
        int[] distance = FinalTask1.dist(new int[]{0, 1, 4, 9, 0});
        Assert.assertArrayEquals(new int[]{0, 1, 2, 1, 0}, distance);
    }

    @Test
    public void test2() {
        int[] distance = FinalTask1.dist(new int[]{0, 7, 9, 4, 8, 20});
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, distance);
    }

    @Test
    public void test3() {
        int[] distance = FinalTask1.dist(new int[]{0, 7, 0, 4, 8, 20});
        Assert.assertArrayEquals(new int[]{0, 1, 0, 1, 2, 3}, distance);
    }

    @Test
    public void test4() {
        int[] distance = FinalTask1.dist(new int[]{2, 7, 3, 4, 8, 0});
        Assert.assertArrayEquals(new int[]{5, 4, 3, 2, 1, 0}, distance);
    }

    @Test
    public void test5() {
        int[] distance = FinalTask1.dist(new int[]{2, 7, 0, 4, 8, 0});
        Assert.assertArrayEquals(new int[]{2, 1, 0, 1, 1, 0}, distance);
    }
    @Test
    public void test6() {
        int[] distance = FinalTask1.dist(new int[]{0, 0, 0, 0, 0, 0});
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0}, distance);
    }
}