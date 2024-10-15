package middleclass2.collection.link;

public class NodeMain3 {
    public static void main(String[] args) {
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");

        printAll(first);

        // 마지막 노드 조회하기
        Node lastNode = getLastNode(first);
        System.out.println("lastNode = " + lastNode);

        // 특정 index의 노드 조회하기
        System.out.println("idx 노드 조회하기");
        int idx = 2;
        Node idx2Node = getNode(first, idx);
        System.out.println("idx2Node = " + idx2Node.item);

        // 데이터 추가하기
        System.out.println("데이터 추가하기");
        add(first, "D");


    }

    private static void add(Node node, String param) {
        Node lastNode = getLastNode(node);
        lastNode.next = new Node(param);
    }

    private static Node getNode(Node node, int idx) {
        Node x = node;
        for (int i = 0; i < idx; i++) {
            x = x.next;
        }
        return x;
    }

    private static Node getLastNode(Node node) {
        Node x = node;
        while (x.next != null) {
            x = x.next;
        }

        return x;
    }


    private static void printAll(Node node) {
        Node x = node;
        while (x != null) {
            System.out.println(x.item);
            x = x.next;
        }
    }
}
