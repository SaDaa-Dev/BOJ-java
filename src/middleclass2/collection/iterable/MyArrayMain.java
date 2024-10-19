package middleclass2.collection.iterable;

import java.util.HashSet;
import java.util.Iterator;

public class MyArrayMain {
    public static void main(String[] args) {
        MyArray array = new MyArray(new int[]{1, 2, 3, 4});
        Iterator<Integer> iterator = array.iterator();

        HashSet<Integer> set = new HashSet<>();
        Iterator<Integer> iterator1 = set.iterator();

        forEach(array);
    }

    private static <E extends Iterable> E forEach(E iter) {
        for (Object element : iter) {
            System.out.println("element = " + element);
        }

        return null;
    }
}
