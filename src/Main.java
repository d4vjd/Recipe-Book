
public class Main {
    public static void main(String[] args) {

        Recipe recipe1 = new Recipe("Pizza", "Flour, Tomato Sauce, Cheese",
                "1. Preheat oven to 220°C. 2. Roll out dough. 3. Add sauce and cheese. 4. Bake for 10-15 minutes.",
                5,"45 min","15 min","Pizza",4.50f);

        Recipe recipe2 = new Recipe();
        recipe2.assign(recipe1);
        recipe2.displayRecipe();
        System.out.println();

        Book book1 = new Book();
        book1.addRecipe(recipe1);
        book1.addRecipe(recipe2);

        book1.displayAllRecipes();

    }
}