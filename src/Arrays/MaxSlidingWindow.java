package Arrays;

import java.util.LinkedList;

public class MaxSlidingWindow {

    public static void main(String [] args){
        int [] arr = {1, 2, 3, 4, 3, 2, 1, 2, 5 };
        int window = 4;
        MaxSlidingWindow m = new MaxSlidingWindow();

        int[] result = m.getMaxSlidingWindow(arr, window);
        m.printResult(result);

    }

    private int[] getMaxSlidingWindow(int[] arr, int window) {

        if(arr == null || arr.length == 0 || arr.length <window){
            throw new IllegalArgumentException();
        }

        int [] result = new int [arr.length - window +1];
        LinkedList<Integer>  list = new LinkedList<Integer>();

        for(int i = 0; i < arr.length ; i++){

            while(!list.isEmpty() && arr[list.peekLast()] < arr[i]){
                list.removeLast();
            }

            if(!list.isEmpty() && list.peekFirst() <= (i-window) ){
                list.removeFirst();
            }
            list.add(i);


            if(i-window+1 >=0){
                result[i-window+1] = arr[list.peekFirst()];
            }
        }

        return result;
    }

    private void printResult(int[] result) {
        for(int i: result){
            System.out.print(i + " ");
        }
    }
}
