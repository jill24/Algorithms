package Arrays;

/*
Given an array (list) of intervals as input where each interval has a start and end timestamps. Input array is sorted by starting timestamps.
You are required to merge overlapping intervals and return output array (list).

Consider below input array. Intervals (1, 5), (3, 7), (4, 6), (6, 8) are overlapping so should be merged to one big interval (1, 8).
Similarly intervals (10, 12) and (12, 15) are also overlapping intervals and should be merged to (10, 15).
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeOverlappingIntervals {
    public static void main(String[] args){
        MergeOverlappingIntervals m = new MergeOverlappingIntervals();
        int[][] interval1 = {{1, 2}, {3,7}, {4,6}, {6,8}};
        int [][] result1 = m.mergeIntervals(interval1);
        m.print(result1);
        int[][] interval2 = {{22, 23}, {12,15}};
        int [][] result2 = m.mergeIntervals(interval2);
        m.print(result2);
    }

    private int[][] mergeIntervals(int[][] interval) {
        if(interval == null){
            throw new IllegalArgumentException();
        }

        // create custom comparator
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.start!=i2.start)
                    return i1.start-i2.start;
                else
                    return i1.end-i2.end;

            }
        });
        for(int i = 0 ; i<interval.length; i++){
            queue.offer(new Interval(interval[i][0], interval[i][1]));
        }
        List<Interval> result = new ArrayList<Interval>();
        while( queue.size() >1){
            Interval i1 = queue.poll();
            Interval i2 = queue.peek();
            if(i1.end >= i2.start){
                Interval i = new Interval(i1.start, Math.max(i1.end,i2.end));
                queue.poll();
                queue.offer(i);
            }else{
                result.add(i1);
            }
        }

        while(!queue.isEmpty()){
            result.add(queue.poll());
        }

        int [][] arrResult = new int [result.size()][2];
        int i = 0;
        for(Interval x :  result){
            arrResult[i][0] = x.start;
            arrResult[i][1] = x.end;
            i++;
        }

        return arrResult;
    }
    private void print(int[][] result) {
        for(int i = 0 ; i <result.length; i++){
            System.out.print("("+ result[i][0] +","+result[i][1]+")");
        }
        System.out.println();
    }
}

class Interval{
    int start;
    int end;
    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }

}