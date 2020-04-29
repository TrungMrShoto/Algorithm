package algorithm.sorting;

import algorithm.generalFuntion.GeneralFunction;

/**
 * @author : Nguyen Trong TRUNG
 *
 * Strategy : Brute Force
 * Basic operation: comparision
 * n is the number of elements in input array
 * Best Case :
 * Avarage Case :
 * WorstCase : n(n-1)/2 in O(n^2)
 * Stable : No
 * In-place : Yes
 */
public class SelectionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] inputArray) {
        int min;
        for(int i=0;i<inputArray.length-1;i++)
        {
            min = i;
            for (int j=i+1;j<inputArray.length;j++)
                if (inputArray[j]<inputArray[min])
                    min=j;
            GeneralFunction.swap(inputArray,i,min);
        }
    }
}
