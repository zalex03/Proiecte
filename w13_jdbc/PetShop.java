package teme.w13_jdbc;
//

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PetShop {

    static ArrayList<Persons> persons;

    public static void main(String[] args) throws SQLException {
        /*
        checkCsv();
        DDL.dropTablePersons();
        DDL.dropTablePets();
        DDL.createPersonTable();
        DDL.createPetsTable();
        DDL.createPetType();
        DAO.deleteAllPersons();
            DAO.deleteAllPets();
        Persons.loadFromCsvFile("C:\\Users\\pc\\IdeaProjects\\teme_alex_zaharia\\src\\main\\java\\teme\\w13_jdbc\\persoane.csv.txt");
        Pets.loadFromCsvFile("C:\\Users\\pc\\IdeaProjects\\teme_alex_zaharia\\src\\main\\java\\teme\\w13_jdbc\\Pet.csv.txt");
        //DAO.getAllPets();
        PetType.loadFromCsvFile("C:\\Users\\pc\\IdeaProjects\\teme_alex_zaharia\\src\\main\\java\\teme\\w13_jdbc\\petType.csv.txt");
        */
        DAO.getAllPetType();
        System.out.println(DAO.getByType(1));
    }


    // check csv files
    public static void checkCsv() {
        File pet = new File("C:\\Users\\pc\\IdeaProjects\\teme_alex_zaharia\\src\\main\\java\\W13_JDBC\\Pet.csv.txt");
        File person = new File("C:\\Users\\pc\\IdeaProjects\\teme_alex_zaharia\\src\\main\\java\\W13_JDBC\\persoane.csv.txt");
        File petType = new File("C:\\Users\\pc\\IdeaProjects\\teme_alex_zaharia\\src\\main\\java\\W13_JDBC\\petType.csv.txt");
        System.out.println("Does person file exist ? " + person.exists());
        System.out.println("Does pet file exist ? " + pet.exists());
        System.out.println("Does pet file exist ? " + petType.exists());
    }
}

//Connection
class DbManager {
    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:test.db");
    }
}

//Table creation for persons, pets and pettype
class DDL {

    static void createPersonTable() throws SQLException {

        String sql = "CREATE TABLE if not exists PERSONS (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FIRST_NAME VARCHAR(100) NOT NULL," +
                "Last_NAME VARCHAR(100) NOT NULL," +
                "AGE INTEGER NOT NUll," +
                "GENDER VARCHAR(1) NOT NULL " +
                ")";

        try (Connection conn = DbManager.getConnection()) {
            Statement st = conn.createStatement();
            st.execute(sql);
        }
    }

    static void dropTablePersons() throws SQLException {
        String sql = "DROP TABLE IF EXISTS PERSONS;";

        try (Connection conn = DbManager.getConnection()) {
            Statement st = conn.createStatement();
            st.execute(sql);
        }
    }

    static void createPetsTable() throws SQLException {

        String sql = "CREATE TABLE if not exists PETS (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TYPE_ID INTEGER ," +
                "NAME VARCHAR(100) NOT NULL," +
                "BIRTH_DATE DATE  NOT NULL," +
                "GENDER VARCHAR(20) NOT NULL, " +
                "PERSON_ID INTEGER" +
                ")";

        try (Connection conn = DbManager.getConnection()) {
            Statement st = conn.createStatement();
            st.execute(sql);
        }
    }

    static void dropTablePets() throws SQLException {
        String sql = "DROP TABLE IF EXISTS PETS;";

        try (Connection conn = DbManager.getConnection()) {
            Statement st = conn.createStatement();
            st.execute(sql);
        }
    }

    static void createPetType() throws SQLException {

        String sql = "CREATE TABLE if not exists PET_TYPE (" +
                "ID INTEGER PRIMARY KEY NOT NULL," +
                "DESCRIPTION VARCHAR(100) NOT NULL" +
                ")";

      /*  id int not null
          description varchar(50) not null*/

        try (Connection conn = DbManager.getConnection()) {
            Statement st = conn.createStatement();
            st.execute(sql);
        }
    }

