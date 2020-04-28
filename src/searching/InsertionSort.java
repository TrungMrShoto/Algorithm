package searching;

public class InsertionSort implements SerchAlgorithm{

    @Override
    public void search(int[] inputArray) {
        recursiveSort(inputArray,inputArray.length-1);
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
}
