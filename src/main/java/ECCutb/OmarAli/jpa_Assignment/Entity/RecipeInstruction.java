package ECCutb.OmarAli.jpa_Assignment.Entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class RecipeInstruction {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  private String recipeInstructionId;
  private String instruction;

  public RecipeInstruction(String recipeInstructionId, String instruction) {
    this.recipeInstructionId = recipeInstructionId;
    this.instruction = instruction;
  }
  public RecipeInstruction(){}

  public String getRecipeInstructionId() {
    return recipeInstructionId;
  }

  public void setRecipeInstructionId(String recipeInstructionId) {
    this.recipeInstructionId = recipeInstructionId;
  }

  public String getInstruction() {
    return instruction;
  }

  public void setInstruction(String instruction) {
    this.instruction = instruction;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecipeInstruction that = (RecipeInstruction) o;
    return Objects.equals(recipeInstructionId, that.recipeInstructionId) &&
        Objects.equals(instruction, that.instruction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipeInstructionId, instruction);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("RecipeInstruction{");
    sb.append("recipeInstructionId='").append(recipeInstructionId).append('\'');
    sb.append(", instruction='").append(instruction).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
