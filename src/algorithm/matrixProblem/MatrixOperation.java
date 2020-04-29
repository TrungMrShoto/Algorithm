package algorithm.matrixProblem;

import org.jetbrains.annotations.NotNull;

/**
 * @author : Nguyen Trong TRUNG
 */
public class MatrixOperation {
    public static double[][] MatrixAdditionOrSubtraction(@NotNull double[][] A, @NotNull  double[][] B, boolean isAddition) {
        int rowLengthMatrixA = A.length;
        int colLengthMatrixA = A[0].length;
        int rowLengthMatrixB = B.length;
        int colLengthMatrixB = B[0].length;

        if (rowLengthMatrixA!=rowLengthMatrixB || colLengthMatrixA!=colLengthMatrixB)
            System.err.println("Cannot plus or subtract two matrices");

        double[][] C = new double[rowLengthMatrixA][colLengthMatrixA];
        for (int i = 0; i < rowLengthMatrixA; i++)
        {
            for (int j = 0; j < colLengthMatrixA; j++) {
                C[i][j]=isAddition ? A[i][j]+B[i][j]:A[i][j]-B[i][j];
            }
        }
        return C;
    }

    public static double[][] MatrixMultiplication(@NotNull double[][] A,@NotNull double[][] B)
    {
        int rowLengthMatrixA = A.length;
        int colLengthMatrixA = A[0].length;
        int rowLengthMatrixB = B.length;
        int colLengthMatrixB = B[0].length;

        if(colLengthMatrixA!=rowLengthMatrixB)
            System.err.println("Cannot multiple two matrices");

        double[][] C = new double[rowLengthMatrixA][colLengthMatrixB];
        for (int i=0;i<rowLengthMatrixA;i++)
            for(int j=0;j<colLengthMatrixB;j++)
            {
                C[i][j]=0;
                for(int k=0;k<rowLengthMatrixB;k++)
                    C[i][j]+=A[i][k]*B[k][j];
            }
        return C;
    }
}
