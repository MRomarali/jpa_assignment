package ECCutb.OmarAli.jpa_Assignment.data;

import ECCutb.OmarAli.jpa_Assignment.Entity.Ingredient;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface IngredientDao extends CrudRepository<Ingredient, Integer> {
  //Optional<Ingredient> findByIngredientNameIgnoreCase(String name);
}
