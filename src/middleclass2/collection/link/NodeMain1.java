package middleclass2.collection.link;

public class NodeMain1 {
    public static void main(String[] args) {
        Node first = new Node("A");
        first.next = new Node("B");

        first.next.next = new Node("C");

        Node x = first;
        while (x != null) {
            System.out.println(x.item);
            x = x.next;
        }
    }
}
