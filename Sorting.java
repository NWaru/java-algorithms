package algortihms;

public class Sorting 
{
    public static int[] selectionSort(int[] nums)
    {
        int largestIndex; 
        int tmp; 
        
        for(int searchLength = nums.length; searchLength > 0; searchLength--)
        {
            largestIndex = 0; 
            for(int compare = 0; compare < searchLength; compare++)
            {
                if(nums[compare] > nums[largestIndex])
                {                 
                    largestIndex = compare; 
                }
                if(compare == searchLength-1)
                {
                    tmp = nums[compare];
                    nums[compare] = nums[largestIndex];
                    nums[largestIndex] = tmp; 
                } 
            }
        }    
        return(nums);
    }
    
    public static int[] insertionSort(int[] nums)
    {
        int tmp; 
        
        for(int i = 1; i < nums.length; i++)
        {
            tmp = nums[i]; 
            for(int n = i-1; n >= 0; n--)
            {
                if(nums[n] > tmp)
                {
                    nums[n+1] = nums[n];
                    if(n == 0)
                    {
                        nums[n] = tmp; 
                    }
                }
                else
                {
                    nums[n+1] = tmp;
                    break;
                }
            }
        }
        return(nums);
    }
        
    public static void merge(int[] nums, int start, int mid, int end)
    {
        int[] numsCopy  = new int[end-start];
        int i = start; 
        int n = mid;
        int index = 0;
        while(i < mid && n < end)
        {
            if(nums[i] < nums[n])
            {
                numsCopy[index] = nums[i];
                i++;            
            }
            else
            {
                numsCopy[index] = nums[n];
                n++;
            }
            index++;
        }
        while(i < mid)
        {
            numsCopy[index] = nums[i];
            i++;
            index++;
        }
        while(n < end)
        {
            numsCopy[index] = nums[n];
            n++;
            index++;
        }
        for(int place = start; place < end; place++)
            nums[place] = numsCopy[place-start];
    }
    
    private static void mergesortHelper(int[] a, int lo, int hi)
    {
        if(hi - lo <= 1)
            return;
        
        int mid = (lo + hi) / 2; 
        mergesortHelper(a, lo, mid);
        mergesortHelper(a, mid, hi);
        
        merge(a, lo, mid, hi);
    }
    
    public static void mergesort(int[] a)
    {
        int n = a.length;
        mergesortHelper(a, 0, n);
    }
    
    public static int[] quicksort(int[] a, int lo, int hi)
    {
        if(lo < hi)
        {
            int p = partition(a, lo, hi);
            quicksort(a, lo, p - 1);
            quicksort(a, p + 1, hi);
        }
        return(a);
    }
    
    public static int partition(int[] a, int lo, int hi)
    {
        int tmp; 
        int pivot = a[hi];
        int i = lo - 1;
        for(int j = lo; j < hi; j++)
        {
            if(a[j] < pivot)
            {
                i = i + 1;
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        tmp = a[i+1];
        a[i+1] = a[hi];
        a[hi] = tmp; 
        return(i+1); 
    }
}
