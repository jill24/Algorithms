package DynamicProgramming;

public class MaxSumSubsequenceNonAdj {
    public static void main(String [] args){
        MaxSumSubsequenceNonAdj m = new MaxSumSubsequenceNonAdj();
        int[] v1 = new int[]{1, 6, 10, 14, 50, -20, -5, -10};
        System.out.println("Max non adjacent sum: " + m.findMaxSumNonadjacent(v1));
        int[] v2 = new int[]{1, 6, 10, 14, -5, -1, 2, -1, 3};
        System.out.println("Max non adjacent sum: " + m.findMaxSumNonadjacent(v2));
        int[] v3 = new int[]{1, -1, 6, -4, 2,  2};
        System.out.println("Max non adjacent sum: " + m.findMaxSumNonadjacent(v3));
    }

//O(n) approach
    private int findMaxSumNonadjacent(int[] arr) {
        if(arr == null || arr.length ==0){
            return 0;
        }
        if(arr.length == 1){
            return arr[0];
        }
        int [] result = new int[arr.length];
        result[0] = arr[0];
        for(int i = 1; i < arr.length; i++){

            result[i] = Math.max(arr[i], result[i-1]);
            if(i-2 >= 0){
                result[i] = Math.max(result[i], arr[i]+ result[i-2]);
            }

        }
        return result[arr.length-1];
    }


//O(n2) approach
    private int findMaxSumNonadjacent2(int[] arr) {
        if(arr == null || arr.length ==0){
            return 0;
        }

        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;
        int index1 = 0;
        int index2 = 0;
        int j = 0;

        while(j < arr.length){
            index1 = j;
            localMax = arr[index1];
            for(int i = j+2; i < arr.length; i++ ){
                index2 = i;

                if(index2-index1 == 1){
                    continue;
                }
                int sum = localMax+ arr[index2];

                if(localMax <0 ){
                    localMax = arr[index2];
                }else if(sum < localMax){
                    continue;
                }else{
                    localMax = sum;
                }

                if(globalMax < localMax){
                    globalMax = localMax;
                }

                index1 = index2;
            }
            j++;
        }

        return globalMax;
    }
}
