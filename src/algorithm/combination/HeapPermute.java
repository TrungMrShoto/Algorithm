package algorithm.combination;

/**
 * @author : Nguyen Trong TRUNG
 */
import algorithm.generalFuntion.GeneralFunction;

import java.util.Arrays;

public class HeapPermute {
    private int[] array;
    private int noOfSwap;

    public HeapPermute(){}

    public void permute(int[] array)
    {
        this.array=array;
        noOfSwap=0;
        recursivePermute(this.array.length-1);
    }

    private void recursivePermute(int n) {
        int t;
        if (n==1)
        {
            for(int i=1;i<array.length;i++)
                System.out.print(array[i]+"\t");
            System.out.println();
        }
        else
        {
            for (int i=1;i<=n;i++)
            {
                recursivePermute(n-1);
                if (n%2!=0)
                {
                    GeneralFunction.swap(this.array,1,n);
                }
                else{
                   GeneralFunction.swap(this.array,i,n);
                }
                noOfSwap++;
            }
        }
    }

    public int getNoOfSwap() {
        return this.noOfSwap;
    }
}
