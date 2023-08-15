import java.util.ArrayList;
import java.util.List;

public class category {
    private String name;
    private List<food>foods;

    public category(String name, List<food> foods) {
        this.name = name;
        this.foods = foods;
    }

    public category() {
        this.name = "";
        this.foods = new ArrayList<>();
    }

    public category(String name) {
        this.name = name;
        this.foods = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<food> getFoods() {
        return foods;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoods(List<food> foods) {
        this.foods = foods;
    }

    public void addFood(food food) {
        this.foods.add(food);
    }

    public void removeFood(food food) {
        this.foods.remove(food);
    }

    public void removeFood(int index) {
        this.foods.remove(index);
    }

    public void printFoods() {
        for (int i = 0; i < foods.size(); i++) {
            foods.get(i).showDetails();
        }
    }

    public void printFoods(int index) {
        foods.get(index).showDetails();
    }

    public void printFoods(String name) {
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getFoodName().toUpperCase().equals(name.toUpperCase())) {
                System.out.println(foods.get(i).toString());
            }
        }
    }

    public void printFoods(double low, double high) {
        for (int i = 0; i < foods.size(); i++) {
            double price = foods.get(i).getPrice();
            if (price >= low && price <= high) {
                System.out.println(foods.get(i).toString());
            }
        }
    }
}
