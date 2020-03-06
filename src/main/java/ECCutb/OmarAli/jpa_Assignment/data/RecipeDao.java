package ECCutb.OmarAli.jpa_Assignment.data;

import ECCutb.OmarAli.jpa_Assignment.Entity.Recipe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeDao extends JpaRepository<Recipe, Integer> {
  //Optional<Recipe> findByProductNameIgnoreCase(String recipeName);

}
