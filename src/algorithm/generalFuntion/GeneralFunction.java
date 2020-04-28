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
}
