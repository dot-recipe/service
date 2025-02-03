package com.noah.dotrecipe.exceptions.ingredient;

import com.noah.dotrecipe.exceptions.DuplicateException;

public class IngredientNotFoundException extends DuplicateException {

  public IngredientNotFoundException() {
    super();
  }

  public IngredientNotFoundException(String message) {
    super(message);
  }

  public IngredientNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public IngredientNotFoundException(Throwable cause) {
    super(cause);
  }
}
