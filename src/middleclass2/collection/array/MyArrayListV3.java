package middleclass2.collection.array;

import java.util.Arrays;

public class MyArrayListV3<E> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elementData;
    private int size = 0;

    public MyArrayListV3() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV3(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(E e) {
        // 코드 추가
        if (size == elementData.length) {
            grow();
        }

        elementData[size] = e;
        size++;
    }

    public void add(int index, E e) {
        // 코드 추가
        if (size == elementData.length) {
            grow();
        }
        shiftRightFrom(index);

        elementData[size] = e;
        size++;
    }

    // 요소의 마지막부토 index까지 오른쪽으로 밀기
    public void shiftRightFrom(int idx) {
        for (int i = size; i > idx; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    public E remove(int idx) {
        E oldValue = get(idx);
        shiftLeftFrom(idx);

        size--;
        elementData[size] = null;
        return oldValue;
    }

    private void shiftLeftFrom(int idx) {
        for (int i = idx; i < size - 1 ; i++) {
            elementData[i] = elementData[i + 1];
        }

    }

    public void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;

        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @SuppressWarnings("unchecked")
    public E get(int idx) {
        return (E) elementData[idx];
    }

    public E set(int idx, Object element) {
        E oldValue = get(idx);
        elementData[idx] = element;
        return oldValue;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }

        return -1;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) +
                "size = " + size + ", capacity = " + elementData.length;
    }
}
