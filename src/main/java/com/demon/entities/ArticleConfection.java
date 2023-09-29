package com.demon.entities;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticleConfection extends AbstractEntity {
   
    private double prix;
    private double qte;

    //Attributs Navigationnels
    //@ManyToOne
      Categorie categorie;
      //@ManyToMany
      //Couplage Fort
       ArrayList <Unite> unites =new ArrayList<>();

  

    public void addUnite(Unite unite){
         unites.add(unite);
     }
  
    public ArrayList<Unite> getUnites() {
        return unites;
    }

    
}
