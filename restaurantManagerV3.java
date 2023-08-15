import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class restaurantManagerV3 {
    private String name;
    private List<restaurant> restaurants;
    // private List<category> categories;
    // private List<String> allCaterories;
    private List<String> AllRestCategories;
    private List<food> foods;

    restaurantManagerV3() {
        this.name = "";
        this.restaurants = new ArrayList<>();
        // this.categories = new ArrayList<>();
        // this.allCaterories = new ArrayList<>();
        this.foods = new ArrayList<>();
        this.AllRestCategories = new ArrayList<>();
    }

    restaurantManagerV3(String name) {
        this.name = name;
        this.restaurants = new ArrayList<>();
        // this.categories = new ArrayList<>();
        // this.allCaterories = new ArrayList<>();
        this.foods = new ArrayList<>();
        this.AllRestCategories = new ArrayList<>();

    }

    // restaurantManagerV3(String name, List<restaurant> restaurants) {
    // this.name = name;
    // this.restaurants = restaurants;
    // }

    public String getName() {
        return this.name;
    }

    public List<restaurant> getRestaurants() {
        return this.restaurants;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRestaurants(List<restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    // Option 1
    public List<restaurant> searchRestaurantByName(String name) {
        // boolean isFound = false;
        List<restaurant> res = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getName().toUpperCase().equals(name.toUpperCase())) {
                // isFound = true;
                // restaurants.get(i).showDetails();
                res.add(restaurants.get(i));
                break;
            }
        }
        return res;
        // if (!isFound) {
        // System.out.println("No such restaurant with this name");
        // }
    }

    public List<restaurant> searchRestaurantByScore(double low, double high) {
        // boolean isFound = false;
        List<restaurant> res = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            double score = restaurants.get(i).getScore();
            if (score >= low && score <= high) {
                // isFound = true;
                // restaurants.get(i).showDetails();
                res.add(restaurants.get(i));
            }
        }
        return res;
        // if (!isFound) {
        // System.out.println("No such restaurant with this socre range");
        // }
    }

    public List<restaurant> searchRestaurantByCategory(String category) {
        // boolean isFound = false;
        List<restaurant> res = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            // for (int j = 0; j < restaurants.get(i).getCategory().size(); j++) {
            // if
            // (category.toUpperCase().equals(restaurants.get(i).getCategory().get(j).toUpperCase()))
            // {
            // isFound = true;
            // restaurants.get(i).showDetails();
            // }
            // }
            if (restaurants.get(i).isCategory(category)) {
                // isFound = true;
                // restaurants.get(i).showDetails();
                res.add(restaurants.get(i));
            }
        }
        return res;
        // if (!isFound) {
        // System.out.println("No such restaurant with this category");
        // }
    }

    public List<restaurant> searchRestaurantByPrice(String price) {
        // boolean isFound = false;
        List<restaurant> res = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getPrice().equals(price)) {
                // isFound = true;
                // restaurants.get(i).showDetails();
                res.add(restaurants.get(i));
            }
        }
        return res;
        // if (!isFound) {
        // System.out.println("No such restaurant with this price");
        // }
    }

    public List<restaurant> searchRestaurantByZip(String Zip) {
        // boolean isFound = false;
        List<restaurant> res = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getZipCode().equals(Zip)) {
                // isFound = true;
                // restaurants.get(i).showDetails();
                res.add(restaurants.get(i));
            }
        }
        return res;
        // if (!isFound) {
        // System.out.println("No such restaurant with this Zip Code");
        // }
    }

    // public void searchRestaurantByDiffCategory() {
    // // for (int i = 0; i < allCaterories.size(); i++) {
    // // System.out.print(allCaterories.get(i) + ": ");
    // // for (int j = 0; j < restaurants.size(); j++) {
    // // for (int k = 0; k < restaurants.get(j).getCategory().size(); k++) {
    // // if (restaurants.get(j).getCategory().get(k).equals(allCaterories.get(i)))
    // {
    // // System.out.print(restaurants.get(j).getName() + ",");
    // // }
    // // }
    // // }
    // // System.out.println();
    // // }

    // for (String i : AllRestCategories) {
    // System.out.println(i + ": ");
    // for (restaurant j : restaurants) {
    // if (j.isCategory(i)) {
    // System.out.println(j.getName() + ", ");
    // }
    // }
    // }
    // }

    public Map<String, String> searchRestaurantByDiffCategory() {
        Map<String, String> map = new HashMap<>();
        // for (int i = 0; i < allCaterories.size(); i++) {
        // System.out.print(allCaterories.get(i) + ": ");
        // for (int j = 0; j < restaurants.size(); j++) {
        // for (int k = 0; k < restaurants.get(j).getCategory().size(); k++) {
        // if (restaurants.get(j).getCategory().get(k).equals(allCaterories.get(i))) {
        // System.out.print(restaurants.get(j).getName() + ",");
        // }
        // }
        // }
        // System.out.println();
        // }

        for (String i : AllRestCategories) {
            // System.out.println(i + ": ");
            String resName = "";
            for (restaurant j : restaurants) {
                if (j.isCategory(i)) {
                    // System.out.println(j.getName() + ", ");
                    if (resName.equals("")) {
                        resName = j.getName();
                    } else {
                        // resName.join(",",j.getName());
                        resName += ", " + j.getName();
                    }
                }
            }
            map.put(i, resName);
        }
        return map;
    }

    // Option 2
    public List<food> searchFoodByName(String name) {
        // boolean isFound = false;
        List<food> f = new ArrayList<>();
        // System.out.println(foods.size());
        // for (int i = 0; i < foods.size(); i++) {
        // if (foods.get(i).getFoodName().toUpperCase().equals(name.toUpperCase())) {
        // isFound = true;
        // foods.get(i).showDetails();
        // }
        // }
        for (food i : foods) {
            if (i.getFoodName().toUpperCase().equals(name.toUpperCase())) {
                // isFound = true;
                // i.showDetails();
                f.add(i);
            }
        }
        return f;
        // if (!isFound) {
        // System.out.println("No such food item with this name");
        // }
    }

    public restaurant getRestaurant(String name) {
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getName().toUpperCase().equals(name.toUpperCase())) {
                return restaurants.get(i);
            }
        }
        return null;
    }

    public List<food> searchFoodByRestaurant(String foodName, String restaurantName) {
        // boolean isFound = false;
        List<food> f = new ArrayList<>();
        // for (int i = 0; i < restaurants.size(); i++) {
        // if
        // (restaurants.get(i).getName().toUpperCase().equals(restaurantName.toUpperCase()))
        // {
        // for (int j = 0; j < restaurants.get(i).getmenu().size(); j++) {
        // if (restaurants.get(i).getmenu().get(j).getFoodName().toUpperCase()
        // .equals(foodName.toUpperCase())) {
        // isFound = true;
        // restaurants.get(i).getmenu().get(j).showDetails();
        // }
        // }
        // }
        // }
        restaurant res = getRestaurant(restaurantName);
        int index = res.isFood(foodName);
        if (index != -1) {
            // isFound = true;
            // res.getmenu().get(index).showDetails();
            f.add(res.getmenu().get(index));
        }
        return f;
        // if (!isFound) {
        // System.out.println("No such food item with this name on the menu of this
        // restaurant");
        // }
    }

    public List<food> searchFoodByCategory(String category) {
        // boolean isFound = false;
        List<food> f = new ArrayList<>();
        // System.out.println(categories.size());
        // for (int i = 0; i < categories.size(); i++) {
        // System.out.println(categories.get(i).getName());
        // if (categories.get(i).getName().toUpperCase().equals(category.toUpperCase()))
        // {
        // isFound = true;
        // System.out.println();
        // categories.get(i).printFoods();
        // }
        // }
        for (food i : foods) {
            if (i.getCategory().toUpperCase().equals(category.toUpperCase())) {
                // isFound = true;
                // i.showDetails();
                f.add(i);
            }
        }
        return f;
        // if (!isFound) {
        // System.out.println("No such food item with this category");
        // }
    }

    public List<food> searchFoodByCategoryRes(String category, String restaurant) {
        // boolean isFound = false;
        List<food> f = new ArrayList<>();
        // for (int i = 0; i < restaurants.size(); i++) {
        // if
        // (restaurants.get(i).getName().toUpperCase().equals(restaurant.toUpperCase()))
        // {
        // for (int j = 0; j < restaurants.get(i).getmenu().size(); j++) {
        // if (restaurants.get(i).getmenu().get(j).getCategory().toUpperCase()
        // .equals(category.toUpperCase())) {
        // isFound = true;
        // restaurants.get(i).getmenu().get(j).showDetails();
        // }
        // }
        // }
        // }
        int Id = getResId(restaurant);
        for (food i : foods) {
            if (i.getRestaurantId() == Id && i.getCategory().toUpperCase().equals(category.toUpperCase())) {
                // isFound = true;
                // i.showDetails();
                f.add(i);
            }
        }
        return f;
        // if (!isFound) {
        // System.out.println("No such food item with this category on the menu of this
        // restaurant");
        // }
    }

    public List<food> searchFoodByPrice(double low, double high) {
        // boolean isFound = false;
        List<food> f = new ArrayList<>();
        for (food i : foods) {
            double price = i.getPrice();
            if (low <= price && high >= price) {
                // isFound = true;
                // i.showDetails();
                f.add(i);
            }
        }
        return f;
        // if (!isFound) {
        // System.out.println("No such food item with this category on the menu of this
        // restaurant");
        // }
    }

    public List<food> searchFoodByPriceRes(double low, double high, String restaurant) {
        // boolean isFound = false;
        List<food> f = new ArrayList<>();
        // for (int i = 0; i < foods.size(); i++) {
        // double price = foods.get(i).getPrice();
        // if (low <= price && high >= price) {
        // isFound = true;
        // foods.get(i).showDetails();
        // }
        // }
        int Id = getResId(restaurant);
        for (food i : foods) {
            double price = i.getPrice();
            if (i.getRestaurantId() == Id && low <= price && high >= price) {
                // isFound = true;
                // i.showDetails();
                f.add(i);
            }
        }
        return f;
        // if (!isFound) {
        // System.out.println("No such food item with this category on the menu of this
        // restaurant");
        // }
    }

    // public void costliestFood(String restaurant) {
    // boolean isFound = false;
    // for (int i = 0; i < restaurants.size(); i++) {
    // if
    // (restaurants.get(i).getName().toUpperCase().equals(restaurant.toUpperCase()))
    // {
    // isFound = true;
    // restaurants.get(i).displayCosliestFood();
    // }
    // }
    // if (!isFound) {
    // System.out.println("No such restaurant exists");
    // }
    // }

    public List<food> costliestFood(String restaurant) {
        List<food> f = new ArrayList<>();
        restaurant r = getRestaurant(restaurant);
        List<food> menu = r.getmenu();
        double costliest = -1;
        for (var i : menu) {
            if (i.getPrice() > costliest) {
                costliest = i.getPrice();
            }
        }

        for (var i : menu) {
            if (i.getPrice() == costliest) {
                f.add(i);
            }
        }
        return f;
    }

    // public void displayTotalFood() {
    // for (restaurant i : restaurants) {
    // System.out.println(i.getName() + ": " + i.getTotalFood());
    // }
    // }

    public Map<String, Integer> displayTotalFood() {
        Map<String, Integer> map = new HashMap<>();
        for (restaurant i : restaurants) {
            // System.out.println(i.getName() + ": " + i.getTotalFood());
            map.put(i.getName(), i.getTotalFood());
        }
        return map;
    }

    boolean isCat(String Cat) {
        for (String i : AllRestCategories) {
            if (i.toUpperCase().equals(Cat.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    // Option 3

    public boolean isRestaurantValid(String name) {
        for (restaurant i : restaurants) {
            if (i.getName().toUpperCase().equals(name.toUpperCase())) {
                return false;
            }
        }
        return true;
    }

    // public void addRestaurant(int id, String name, double score, String price, String zip, List<String> cat) {
    //     boolean isValid = isRestaurantValid(name);
    //     if (isValid) {
    //         restaurants.add(new restaurant(id, name, score, price, zip, cat));
    //         for (String i : cat) {
    //             if (!isCat(i)) {
    //                 AllRestCategories.add(i);
    //                 // categories.add(new category(i));
    //             }
    //         }
    //         System.out.println("Restaurant added successfully");
    //     } else {
    //         System.out.println("Restaurant of the same name is already added");
    //     }
    // }

    public int addRestaurant(restaurant r) {
        boolean isValid = isRestaurantValid(r.getName());
        if (isValid) {
            restaurants.add(new restaurant(r.getId(), r.getName(), r.getScore(), r.getPrice(), r.getZipCode(),
                    r.getCategory()));
            for (String i : r.getCategory()) {
                if (!isCat(i)) {
                    AllRestCategories.add(i);
                    // categories.add(new category(i));
                }
            }
            // System.out.println("Restaurant added successfully");
            return 1;
        } else {
            // System.out.println("Restaurant of the same name is already added");
            return -1;
        }
    }

    // Option 4
    public boolean isFoodValid(food f) {
        for (food i : foods) {
            if (i.isEqual(f)) {
                return false;
            }
        }
        return true;
    }

    public int addFood(String r, food f) {
        if (isFoodValid(f)) {
            foods.add(f);
            // for (restaurant i : restaurants) {
            // if (i.getName().toUpperCase().equals(r.toUpperCase())) {
            // System.out.println(i.getName());
            // i.addFood(f);
            // break;
            // }
            // }
            restaurant res = getRestaurant(r);
            res.addFood(f);
            // for (category i : categories) {
            // if (i.getName().toUpperCase().equals(f.getCategory().toUpperCase())) {
            // i.addFood(f);
            // break;
            // }
            // }
            // System.out.println("Food added successfully");
            return 1;
        } else {
            // System.out.println("This food is already added.");
            return -1;
        }
    }

    public int addFood(food f) {
        if (isFoodValid(f)) {
            foods.add(f);
            for (restaurant i : restaurants) {
                if (i.getId() == f.getRestaurantId()) {
                    // System.out.println(i.getName());
                    i.addFood(f);
                    break;
                }
            }
            // for (category i : categories) {
            // if (i.getName().toUpperCase().equals(f.getCategory().toUpperCase())) {
            // i.addFood(f);
            // break;
            // }
            // }
            // System.out.println("Food added successfully");
            return 1;
        } else {
            // System.out.println("This food is already added.");
            return -1;
        }
    }

    public int getResId(String resName) {
        int id = -1;
        for (restaurant i : restaurants) {
            if (i.getName().toUpperCase().equals(resName.toUpperCase())) {
                return i.getId();
            }
        }
        return id;
    }
}
