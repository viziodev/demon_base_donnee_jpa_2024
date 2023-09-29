package com.demon.services;

import java.util.ArrayList;

import com.demon.entities.Categorie;
import com.demon.repositories.ITables;


public class CategorieServiceImpl implements CategorieService {

    //Couplage fort
    private ITables<Categorie> categoriesRepository;
    public CategorieServiceImpl(ITables<Categorie> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public int add(Categorie categorie) {
       return categoriesRepository.insert(categorie);
    }

    @Override
    public ArrayList<Categorie> getAll() {
        // TODO Auto-generated method stub
        return categoriesRepository.findAll();
    }

    @Override
    public int update(Categorie categorie) {
         return categoriesRepository.update(categorie);
       
    }

    @Override
    public Categorie show(int id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public int remove(int id) {
       return categoriesRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
          for (int id = 0; id < ids.length; id++) {
              if (categoriesRepository.delete(id)==0) {
                idsNotDelete[nbre++]=id;

              }
          }
          return idsNotDelete;
    }
    
}
