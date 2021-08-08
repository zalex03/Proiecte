package teme.w04_oop1.ex6_arraylist;

class MyArrayList {

    //TODO!

    int size() {
        return -1;
    }

    int get(int index) {
        return -1;
    }

    void set(int index, int value) {

    }


    void add(int newValue) {

    }

    void add(int index, int value) {

    }


    void remove() {

    }

    void remove(int index) {

    }


    //some other nice methods:
    int indexOf(int value) {
        return -1;
    }

    boolean contains(int value) {
        return false;
    }

    @Override
    public String toString() {
        return "MyArrayList{ ??? }";
    }

    /**
     * Some manual tests...
     */
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        System.out.println(list); //[]

        list.add(3);
        list.add(4);
        list.add(5);
        list.add(7);
        System.out.println(list); //[3, 4, 5, 7]

        list.remove();
        System.out.println(list); //[3, 4, 5]

        System.out.println("indexOf(3): " + list.indexOf(3)); //0
        System.out.println("indexOf(5): " + list.indexOf(5)); //2

        list.add(0, 8); //[8, 3, 4, 5]
        System.out.println(list);

        list.add(3, 9); //[8, 3, 4, 9, 5]
        System.out.println(list);

        list.remove(0); //[3, 4, 9, 5]
        System.out.println(list);

        list.remove(3); //[3, 4, 9]
        System.out.println(list);
    }
}
