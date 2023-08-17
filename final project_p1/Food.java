public class Food {
    private int restaurantId;
    private String category;
    private String foodName;
    private double price;

    public Food() {
        this.restaurantId = 0;
        this.category = "";
        this.foodName = "";
        this.price = 0.0;
    }

    public Food(int restaurantId, String category, String foodName, double price) {
        this.restaurantId = restaurantId;
        this.category = category;
        this.foodName = foodName;
        this.price = price;
    }

    public String getFoodName() {
        return this.foodName;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // @Override
    // public String toString()
    // {
    // String str = "";
    // str += "Restaurant ID: " + this.restaurantId + "\n";
    // str += "Category: " + this.category + "\n";
    // str += "Food Name: " + this.foodName + "\n";
    // str += "Price: " + this.price + "\n";
    // return str;
    // }

    // public void showDetails() {
    //     System.out.println("Restaurant Id: " + this.restaurantId);
    //     System.out.println("Category: " + this.category);
    //     System.out.println("Food Name: " + this.foodName);
    //     System.out.println("Price: " + this.price);
    // }

    public boolean isEqual(Food f) {
        if (this.foodName.toUpperCase().equals(f.getFoodName().toUpperCase()) &&
                this.restaurantId == f.getRestaurantId() &&
                this.category.toUpperCase().equals(f.getCategory().toUpperCase()) &&
                this.price == f.getPrice()) {
            return true;
        }
        return false;
    }

    // public String toFileString()
    // {
    // String str = "";
    // str += this.restaurantId + ",";
    // str += this.category + ",";
    // str += this.foodName + ",";
    // str += this.price;
    // return str;
    // }

    // public static food fromString(String str)
    // {
    // String [] array = str.split(",", -1);
    // food f = new food(array[0], array[1], array[2], array[3]);
    // return f;
    // }

}
