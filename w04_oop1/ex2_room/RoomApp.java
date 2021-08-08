package teme.w04_oop1.ex2_room;

import teme.w04_oop1.ex1_person.Person;

public class RoomApp {
    //just for manual testing of the Room class
    public static void main(String[] args) {
        Room room = new Room(10);
        room.enter(new Person("Ion", 1997, "blond"));
        room.enter(new Person("Ion", 1997, "blond"));
        room.enter(new Person("alex", 199, "chel"));
        Person p1 = new Person("Alex", 1988, "brown");
        System.out.println(room.getCount());
        System.out.println();
        System.out.println(room.isPresent("Ion"));
        System.out.println(room.indexOf("alex"));

        //room.printAll();
        //...
    }
}

//TODO: define your Room class here (or in a separate file in same package)
//(using in it the existing Person class, done for previous exercise and placed in separate package)

