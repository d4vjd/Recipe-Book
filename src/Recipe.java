import java.io.*;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

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

    public void readRecipeFromTXT(File fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            name = bufferedReader.readLine();
            ingredients = bufferedReader.readLine();
            instructions = bufferedReader.readLine();
            servingSize = Integer.parseInt(bufferedReader.readLine());
            prepTime = bufferedReader.readLine();
            cookTime = bufferedReader.readLine();
            category = bufferedReader.readLine();
            rating = Float.parseFloat(bufferedReader.readLine());

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public void exportRecipeAsPDF(String fileName) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
            writer.setPageEvent(new MyHeaderFooter());
            document.open();

            Paragraph nameParagraph = new Paragraph("Name: " + name);
            nameParagraph.setAlignment(Element.ALIGN_LEFT);
            document.add(nameParagraph);

            Paragraph ingredientsParagraph = new Paragraph("Ingredients: " + ingredients);
            ingredientsParagraph.setAlignment(Element.ALIGN_LEFT);
            document.add(ingredientsParagraph);

            Paragraph instructionsParagraph = new Paragraph("Instructions: " + instructions);
            instructionsParagraph.setAlignment(Element.ALIGN_LEFT);
            document.add(instructionsParagraph);

            Paragraph servingSizeParagraph = new Paragraph("Serving Size: " + servingSize);
            servingSizeParagraph.setAlignment(Element.ALIGN_LEFT);
            document.add(servingSizeParagraph);

            Paragraph prepTimeParagraph = new Paragraph("Preparation Time: " + prepTime);
            prepTimeParagraph.setAlignment(Element.ALIGN_LEFT);
            document.add(prepTimeParagraph);

            Paragraph cookTimeParagraph = new Paragraph("Cook Time: " + cookTime);
            cookTimeParagraph.setAlignment(Element.ALIGN_LEFT);
            document.add(cookTimeParagraph);

            Paragraph categoryParagraph = new Paragraph("Category: " + category);
            categoryParagraph.setAlignment(Element.ALIGN_LEFT);
            document.add(categoryParagraph);

            Paragraph ratingParagraph = new Paragraph("Rating: " + rating);
            ratingParagraph.setAlignment(Element.ALIGN_LEFT);
            document.add(ratingParagraph);

            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    class MyHeaderFooter extends PdfPageEventHelper {
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Phrase header = new Phrase("Recipe Book", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, header, (document.right() - document.left()) / 2 + document.leftMargin(), document.top() + 10, 0);
        }
    }


}


