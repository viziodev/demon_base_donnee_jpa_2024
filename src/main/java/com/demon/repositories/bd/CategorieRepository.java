package com.demon.repositories.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.demon.entities.Categorie;
import com.demon.repositories.ITables;

public class CategorieRepository implements ITables<Categorie>  {
   private final String SQLINSERT="INSERT INTO `categories` (`libelle`) VALUES (?)";
   private final String SQLALL="select * from categories ";
   private DataBase dataBase;
 

    public CategorieRepository(DataBase dataBase) {
      this.dataBase = dataBase;
      dataBase.connection();

   }

    @Override
    public int insert(Categorie data) {
          int id=0;
                  try {
                      dataBase.getPs().setString(1, data.getLibelle());
                      id= dataBase.executeUpdate(SQLINSERT);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            return id; 
    }

    @Override
    public int update(Categorie data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<Categorie> findAll() {
        ArrayList<Categorie> cateList=new ArrayList<>();
           try  {
            ResultSet res = dataBase.executeSelect(SQLALL);
               while(res.next()){
                Categorie categorie=new Categorie(res.getInt("id"),res.getString("libelle"));
               cateList.add(categorie);
              }
            } catch (SQLException e) {
          
            e.printStackTrace();
          }
            return cateList;
    
    }

    @Override
    public Categorie findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int indexOf(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }
    
}
