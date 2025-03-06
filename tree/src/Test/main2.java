package Test;

import java.util.ArrayList;
import java.util.List;

public class main2 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int index = 2;
        int result = getElementAtIndex(numbers, index);
        System.out.println("Element at index " + index + ": " + result);
    }

    public static int getElementAtIndex(int[] array, int index) {
        return array[index];
    }


    public static List<Integer> findFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        int limit = (int) Math.sqrt(n);

        for (int i = 1; i <= limit; i++) {
            if (n % i == 0) {
                factors.add(i);
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }

        return factors;
    }











    public static void divideNum(int n) {
        int y=n;
        while (n>1){
            n=n/2;
            for (int i = 1; i < y; i++) {
                System.out.println(i);
            }
        }
    }













    public static int logarithmicFunction(int n) {
        int count = 0;
        while (n > 1) {
            n = n / 2;
            count++;
        }
        return count;
    }






















}


























