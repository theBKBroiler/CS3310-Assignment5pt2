package edu.wmich.cs3310.KennethRivard;

/**
 * Created by bk on 11/29/16.
 */
public class CustomArrayList<T> {
    protected final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;
    protected int rear;
    protected MyData[] list;

    public CustomArrayList() {
        rear = 0;
        list = (MyData[])(new Object[DEFAULT_CAPACITY]);
    }//end CustomArrayList

    public CustomArrayList(int capacity) {
        rear = 0;
        list = (MyData[])(new Object[capacity]);
    }//end CustomArrayList initializer

    public int size() {
        return rear;
    }//end size

    protected void expandCapacity() {
        MyData[] larger = (MyData[])(new Object[list.length*2]);

        for(int i = 0; i < list.length; i++) {
            larger[i] = list[i];
        }//end for
        list = larger;
    }//end expandCapacity

}//end class CustomArrayList
