package ECCutb.OmarAli.jpa_Assignment.Entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int ingredientId;
  @Column(unique = true)
  private String name;

  public Ingredient(int ingredientId, String name) {
    this.ingredientId = ingredientId;
    this.name = name;
  }
  public Ingredient(String name) {
    this(0, name);
  }
  public Ingredient(){}

  public int getIngredientId() {
    return ingredientId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ingredient that = (Ingredient) o;
    return ingredientId == that.ingredientId &&
        Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ingredientId, name);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Ingredient{");
    sb.append("ingredientId=").append(ingredientId);
    sb.append(", name='").append(name).append('\'');
    sb.append('}');
    return sb.toString();
  }
}