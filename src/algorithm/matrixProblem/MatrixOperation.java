package algorithm.matrixProblem;
import org.jetbrains.annotations.NotNull;

/**
 * @author : Nguyen Trong TRUNG
 */
public class MatrixOperation {

    /**
     * Matrix addition or matrix subtraction
     */
    public static double[] @NotNull [] matrixAdditionOrSubtraction(@NotNull double[][] A, @NotNull  double[][] B, boolean isAddition) {
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

    /**
     * Scalar Multiplication
     */
    public static double[] @NotNull [] scalarMultiplication(double[] @NotNull [] A, double scalar){
        double[][] resultMatrix = new double[A.length][A[0].length];
        for(int i=0; i<A.length;i++)
            for(int j=0;j<A[0].length;j++)
                resultMatrix[i][j]=scalar*A[i][j];
        return resultMatrix;
    }

    /**
     * Transposition
     */
    public static double[] @NotNull [] transpose(double[] @NotNull [] A){
        double[][] resultMatrix= new double[A[0].length][A.length];
        for(int i = 0;i<A.length;i++)
            for(int j=0;j<A[0].length;j++)
                resultMatrix[j][i]=A[i][j];
        return resultMatrix;
    }

    /**
     * Matrix multiplication
     */
    public static double[] @NotNull [] matrixMultiplication(@NotNull double[][] A, @NotNull double[][] B) {
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

    /**
     * Find the determinant of a matrix
     */
    public static double det(@NotNull double[][] A){
        if(A.length != A[0].length)
            System.err.println("The given matrix doesn't have determinant value!!!");
        return determinant(A,A.length);
    }

    private static double determinant(double[][]matrix, int n){
        double result = 0;

        if(n==1)
            return matrix[0][0];

        double temp[][] = new double[n][n];
        int sign = 1;

        for(int i=0;i<n;i++)
        {
            getSubmatrix(matrix,temp,0,i,n);
            result+=sign*matrix[0][i]*determinant(temp,n-1);
            sign=-sign;
        }
        return result;
    }

    private static void getSubmatrix(double[][] matrix, double[][] temp, int rowPivot, int colPivot, int n) {
        int i = 0, j = 0;
        for(int row = 0;row < n;row++)
        {
            for(int col=0;col<n;col++)
            {
                if(row!=rowPivot && col!= colPivot)
                {
                    temp[i][j]=matrix[row][col];
                    j++;
                    if(j==n-1)
                    {
                        i++;
                        j=0;
                    }
                }
            }
        }
    }

    public static double[] @NotNull [] invertibleMatrix(@NotNull double[] @NotNull [] A){
        if (A.length != A[0].length)
            System.err.println("If you want to find the invertible of a matrix, your given matrix must be square matrix!!!");
        double detOfMatrix = MatrixOperation.det(A);
        if (Double.compare(detOfMatrix,0.0)==0)
            System.err.println("If you want to find the invertible of a matrix, the determinant of your given matrix must be different from zero!!!");
        double[][] adjugateMatrix = calculateAdjugateMatrix(A);
        return scalarMultiplication(adjugateMatrix,1.0/detOfMatrix);
    }

    private static double[] @NotNull [] calculateAdjugateMatrix(double[] @NotNull [] matrix) {
        int length=matrix.length;
        if(length==1)
            return getIdentityMatrix(1);
        double[][] resultMatrix=new double[length][length];
        for(int i=0;i<length;i++)
            for(int j=0;j<length;j++)
            {
                double[][] temp = new double[length-1][length-1];
                getSubmatrix(matrix,temp,i,j,length-1);
                resultMatrix[i][j]=Math.pow(-1.0,i+j)*det(temp);
            }
        return resultMatrix;
    }

    public static double[] @NotNull [] getIdentityMatrix(int size) {
        if(size<=0)
            System.err.println("Identity Matrix must have size greater than 0");

        double[][] resultMatrix = new double[size][size];
        for(int i=0;i<size;i++)
            resultMatrix[i][i] = 1;
        return resultMatrix;
    }

    /**
     * The trace of the square matrix
     */
    public static double tr(double[] @NotNull [] A) {
        double result=0.0;
        if (A.length != A[0].length)
            System.err.println("If you want to find the trace of a matrix, your given matrix must be square matrix!!!");
        for(int i=0;i<A.length;i++)
            result+=A[i][i];
        return result;
    }
}
