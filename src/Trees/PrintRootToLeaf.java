package Trees;

public class PrintRootToLeaf {
    public static void main(String [] args){
        PrintRootToLeaf p = new PrintRootToLeaf();
        int [] values = {5,4,6,3,3,7,2};
        Node n = p.create(values);
        System.out.println("Print Root To Leaf");
        p.printRootToLeaf(n);

    }

    public void printRootToLeaf(Node n) {
        if(n == null){
            return;
        }
        if(n.left == null && n.right == null){
            System.out.print(n.val);
            return;
        }
        
        int [] arr = new int [1000];
        printPath(n, arr, 0);
    }

    private void printPath(Node n, int[] arr, int len) {
        if(n != null){
            arr[len] = n.val;
            len++;
            if(n.left ==  null && n.right == null){
                print(arr, len );

            }
            
            printPath(n.left, arr, len);
            printPath(n.right, arr, len);
        }
    }

    private void print(int [] arr, int len){
        for(int i =0; i <len; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
    private Node create(int[] values) {
        Node n = new Node(values[0]);
        for(int i =1; i< values.length; i++){
            n.insert(values[i]);
        }
        return n;
    }
}
