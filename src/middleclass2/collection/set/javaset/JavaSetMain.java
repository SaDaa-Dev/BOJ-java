package middleclass2.collection.set.javaset;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class JavaSetMain {
    public static void main(String[] args) {

        run(new HashSet<String>());
        run(new LinkedHashSet<String>());
        run(new TreeSet<String>());
    }

    private static void run(Set<String> set) {
        System.out.println("set.getClass() = " + set.getClass());

        set.add("C");
        set.add("B");
        set.add("A");
        set.add("1");
        set.add("2");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
