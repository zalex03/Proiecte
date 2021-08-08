package teme.w04_oop1;

import java.util.Arrays;

public class MyArrayList {

    private static int[] values = new int[0];
    private static int[] newArr = new int[0];


    public static void main(String[] args) {
        // test to add//
        add(5);
        add(6);
        add(7);
        add(3);
        add(4);
        add(1);
        add(7);
        add(6);
        add(2);
        // test to remove //
        remove();
        remove();
        //test to get element
        get(3);
        get(5);
        //test for count
        size();
        //test to add new element
        newElement(4, 3);
        //test to remove element;
        removeElement(3);
    }


    private static void add(int newValue) {
        System.out.println("This is the original array" + Arrays.toString(values));
        newArr = Arrays.copyOf(values, newArr.length + 1);
        newArr[newArr.length - 1] = newValue;
        values = Arrays.copyOf(newArr, newArr.length);
        System.out.println("This is the array with the added element" + Arrays.toString(values) + "its length is " + values.length);
    }


    private static void remove() {
        if (values.length == 0) {
            System.out.println("There is nothing else to remove");
            return;
        }
        values = Arrays.copyOf(values, values.length - 1);
        System.out.println(Arrays.toString(values));
    }


    private static int size() {
        int count = values.length;
        System.out.println("The number of element in array is " + count);
        return count;
    }

    private static int get(int index) {
        if (index > values.length) {
            System.out.println("Cannot get element,index out of bounds");
            return -1;
        }
        int element = values[index];
        System.out.println("The element at position " + index + "is " + element);
        return element;
    }

    private static void newElement(int element, int index) {
        if (index > values.length) {
            System.out.println("The index you have specified does not exist ");
            return;
        }
        int[] temp = new int[values.length + 1];
        for (int i = 0; i < index; i++) {
            temp[i] = values[i];
            temp[index] = element;
        }
        for (int i = index + 1; i < temp.length; i++) {
            temp[i] = values[i - 1];
        }
        values = Arrays.copyOf(temp, temp.length);
        System.out.println("The new array with added element at index: " + index + " " + Arrays.toString(temp));
    }

    private static void removeElement(int index) {
        if (index > values.length) {
            System.out.println("Not posible");
            return;
        }
        int j = 0;
        int[] temp = new int[values.length - 1];
        for (int i = 0; i < values.length; i++) {
            if (index == i) {
                i++;
            }
            temp[j] = values[i];
            j++;
        }

        System.out.println("The new array with removing element from : " + index + "  " + Arrays.toString(temp));
    }
}
