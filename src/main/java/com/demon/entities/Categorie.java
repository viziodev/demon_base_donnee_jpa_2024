package com.demon.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Categorie extends AbstractEntity {
   public Categorie(int id,String libelle){
    super(id,libelle);
  }
}
