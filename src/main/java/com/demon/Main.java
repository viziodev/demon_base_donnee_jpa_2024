package com.demon;

import java.util.Scanner;

import com.demon.entities.Categorie;
import com.demon.repositories.ITables;
import com.demon.repositories.bd.CategorieRepository;
import com.demon.repositories.bd.DataBase;
import com.demon.repositories.bd.Mysql;
import com.demon.services.CategorieService;
import com.demon.services.CategorieServiceImpl;

public class Main {
    private static  Scanner scanner =new Scanner(System.in);
    private static DataBase dataBase=new Mysql();
    private static ITables<Categorie> categorieRepository=new CategorieRepository(dataBase);
    private static CategorieService categorieServiceImpl=new CategorieServiceImpl(categorieRepository);
    public static void main(String[] args) throws Exception {
           menu();   
    }

    public static void menu(){
        int choix ;
      
        do {
            try {
                 System.out.println("Entrer une Valeurs"); 
                 choix=  scanner.nextInt();
               scanner.nextLine();
               switch (choix) {
                case 1:
                System.out.println("Entrer un Libelle");
                Categorie categorie =new Categorie();
                categorie.setLibelle(scanner.nextLine());
                categorieServiceImpl.add(categorie) ;
                    break;
               case 2:
                   categorieServiceImpl.getAll().forEach(System.out::println);
                default:
                    break;
             }
            } catch (Exception e) {
                throw new RuntimeException("Veuillez entrer un nombre");
            }
            
   
        } while (choix!=6);
    }
}