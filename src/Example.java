import searching.*;

import java.util.Arrays;

public class Example{
    private static int[] A = {1,2,3};
    private static int noOfSwap = 0;
    private static void HeapPermute(int n){
        int t;
        if (n==0)
        {
            Arrays.stream(A).forEach(System.out::print);
            System.out.println();
        }
        else
        {
            for (int i=0;i<=n;i++)
            {
                HeapPermute(n-1);
                if (n%2!=0)
                {
                    t=A[0]; A[0]=A[n];A[n]=t;
                    noOfSwap++;
                }
                else{
                    t=A[i]; A[i]=A[n];A[n]=t;
                    noOfSwap++;
                }
            }
        }
    }
    public static void main(String[] args) {
//        int[] arr = {8,8,9,2,1,0,0,7,6,11,4,9};
//        SerchAlgorithm insertionSort = new InsertionSort();
//        insertionSort.search(arr);
//        for(int i :arr)
//            System.out.println(i);
        HeapPermute(2);
        System.out.println(noOfSwap);
    }
}

