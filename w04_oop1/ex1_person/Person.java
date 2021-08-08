package teme.w04_oop1.ex1_person;


public class Person {

    private String name;
    private int birthYear;
    private String hairColor;

    public String getName() {
        return name;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getHairColor() {
        return hairColor;
    }

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.hairColor = "brown";
    }

    public Person(String name, int birthYear, String hairColor) {
        this.name = name;
        this.birthYear = birthYear;
        this.hairColor = hairColor;

    }

    boolean isOlderThan(Person x) {
        boolean answer;

        if (this.birthYear < x.birthYear)
            answer = true;
        else
            answer = false;
        return answer;
    }

    int getAgeInYear(int year) {
        if (year - this.birthYear < 0) {
            return 0;
        }
        int yearsOld = year - this.birthYear;

        return yearsOld;
    }


    public String toString() {
        return name + " " + birthYear + " " + hairColor;
    }
}

