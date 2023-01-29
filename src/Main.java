import java.io.*; //import input output classes

public class Main {
    public static void main(String[] args) {

        Recipe recipe1 = new Recipe("Pizza", "Flour, Tomato Sauce, Cheese",
                "1. Preheat oven to 220°C. 2. Roll out dough. 3. Add sauce and cheese. 4. Bake for 10-15 minutes.",
                5,"45 min","15 min","Pizza",4.50f);
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
        recipe3.displayRecipe();

        String recipe3pdf="Recipe3pdf.pdf";
        recipe3.exportRecipeAsPDF(recipe3pdf); //export recipe3 info to a pdf document
    }
}