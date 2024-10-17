package middleclass2.collection.set;

import java.util.Arrays;

public class HashStart3 {
    public static void main(String[] args) {
        Integer[] inputArray = new Integer[100];
        inputArray[1] = 1;
        inputArray[2] = 2;
        inputArray[5] = 5;
        inputArray[8] = 8;
        inputArray[14] = 14;
        inputArray[99] = 99;

        int searchValue = 8;
        Integer result = inputArray[searchValue];
        System.out.println("result = " + result);

        System.out.println(Arrays.toString(inputArray));
    }
}
