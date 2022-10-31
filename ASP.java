import java.util.*;
import java.io.*;
public class ASP
{
    static void swap (int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
    static int partition (int a[], int s[], int low, int high)
    {
        int pivot = a[high];
        int i=low-1;
        for (int j=low;j<high;j++)
        {
            if (a[j] < pivot)
            {
                i++;
                swap(a[i], a[j]);
                swap(s[i], s[j]);
            }
        }
        swap(a[i+1],a[high]);
        swap(s[i+1],s[high]);
        return i+1;        
    } 
    static void quicksort (int a[], int s[], int low, int high)
    {
        if (low < high)
        {
            int p = partition(a, s, low, high);
            quicksort(a, s, low, p-1);
            quicksort(a, s, p+1, high);
        }
    }
    static void MaxActivities (int start[], int end[], int n)
    {
        quicksort(end, start, 0, end.length-1);
        int i,j;
        System.out.println("\nActivities Selected : ");
        i=0;
        System.out.print(i + " ");
        for (j=1;j<n;j++)
        {
            if (start[j] >= end[i])
            {
                System.out.print(j + " ");
                i = j;
            }
        }
        System.out.println("");
    }
    public static void main(String args[])
    {
        Random rnd = new Random();
        int start[] = new int[75];
        int end[] = new int[75];
        for (int i=0;i<start.length;i++)
        {
            start[i] = 1 + rnd.nextInt(94);
            end[i] = start[i] + 1 + rnd.nextInt(6);
        }
        MaxActivities(start, end, start.length);
    }
}