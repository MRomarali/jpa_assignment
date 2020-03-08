package ECCutb.OmarAli.jpa_Assignment.data;

import ECCutb.OmarAli.jpa_Assignment.Entity.Recipe;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecipeDao extends JpaRepository<Recipe, Integer> {
  //List<Recipe> findByRecipeNameContainsIgnoreCase(String recipeName);
  //Set<Recipe> findByRecipeIngredientsIngredientNameContainsIgnoreCase(String ingredientName);
  //Set<Recipe> findByCategoriesCategoryContainsIgnoreCase(String recipeCategory);
  //@Query("SELECT recipe FROM Recipe recipe JOIN FETCH recipe.category recipe_category WHERE recipe_category.category IN recipe_category_name")
  //Set<Recipe> findRecipeByCategoriesWithQuery(@Param("categories")List<String>categories);

}
