package Arrays;
/*
Given three integer arrays sorted in ascending order, find the smallest number that is common in all three arrays.
For example, let's look at the below three arrays.
Here 6 is the smallest number that's common in all the arrays.
 */
public class SmallestCommonNumber {

    public static void main(String[] args){
        SmallestCommonNumber s = new SmallestCommonNumber();
        int[] v1 = new int[]{-1, 6, 10, 14, 50};
        int[] v2 = new int[]{-1, 6, 7, 8, 50};
        int[] v3 = new int[]{0, 6, 7, 10, 25, 30, 40};
        int result = s.findLeastCommonNumber(v1, v2, v3);
        System.out.println("Least Common Number: "+result);
    }
    private int findLeastCommonNumber(int[] v1, int[] v2, int[] v3) {
        if (v1 == null || v2 == null || v3 == null){
            throw new IllegalArgumentException();
        }
        if (v1.length == 0 || v2.length == 0 || v3.length == 0){

        }

        int i = 0; int j=0; int k = 0;

        while (i <v1.length && j < v2.length && k < v3.length){

            if(v1[i] == v2[j] && v2[j] == v3[k]){
                return v1[i];
            }

            if(v1[i] < v2[j] || v1[i] < v3[k]){
                i++;
            }else if(v2[j] < v3[k] || v2[j] < v1[i]){
                j++;
            }else{
                k++;
            }
        }
        throw new IllegalArgumentException();
    }

}
