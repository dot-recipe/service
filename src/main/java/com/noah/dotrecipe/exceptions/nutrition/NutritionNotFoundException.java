package com.noah.dotrecipe.exceptions.nutrition;

import com.noah.dotrecipe.exceptions.NotFoundException;

public class NutritionNotFoundException extends NotFoundException {

  public NutritionNotFoundException() {
    super();
  }

  public NutritionNotFoundException(String message) {
    super(message);
  }

  public NutritionNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public NutritionNotFoundException(Throwable cause) {
    super(cause);
  }
}