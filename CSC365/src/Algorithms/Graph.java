package Algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class Graph {
    Collection<Node> nodes = new ArrayList<>();
    
    void buildSpanningTree(Node root){
        ArrayDeque<Node> deq = new ArrayDeque<>();
        clearParents();
        root.parent = root;
        System.out.println(root.parent.attribute + "-- " + root.attribute);
        deq.addLast(root);
        Node p;
        while((p = deq.pollFirst())!= null){
            for(Node d: p.links){
                if(d.parent == null){
                    d.parent = p;
                    deq.addLast(d);
                    System.out.println(d.parent.attribute + "-- " + d.attribute);
                }
            }
        }
    }

    public void makeSet(Node x){
        if(nodes.contains(x)){
            x.parent = x;
            x.size = 1;
        }
    }

    public Node find(Node x){
        if(x.parent != x){
            x.parent = find(x.parent);
            return x.parent;
        }else {
            return x;
        }
    }

    public Node find1(Node x){
        Node root = x;
        while(root.parent != root){
            root = root.parent;
        }
        while (x.parent != root){
            Node parent = x.parent;
            x.parent = root;
            x = parent;
        }
        return root;
    }

    public Node find2(Node x){
        while(x.parent != x ){
            x = x.parent;
            x.parent = x.parent.parent;
        }
        return x;
    }

    public Node find3(Node x){
        while (x.parent != x){
            x.parent = x.parent.parent;
            x = x.parent;
        }
        return x;
    }

    public Node union(Node x, Node y){
        //Replace nodes by roots
        x = find(x);
        y = find(y);
        if (x == y){
            return null;
        }
        if (x.size < y.size){
            Node temp = x;
            x= y;
            y = temp;
        }
        //Make x the new root
        y.parent = x;
        //Update the size of x
        x.size = x.size + y.size;
        return x;
    }

//    public Node union1(Node x, Node y){
//        x = find(x);
//        y = find(y);
//        if (x == y){
//          return null;  //x and y already in the same set
//        }
//
//        //If necessary, rename variables to ensure that
//        // x has rank at least as large as that of y
//        if(x.rank < y.rank){
//            Node temp = x;
//            x = y;
//            y = temp;
//        }
//
//        //make x the new root
//        y.parent = x;
//        // if necessary, increment the rank of x
//        if(x.rank = y.rank){
//            x.rank = x.rank + 1;
//        }
//    }

    
    void clearParents(){     //clearing parents without visiting them
        nodes.forEach(s -> {s.parent = null;});
    }

    public static void main(String[] args) {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        a.attribute = 1;
        b.attribute =2;
        c.attribute = 3;
        d.attribute = 4;
        e.attribute = 5;
        a.links.add(b);
        a.links.add(c);
        b.links.add(d);
        c.links.add(e);
        Graph graph = new Graph();
        graph.nodes = new ArrayList<>();
        graph.nodes.add(a);
        graph.nodes.add(b);
        graph.nodes.add(c);
        graph.nodes.add(d);
        graph.nodes.add(e);
        graph.buildSpanningTree(a);


    }
}
class Node{
    int attribute;
    int size;
    Collection<Node> links = new ArrayList<>();
    long mark;
    Node parent;
}
