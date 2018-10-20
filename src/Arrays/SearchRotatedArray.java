package Arrays;

public class SearchRotatedArray {
    public static void main(String []args){
        SearchRotatedArray s = new SearchRotatedArray();
        int[] v1 = {6, 7, 1, 2, 3, 4, 5};
        System.out.println("Key(3) found at: "+ s.search(v1, 3));
        System.out.println("Key(6) found at: "+ s.search(v1, 6));
        int[] v2 = {4, 5, 6, 1, 2, 3};
        System.out.println("Key(3) found at: "+ s.search(v2, 3));
        System.out.println("Key(6) found at: "+ s.search(v2, 6));
    }

    private int search(int[] arr, int val){
        if(arr == null || arr.length ==0){
            return -1;
        }
        int result = -1;

        int start = 0;
        int end = arr.length-1;

        while(start <= end && start>=0 && end < arr.length){
            int mid =  (end+start) /2;

            if(arr[mid] == val){
                return mid;
            }
            //left side is sorted
            if(arr[mid] > arr[start]){
                if(val >= arr[start] && val < arr[mid]){
                    end  = mid-1;
                }else{
                    start = mid+1;
                }
            }

            //right side sorted
            if(arr[end] > arr[mid]){
                if(val > arr[mid] && val <= arr[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return result;
    }

}
