package DynamicProgramming;
/*
Given coins denominations and total amount, find out the number of ways to make the change.
For example, we have coin denominations 1, 2 and 5 and the total amount is 7.
We can make its change in the following six ways.
 */

public class CoinChangeProblem {
    public static void main(String[] args) {
        CoinChangeProblem c = new CoinChangeProblem();
        int[] denominations = new int[] {1, 5, 10};
        System.out.println("Combinations (DP): " + c.findCoinChange(denominations,356));
        int[] denominations2 = new int[] {1, 2, 5};
        System.out.println("Combinations (DP): " + c.findCoinChange(denominations2,7));
    }

    private int findCoinChange(int[] denominations, int sum) {
        if(denominations == null || denominations.length == 0 ){
            throw new IllegalArgumentException("Invalid arguments");
        }
        if(sum == 0){
            return 1;
        }
    // create a solution array with sum+1 ( in order to consider for sum = 0;
        int [] solution = new int[sum+1];
        solution[0] = 1;
        for(int i : denominations){

            for(int j = i; j <solution.length; j++){
    // keep computing all possible combinations at each position of the array
                solution[j] = solution[j] + solution[j- i];
            }
        }
    //return last position of array
        return solution[solution.length-1];
    }
}
