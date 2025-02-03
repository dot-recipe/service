package com.noah.dotrecipe.exceptions.nutrition;

import com.noah.dotrecipe.exceptions.DuplicateException;

public class NutritionDuplicateException extends DuplicateException {
  
  public NutritionDuplicateException() {
    super();
  }

  public NutritionDuplicateException(String message) {
    super(message);
  }

  public NutritionDuplicateException(String message, Throwable cause) {
    super(message, cause);
  }

  public NutritionDuplicateException(Throwable cause) {
    super(cause);
  }
}
