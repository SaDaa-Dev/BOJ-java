package middleclass1.nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV5 {

    public interface Print {
        void print();
    }

    public static void hello(Print printer) {
        System.out.println("프로그램 시작");
        printer.print();
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        hello(() -> {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);
        });
        hello(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
            }
        });
    }
}
