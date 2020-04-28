package algorithm.sorting;

/**
 * @author : Nguyen Trong TRUNG
 *
 * Strategy : Decrease-and-Conquer (decrease-by-one)
 * Best Case : n - 1 in O(n)
 * Avarage Case : approx n^/4 in O(n^2)
 * Worst Case : n(n-1)/2 in O(n^2)
 */
public class InsertionSort implements SortingAlgorithm {

    @Override
    public void sort(int[] inputArray) {
        nonRecursiveSort(inputArray);
        //recursiveSort(inputArray,inputArray.length-1);
    }
    private void recursiveSort(int[] inputArray,int n)
    {
        if (n<=0) return;
        recursiveSort(inputArray,n-1);
        int insertKey = inputArray[n];
        int i = n-1;
        while(i>=0 && inputArray[i]>insertKey)
        {
            inputArray[i+1] = inputArray[i];
            i--;
        }
        inputArray[i+1]=insertKey;
    }

    private void nonRecursiveSort(int[] inputArray)
    {
        int j,insertKey;
        for(int i = 1;i<inputArray.length;i++) {
            insertKey = inputArray[i];
            j = i - 1;
            while (j >= 0 && inputArray[j] > insertKey) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = insertKey;
        }
    }
}
