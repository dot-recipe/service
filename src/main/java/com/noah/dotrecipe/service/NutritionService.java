package com.noah.dotrecipe.service;

import com.noah.dotrecipe.entities.Nutrition;
import com.noah.dotrecipe.exceptions.nutrition.NutritionDuplicateException;
import com.noah.dotrecipe.exceptions.nutrition.NutritionNotFoundException;
import com.noah.dotrecipe.repository.NutritionRepository;
import jakarta.transaction.Transactional;
import java.text.MessageFormat;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NutritionService {

  private final NutritionRepository nutritionRepository;
  
  @Transactional
  public Nutrition getNutritionById(UUID nutritionId) {
    return nutritionRepository.findById(nutritionId)
        .orElseThrow(() -> new NutritionNotFoundException(
            MessageFormat.format(
                "Could not retrieve nutrition from the nutritionId: {0}", nutritionId)
        ));
  }
  
  @Transactional
  public Nutrition getNutritionByIngredientId(UUID ingredientId) {
    return nutritionRepository.findByIngredientId(ingredientId)
        .orElseThrow(() -> new NutritionNotFoundException(
            MessageFormat.format(
                "Could not retrieve nutrition from the ingredientId: {0}", ingredientId)
        ));
  }
  
  @Transactional
  public Nutrition createNutrition(Nutrition nutrition) {
    Optional<Nutrition> existingNutrition = 
        nutritionRepository.findById(nutrition.getId());

    if (existingNutrition.isPresent() && !existingNutrition.get().getId().equals(nutrition.getId())) {
      throw new NutritionDuplicateException(
          MessageFormat.format(
              "Nutrition already exists with the nutritionId: {0}", nutrition.getId())
      );
    }
    return nutritionRepository.save(nutrition);
  }
  
  @Transactional
  public Nutrition updateNutrition(Nutrition nutrition) {
    nutritionRepository.findById(nutrition.getId())
        .orElseThrow(() -> new NutritionNotFoundException(
            MessageFormat.format("Could not retrieve nutrition from the nutritionId: {0}", nutrition.getId())
        ));
    return nutritionRepository.save(nutrition);
  }
  
  @Transactional
  public void deleteNutrition(UUID nutritionId) {
    if (nutritionId == null) {
      throw new IllegalArgumentException("Nutrition ID can't be null");
    }
    nutritionRepository.deleteById(nutritionId);
  }
}