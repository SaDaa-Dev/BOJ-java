package middleclass2.collection.list;

public class BatchProcessorMain {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        BatchProcessor processor = new BatchProcessor(list);
        processor.logic(100_000);
    }
}
