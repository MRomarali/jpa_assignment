package ECCutb.OmarAli.jpa_Assignment.data;

import ECCutb.OmarAli.jpa_Assignment.Entity.RecipeIngredient;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientDao extends JpaRepository<RecipeIngredient, Integer> {
  //Optional<RecipeIngredient> findByProductNameIgnoreCase(String recipeIngredient);
}
