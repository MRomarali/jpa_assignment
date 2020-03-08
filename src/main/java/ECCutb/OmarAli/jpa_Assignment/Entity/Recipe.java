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

  public Recipe(int recipeId, String recipeName,
      List<RecipeIngredient> recipeIngredients,
      RecipeInstruction recipeInstruction,
      List<RecipeCategory> recipeCategories) {
    this.recipeId = recipeId;
    this.recipeName = recipeName;
    setRecipeIngredients(recipeIngredients);
    this.recipeInstruction = recipeInstruction;
    setCategories(recipeCategories);
  }

  public Recipe(String recipeName,
      List<RecipeIngredient> recipeIngredients,
      RecipeInstruction recipeInstruction,
      List<RecipeCategory> recipeCategories) {
    this(0, recipeName, recipeIngredients, recipeInstruction, recipeCategories);
    }
    public Recipe(){}

  private void setCategories(List<RecipeCategory> recipeCategories) {
    if (recipeCategories == null){
      recipeCategories = new ArrayList<>();
    }
    this.recipeCategories = recipeCategories;
  }

  private void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
    if (recipeIngredients == null){
      recipeIngredients = new ArrayList<>();
    }
    this.recipeIngredients = recipeIngredients;
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

  public List<RecipeIngredient> getRecipeIngredients() {
    return recipeIngredients;
  }

  public RecipeInstruction getRecipeInstruction() {
    return recipeInstruction;
  }

  public void setRecipeInstruction(
      RecipeInstruction recipeInstruction) {
    this.recipeInstruction = recipeInstruction;
  }

  public List<RecipeCategory> getRecipeCategories() {
    return recipeCategories;
  }

  public void setRecipeCategories(List<RecipeCategory> recipeCategories) {
    if (recipeCategories == null){
      recipeCategories = new ArrayList<>();
    }
    this.recipeCategories = recipeCategories;
  }
  public boolean addRecipeCategory(RecipeCategory categoryList){
    if (categoryList == null) return false;
    if (recipeCategories.contains(categoryList)) return false;
    recipeCategories.add(categoryList);
    categoryList.getRecipe().add(this);
    return true;
  }

  public boolean deleteRecipeCategory(RecipeCategory category){
    if (category == null) return false;
    if (recipeCategories == null) return false;
    category.setRecipeCategoryName(null);
    return recipeCategories.remove(category);
  }
  public boolean addRecipeIngredient(RecipeIngredient recipeIngredient){
    if (recipeIngredient == null) return false;
    if (recipeIngredients.contains(recipeIngredient)) return false;
    recipeIngredients.add(recipeIngredient);
    recipeIngredient.setRecipe(this);
    return true;
  }
  public boolean deleteRecipeIngredient(RecipeIngredient recipeIngredient){
    if (recipeIngredient == null) return false;
    if (recipeIngredients == null) return false;
    recipeIngredient.setIngredient(null);
    return recipeIngredients.remove(recipeIngredient);
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