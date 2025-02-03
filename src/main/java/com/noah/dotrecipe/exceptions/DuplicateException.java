package com.noah.dotrecipe.exceptions;

public class DuplicateException extends RuntimeException {

  // Default constructor
  public DuplicateException() {
    super();
  }

  // Constructor with a custom message
  public DuplicateException(String message) {
    super(message);
  }

  // Constructor with a custom message and a cause
  public DuplicateException(String message, Throwable cause) {
    super(message, cause);
  }

  // Constructor with just a cause
  public DuplicateException(Throwable cause) {
    super(cause);
  }

}
