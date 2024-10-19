package middleclass2.collection.compare;

import java.util.Arrays;

public class SortMain1 {
    public static void main(String[] args) {
        Integer[] arr = {3, 2, 1};
        System.out.println("arr = " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
