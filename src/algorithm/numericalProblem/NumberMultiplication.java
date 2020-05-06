package algorithm.numericalProblem;

/**
 * @author : Nguyen Trong TRUNG
 *
 * Strategy : Decrease-and-Conquer (Decrease-by-a-Constant-Factor)
 */
public class NumberMultiplication {
    public static long RussianPeasantMethod(int n, int m)
    {
        if (n==1) return m;
        if(n%2==0)
        {
            return RussianPeasantMethod(n/2,2*m);
        }
        else
            return RussianPeasantMethod((n-1)/2,2*m)+m;
    }
}
