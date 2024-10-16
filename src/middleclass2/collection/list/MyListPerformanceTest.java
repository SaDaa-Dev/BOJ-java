package middleclass2.collection.list;

public class MyListPerformanceTest {
    public static void main(String[] args) {
        int size = 50_000;
        System.out.println("====MyArrayList 추가====");
        addFirst(new MyArrayList<>(), size);
        addMid(new MyArrayList<>(), size); // 찾는 데 O(1), 데이터 추가(밀기) O(N)
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        addLast(arrayList, size); // 찾기, 추가 O(1)

        int loop = 10000;
        System.out.println("==MyArrayList 조회==");
        getIndex(arrayList, loop, 0);
        getIndex(arrayList, loop, size / 2);
        getIndex(arrayList, loop, size - 1);

        System.out.println("====MyLinkedList 추가====");
        addFirst(new MyLinkedList<>(), size);
        addMid(new MyLinkedList<>(), size); // 찾는 데 O(N), 추가 O(1)
        addLast(new MyLinkedList<>(), size); // 찾기 O(N), 추가 (1)

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        System.out.println("==MyArrayList 조회==");
        getIndex(linkedList, loop, 0);
        getIndex(linkedList, loop, size / 2);
        getIndex(linkedList, loop, size - 1);
    }

    private static void addFirst(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("앞에 추가 - 크기 : " + size + ", 계산 시간 " + (endTime - startTime) + "ms");
    }
    private static void addMid(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i / 2, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("평균 추가 - 크기 : " + size + ", 계산 시간 " + (endTime - startTime) + "ms");
    }

    private static void addLast(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("평균 추가 - 크기 : " + size + ", 계산 시간 " + (endTime - startTime) + "ms");
    }

    private static void getIndex(MyList<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("index : " + index + ", 반복 " + loop + ", 계산 시간 : " + (endTime - startTime) + "ms");

    }
}
