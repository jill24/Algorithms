package Trees;

public class TreeTraversal {
    public static void main(String [] args){
        TreeTraversal t = new TreeTraversal();
        int [] values = {5,4,6,3,3,7,2};
        Node n = t.create(values);
        System.out.println("InOrder Traversal - Recursive ");
        t.inorderTraversal(n);
        System.out.println("---------");
        System.out.println("PreOrder Traversal - Recursive ");
        t.preorderTraversal(n);
        System.out.println("---------");
        System.out.println("PostOrder Traversal - Recursive ");
        t.postorderTraversal(n);
        System.out.println("---------");
    }

    private void postorderTraversal(Node n) {
        if(n != null){
            postorderTraversal(n.left);
            postorderTraversal(n.right);
            System.out.print(n.val +" ");
        }
    }

    private void inorderTraversal(Node n) {
        if(n != null){
            inorderTraversal(n.left);
            System.out.print(n.val +" ");
            inorderTraversal(n.right);
        }
    }

    private void preorderTraversal(Node n){
        if(n != null){
            System.out.print(n.val +" ");
            preorderTraversal(n.left);
            preorderTraversal(n.right);
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
