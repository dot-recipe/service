package com.noah.dotrecipe.repository;

import com.noah.dotrecipe.entities.Recipe;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

  @NonNull
  Optional<Recipe> findById(@NonNull UUID id);
}
