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

@Entity
public class RecipeCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int recipeCategoryId;
  private String recipeCategoryName;
  @ManyToMany(
      cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
      fetch = FetchType.LAZY
  )
  @JoinTable(name = "recipe_recipe_category",
      joinColumns = @JoinColumn(name = "recipe_category_id"),
      inverseJoinColumns = @JoinColumn(name = "recipe_id"))
  private List<Recipe> recipeListByCategory = new ArrayList<>();

  public RecipeCategory(int recipeCategoryId, String recipeCategoryName,
      List<Recipe> recipeListByCategory) {
    this.recipeCategoryId = recipeCategoryId;
    this.recipeCategoryName = recipeCategoryName;
    this.recipeListByCategory = recipeListByCategory;
  }

  public RecipeCategory(String recipeCategoryName,
      List<Recipe> recipeListByCategory) {
    this(0,recipeCategoryName,recipeListByCategory);
  }
  public RecipeCategory(){}
  
  public int getRecipeCategoryId() {
    return recipeCategoryId;
  }

  public String getRecipeCategoryName() {
    return recipeCategoryName;
  }

  public void setRecipeCategoryName(String recipeCategoryName) {
    this.recipeCategoryName = recipeCategoryName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecipeCategory that = (RecipeCategory) o;
    return recipeCategoryId == that.recipeCategoryId &&
        Objects.equals(recipeCategoryName, that.recipeCategoryName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipeCategoryId, recipeCategoryName);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("RecipeCategory{");
    sb.append("recipeId=").append(recipeCategoryId);
    sb.append(", recipeCategoryName='").append(recipeCategoryName).append('\'');
    sb.append('}');
    return sb.toString();
  }

  public List<Recipe> getRecipe() {
    if (recipeListByCategory == null)
      return new ArrayList<>();
    return recipeListByCategory;
  }
}
