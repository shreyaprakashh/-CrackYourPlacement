//Given an array nums[] of size n, construct a Product Array P (of same size n) such that P[i] is equal to the product of all the elements of nums except nums[i].
class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        // code here
        long productArr[] = new long[n];
        long product = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                else{
                    product *= nums[j];
                }
            }
            productArr[i] = product;
            product = 1;
        }
        return productArr;
	} 
} 
