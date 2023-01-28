public class Recipe {
    public String name;
    public String ingredients;
    public String instructions;
    public int servingSize;
    public String prepTime;
    public String cookTime;
    public String category;
    public float rating;

    // constructor method
    public Recipe(String name, String ingredients, String instructions, int servingSize,
                  String prepTime, String cookTime, String category, float rating) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.servingSize = servingSize;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.category = category;
        this.rating = rating;
    }
    public Recipe() {
        // This constructor takes no arguments
    }

    // getters
    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public int getServingSize() {
        return servingSize;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public String getCategory() {
        return category;
    }

    public float getRating() {
        return rating;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void assign(Recipe other) {
        this.name = other.name;
        this.servingSize = other.servingSize;
        this.ingredients = other.ingredients;
        this.instructions = other.instructions;
        this.category=other.category;
        this.cookTime=other.cookTime;
        this.prepTime=other.prepTime;
        this.rating=other.rating;
    }

    public void displayRecipe() {
        System.out.println("Name: " + name);
        System.out.println("Ingredients: " + ingredients);
        System.out.println("Instructions: " + instructions);
        System.out.println("Rating: " + rating);
        System.out.println("Cook Time: " + cookTime);
        System.out.println("Prep Time: " + prepTime);
        System.out.println("Category: " + category);
    }


}

