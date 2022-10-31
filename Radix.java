import java.util.*;
import java.time.*;
public class Radix
{
    static void countingsort (int A[], int n, int dig)
    {
        int k = getMax(A, n);
        int B[] = new int[n+1];
        int C[] = new int[k+1];
        for (int i=0;i<k+1;i++)
            C[i] = 0; 
        for (int i=0;i<n;i++)
            C[(A[i]/dig)%10]++;
        for (int i=1;i<10;i++)
            C[i] += C[i-1];
        for (int i=n-1;i>=0;i--) {
            B[C[(A[i]/dig)%10]-1] = A[i];
            C[(A[i]/dig)%10]--;
        }
        for (int i=0;i<n;i++)
            A[i] = B[i];
    }
    static int getMax (int A[], int n)
    {
        int k = A[0];
        for (int i=0;i<n;i++)
            if (A[i] > k)
                k = A[i];
        return k;
    }
    static void radixsort(int A[], int n)
    {
        int max = getMax(A, n);
        for (int i=1;max/i>0;i*=10)
            countingsort(A, n, i);
    }
    public static void main (String args[])
    {
        int n=10000;
        int A[] = new int[n];
        Random rnd = new Random();
        for (int i=0;i<n;i++)
            A[i] = rnd.nextInt(n+1);
        double time1 = System.nanoTime();
        radixsort(A, n);
        double time2 = System.nanoTime();
        double timediff = (time2 - time1)/1000; // in microseconds
        System.out.println("\nThe Execution Time taken in radix sort algorithm is - " + timediff + "\n");
    }
}