package Test;

public class main {

    public static void main(String[] args) {


        //        BinaryTree tree = new BinaryTree();
//
//        tree.insert(50);
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(40);
//        tree.insert(60);
//        tree.insert(80);
//        System.out.println(tree.countNum(40));
//        System.out.println(tree.sumNum());
//        System.out.println(tree.numOfLeaves());
//        System.out.println(tree.sumOfLevel(1));
//        System.out.println(tree.maxDifference());

//
//        System.out.println("Inorder traversal:");
//        tree.inorder();
//
//        tree.delete(20);
//        System.out.println("After deleting 20:");
//        tree.inorder();
//
//        tree.delete(30);
//        System.out.println("After deleting 30:");
//        tree.inorder();



        int[] numbers = {1, 2, 3, 4, 5};
        int sum = calculateSum(numbers);
        System.out.println("Sum: " + sum);

    }
        public static int calculateSum(int[] arr) {
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            return sum;
        }



    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }



    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }




    public void permute(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String ros = str.substring(0, i) + str.substring(i + 1);
            permute(ros, ans + str.charAt(i));
        }
    }

    public static int calculateTripletSum(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sum += arr[i] + arr[j] + arr[k];
                }
            }
        }
        return sum;
    }
}
