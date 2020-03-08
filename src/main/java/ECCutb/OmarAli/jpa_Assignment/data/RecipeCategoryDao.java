package ECCutb.OmarAli.jpa_Assignment.data;

import ECCutb.OmarAli.jpa_Assignment.Entity.RecipeCategory;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface RecipeCategoryDao extends CrudRepository<RecipeCategory, Integer> {
}
