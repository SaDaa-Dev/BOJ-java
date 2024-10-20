package middleclass2.collection.utils;

import java.util.*;

public class EmptyListMain {
    public static void main(String[] args) {
        // 빈 가변 리스트 생성
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        List<Object> list3 = Collections.emptyList(); // 자바 5
        List<Object> list4 = List.of(); // 자바 9

        System.out.println("list3.getClass() = " + list3.getClass());
        System.out.println("list4.getClass() = " + list4.getClass());

        // List.of(arr) arr를 돌면서 새로운 리스트 생성 **기본적으로 사용
        // Arrays.asList(arr) arr 참조값을 이어서 사용함
    }
}
