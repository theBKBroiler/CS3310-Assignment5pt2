package edu.wmich.cs3310.KennethRivard;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by Kenneth Rivard on 11/24/16.
 */
public class ImplicitBST<T extends Comparable> {

    private MyData[] tree;
    int treeSize;
    int lastIndexUsed;
    protected int height;
    protected int maxIndex;
    private final int capacity = 10000;

    //sets root to be the first [0] element
    public ImplicitBST(MyData element) {
        treeSize = 1;
        //tree = (MyData[]) new Object[capacity];
        //set root to tree[0]
        height = 1;
        maxIndex = 0;
        tree[0] = element;
    }//end ImplicitBST root constructor

    public ImplicitBST() {
        super();
        height = 0;
        maxIndex = -1;
    }

    //expand array size if necessary
    protected void expantCapacity() {
        MyData[] temp = (MyData[]) new Object[tree.length*2];
        for(int i = 0; i < tree.length; i++) {
            temp[i] = tree[i];
        }//end for
        tree=temp;
    }//end expandCapacity

    //check if arrray is empty
    public boolean isEmpty() {
        return (treeSize ==0);
    }//end isEmpty

    //check array size
    public int size() {
        return treeSize;
    }//end size

    /*================================================================================================================*/

    public int leftChild(int i) {
        return((2*i)+1);
    }//end leftChild

    public int rightChild(int i) {
        return ((2*i)+1);
    }//end rightChild

    public int parent(int i){
        return ((i-1)/2);
    }//end parent

    public int root(){
        return 0;
    }

    /*===============================INSERTION - DELETION - SEARCHING=================================================*/

    //insert student data in implicit BST
    public void insert(MyData element){
        if(tree.length < maxIndex*2+3)
           expantCapacity();

        Comparable<T> tempElement = (Comparable<T>)element;

        if(isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        }//end if

        else {
            boolean added = false;
            int currentIndex = 0;

            while(!added) {
                if(tempElement.compareTo((T) tree[currentIndex]) < 0) {
                    //going left
                    if(tree[currentIndex*2+1] == null) {
                        tree[currentIndex*2+1] = element;
                        added = true;
                        if(currentIndex*2+1 > maxIndex)
                            maxIndex = currentIndex*2+1;
                    }//end if
                    else
                        currentIndex = currentIndex*2+1;

                }//end if

                else {
                    //going right
                    if(tree[currentIndex*2+2] == null) {
                        tree[currentIndex*2+2] = element;
                        added = true;
                        if(currentIndex*2+2 > maxIndex)
                            maxIndex = currentIndex*2+2;
                    }
                    else
                        currentIndex = currentIndex*2+2;
                }//end else
            }//end while
        }//end else

        height = (int)(Math.log(maxIndex + 1) / Math.log(2)) + 1;
        treeSize++;
    }//end insert()


    //delete student data based on student name
    public MyData delete(MyData element) {
        MyData result = null;
        boolean found = false;

        if(isEmpty()) {
            return result;
        }//end is empty

        for(int i = 0; (i < maxIndex) && !found; i++) {
            if((tree[i] != null) && element.equals(tree[i])) {
                found = true;
                result = tree[i];
                //replace(i);
                treeSize--;
            }//end if
        }//end for

        if(!found) {
            System.out.println("Element not found!");

            int temp = maxIndex;
            maxIndex = -1;
            for(int i = 0; i <= temp; i++) {
                if(tree[i] != null){
                    maxIndex = i;
                }//end if
            }//end for
        }//end if

        height = (int)(Math.log(maxIndex+1) / Math.log(2)) + 1;
        return result;
    }//end delete()

    //search for data based on student name
    public MyData search(MyData element) {
        MyData temp = null;
        boolean found = false;

        for(int i = 0; i < treeSize && !found; i++) {
            if(element.equals(tree[i])) {
                found = true;
                temp = tree[i];
            }//end if
        }//end for

        if(!found)
            System.out.println("Element not found!");
            return temp;
    }//end search()


    /*================================================================================================================*/

    //traverse tree in root, left, right order
    public void preorderTraversal(int node, ArrayUnordered<T> tempList) {
        if(node < tree.length) {
            if(tree[node] != null) {
                tempList.addToRear(tree[node]);
                preorderTraversal((node+1)*2-1,tempList);
                preorderTraversal((node+1)*(2+1)-1,tempList);
            }//end if
        }//end if
    }//end preorderTraversal

    //traverse tree in left, root, right order
    public void inorderTraversal(int node, ArrayUnordered<T> tempList) {
        if(node < tree.length) {
            if(tree[node] != null) {
                inorderTraversal((node+1)*2-1,tempList);
                tempList.addToRear(tree[node]);
                inorderTraversal((node+1)*(2+1)-1,tempList);
            }//end if
        }//end if
    }//end inorderTraversal

    //traverse tree in left, right, root order
    public void postorderTraversal(int node, ArrayUnordered<T> tempList) {
        if(node < tree.length) {
            if(tree[node] != null) {
                postorderTraversal((node+1)*2-1,tempList);
                postorderTraversal((node+1)*(2*+1)-1,tempList);
            }//end if
        }//end if
    }//end postorderTraversal




}//end class ImpliciBST
