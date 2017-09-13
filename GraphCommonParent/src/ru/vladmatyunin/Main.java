package ru.vladmatyunin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);

        root.setFirstChild(two);
        root.setSecondChild(three);
        three.setFirstChild(four);
        two.setFirstChild(five);

        two.setSecondChild(six);
        six.setFirstChild(seven);
        five.setFirstChild(eight);
        Node common = GraphSearch.findCommonParent(root, seven, eight);
        System.out.print(common.getValue());
    }
    private static Node GraphGenerator(){
//        Scanner scanner = new Scanner();
        Node root = new Node(1);
        root.setFirstChild(new Node(2));
        root.setSecondChild(new Node(3));
        return root;
    }

}
