package middleclass.lang.system;

import java.util.Arrays;
import java.util.Map;

public class SystemMain {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        long currentTimeNano = System.nanoTime();
        System.out.println("currentTimeNano = " + currentTimeNano);

        Map<String, String> getenv = System.getenv();
        System.out.println("getenv = " + getenv);

        char[] originalArray = {'h', 'h', 'e', 'l'};
        char[] copiedArr = new char[5];
        System.arraycopy(originalArray, 0, copiedArr, 0, originalArray.length );

        System.out.println("originalArray = " + Arrays.toString(originalArray));
    }
}
