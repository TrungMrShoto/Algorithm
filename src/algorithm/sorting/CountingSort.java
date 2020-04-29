package algorithm.sorting;

import java.util.Arrays;

/**
 * @author : Nguyen Trong TRUNG
 *
 * Strategy :
 */
public class CountingSort implements SortingAlgorithm{

    @Override
    public void sort(int[] inputArray) {
        nonComparisionType(inputArray,inputArray.length);
    }

    /**
     * Best case : -
     * Avarage case :
     * Worst case : n + k in O(n+k) where n is the number of elements in input array,
     *                                    k is the range of the input
     * Stable : Yes
     * In-place : Yes
    */
    private void nonComparisionType(int[] inputArray, int n)
    {
        int min = Arrays.stream(inputArray).min().getAsInt();
        int max = Arrays.stream(inputArray).max().getAsInt();
        int range = max-min+1;

        //create a count array to store count
        int[] count = new int[range];

        //store count of each integer
        for(int i=0;i<n;i++)
        {
            count[inputArray[i]-min]++;
        }

        // Change count[i] so that count[i] now contains actual
        // position of this integer in outputArray
        for(int i=1; i<count.length; i++)
            count[i]+=count[i-1];

        //build outputArray
        int[] outputArray = new int[n];
        for(int i=n-1; i>=0; i--)
        {
            outputArray[count[inputArray[i]-min]-1]=inputArray[i];
            count[inputArray[i]-min]--;
        }

        //copy the outputArray to inputArray, which contains sorted integer
        System.arraycopy(outputArray, 0, inputArray, 0, n);
    }

    private void comparisionType(int[] inputArray, int n)
    {
        int[] count = new int[n];
        Arrays.fill(count,0);
        for(int i=0; i<n-1; i++)
            for(int j=i+1; j<n;j++)
            {
                if(inputArray[i]<inputArray[j])
                    count[j]++;
                else
                    count[i]++;
            }
        int[] outputArray = new int[n];
        for(int i=0; i<n;i++)
            outputArray[count[i]]=inputArray[i];
        System.arraycopy(outputArray, 0, inputArray, 0, n);
    }
}
