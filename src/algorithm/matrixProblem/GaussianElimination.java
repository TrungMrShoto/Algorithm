package algorithm.matrixProblem;

import org.jetbrains.annotations.NotNull;

/**
 * @author : Nguyen Trong TRUNG
 *
 * Stategy : Transform-and-Conquer
 */
public class GaussianElimination {
    /**
     * Basic Operator : Comparision
     * Best case :
     * Average case :
     * Worst case :
     */
    public static void forwardElimination(@NotNull double[][] A)
    {
        int m=A.length;
        int n=A[0].length;
        if(n-m!=1)
            System.err.println("Cannot apply Gaussian Elimination");
        for(int i=0;i<m-1;i++)
            for(int j=i+1;j<m;j++)
                for(int k=i;k<m;k++)
                    if(Double.compare(A[i][i],0.0)==0)
                        A[j][k]=A[j][k]-A[i][k]*A[j][j]/A[i][i];
    }
}
