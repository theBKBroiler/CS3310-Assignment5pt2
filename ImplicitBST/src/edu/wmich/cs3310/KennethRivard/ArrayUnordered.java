package edu.wmich.cs3310.KennethRivard;

import java.util.ArrayList;

/**
 * Created by bk on 11/29/16.
 */
public class ArrayUnordered<T> extends CustomArrayList<T> {

    public ArrayUnordered() {
        super();
    }//end ArrayUnordered constructor

    //create empty list
    public ArrayUnordered(int capacity){
        super(capacity);
    }//end ArrayUnordered constructor

    //add elements to the rear of the array
    public void addToRear(MyData element) {
        if(size() == list.length){
            expandCapacity();
        }//end if
        list[rear] = element;
        rear++;
    }//end addToRear


}//end class ArrayUnordered
