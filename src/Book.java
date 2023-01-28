import java.util.ArrayList;

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
}