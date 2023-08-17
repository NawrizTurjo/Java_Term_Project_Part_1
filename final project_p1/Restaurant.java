import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private double score;
    private String price;
    private String zipCode;
    private List<String> category;
    private List<Food> menu;

    public Restaurant() {
        this.id = 0;
        this.name = "";
        this.price = "";
        this.zipCode = "";
        this.score = 0.0;
        this.category = new ArrayList<>();
        this.menu = new ArrayList<>();
    }

    public Restaurant(int id, String name, double score ,String price, String zipCode) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.zipCode = zipCode;
        this.score = score;
        this.category = new ArrayList<>();
        this.menu = new ArrayList<>();
    }

    public Restaurant(int id, String name, double score, String price, String zipCode, List<String> category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.zipCode = zipCode;
        this.category = category;
        this.score=score;
        this.menu = new ArrayList<>();
    }

    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getZipCode() {
        return zipCode;
    }

    public double getScore()
    {
        return this.score;
    }

    public List<String> getCategory() {
        return category;
    }

    public List<Food> getmenu() {
        return menu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public void setmenu(List<Food> menu) {
        this.menu = menu;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setScore(double score)
    {
        this.score = score;
    }
    // @Override
    // public String toString() {
    // String str = "";
    // str += "Restaurant ID: " + this.id + "\n";
    // str += "Restaurant Name: " + this.name + "\n";
    // str += "Price: " + this.price + "\n";
    // str += "Zip Code: " + this.zipCode + "\n";
    // str += "Category: " + this.category + "\n";
    // str += "menu: " + this.menu + "\n";
    // return str;
    // }

    // @Override
    // public String toString() {
    //     String str = "";
    //     str += "Restaurant ID: " + this.id + "\n";
    //     str += "Restaurant Name: " + this.name + "\n";
    //     str += "Price: " + this.price + "\n";
    //     str += "Zip Code: " + this.zipCode + "\n";
    //     str += "Category: " + this.category + "\n";
    //     str += "menu: " + "\n";
    //     for (int i = 0; i < this.menu.size(); i++) {
    //         str += this.menu.get(i).toString();
    //     }
    //     return str;
    // }

    // public void showDetails()
    // {
    //     System.out.println("Restaurant ID: "+this.id);
    //     System.out.println("Restaurant Name: "+this.name);
    //     System.out.println("Score: "+this.score);
    //     System.out.println("Price: "+this.price);
    //     System.out.println("Zip Code: "+this.zipCode);
    //     System.out.println("Categories: ");
    //     for(String i:category)
    //     {
    //         System.out.println(i);
    //     }
    //     System.out.println("Menu: ");
    //     for(Food i:menu)
    //     {
    //         System.out.print("\t");
    //         i.showDetails();
    //     }
    // }

    // public boolean searchFood(String FoodName)
    // {
    //     int FoodCount = 0;
    //     for(Food i:menu)
    //     {
    //         if(i.getFoodName().toUpperCase().equals(FoodName.toUpperCase()))
    //         {
    //             i.showDetails();
    //             FoodCount++;
    //         }
    //     }
    //     if(FoodCount == 0)  return false;
    //     return true;
    // }

    // public boolean searchCatagory(String catagoryName)
    // {
    //     boolean isFound = false;
    //     for(String i:category)
    //     {
    //         if(i.toUpperCase().equals(catagoryName.toUpperCase()))
    //         {
    //             isFound = true; 
    //         }
    //     }
    //     return isFound;
    // }

    // public void displayCosliestFood()
    // {
    //     double costliest = menu.get(0).getPrice();
    //     int index=0;
    //     for(int i=0;i<menu.size();i++)
    //     {
    //         if(menu.get(i).getPrice()>costliest)
    //         {
    //             costliest = menu.get(i).getPrice();
    //             index = i;
    //             menu.get(index).showDetails();
    //         }
    //     }
    // }

    

    public int getTotalFood()
    {
        return menu.size();
    }

    public void addFood(Food f)
    {
        menu.add(f);
    }

    public boolean isCategory(String Category)
    {
        boolean isFound = false;

        for(int i=0;i<category.size();i++)
        {
            if(category.get(i).toUpperCase().contains(Category.toUpperCase()))
            {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public List<Food> isFood(String foodName)
    {
        // boolean isFound = false;
        // int index = -1;
        List<Food> f = new ArrayList<>();
        for(Food i:menu)
        {
            if(i.getFoodName().toUpperCase().contains(foodName.toUpperCase()))
            {
                // isFound = true;
                f.add(i);
            }
        }
        return f;
    }
    // public String toString2() {
    // String str = "";
    // str += "Restaurant ID: " + this.id + "\n";
    // str += "Restaurant Name: " + this.name + "\n";
    // str += "Price: " + this.price + "\n";
    // str += "Zip Code: " + this.zipCode + "\n";
    // str += "Category: " + this.category + "\n";
    // str += "menu: " + "\n";
    // for (int i = 0; i < this.menu.size(); i++) {
    // str += this.menu.get(i).toString2();
    // }
    // return str;
    // }

}
