package algortihms;

public class Searching
{    
    public static int linearSearch(int[] nums, int seek)
    {
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == seek)
            {
                return(i);
            }
        }
        return(-1);
    }
    
    public static int binarySearch(int[] nums, int seek, int start, int end)
    {
        int centre = (start + end) / 2; 
        if(end < start)
        {
            return(-1);
        }
        
        else if(nums[centre] == seek)
        {
            return(centre); 
        }       
        else if(seek < nums[centre])
        {
            return(binarySearch(nums, seek, start, centre-1));
        }
        else 
        {
            return(binarySearch(nums, seek, centre+1, end)); 
        }
    }
}
