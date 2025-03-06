package Test;

public class BinaryTree {

    class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    public  BinaryTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertrec(root, value);
    }

    private Node insertrec(Node root, int value) {
        if ( root == null) {
            root = new Node(value);
            return root ;
        }
        if ( value <= root.value){
            root.left = insertrec(root.left, value);
        } else if (value > root.value) {
            root.right = insertrec(root.right, value);
        }
        return root;
    }

    public void delete(int value) {
        root = deleteRec(root, value);
    }
    private Node deleteRec(Node root, int value){
        if (root == null) {
            return null;
        }

        if (value <= root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value)  {
            root.right = deleteRec(root.right,value);
        }else {
            if ( root.left == null){
                return root.right;
            } else if (root.right == null) {
                return  root.left;
            }
            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    private int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            root = root.left;
            minValue = root.value;
        }
        return minValue;
    }

    public  void  inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void  inorderRec(Node root) {
        if (root != null){
            inorderRec(root.left);
            System.out.println(root.value + "");
            inorderRec(root.right);
        }
    }
    public int countNum(int num) {
        return  countNumRec(root, num);
    }

    private int countNumRec(Node root, int num) {
        if (root == null){
            return 0;
        }
        int count = 0;
        if (num == root.value) {
            count++;
        }

        return count + countNumRec(root.right, num) + countNumRec(root.left, num) ;
    }

    public int sumNum() {
        return sumNumRec(root);
    }

    private int sumNumRec(Node root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        return sum += root.value + sumNumRec(root.right) + sumNumRec(root.left);

    }

    public int numOfLeaves() {
        return numOfLeavesRec(root);
    }

    private int numOfLeavesRec(Node root){
        if (root == null){
            return 0;
        }
        int count = 0;
        if (root.left == null && root.right == null) {
            count++;
        }

        return count + numOfLeavesRec(root.right) + numOfLeavesRec(root.left);
    }

    public int sumOfLevel(int level){
        sumOfLevelRec(root, level);
        return sumOfLevelRec(root,level);
    }
    private int sumOfLevelRec(Node root, int level){
        if (root == null) {
            return 0;
        }
        if (level==1){
            return root.value;
        }
        return sumOfLevelRec(root.left, level-1)+sumOfLevelRec(root.right, level-1);
    }

    public int maxDifference() {
        if (root== null) {
            return 0;
        }
        int max = findMax(root);
        int min = findMin(root);
        return max - min;
    }

    private int findMax(Node root) {
        if (root.right == null) {
            return root.value;
        }
        return findMax(root.right);
    }

    private int findMin(Node root) {
        if (root.left == null) {
            return root.value;
        }
        return findMin(root.left);
    }
}
