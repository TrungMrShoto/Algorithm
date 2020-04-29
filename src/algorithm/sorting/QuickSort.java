package algorithm.sorting;

import algorithm.generalFuntion.GeneralFunction;

/**
 *@author : Nguyen Trong TRUNG
 *
 * Strategy : Divide-and-Conquer
 * Basic operation : comparision
 * Best case : nlog2 n + n - 1 in O(nlog2 n)
 * Avarage case : approx 2nln n approx 1.39nlog2 n in O(nlog2 n)
 * Worst case : (n+1)(n+2)/2 - 3 in O(n^2)
 * Stable : No
 * In-place : Yes, O(log2 n) of stack space
 */
public class QuickSort implements SortingAlgorithm {

    @Override
    public void sort(int[] inputArray) {
        quickSort(inputArray,0,inputArray.length-1);
    }

    private void quickSort(int[] inputArray, int left, int right) {
        if (left<right)
        {
            int pivotPosition = partition(inputArray,left,right);
            quickSort(inputArray,left,pivotPosition-1);
            quickSort(inputArray,pivotPosition+1,right);
        }
    }

    /**
     * Partition a subarray by Hoare's algorithm, using the first element as a pivot
     */
    private int partition(int[] inputArray, int left, int right) {
        int length= inputArray.length;
        int pivot = inputArray[left];
        int i = left;
        int j = right+1;
        do{
            do{i=i+1;} while(inputArray[i]<pivot);           //find the element larger than the pivot
            do{j=j-1;} while(inputArray[j]>pivot);           //find the element smaller than the pivot
            if (i<j)
                GeneralFunction.swap(inputArray,i,j);
        }while(i<=j);
        GeneralFunction.swap(inputArray,left,j);
        return j;
    }
}
