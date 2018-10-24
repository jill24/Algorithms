package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorBinaryTree {

    public static void main(String [] args){
        MirrorBinaryTree m = new MirrorBinaryTree();
        Node root = m.createBinaryTree();
        m.printTree(root);
        System.out.print("___________");
        root = m.mirrorTree(root);
        m.printTree(root);

    }

    private Node mirrorTree(Node root) {
        if(root == null || root.left == null && root.right == null){
            return root;
        }
        if(root.left != null || root.right != null){
            Node n = root.left;
            root.left = root.right;
            root.right = n;
        }
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);

        return root;
    }

    private void printTree(Node root) {
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        System.out.println();
        //DFS Traversal
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count > 0){
                Node n = queue.poll();
                if(n.left != null){
                    queue.offer(n.left);
                }
                if(n.right != null){
                    queue.offer(n.right);
                }

                System.out.print(n.val + " ");
                count--;
            }
            System.out.println();
        }
    }

    private Node createBinaryTree() {
        Node root = new Node(20);
        root.left= new Node(50);
        root.left.left = new Node(75);
        root.left.right = new Node(25);
        root.right = new Node(200);
        root.right.right = new Node(300);
        return root;
    }
}
