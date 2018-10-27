package Trees;

import java.util.Stack;
/*
        5
    4       6
 3              7
2 3
*/
public class PrintPerimeter {

    public static void main(String[] args){
        PrintPerimeter p = new PrintPerimeter();
        int [] values = {5,4,6,3,3,7,2};
        Node n = p.create(values);
        p.printPerimeter(n);
    }

    private void printPerimeter(Node root) {
        if(root == null){
            return;
        }
        // print top to left
        printLeft(root);
        //print all leaves
        printLeaves(root);
        //print right bottom to top
        printRight(root);

    }
    
    private void printLeft(Node n){
        System.out.print(n.val +" ");
        while(n.left.left != null){
            n = n.left;
            System.out.print(n.val +" ");
        }
    }

    private void printRight(Node n){
        Stack<Node> stack = new Stack<Node>();
        while(n.right != null && n.right.right != null){
            stack.push(n.right);
            n = n.right;
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().val+ " ");
        }
    }

    private void printLeaves(Node n) {
        if(n != null){
            if(n.left == null && n.right == null){
                System.out.print(n.val+" ");
            }
            printLeaves(n.left);
            printLeaves(n.right);
        }
    }

    private Node create(int[] values) {
        Node n = new Node(values[0]);
        for(int i =1; i< values.length; i++){
            n.insert(values[i]);
        }
        return n;
    }
}
