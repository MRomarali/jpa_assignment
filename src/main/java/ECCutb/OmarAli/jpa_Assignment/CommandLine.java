package ECCutb.OmarAli.jpa_Assignment;

import ECCutb.OmarAli.jpa_Assignment.Entity.Ingredient;
import ECCutb.OmarAli.jpa_Assignment.Entity.Measurement;
import ECCutb.OmarAli.jpa_Assignment.Entity.Recipe;
import ECCutb.OmarAli.jpa_Assignment.Entity.RecipeCategory;
import ECCutb.OmarAli.jpa_Assignment.Entity.RecipeIngredient;
import ECCutb.OmarAli.jpa_Assignment.Entity.RecipeInstruction;
import ECCutb.OmarAli.jpa_Assignment.data.IngredientDao;
import ECCutb.OmarAli.jpa_Assignment.data.RecipeCategoryDao;
import ECCutb.OmarAli.jpa_Assignment.data.RecipeDao;
import ECCutb.OmarAli.jpa_Assignment.data.RecipeIngredientDao;
import ECCutb.OmarAli.jpa_Assignment.data.RecipeInstructionDao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CommandLine implements CommandLineRunner {

  private IngredientDao ingredientDao;
  private RecipeDao recipeDao;
  private RecipeIngredientDao recipeIngredientDao;
  private RecipeInstructionDao recipeInstructionDao;
  private RecipeCategoryDao recipeCategoryDao;

  @Autowired
  public CommandLine(IngredientDao ingredientDao,
      RecipeDao recipeDao, RecipeIngredientDao recipeIngredientDao,
      RecipeInstructionDao recipeInstructionDao,
      RecipeCategoryDao recipeCategoryDao) {
    this.ingredientDao = ingredientDao;
    this.recipeDao = recipeDao;
    this.recipeIngredientDao = recipeIngredientDao;
    this.recipeInstructionDao = recipeInstructionDao;
    this.recipeCategoryDao = recipeCategoryDao;
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    Ingredient ingredient = new Ingredient("Bananas");
    Ingredient ingredient1 = new Ingredient("Juice");
    Ingredient ingredient2 = new Ingredient("meat");

    RecipeInstruction recipeInstruction = new RecipeInstruction( "Its a yellow fruit and very delicious");
    RecipeInstruction recipeInstruction1 = new RecipeInstruction( "Its a orange drink and very juicy");
    RecipeInstruction recipeInstruction2 = new RecipeInstruction( "Its cow meat");

    RecipeCategory recipeCategory = new RecipeCategory("after exercise meal", null);
    RecipeCategory recipeCategory1 = new RecipeCategory("serves with food", null);
    RecipeCategory recipeCategory2 = new RecipeCategory("Dinner", null);

    Recipe recipe = new Recipe( 1, "BananaMix", null,recipeInstruction, null);
    Recipe recipe1 = new Recipe( 1, "Orange Juice", null,recipeInstruction1, null);
    Recipe recipe2 = new Recipe( 1, "Meatball", null,recipeInstruction2, null);

    RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient, 40, Measurement.KG, recipe);
    RecipeIngredient recipeIngredient1 = new RecipeIngredient(ingredient, 40, Measurement.KG, recipe1);
    RecipeIngredient recipeIngredient2 = new RecipeIngredient(ingredient, 40, Measurement.KG, recipe2);



    System.out.println(recipe.addRecipeCategory(recipeCategory));
    System.out.println(recipe.addRecipeCategory(recipeCategory1));
    System.out.println(recipe.addRecipeCategory(recipeCategory2));

    recipe.addRecipeIngredient(recipeIngredient);
    recipe.addRecipeIngredient(recipeIngredient1);
    recipe.addRecipeIngredient(recipeIngredient2);

    recipeDao.save(recipe);
    recipeDao.save(recipe1);
    recipeDao.save(recipe2);

    //System.out.println(ingredientDao.findByIngredientNameIgnoreCase("Bananas"));
    //System.out.println(ingredientDao.findByIngredientNameContainsIgnoreCase("as"));
    //System.out.println(recipeDao.findByRecipeNameContainsIgnoreCase("Banana"));
    //System.out.println(recipeDao.findByRecipeIngredientsIngredientNameContainsIgnoreCase("Banana"));
    //System.out.println(recipeDao.findByCategoriesCategoryContainsIgnoreCase("ser"));
    //System.out.println(recipeDao.findRecipeByCategoriesWithQuery(Arrays.asList("serves with food", "Dinner")));
  }
}
