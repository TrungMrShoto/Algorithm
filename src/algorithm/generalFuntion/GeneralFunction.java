package algorithm.generalFuntion;

/**
 * @author : Nguyen Trong TRUNG
 */
public class GeneralFunction {
    public static void swap(int[] arr, int firstPosition, int secondPersition)
    {
        int t;
        t=arr[firstPosition];
        arr[firstPosition]=arr[secondPersition];
        arr[secondPersition]=t;
    }
    public static int maxElement(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > maxValue)
                maxValue = arr[i];
        return maxValue;
    }

    /**
     * Determine whether all the elements in a given array are distinct
     * Worst case : (n-1)n/2 in O(n^2) where n is the number of elements of the input array
     */
    public static boolean uniqueElement(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] == arr[j])
                    return false;
        return true;
    }
}
