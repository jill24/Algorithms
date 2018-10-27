package Arrays;
/*
Given an integer array, move all elements containing '0' to the left while maintaining the order of other elements in the array.

{1, 10, -1, 11, 5, 0, -7, 0, 25, -35};

 */
public class MoveZeros {
    public static void main(String [] args){
        MoveZeros m = new MoveZeros();
        int [] arr = {1, 10, -1, 11, 5, 0, -7, 0, 25, -35};
        m.moveZeroes(arr);
        for( int i: arr){
            System.out.print(i + " ");
        }
    }

    private void moveZeroes(int[] arr) {
        if(arr == null && arr.length == 0){
            return;
        }
        int i = arr.length-1; int j= arr.length-1;
        while(j>=0){
            if(arr[j]== 0){
                j--;
            }else{
                arr[i] = arr[j];
                i--;
                j--;
            }
        }

        while(i >=0){
            arr[i] = 0;
            i--;
        }
    }
}
