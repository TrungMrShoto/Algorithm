package algorithm;

import algorithm.combination.HeapAlgorithm;

/**
 * @author : Nguyen Trong TRUNG
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3};
        HeapAlgorithm heap = new HeapAlgorithm();
        heap.permute(arr);
        System.out.print(heap.getNoOfSwap());
    }
}
