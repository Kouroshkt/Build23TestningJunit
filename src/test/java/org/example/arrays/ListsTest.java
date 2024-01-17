package org.example.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListsTest {
  Lists lists=new Lists();
  List<Integer> myListTest=Arrays.asList(1000,0,2,3,-4,-5,6,100);
  @Test
  @DisplayName("Given positiv numbr when has negativ number in list")
  void givenPositivNumberWhenHasNegativNumberInList(){
      List<Integer> expectedList=Arrays.asList(1000,0,2,3,6,100);
      assertThat(myListTest);
      assertEquals(expectedList.stream().sorted().toList()
              ,lists.removeNegativeNumbers(myListTest).stream().sorted().toList());

  }

  @Test
  @DisplayName("test name")
  void testName() {
    
  }

  @Test
    @DisplayName("Should multiply odd number when vi have a list Number")
    void ShouldMultiplyOddNumberWhenViHaveAListNumber() {
      List<Integer> expectedList=Arrays.asList(0,2,6,-4,-10,6,100);
      assertEquals(expectedList,lists.multiplyOddNumbersBy2(myListTest));
    }

    @Test
    @DisplayName("Get a List when given 3 number")
    void GetAListWhenGiven3Number() {
    List<Integer> expectedList=Arrays.asList(0,10,100);
    assertEquals(expectedList,lists.createListWith3Numbers(0,10,100));
    }

}