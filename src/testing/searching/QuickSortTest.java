package testing.searching;

import algorithm.sorting.QuickSort;
import algorithm.sorting.SortingAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author : Nguyen Trong TRUNG
 */
public class QuickSortTest {
    @Test
    public void checkTest() throws Exception{
        int[] arrExpected = {
                0,0,1,2,4,6,7,8,8,9,9,11
        };
        int[] arrActual={
                8,8,9,2,1,0,0,7,6,11,4,9
        };
        SortingAlgorithm searching = new QuickSort();
        searching.sort(arrActual);
        Assertions.assertArrayEquals(arrExpected,arrActual);
    }
}