package algorithm.combination;
import algorithm.generalFuntion.GeneralFunction;


/**
 * @author : Nguyen Trong TRUNG
 */
public class HeapAlgorithm implements GeneratingAllPermutation{
    private int[] array;
    private int noOfSwap;

    public HeapAlgorithm(){}

    @Override
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
            for(int i=0;i<array.length;i++)
                System.out.print(array[i]+"\t");
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
