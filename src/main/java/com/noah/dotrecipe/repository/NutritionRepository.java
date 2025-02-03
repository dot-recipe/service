package com.noah.dotrecipe.repository;

import com.noah.dotrecipe.entities.Nutrition;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutritionRepository extends JpaRepository<Nutrition, UUID> {

  Optional<Nutrition> findByIngredientId(UUID ingredientId);
}