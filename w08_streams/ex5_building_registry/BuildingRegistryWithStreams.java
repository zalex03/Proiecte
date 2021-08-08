package teme.w08_streams.ex5_building_registry;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class BuildingRegistryWithStreams {

    static int categoriesCount(List<Building> bs) {
       /* Set<Category> categs = new HashSet<>();

        for (Building b : bs) {
            categs.add(b.getCategory());
        }
        System.out.println("used categories: " + categs);

        return categs.size();*/
        return (int) bs.stream().
                map(Building::getCategory).
                distinct().
                count();
    }

    static List<String> neighborhoodsList(List<Building> bs) {
       /* Set<String> namesSet = new TreeSet<>(); //using a TreeSet implementation to also have them sorted directly

        for (Building b : bs) {
            namesSet.add(b.getNeighborhood());
        }*/
        return bs.stream().
                map(Building::getNeighborhood).
                distinct().
                sorted().
                collect(Collectors.toList());
    }

    static double averagePriceForOneCategory(List<Building> bs, Category cat) {
      /*  double sum = 0;
        int count = 0;

        for (Building b : bs) {
            //if (b.getCategory().equals(selectedCategory)) { //using equals() for enums - ok, but not really needed
            if (b.getCategory() == cat) { //'==' works ok for enums
                sum += b.getPrice();
                count++;
            }
        }*/

        return bs.stream().
                filter(i -> i.getCategory().equals(cat)).
                mapToDouble(Building::getPrice).
                average().orElse(0.0);
    }

    static Map<Category, Double> averagePricePerCategory(List<Building> bs) {
        /*Map<BlogPostType, Double> averageLikesPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, averagingInt(BlogPost::getLikes)));*/

        //Map<Category, Double> averagePrice= bs.stream().collect(Collectors.groupingBy(Building::getCategory,averagePriceForOneCategory(Building::getPrice))

        //[Cristi] Erai aproape :) bazat pe exemplul tau de mai sus, cam asa venea, si merge
        return bs.stream()
                .collect(
                        Collectors.groupingBy(
                                Building::getCategory,
                                Collectors.averagingDouble(Building::getPrice)));
    }

    static Map<String, Double> averagePricePerNeighborhood(List<Building> bs) {
        //TODO
        return null;
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {

        List<Building> buildings = Arrays.asList(
                new Building(Category.OFFICE, 10, "tudor"),
                new Building(Category.OFFICE, 40, "centru"),
                new Building(Category.OFFICE, 20, "pacurari"),
                new Building(Category.RESIDENTIAL, 15, "pacurari"),
                new Building(Category.HOSPITAL, 35, "pacurari"),
                new Building(Category.HOSPITAL, 30, "copou"));

        System.out.println("Actual categories: " + categoriesCount(buildings));
        System.out.println("Actual neighborhoods: " + neighborhoodsList(buildings));

        System.out.println("Average price for OFFICE category: " + averagePriceForOneCategory(buildings, Category.OFFICE));
        System.out.println("Average price for RELIGIOUS category: " + averagePriceForOneCategory(buildings, Category.RELIGIOUS));

        System.out.println("Average price per category: " + averagePricePerCategory(buildings));
        System.out.println("Average price per neighborhood: " + averagePricePerNeighborhood(buildings));
    }
}
