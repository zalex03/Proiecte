package teme.w06_collections.ex1_building_registry;

import java.util.*;

class BuildingRegistry {

    static int categoriesCount(List<Building> bs) {
        Set<Category> categ = new HashSet<>();
        for (Building build : bs
        ) {
            categ.add(build.getCategory());

        }
        System.out.println("Categories" + categ);
        //TODO
        return categ.size();
    }

    static Collection<String> neighborhoodsList(List<Building> bs) {
        Set<String> list = new TreeSet<>();
        for (Building build : bs) {
            list.add(build.getNeighborhood());
        }
        //TODO
        return new ArrayList<>(list);
    }

    static double averagePriceForOneCategory(List<Building> bs, Category cat) {
        //TODO
        double sum = 0;
        int count = 0;

        for (Building b : bs) {
            //if (b.getCategory().equals(selectedCategory)) { //using equals() for enums - ok, but not really needed
            if (b.getCategory() == cat) { //'==' works ok for enums
                sum += b.getPrice();
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }

    static Map<Category, Double> averagePricePerCategory(List<Building> bs) {
        Map<Category, Double> map = new HashMap<>();
        for (Category cat : Category.values()) {
            double avgPrice = averagePriceForOneCategory(bs, cat);
            map.put(cat, avgPrice);
        }
        return map;//TODO
    }

    static Map<String, Double> averagePricePerNeighborhood(List<Building> bs) {
        Map<String, Integer> pricesMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Building b : bs) {

            //update prices map
            int oldSum = pricesMap.getOrDefault(b.getNeighborhood(), 0);
            pricesMap.put(b.getNeighborhood(), oldSum + b.getPrice());

            //update count map
            int oldCount = countMap.getOrDefault(b.getNeighborhood(), 0);
            countMap.put(b.getNeighborhood(), oldCount + 1);
        }

        System.out.println("prices map: " + pricesMap);
        System.out.println("count map: " + countMap);


        Map<String, Double> avgMap = new HashMap<>();
        for (String cat : pricesMap.keySet()) {
            double sum = pricesMap.get(cat);
            int count = countMap.get(cat);

            double avg = sum / count;

            avgMap.put(cat, avg);
        }
        //
        System.out.println("final map with average price pe categ: " + avgMap);
        return avgMap;
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {

        List<Building> buildings = Arrays.asList(
                new Building(Category.valueOf("OFFICE"), 10, "tudor"),
                new Building(Category.valueOf("OFFICE"), 40, "centru"),
                new Building(Category.valueOf("OFFICE"), 20, "pacurari"),
                new Building(Category.valueOf("RESIDENTIAL"), 15, "pacurari"),
                new Building(Category.valueOf("HOSPITAL"), 35, "pacurari"),
                new Building(Category.valueOf("HOSPITAL"), 30, "copou"));

        System.out.println("Actual categories: " + categoriesCount(buildings));
        System.out.println("Actual neighborhoods: " + neighborhoodsList(buildings));

        System.out.println("Average price for OFFICE category: " + averagePriceForOneCategory(buildings, Category.valueOf("OFFICE")));
        System.out.println("Average price for RELIGIOUS category: " + averagePriceForOneCategory(buildings, Category.valueOf("RELIGIOUS")));

        System.out.println("Average price per category: " + averagePricePerCategory(buildings));
        System.out.println("Average price per neighborhood: " + averagePricePerNeighborhood(buildings));
    }
}