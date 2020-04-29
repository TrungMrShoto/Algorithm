package algorithm;

import algorithm.combination.HeapPermute;

/**
 * @author : Nguyen Trong TRUNG
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3};
        HeapPermute heap = new HeapPermute();
        heap.permute(arr);
        System.out.print(heap.getNoOfSwap());
    }
}
