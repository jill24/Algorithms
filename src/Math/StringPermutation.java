package Math;

/*
Write a program to print all permutations of a given string
A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of an ordered
list S into a one-to-one correspondence with S itself. A string of length n has n! permutation.

Below are the permutations of string ABC.
ABC ACB BAC BCA CBA CAB
 */
public class StringPermutation {
    public static void main(String [] args){
        StringPermutation s = new StringPermutation();
        String input = "ABC";
        s.permute(input.toCharArray(), 0, 2);
    }

    private void permute(char [] c, int l, int r) {
        if(c == null || c.length == 0){
            return;
        }

        if(l == r){
            System.out.print(String.valueOf(c)+" ");
        }else{

            for(int i = l; i<=r; i++){
                swap(c,  l, i);
                permute(c, l+1, r);
                swap(c, l, i);
            }
        }
    }

    private void swap(char [] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
