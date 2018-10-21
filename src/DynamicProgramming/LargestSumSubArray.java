package DynamicProgramming;
/*
Given an array, find the contiguous subarray with the largest sum.
In the 3rd array below, the largest sum subarray starts at index 3 and ends at 6 and the largest sum is 12.
 */

public class LargestSumSubArray {
    public static void main(String [] args){
        LargestSumSubArray s = new LargestSumSubArray();
        int[] v = new int[]{1, 10, -1, 11, 5, -30, -7, 20, 25, -35};
        System.out.println("Sum of largest subarray: " + s.findMaxSubArray(v));


        int[] v1 = new int[]{-15, -14, -10, -19, -5, -21, -10};
        System.out.println("Sum of largest subarray: " + s.findMaxSubArray(v1));

        int[] v2 = new int[]{-4, 2,-5,1,2,3,6,-5,1};
        System.out.println("Sum of largest subarray: " + s.findMaxSubArray(v2));
    }

    private int findMaxSubArray(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int globalMax = arr[0];
        int localMax = arr[0];
        for(int i=1; i< arr.length; i++){


            if(localMax < 0){
                localMax = arr[i];
            }else{
                localMax += arr[i];
            }
            if(localMax > globalMax){
                globalMax = localMax;
            }
        }
        return globalMax;
    }
}
