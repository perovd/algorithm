package ru.mail.perovd.sprint1;


import org.junit.Assert;
import org.junit.Test;

public class FinalTask1Test {
    @Test
    public void test1() {
        int[] distance = FinalTask1.dist(new long[]{0L, 1L, 4L, 9L, 0L});
        Assert.assertArrayEquals(new int[]{0, 1, 2, 1, 0}, distance);
    }

    @Test
    public void test2() {
        int[] distance = FinalTask1.dist(new long[]{0L, 7L, 9L, 4L, 8L, 20L});
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, distance);
    }

    @Test
    public void test3() {
        int[] distance = FinalTask1.dist(new long[]{0L, 7L, 0L, 4L, 8L, 20L});
        Assert.assertArrayEquals(new int[]{0, 1, 0, 1, 2, 3}, distance);
    }

    @Test
    public void test4() {
        int[] distance = FinalTask1.dist(new long[]{2L, 7L, 3L, 4L, 8L, 0L});
        Assert.assertArrayEquals(new int[]{5, 4, 3, 2, 1, 0}, distance);
    }

    @Test
    public void test5() {
        int[] distance = FinalTask1.dist(new long[]{2L, 7L, 0L, 4L, 8L, 0L});
        Assert.assertArrayEquals(new int[]{2, 1, 0, 1, 1, 0}, distance);
    }
    @Test
    public void test6() {
        int[] distance = FinalTask1.dist(new long[]{0L, 0L, 0L, 0L, 0L, 0L});
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0}, distance);
    }
}