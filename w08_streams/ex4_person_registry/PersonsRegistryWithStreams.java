package teme.w08_streams.ex4_person_registry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class PersonsRegistryWithStreams implements PersonsRegistry {
    public Map<Integer, String> mapRegister = new HashMap<>(0);
    Set<Person> listRegister = new HashSet<>();

    /**
     * Ok not to use streams for this one
     */
    @Override
    public void register(Person p) {
        mapRegister.put(p.getCnp(), p.getName());
        listRegister.add(p);
    }

    /**
     * Ok not to use streams for this one
     */
    @Override
    public void unregister(int cnp) {
        mapRegister.remove(cnp);
        for (Person waldo : listRegister) {
            if (waldo.getCnp() == cnp) {
                listRegister.remove(waldo);
                break;
            }
        }
    }

    /**
     * Ok not to use streams for this one
     */
    @Override
    public int count() {

        return listRegister.size();
    }

    /**
     * Ok not to use streams for this one
     */
    @Override
    public Person findByCnp(int cnp) {
        for (Person waldo : listRegister
        ) {
            if (waldo.getCnp() == cnp) {
                return waldo;
            }

        }
        return null;
    }


    /**
     * Ok not to use streams for this one
     */
    @Override
    public Set<Integer> cnps() {
        //TODO
        return mapRegister.keySet();
    }

    //--- These should be done using streams operations! ---//

    @Override
    public Set<String> uniqueNames() {
        // Set<String> names = new HashSet<>(mapRegister.values());

        return listRegister.stream().map(Person::getName).collect(Collectors.toSet());
    }

    @Override
    public Set<Person> findByName(String name) {
        Set<Person> person = new HashSet<>();
        /*for (Person waldo : listRegister) {
            if (waldo.getName().toLowerCase().equals(name.toLowerCase())) {
                person.add(waldo);
            }
        }*/
        //mai frumos cu stream
        return listRegister.stream().
                filter(b -> b.getName().toLowerCase().equals(name.toLowerCase())).
                collect(Collectors.toSet());
    }

    @Override
    public double averageAge() {
        /*double totalAges = 0;
        int count = 0;
        if (listRegister.isEmpty()) {
            return 0;
        }
        for (Person waldo : listRegister
        ) {
            totalAges = totalAges + waldo.getAge();
            count++;
        }*/

        return listRegister.stream().mapToDouble(Person::getAge).average().orElse(0.0);
    }

    @Override
    public double adultsPercentage() {
     /*   if (listRegister.isEmpty()) {
            return 0;
        }
        double adults = 0;
        for (Person waldo : listRegister
        ) {
            if (waldo.getAge() >= 18) {
                adults++;
            }

        }*/

        return listRegister.isEmpty() ?
                0.0 :
                (double) listRegister.stream().
                        filter(b -> b.getAge() > 18).
                        mapToDouble(Person::getAge).
                        count() * 100 / listRegister.size();
    }


    @Override
    public double adultsWhoVotedPercentage() {
      /*  double voted = 0;
        double adults = 0;
        if (listRegister.isEmpty()) {
            return 0;
        }
        for (Person waldo : listRegister
        ) {
            if (waldo.getAge() >= 18) {
                adults++;
                if (waldo.isHasVoted()) {
                    voted++;
                }
            }


        }
*/
        Double voted = (double) listRegister.stream().
                filter(Person::isHasVoted).count();
        return listRegister.isEmpty() ?
                0.0 :
                voted / listRegister.stream().filter(b -> b.getAge() > 18).count() * 100;
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {
        PersonsRegistryWithStreams reg = new PersonsRegistryWithStreams();
        reg.register(new Person(1234, "Ion", 14, false));
        reg.register(new Person(2233, "Ana", 12, false));
        reg.register(new Person(2678, "Ana", 3, false));
        reg.register(new Person(1235, "Costel", 21, false));
        reg.register(new Person(2367, "Maria", 33, true));

        System.out.println("Registered persons count: " + reg.count());
        System.out.println("Average age: " + reg.averageAge());
        System.out.println("Adults percentage: " + reg.adultsPercentage());
        System.out.println("Voters percentage (vs all adults): " + reg.adultsWhoVotedPercentage());

        System.out.println("Unique names: " + reg.uniqueNames());
        System.out.println("Persons named 'ana': " + reg.findByName("ana"));
        System.out.println("Person with cnp 2678: " + reg.findByCnp(2678));
        System.out.println("Person with cnp 1000: " + reg.findByCnp(1000));

        reg.unregister(2678);
        System.out.println("Registered persons count: " + reg.count());
        System.out.println("Person with cnp 2678: " + reg.findByCnp(2678));
    }
}
