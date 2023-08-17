import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// import java.lang.*;

public class restaurantAppV2 {
    public static void showFood(List<food> f) {
        for (var i : f) {
            System.out.println("Restaurant Id: " + i.getRestaurantId());
            System.out.println("Category: " + i.getCategory());
            System.out.println("Food Name: " + i.getFoodName());
            System.out.println("Price: " + i.getPrice());
            System.out.println();
        }
    }

    public static void showRestaurant(List<restaurant> r) {
        for (var i : r) {
            System.out.println("Restaurant ID: " + i.getId());
            System.out.println("Restaurant Name: " + i.getName());
            System.out.println("Score: " + i.getScore());
            System.out.println("Price: " + i.getPrice());
            System.out.println("Zip Code: " + i.getZipCode());
            System.out.println("Categories: ");
            String cat = "";
            for (String j : i.getCategory()) {
                if (cat.equals("")) {
                    cat = j;
                } else {
                    cat += "," + j;
                }
            }
            System.out.println(cat);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Menu: ");
            for (food j : i.getmenu()) {
                showFood(j);
            }
        }
    }

    public static void showFood(food f) {
        System.out.println("Restaurant Id: " + f.getRestaurantId());
        System.out.println("Category: " + f.getCategory());
        System.out.println("Food Name: " + f.getFoodName());
        System.out.println("Price: " + f.getPrice());
        System.out.println();
    }

    public static void printMappedRestaurant(Map<String, String> map) {
        for (Map.Entry<String, String> i : map.entrySet()) {
            System.out.println(i.getKey() + ": " + i.getValue());
        }
    }

