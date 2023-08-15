import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FileOp {

    private static final String INPUT_FILE_NAME1 = "out_r.txt";
    private static final String INPUT_FILE_NAME2 = "out_f.txt";
    private static final String OUTPUT_FILE_NAME1 = "out_r.txt";
    private static final String OUTPUT_FILE_NAME2 = "out_f.txt";
    private static final DecimalFormat df = new DecimalFormat("#.##");

    // public static void main(String[] args) throws Exception {
    // BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
    // BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
    // while (true) {
    // String line = br.readLine();
    // if (line == null)
    // break;
    // System.out.println(line);
    // String[] array = line.split(",", -1);
    // for (int i = 0; i < array.length; i++) {
    // System.out.println(array[i]);
    // // bw.write(array[i]);
    // }
    // }
    // br.close();

    // String text = "Hello World";
    // bw.write(text);
    // bw.write(System.lineSeparator());
    // bw.close();
    // }

    public List<restaurant> fileRestaurant() {
        List<restaurant> restaurantList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME1));
            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                String[] array = line.split(",", -1);
                // if (array.length >= 3) {
                // String name = array[0];
                // String location = array[1];
                // String cuisine = array[2];
                int id = Integer.parseInt(array[0]);
                String name = array[1];
                double score = Double.parseDouble(array[2]);
                String price = array[3];
                String zip = array[4];
                List<String> category = new ArrayList<>();
                for (int i = 5; i < array.length; i++) {
                    if(!(array[i].equals("")))
                    {category.add(array[i]);}
                }
                restaurant restaurant = new restaurant(id, name, score, price, zip, category);
                restaurantList.add(restaurant);
                // }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurantList;
    }

    public List<food> fileFood() {
        List<food> foodList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME2));
            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                String[] array = line.split(",", -1);
                int id = Integer.parseInt(array[0]);
                String category = array[1];
                String name = array[2];
                double price = Double.parseDouble(array[3]);
                food f = new food(id,category,name,price);
                foodList.add(f);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foodList;
    }

    public void writeFile(List<food> f,List<restaurant> r)
    {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME2));
            for(var i:f)
            {
                String line = i.getRestaurantId()+","+i.getCategory()+","+i.getFoodName()+","+df.format(i.getPrice());
                bw.write(line+"\n");
            }
            bw.close();
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME1));
            for(var i:r)
            {
                String line = i.getId()+","+i.getName()+","+df.format(i.getScore())+","+i.getPrice()+","+i.getZipCode();
                for(int j=0;j<i.getCategory().size();j++)
                {
                    line+=","+i.getCategory().get(j);
                }
                if(i.getCategory().size()<3)    {
                    line+=",";
                }
                bw2.write(line+"\n");
            }
            bw2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}