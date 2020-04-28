package algorithm.sorting;

import algorithm.generalFuntion.GeneralFunction;

/**
 * @author : Nguyen Trong TRUNG
 *
 * Strategy : Brute-Force
 * Best case :
 * Avarage case :
 * Worst case : n(n-1)/2 in O(n^2)
 */
public class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort(int[] inputArray) {
        for(int i=0;i<inputArray.length-1;i++)
            for (int j=0;j<inputArray.length-1-i;j++)
                if (inputArray[j+1]<inputArray[j])
                    GeneralFunction.swap(inputArray,j,j+1);
    }
}
