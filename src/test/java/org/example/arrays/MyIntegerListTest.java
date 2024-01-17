package org.example.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyIntegerListTest {
    Integer[] testArray= {-1,0,1,10};
    MyIntegerList myIntegerList= new MyIntegerList(testArray);

    @Test
    void getListAsAnArray() {
        var result=myIntegerList.getListAsAnArray();
        assertTrue(Arrays.equals(testArray,result));

    }

    @Test
    void addANumberWhenGivenANumber() {
    }

    @Test
    void remove() {
    }

    @Test
    void get() {
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }
}