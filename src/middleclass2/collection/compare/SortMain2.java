package middleclass2.collection.compare;

import java.util.Arrays;
import java.util.Comparator;

public class SortMain2 {
    public static void main(String[] args) {
        Integer[] arr = {3, 2, 1};
        System.out.println("arr = " + Arrays.toString(arr));
        Arrays.sort(arr, new AscComparator());
        System.out.println("arr = " + Arrays.toString(arr));
        Arrays.sort(arr, new DecComparator());
        System.out.println("arr = " + Arrays.toString(arr));

        Arrays.sort(arr, Comparator.reverseOrder());

    }

    static class AscComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("o1 = " + o1 + ", o2 = " + o2);
            return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
        }
    }
    static class DecComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("o1 = " + o1 + ", o2 = " + o2);
            return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1) * -1;
        }
    }

}
