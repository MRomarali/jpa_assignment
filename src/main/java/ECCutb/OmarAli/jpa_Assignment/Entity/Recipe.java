package ECCutb.OmarAli.jpa_Assignment.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Recipe {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int recipeId;
  private String recipeName;

  @OneToMany(
        cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
        fetch = FetchType.LAZY,
      mappedBy = "recipe"
    )
  private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

  @OneToOne(
        cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
        fetch = FetchType.LAZY
    )
  private RecipeInstruction recipeInstruction;

  @ManyToMany(
        cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
        fetch = FetchType.LAZY
    )
  @JoinTable(name = "recipe_recipe_category",
  joinColumns = @JoinColumn(name = "recipe_id"),
  inverseJoinColumns = @JoinColumn(name = "recipe_category_id"))
  private List<RecipeCategory> recipeCategories;

  public Recipe(int recipeId, String recipeName) {
    this.recipeId = recipeId;
    this.recipeName = recipeName;
  }

  public Recipe(String recipeName) {
    this(0, recipeName);
  }

  public int getRecipeId() {
    return recipeId;
  }

  public String getRecipeName() {
    return recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipe recipe = (Recipe) o;
    return recipeId == recipe.recipeId &&
        Objects.equals(recipeName, recipe.recipeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipeId, recipeName);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Recipe{");
    sb.append("recipeId=").append(recipeId);
    sb.append(", recipeName='").append(recipeName).append('\'');
    sb.append('}');
    return sb.toString();
  }
}