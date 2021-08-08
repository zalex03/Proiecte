package teme.w04_oop1.ex2_room;

import teme.w04_oop1.ex1_person.Person;

import java.util.Arrays;

public class Room {
    int capacity;
    Person[] arrPersons;
    int count = 0;
    int index = 0;

    //constructor for capacity and getter
    public Room(int capacity) {
        this.capacity = capacity;
        arrPersons = new Person[capacity];
    }

    final public int getCapacity() {
        return capacity;
    }
    //

    int getCount() {
        return count;
    }

    void enter(Person person) {

        if (count == 0) {
            arrPersons[count] = person;
            count++;

        }

        boolean present = isPresent(person.getName());
        if (getCount() == getCapacity()) {
            return;
        }

        if (present == false) {
            arrPersons[count] = person;
            count++;
        }


        System.out.println(Arrays.toString(arrPersons));
    }


    void printAll() {
        System.out.println("capacity :" + getCapacity() + "persons in room" + getCount());
        for (Person persoane : arrPersons) {
            System.out.println(persoane);
        }
    }

    boolean isPresent(String personName) {

        if (arrPersons[0] == null) {
            return false;
        }

        for (int i = 0; i <= getCount() - 1; i++) {
            if (count == capacity) {
                break;
            } else if (personName.equals(arrPersons[i].getName())) {
                return true;
            }

        }
        return false;
    }

    String getOldest() {
        if (arrPersons[0] == null) {
            return "";
        }

        for (int i = 0; i <= getCount() - 1; i++) {
            for (int j = i + 1; j <= getCount() - 1; j++) {
                if (arrPersons[i].getBirthYear() > arrPersons[j].getBirthYear()) {
                    Person temp = arrPersons[i];
                    arrPersons[i] = arrPersons[j];
                    arrPersons[j] = temp;
                }

            }
        }
        return "" + arrPersons[0].getName() + "(" + arrPersons[0].getBirthYear() + ")";
    }

    String[] getNames(String hairColor) {
        String[] namesArr = new String[getCapacity() - 1];
        int index = 0;
        for (Person person : arrPersons) {
            if (arrPersons[index] == null) {
                return new String[0];
            }
            if (person.getHairColor().equals(hairColor)) {
                namesArr[index] = person.getName();
                index++;
            }
        }


        String[] newArrOfNames = Arrays.copyOf(namesArr, index);
        return newArrOfNames;
    }


    // Stiu ca trebuia sa folosesc metodele indexOf si isPresent dar tot imi dadea eroare, am scris tot codul.Sorry!
    void exit(String personName) {
        boolean answer = false;
        System.out.println(Arrays.toString(arrPersons));
        if (personName.isEmpty()) {
            return;
        }
        for (int i = 0; i < getCount(); i++) {
            if (personName.equals(arrPersons[i].getName())) {
                System.out.println(personName);
                answer = true;
            }

        }
        if (answer == true) {
            int j = 0;
            Person[] temp = new Person[arrPersons.length - 1];
            for (int i = 0; i < arrPersons.length; i++) {
                if (arrPersons[i].getName() == personName) {
                    i++;
                    count--;

                }
                if (count == 0) {
                    arrPersons = Arrays.copyOf(temp, 0);
                    return;
                }
                temp[j] = arrPersons[i];
                j++;

            }
            arrPersons = Arrays.copyOf(temp, temp.length);
            System.out.println("This is the count  " + getCount());
            System.out.println("This is the array  " + Arrays.toString(arrPersons));
        }
    }

    int indexOf(String personName) {

        for (int i = 0; i <= getCount() - 1; i++) {
            if (count == capacity) {
                break;
            } else if (personName.equals(arrPersons[i].getName())) {
                return i;
            }

        }
        return arrPersons.length + 1;
    }
}

