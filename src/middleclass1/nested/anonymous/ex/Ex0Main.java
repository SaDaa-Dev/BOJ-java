package middleclass1.nested.anonymous.ex;

public class Ex0Main {

    private static void hello(String name) {
        System.out.println("프로그램 시작");
        System.out.println("Hello " + name);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        String[] input = {"Java", "Spring"};

        for (int i = 0; i < input.length; i++) {
            hello(input[i]);
        }
    }
}