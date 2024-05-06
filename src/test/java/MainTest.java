package test.java;

import org.junit.Assert;
import org.junit.Test;
import main.java.Main;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {
    // Тесты одноименных функций
    @Test
    public void min() {
        //создаем тестовые данные
        int[] numbers = {1, 2, 3, 4, 1123902};

        //запускаем тест, в случае если результат будет не равен 1, то
        //тест будет провален, о результатах теста читаем в консоли
        Assert.assertEquals(2, Main._min(numbers));
    }

    @Test
    public void max() {
        int[] numbers = {1, 2, 3, 4, 1123902};

        Assert.assertEquals(1123902, Main._max(numbers));
    }

    @Test
    public void sum() {
        int[] numbers = {1, 2, 3, 4, 1123902};

        Assert.assertEquals(1123912, Main._sum(numbers));
    }

    @Test
    public void mul() {
        int[] numbers = {1, 2, 3, 4, 5};

        Assert.assertEquals(120, Main._mult(numbers));
    }

    // Тест на скорость
    @Test
    public void speed_test() {
        int[] numbers = new int[100000000];

        Arrays.fill(numbers, 1);
        long start = System.currentTimeMillis();
        Main._min(numbers);
        Main._max(numbers);
        Main._mult(numbers);
        Main._sum(numbers);

        long time = (System.currentTimeMillis() - start);
        assertTrue(time <= 500);
    }

    // Тест на то, что если в массиве 0, то результат умножения 0
    @Test
    public void zero_mult() {
        int[] numbers = {23432, -323423, 234234, 0};

        assertEquals(0, Main._mult(numbers));
    }
}