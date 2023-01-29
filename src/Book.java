import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private ArrayList<Recipe> recipeBook;

    public Book() {
        recipeBook = new ArrayList<Recipe>();
    }

    public ArrayList<Recipe> getRecipes() {
        return recipeBook;
    }

    public void addRecipe(Recipe recipe) {
        recipeBook.add(recipe);
    }

    public Recipe searchRecipe(String ingredient) {
        for (Recipe recipe : recipeBook) {
            if (recipe.getIngredients().contains(ingredient)) {
                return recipe;
            }
        }
        return null;
    }

    public void deleteRecipe(String recipeName) {
        for (int i = 0; i < recipeBook.size(); i++) {
            Recipe recipe = recipeBook.get(i);
            if (recipe.getName().equals(recipeName)) {
                recipeBook.remove(i);
                break;
            }
        }
    }

    public void updateRecipe(Recipe recipe) {
        for (int i = 0; i < recipeBook.size(); i++) {
            Recipe currentRecipe = recipeBook.get(i);
            if (currentRecipe.getName().equals(recipe.getName())) {
                recipeBook.set(i, recipe);
                break;
            }
        }
    }

    public void displayAllRecipes() {
        for (Recipe recipe : recipeBook) {
            System.out.println("Name: " + recipe.getName());
            System.out.println("Ingredients: " + recipe.getIngredients());
            System.out.println("Instructions: " + recipe.getInstructions());
            System.out.println("Prep Time: " + recipe.getPrepTime());
            System.out.println("Cook Time: " + recipe.getCookTime());
            System.out.println("Rating: " + recipe.rating);
            System.out.println("Category: " + recipe.getCategory());
            System.out.println();
        }
    }

    public void displayRecipesByCategory(String category) {
        for (Recipe recipe : recipeBook) {
            if (recipe.getCategory().equals(category)) {
                System.out.println("Name: " + recipe.getName());
                System.out.println("Ingredients: " + recipe.getIngredients());
                System.out.println("Instructions: " + recipe.getInstructions());
                System.out.println("Prep Time: " + recipe.getPrepTime());
                System.out.println("Cook Time: " + recipe.getCookTime());
                System.out.println("Rating: " + recipe.rating);
                System.out.println("Category: " + recipe.getCategory());
                System.out.println();
            }
        }
    }

    public void addRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the recipe: ");
        String name = scanner.nextLine();
        System.out.print("Enter the ingredients: ");
        String ingredients = scanner.nextLine();
        System.out.print("Enter the instructions: ");
        String instructions = scanner.nextLine();
        System.out.print("Enter the serving size: ");
        String servingSize = scanner.nextLine();
        System.out.print("Enter the preparation time (in minutes): ");
        String prepTime = scanner.nextLine();
        System.out.print("Enter the cook time (in minutes): ");
        String cookTime = scanner.nextLine();
        System.out.print("Enter the category: ");
        String category = scanner.nextLine();
        System.out.print("Enter the rating (out of 5): ");
        float rating = scanner.nextFloat();

        Recipe recipe = new Recipe(name, ingredients, instructions, servingSize, prepTime, cookTime, category, rating);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipebook", "root", "R4b57ahmfapu");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT MAX(idRecipe) FROM recipe");
            int idRecipe = 0;
            if (resultSet.next()) {
                idRecipe = resultSet.getInt(1) + 1;
            }

            String query = "INSERT INTO recipe (idRecipe, name, ingredients, instructions, serving_size, prep_time, cook_time, category, rating) " +
                    "VALUES (" + idRecipe + ", '" + name + "', '" + ingredients + "', '" + instructions + "', " + servingSize + ", '" + prepTime + "', '" + cookTime + "', '" + category + "', " + rating + ")";

            statement.executeUpdate(query);

            System.out.println("Recipe added to database successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
