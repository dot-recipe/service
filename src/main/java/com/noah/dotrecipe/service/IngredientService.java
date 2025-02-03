package com.noah.dotrecipe.service;

import com.noah.dotrecipe.entities.Ingredient;
import com.noah.dotrecipe.entities.Recipe;
import com.noah.dotrecipe.exceptions.ingredient.IngredientNotFoundException;
import com.noah.dotrecipe.repository.IngredientRepository;
import jakarta.transaction.Transactional;
import java.text.MessageFormat;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientService {
  
  private final IngredientRepository ingredientRepository;
  private final NutritionService nutritionService;
  
  @Transactional
  public List<Ingredient> getIngredientsByRecipeId(UUID recipeId) {
    return ingredientRepository.findByRecipe_Id(recipeId)
        .orElseThrow(() -> new IngredientNotFoundException(
            MessageFormat.format(
                "Could not retrieve ingredients from the recipeId: {0}", recipeId)
        ));
  }
  
  @Transactional
  public Ingredient createIngredient(Ingredient ingredient) {
    if (ingredient.getNutrition() == null) {
      throw new IllegalArgumentException("Nutrition can't be null");
    }
    nutritionService.createNutrition(ingredient.getNutrition());
    return ingredientRepository.save(ingredient);
  }
  
  @Transactional
  public Ingredient updateIngredient(Ingredient ingredient) {
    ingredientRepository.findById(ingredient.getId())
        .orElseThrow(() -> new IngredientNotFoundException(
            MessageFormat.format(
                "Could not retrieve ingredient from the ingredientId: {0}", 
                ingredient.getId())
        ));
    if (ingredient.getNutrition() == null) {
      throw new IllegalArgumentException("Nutrition can't be null");
    }
    nutritionService.updateNutrition(ingredient.getNutrition());
    return ingredientRepository.save(ingredient);
  }
  
  @Transactional
  public void deleteIngredient(UUID ingredientId) {
    if (ingredientId == null) {
      throw new IllegalArgumentException("Ingredient ID can't be null");
    }
    ingredientRepository.deleteById(ingredientId);
  }
}
