package ru.mail.perovd.sprint1;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FinalTask2Test {
    @Test
    public void test1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 2);
        map.put("2", 7);
        map.put("3", 1);
        map.put(".", 6);
        Assert.assertEquals(2, FinalTask2.score(map, 3));
    }
    @Test
    public void test2() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 10);
        map.put("9", 6);
        Assert.assertEquals(1, FinalTask2.score(map, 4));
    }
}