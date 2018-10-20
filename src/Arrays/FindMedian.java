package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedian {
    public static void main(String [] args){
        int [] arr = {1, 4, 3, 2};
        FindMedian m = new FindMedian();
        m.findMedian(arr);
    }

    private void findMedian(int[] arr) {
        if(arr == null || arr.length == 0){
            return;
        }
        if(arr.length == 1){
            System.out.println(arr[0]);
            return;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for(int i: arr){
            maxHeap.offer(i);
            minHeap.offer(maxHeap.poll());
            if(maxHeap.size() < minHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
            findMedian(maxHeap, minHeap);
        }

    }

    private void findMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if(maxHeap.size() == minHeap.size()){
            int val = maxHeap.peek();
            int val2 = minHeap.peek();
            double median = (val+val2);
            System.out.println(median/2);
        }else{
            System.out.println(maxHeap.peek());
        }
    }
}
