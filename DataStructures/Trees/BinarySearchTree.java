package Trees;

public class BinarySearchTree {

    private static TreeNode root;

    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;
        
        public TreeNode(int data){
            this.data = data;
        }
    }

    public void insert(int value) {
		root = insert(root, value);
	}
	
	public TreeNode insert(TreeNode root, int value) {
		if(root == null) {
			root = new TreeNode(value);
			return root;
		}
		
		if(value < root.data) {
			root.left = insert(root.left, value);
		} else {
			root.right = insert(root.right, value);
		}
		return root;
	}

    public void inOrder() {
		inOrder(root);
	}

    public void inOrder(TreeNode root){
        if(root == null)
            return;
        
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public TreeNode search(int key){
        return search(root, key);
    }

    public TreeNode search(TreeNode root, int key){
        if(root == null || root.data == key)
            return root;
        
        if(key < root.data) 
            return search(root.left, key);
        
        else   
            return search(root.right, key);
    }

    public int maxValue(){
        return maxValue(root);
    }

    public int minValue(){
        return minValue(root);
    }

    public int maxValue(TreeNode root){
        TreeNode current = root;
        while(current.right != null)
            current = current.right;
        
        return current.data;
    }

    public int minValue(TreeNode root){
        TreeNode current = root;
        while(current.left != null)
            current = current.left;
        
        return current.data;
    }


    public boolean isValid(TreeNode root, long min, long max){
        if(root == null)
            return true;
        
        if(root.data <= min || root.data >= max)
            return false;
        
        boolean left = isValid(root.left, min, root.data);
        if(left){
            boolean right = isValid(root.right, root.data, max);
            return right;
        }

        return false;

    }



    public static void main(String[] args) {
        
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        
        bst.inOrder();
        System.out.println();
        if(null != bst.search(8)){
            System.out.println("Key Found !");
        }
        else
            System.out.println("Key not found !");
        //System.out.println("\n" + bst.search(8).data);

        System.out.println("Max value of BST: " + bst.maxValue());
        System.out.println("Min value of BST: " + bst.minValue()); 
        System.out.println(bst.isValid(root, Long.MIN_VALUE, Long.MAX_VALUE));


        
    }
    
}
