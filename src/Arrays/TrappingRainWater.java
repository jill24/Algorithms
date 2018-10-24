package Arrays;
/*

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

 */
public class TrappingRainWater {
    public  static void main(String [] args){
        TrappingRainWater t = new TrappingRainWater();
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Total water stored : "+t.trap(height));
    }

    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = height[0];
        left[0]= height[0];


        for(int i = 1; i <height.length; i++){
            if(height[i]<max){
                left[i] = max;
            }else{
                left[i] = height[i];
                max = height[i];
            }
        }

        for(int i : left){
            System.out.print(i+" ");
        }
        max = height[height.length-1];;
        right[height.length-1] = height[height.length-1];
        for(int i =height.length-2; i>=0; i--){
            if(height[i]<max){
                right[i] = max;
            }else{
                right[i] = height[i];
                max = height[i];
            }
        }
        System.out.println();
        for(int i : right){
            System.out.print(i+" ");
        }
        System.out.println();

        int result = 0;
        for(int i=0; i<height.length; i++){
            result+= Math.min(left[i],right[i])-height[i];
        }
        return result;
    }
}
