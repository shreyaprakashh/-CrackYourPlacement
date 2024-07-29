// You have n books, each with arr[i] a number of pages. m students need to be allocated contiguous books, with each student getting at least one book.
// Out of all the permutations, the goal is to find the permutation where the sum of the maximum number of pages in a book allotted to a student should be the minimum, out of all possible permutations.
// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).
class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
         if(n < m)
        {
            return -1;
        }
        
        int low = arr[0];
        int high = 0;
        
        for (int i = 0; i < n; i++)
        {
            if(arr[i] > low)
            {
                low = arr[i];
            }
            high += arr[i];
        }
        
        while(low <= high)
        {
            int mid = (low + high) / 2;
            int students = countstudents(arr, mid);
            if(students > m)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    public static int countstudents(int[] arr, int pages)
    {
        int students = 1;
        long pagestudent = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            if(pagestudent + arr[i] <= pages)
            {
                pagestudent += arr[i];
            }
            else
            {
                students += 1;
                pagestudent = arr[i];
            }
        }
        
        return students;
    }
};
