package com.noah.dotrecipe;

import org.springframework.boot.SpringApplication;

public class TestDotRecipeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.from(DotRecipeServiceApplication::main)
        .with(TestcontainersConfiguration.class).run(args);
  }

}
