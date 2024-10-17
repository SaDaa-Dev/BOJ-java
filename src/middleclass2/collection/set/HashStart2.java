package middleclass2.collection.set;

public class HashStart2 {
    public static void main(String[] args) {
        Integer[] inputArray = new Integer[10];
        inputArray[1] = 1;
        inputArray[2] = 2;
        inputArray[5] = 5;
        inputArray[8] = 8;

        int searchValue = 8;
        Integer result = inputArray[searchValue];
        System.out.println("result = " + result);
    }
}
