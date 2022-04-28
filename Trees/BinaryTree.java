package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(10);
        

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;
    }

    // pre order binary tree treaversal
        // a) visit the root node
        // b) traverse left subtree
        // c) traverse right subtree

    public void preOrder(TreeNode root){ // recursive method
        if(root == null)
            return;
        
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public void preOrderStack(TreeNode root){ //Iterative
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }

    }

    // inorder tree traversal 
        // a) traverse left subtress
        // b) visit root node
        // c) traverse right subtree

    public void inOrder(TreeNode root){ // recursive
        if(root == null) 
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void inOrderStack(TreeNode root){ // iterative
        if(root == null)
            return;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        System.out.print("\n");
        while(!stack.isEmpty() || temp != null){

            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    
    // postorder tree traversal
        // a) traverse left subtree
        // b) traverse right subtree
        // c) visit root node
    
    public void postOrder(TreeNode root){ // recursive
        if(root == null)
            return;

       
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }

    static Stack<TreeNode> s1,s2;

    public void postOrderStack(TreeNode root){ // iterative
        
        s1 = new Stack<>();
        s2 = new Stack<>();

        if(root == null)
            return;
        
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode temp = s1.pop();
            s2.push(temp);

            if(temp.left != null)
                s1.push(temp.left);
            if(temp.right != null)
                s2.push(temp.right);
        }

        while(!s2.isEmpty()){
            TreeNode temp = s2.pop();
            System.out.print(temp.data + " ");
        }

    }

    // level order traversal 
    public void levelOrder(TreeNode root){
        if(root == null)
            return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
    
    }

    // find maximum
    public int findMax(TreeNode root){
        if(root == null)
            return Integer.MIN_VALUE;
        
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > result)
            result = left;
        if(right > result)
            result = right;
        
        return result;
    }


    public static void main(String[] args) {
        
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.preOrderStack(bt.root);
        bt.inOrderStack(bt.root);
        System.out.print("\n");
        bt.postOrder(bt.root);
        System.out.print("\n");
        bt.postOrderStack(bt.root);
        System.out.print("\n");
        bt.levelOrder(bt.root);
        System.out.print("\n");
        System.out.println("Max elemnt: " + bt.findMax(bt.root));
    }
    
}
