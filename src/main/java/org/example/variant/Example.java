package org.example.variant;

import java.time.LocalTime;
import java.util.Random;

public class Example {
    private int value;
    private int sum;
    private Random random;

    public int getValue() {
        return value;
    }

    public Example() {
        this.random = new Random();
    }

    public Example(Random random) {
        this.random = random;
    }

    //Pure function, always same return value for same input
    public static int add(int a, int b) {
        return a + b;
    }

    //---
    //Return value depends on previous calls.
    public int addAndReturn(int value) {
        this.value += value;
        return this.value;
    }

    //---
    //Update internal state of object but don't return anything
    public void add(int value) {
        sum += value;
    }

    //Needed for testing add method above.
    public int sum() {
        return this.sum;
    }

    //---
    //Hard to test without custom Random object. Value from nextInt must be predictable for the test
    public int value() {
        return random.nextInt();
    }

    //---
    //Introduce parameter with time to check against for testability
    public String sayHello(LocalTime time) {
        if (time.isBefore(LocalTime.of(12, 0)))
            return "Good morning";
        return "Good afternoon";
    }

}