    static void dropTablePetType() throws SQLException {
        String sql = "DROP TABLE IF EXISTS PET_TYPE;";

        try (Connection conn = DbManager.getConnection()) {
            Statement st = conn.createStatement();
            st.execute(sql);
        }
    }
}

class DAO {

    public static Pets getByType(int id) throws SQLException {
        try (Connection conn = DbManager.getConnection();
             PreparedStatement pst = conn.prepareStatement("SELECT * FROM PETS where TYPE_ID =?")) {

            pst.setInt(1, id);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {
                    return new Pets(
                            rs.getInt("ID"),
                            rs.getInt("TYPE_ID"),
                            rs.getString("NAME"),
                            rs.getDate("BIRTH_DATE"),
                            rs.getString("GENDER"),
                            rs.getInt("PERSON_ID"));
                }
            }

            return null;
        }
    }

    public static void insertPerson(Persons person) throws SQLException {

        String sql = "insert into PERSONS (FIRST_NAME,LAST_NAME, AGE, GENDER) values(?,?,?,?)";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, person.getFirst_name());
            pst.setString(2, person.getLast_name());
            pst.setInt(3, person.getAge());
            pst.setString(3, person.getGender());
            pst.execute();
        }
    }

    public static void insertPET(Pets pet) throws SQLException {
        //id,type_id,name, birth_date, gender,person_id
        String sql = "insert into PETS (id,type_id,name,birth_date,gender,person_id) values(?,?,?,?,?,?)";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, pet.getId());
            pst.setInt(2, pet.getType_id());
            pst.setString(3, pet.getName());
            pst.setDate(4, new java.sql.Date(pet.getBirth_date().getTime()));
            pst.setString(5, pet.getGender());
            pst.setInt(6, pet.getPerson_id());
            pst.execute();
        }
    }

    public static void insertPetType(PetType petType) throws SQLException {

        String sql = "insert into PET_TYPE(ID,DESCRIPTION) values(?,?)";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, petType.getId());
            pst.setString(2, petType.getDescription());

            pst.execute();
        }
    }


    public static void getAllPersons() throws SQLException {

        try (Connection conn = DbManager.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("select * from PERSONS order by Last_NAME")) {


            while (rs.next()) {

                int id = rs.getInt("ID");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                int age = rs.getInt("AGE");
                String gender = rs.getString("GENDER");

                Persons person = new Persons(id, firstName, lastName, id, gender);


                System.out.println(person);
            }

        }
    }

    public static void getAllPets() throws SQLException {

        try (Connection conn = DbManager.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("select * from PETS order by NAME")) {


            while (rs.next()) {
                //id,type_id,name, birth_date, gender,person_id
                int id = rs.getInt("ID");
                int type_id = rs.getInt("type_id");
                String name = rs.getString("name");
                Date date = rs.getDate("birth_date");
                String gender = rs.getString("GENDER");
                int person_id = rs.getInt("person_id");

                Pets pets = new Pets(id, type_id, name, date, gender, person_id);


                System.out.println(pets);
            }

        }
    }

    public static void getAllPetType() throws SQLException {

        try (Connection conn = DbManager.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("select * from PET_TYPE order by ID")) {


            while (rs.next()) {

                int id = rs.getInt("ID");
                String description = rs.getString("DESCRIPTION");
                PetType petType = new PetType(id, description);


                System.out.println(petType);
            }

        }
    }

    public static void deleteAllPersons() throws SQLException {
        try (Connection conn = DbManager.getConnection();
             Statement st = conn.createStatement()) {

            st.execute("delete from Persons");
        }
    }

    public static void deleteAllPets() throws SQLException {
        try (Connection conn = DbManager.getConnection();
             Statement st = conn.createStatement()) {

            st.execute("delete from PETS");
        }
    }

    public static void deleteAllPetType() throws SQLException {
        try (Connection conn = DbManager.getConnection();
             Statement st = conn.createStatement()) {

            st.execute("delete from PET_TYPE");
        }
    }
}

class Persons {
    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private String gender;

