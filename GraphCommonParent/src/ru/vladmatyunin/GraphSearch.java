package ru.vladmatyunin;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vlad on 14.09.2017.
 */
public class GraphSearch {

    static Node findCommonParent(Node root, Node firstNode, Node secondNode) {
        List<Node> startPath = new LinkedList<>();
        startPath.add(root);
        List<Node> pathToFirstNode = findNodePath(root, firstNode, startPath);
        List<Node> pathToSecondNode = findNodePath(root, secondNode, startPath);
        return findCommonParent(pathToFirstNode, pathToSecondNode);
    }

    private static List<Node> findNodePath(Node root, Node target, List<Node> path){
        if (root.getFirstChild()==target){
            return appendNode(path, root.getFirstChild());
        }
        if (root.getSecondChild()==target){
            return appendNode(path, root.getSecondChild());
        }
        List<Node> firstBranch = goDeeper(root.getFirstChild(), target, path);
        List<Node> secondBranch = goDeeper(root.getSecondChild(), target, path);
        return firstBranch!=null?firstBranch:secondBranch;
    }

    private static List<Node> goDeeper(Node child, Node target, List<Node> path){
        if (child != null){
            return findNodePath(child, target, appendNode(path, child));
        }
        return null;
    }

    private static List<Node> appendNode(List<Node> nodes, Node newNode){
        List<Node> newPath = new LinkedList<>(nodes);
        newPath.add(newNode);
        return newPath;
    }

    private static Node findCommonParent(List<Node> path1, List<Node> path2){
        for (Node node1: path1){
            if (path2.contains(node1)){
                return node1;
            }
        }
        return null;
    }
}
