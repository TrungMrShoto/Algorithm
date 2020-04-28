package testing.sorting;

import algorithm.sorting.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author : Nguyen Trong TRUNG
 */
class SortingTest {
    private final int[] arrExpected = {0,0,1,2,4,6,7,8,8,9,9,11};
    private final int[] arrActual = {8,8,9,2,1,0,0,7,6,11,4,9};

    @Test
    public void checkInsertionSort(){
        int[] arrActual = Arrays.copyOf(this.arrActual,this.arrActual.length);
        SortingAlgorithm searching = new InsertionSort();
        searching.sort(arrActual);
        Assertions.assertArrayEquals(this.arrExpected,arrActual);
    }

    @Test
    public void checkQuickSort(){
        int[] arrActual = Arrays.copyOf(this.arrActual,this.arrActual.length);
        SortingAlgorithm searching = new QuickSort();
        searching.sort(arrActual);
        Assertions.assertArrayEquals(this.arrExpected,arrActual);
    }

    @Test
    public void checkMergeSort(){
        int[] arrActual = Arrays.copyOf(this.arrActual,this.arrActual.length);
        SortingAlgorithm searching = new MergeSort();
        searching.sort(arrActual);
        Assertions.assertArrayEquals(this.arrExpected,arrActual);
    }

    @Test
    public void checkBubbleSort(){
        int[] arrActual = Arrays.copyOf(this.arrActual,this.arrActual.length);
        SortingAlgorithm searching = new BubbleSort();
        searching.sort(arrActual);
        Assertions.assertArrayEquals(this.arrExpected,arrActual);
    }

    @Test
    public void checkSelectionSort(){
        int[] arrActual = Arrays.copyOf(this.arrActual,this.arrActual.length);
        SortingAlgorithm searching = new SelectionSort();
        searching.sort(arrActual);
        Assertions.assertArrayEquals(this.arrExpected,arrActual);
    }
}