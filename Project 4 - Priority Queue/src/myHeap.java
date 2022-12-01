//Project 4 (Priority Queue (minheap))
//Name: Sifat Hasan
//ID: 202887233
//Date: 11/30/2022
//Project Description: This project performs add and remove operations
//on a minheap. The output represents a minheap.
//Program Description: This program is the main program, where everything is
//being tested. This is where the output is produced.

import java.util.Random;

public class myHeap {
    public static void main(String[] args) {
        //30 tests
        int howManyTests = 30;

        //new objects
        Random random = new Random();
        Heap211 heap = new Heap211();

        //iterate through # of tests
        for(int test = 1; test <= howManyTests; test++) {
            //randomize from 0-2
            int action = random.nextInt(3);

            //higher chance to add than remove
            if(action <= 1) { //add
                //Generate a node (random number, 0-49) to add
                int node = random.nextInt(50);
                //add element to the heap
                heap.add(node);
                //print current heap
                System.out.println(test + " Add " + node + ": " + heap);
            }

            else if(action == 2) { //remove
                //check if heap is empty
                if(heap.isEmpty()) {} //skip action
                else {
                    //remove min from the heap
                    int rem = heap.remove();
                    //print current heap
                    System.out.println(test + " Remove " + rem + ": " + heap);
                }
            }
        }
    }
}