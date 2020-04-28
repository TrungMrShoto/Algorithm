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
        recursivePermute(this.array.length-1);
    }

    private void recursivePermute(int n) {
        int t;
        if (n==0)
        {
            Arrays.stream(this.array).forEach(x->
                    System.out.print("\t")
                    );
            System.out.println();
        }
        else
        {
            for (int i=0;i<=n;i++)
            {
                recursivePermute(n-1);
                if (n%2!=0)
                {
                    GeneralFunction.swap(this.array,0,n);
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
