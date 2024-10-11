package middleclass1.lang.string.chaining;

public class MethodCainingMain1 {
    public static void main(String[] args) {
        ValueAdder adder = new ValueAdder();
        /*
        ValueAdder adder1 = adder.add(1);
        ValueAdder adder2 = adder.add(2);
        ValueAdder adder3 = adder.add(3);
        */

        int result = adder.add(1).add(2).add(3).getValue();
        System.out.println("result = " + result);
    }
}
