//Project 4 (Priority Queue (minheap))
//Name: Sifat Hasan
//ID: 202887233
//Date: 11/30/2022
//Project Description: This project performs add and remove operations
//on a minheap. The output represents a minheap.
//Program Description: This program houses the minheap operations.
//All methods that are called in the main program are from this class.

import java.util.Arrays;
public class Heap211 {
    //declaring array (to be used as minheap) & size
    private int[] data;
    private int size;

    Heap211() {
        //initialize declared variables
        data = new int[10];
        size = 0;
    }

    public void add(int val) {
        //double the length of array if array is full
        if(size + 1 >= data.length) {
            data = Arrays.copyOf(data,data.length*2);
        }

        //add element to end of array
        data[size+1] = val;

        //bubble up
        int index = size + 1;
        boolean found = false;
        while(!found && hasParent(index)) {
            int parent = parent(index);
            if(data[index] < data[parent]) {
                swap(data,index,parent);
                index = parent(index);
            } else {
                found = true;
            }
        }

        //increment size (since we are adding element)
        size++;
    }

    public int remove() {
        //set result as peek value (value being removed)
        int result = peek();

        //move last element to the root and decrement size
        data[1] = data[size];
        size--;

        //bubble down
        int index = 1;
        boolean found = false;
        while(!found && hasLeftChild(index)) {
            int left = leftChild(index);
            int right = rightChild(index);
            int child = left;
            if(hasRightChild(index) && data[right] < data[left]) child = right;
            if(data[index] > data[child]) {
                swap(data,index,child);
                index = child;
            } else {
                found = true;
            }
        }

        //return peeked value
        return result;
    }

    //toString representation of minheap (for main program)
    @Override
    public String toString() {
        String result = "[";
        if(!isEmpty()) {
            result += data[1];
            for(int i = 2; i <= size; i++) {
                result += ", " + data[i];
            }
        }
        result += "]";
        return result;
    }

    //returns if minheap is empty or not
    public boolean isEmpty() {
        return size == 0;
    }

    //swap 2 elements within array a
    private void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    //returns root
    private int peek() {
        return data[1];
    }

    //returns index's parent (as an index)
    private int parent(int index) {
        return index / 2;
    }

    //returns index's left child (as an index)
    private int leftChild(int index) {
        return index * 2;
    }

    //returns index's right child (as an index)
    private int rightChild(int index) {
        return index * 2 + 1;
    }

    //returns if index has parent
    private boolean hasParent(int index) {
        return index > 1;
    }

    //returns if index has left child
    private boolean hasLeftChild(int index) {
        return leftChild(index) <= size;
    }

    //returns if index has right child
    private boolean hasRightChild(int index) {
        return rightChild(index) <= size;
    }
}
