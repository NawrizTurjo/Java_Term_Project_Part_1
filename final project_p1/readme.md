# CSE 108: Java Term Project (Part 1)
## Restaurant Database System

This project involves writing a program to implement a simple restaurant database system. The system aims to manage a database of restaurants along with their food menus and offers various functionalities for searching, adding, and reporting restaurant and food item data.

## Features

The Restaurant Database System provides the following features:

- Maintain a list of Restaurant objects
- Each Restaurant object contains information such as Id, Name, Score, Price ($, $$, or $$$), Zip Code, and Categories
- Maintain a list of Food objects
- Each Food object represents a food item on a specific restaurant's menu and contains information like Restaurant Id, Category, Name, and Price
- Add restaurants to the list
- Add food items to restaurant menus
- Search and display restaurant and food item details based on different criteria
- Generate reports and statistics for restaurants and food items
- Load and save restaurant and menu data from/to text files
- Automatic loading and saving of data on program start and exit

## Main Menu

When the program is running, it will display a command-line-based main menu with the following options:

1) Search Restaurants
2) Search Food Items
3) Add Restaurant
4) Add Food Item to the Menu
5) Exit System

## Option (1) - Search Restaurants

Option (1) of the main menu allows the user to search for restaurants in the database. The user can choose from various search criteria, including Name, Score, Category, Price, Zip Code, and more.

## Option (2) - Search Food Items

Option (2) of the main menu enables users to search for food items on restaurant menus. Similar to the restaurant search, users can specify criteria such as Name, Category, Price Range, and more.

## Option (3) - Add Restaurant

Option (3) of the main menu allows users to add new restaurants to the database. Users need to input all the required information for the new restaurant.

## Option (4) - Add Food Item to the Menu

Option (4) of the main menu lets users add food items to the menu of a specific restaurant. Users first enter the restaurant name and then provide information about the new food item.

## Option (5) - Exit System

Option (5) exits the program. All restaurant and food item data in memory are automatically saved back to 'restaurant.txt' and 'menu.txt' files.

## Input File Format

The input data files 'restaurant.txt' and 'menu.txt' have specific formats. 'restaurant.txt' contains details about restaurants, and 'menu.txt' contains details about food items on restaurant menus. Both files use a comma-separated format.

## Assumptions

Several assumptions are made during the implementation of this project. These include:

- No hardcoding is allowed
- Design code for reusability
- All restaurant names are unique
- Food items in a restaurant's menu are unique
- No limits on the number of restaurants or food items
- Case-insensitive searches
- Data file formats are correct and do not need validation
- Command-line interface only, no JavaFX or Java Swing

## Price Symbols ($ , $$ , $$$)

The price symbols ($ , $$ , $$$) refer to the cost per person for an average meal: $1 to $10, $11 to $20, and $21 to $30, respectively.

## Running the Program

To run the program, compile and execute the main Java class. Ensure that you have Java Development Kit (JDK) installed and configured correctly.

```bash
javac RestaurantApp.java
java RestaurantApp
