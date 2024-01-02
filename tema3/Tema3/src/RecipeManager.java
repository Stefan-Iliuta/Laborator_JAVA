import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
    private List<Recipe> recipes;

    public RecipeManager() {
        // Inițializați lista de rețete aici, fie citind din fișierul CSV, fie adăugând manual
        this.recipes = new ArrayList<>();
        initializeRecipes();
    }

    // Endpoint pentru GET
    public Recipe getRecipeByColumnValue(String columnName, String searchValue) {
        for (Recipe recipe : recipes) {
            if (recipe.getColumnValue(columnName).equalsIgnoreCase(searchValue)) {
                return recipe;
            }
        }
        return null; // Rețeta nu a fost găsită
    }

    // Endpoint pentru POST
    public void addRecipes(List<Recipe> newRecipes) {
        recipes.addAll(newRecipes);
    }

    // Endpoint pentru DELETE
    public void deleteRecipeByColumnValue(String columnName, String searchValue) {
        recipes.removeIf(recipe -> recipe.getColumnValue(columnName).equalsIgnoreCase(searchValue));
    }

    // Endpoint pentru PUT
    public void updateRecipe(String columnName, String searchValue, String newColumnValue) {
        for (Recipe recipe : recipes) {
            if (recipe.getColumnValue(columnName).equalsIgnoreCase(searchValue)) {
                recipe.setColumnValue(columnName, newColumnValue);
                break;
            }
        }
    }

    // Metodă pentru a inițializa lista de rețete
    private void initializeRecipes() {
        recipes.add(new Recipe("Italy", "Risotto", "Rice", 45, 4, "Medium", 320, 1950, "Giada De Laurentiis"));
        // Adăugați restul rețetelor în aceeași manieră
    }

    // Clasa pentru reprezentarea unei rețete
    private static class Recipe {
        private String country;
        private String dishName;
        private String mainIngredient;
        private int cookingTimeMin;
        private int servings;
        private String spiceLevel;
        private int calories;
        private int yearIntroduced;
        private String chefName;

        public Recipe(String country, String dishName, String mainIngredient, int cookingTimeMin, int servings,
                      String spiceLevel, int calories, int yearIntroduced, String chefName) {
            this.country = country;
            this.dishName = dishName;
            this.mainIngredient = mainIngredient;
            this.cookingTimeMin = cookingTimeMin;
            this.servings = servings;
            this.spiceLevel = spiceLevel;
            this.calories = calories;
            this.yearIntroduced = yearIntroduced;
            this.chefName = chefName;
        }

        public String getColumnValue(String columnName) {
            switch (columnName) {
                case "Country":
                    return country;
                case "Dish_Name":
                    return dishName;
                case "Main_Ingredient":
                    return mainIngredient;
                case "Cooking_Time_Min":
                    return String.valueOf(cookingTimeMin);
                case "Servings":
                    return String.valueOf(servings);
                case "Spice_Level":
                    return spiceLevel;
                case "Calories":
                    return String.valueOf(calories);
                case "Year_Introduced":
                    return String.valueOf(yearIntroduced);
                case "Chef_Name":
                    return chefName;
                default:
                    return null;
            }
        }

        public void setColumnValue(String columnName, String value) {
            switch (columnName) {
                case "Country":
                    country = value;
                    break;
                case "Dish_Name":
                    dishName = value;
                    break;
                case "Main_Ingredient":
                    mainIngredient = value;
                    break;
                case "Cooking_Time_Min":
                    cookingTimeMin = Integer.parseInt(value);
                    break;
                case "Servings":
                    servings = Integer.parseInt(value);
                    break;
                case "Spice_Level":
                    spiceLevel = value;
                    break;
                case "Calories":
                    calories = Integer.parseInt(value);
                    break;
                case "Year_Introduced":
                    yearIntroduced = Integer.parseInt(value);
                    break;
                case "Chef_Name":
                    chefName = value;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // Exemplu de utilizare
        RecipeManager recipeManager = new RecipeManager();

        // GET
        Recipe foundRecipe = recipeManager.getRecipeByColumnValue("Country", "Italy");
        if (foundRecipe != null) {
            System.out.println("Found Recipe: " + foundRecipe.dishName);
        } else {
            System.out.println("Recipe not found");
        }

        // POST
        List<Recipe> newRecipes = new ArrayList<>();
        newRecipes.add(new Recipe("NewCountry", "NewDish", "NewIngredient", 60, 4, "Spicy", 400, 2000, "NewChef"));
        recipeManager.addRecipes(newRecipes);

        // PUT
        recipeManager.updateRecipe("Country", "NewCountry", "UpdatedCountry");

        // DELETE
        recipeManager.deleteRecipeByColumnValue("Country", "UpdatedCountry");
    }
}
