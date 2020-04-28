package algorithm.stringProcessing;

/**
 * @author : Nguyen Trong TRUNG
 *
 * Strategy : Brute-Force
 * Worst case : m(n-m + 1) = O(nm)
 */
public class BruteForceStringMatch implements StringMatch{
    public int match(String text, String pattern){
        int n = text.length();
        int m = pattern.length();
        for (int i=0;i<n-m+1;i++)
        {
            int j = 0;
            while(j<m && pattern.charAt(j)==text.charAt(i+j))
                j=j+1;
            if (j==m) return i;
        }
        return -1;
    }
}
