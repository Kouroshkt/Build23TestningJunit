package org.example.variant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {
    Example example = new Example();

    @Test
    @DisplayName("Two add two should four")
    void twoAddTwoShouldFour() {
        assertEquals(5, example.add(3, 2));
    }

    @Test
    @DisplayName("Should add value with previous values")
    void shouldAddValueWithPreviousValues() {
        int pValue = example.getValue();
        int value = 28;
        int exepted = pValue + value;
        assertEquals(exepted, example.addAndReturn(value));
    }

    @Test
    @DisplayName("Should add sum and value")
    void shouldAddSumAndValue() {
        example.add(2);
        example.add(-5);
        assertEquals(-3,example.sum());
    }

    @Test
    @DisplayName("Should given a random for value")
    void shouldGivenARandomForValue() {
        Random random= new Random(1000);
        Example testExample= new Example(random);
        assertEquals(-1244746321,testExample.value());
    }

    @Test
    @DisplayName("Should say goodmornig time before 12")
    void shouldSayGoodmornigTimeBefore12() {
        LocalTime before= LocalTime.of(11,00);
        assertEquals("Good morning",example.sayHello(before));
    }

    @Test
    @DisplayName("Shold say Good afternoon with time after 12")
    void sholdSayGoodAfternoonWithTimeAfter12() {
        LocalTime after= LocalTime.of(12,20);
        assertEquals("Good afternoon",example.sayHello(after));
    }


}