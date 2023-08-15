import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// import java.lang.*;

public class restaurantApp {
    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            restaurantManagerV2 RestaurantManager = new restaurantManagerV2("Restaurants");
            FileOp fileReader = new FileOp();
            List<restaurant> r = fileReader.fileRestaurant();
            List<food> F = fileReader.fileFood();
            for (var i : r) {
                RestaurantManager.addRestaurant(i);
            }
            for(var i:F)
            {
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
                                String name1 = scanner.nextLine();
                                RestaurantManager.searchRestaurantByName(name1);
                                break;
                            case 2:
                                double low = Double.parseDouble(scanner.nextLine());
                                double high = Double.parseDouble(scanner.nextLine());
                                System.out.println(low + " " + high);
                                RestaurantManager.searchRestaurantByScore(low, high);
                                break;
                            case 3:
                                String category = scanner.nextLine();
                                RestaurantManager.searchRestaurantByCategory(category);
                                break;
                            case 4:
                                String price = scanner.nextLine();
                                RestaurantManager.searchRestaurantByPrice(price);
                                break;
                            case 5:
                                String zip = scanner.nextLine();
                                RestaurantManager.searchRestaurantByZip(zip);
                                break;
                            case 6:
                                RestaurantManager.searchRestaurantByDiffCategory();
                                break;
                            case 7:
                                break;
                            default:
                                System.out.println("Error: This is not a valid operation.");
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
                                String foodName = scanner.nextLine();
                                RestaurantManager.searchFoodByName(foodName);
                                break;

                            case 2:
                                String foodname = scanner.nextLine();
                                String resName = scanner.nextLine();
                                RestaurantManager.searchFoodByRestaurant(foodname, resName);
                                break;

                            case 3:
                                String foodcat = scanner.nextLine();
                                RestaurantManager.searchFoodByCategory(foodcat);
                                break;

                            case 4:
                                String foodCategory = scanner.nextLine();
                                String res = scanner.nextLine();
                                RestaurantManager.searchFoodByCategoryRes(foodCategory, res);

                                break;

                            case 5:
                                double l = Double.parseDouble(scanner.nextLine());
                                double h = Double.parseDouble(scanner.nextLine());
                                RestaurantManager.searchFoodByPrice(l, h);
                                break;

                            case 6:
                                double low = Double.parseDouble(scanner.nextLine());
                                double high = Double.parseDouble(scanner.nextLine());
                                String rest = scanner.nextLine();
                                RestaurantManager.searchFoodByPriceRes(low, high, rest);
                                ;
                                break;

                            case 7:
                                String R = scanner.nextLine();
                                RestaurantManager.costliestFood(R);
                                break;

                            case 8:
                                RestaurantManager.displayTotalFood();
                                break;

                            case 9:
                                break;
                            default:
                                System.out.println("Error: This is not a valid operation.");
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
                        RestaurantManager.addRestaurant(id, Name, score, price, Z, cateList);
                        break;

                    case 4:
                        String foodRes = scanner.nextLine();
                        System.out.println(foodRes);
                        String foodInfo = scanner.nextLine();
                        System.out.println(foodInfo);
                        String[] foodArray = foodInfo.split(",", -1);
                        for (String i : foodArray) {
                            System.out.println(i);
                        }
                        int foodId = RestaurantManager.getResId(foodRes);
                        String foodCat = foodArray[0];
                        String foodName = foodArray[1];
                        double foodPrice = Double.parseDouble(foodArray[2]);
                        System.out.println(foodCat + " " + foodName + " " + foodPrice);
                        food f = new food(foodId, foodCat, foodName, foodPrice);
                        RestaurantManager.addFood(f);
                        break;
                }
                System.out.println();
            } while (choice != 5);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * 3
 * 1,KFC,4.3,$$$,98531,Chicken,Fast Food,Family Meals
 * 3
 * 2,IHOP,4.3,$$,77494,Breakfast and Brunch,Family Meals,Burgers
 * 3
 * 3,Starbucks,4.9,$,99218,Coffee and Tea,Breakfast and Brunch,Bakery
 * 3
 * 4,McDonalds,4.7,$,98346,Burgers,Fast Food,
 * 4
 * KFC
 * Fast Food,Chicken and Pancakes,13.55
 * 4
 * IHOP
 * Family Meals,12 pc. Family Bucket Meal,50.39
 * 4
 * Starbucks
 * Coffee and Tea,Coffee Traveler – Pike Place Roast,22.95
 * 4
 * McDonalds
 * Burgers,Medium Iced Hazelnut Coffee,2.99
 * 2
 * 8
 * 2
 * 7
 * KFC
 * 4
 * McDonalds
 * Fast Food,Tomato and Mozzarella on Focaccia,17.25
 * 2
 * 8
 * 2
 * 7
 * McDonalds
 * 
 *   5,hasbi,2.5,$$$$,sizan,apurbo,jonathon
 *   hasbi
 *   mohi,Shovon,69.99
 * 
 */

/*
 * Chicken: KFC,
 * Fast Food: KFC,McDonalds,
 * Family Meals: KFC,IHOP,
 * Breakfast and Brunch: IHOP,Starbucks,
 * Burgers: IHOP,McDonalds,
 * Coffee and Tea: Starbucks,
 * Bakery: Starbucks,
 */

// 2,Combo Meals,Chicken and Pancakes,13.55
