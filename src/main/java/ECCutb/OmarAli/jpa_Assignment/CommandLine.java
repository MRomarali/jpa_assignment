package ECCutb.OmarAli.jpa_Assignment;

import ECCutb.OmarAli.jpa_Assignment.Entity.Ingredient;
import ECCutb.OmarAli.jpa_Assignment.Entity.Measurement;
import ECCutb.OmarAli.jpa_Assignment.Entity.Recipe;
import ECCutb.OmarAli.jpa_Assignment.Entity.RecipeIngredient;
import ECCutb.OmarAli.jpa_Assignment.Entity.RecipeInstruction;
import ECCutb.OmarAli.jpa_Assignment.data.IngredientDao;
import ECCutb.OmarAli.jpa_Assignment.data.RecipeDao;
import ECCutb.OmarAli.jpa_Assignment.data.RecipeIngredientDao;
import ECCutb.OmarAli.jpa_Assignment.data.RecipeInstructionDao;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLine implements CommandLineRunner {

  private IngredientDao ingredientDao;
  private RecipeDao recipeDao;
  private RecipeIngredientDao recipeIngredientDao;
  private RecipeInstructionDao recipeInstructionDao;

  public CommandLine(IngredientDao ingredientDao,
      RecipeDao recipeDao, RecipeIngredientDao recipeIngredientDao,
      RecipeInstructionDao recipeInstructionDao) {
    this.ingredientDao = ingredientDao;
    this.recipeDao = recipeDao;
    this.recipeIngredientDao = recipeIngredientDao;
    this.recipeInstructionDao = recipeInstructionDao;
  }

  @Override
  public void run(String... args) throws Exception {
    Ingredient ingredient = new Ingredient("Bananer");
    ingredientDao.save(ingredient);
    Recipe recipe = new Recipe( "Fruit");
    recipeDao.save(recipe);
    RecipeIngredient recipeIngredient = new RecipeIngredient("1", 25, Measurement.KG);
    recipeIngredientDao.save(recipeIngredient);
    RecipeInstruction recipeInstruction = new RecipeInstruction("1", "Its a yellow fruit and very delicious");
    recipeInstructionDao.save(recipeInstruction);

    //Optional<Ingredient> result = ingredientDao.findByIngredientNameIgnoreCase("BaNaNeR");
    //System.out.println(result.orElseThrow(IllegalArgumentException::new));
  }
}
