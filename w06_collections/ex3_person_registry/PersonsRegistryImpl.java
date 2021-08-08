package teme.w06_collections.ex3_person_registry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class PersonsRegistryImpl implements PersonsRegistry {
    public Map<Integer, String> mapRegister = new HashMap<>(0);
    Set<Person> listRegister = new HashSet<>();

    @Override
    public void register(Person p) {
        mapRegister.put(p.getCnp(), p.getName());
        listRegister.add(p);
    }

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

    @Override
    public int count() {
        return listRegister.size();
    }

    @Override
    public Set<Integer> cnps() {

        return mapRegister.keySet();
    }

    @Override
    public Set<String> uniqueNames() {
        Set<String> names = new HashSet<>(mapRegister.values());

        return names;
    }

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

    @Override
    public Set<Person> findByName(String name) {
        Set<Person> person = new HashSet<>();
        for (Person waldo : listRegister) {
            if (waldo.getName().toLowerCase().equals(name.toLowerCase())) {
                person.add(waldo);
            }
        }
        return person;
    }

    @Override
    public double averageAge() {
        double totalAges = 0;
        int count = 0;
        if (listRegister.isEmpty()) {
            return 0;
        }
        for (Person waldo : listRegister
        ) {
            totalAges = totalAges + waldo.getAge();
            count++;
        }
        return totalAges / count;
    }

    @Override
    public double adultsPercentage() {
        if (listRegister.isEmpty()) {
            return 0;
        }
        double adults = 0;
        for (Person waldo : listRegister
        ) {
            if (waldo.getAge() >= 18) {
                adults++;
            }

        }
        return adults * 100 / listRegister.size();
    }

    @Override
    public double adultsWhoVotedPercentage() {
        double voted = 0;
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


        return voted / adults * 100;
    }


}
