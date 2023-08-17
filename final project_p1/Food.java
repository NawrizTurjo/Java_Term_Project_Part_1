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

    public boolean isEqual(Food f) {
        if (this.foodName.toUpperCase().equals(f.getFoodName().toUpperCase()) &&
                this.restaurantId == f.getRestaurantId() &&
                this.category.toUpperCase().equals(f.getCategory().toUpperCase()) &&
                this.price == f.getPrice()) {
            return true;
        }
        return false;
    }
}
