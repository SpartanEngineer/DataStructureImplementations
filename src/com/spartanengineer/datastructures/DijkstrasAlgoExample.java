package com.spartanengineer.datastructures;

import java.util.Map;
import java.util.HashMap;

public class DijkstrasAlgoExample {

    private class Node<U> {
        public U data;
        public Map<Node<U>, Integer> edges;
            
        public Node(U data) {
            this.data = data;
            edges = new HashMap<Node<U>, Integer>();
        }
    }
    
    public DijkstrasAlgoExample() {
        //TODO: create graph here
        Node<Integer> n0 = new Node<Integer>(0);
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n2 = new Node<Integer>(2);
        Node<Integer> n3 = new Node<Integer>(3);
        Node<Integer> n4 = new Node<Integer>(4);
        Node<Integer> n5 = new Node<Integer>(5);
        Node<Integer> n6 = new Node<Integer>(6);
    }

    public int getShortestPath(Node start, Node end) {
        //TODO: implement dijkstras algorithm here
        return -1;
    }
}
