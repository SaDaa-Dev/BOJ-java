package programmers.level3.prac;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SellingToothbrush {

    private Map<String, String> parentMap = new HashMap<>();
    private Map<String, Integer> profitMap = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            parentMap.put(enroll[i], referral[i]);
            profitMap.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int profit = amount[i] * 100;
            forwardProfitToParent(sellerName, profit);
        }

        for (int i = 0; i < n; i++) {
            answer[i] = profitMap.get(enroll[i]);
        }

        return answer;
    }

    private void forwardProfitToParent(String name, int profit) {
        if (name.equals("-") || profit == 0) {
            return;
        }

        int commission = profit / 10;
        int myProfit = profit - commission;

        profitMap.put(name, profitMap.get(name) + myProfit);
        forwardProfitToParent(parentMap.get(name), commission);
    }

    public static void main(String[] args) {
        SellingToothbrush problem = new SellingToothbrush();
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(problem.solution(enroll, referral, seller, amount)));
    }
}


//private class Node {
//    String name;
//    int profit;
//
//    Node parent;
//    List<Node> children = new ArrayList<>();
//
//    public Node(String name) {
//        this.name = name;
//        this.profit = 0;
//    }
//
//    private void addChild(Node child) {
//        child.parent = this;
//        children.add(child);
//    }
//
//    private Node findNodeByName(String name) {
//        if (this.name.equals(name)) {
//            return this;
//        }
//
//        for (Node child : children) {
//            Node found = child.findNodeByName(name);
//            if (found != null) {
//                return found;
//            }
//        }
//
//        return null;
//    }
//
//    private void addProfit(int profit) {
//        if (this.parent == null) {
//            return;
//        }
//
//        int parentProfit = profit / 10;
//        int myProfit = profit - parentProfit;
//        this.profit += myProfit;
//        this.parent.addProfit(parentProfit);
//    }
//}

//    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
//        Node root = new Node("Center");
//
//        for (int i = 0; i < enroll.length; i++) {
//            String name = enroll[i];
//            String parent = referral[i];
//
//            if (parent.equals("-")) {
//                root.addChild(new Node(name));
//            } else {
//                Node parentNode = root.findNodeByName(parent);
//                if (!(parentNode == null)) {
//                    parentNode.addChild(new Node(name));
//                }
//            }
//        }
//
//
//        for (int i = 0; i < seller.length; i++) {
//            String sellerName = seller[i];
//            int sellAmount = amount[i];
//            Node sellPeople = root.findNodeByName(sellerName);
//            sellPeople.addProfit(sellAmount * 100);
//        }
//
//        int[] answer = new int[enroll.length];
//        for (int i = 0; i < enroll.length; i++) {
//            Node member = root.findNodeByName(enroll[i]);
//            answer[i] = member != null ? member.profit : 0;
//        }
//
//        return answer;
//    }