package algorithm.searching;

/**
 * @author : Nguyen Trong TRUNG
 *
 * Strategy : Brute-Force
 * Best case : O(1)
 * Avarage case : p(n+1)/2 + n(1-p) (p is the probability of a successful search
 * Worst case : O(n)
 */
public class SequentialSearch implements SearchAlgorithm{
    @Override
    public int search(int[] inputArray, int key) {
        return nonRecursive(inputArray,key);
        //return recursive(inputArray,key,0);
}

    private int nonRecursive(int[] inputArray, int key)
    {
        int i = 0;
        while(i<inputArray.length && inputArray[i]!= key)
            i=i+1;
        if (i<inputArray.length)
            return i;
        else
            return -1;
    }

    private int recursive(int[] inputArray, int key, int position)
    {
        if(position>=inputArray.length) return -1;
        if (inputArray[position]==key) return position;
        return recursive(inputArray,key,position+1);
    }
}
