package testing.searching;

import algorithm.sorting.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author : Nguyen Trong TRUNG
 */
class InsertionSortTest {
    @Test
    public void checkTest1() throws Exception{
        int[] arrExpected = {
                8,9,10,11,12,14,15,16
        };
        int[] arrActual={
                10,16,8,9,11,15,12,14
        };
        SortingAlgorithm searching = new InsertionSort();
        searching.sort(arrActual);
        Assertions.assertArrayEquals(arrExpected,arrActual);
    }
}