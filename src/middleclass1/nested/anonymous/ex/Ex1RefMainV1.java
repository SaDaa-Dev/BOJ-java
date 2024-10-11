package middleclass1.nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV1 {

    public interface Print {
        void print();
    }

    public static class Dice implements Print {
        @Override
        public void print() {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);
        }
    }

    public static class Sum implements Print {
        @Override
        public void print() {
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
            }
        }
    }

    public static void hello(Print printer) {
        System.out.println("프로그램 시작");
        printer.print();
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        hello(new Dice());
        hello(new Sum());
    }
}
