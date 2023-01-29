import java.io.*; //import input output classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Recipe recipe1 = new Recipe("Pizza Alfredo", "Flour, Tomato Sauce, Cheese, Bacon",
                "1. Preheat oven to 220°C. 2. Roll out dough. 3. Add sauce and cheese. 4. Bake for 10-15 minutes.",
                "5","45 min","15 min","Pizza",4.50f);
                //new recipe with preset parameters

        Recipe recipe2 = new Recipe(); //new recipe
        recipe2.assign(recipe1); //recipe2=recipe1
        //recipe2.displayRecipe(); //display recipe2
        System.out.println(); // endl

        Book book1 = new Book(); //new book
        book1.addRecipe(recipe1); //add recipe1 to book1
        book1.addRecipe(recipe2); //add recipe2 to book1
        //book1.displayAllRecipes(); //display all recipes from book1

        Recipe recipe3 = new Recipe(); //new recipe
        File recipe3file = new File("src/recipe3file.txt");
        recipe3.readRecipeFromTXT(recipe3file); //read content of recipe3 from recipe3file.txt
        //recipe3.displayRecipe();
        //book1.displayRecipesByCategory("Pizza"); //displays all recipes in the'Pizza' category

        //String recipe3pdf="Recipe3pdf.pdf";
        //recipe3.exportRecipeAsPDF(recipe3pdf); //export recipe3 info to a pdf document

        book1.addRecipe();//input recipe from keyboard and add it to the database
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipebook", "root", "R4b57ahmfapu");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from recipe");
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Ingredients: " + resultSet.getString("ingredients"));
                System.out.println("Instructions: " + resultSet.getString("instructions"));
                System.out.println("Serving Size: " + resultSet.getInt("serving_size"));
                System.out.println("Preparation Time: " + resultSet.getString("prep_time"));
                System.out.println("Cook Time: " + resultSet.getString("cook_time"));
                System.out.println("Category: " + resultSet.getString("category"));
                System.out.println("Rating: " + resultSet.getFloat("rating"));
                System.out.println("-------------------");
            }
        }catch (Exception e){e.printStackTrace();} //displays all contents of the database

    }
}