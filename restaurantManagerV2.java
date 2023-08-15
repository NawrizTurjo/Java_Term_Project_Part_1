import java.util.ArrayList;
import java.util.List;

public class restaurantManagerV2 {
    private String name;
    private List<restaurant> restaurants;
    // private List<category> categories;
    // private List<String> allCaterories;
    private List<String> AllRestCategories;
    private List<food> foods;

    restaurantManagerV2() {
        this.name = "";
        this.restaurants = new ArrayList<>();
        // this.categories = new ArrayList<>();
        // this.allCaterories = new ArrayList<>();
        this.foods = new ArrayList<>();
        this.AllRestCategories = new ArrayList<>();
    }

    restaurantManagerV2(String name) {
        this.name = name;
        this.restaurants = new ArrayList<>();
        // this.categories = new ArrayList<>();
        // this.allCaterories = new ArrayList<>();
        this.foods = new ArrayList<>();
        this.AllRestCategories = new ArrayList<>();

    }

    // restaurantManagerV2(String name, List<restaurant> restaurants) {
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
    public void searchRestaurantByName(String name) {
        boolean isFound = false;
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getName().toUpperCase().equals(name.toUpperCase())) {
                isFound = true;
                restaurants.get(i).showDetails();
                break;
            }
        }
        if (!isFound) {
            System.out.println("No such restaurant with this name");
        }
    }

    public void searchRestaurantByScore(double low, double high) {
        boolean isFound = false;
        for (int i = 0; i < restaurants.size(); i++) {
            double score = restaurants.get(i).getScore();
            if (score >= low && score <= high) {
                isFound = true;
                restaurants.get(i).showDetails();
            }
        }
        if (!isFound) {
            System.out.println("No such restaurant with this socre range");
        }
    }

    public void searchRestaurantByCategory(String category) {
        boolean isFound = false;
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
                isFound = true;
                restaurants.get(i).showDetails();
            }
        }
        if (!isFound) {
            System.out.println("No such restaurant with this category");
        }
    }

    public void searchRestaurantByPrice(String price) {
        boolean isFound = false;
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getPrice().equals(price)) {
                isFound = true;
                restaurants.get(i).showDetails();
            }
        }
        if (!isFound) {
            System.out.println("No such restaurant with this price");
        }
    }

    public void searchRestaurantByZip(String Zip) {
        boolean isFound = false;
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getZipCode().equals(Zip)) {
                isFound = true;
                restaurants.get(i).showDetails();
            }
        }
        if (!isFound) {
            System.out.println("No such restaurant with this Zip Code");
        }
    }

    public void searchRestaurantByDiffCategory() {
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
            System.out.println(i+": ");
            for (restaurant j : restaurants) {
                if (j.isCategory(i)) {
                    System.out.println(j.getName() + ", ");
                }
            }
        }
    }

    // Option 2
    public void searchFoodByName(String name) {
        boolean isFound = false;
        // System.out.println(foods.size());
        // for (int i = 0; i < foods.size(); i++) {
        // if (foods.get(i).getFoodName().toUpperCase().equals(name.toUpperCase())) {
        // isFound = true;
        // foods.get(i).showDetails();
        // }
        // }
        for (food i : foods) {
            if (i.getFoodName().toUpperCase().equals(name.toUpperCase())) {
                isFound = true;
                i.showDetails();
            }
        }
        if (!isFound) {
            System.out.println("No such food item with this name");
        }
    }

    public restaurant getRestaurant(String name) {
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getName().toUpperCase().equals(name.toUpperCase())) {
                return restaurants.get(i);
            }
        }
        return null;
    }

    public void searchFoodByRestaurant(String foodName, String restaurantName) {
        boolean isFound = false;
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
            isFound = true;
            res.getmenu().get(index).showDetails();
        }
        if (!isFound) {
            System.out.println("No such food item with this name on the menu of this restaurant");
        }
    }

    public void searchFoodByCategory(String category) {
        boolean isFound = false;
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
                isFound = true;
                i.showDetails();
            }
        }
        if (!isFound) {
            System.out.println("No such food item with this category");
        }
    }

    public void searchFoodByCategoryRes(String category, String restaurant) {
        boolean isFound = false;
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
                isFound = true;
                i.showDetails();
            }
        }
        if (!isFound) {
            System.out.println("No such food item with this category on the menu of this restaurant");
        }
    }

    public void searchFoodByPrice(double low, double high) {
        boolean isFound = false;
        for (food i : foods) {
            double price = i.getPrice();
            if (low <= price && high >= price) {
                isFound = true;
                i.showDetails();
            }
        }
        if (!isFound) {
            System.out.println("No such food item with this category on the menu of this restaurant");
        }
    }

    public void searchFoodByPriceRes(double low, double high, String restaurant) {
        boolean isFound = false;
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
                isFound = true;
                i.showDetails();
            }
        }
        if (!isFound) {
            System.out.println("No such food item with this category on the menu of this restaurant");
        }
    }

    public void costliestFood(String restaurant) {
        boolean isFound = false;
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getName().toUpperCase().equals(restaurant.toUpperCase())) {
                isFound = true;
                restaurants.get(i).displayCosliestFood();
            }
        }
        if (!isFound) {
            System.out.println("No such restaurant exists");
        }
    }

    public void displayTotalFood() {
        for (restaurant i : restaurants) {
            System.out.println(i.getName() + ": " + i.getTotalFood());
        }
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

    public void addRestaurant(int id, String name, double score, String price, String zip, List<String> cat) {
        boolean isValid = isRestaurantValid(name);
        if (isValid) {
            restaurants.add(new restaurant(id, name, score, price, zip, cat));
            for (String i : cat) {
                if (!isCat(i)) {
                    AllRestCategories.add(i);
                    // categories.add(new category(i));
                }
            }
            System.out.println("Restaurant added successfully");
        } else {
            System.out.println("Restaurant of the same name is already added");
        }
    }

    public void addRestaurant(restaurant r) {
        boolean isValid = isRestaurantValid(r.getName());
        if (isValid) {
            restaurants.add(new restaurant(r.getId(), r.getName(), r.getScore(), r.getPrice(), r.getZipCode(), r.getCategory()));
            for (String i : r.getCategory()) {
                if (!isCat(i)) {
                    AllRestCategories.add(i);
                    // categories.add(new category(i));
                }
            }
            System.out.println("Restaurant added successfully");
        } else {
            System.out.println("Restaurant of the same name is already added");
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

    public void addFood(String r, food f) {
        if (isFoodValid(f)) {
            foods.add(f);
            for (restaurant i : restaurants) {
                if (i.getName().toUpperCase().equals(r.toUpperCase())) {
                    System.out.println(i.getName());
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
            System.out.println("Food added successfully");
        } else {
            System.out.println("This food is already added.");
        }
    }

    public void addFood(food f) {
        if (isFoodValid(f)) {
            foods.add(f);
            for (restaurant i : restaurants) {
                if (i.getId()==f.getRestaurantId()) {
                    System.out.println(i.getName());
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
            System.out.println("Food added successfully");
        } else {
            System.out.println("This food is already added.");
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
