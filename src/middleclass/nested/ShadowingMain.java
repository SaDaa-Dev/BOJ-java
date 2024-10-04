package middleclass.nested;

public class ShadowingMain {
    private int value = 1;
   class Inner {

       public int value = 2;
        void go() {
            int value = 3;
            System.out.println("value = " + value);
            System.out.println("this.value = " + this.value);
            System.out.println("ShadowingMain.this = " + ShadowingMain.this.value);
        }

   }
    public static void main(String[] args) {
        ShadowingMain shadowingMain = new ShadowingMain();
        Inner inner = new Inner();
        inner.go();
    }

}
