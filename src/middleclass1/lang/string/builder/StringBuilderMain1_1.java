package middleclass1.lang.string.builder;

public class StringBuilderMain1_1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("a").append("b").append("C").append("D");
        System.out.println("sb = " + sb);

        sb.insert(4, "JAVA");
        System.out.println("sb = " + sb);

        // 다시 불변으로
        String str = sb.toString();
        System.out.println("str = " + str);
    }
}