    public Persons(int id, String first_name, String last_name, int age, String gender) {

        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    //Load from file, convertFromLine, Insert into tables
    static Persons convertFromLine(String line) {
        String[] parts = line.split(" ");
        return new Persons(
                Integer.parseInt(parts[0].trim()),
                parts[1].trim(),
                parts[2].trim(),
                Integer.parseInt(parts[3].trim()),
                parts[4].trim());
    }

    static void loadFromCsvFile(String fileName) {
        String sql = "insert into PERSONS (ID,FIRST_NAME,LAST_NAME, AGE, GENDER) values(?,?,?,?,?)";
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    try (Connection conn = DbManager.getConnection();
                         PreparedStatement pst = conn.prepareStatement(sql)) {
                        pst.setInt(1, convertFromLine(line).getId());
                        pst.setString(2, convertFromLine(line).getFirst_name());
                        pst.setString(3, convertFromLine(line).getLast_name());
                        pst.setInt(4, convertFromLine(line).getAge());
                        pst.setString(5, convertFromLine(line).getGender());
                        pst.execute();
                    }
                } catch (Exception e) {
                    System.err.println("skipped invalid line: '" + line + "', error was: " + e);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found, error: " + e);
        }

    }


}

class Pets {

    private int id;
    private int type_id;
    private String name;
    private Date birth_date;
    private String gender;
    private int person_id;


    public Pets(int id, int type_id, String name, Date birth_date, String gender, int person_id) {
        this.id = id;
        this.type_id = type_id;
        this.name = name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.person_id = person_id;
    }

    public int getId() {
        return id;
    }

    public int getType_id() {
        return type_id;
    }

    public String getName() {
        return name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public String getGender() {
        return gender;
    }

    public int getPerson_id() {
        return person_id;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "id=" + id +
                ", type_id=" + type_id +
                ", name='" + name + '\'' +
                ", birth_date=" + birth_date +
                ", gender='" + gender + '\'' +
                ", person_id=" + person_id +
                '}';
    }

    //Load from file, convertFromLine, Insert into tables
    static Pets convertFromLine(String line) throws ParseException {
        String[] parts = line.split(" ");
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter1.parse(parts[3].trim());
        return new Pets(
                Integer.parseInt(parts[0].trim()),
                Integer.parseInt(parts[1].trim()),
                parts[2].trim(),
                date,
                parts[4].trim(),
                0);
    }

    static void loadFromCsvFile(String fileName) {
        String sql = "insert into PETS (ID,TYPE_ID,NAME, BIRTH_DATE, GENDER) values(?,?,?,?,?)";
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    try (Connection conn = DbManager.getConnection();
                         PreparedStatement pst = conn.prepareStatement(sql)) {
                        pst.setInt(1, convertFromLine(line).getId());
                        pst.setInt(2, convertFromLine(line).getType_id());
                        pst.setString(3, convertFromLine(line).getName());
                        pst.setDate(4, new java.sql.Date(convertFromLine(line).getBirth_date().getTime()));
                        pst.setString(5, convertFromLine(line).getGender());
                        pst.execute();
                    }
                } catch (Exception e) {
                    System.err.println("skipped invalid line: '" + line + "', error was: " + e);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found, error: " + e);
        }
    }
}

class PetType {
    private int id;
    private String description;

    public PetType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "PetType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    //Load from file, convertFromLine, Insert into tables
    static PetType convertFromLine(String line) {
        String[] parts = line.split(" ");
        return new PetType(
                Integer.parseInt(parts[0].trim()),
                parts[1].trim());
    }

    static void loadFromCsvFile(String fileName) {
        String sql = "insert into PET_TYPE (ID,DESCRIPTION) values(?,?)";
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    try (Connection conn = DbManager.getConnection();
                         PreparedStatement pst = conn.prepareStatement(sql)) {
                        pst.setInt(1, convertFromLine(line).getId());
                        pst.setString(2, convertFromLine(line).getDescription());
                        pst.execute();
                    }
                } catch (Exception e) {
                    System.err.println("skipped invalid line: '" + line + "', error was: " + e);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found, error: " + e);
        }
    }

}