    public static void printMappedFood(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> i : map.entrySet()) {
            System.out.println(i.getKey() + ": " + i.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            restaurantManagerV3 RestaurantManager = new restaurantManagerV3("Restaurants");
            FileOp fileReader = new FileOp();
            List<restaurant> r = fileReader.fileRestaurant();
            List<food> F = fileReader.fileFood();
            for (var i : r) {
                RestaurantManager.addRestaurant(i);
            }
            for (var i : F) {
                RestaurantManager.addFood(i);
            }
            int choice;
            do {
                System.out.println("Main Menu:");
                System.out.println("1) Search Restaurants");
                System.out.println("2) Search Food Items");
                System.out.println("3) Add Restaurant");
                System.out.println("4) Add Food Item to the Menu");
                System.out.println("5) Exit System");

                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("1) By Name");
                        System.out.println("2) By Score");
                        System.out.println("3) By Category");
                        System.out.println("4) By Price");
                        System.out.println("5) By Zip Code");
                        System.out.println("6) Different Category Wise List of Restaurants");
                        System.out.println("7) Back to Main Menu");

                        int choice2 = Integer.parseInt(scanner.nextLine());
                        switch (choice2) {
                            case 1:
                                System.out.print("Enter a restaurant name to search: ");
                                String name1 = scanner.nextLine();
                                List<restaurant> resName = RestaurantManager.searchRestaurantByName(name1);
                                showRestaurant(resName);
                                break;
                            case 2:
                                System.out.print("Enter a lower score: ");
                                double low = Double.parseDouble(scanner.nextLine());
                                System.out.print("Enter a upper score: ");
                                double high = Double.parseDouble(scanner.nextLine());
                                // System.out.println(low + " " + high);
                                List<restaurant> resSCore = RestaurantManager.searchRestaurantByScore(low, high);
                                showRestaurant(resSCore);
                                break;
                            case 3:
                                System.out.print("Enter a category to search: ");
                                String category = scanner.nextLine();
                                List<restaurant> resCat = RestaurantManager.searchRestaurantByCategory(category);
                                showRestaurant(resCat);
                                break;
                            case 4:
                                System.out.print("Enter price to search: ");
                                String price = scanner.nextLine();
                                List<restaurant> resPrice = RestaurantManager.searchRestaurantByPrice(price);
                                showRestaurant(resPrice);
                                break;
                            case 5:
                                System.out.print("Enter ZipCode to search: ");
                                String zip = scanner.nextLine();
                                List<restaurant> resZip = RestaurantManager.searchRestaurantByZip(zip);
                                showRestaurant(resZip);
                                break;
                            case 6:
                                System.out.println("Showing Restaurants in the database by different category: ...");
                                Thread.sleep(1000);
                                Map<String, String> map = RestaurantManager.searchRestaurantByDiffCategory();
                                printMappedRestaurant(map);
                                break;
                            case 7:
                                break;
                            default:
                                System.out.println("Error: This  is not a valid operation.");
                                break;
                        }
                        break;

                    case 2:
                        System.out.println("1) By Name");
                        System.out.println("2) By Name in a Given Restaurant");
                        System.out.println("3) By Category");
                        System.out.println("4) By Category in a Given Restaurant");
                        System.out.println("5) By Price Range");
                        System.out.println("6) By Price Range in a Given Restaurant");
                        System.out.println("7) Costliest Food Item(s) on the Menu in a Given Restaurant");
                        System.out.println("8) List of Restaurants and Total Food Item on the Menu");
                        System.out.println("9) Back to Main Menu");

                        int choice3 = Integer.parseInt(scanner.nextLine());

                        switch (choice3) {
                            case 1:
                                System.out.print("Enter a food name: ");
                                String foodName = scanner.nextLine();
                                List<food> fName = RestaurantManager.searchFoodByName(foodName);
                                showFood(fName);
                                break;

                            case 2:
                                System.out.print("Enter a food name: ");
                                String foodname = scanner.nextLine();
                                System.out.print("Enter a restaurant name: ");
                                String resName = scanner.nextLine();
                                List<food> fNameRes = RestaurantManager.searchFoodByRestaurant(foodname, resName);
                                showFood(fNameRes);
                                break;

                            case 3:
                                System.out.print("Enter a food category: ");
                                String foodcat = scanner.nextLine();
                                List<food> fCat = RestaurantManager.searchFoodByCategory(foodcat);
                                showFood(fCat);
                                break;

                            case 4:
                                System.out.print("Enter a food category: ");
                                String foodCategory = scanner.nextLine();
                                System.out.print("Enter a restaurant name: ");
                                String res = scanner.nextLine();
                                List<food> fCatRes = RestaurantManager.searchFoodByCategoryRes(foodCategory, res);
                                showFood(fCatRes);
                                break;

                            case 5:
                                System.out.print("Enter lower price: ");
                                double l = Double.parseDouble(scanner.nextLine());
                                System.out.print("Enter upper price: ");
                                double h = Double.parseDouble(scanner.nextLine());
                                List<food> fPrice = RestaurantManager.searchFoodByPrice(l, h);
                                showFood(fPrice);
                                break;

                            case 6:
                                System.out.print("Enter a lower price: ");
                                double low = Double.parseDouble(scanner.nextLine());
                                System.out.print("Enter upper price: ");
                                double high = Double.parseDouble(scanner.nextLine());
                                System.out.print("Enter a restaurant name: ");
                                String rest = scanner.nextLine();
                                List<food> fPriceRes = RestaurantManager.searchFoodByPriceRes(low, high, rest);
                                showFood(fPriceRes);
                                ;
                                break;

                            case 7:
                                System.out.print("Enter a restaurant name: ");
                                String R = scanner.nextLine();
                                System.out.println("Showing costliest food in restaurant " + R + "...");
                                Thread.sleep(1000);
                                List<food> fCostliest = RestaurantManager.costliestFood(R);
                                if (fCostliest.size() > 0) {
                                    showFood(fCostliest);
                                } else {
                                    System.out.println("There is no food item on the menu.");
                                }
                                break;

                            case 8:
                                System.out.println("Displaying total food of all restaurants...");
                                Thread.sleep(1000);
                                Map<String, Integer> mapFood = RestaurantManager.displayTotalFood();
                                printMappedFood(mapFood);
                                break;

                            case 9:
                                break;
                            default:
                                System.out.println("Error: f is not a valid operation.");
                                break;

                        }
                        break;

                    case 3:
                        String restInfo = scanner.nextLine();
                        // System.out.println(restInfo);
                        String[] array = restInfo.split(",", -1);
                        // for(String i:array)
                        // {
                        // System.out.println(i);
                        // }
                        int id = Integer.parseInt(array[0]);
                        String Name = array[1];
                        double score = Double.parseDouble(array[2]);
                        String price = array[3];
                        String Z = array[4];
                        List<String> cateList = new ArrayList<>();
                        for (int i = 5; i < array.length; i++) {
                            if (array[i] != "") {
                                cateList.add(array[i]);
                            }
                        }
                        restaurant newRestaurant = new restaurant(id, Name, score, price, Z, cateList);
                        int addedRes = RestaurantManager
                                .addRestaurant(newRestaurant);
                        if (addedRes == 1) {
                            System.out.println("Restaurant added successfully");
                            r.add(newRestaurant);
                        } else
                            System.out.println("The Name already exists");
                        break;

                    case 4:
                        String foodRes = scanner.nextLine();
                        // System.out.println(foodRes);
                        boolean isRestaurant = !(RestaurantManager.isRestaurantValid(foodRes));
                        String foodInfo = scanner.nextLine();
                        // System.out.println(foodInfo);
                        String[] foodArray = foodInfo.split(",", -1);
                        // for (String i : foodArray) {
                        // System.out.println(i);
                        // }
                        int foodId = RestaurantManager.getResId(foodRes);
                        String foodCat = foodArray[0];
                        String foodName = foodArray[1];
                        double foodPrice = Double.parseDouble(foodArray[2]);
                        // System.out.println(foodCat + " " + foodName + " " + foodPrice);

                        food f = new food(foodId, foodCat, foodName, foodPrice);
                        int foodAdded = RestaurantManager.addFood(f);
                        if (foodAdded == 1 && isRestaurant == true) {
                            System.out.println("Food Added Successfully");
                            F.add(f);
                        } else {
                            System.out.println("Food is not valid.");
                        }
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("This is not a valid operation");
                        break;
                }
                System.out.println();
            } while (choice != 5);
            scanner.close();
            fileReader.writeFile(F, r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * 5,hasbi,2.5,$$$$,sizan,apurbo,jonathon
 * hasbi
 * mohi,Shovon,69.99
 * 7,hasbullah,2.9,$$$$,sizu,apurboss,jonathon,shantoo
 * hasbullah
 * mohi,Shovon,69.99
 * 
 */