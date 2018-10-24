package Trees;
/*
Given root of a binary tree, delete any subtrees whose nodes sum up to zero.
In the below binary tree, we need to delete the subtree starting at node 5 as it's sum (5 -3 -2) equals zero.
 */
public class DeleteZeroSumSubTree {
    public static void main(String [] args){
        DeleteZeroSumSubTree d = new DeleteZeroSumSubTree();
        Node root = d.createBinaryTree();
        root = d.deleteSubTree(root);
    }

    private Node deleteSubTree(Node root) {

        if(root == null || root.val == 0){
            return root;
        }
        if(0 == delete(root)){
            root = null;
        }
        return root;
    }

    private int delete(Node root) {
        if(root == null){
            return 0;
        }
        int left = delete(root.left);
        int right = delete(root.right);

        if(left == 0){
            root.left = null;
        }
        if(right == 0){
            root.right = null;
        }
        int sum = root.val + left + right;

        return sum;
    }

    private Node createBinaryTree() {
        Node root = new Node(7);
        root.left= new Node(5);
        root.left.left = new Node(-3);
        root.left.right = new Node(-2);
        root.right = new Node(6);
        return root;
    }

}
