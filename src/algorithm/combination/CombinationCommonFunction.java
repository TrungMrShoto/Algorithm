package algorithm.combination;

/**
 * @author : Nguyen Trong TRUNG
 */
public class CombinationCommonFunction {

    /**
     * Computes n! recursively
     * @param n
     * @return
     */
    public static long findFactorial(long n){
        if (n==0) return 1;
        else return findFactorial(n-1)*n;
    }
}
