package ECCutb.OmarAli.jpa_Assignment.Entity;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class RecipeIngredient {

  @ManyToOne(
      cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.PERSIST,CascadeType.REFRESH},
      fetch = FetchType.LAZY
  )
  private Ingredient ingredient;
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  private String recipeIngredientId;
  private double amount;
  private Measurement unit;

  @ManyToOne(
        cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
        fetch = FetchType.LAZY
    )
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  public RecipeIngredient(Ingredient ingredient, String recipeIngredientId, double amount,
      Measurement unit, Recipe recipe) {
    this.ingredient = ingredient;
    this.recipeIngredientId = recipeIngredientId;
    this.amount = amount;
    this.unit = unit;
    this.recipe = recipe;
  }

  public RecipeIngredient(Ingredient ingredient, double amount,
      Measurement unit, Recipe recipe) {
    this(ingredient,null,amount,unit,recipe);
  }

  public RecipeIngredient(){}

  public Ingredient getIngredient() {
    return ingredient;
  }

  public void setIngredient(Ingredient ingredient) {
    this.ingredient = ingredient;
  }

  public String getRecipeIngredientId() {
    return recipeIngredientId;
  }

  public void setRecipeIngredientId(String recipeIngredientId) {
    this.recipeIngredientId = recipeIngredientId;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Measurement getUnit() {
    return unit;
  }

  public void setUnit(Measurement unit) {
    this.unit = unit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecipeIngredient that = (RecipeIngredient) o;
    return Double.compare(that.amount, amount) == 0 &&
        Objects.equals(ingredient, that.ingredient) &&
        Objects.equals(recipeIngredientId, that.recipeIngredientId) &&
        unit == that.unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(ingredient, recipeIngredientId, amount, unit);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("RecipeIngredient{");
    sb.append("ingredient=").append(ingredient);
    sb.append(", recipeIngredientId='").append(recipeIngredientId).append('\'');
    sb.append(", amount=").append(amount);
    sb.append(", unit=").append(unit);
    sb.append('}');
    return sb.toString();
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }
}
