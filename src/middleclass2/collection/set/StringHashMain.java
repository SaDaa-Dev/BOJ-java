package middleclass2.collection.set;

public class StringHashMain {
    static final int CAPACITY = 10;
    public static void main(String[] args) {
        char charA = 'A';
        char charB = 'B';


        int hashCodeA = hashCode("A");
        int hashIndex = hashIndex(hashCodeA);
        System.out.println(hashIndex);
    }

    static int hashCode(String str) {
        char[] charArray = str.toCharArray();
        int sum = 0;
        for (char c : charArray) {
            sum += (int) c;
        }
        return sum;
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }
}
