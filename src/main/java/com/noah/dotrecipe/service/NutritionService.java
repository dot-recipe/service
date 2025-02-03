package com.noah.dotrecipe.service;

import com.noah.dotrecipe.entities.Nutrition;
import com.noah.dotrecipe.exceptions.nutrition.NutritionNotFoundException;
import com.noah.dotrecipe.repository.NutritionRepository;
import jakarta.transaction.Transactional;
import java.text.MessageFormat;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NutritionService {

  private final NutritionRepository nutritionRepository;

  @Transactional
  public Nutrition getNutritionByIngredientId(UUID ingredientId) {
    return nutritionRepository.findByIngredientId(ingredientId)
        .orElseThrow(() -> new NutritionNotFoundException(
            MessageFormat.format("Could not retrieve nutrition from the ingredientId: {0}", ingredientId)
        ));
  }
}