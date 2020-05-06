package algorithm.sorting;

/**
 *@author : Nguyen Trong TRUNG
 *
 * Strategy : Divide-and-Conquer
 * Best case :
 * Average case :
 * Best case : nlog2 n in O(nlog n)
 */
public class MergeSort implements SortingAlgorithm {

    @Override
    public void sort(int[] inputArray) {
        mergeSort(inputArray,0,inputArray.length-1);
    }

    private void mergeSort(int[] inputArray, int left, int right) {
        if (left<right)
        {
            int middle = (left+right)/2;
            mergeSort(inputArray,left,middle);
            mergeSort(inputArray,middle+1,right);
            merge(inputArray,left,middle,right);
        }
    }


    private void merge(int[] inputArray, int left, int middle, int right) {
        int i,j,k;

        int lengthLeftPartition = middle-left+1;
        int[] LeftPartition = new int[lengthLeftPartition];
        for(i=0;i<lengthLeftPartition;i++)
        {
            LeftPartition[i]=inputArray[left+i];
        }

        int lengthRightPartition = right - middle;
        int[] RightPartition = new int[lengthRightPartition];
        for(j=0;j<lengthRightPartition;j++)
        {
            RightPartition[j]=inputArray[middle+1+j];
        }


        i = j = 0;
        k=left;

        while (i<lengthLeftPartition && j<lengthRightPartition)
        {
            if(LeftPartition[i]<=RightPartition[j]){
                inputArray[k]=LeftPartition[i];
                i=i+1;
            }
            else
            {
                inputArray[k]=RightPartition[j];
                j=j+1;
            }
            k=k+1;
        }
        while(i<lengthLeftPartition){
            inputArray[k]=LeftPartition[i];
            i++;
            k++;
        }
        while(j<lengthRightPartition)
        {
            inputArray[k]=RightPartition[j];
            j++;
            k++;
        }
    }

}
