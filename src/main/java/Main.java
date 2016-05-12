import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by alexandermiheev on 12.05.16.
 */
public class Main {

    public static void printRoutine(String message, long startTime, long finishTime) {
        System.out.println(message + (finishTime - startTime) / 1000000 + " ms");
    }

    public static void testingSequentialAdding(int length) {
        //Testing sequential adding
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        //Testing arrayList

        long startTime = System.nanoTime();
        for (int index = 0; index < length; index++) {
            arrayList.add(index);
        }
        long finishTime = System.nanoTime();
        printRoutine("Sequential adding into an ArrayList took ", startTime, finishTime);

        //Testing linkedList
        startTime = System.nanoTime();
        for (int index = 0; index < length; index++) {
            linkedList.add(index);
        }
        finishTime = System.nanoTime();
        printRoutine("Sequential adding into a LinkedList took ", startTime, finishTime);
    }

    public static int[] generatingAnIndexArray(int length) {
        Random random = new Random();
        int indexesToAdd[] = new int[length];

        for (int index = 1; index < length; index++) {
            indexesToAdd[index] = random.nextInt(index);
        }
        return indexesToAdd;
    }
    public static void testingRandomAdding(int length) {
        //Testing random adding
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        //Generating an array with indexes
        int indexesToAdd[] = generatingAnIndexArray(length);

        //Testing ArrayList
        long startTime = System.nanoTime();
        for (int index = 0; index < length; index++) {
            arrayList.add(indexesToAdd[index], index);
        }
        long finishTime = System.nanoTime();
        printRoutine("Random adding into an ArrayList took ", startTime, finishTime);

        //Testing LinkedList
        startTime = System.nanoTime();
        for (int index = 0; index < length; index++) {
            linkedList.add(indexesToAdd[index], index);
        }
        finishTime = System.nanoTime();
        printRoutine("Random adding into a LinkedList took ", startTime, finishTime);


    }

    public static void testingRandomGet(int length) {

        //Testing random getting
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        //Generating an array with indexes
        int indexesToGet[] = generatingAnIndexArray(length);

        //Filling lists with elements
        for (int index = 0; index < length; index++) {
            arrayList.add(index);
            linkedList.add(index);
        }

        //Testing array list
        long startTime = System.nanoTime();
        for (int i = 0; i < length; i++) {
            Integer tempValue = arrayList.get(indexesToGet[i]);
        }
        long finishTime = System.nanoTime();
        printRoutine("Random getting from an ArrayList took ", startTime, finishTime);

        startTime = System.nanoTime();
        for (int i = 0; i < length; i++) {
            Integer tempValue = linkedList.get(indexesToGet[i]);
        }
        finishTime = System.nanoTime();
        printRoutine("Random getting from a LinkedList took ", startTime, finishTime);



    }

    public static void testingIterator(int length) {
        //Testing Iterator
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();



        //Filling lists with elements
        for (int index = 0; index < length; index++) {
            arrayList.add(index);
            linkedList.add(index);
        }

        //Testing array list
        long startTime = System.nanoTime();
        for (Integer element: arrayList) {
            int someFancyVariableDoingNothing = element;
        }
        long finishTime = System.nanoTime();
        printRoutine("Iterating through an ArrayList took ", startTime, finishTime);

        startTime = System.nanoTime();
        for (Integer element: linkedList) {
            int someFancyVariableDoingNothing = element;
        }
        finishTime = System.nanoTime();
        printRoutine("Iterating through a LinkedList took ", startTime, finishTime);
    }

    public static void testingSorting(int length) {
        //Testing sort
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();



        //Filling lists with elements
        Random random = new Random();
        for (int index = 0; index < length; index++) {
            int tempElement = random.nextInt(2 * length) - length;
            arrayList.add(tempElement);
            linkedList.add(tempElement);
        }

        //Testing array list
        long startTime = System.nanoTime();
        Collections.sort(arrayList);
        long finishTime = System.nanoTime();
        printRoutine("Sorting an ArrayList took ", startTime, finishTime);

        //Testing linked list
        startTime = System.nanoTime();
        Collections.sort(linkedList);
        finishTime = System.nanoTime();
        printRoutine("Sorting a LinkedList took ", startTime, finishTime);


    }

    public static void testingRandomRemove(int length) {
        //Testing random remove
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        //Filling lists with elements
        for (int index = 0; index < 2 * length; index++) {
            arrayList.add(index);
            linkedList.add(index);
        }

        //Getting array with indexes to delete
        int[] indexesToRemove = generatingAnIndexArray(length);

        //Testing array list
        long startTime = System.nanoTime();
        for (int i = 0; i < indexesToRemove.length; i++) {
            arrayList.remove(indexesToRemove[i]);
        }
        long finishTime = System.nanoTime();
        printRoutine("Random removing from an ArrayList took ", startTime, finishTime);

        startTime = System.nanoTime();
        for (int i = 0; i < indexesToRemove.length; i++) {
            linkedList.remove(indexesToRemove[i]);
        }
        finishTime = System.nanoTime();
        printRoutine("Random removing from a LinkedList took ", startTime, finishTime);


    }

    public static void main(String[] args) {
        int size = 500 * 1000;
        testingSequentialAdding(size);
        testingRandomAdding(size);
        testingRandomGet(size);
        testingIterator(size);
        testingSorting(size);
        testingRandomRemove(size);

    }
}
