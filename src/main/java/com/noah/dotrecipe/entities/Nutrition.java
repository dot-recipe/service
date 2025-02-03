package com.noah.dotrecipe.entities;

import com.noah.dotrecipe.model.Unit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Nutrition {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @OneToOne
  private Ingredient ingredient;

  @Column(nullable = false)
  private Unit unit;

  @Column(nullable = false)
  private int calories;

  @Column(nullable = false)
  private int protein;

  @Column(nullable = false)
  private int carbs;

  @Column(nullable = false)
  private int fat;
}