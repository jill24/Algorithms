package Arrays;

import java.util.*;

/*
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
 */
//O(nlogn)+o(n)
public class KClosestElements {
    public static void main(String [] args){
        KClosestElements e = new KClosestElements();
        int  k = 4; int elem = 3;
        int [] arr = {1,2,3,4,5};
        List<Integer> result = e.getKClosestElements(getInput(arr), k, elem);
        for(int i : result){
            System.out.print(i + " ");
        }

        System.out.println();
        k = 4;  elem = -1;
        int [] arr2 = {1,2,3,4};
        result = e.getKClosestElements(getInput(arr2), k, elem);
        for(int i : result){
            System.out.print(i + " ");
        }
    }

    private static List<Integer> getInput(int [] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i : arr){
            list.add(i);
        }
        return list;
    }

    private List<Integer> getKClosestElements(List<Integer> arr, int k, int elem) {
        List<Integer> result = new ArrayList<>();
        if(arr == null){
            return result;
        }
        Collections.sort(arr);
        int i = 0;
        int j = 0;

        // can be done using binary search
        while(arr.get(j) < elem && j < k && j < arr.size()){
            j++;
        }

        if(j-k > 0){
            i = j-k + 1;
        }

        while(k>0 && i < arr.size()){
            result.add(arr.get(i));
            i++;
            k--;
        }
        return result;
    }
}
