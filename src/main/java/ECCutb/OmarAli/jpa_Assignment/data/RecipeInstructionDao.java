package ECCutb.OmarAli.jpa_Assignment.data;

import ECCutb.OmarAli.jpa_Assignment.Entity.RecipeInstruction;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInstructionDao extends JpaRepository<RecipeInstruction, Integer> {
  //Optional<RecipeInstruction> findByProductNameIgnoreCase(String recipeInstructionName);
}
