package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
current approach is o(n3) can be done in o(n2) by sorting array
 */
public class PythagoreanTriplets {
    public static void main(String [] args){
        PythagoreanTriplets p = new PythagoreanTriplets();
        int [] arr = {3, 4, 5, 6, 8, 10, 9, 12, 15, 18, 19};
        List<int[]> result = p.getTriplets(arr);
        for(int [] l : result){
            for(int i = 0; i <l.length; i++){
                System.out.print(l[i] + " ");
            }
            System.out.println();
        }
    }

    private List<int []> getTriplets(int[] arr) {
        List<int []> result = new ArrayList<>();

        if(arr == null || arr.length == 0){
            return result;
        }

        for(int i = 0; i < arr.length; i ++){

            for(int j = i+1; j< arr.length; j++){
                int k = j+1;
                while(k < arr.length){
                    double sum = Math.pow(arr[i], 2) + Math.pow(arr[j],2);
                    if(arr[k] == Math.sqrt(sum)){
                        int [] list = {arr[i], arr[j], arr[k]};
                        result.add(list);
                        break;
                    }else{
                        k++;
                    }
                }
            }
        }

        return result;
    }
}
