package Algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryVista {
    ArrayDeque<BinaryTreeNode> old = new ArrayDeque<>();
    ArrayDeque<BinaryTreeNode> deepest = new ArrayDeque<>();
    // Task 1: Function to insert a value into the binary tree
    public  BinaryTreeNode insert(BinaryTreeNode root, int value) {
        if(root==null){
            return new BinaryTreeNode(value);
        }
        if(root.data > value){
            root.left=insert(root.left,value);
        }else{
            root.right=insert(root.right,value);
        }
        return root;
    }


    // Task 1: Function to perform in-order traversal
    public  void inOrderTraversal(BinaryTreeNode root, List<Integer> result) {
        if(root == null){
            return;
        }
        if(!result.contains(root.data)){
            inOrderTraversal(root.left, result);
            result.add(root.data);
            inOrderTraversal(root.right,result);
        }
        return;

        // while(root!=null){
        //     root = root.left;
        //     if(root.left==null){
        //         result.add(root.data);
        //         root = root.right;
        //     }

        // }
    }


    //Task 2: Iterative function to perform pre-order traversal
    public  void preOrderTraversal(BinaryTreeNode root,List<Integer> result) {
        if(root == null){
            return;
        }
        if(!result.contains(root.data)){
            result.add(root.data);
            preOrderTraversal(root.left,result);
            preOrderTraversal(root.right,result);
        }
    }

    //Task 3: Iterative function to perform post-order traversal
    public  void postOrderTraversal(BinaryTreeNode root,List<Integer> result) {
        if(root == null){
            return;
        }
        postOrderTraversal(root.left,result);
        postOrderTraversal(root.right,result);
        result.add(root.data);

    }


    //Task 4: Function to delete a value from the binary tree
    public  BinaryTreeNode delete(BinaryTreeNode root, int value) {
        if(root == null){
            return root;
        }

        //if value is less than root then go left
        if(root.data > value){
            root.left = delete(root.left,value);
            return root;
        }else if(root.data<value){   //if value is more than root data then go right
            root.right = delete(root.right,value);
            return root;
        }

        //if value is equal to the root data
        //if value doesnot have left or right
            if(root.left == null && root.right == null){
                root = null;
            }else if (root.left == null){
                root = root.right;
            }else if(root.right == null){
                root = root.left;
            }else{
                BinaryTreeNode parent = root;
                BinaryTreeNode succ = root.right;
                while(succ.left!=null){
                    parent = succ;
                    succ = succ.left;
                }
                parent.left = succ.right;
                root.data = succ.data;
                return root;
            }
        return null;
    }

    // Task 4: Helper function to get the deepest node in the binary tree
    private  BinaryTreeNode getDeepestNode(BinaryTreeNode root) {
        int height = calculateHeight(root);
        int level = 0;
        if(root == null){
            return null;
        }
        BinaryTreeNode a = getDeepestNode(root.left);

   return null;
    }

    //Task 4: Helper function to delete the deepest node in the binary tree
    private  BinaryTreeNode deleteDeepest(BinaryTreeNode root, BinaryTreeNode deepestNode) {

        return null;
    }

    // Task 5: Function to search for a value in the binary tree
    public  boolean search(BinaryTreeNode root, int value) {
        if(root==null){
            return false;
        }
        boolean x = false;
        if(root.data == value){
            return true;
        }else if(value < root.data){
            x = search(root.left,value);
        }else{
            x = search(root.right, value);
        }
        return x;
    }

    //Task 6: Function to calculate the height of the binary tree
    public static int calculateHeight(BinaryTreeNode root) {
        if(root == null) return 0;
        int leftside = calculateHeight(root.left);
        int rightside = calculateHeight(root.right);
        return Math.max(leftside,rightside)+1;
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("Binary Tree Project");
        BinaryTreeNode a = new BinaryTreeNode(10);
        BinaryVista x = new BinaryVista();
        List<Integer> m = new ArrayList<>();
        x.insert(a,2);
        x.insert(a,15);
        x.insert(a,1);
        x.insert(a,50);
        x.insert(a,5);
        x.insert(a,12);
        x.insert(a,13);
        x.getDeepestNode(a);
        System.out.println(calculateHeight(a));
    }
}
