package Trees;

public class Node {
    int val;
    Node left;
    Node right;
    Node(int v){
        this.val = v;
        this.left = null;
        this.right = null;
    }

    public Node insert(int value){
        while(value >= this.val){
            if(this.right == null){
                this.right = new Node(value);
                return this;
            }else{
                return this.right.insert(value);

            }
        }
        while(value < this.val){
            if(this.left == null){
                this.left = new Node(value);
                return this;
            }else{
                return this.left.insert(value);
            }
        }
        return this;
    }

}
