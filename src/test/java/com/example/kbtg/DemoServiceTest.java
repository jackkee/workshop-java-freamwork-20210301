package com.example.kbtg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DemoServiceTest {
    @Test
    public void random_5() {
        DemoService demoService = new DemoService();
        demoService.setRandom(new Random5());
        String actualResult =demoService.generateData("TEST");
        Assertions.assertEquals("TEST5", actualResult);
    }
    @Test
    public void random_invalid() {
        DemoService demoService = new DemoService();
        demoService.setRandom(new RandomInvalid());
        Assertions.assertThrows(RuntimeException.class,()->demoService.generateData("TEST"));
    }

}

class Random5 extends Random {
    @Override
    public int nextInt(int bound) {
        return 5;
    }
}
class RandomInvalid extends Random {
    @Override
    public int nextInt(int bound) {
        return Integer.MAX_VALUE;
    }
}