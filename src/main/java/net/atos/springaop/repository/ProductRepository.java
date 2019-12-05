package net.atos.springaop.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {


    public  String getValue(){

        return "ProductRepository value = 1";
    }

}
