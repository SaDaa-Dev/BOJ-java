package middleclass.lang.string.builder;

public class LoopStringMain {
    public static void main(String[] args) {
        long startT = System.currentTimeMillis();
        /*String result = "";
        for (int i = 0; i < 100000; i++) {
            result += "Hello JAVA ";
        }*/
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append("Hello JAVA ");
        }
        long endT = System.currentTimeMillis();

        System.out.println("result = " + sb.toString());
        System.out.println("time = " + (endT - startT) + "ms");
    }
}
