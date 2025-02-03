package com.noah.dotrecipe.repository;

import com.noah.dotrecipe.entities.Ingredient;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {
  
  @NonNull
  Optional<Ingredient> findById(@NonNull UUID ingredientId);

  Optional<List<Ingredient>> findByRecipe_Id(UUID recipeId);
}
