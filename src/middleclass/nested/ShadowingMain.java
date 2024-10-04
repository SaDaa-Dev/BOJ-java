package middleclass.nested;

public class ShadowingMain {
    public int value = 1;
   class Inner {

        int value = 2;
        void go() {
            int value = 3;
            System.out.println("value = " + value);
            System.out.println("this.value = " + this.value);
            System.out.println("ShadowingMain.this = " + ShadowingMain.this.value);
        }

   }
    public static void main(String[] args) {
        ShadowingMain main = new ShadowingMain();
        Inner inner = main.new Inner();
        inner.go();
    }

}

