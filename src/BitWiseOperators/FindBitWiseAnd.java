package BitWiseOperators;

/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
    8  4  2  1
---------------
5 | 0  1  0  1
6 | 0  1  1  0
7 | 0  1  1  1
 */
public class FindBitWiseAnd {
    public static void main(String [] args){
        FindBitWiseAnd f = new FindBitWiseAnd();
        System.out.print(f.rangeBitwiseAnd(5,7));
    }

    public int rangeBitwiseAnd(int m, int n) {
        if(m > n || m< 0 || n <0){
            return 0;
        }

        for(int i = m+1; i <= n; i++){

            m = m & i;
        }
        return m;
    }
}
