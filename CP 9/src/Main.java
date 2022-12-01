import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    static int howManyTests = 5;
    static int howManyData = 60000; //modify this size to fit your computer processing speed

    //declare arraylist and linkedlist using string as data type
    static ArrayList<String> AL = new ArrayList<>();
    static LinkedList<String> LL = new LinkedList<>();

    //to generate random index to remove
    static Random rand = new Random();

    public static void initialization() {
        AL.clear();
        LL.clear();

        for(int i = 0; i < howManyData; i++) {
            //add string value of i to ArrayList and LinkedList
            String n = Integer.toString(i);
            AL.add(n);
            LL.add(n);
        }
    }

    public static void remove() {
        double TimeRemove_ArrayList = 0.0;
        double TimeRemove_LinkedList = 0.0;
        double startTime, endTime;

        for(int i = 0; i < howManyData/2; i++) { //removing half of the data
            //generate index to remove
            //index must be within size of ArrayList or LinkedList
            //remember that both lists are always the same size
            int index2remove = rand.nextInt(AL.size());

            //remove index2remove from ArrayList
            //accumulate the processing time of this 'remove' operation
            //eg) TimeRemove_ArrayList += ...
            startTime = System.currentTimeMillis();
            AL.remove(index2remove);
            endTime = System.currentTimeMillis();
            TimeRemove_ArrayList += endTime - startTime;

            //remove index2remove from LinkedList
            //accumulate the processing time of this 'remove' operation
            //eg) TimeRemove_LinkedList += ...
            startTime = System.currentTimeMillis();
            LL.remove(index2remove);
            endTime = System.currentTimeMillis();
            TimeRemove_LinkedList += endTime - startTime;
        } //end for

        //print out the result as shown in the sample log

        System.out.printf("%nRemoved: %s %n", howManyData/2);
        System.out.printf("ArrayList: %.3f sec %n",TimeRemove_ArrayList/1000);
        System.out.printf("LinkedList: %.3f sec %n",TimeRemove_LinkedList/1000);
        System.out.printf("ArrayList's processing time is %.1f%% of LinkedList",TimeRemove_ArrayList/TimeRemove_LinkedList*100);
    }

    public static void main(String[] args) {
        for(int i = 1; i <= howManyTests; i++) {
            initialization();
            System.out.printf("\nTest: " + i);
            remove();
        }
    }
}